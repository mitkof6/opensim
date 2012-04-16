// JointWorkMeter.cpp
// Author: Ajay Seth
/*
 * Copyright (c)  2012, Stanford University. All rights reserved. 
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
#include "JointWorkMeter.h"
#include <OpenSim/Simulation/Model/Model.h>

//=============================================================================
// STATICS
//=============================================================================
using namespace std;
//using namespace SimTK;
using namespace OpenSim;

static const string WORK_STATE_NAME = "work";

//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Default constructor.
 */
JointWorkMeter::JointWorkMeter() 
{
	setNull();
	setupProperties();
}

//_____________________________________________________________________________
/**
 * Convenience constructor.
 */
JointWorkMeter::JointWorkMeter(const Joint &joint, double initialWork)
{
	setNull();
	setupProperties();
	setPropertyValue("joint_name", joint.getName());
	setPropertyValue("initial_joint_work", initialWork);
}

//_____________________________________________________________________________
/**
 * Destructor.
 */
JointWorkMeter::~JointWorkMeter()
{
}

//_____________________________________________________________________________
/**
 * Copy constructor.
 *
 * @param aJointWorkMeter JointWorkMeter to be copied.
 */
JointWorkMeter::JointWorkMeter(const JointWorkMeter &aJointWorkMeter) :
   ModelComponent(aJointWorkMeter)
{
	setNull();
	setupProperties();
}

//=============================================================================
// CONSTRUCTION METHODS
//=============================================================================


//_____________________________________________________________________________
/**
 * Set the data members of this JointWorkMeter to their null values.
 */
void JointWorkMeter::setNull(void)
{
}

//_____________________________________________________________________________
/**
 * Connect properties to local pointers.
 */
void JointWorkMeter::setupProperties(void)
{
	addProperty<string>("joint_name",
		"The joint name whos work use will be calculated.",
		"Unassigned");
	addProperty<double>("initial_joint_work",
		"The initial amount of work.",
		0.0);
}

//_____________________________________________________________________________
/**
 * Perform some set up functions that happen after the
 * object has been deserialized or copied.
 *
 * @param aModel OpenSim model containing this JointWorkMeter.
 */
void JointWorkMeter::setup(Model& aModel)
{
	const string& jointName = getPropertyValue<string>("joint_name");
	ModelComponent::setup(aModel);
	int k = _model->getJointSet().getIndex(jointName);
	if( k >=0 )
		_joint = &_model->getJointSet().get(k);
	else{
		string errorMessage = "JointWorkMeter: Invalid joint '" + jointName + "' specified.";
		throw (Exception(errorMessage.c_str()));
	}
}

//=============================================================================
// Create the underlying system component(s)
//=============================================================================
void JointWorkMeter::createSystem(SimTK::MultibodySystem& system) const
{
	ModelComponent::createSystem(system);

	// Assign a name to the state variable to access the work value stored in the state
	string stateName = _joint->getName()+"."+WORK_STATE_NAME;

	// Add state variables to the underlying system
	addStateVariable(stateName);
}


//=============================================================================
// The state variable derivative (power) to be integrated
//=============================================================================
SimTK::Vector JointWorkMeter::computeStateVariableDerivatives(const SimTK::State& s) const
{
	SimTK::Vector derivs(1, _joint->calcPower(s));
	double power = derivs[0];

	return derivs;
}

 void JointWorkMeter::initState( SimTK::State& s) const
{
	setStateVariable(s, getStateVariableNames()[0], getPropertyValue<double>("initial_joint_work"));
}

void JointWorkMeter::setDefaultsFromState(const SimTK::State& state)
{
    setPropertyValue("initial_joint_work", getWork(state));
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
JointWorkMeter& JointWorkMeter::operator=(const JointWorkMeter &aJointWorkMeter)
{
	// BASE CLASS
	Object::operator=(aJointWorkMeter);
	return(*this);
}

//=============================================================================
// GET AND SET
//=============================================================================
//
// Computed work is part of the state
double JointWorkMeter::getWork(const SimTK::State& state) const
{
	return getStateVariable(state, _joint->getName()+"."+WORK_STATE_NAME);
}