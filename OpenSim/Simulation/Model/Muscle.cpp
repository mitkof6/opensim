// Muscle.cpp
// Author: Peter Loan, Ajay Seth
/*
 * Copyright (c)  2011, Stanford University. All rights reserved. 
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
#include "Muscle.h"

#include <OpenSim/Simulation/SimbodyEngine/Body.h>
#include <OpenSim/Simulation/SimbodyEngine/SimbodyEngine.h>
#include "ConditionalPathPoint.h"
#include "PointForceDirection.h"
#include "GeometryPath.h"

#include "Model.h"


#include <OpenSim/Common/XMLDocument.h>

//=============================================================================
// STATICS
//=============================================================================
using namespace std;
using namespace OpenSim;
using SimTK::Vec3;

static int counter=0;
//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Default constructor.
 */
Muscle::Muscle() : PathActuator()
{
	setNull();
	setupProperties();
	// override the value of default _minControl, _maxControl
	setMinControl(0.0);
	setMaxControl(1.0);
}

//_____________________________________________________________________________
/**
 * Destructor.
 */
Muscle::~Muscle()
{
	VisibleObject* disp;
	if ((disp = getDisplayer())){
		 // Free up allocated geometry objects
		disp->freeGeometry();
	}
}

//_____________________________________________________________________________
/**
 * Copy constructor.
 *
 * @param aMuscle Muscle to be copied.
 */
Muscle::Muscle(const Muscle &aMuscle) : PathActuator(aMuscle)
{
	setNull();
	setupProperties();
	copyData(aMuscle);
}

//=============================================================================
// CONSTRUCTION METHODS
//=============================================================================
//_____________________________________________________________________________
/**
 * Copy data members from one Muscle to another.
 *
 * @param aMuscle Muscle to be copied.
 */
void Muscle::copyData(const Muscle &aMuscle)
{
	setPropertyValue("max_isometric_force", aMuscle.getPropertyValue<double>("max_isometric_force"));
	setPropertyValue("optimal_fiber_length", aMuscle.getPropertyValue<double>("optimal_fiber_length"));
	setPropertyValue("tendon_slack_length", aMuscle.getPropertyValue<double>("tendon_slack_length"));
	setPropertyValue("pennation_angle_at_optimal", aMuscle.getPropertyValue<double>("pennation_angle_at_optimal"));
	setPropertyValue("max_contraction_velocity", aMuscle.getPropertyValue<double>("max_contraction_velocity"));
}

//_____________________________________________________________________________
/**
 * Set the data members of this Muscle to their null values.
 */
void Muscle::setNull()
{
	setType("Muscle");
}

//_____________________________________________________________________________
/**
 * Override default implementation by object to intercept and fix the XML node
 * underneath the model to match current version
 */
void Muscle::updateFromXMLNode(SimTK::Xml::Element& aNode, int versionNumber)
{
	if ( versionNumber < XMLDocument::getLatestVersion()){
		if (Object::getDebugLevel()>=1)
			cout << "Updating Muscle object to latest format..." << endl;
		
		if (versionNumber <= 20301){
				SimTK::Xml::element_iterator pathIter = aNode.element_begin("GeometryPath");
				if (pathIter != aNode.element_end()){
					XMLDocument::renameChildNode(*pathIter, "MusclePointSet", "PathPointSet");
					XMLDocument::renameChildNode(*pathIter, "MuscleWrapSet", "PathWrapSet");
					}
				else { // There was no GeometryPath, just MusclePointSet
					XMLDocument::renameChildNode(aNode, "MusclePointSet", "PathPointSet");
					XMLDocument::renameChildNode(aNode, "MuscleWrapSet", "PathWrapSet");
					// Now create a "GeometryPath" node and move MusclePointSet & MuscleWrapSet under it
					SimTK::Xml::Element myPathElement("GeometryPath");
					SimTK::Xml::element_iterator  pathPointSetIter = aNode.element_begin("PathPointSet");
					SimTK::Xml::Node moveNode = aNode.removeNode(pathPointSetIter);
					myPathElement.insertNodeAfter(myPathElement.element_end(),moveNode);
					SimTK::Xml::element_iterator  pathWrapSetIter = aNode.element_begin("PathWrapSet");
					moveNode = aNode.removeNode(pathWrapSetIter);
					myPathElement.insertNodeAfter(myPathElement.element_end(),moveNode);
					aNode.insertNodeAfter(aNode.element_end(), myPathElement);
					}
			XMLDocument::renameChildNode(aNode, "pennation_angle", "pennation_angle_at_optimal");
					}

	}
	// Call base class now assuming aNode has been corrected for current version
	PathActuator::updateFromXMLNode(aNode, versionNumber);
}


//_____________________________________________________________________________
/**
 * Connect properties to local pointers.
 */
void Muscle::setupProperties()
{
	addProperty<double>("max_isometric_force",
		"Maximum isometric force that the fibers can generate",
		1000.0);
	addProperty<double>("optimal_fiber_length",
		"Optimal length of the muscle fibers",
		0.1);
	addProperty<double>("tendon_slack_length",
		"Resting length of the tendon",
		0.2);
	addProperty<double>("pennation_angle_at_optimal",
		"Angle between tendon and fibers at optimal fiber length",
		0.0);
	addProperty<double>("max_contraction_velocity",
		"Maximum contraction velocity of the fibers, in optimal fiberlengths per second",
		10.0);
}

//=============================================================================
// OPERATORS
//=============================================================================
//_____________________________________________________________________________
/**
 * Assignment operator.
 *
 * @param aMuscle The muscle from which to copy its data
 * @return Reference to this object.
 */
Muscle& Muscle::operator=(const Muscle &aMuscle)
{
	// base class
	PathActuator::operator=(aMuscle);

	copyData(aMuscle);

	return(*this);
}


//--------------------------------------------------------------------------
// MUSCLE PARAMETERS GETTERS AND SETTERS
//--------------------------------------------------------------------------
double Muscle::getMaxIsometricForce() const
{ return getPropertyValue<double>("max_isometric_force"); }

double Muscle::getOptimalFiberLength() const
{ return getPropertyValue<double>("optimal_fiber_length"); }

double Muscle::getTendonSlackLength() const 
{ return getPropertyValue<double>("tendon_slack_length"); }

double Muscle::getPennationAngleAtOptimalFiberLength() const 
{ return getPropertyValue<double>("pennation_angle_at_optimal"); }

double Muscle::getMaxContractionVelocity() const 
{ return getPropertyValue<double>("max_contraction_velocity"); }

void Muscle::setMaxIsometricForce(double aMaxIsometricForce)
{ setPropertyValue("max_isometric_force", aMaxIsometricForce);}

void Muscle::setOptimalFiberLength(double aOptimalFiberLength) 
{ setPropertyValue("optimal_fiber_length", aOptimalFiberLength);}

void Muscle::setTendonSlackLength(double aTendonSlackLength) 
{ setPropertyValue("tendon_slack_length", aTendonSlackLength);}

void Muscle::setPennationAngleAtOptimalFiberLength(double aPennationAngle)
{ setPropertyValue("pennation_angle_at_optimal", aPennationAngle);}

void Muscle::setMaxContractionVelocity(double aMaxContractionVelocity) 
{ setPropertyValue("max_contraction_velocity", aMaxContractionVelocity);}

//=============================================================================
// ModelComponent Interface Implementation
//=============================================================================
void Muscle::setup(Model &aModel)
{
	PathActuator::setup(aModel);
	_muscleWidth = getOptimalFiberLength()*sin(getPennationAngleAtOptimalFiberLength());

	_maxIsometricForce = getMaxIsometricForce();
	_optimalFiberLength = getOptimalFiberLength();
	_pennationAngleAtOptimal = getPennationAngleAtOptimalFiberLength();
	_tendonSlackLength = getTendonSlackLength();
}

// Add Muscle's contributions to the underlying system
 void Muscle::createSystem(SimTK::MultibodySystem& system) const
{
	PathActuator::createSystem(system);
	
	// Cache the calculated values for this muscle categorized by their realization stage 
	addCacheVariable<Muscle::MuscleLengthInfo>("lengthInfo", MuscleLengthInfo(), SimTK::Stage::Position);
	addCacheVariable<Muscle::FiberVelocityInfo>("velInfo", FiberVelocityInfo(), SimTK::Stage::Velocity);
	addCacheVariable<Muscle::MuscleDynamicsInfo>("dynamicsInfo", MuscleDynamicsInfo(), SimTK::Stage::Dynamics);
 }

void Muscle::addStateVariables(const Array<std::string> &stateVariableNames) const
{
	PathActuator::addStateVariables(stateVariableNames);
	for (int i = 0; i < stateVariableNames.getSize(); ++i)
		addCacheVariable<double>(stateVariableNames[i] + "_deriv", 0., SimTK::Stage::Dynamics);
}


//=============================================================================
// GET values of interest from calculations
//=============================================================================
//_____________________________________________________________________________
//**
// * get the excitation value for this ActivationFiberLengthMuscle 
// */
double Muscle::getExcitation( const SimTK::State& s) const {
    return( getControl(s) );
}


/* get the activation level of the muscle, which modulates the active force of the muscle 
	and has a normalized (0 to 1) value */
double Muscle::getActivation(const SimTK::State& s) const
{
	const Muscle::MuscleDynamicsInfo& mdi = getMuscleDynamicsInfo(s);
	return mdi.activation;
}

/* get the current working fiber length (m) for the muscle */
double Muscle::getFiberLength(const SimTK::State& s) const 
{
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mli.fiberLength; 
}

/* get the current pennation angle (radians) between the fiber and tendon at the current fiber length  */
double Muscle::getPennationAngle(const SimTK::State& s) const
{
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mli.pennationAngle; 
}

/* get the current tendon length (m)  given the current joint angles and fiber length */
double Muscle::getTendonLength(const SimTK::State& s) const
{
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mli.tendonLength; 
}

/* get the current normalized fiber length (fiber_length/optimal_fiber_length) */
double Muscle::getNormalizedFiberLength(const SimTK::State& s) const
{
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mli.normFiberLength; 
}

/* get the current fiber length (m) projected (*cos(pennationAngle)) onto the tendon direction */
double Muscle::getFiberLengthAlongTendon(const SimTK::State& s) const
{
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mli.fiberLength*mli.cosPennationAngle; 
}

/* get the current tendon strain (delta_l/lo is dimensionless)  */
double Muscle::getTendonStrain(const SimTK::State& s) const
{
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mli.tendonStrain;
}

/* get current fiber velocity (m/s) positive is lengthening */
double Muscle::getFiberVelocity(const SimTK::State& s) const
{
	const FiberVelocityInfo& fvi = getFiberVelocityInfo(s);
	return fvi.fiberVelocity; 
}

/* get normalize fiber velocity (fiber_length/s / max_contraction_velocity) */
double Muscle::getNormalizedFiberVelocity(const SimTK::State& s) const
{
	const FiberVelocityInfo& fvi = getFiberVelocityInfo(s);
	return fvi.normFiberVelocity; 
}

/* get the current afiber velocity (m/s) projected onto the tendon direction */
double Muscle::getFiberVelocityAlongTendon(const SimTK::State& s) const 
{
	const FiberVelocityInfo& fvi = getFiberVelocityInfo(s);
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return fvi.fiberVelocity*mli.cosPennationAngle; 
}

/* get pennation angular velocity (radians/s) */
double Muscle::getPennationAngularVelocity(const SimTK::State& s) const
{
	const FiberVelocityInfo& fvi = getFiberVelocityInfo(s);
	return fvi.pennationAngularVelocity; 
}

/* get the current fiber force (N) applied to the tendon */
double Muscle::getFiberForce(const SimTK::State& s) const
{
	const MuscleDynamicsInfo& mdi = getMuscleDynamicsInfo(s);
	return mdi.activeFiberForce+mdi.passiveFiberForce; 
}

/* get the current active fiber force (N) due to activation*force_length*force_velocity relationships */
double Muscle::getActiveFiberForce(const SimTK::State& s) const
{
	const MuscleDynamicsInfo& mdi = getMuscleDynamicsInfo(s);
	return mdi.activeFiberForce; 
}

/* get the current passive fiber force (N) passive_force_length relationship */
double Muscle::getPassiveFiberForce(const SimTK::State& s) const 
{
	const MuscleDynamicsInfo& mdi = getMuscleDynamicsInfo(s);
	return mdi.passiveFiberForce;
}

/* get the current active fiber force (N) projected onto the tendon direction */
double Muscle::getActiveFiberForceAlongTendon(const SimTK::State& s) const
{
	const MuscleDynamicsInfo& mdi = getMuscleDynamicsInfo(s);
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mdi.activeFiberForce*mli.cosPennationAngle;
}

/* get the current passive fiber force (N) projected onto the tendon direction */
double Muscle::getPassiveFiberForceAlongTendon(const SimTK::State& s) const 
{
	const MuscleDynamicsInfo& mdi = getMuscleDynamicsInfo(s);
	const MuscleLengthInfo& mli = getMuscleLengthInfo(s);
	return mdi.passiveFiberForce*mli.cosPennationAngle;
}

/* get the current tendon force (N) applied to bones */
double Muscle::getTendonForce(const SimTK::State& s) const
{
	const MuscleDynamicsInfo& mdi = getMuscleDynamicsInfo(s);
	return getMaxIsometricForce()*mdi.normTendonForce;
}

void Muscle::setExcitation(SimTK::State& s, double excitaion) const
{
	setControls(SimTK::Vector(1, excitaion), _model->updControls(s));
}

/** Access to compute data structures */
const Muscle::MuscleLengthInfo& Muscle::getMuscleLengthInfo(const SimTK::State& s) const
{
	if(!isCacheVariableValid(s,"lengthInfo")){
		calcMuscleLengthInfo(s, updMuscleLengthInfo(s));
		markCacheVariableValid(s,"lengthInfo");
	}
	return getCacheVariable<MuscleLengthInfo>(s, "lengthInfo");
}
Muscle::MuscleLengthInfo& Muscle::updMuscleLengthInfo(const SimTK::State& s) const
{
	return updCacheVariable<MuscleLengthInfo>(s, "lengthInfo");
}
const Muscle::FiberVelocityInfo& Muscle::getFiberVelocityInfo(const SimTK::State& s) const
{
	if(!isCacheVariableValid(s,"velInfo")){
		FiberVelocityInfo& ufvi = updFiberVelocityInfo(s);
		calcFiberVelocityInfo(s, ufvi);
		markCacheVariableValid(s,"velInfo");
		// don't bother fishing it out of the cache since 
		// we just calculated it and still have a handle on it
		return ufvi;
	}
	return getCacheVariable<FiberVelocityInfo>(s, "velInfo");
}
Muscle::FiberVelocityInfo& Muscle::updFiberVelocityInfo(const SimTK::State& s) const
{
	return updCacheVariable<FiberVelocityInfo>(s, "velInfo");
}
const Muscle::MuscleDynamicsInfo& Muscle::getMuscleDynamicsInfo(const SimTK::State& s) const
{
	if(!isCacheVariableValid(s,"dynamicsInfo")){
		MuscleDynamicsInfo& umdi = updMuscleDynamicsInfo(s);
		calcMuscleDynamicsInfo(s, umdi);
		markCacheVariableValid(s,"dynamicsInfo");
		// don't bother fishing it out of the cache since 
		// we just calculated it and still have a handle on it
		return umdi;
	}
	return getCacheVariable<MuscleDynamicsInfo>(s, "dynamicsInfo");
}
Muscle::MuscleDynamicsInfo& Muscle::updMuscleDynamicsInfo(const SimTK::State& s) const
{
	return updCacheVariable<MuscleDynamicsInfo>(s, "dynamicsInfo");
}

//_____________________________________________________________________________
/**
 * Get the stress in this muscle actuator.  It is calculated as the force 
 * divided by the maximum isometric force (which is proportional to its area).
 */
double Muscle::getStress(const SimTK::State& s) const
{
	return getForce(s)/getPropertyValue<double>("max_isometric_force");
}


//=============================================================================
// CALCULATIONS
//=============================================================================
/* calculate muscle's position related values such fiber and tendon lengths,
	normalized lengths, pennation angle, etc... */
void Muscle::calcMuscleLengthInfo(const SimTK::State& s, MuscleLengthInfo& mli) const
{
	throw Exception("ERROR- "+getType()+"::calcMuscleLengthInfo() NOT IMPLEMENTED.");
}

/* calculate muscle's velocity related values such fiber and tendon velocities,
	normalized velocities, pennation angular velocity, etc... */
void Muscle::calcFiberVelocityInfo(const SimTK::State& s, FiberVelocityInfo& fvi) const
{
	throw Exception("ERROR- "+getType()+"::calcFiberVelocityInfo() NOT IMPLEMENTED.");
}

/* calculate muscle's active and passive force-length, force-velocity, 
	tendon force, relationships and their related values */
void Muscle::calcMuscleDynamicsInfo(const SimTK::State& s, MuscleDynamicsInfo& mdi) const
{
	throw Exception("ERROR- "+getType()+"::calcMuscleDynamicsInfo() NOT IMPLEMENTED.");
}

//=============================================================================
// FORCE APPLICATION
//=============================================================================
//_____________________________________________________________________________
/**
 * Apply the muscle's force at its points of attachment to the bodies.
 */
void Muscle::computeForce(const SimTK::State& s, 
							  SimTK::Vector_<SimTK::SpatialVec>& bodyForces, 
							  SimTK::Vector& generalizedForces) const
{
	PathActuator::computeForce(s, bodyForces, generalizedForces); // Calls compute actuation.

	// NOTE: Force could be negative, in particular during CMC, when the optimizer is computing
	// gradients, it will setForce(+1) and setForce(-1) to compute the derivative with respect to force.
	if (getForce(s) < -SimTK::SqrtEps) {
		string msg = getType()+"::computeForce, muscle force < 0 for muscle '" + getName() +"' ";
		cout << msg << " at time = " << s.getTime() << endl;
		//throw Exception(msg);
    }
}

void Muscle::updateGeometry(const SimTK::State& s)
{
	updGeometryPath().updateGeometry(s);
}


//_____________________________________________________________________________
/**
 * Utility function to calculate the current pennation angle in a
 * muscle. Pennation angle increases as muscle fibers shorten. The implicit
 * modeling assumption is that muscles have constant width.
 *
 * @param s State
 * @return Current pennation angle (in radians).
 */
 double Muscle::calcPennationAngle(const SimTK::State &s) const
{
	double aFiberLength = getFiberLength(s);
	if (aFiberLength < SimTK::Eps){
		cout << "Muscle::calcPennationAngle() ERRROR- fiber length is zero." << endl;
		return SimTK::NaN;
	}
	
	double value = _muscleWidth/aFiberLength;

	if(value >= 1.0){
		cout << "Muscle::calcPennationAngle() ERRROR- pennation at 90 degrees." << endl;
		return SimTK_PI/2.0;
	}
   else
      return asin(value);
}