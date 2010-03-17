// SimbodyEngine.cpp
// Authors: Frank C. Anderson, Ajay Seth
/*
 * Copyright (c)  2007, Stanford University. All rights reserved. 
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

//=============================================================================
// INCLUDES
//=============================================================================
#include <iostream>
#include <string>
#include <math.h>
#include <float.h>
#include <time.h>
#include <SimTKcommon/internal/Exception.h>
#include <OpenSim/Common/GCVSplineSet.h>
#include <OpenSim/Common/Storage.h>
#include <OpenSim/Common/LoadOpenSimLibrary.h>
#include <OpenSim/Simulation/Model/Model.h>
#include <OpenSim/Simulation/Model/MarkerSet.h>
#include <OpenSim/Simulation/Model/BodySet.h>
#include <SimTKsimbody.h>

#include "SimbodyEngine.h"
#include "Coordinate.h"


//=============================================================================
// STATICS
//=============================================================================
using namespace std;
using namespace OpenSim;
using namespace SimTK;

static std::string SimbodyGroundName = "ground";


//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Destructor.
 */
SimbodyEngine::~SimbodyEngine()
{
}
//_____________________________________________________________________________
/**
 * Default constructor.  This constructor constructs a dynamic model of a
 * simple pendulum.
 */
SimbodyEngine::SimbodyEngine() :
    Object()
{
	setNull();

	// CONSTRUCT SIMPLE PENDULUM
	//constructPendulum();
}

//_____________________________________________________________________________
/**
 * Constructor from an XML Document
 */
SimbodyEngine::SimbodyEngine(const string &aFileName) :
    Object(aFileName, false)
{
	setNull();
	setup(*_model);
}


//_____________________________________________________________________________
/**
 * Copy constructor.
 */
SimbodyEngine::SimbodyEngine(const SimbodyEngine& aEngine) :
    Object(aEngine)
{
	setNull();
	copyData(aEngine);
	setup(*_model);
}

//_____________________________________________________________________________
/**
 * Copy this engine and return a pointer to the copy.
 * The copy constructor for this class is used.
 *
 * @return Pointer to a copy of this SimbodyEngine.
 */
Object* SimbodyEngine::copy() const
{
	SimbodyEngine *object = new SimbodyEngine(*this);
	return object;
}

//=============================================================================
// CONSTRUCTION METHODS
//=============================================================================


//_____________________________________________________________________________
/**
 * Copy data members from one SimbodyEngine to another.
 *
 * @param aEngine SimbodyEngine to be copied.
 */
void SimbodyEngine::copyData(const SimbodyEngine &aEngine)
{
    _model = aEngine._model;
}

//_____________________________________________________________________________
/**
 * Set NULL values for all the variable members of this class.
 */
void SimbodyEngine::setNull()
{
	setType("SimbodyEngine");
    _model = NULL;
}
    
//_____________________________________________________________________________
/**
 * Create a ground body if necessary.
 */
void SimbodyEngine::
createGroundBodyIfNecessary()
{
	// See if the ground body already exists.
	// The ground body is assumed to have the name simbodyGroundName.
	int size = _model->getBodySet().getSize();
	if (size==0)	// Don't want to throw an exception for trivial models
		return;
	Body *ground=NULL;
	for(int i=0; i<size; i++) {
		Body& body = _model->getBodySet().get(i);
		if(body.getName() == SimbodyGroundName) {
			ground = &body;
			break;
		}
	}

	// If the ground body doesn't exist create it
	// and append it to the body set.
	if (ground==NULL){
		string msg = "Model has no ground body. Please rename base segment to 'ground' and retry.";
		throw Exception(msg,__FILE__,__LINE__);
	}
	/* Temporarily comment out pending a robust solution to models without ground
	if(ground==NULL) {
		ground = new Body();
		_bodySet.append(ground);
	}
    */
	// Set member variables
	ground->setName(SimbodyGroundName);
	// Mass
	ground->_mass = 0.0;
	// Mass center
	Vec3 massCenter(0.0);
	ground->_massCenter = massCenter;
	// Simbody id
	ground->_index = SimTK::GroundIndex;
	// Engine
	ground->_model = _model;
}


//_____________________________________________________________________________
/**
 * Perform some set up functions that happen after the
 * object has been deserialized or copied.
 *
 * @param aModel model containing this SimbodyEngine.
 */
void SimbodyEngine::setup(Model& aModel)
{
    _model = &aModel;
}

//_____________________________________________________________________________
/**
 * Go through the coordinate set and make sure the locking flags
 * and coordinate values are in the state
 *
 * @param s  current SimTK state 
 */
void SimbodyEngine::initializeState( SimTK::State& s ) 
{


	for(int i = 0; i<_model->getCoordinateSet().getSize(); i++){
		Coordinate& aCoord = _model->getCoordinateSet().get(i);
		aCoord.initState(s);

		// If a coordinate is locked, or prescribed it's initial velocity should be zero
		if(aCoord.getLocked(s))
			aCoord.setSpeedValue(s, 0.0);
		else
			aCoord.setSpeedValue(s, SimTK::NaN);
	}

/*
	for(int i = 0; i<_model->getConstraintSet().getSize(); i++){
		Constraint *aConstraint = _model->updConstraintSet().get(i);
		aConstraint->initializeState(s);
	}*/

	_model->applyDefaultConfiguration(s);
}


//=============================================================================
// OPERATORS
//=============================================================================
//_____________________________________________________________________________
/**
 * Assignment operator.
 *
 * @return Reference to this object.
 */
SimbodyEngine& SimbodyEngine::operator=(const SimbodyEngine &aEngine)
{
    // Base class
    Object::operator=(aEngine);
	copyData(aEngine);
	setup(*aEngine._model);
	return(*this);
}



//--------------------------------------------------------------------------
// COORDINATES
//--------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Update all coordinates in the model with the ones in the
 * passed-in coordinate set. If the coordinate does not exist
 * in the model, it is not added.
 *
 * @param aCoordinateSet set of coordinates to be updated/added
 */
void SimbodyEngine::updateCoordinateSet(CoordinateSet& aCoordinateSet)
{
	for (int i = 0; i < aCoordinateSet.getSize(); i++) {
        if (_model->updCoordinateSet().contains(aCoordinateSet.get(i).getName())) {
    		Coordinate& modelCoordinate = _model->updCoordinateSet().get(aCoordinateSet.get(i).getName());
			modelCoordinate.updateFromCoordinate(aCoordinateSet.get(i));
        }
	}

	cout << "Updated coordinates in model " << _model->getName() << endl;
}

//_____________________________________________________________________________
/**
 * Get the set of coordinates that are not locked
 *
 * @param rUnlockedCoordinates set of unlocked coordinates is returned here
 */
void SimbodyEngine::getUnlockedCoordinates(const SimTK::State &s, CoordinateSet& rUnlockedCoordinates) const
{
	rUnlockedCoordinates.setSize(0);
	rUnlockedCoordinates.setMemoryOwner(false);

	for (int i = 0; i < _model->getCoordinateSet().getSize(); i++)
		if (!_model->getCoordinateSet().get(i).getLocked(s))
			rUnlockedCoordinates.append(&_model->getCoordinateSet().get(i));
}

/**
 * Project (change) the current configuration such that it satisfies the constraints acting
 * on the system. This alters the configuration (state) down in Simbody and then returns
 * the projected configuration. This method is intended for corrections to the state during
 * integration and should be called after a successful integrations step.
 * It can also be called to pose the model (i.e. in coord->setValue() after )
 * so that the configuration satisfies the constraints but WARNING this may produce upredictable
 * results when the current configuration is far from satisfying the constraints.
 *
 * returns true iff the engine configuration (state) was changed by the projection
 * @param cTol constraint tolerance. (input)
 */
bool SimbodyEngine::projectConfigurationToSatisfyConstraints(SimTK::State& s, const double cTol) const 
{
	// Enforce all coordinate coupler constraints. This is needed because if the coordinate values
	// have changed a lot, MultibodySystem::project() will change the unconstrained
	// coordinate values as it searches for a pose that satisfies all of the constraints.
	// Once project() supports the locking of coordinates, this call will no longer be needed.
	getModel().enforceCoordinateCouplerConstraints(s);

	// REALIZE AT THE VELOCITY STAGE
	_model->getSystem().realize(s, Stage::Velocity);

	// Project configuration on to constraints to make sure we
	// are not violating locking and other constraints
	Vector weights; _model->getSystem().calcYUnitWeights(s, weights);
	Vector tols; _model->getSystem().calcYErrUnitTolerances(s, tols); 

	// Don't bother attempting to project constraints if there are none.
	if (_model->getMatterSubsystem().getNumConstraints() > 0){
		Vector yErrEst; // should send in Null vector if don't have any estimates 
		_model->getSystem().project(s, cTol, weights, tols, yErrEst, SimTK::System::ProjectOptions::All);
		//bool Qchanged = _system->updMatterSubsystem().projectQConstraints(_s, cTol, weights, tols,
		//												errEst, System::ProjectOptions::All);
		//
		//bool Uchanged =  _system->updMatterSubsystem().projectUConstraints(_s, cTol, Vector(ny, 1), Vector(nc, 1),
		//												errEst, System::ProjectOptions::All);
		return true;
	}
	return false;
}
//--------------------------------------------------------------------------
// BODY INFORMATION
//--------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the body that is being used as ground.
 *
 * @return Pointer to the ground body.
 */
OpenSim::Body& SimbodyEngine::getGroundBody() const
{
	return _model->getGroundBody();
}


//--------------------------------------------------------------------------
// INERTIA
//--------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the total mass of the model
 *
 * @return the mass of the model
 */
double SimbodyEngine::getMass() const
{
	double totalMass = 0.0;

	for (int i=0; i<_model->getBodySet().getSize(); i++)
		totalMass += _model->getBodySet().get(i).getMass();

	return totalMass;
}

//_____________________________________________________________________________
/**
 * getSystemInertia
 *
 * @param rM
 * @param rCOM
 * @param rI
 */
void SimbodyEngine::getSystemInertia(const SimTK::State& s, double& rM, Vec3& rCOM, double rI[3][3]) const
{
	rM = _model->getMatterSubsystem().calcSystemMass(s);
	rCOM = _model->getMatterSubsystem().calcSystemMassCenterLocationInGround(s);
	Mat33::updAs(&rI[0][0]) = _model->getMatterSubsystem().calcSystemCentralInertiaInGround(s).toMat33();
}

//_____________________________________________________________________________
/**
 * getSystemInertia
 *
 * @param rM
 * @param rCOM
 * @param rI
 */
void SimbodyEngine::getSystemInertia(const SimTK::State& s, double& rM, double *rCOM, double *rI) const
{
	rM                 = _model->getMatterSubsystem().calcSystemMass(s);
	Vec3::updAs(rCOM) = _model->getMatterSubsystem().calcSystemMassCenterLocationInGround(s);
	Mat33::updAs(rI)  = _model->getMatterSubsystem().calcSystemCentralInertiaInGround(s).toMat33();
}

//--------------------------------------------------------------------------
// KINEMATICS
//--------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the inertial position of a point on a body.
 *
 * Note that the configuration of the model must be set before calling this
 * method.
 *
 * @param aBody Pointer to body.
 * @param aPoint Point on the body expressed in the body-local frame.
 * @param rPos Position of the point in the inertial frame.
 */
void SimbodyEngine::getPosition(const SimTK::State& s, const OpenSim::Body &aBody, const Vec3& aPoint, Vec3& rPos) const
{
	const OpenSim::Body* b = (OpenSim::Body*)(&aBody);
	rPos = _model->getMatterSubsystem().getMobilizedBody(b->_index).findStationLocationInGround(s, aPoint);
}

//_____________________________________________________________________________
/**
 * Get the inertial velocity of a point on a body.
 *
 * Note that the configuration of the model must be set before calling this
 * method.
 *
 * @param aBody Pointer to body.
 * @param aPoint Point on the body expressed in the body-local frame.
 * @param rVel Velocity of the point in the inertial frame.
 */
void SimbodyEngine::getVelocity(const SimTK::State& s, const OpenSim::Body &aBody, const Vec3& aPoint, Vec3& rVel) const
{
	const Body* b = (Body*)(&aBody);
	rVel = _model->getMatterSubsystem().getMobilizedBody(b->_index).findStationVelocityInGround(s, aPoint);
}

//_____________________________________________________________________________
/**
 * Get the inertial acceleration of a point on a body.
 *
 * Note that the configuration of the model must be set and accelerations of
 * the generalized coordinates must be computed before calling this method.
 *
 * @param aBody Pointer to body.
 * @param aPoint Point on the body expressed in the body-local frame.
 * @param rAcc Acceleration of the point in the inertial frame.
 *
 * @see set()
 * @see computeAccelerations()
 */
void SimbodyEngine::getAcceleration(const SimTK::State& s, const OpenSim::Body &aBody, const Vec3& aPoint, Vec3& rAcc) const
{
	const Body* b = (Body*)(&aBody);
	rAcc = _model->getMatterSubsystem().getMobilizedBody(b->_index).findStationAccelerationInGround(s, aPoint);
}

//_____________________________________________________________________________
/**
 * Get the body orientation with respect to the ground.
 *
 * @param aBody Pointer to body.
 * @param rDirCos Orientation of the body with respect to the ground frame.
 */
void SimbodyEngine::getDirectionCosines(const SimTK::State& s, const OpenSim::Body &aBody, double rDirCos[3][3]) const
{
	const Body* b = (Body*)(&aBody);
	Mat33::updAs(&rDirCos[0][0]) = _model->getMatterSubsystem().getMobilizedBody(b->_index).getBodyRotation(s).asMat33();
}

//_____________________________________________________________________________
/**
 * Get the body orientation with respect to the ground.
 *
 * @param aBody Pointer to body.
 * @param rDirCos Orientation of the body with respect to the ground frame.
 */
void SimbodyEngine::getDirectionCosines(const SimTK::State& s, const OpenSim::Body &aBody, double *rDirCos) const
{
	const Body* b = (Body*)(&aBody);
	Mat33::updAs(rDirCos) = _model->getMatterSubsystem().getMobilizedBody(b->_index).getBodyRotation(s).asMat33();
}

//_____________________________________________________________________________
/**
 * Get the inertial angular velocity of a body in the ground reference frame.
 *
 * @param aBody Pointer to body.
 * @param rAngVel Angular velocity of the body.
 */
void SimbodyEngine::getAngularVelocity(const SimTK::State& s, const OpenSim::Body &aBody, Vec3& rAngVel) const
{
	const Body *b = (Body*)(&aBody);
	rAngVel = _model->getMatterSubsystem().getMobilizedBody(b->_index).getBodyAngularVelocity(s);
}

//_____________________________________________________________________________
/**
 * Get the inertial angular velocity in the local body reference frame.
 *
 * @param aBody Pointer to body.
 * @param rAngVel Angular velocity of the body.
 */
void SimbodyEngine::getAngularVelocityBodyLocal(const SimTK::State& s, const OpenSim::Body &aBody, Vec3& rAngVel) const
{
	const Body *b = (Body*)(&aBody);
	rAngVel = _model->getMatterSubsystem().getMobilizedBody(b->_index).getBodyAngularVelocity(s);
}

//_____________________________________________________________________________
/**
 * Get the inertial angular acceleration of a body in the ground reference 
 * frame.
 *
 * @param aBody Pointer to body.
 * @param rAngAcc Angular acceleration of the body.
 */
void SimbodyEngine::getAngularAcceleration(const SimTK::State& s, const OpenSim::Body &aBody, Vec3& rAngAcc) const
{
	const Body *b = (Body*)(&aBody);
	rAngAcc = _model->getMatterSubsystem().getMobilizedBody(b->_index).getBodyAngularAcceleration(s);
}

//_____________________________________________________________________________
/**
 * Get the inertial angular acceleration in the local body reference frame.
 *
 * @param aBody Pointer to body.
 * @param rAngAcc Angular acceleration of the body.
 */
void SimbodyEngine::getAngularAccelerationBodyLocal(const SimTK::State& s, const OpenSim::Body &aBody, Vec3& rAngAcc) const
{
	const Body *b = (Body*)(&aBody);
	rAngAcc = _model->getMatterSubsystem().getMobilizedBody(b->_index).getBodyAngularAcceleration(s);
}

//_____________________________________________________________________________
/**
 * get a copy of the transform from the inertial frame to a body
 *
 * @param aBody
 * @return Transform from inertial frame to body
 */
SimTK::Transform SimbodyEngine::getTransform(const SimTK::State& s, const OpenSim::Body &aBody) const
{
	const Body* b = (Body*)(&aBody);
	/*
	double aMat[4][4];
	Mat44::updAs(&aMat[0][0]) = _model->getMatterSubsystem()->getMobilizedBody(b->_index).getBodyTransform(s).toMat44();
	return Transform(aMat);*/
	return (_model->getMatterSubsystem().getMobilizedBody(b->_index).getBodyTransform(s));
}

//--------------------------------------------------------------------------
// LOAD ACCESS AND COMPUTATION
//--------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Compute the reaction forces and torques at all the joints in the model.
 *
 * It is necessary to call computeAccelerations() before this method
 * to get valid results.  This method is expensive to call, beyond the
 * expense of computing the accelerations.  So, this method should be
 * called as infrequently as possible.
 *
 * @param rForces Matrix of reaction forces.  The size should be
 * at least NumberOfJoints x 3.
 * @param rTorques Matrix of reaction torques.  The size should be
 * at least NumberOfJoints x 3.
 */
void SimbodyEngine::computeReactions(const SimTK::State& s, Vector_<Vec3>& rForces, Vector_<Vec3>& rTorques) const
{
	int nb = _model->getMatterSubsystem().getNumBodies();
	SimTK::Vector_<SpatialVec> reactionForces(_model->getMatterSubsystem().getNumBodies());

	// Systems must be realized to acceleration stage
	_model->getSystem().realize(s, Stage::Acceleration);
    _model->getMatterSubsystem().calcMobilizerReactionForces(s, reactionForces);

    //Separate SimTK SpatialVecs to Forces and Torques	
	// SpatialVec = Vec2<Vec3 torque, Vec3 force>
	for(int i=0; i<nb; i++){
         rTorques[i] = reactionForces[i](0);
         rForces[i] = reactionForces[i](1);
	}
}


//--------------------------------------------------------------------------
// DERIVATIVES
//--------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Compute the derivatives of the generalized coordinates and speeds.
 *
 * @param dqdt Derivatives of generalized coordinates.
 * @param dudt Derivatives of generalized speeds.
 */
void SimbodyEngine::computeDerivatives(const SimTK::State& s, double *dqdt,double *dudt)
{
	// COMPUTE ACCELERATIONS
	try {
		_model->getSystem().realize(s,Stage::Acceleration);
	} catch(std::exception &x) {
		cout<<x.what()<<endl;
		cout<<"SimbodyEngine.computeDerivatives: invalid derivatives."<<endl;
		return;
	}
	Vector qdot = _model->getMatterSubsystem().getQDot(s);
	Vector udot = _model->getMatterSubsystem().getUDot(s);

	// ASSIGN THEM (MAYBE SLOW BUT CORRECT)
	int nq = s.getNQ();
	for(int i=0;i<nq;i++) dqdt[i] = qdot[i];

	int nu = s.getNU();
	for(int i=0;i<nu;i++) dudt[i] = udot[i];
}


//--------------------------------------------------------------------------
// UTILITY
//--------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Transform a vector from one body to another
 *
 * @param aBodyFrom the body in which the vector is currently expressed
 * @param aPos the vector to be transformed
 * @param aBodyTo the body the vector will be transformed into
 * @param rPos the vector in the aBodyTo frame is returned here
 */
void SimbodyEngine::transform(const SimTK::State& s, const OpenSim::Body &aBodyFrom, const double aVec[3], const OpenSim::Body &aBodyTo, double rVec[3]) const
{
    if(&aBodyFrom == &aBodyTo) { for(int i=0; i<3; i++) { rVec[i]=aVec[i]; } return; }
	const Body* bFrom = (const Body*)&aBodyFrom;
	const Body* bTo = (const Body*)&aBodyTo;

	//Get input vector as a Vec3 to make the call down to Simbody and update the output vector 
	Vec3::updAs(rVec) = _model->getMatterSubsystem().getMobilizedBody(bFrom->_index).expressVectorInAnotherBodyFrame(s, Vec3::getAs(aVec), _model->getMatterSubsystem().getMobilizedBody(bTo->_index));
}

//_____________________________________________________________________________
/**
 * Transform a vector from one body to another
 *
 * @param aBodyFrom the body in which the vector is currently expressed
 * @param aPos the vector to be transformed
 * @param aBodyTo the body the vector will be transformed into
 * @param rPos the vector in the aBodyTo frame is returned here
 */
void SimbodyEngine::transform(const SimTK::State& s, const OpenSim::Body &aBodyFrom, const Vec3& aVec, const OpenSim::Body &aBodyTo, Vec3& rVec) const
{
    if(&aBodyFrom == &aBodyTo) { rVec=aVec; return; }	
	const Body* bFrom = (const Body*)&aBodyFrom;
	const Body* bTo = (const Body*)&aBodyTo;

	//Get input vector as a Vec3 to make the call down to Simbody and update the output vector 
	rVec = _model->getMatterSubsystem().getMobilizedBody(bFrom->_index).expressVectorInAnotherBodyFrame(s, aVec, _model->getMatterSubsystem().getMobilizedBody(bTo->_index));
}

//_____________________________________________________________________________
/**
 * Transform a point from one body to another
 *
 * @param aBodyFrom the body in which the point is currently expressed
 * @param aPos the XYZ coordinates of the point
 * @param aBodyTo the body the point will be transformed into
 * @param rPos the XYZ coordinates of the point in the aBodyTo frame are returned here
 */
void SimbodyEngine::
transformPosition(const SimTK::State& s, const OpenSim::Body &aBodyFrom, const double aPos[3], const OpenSim::Body &aBodyTo, double rPos[3]) const
{
	if(&aBodyFrom == &aBodyTo) {
	   for (int i=0; i<3; i++) rPos[i] = aPos[i];
		return;
	}
	const Body* bFrom = (const Body*)&aBodyFrom;
	const Body* bTo = (const Body*)&aBodyTo;

	//Get input vector as a Vec3 to make the call down to Simbody and update the output vector 
	Vec3::updAs(rPos) = _model->getMatterSubsystem().getMobilizedBody(bFrom->_index).findStationLocationInAnotherBody(s, Vec3::getAs(aPos), _model->getMatterSubsystem().getMobilizedBody(bTo->_index));
}

//_____________________________________________________________________________
/**
 * Transform a point from one body to another
 *
 * @param aBodyFrom the body in which the point is currently expressed
 * @param aPos the XYZ coordinates of the point
 * @param aBodyTo the body the point will be transformed into
 * @param rPos the XYZ coordinates of the point in the aBodyTo frame are returned here
 */
void SimbodyEngine::
transformPosition(const SimTK::State& s, const OpenSim::Body &aBodyFrom, const Vec3& aPos,
	const OpenSim::Body &aBodyTo, Vec3& rPos) const
{
	if(&aBodyFrom == &aBodyTo) {
	   for (int i=0; i<3; i++) rPos[i] = aPos[i];
		return;
	}
	const Body* bFrom = (const Body*)&aBodyFrom;
	const Body* bTo = (const Body*)&aBodyTo;

	//Get input vector as a Vec3 to make the call down to Simbody and update the output vector 
	rPos = _model->getMatterSubsystem().getMobilizedBody(bFrom->_index).findStationLocationInAnotherBody(s, aPos, _model->getMatterSubsystem().getMobilizedBody(bTo->_index));
}

//_____________________________________________________________________________
/**
 * Transform a point from one body to the ground body
 *
 * @param aBodyFrom the body in which the point is currently expressed
 * @param aPos the XYZ coordinates of the point
 * @param rPos the XYZ coordinates of the point in the ground frame are returned here
 */
void SimbodyEngine::transformPosition(const SimTK::State& s, const OpenSim::Body &aBodyFrom, const double aPos[3], double rPos[3]) const
{
	const Body* bFrom = (const Body*)&aBodyFrom;

	//Get input vector as a Vec3 to make the call down to Simbody and update the output vector 
	Vec3::updAs(rPos) = _model->getMatterSubsystem().getMobilizedBody(bFrom->_index).findStationLocationInGround(s, Vec3::getAs(aPos));
}

//_____________________________________________________________________________
/**
 * Transform a point from one body to the ground body
 *
 * @param aBodyFrom the body in which the point is currently expressed
 * @param aPos the XYZ coordinates of the point
 * @param rPos the XYZ coordinates of the point in the ground frame are returned here
 */
void SimbodyEngine::
transformPosition(const SimTK::State& s, const OpenSim::Body &aBodyFrom,const Vec3& aPos,
	Vec3& rPos) const
{
	const Body* bFrom = (const Body*)&aBodyFrom;
	_model->getSystem().realize(s, SimTK::Stage::Position);
	rPos = _model->getMatterSubsystem().getMobilizedBody(bFrom->_index).findStationLocationInGround(s, aPos);
}

//_____________________________________________________________________________
/**
 * Calculate the distance between a point on one body and a point on another body
 *
 * @param aBody1 the body that the first point is expressed in
 * @param aPoint1 the XYZ coordinates of the first point
 * @param aBody2 the body that the second point is expressed in
 * @param aPoint2 the XYZ coordinates of the second point
 * @return the distance between aPoint1 and aPoint2
 */
double SimbodyEngine::
calcDistance(const SimTK::State& s, const OpenSim::Body& aBody1, const Vec3& aPoint1,
	const OpenSim::Body& aBody2, const Vec3& aPoint2) const
{
	const Body* b1 = (Body*)(&aBody1);
	const Body* b2 = (Body*)(&aBody2);
	return _model->getMatterSubsystem().getMobilizedBody(b1->_index).calcStationToStationDistance(s, aPoint1, _model->getMatterSubsystem().getMobilizedBody(b2->_index), aPoint2);
}

//_____________________________________________________________________________
/**
 * Calculate the distance between a point on one body and a point on another body
 *
 * @param aBody1 the body that the first point is expressed in
 * @param aPoint1 the XYZ coordinates of the first point
 * @param aBody2 the body that the second point is expressed in
 * @param aPoint2 the XYZ coordinates of the second point
 * @return the distance between aPoint1 and aPoint2
 */
double SimbodyEngine::calcDistance(const SimTK::State& s, const OpenSim::Body& aBody1, const double aPoint1[3], const OpenSim::Body& aBody2, const double aPoint2[3]) const
{
	const Body* b1 = (Body*)(&aBody1);
	const Body* b2 = (Body*)(&aBody2);
	return _model->getMatterSubsystem().getMobilizedBody(b1->_index).calcStationToStationDistance(s, Vec3::getAs(aPoint1), _model->getMatterSubsystem().getMobilizedBody(b2->_index), Vec3::getAs(aPoint2));
}

//_____________________________________________________________________________
/**
 * Convert angles to direction cosines.
 * @param aE1 1st Euler angle.
 * @param aE2 2nd Euler angle.
 * @param aE3 3rd Euler angle.
 * @param rDirCos Vector of direction cosines.
 */
void SimbodyEngine::convertAnglesToDirectionCosines(double aE1, double aE2, double aE3, double rDirCos[3][3]) const
{
	Vec3 angs(aE1, aE2, aE3);
	Rotation aRot; 
	aRot.setRotationToBodyFixedXYZ(angs);
	Mat33::updAs(&rDirCos[0][0]) = aRot.asMat33();
}

//_____________________________________________________________________________
/**
 * Convert angles to direction cosines.
 * @param aE1 1st Euler angle.
 * @param aE2 2nd Euler angle.
 * @param aE3 3rd Euler angle.
 * @param rDirCos Vector of direction cosines.
 */
void SimbodyEngine::convertAnglesToDirectionCosines(double aE1, double aE2, double aE3, double *rDirCos) const
{
	if(rDirCos==NULL) return;
	
	Vec3 angs(aE1, aE2, aE3);
	Rotation aRot; 
	aRot.setRotationToBodyFixedXYZ(angs);
	Mat33::updAs(&rDirCos[0]) = aRot.asMat33();
}

//_____________________________________________________________________________
/**
 * Convert direction cosines to angles.
 * @param aDirCos Vector of direction cosines.
 * @param rE1 1st Euler angle.
 * @param rE2 2nd Euler angle.
 * @param rE3 3rd Euler angle.
 */
void SimbodyEngine::convertDirectionCosinesToAngles(double aDirCos[3][3], double *rE1, double *rE2, double *rE3) const
{
	Vec3 ang = Rotation(Rotation::getAs(&aDirCos[0][0])).convertRotationToBodyFixedXYZ();
	*rE1 = ang[0];
	*rE2 = ang[1];
	*rE3 = ang[2];
}

//_____________________________________________________________________________
/**
 * Convert direction cosines to angles.
 * @param aDirCos Vector of direction cosines.
 * @param rE1 1st Euler angle.
 * @param rE2 2nd Euler angle.
 * @param rE3 3rd Euler angle.
 */
void SimbodyEngine::convertDirectionCosinesToAngles(double *aDirCos, double *rE1, double *rE2, double *rE3) const
{
	if(!aDirCos) return;
	Vec3 ang = Rotation(Rotation::getAs(aDirCos)).convertRotationToBodyFixedXYZ();
	*rE1 = ang[0];
	*rE2 = ang[1];
	*rE3 = ang[2];
}

//_____________________________________________________________________________
/**
 * Convert direction cosines to quaternions.
 * @param aDirCos Vector of direction cosines.
 * @param rQ1 1st Quaternion.
 * @param rQ2 2nd Quaternion.
 * @param rQ3 3rd Quaternion.
 * @param rQ4 4th Quaternion.
 */
void SimbodyEngine::convertDirectionCosinesToQuaternions(double aDirCos[3][3], double *rQ1, double *rQ2, double *rQ3, double *rQ4) const
{
	Quaternion quat = Rotation(Rotation::getAs(&aDirCos[0][0])).convertRotationToQuaternion();
	*rQ1 = quat[0];
	*rQ2 = quat[1];
	*rQ3 = quat[2];
	*rQ4 = quat[3];
}

//_____________________________________________________________________________
/**
 * Convert direction cosines to quaternions.
 * @param aDirCos Vector of direction cosines.
 * @param rQ1 1st Quaternion.
 * @param rQ2 2nd Quaternion.
 * @param rQ3 3rd Quaternion.
 * @param rQ4 4th Quaternion.
 */
void SimbodyEngine::convertDirectionCosinesToQuaternions(double *aDirCos, double *rQ1, double *rQ2, double *rQ3, double *rQ4) const
{
	if(aDirCos==NULL) return;
	Quaternion quat = Rotation(Rotation::getAs(aDirCos)).convertRotationToQuaternion();
	*rQ1 = quat[0];
	*rQ2 = quat[1];
	*rQ3 = quat[2];
	*rQ4 = quat[3];
}

//_____________________________________________________________________________
/**
 * Convert quaternions to direction cosines.
 * @param aQ1 1st Quaternion.
 * @param aQ2 2nd Quaternion.
 * @param aQ3 3rd Quaternion.
 * @param aQ4 4th Quaternion.
 * @param rDirCos Vector of direction cosines.
 */
void SimbodyEngine::convertQuaternionsToDirectionCosines(double aQ1, double aQ2, double aQ3, double aQ4, double rDirCos[3][3]) const
{
	Rotation R;
	R.setRotationFromQuaternion(Quaternion(Vec4(aQ1, aQ2, aQ3, aQ4)));

	Mat33::updAs(&rDirCos[0][0]) = R.asMat33();
}

//_____________________________________________________________________________
/**
 * Convert quaternions to direction cosines.
 * @param aQ1 1st Quaternion.
 * @param aQ2 2nd Quaternion.
 * @param aQ3 3rd Quaternion.
 * @param aQ4 4th Quaternion.
 * @param rDirCos Vector of direction cosines.
 */
void SimbodyEngine::convertQuaternionsToDirectionCosines(double aQ1, double aQ2, double aQ3, double aQ4, double *rDirCos) const
{
	if(rDirCos==NULL) return;
	Rotation R;
	R.setRotationFromQuaternion(Quaternion(Vec4(aQ1, aQ2, aQ3, aQ4)));

	Mat33::updAs(rDirCos) = R.asMat33();
}


//--- Private Utility Methods Below Here ---


void SimbodyEngine::formEulerTransform(const SimTK::State& s, const OpenSim::Body &aBody, double *rE) const
{
	if (&aBody && rE)
	{
		// GET ORIENTATION OF aBody
		double ang[3], dc[3][3];

		getDirectionCosines(s, aBody, dc);
		convertDirectionCosinesToAngles(dc, &ang[0], &ang[1], &ang[2]);

		// ROW 1
		*rE =  cos(ang[2]) / cos(ang[1]);
		rE++;  *rE = -sin(ang[2]) / cos(ang[1]);
		rE++;  *rE = 0.0;

		// ROW 2
		rE++;  *rE = sin(ang[2]);
		rE++;  *rE = cos(ang[2]);
		rE++;  *rE = 0.0;

		// ROW 3
		rE++;  *rE = -cos(ang[2]) * sin(ang[1]) / cos(ang[1]);
		rE++;  *rE =  sin(ang[1]) * sin(ang[2]) / cos(ang[1]);
		rE++;  *rE = 1.0;
	}
}

//_____________________________________________________________________________
/**
 * Scale the dynamics engine
 *
 * @param aScaleSet the set of XYZ scale factors for the bodies
 * @param aFinalMass the mass that the scaled model should have
 * @param aPreserveMassDist whether or not the masses of the
 *        individual bodies should be scaled with the body scale factors.
 * @return Whether or not scaling was successful.
 */
bool SimbodyEngine::scale(SimTK::State& s, const ScaleSet& aScaleSet, double aFinalMass, bool aPreserveMassDist)
{
	_model->updBodySet().scale(aScaleSet, !aPreserveMassDist);

	// Now that the masses of the individual bodies have
	// been scaled (if aPreserveMassDist == false), get the
	// total mass and compare it to aFinalMass in order to
	// determine how much to scale the body masses again,
	// so that the total model mass comes out to aFinalMass.
	if (aFinalMass > 0.0)
	{
		double mass = getMass();
		if (mass > 0.0)
		{
			double factor = aFinalMass / mass;
			for (int i = 0; i < _model->getBodySet().getSize(); i++)
				_model->getBodySet().get(i).scaleMass(factor);
		}
	}
	
	// Now scale the joints.
   _model->updJointSet().scale(aScaleSet);

   	// Now scale translational coupled coordinate constraints.
   _model->updConstraintSet().scale(aScaleSet);

	// Now scale the markers.
	_model->updMarkerSet().scale(aScaleSet);

	return true;
}

//=============================================================================
// BODY INFORMATION
//=============================================================================
WrapObject* SimbodyEngine::getWrapObject(const string& aName) const
{
	for (int i = 0; i < _model->getBodySet().getSize(); i++) {
		WrapObject* wrap = _model->getBodySet().get(i).getWrapObject(aName);
		if (wrap != NULL)
			return wrap;
	}

	return NULL;
}

//=============================================================================
// CONFIGURATION
//=============================================================================
/**
 * From a potentially partial specification of the generalized coordinates,
 * form a complete storage of the generalized coordinates (q's) and
 * generalized speeds (u's).
 *
 * @param aQIn Storage containing the q's or a subset of the q's.  Rotational
 * q's should be in degrees.
 * @param rQComplete Storage containing all the q's.  If q's were not
 * in aQIn, the values are set to 0.0.  When a q is constrained, its value
 * is altered to be consistent with the constraint.  The caller is responsible
 * for deleting the memory associated with this storage.
 * @param rUComplete Storage containing all the u's.  The generalized speeds
 * are obtained by spline fitting the q's and differentiating the splines.
 * When a u is constrained, its value is altered to be consisten with the
 * constraint.  The caller is responsible for deleting the memory
 * associated with this storage.
 */
void SimbodyEngine::
formCompleteStorages( const SimTK::State& s, const OpenSim::Storage &aQIn,
	OpenSim::Storage *&rQComplete,OpenSim::Storage *&rUComplete) const
{
	int i;
	int nq = _model->getNumCoordinates();
	int nu = _model->getNumSpeeds();

	// Get coordinate file indices
	Array<string> columnLabels;
	columnLabels.append("time");
	string qName;
	Array<int> index(-1,nq);
	const CoordinateSet& coordinateSet = _model->getCoordinateSet();
	int sizeCoordSet = coordinateSet.getSize();
	for(i=0;i<sizeCoordSet;i++) {
		Coordinate& coord = coordinateSet.get(i);
		qName = coord.getName();
		columnLabels.append(qName);
		index[i] = aQIn.getStateIndex(qName);
		if(index[i]<0) {
			string msg = "Model::formCompleteStorages(): WARNING- Did not find column ";
			msg += qName;
			msg += " in storage object.\n";
			cout<<msg;
		}
	}

	// Extract Coordinates
	double time;
	Array<double> data(0.0);
	Array<double> q(0.0,nq);
	Storage *qStore = new Storage();
	qStore->setName("GeneralizedCoordinates");
	qStore->setColumnLabels(columnLabels);
	int size = aQIn.getSize();
	StateVector *vector;
	int j;
	for(i=0;i<size;i++) {
		vector = aQIn.getStateVector(i);
		data = vector->getData();
		time = vector->getTime();

		for(j=0;j<nq;j++) {
			q[j] = 0.0;
			if(index[j]<0) continue;
			q[j] = data[index[j]];
		}

		qStore->append(time,nq,&q[0]);
	}

	// Convert to radians
	convertDegreesToRadians(*qStore);


	// Compute generalized speeds
	GCVSplineSet tempQset(5,qStore);
	Storage *uStore = tempQset.constructStorage(1);

	// Compute constraints
	Array<double> qu(0.0,nq+nu);
	rQComplete = new Storage();
	rUComplete = new Storage();
    State constrainedState = s;
     _model->getSystem().realize(constrainedState, s.getSystemStage());
	for(i=0;i<size;i++) {
		qStore->getTime(i,time);
		qStore->getData(i,nq,&qu[0]);
		uStore->getData(i,nq,&qu[nq]);
        for (int j = 0; j < nq; j++) {
    		Coordinate& coord = coordinateSet.get(j);
            coord.setValue(constrainedState, qu[j], false);
            coord.setSpeedValue(constrainedState, qu[nq+j]);
        }
        projectConfigurationToSatisfyConstraints(constrainedState, 1e-5);
        for (int j = 0; j < nq; j++) {
    		Coordinate& coord = coordinateSet.get(j);
            qu[j] = coord.getValue(constrainedState);
            qu[nq+j] = coord.getSpeedValue(constrainedState);
        }
		rQComplete->append(time,nq,&qu[0]);
		rUComplete->append(time,nu,&qu[nq]);
	}
	
	delete qStore;
	
	// Compute storage object for simulation
	// Need to set column labels before converting rad->deg
	rQComplete->setColumnLabels(columnLabels);
	rUComplete->setColumnLabels(columnLabels);
	// Convert back to degrees
	convertRadiansToDegrees(*rQComplete);
	convertRadiansToDegrees(*rUComplete);
}

//=============================================================================
// UTILITY
//=============================================================================
//_____________________________________________________________________________
/**
 */
void SimbodyEngine::scaleRotationalDofColumns(Storage &rStorage, double factor) const
{
	const Array<std::string>& columnLabels = rStorage.getColumnLabels();

	if(columnLabels.getSize() == 0)
		throw Exception("SimbodyEngine.scaleRotationalDofColumns: ERROR- storage has no labels, can't determine coordinate types for deg<->rad conversion",
							 __FILE__,__LINE__);

	// Loop through the coordinates in the model. For each one that is rotational,
	// see if it has a corresponding column of data. If it does, multiply that
	// column by the given scaling factor.
	const CoordinateSet& coordinateSet = _model->getCoordinateSet();
	for (int i = 0; i < coordinateSet.getSize(); i++) {
		if (coordinateSet.get(i).getMotionType() == Coordinate::Rotational) {
			std::string name = coordinateSet.get(i).getName();
			for(int j=1; j<columnLabels.getSize(); j++) // skip time column (and adjust for time column when calling multiplyColumn)
				if(columnLabels[j] == name) rStorage.multiplyColumn(j-1, factor);

			// Now do speeds
			std::string spdName = coordinateSet.get(i).getSpeedName();
			for(int j=1; j<columnLabels.getSize(); j++) // skip time column (and adjust for time column when calling multiplyColumn)
				if(columnLabels[j] == spdName) rStorage.multiplyColumn(j-1, factor);
		}
	}
}
//_____________________________________________________________________________
/**
 * Convert the rotational generalized coordinates or speeds from units of
 * degrees to units of radians for all the state-vectors in an Storage
 * object.  Coordinates/speeds are identified by column names.
 *
 * @param rStorage Storage object.
 */
void SimbodyEngine::convertDegreesToRadians(Storage &rStorage) const
{
	scaleRotationalDofColumns(rStorage, SimTK_DEGREE_TO_RADIAN);
}
//_____________________________________________________________________________
/**
 * Convert the rotational generalized coordinates or speeds from units of
 * radians to units of degrees for all the state-vectors in an Storage
 * object.  Coordinates/speeds are identified by column names.
 *
 * @param rStorage Storage object.
 */
void SimbodyEngine::convertRadiansToDegrees(Storage &rStorage) const
{
	scaleRotationalDofColumns(rStorage, SimTK_RADIAN_TO_DEGREE);
}
//_____________________________________________________________________________
/**
 * Convert an array of Q/U values from degrees to radians. The sizes of the
 * arrays are assumed to be equal to the number of Us.
 *
 * @param aQDeg Array of values, in degrees
 * @param rQRad Array of values, in radians
 */
void SimbodyEngine::convertDegreesToRadians(double *aQDeg, double *rQRad) const
{
	const CoordinateSet& coordinateSet = _model->getCoordinateSet();

	// The arrays aQDeg and rQRad are assumed to be of size getNumSpeeds() or greater.
	// It is also assumed that aQDeg[N] corresponds to the first N coordinates
	// in the model, whether those N values are coordinates or speeds.
	for (int i = 0; i < _model->getNumSpeeds(); i++)
	{
		if (coordinateSet.get(i).getMotionType() == Coordinate::Rotational)
			rQRad[i] = aQDeg[i] * SimTK_DEGREE_TO_RADIAN;
		else
			rQRad[i] = aQDeg[i];
	}
}
//_____________________________________________________________________________
/**
 * Convert an array of Q/U values from radians to degrees. The sizes of the
 * arrays are assumed to be equal to the number of Us.
 *
 * @param aQRad Array of values, in radians
 * @param rQDeg Array of values, in degrees
 */
void SimbodyEngine::convertRadiansToDegrees(double *aQRad, double *rQDeg) const
{
	const CoordinateSet& coordinateSet = _model->getCoordinateSet();

	// The arrays aQRad and rQDeg are assumed to be of size getNumSpeeds() or greater.
	// It is also assumed that aQRad[N] corresponds to the first N coordinates
	// in the model, whether those N values are coordinates or speeds.
	for (int i = 0; i < _model->getNumSpeeds(); i++)
	{
		if (coordinateSet.get(i).getMotionType() == Coordinate::Rotational)
			rQDeg[i] = aQRad[i] * SimTK_RADIAN_TO_DEGREE;
		else
			rQDeg[i] = aQRad[i];
	}
}
