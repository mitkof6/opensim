// testConstraints.cpp
// Author:  Samuel Hamner, Ajay Seth
/*
* Copyright (c)  2009, Stanford University. All rights reserved. 
* Use of the OpenSim software in source form is permitted provided that the following
* conditions are met:
* 	1. The software is used only for non-commercial research and education. It may not
*     be used in relation to any commercial activity.
* 	2. The software is not distributed or redistributed.  Software distribution is allowed 
*     only through https://simtk.org/home/opensim.
* 	3. Use of the OpenSim software or derivatives must be acknowledged in all publications,
*      presentations, or documents describing work in which OpenSim or derivatives are used.
* 	4. Credits to developers may not be removed from executables
*     created from modifications of the source.
* 	5. Modifications of source code must retain the above copyright notice, this list of
*     conditions and the following disclaimer. 
* 
*  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
*  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
*  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
*  SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
*  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
*  TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
*  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
*  OR BUSINESS INTERRUPTION) OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
*  WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

//==========================================================================================================
//	testConstraints builds OpenSim models using the OpenSim API and builds an equivalent
//  Simbody system using the Simbody API for each test case. A test fails if the
//  OpenSim and Simbody final states of the simulation are not equivelent (norm-err
//  less than 10x integration error tolerance)
//
//	Tests Include:
//		1. Test locking (constraint) mechansim on coordinates
//      2. PointOnLineConstraint against Simbody built-in PointOnLine constraint
//     Add tests here as new constraint types are added to OpenSim
//
//==========================================================================================================
#include <iostream>
#include <OpenSim/Common/IO.h>
#include <OpenSim/Common/Exception.h>
#include <OpenSim/Simulation/Model/AnalysisSet.h>
#include <OpenSim/Simulation/Model/BodySet.h>
#include <OpenSim/Simulation/Manager/Manager.h>
#include <OpenSim/Analyses/Kinematics.h>
#include <OpenSim/Analyses/PointKinematics.h>
#include <OpenSim/Simulation/Model/Model.h>

#include <OpenSim/Simulation/SimbodyEngine/FreeJoint.h>
#include <OpenSim/Simulation/SimbodyEngine/PinJoint.h>
#include <OpenSim/Simulation/SimbodyEngine/CustomJoint.h>
#include <OpenSim/Simulation/SimbodyEngine/SpatialTransform.h>
#include <OpenSim/Simulation/SimbodyEngine/TransformAxis.h>
#include <OpenSim/Simulation/SimbodyEngine/PointOnLineConstraint.h>
#include <OpenSim/Simulation/SimbodyEngine/CoordinateCouplerConstraint.h>

#include <OpenSim/Common/LoadOpenSimLibrary.h>
#include <OpenSim/Common/LinearFunction.h>
#include <OpenSim/Common/FunctionAdapter.h>
#include <OpenSim/Common/NaturalCubicSpline.h>
#include <OpenSim/Common/FunctionAdapter.h>
#include "SimTKsimbody.h"

using namespace OpenSim;
using namespace SimTK;
using namespace std;

//==========================================================================================================
// Common Parameters for the simulations are just global.
const static double integ_accuracy = 1.0e-5;
const static double duration = 1.00;
const static Vec3 gravity_vec = Vec3(0, -9.8065, 0);

//Thigh
const static double femurMass = 8.806;
const static Vec3 femurCOM(0, 0.5, 0);
const static Inertia femurInertiaAboutCOM(Vec3(0.1268, 0.0332, 0.1337));
//Shank
const static MassProperties tibiaMass(3.510, Vec3(0), Inertia(Vec3(0.0477, 0.0048, 0.0484)));
//Foot
const static MassProperties footMass(1.20, Vec3(0), Inertia(Vec3(0.001361, 0.003709, 0.003916)));
//Toes
const static MassProperties toesMass(0.205126, Vec3(0), Inertia(Vec3(0.000117, 0.000179, 0.000119)));

// Joint locations
const static Vec3 hipInGround(0);
const static Vec3 hipInFemur(0.0020, 0.1715, 0);
const static Vec3 kneeInFemur(0.0033, -0.2294, 0);
const static Vec3 kneeInTibia(0.0, 0.1862, 0.0);
const Vec3 ankleInTibia(0.0, -0.243800, 0);
const Vec3 ankleInFoot(-0.035902, 0.051347, 0);
const Vec3 mtpInFoot(0.098032, -0.038000, 0);
const Vec3 mtpInToes(-0.035902, 0.051347, 0);
//==========================================================================================================

class MultidimensionalFunction : public OpenSim::Function
{
public:
	MultidimensionalFunction() {};

	virtual ~MultidimensionalFunction() {};

	virtual Object* copy() const { return new MultidimensionalFunction; }

	virtual double calcValue(const SimTK::Vector& x) const
	{
		return 2*x[0]*x[0] + x[1];
	}
	virtual double calcDerivative(const std::vector<int>& derivComponents, const SimTK::Vector& x) const
	{
	   int nd = derivComponents.size();
	   if (nd < 1)
		   return SimTK::NaN;
	
	   if (derivComponents[0] == 0){
			if (nd == 1)
				return 4*x[0];
			else if(derivComponents[0] == 0)
				return 4;
	   }
	   else if (derivComponents[0] == 1){
		   if (nd == 1)
			   return 1;
	   }
	   return 0;
	}

	virtual int getArgumentSize() const {return 2;}
	virtual int getMaxDerivativeOrder() const { return 2;}

	virtual SimTK::Function* createSimTKFunction() const
	{
		return new FunctionAdapter(*this);
	}
}; // End of MultidimensionalFunction



//==========================================================================================================
// Common Functions 
//==========================================================================================================
int initTestStates(Vector &qi, Vector &ui)
{
	Random::Uniform randomAngle(-Pi/4, Pi/4);
	Random::Uniform randomSpeed(-1.0, 1.0);

	// Provide initial states as random angles and speeds for OpenSim and Simbody models
	for(int i = 0; i<qi.size(); i++)
		qi[i] = randomAngle.getValue();

	for(int i = 0; i<ui.size(); i++)
		ui[i] = randomSpeed.getValue();
    
	return qi.size();
}

void integrateSimbodySystem(MultibodySystem &system, SimTK::State &state)
{
	// realize simbody system to velocity stage
	system.realize(state, Stage::Velocity);

	RungeKuttaMersonIntegrator integ(system);
	integ.setAccuracy(integ_accuracy);
	integ.setAbsoluteTolerance(integ_accuracy);
	
    TimeStepper ts(system, integ);
    ts.initialize(state);
	ts.stepTo(duration);
	state = ts.getState();
}

void integrateOpenSimModel(Model *osimModel, SimTK::State &osim_state)
{
	// SETUP OpenSim SIMULATION Manager
	osimModel->getSystem().realize(osim_state, Stage::Velocity);
    RungeKuttaMersonIntegrator integrator(osimModel->getSystem() );
	integrator.setAccuracy(integ_accuracy);
	integrator.setAbsoluteTolerance(integ_accuracy);
    Manager manager(*osimModel,  integrator);

	// Specify the initial and final times of the simulation.
	// In this case, the initial and final times are set based on
	// the range of times over which the controls are available.
	//Control *control;
	manager.setInitialTime(0.0);
	manager.setFinalTime(duration);

	// Integrate
    const SimbodyMatterSubsystem& matter2 = osimModel->getMultibodySystem().getMatterSubsystem();
 //   for (int i = 0; i < matter2.getNumConstraints(); i++)
 //       printf("%d: %d\n", i, matter2.isConstraintDisabled(osim_state, SimTK::ConstraintIndex(i)));
 //   cout << osim_state.getQ()<<endl;
	//cout << "\n\nOpenSim Integration 0.0 to " << duration << endl;

	manager.integrate(osim_state);
}

bool compareSimulationStates(Vector q_sb, Vector u_sb, Vector q_osim, Vector u_osim)
{
    bool status = true;
	
	Vector q_err = q_sb;
	Vector u_err = u_sb;

	int nq = q_osim.size();
	if(q_sb.size() > nq){ // we have an unused quaternion slot in Simbody

		q_sb.dump("Simbody q's:");
		q_osim.dump("OpenSim q's:");
		//This is a hack knowing the free and ball joint tests have the quaternion joint first
		// And that the q's are packed as qqqq or aaa* for a ball and qqqqxyz or aaaxyz* for a free joint
		int quat_ind = ((nq > 6) ? 6 : 3);
		int j = 0;
		for(int i=0; i< q_sb.size(); i++){
			if(i != quat_ind){
				q_err[j] = q_sb[i] - q_osim[j];
				j++;
			}
		}
	}
	else{
		if(nq > q_sb.size()){ // OpenSim using constrains
			q_err[0] = q_sb[0] - q_osim[0];
			q_err[1] = q_sb[1] - q_osim[1];
			u_err[0] = u_sb[0] - u_osim[0];
			u_err[1] = u_sb[1] - u_osim[1];
		}
		else{
			q_err = q_sb - q_osim;
			u_err = u_sb - u_osim;
		}
	}

	//cout<<"\nSimbody - OpenSim:"<<endl;
	//q_err.dump("Diff q's:");
	//u_err.dump("Diff u's:");

	if(q_err.norm() > 10*integ_accuracy) {
         cout<<"testJoints compareSimulationStates failed q_err.norm = "<< q_err.norm() << endl;
         status = false;
     }
	if(u_err.norm() > 10*integ_accuracy) {
         cout<<"testJoints compareSimulationStates failed u_err.norm = "<< u_err.norm() << endl;
         status = false;
    }

    return(status);
}

bool compareSimulations(MultibodySystem &system, SimTK::State &state, Model *osimModel, SimTK::State &osim_state)
{
	// Set the initial states for both Simbody system and OpenSim model
	Vector& qi = state.updQ();
	Vector& ui = state.updU();
	int nq_sb = initTestStates(qi, ui);
	int nq = osim_state.getNQ();

	// Push down to OpenSim "state"
	if(system.getMatterSubsystem().getUseEulerAngles(state)){
		const Vector& y = state.getY();
		Vector y_osim(2*nq, 0.0);
		//This is a hack knowing the ball and free joint tests have the joint being tested, first.
		int quat_ind = ((nq > 6) ? 6 : 3);
		int j = 0;
		for(int i=0; i< state.getNY(); i++){
			if(i != quat_ind)
				y_osim[j++] = y[i];
		}
		osim_state.updY() = y_osim;

		y_osim.dump("osim:");
		y.dump("simbody:");
	}
	else{
		if(nq == 2*nq_sb){ //more coordinates because OpenSim model is constrained
			osim_state.updY()[0] = state.getY()[0];
			osim_state.updY()[1] = state.getY()[1];
			osim_state.updY()[nq] = state.getY()[nq_sb];
			osim_state.updY()[nq+1] = state.getY()[nq_sb+1];
		}
		else	
			osim_state.updY() = state.getY();
	}

	//==========================================================================================================
	// Integrate Simbody system
	integrateSimbodySystem(system, state);

	// Simbody model final states
	qi = state.updQ();
	ui = state.updU();

	//qi.dump("\nSimbody Final q's:");
	//ui.dump("\nSimbody Final u's:");

	//==========================================================================================================
	// Integrate OpenSim model
	integrateOpenSimModel(osimModel, osim_state);

	// Get the state at the end of the integration from OpenSim.
	Vector& qf = osim_state.updQ();
	Vector& uf = osim_state.updU();
	//cout<<"\nOpenSim Final q's:\n "<<qf<<endl;
	//cout<<"\nOpenSim Final u's:\n "<<uf<<endl;

	//==========================================================================================================
	// Compare Simulation Results
	return( compareSimulationStates(qi, ui, qf, uf) );
}
//==========================================================================================================

//==========================================================================================================
// Test Cases
//==========================================================================================================
bool testCoordinateLocking()
{
	double fixedKneeAngle = SimTK::Pi/2;
	bool status = true;

	// Setup OpenSim model
	Model *osimModel = new Model;
	//OpenSim bodies
    OpenSim::Body& ground = osimModel->getGroundBody();

	//OpenSim thigh
	OpenSim::Body osim_thigh("thigh", femurMass, femurCOM, femurInertiaAboutCOM);

	// create hip as a pin joint
	PinJoint hip("",ground, hipInGround, Vec3(0), osim_thigh, hipInFemur, Vec3(0));

	// Rename hip coordinates for a pin joint
	hip.getCoordinateSet()[0].setName("hip_flex");
	
	// Add the thigh body which now also contains the hip joint to the model
	osimModel->addBody(&osim_thigh);

	// Add OpenSim shank via a knee joint
	OpenSim::Body osim_shank("shank", tibiaMass.getMass(), tibiaMass.getMassCenter(), tibiaMass.getInertia());

	// create pin knee joint
	PinJoint knee("",osim_thigh, kneeInFemur, Vec3(0), osim_shank, Vec3(0), Vec3(0));
	knee.getCoordinateSet()[0].setName("knee_q");

	// Add the shank body which now also contains the knee joint to the model
	osimModel->addBody(&osim_shank);

	// BAD: have to set memoryOwner to false or program will crash when this test is complete.
	osimModel->updBodySet().setMemoryOwner(false);

	osimModel->setGravity(gravity_vec);

	// Initialize the state of the model based on the defaults of ModelComponents.
	SimTK::State si = osimModel->initSystem();

	// Model joint states
	CoordinateSet &coordinates = osimModel->updCoordinateSet();
	coordinates[0].setValue(si, 0);
	coordinates[0].setSpeedValue(si, 1.0);
	coordinates[1].setValue(si, fixedKneeAngle);
	coordinates[1].setLocked(si, true);  // lock the knee

	// Test that serialization and deserialization of locking works
	osimModel->print("testLockingModel.osim");
	// Model and all its contents are wiped out
	delete osimModel;
	// Reload the model
	osimModel = new Model("testLockingModel.osim");

	// Re-initialize the state of the model based on now saved defaults of the model.
	si = osimModel->initSystem();

	osimModel->getSystem().realize(si, Stage::Velocity );
 
	// Create the integrator and manager for the simulation.
	SimTK::RungeKuttaMersonIntegrator integrator(osimModel->getSystem());
	integrator.setMaximumStepSize(1.0e-3);
	integrator.setMinimumStepSize(1.0e-6);
	integrator.setAccuracy(integ_accuracy);
	integrator.setAbsoluteTolerance(integ_accuracy);
	Manager manager(*osimModel,  integrator);

	// Print out the initial position and velocity states
	si.getQ().dump("Initial q's"); // pendulum positions
	si.getU().dump("Initial u's"); // pendulum velocities
	Vector qi = si.getQ();

	// Integrate from initial time to final time
	manager.setInitialTime(0.0);
	manager.setFinalTime(duration);
	std::cout<<"\n\nIntegrating from "<<manager.getInitialTime()<<" to "<<manager.getFinalTime()<<std::endl;
	manager.integrate(si);

	// Print out the final position and velocity states
	Vector qf = si.getQ();
	qf.dump("Final q's"); // pendulum positions
	si.getU().dump("Final u's"); // pendulum velocities

	if (fabs(qf[1]-fixedKneeAngle) > integ_accuracy){
		cout<<"testCoordinateLocking: q_err = "<< qf[1]-qi[1] << endl;
         status = false;
     }

	return status;
}


bool testPointOnLineConstraint()
{
	cout << endl;
	cout << "==================================================================" << endl;
	cout << " OpenSim PointOnLineConstraint vs. Simbody Constraint::PointOnLine " << endl;
	cout << "==================================================================" << endl;

	Random::Uniform randomDirection(-1, 1);
	Vec3 lineDirection(randomDirection.getValue(), randomDirection.getValue(), randomDirection.getValue());
	SimTK::UnitVec3 normLineDirection(lineDirection.normalize());
	Vec3 pointOnLine(0,0,0);
	Vec3 pointOnFollower(0,0,0);

	// Define the Simbody system
    MultibodySystem system;
    SimbodyMatterSubsystem matter(system);
    GeneralForceSubsystem forces(system);
	SimTK::Force::UniformGravity gravity(forces, matter, gravity_vec);

	// Create a free joint between the foot and ground
	MobilizedBody::Free foot(matter.Ground(), SimTK::Transform(Vec3(0)), 
		SimTK::Body::Rigid(footMass), SimTK::Transform(Vec3(0)));
	
	// Constrain foot to line on ground
	SimTK::Constraint::PointOnLine simtkPointOnLine(matter.Ground(), normLineDirection, pointOnLine, foot, pointOnFollower);

	// Simbody model state setup
	system.realizeTopology();
	State state = system.getDefaultState();
	matter.setUseEulerAngles(state, false);
    system.realizeModel(state);

	//==========================================================================================================
	// Setup OpenSim model
	Model *osimModel = new Model;
	//OpenSim bodies
    OpenSim::Body& ground = osimModel->getGroundBody();

	//OpenSim foot
	OpenSim::Body osim_foot("foot", footMass.getMass(), footMass.getMassCenter(), footMass.getInertia());

	// create foot as a free joint
	bool useEulerAngles = false;  // set useEulerAngles to True
	FreeJoint footJoint("", ground, Vec3(0), Vec3(0), osim_foot, Vec3(0), Vec3(0), useEulerAngles);
	
	// Add the thigh body which now also contains the hip joint to the model
	osimModel->updBodySet().append(&osim_foot);

	// add a point on line constraint
	PointOnLineConstraint lineConstraint(ground, normLineDirection, pointOnLine, osim_foot, pointOnFollower);
	osimModel->updConstraintSet().append(&lineConstraint);

	// BAD: have to set memoryOwner to false or program will crash when this test is complete.
	osimModel->updBodySet().setMemoryOwner(false);

	osimModel->setGravity(gravity_vec);

    //Add analyses before setting up the model for simulation
	Kinematics *kinAnalysis = new Kinematics(osimModel);
	kinAnalysis->setInDegrees(false);
	osimModel->addAnalysis(kinAnalysis);

	// Need to setup model before adding an analysis since it creates the AnalysisSet
	// for the model if it does not exist.
	SimTK::State osim_state = osimModel->initSystem();

	//==========================================================================================================
	// Compare Simbody system and OpenSim model simulations
	return (compareSimulations(system, state, osimModel, osim_state));
} // end testPointOnLineConstraint


bool testCoordinateCouplerConstraint()
{
	cout << endl;
	cout << "=================================================================" << endl;
	cout << " OpenSim CoordinateCouplerConstraint vs. FunctionBasedMobilizer  " << endl;
	cout << "=================================================================" << endl;

	// Define spline data for the custom knee joint
	int npx = 12;
	double angX[] = {-2.094395102393, -1.745329251994, -1.396263401595, -1.047197551197, -0.698131700798, -0.349065850399, -0.174532925199, 0.197344221443, 0.337394955864, 0.490177570472, 1.521460267071, 2.094395102393};
	double kneeX[] = {-0.003200000000, 0.001790000000, 0.004110000000, 0.004100000000, 0.002120000000, -0.001000000000, -0.003100000000, -0.005227000000, -0.005435000000, -0.005574000000, -0.005435000000, -0.005250000000};
	int npy = 7;
	double angY[] = {-2.094395102393, -1.221730476396, -0.523598775598, -0.349065850399, -0.174532925199, 0.159148563428, 2.094395102393};
	double kneeY[] = {-0.422600000000, -0.408200000000, -0.399000000000, -0.397600000000, -0.396600000000, -0.395264000000, -0.396000000000 };


	for(int i = 0; i<npy; i++) {
		// Spline data points from experiment w.r.t. hip location. Change to make it w.r.t knee location
		kneeY[i] += (-kneeInFemur[1]+hipInFemur[1]); 
	}

	NaturalCubicSpline tx(npx, angX, kneeX);
	NaturalCubicSpline ty(npy, angY, kneeY);;

	// Define the functions that specify the FunctionBased Mobilized Body.
	std::vector<std::vector<int> > coordIndices;
	std::vector<const SimTK::Function*> functions;
	std::vector<bool> isdof(6,false);

	// Set the 1 spatial rotation about Z-axis
	isdof[2] = true;  //rot Z
	int nm = 0;
	for(int i=0; i<6; i++){
		if(isdof[i]) {
			Vector coeff(2);
			coeff[0] = 1;
			coeff[1] = 0;
			std::vector<int> findex(1);
			findex[0] = nm++;
			functions.push_back(new SimTK::Function::Linear(coeff));
			coordIndices.push_back(findex);
		}
		else if(i==3 || i ==4){
			std::vector<int> findex(1,0);
			if(i==3)
				functions.push_back(tx.createSimTKFunction());
			else
				functions.push_back(ty.createSimTKFunction());

			coordIndices.push_back(findex);	
		}
		else{
			std::vector<int> findex(0);
			functions.push_back(new SimTK::Function::Constant(0, 0));
			coordIndices.push_back(findex);
		}
	}

	// Define the Simbody system
    MultibodySystem system;
    SimbodyMatterSubsystem matter(system);
    GeneralForceSubsystem forces(system);
	SimTK::Force::UniformGravity gravity(forces, matter, gravity_vec);
	//system.updDefaultSubsystem().addEventReporter(new VTKEventReporter(system, 0.01));

	// Thigh connected by hip
	MobilizedBody::Pin thigh(matter.Ground(), SimTK::Transform(hipInGround), 
		SimTK::Body::Rigid(MassProperties(femurMass, femurCOM, femurInertiaAboutCOM.shiftFromMassCenter(femurCOM, femurMass))), SimTK::Transform(hipInFemur));
	//Function-based knee connects shank
	MobilizedBody::FunctionBased shank(thigh, SimTK::Transform(kneeInFemur), SimTK::Body::Rigid(tibiaMass), SimTK::Transform(kneeInTibia), nm, functions, coordIndices);
	//MobilizedBody::Pin shank(thigh, SimTK::Transform(kneeInFemur), SimTK::Body::Rigid(tibiaMass), SimTK::Transform(kneeInTibia));

	// Simbody model state setup
	system.realizeTopology();
	State state = system.getDefaultState();
	matter.setUseEulerAngles(state, false);
    system.realizeModel(state);

	//==========================================================================================================
	// Setup OpenSim model
	Model *osimModel = new Model;
	//OpenSim bodies
    OpenSim::Body& ground = osimModel->getGroundBody();
	
	OpenSim::Body osim_thigh("thigh", femurMass, femurCOM, femurInertiaAboutCOM);
	//OpenSim::Body osim_thigh;
	//osim_thigh.setName("thigh");

	// Define hip coordinates and axes for custom joint
	SpatialTransform hipTransform;
	hipTransform[2].setCoordinateNames(OpenSim::Array<std::string>("hip_q0", 1, 1));
	hipTransform[2].setFunction(new LinearFunction());

	// create custom hip joint
	CustomJoint hip("", ground, hipInGround, Vec3(0), osim_thigh, hipInFemur, Vec3(0), hipTransform);

	// Add the thigh body which now also contains the hip joint to the model
	osimModel->addBody(&osim_thigh);

	// Add another body via a knee joint
	OpenSim::Body osim_shank("shank", tibiaMass.getMass(), tibiaMass.getMassCenter(), tibiaMass.getInertia());

	// Define knee coordinates and axes for custom joint spatial transform
	SpatialTransform kneeTransform;
	string knee_q_name = "knee_q";
	string tx_name = "knee_tx";
	string ty_name = "knee_ty";

	Array<string> indepCoords(knee_q_name, 1, 1);

	//  knee flexion/extension
	kneeTransform[2].setCoordinateNames(indepCoords);
	kneeTransform[2].setFunction(new LinearFunction());
	// translation X
	kneeTransform[3].setCoordinateNames(OpenSim::Array<std::string>(tx_name, 1, 1));
	kneeTransform[3].setFunction(new LinearFunction());
	// translation Y
	kneeTransform[4].setCoordinateNames(OpenSim::Array<std::string>(ty_name, 1, 1));
	kneeTransform[4].setFunction(new LinearFunction());

	// create custom knee joint
	CustomJoint knee("", osim_thigh, kneeInFemur, Vec3(0), osim_shank, kneeInTibia, Vec3(0), kneeTransform);

	// Add the shank body which now also contains the knee joint to the model
	osimModel->addBody(&osim_shank);

	// Constrain the knee translations to follow the desired manifold
	CoordinateCouplerConstraint knee_tx_constraint;
	CoordinateCouplerConstraint knee_ty_constraint;

	knee_tx_constraint.setIndependentCoordinateNames(indepCoords);
	knee_ty_constraint.setIndependentCoordinateNames(indepCoords);

	knee_tx_constraint.setDependentCoordinateName(tx_name);
	knee_ty_constraint.setDependentCoordinateName(ty_name);

	knee_tx_constraint.setFunction(tx);
	knee_ty_constraint.setFunction(ty);

	// Add the constraints
	osimModel->addConstraint(&knee_tx_constraint);
	osimModel->addConstraint(&knee_ty_constraint);

	//Add analyses before setting up the model for simulation
	Kinematics *kinAnalysis = new Kinematics(osimModel);
	kinAnalysis->setInDegrees(false);
	osimModel->addAnalysis(kinAnalysis);

	// OpenSim model must realize the topology to get valid osim_state
	osimModel->setGravity(gravity_vec);

	PointKinematics *pointKin = new PointKinematics(osimModel);
	// Get the point location of the shank origin in space
	pointKin->setBodyPoint("shank", Vec3(0));
	osimModel->addAnalysis(pointKin);

	// Model cannot own model components created on the stack in this test program
	osimModel->disownAllComponents();

	// write out the model to file
	osimModel->print("testCouplerConstraint.osim");

	//wipe-out the model just constructed
	delete osimModel;

	// reconstruct from the model file
	osimModel = new Model("testCouplerConstraint.osim");
	
	// Need to setup model before adding an analysis since it creates the AnalysisSet
	// for the model if it does not exist.
	SimTK::State osim_state = osimModel->initSystem();

	//==========================================================================================================
	// Compare Simbody system and OpenSim model simulations
	return( compareSimulations(system, state, osimModel, osim_state) );
}


int main()
{
    int  status = 0;

	if(  !testCoordinateLocking()) {
        status = 1;
        cout << " testCoordinateLocking FAILED " << endl;
    }	

	// Compare behavior of PointOnLineConstraint between the foot and ground 
	if(  !testPointOnLineConstraint()) {
        status = 1;
        cout << " testPointOnLineConstraint FAILED " << endl;
    }	

	
	// Compare behavior of CoordinateCouplerConstraint as a custom knee 
	if(  !testCoordinateCouplerConstraint()) {
        status = 1;
        cout << " testCoordinateCouplerConstraint FAILED " << endl;
    }	

	return status;
}
