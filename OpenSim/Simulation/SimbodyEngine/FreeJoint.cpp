// FreeJoint.cpp
// Author: Ajay Seth
/*
 * Copyright (c)  2008, Stanford University. All rights reserved. 
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
#include <math.h>
#include "FreeJoint.h"
#include <OpenSim/Simulation/Model/BodySet.h>

//=============================================================================
// STATICS
//=============================================================================
using namespace std;
using namespace SimTK;
using namespace OpenSim;

//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Destructor.
 */
FreeJoint::~FreeJoint()
{
}
//_____________________________________________________________________________
/**
 * Default constructor.
 */
FreeJoint::FreeJoint() :
	Joint()
	//_useEulerAngles(_useEulerAnglesProp.getValueBool())
{
	setNull();
}

//_____________________________________________________________________________
/**
 * Convenience Constructor.
 */
	FreeJoint::FreeJoint(const std::string &name, OpenSim::Body& parent, SimTK::Vec3 locationInParent, SimTK::Vec3 orientationInParent,
					OpenSim::Body& body, SimTK::Vec3 locationInBody, SimTK::Vec3 orientationInBody,
					/*bool useEulerAngles,*/ bool reverse) :
	Joint(name, parent, locationInParent,orientationInParent,
			body, locationInBody, orientationInBody, reverse)
	//_useEulerAngles(_useEulerAnglesProp.getValueBool())
{
	setNull();
	//_useEulerAngles = useEulerAngles;
	updBody().setJoint(*this);
	setName(name);
}

//=============================================================================
// CONSTRUCTION
//=============================================================================

//_____________________________________________________________________________
/**
 * Set the data members of this FreeJoint to their null values.
 */
void FreeJoint::setNull()
{
	constructCoordinates();
	// We know we have three rotations followed by three translations
	// Replace default names _coord_? with more meaningful names

	const CoordinateSet& coordinateSet = get_CoordinateSet();
	
	string dirStrings[] = {"x", "y", "z"};
	for (int i=0; i< 3; i++){
		string oldName = coordinateSet.get(i).getName();
		int pos=oldName.find("_coord_"); 
		if (pos != string::npos){
			oldName.replace(pos, 8, ""); 
			coordinateSet.get(i).setName(oldName+"_"+dirStrings[i]+"Rotation");
			coordinateSet.get(i).setMotionType(Coordinate::Rotational);
		}
	}
	for (int i=3; i< 6; i++){
		string oldName = coordinateSet.get(i).getName();
		int pos=oldName.find("_coord_"); 
		if (pos != string::npos){
			oldName.replace(pos, 8, ""); 
			coordinateSet.get(i).setName(oldName+"_"+dirStrings[i-3]+"Translation");
			coordinateSet.get(i).setMotionType(Coordinate::Translational);
		}
	}

}

//_____________________________________________________________________________
/**
 * Perform some set up functions that happen after the
 * object has been deserialized or copied.
 *
 * @param aEngine dynamics engine containing this FreeJoint.
 */
void FreeJoint::connectToModel(Model& aModel)
{
	// Base class
	Super::connectToModel(aModel);
}

//=============================================================================
// GET AND SET
//=============================================================================

//=============================================================================
// SCALING
//=============================================================================
//_____________________________________________________________________________
/**
 * Scale a joint based on XYZ scale factors for the bodies.
 *
 * @param aScaleSet Set of XYZ scale factors for the bodies.
 * @todo Need to scale transforms appropriately, given an arbitrary axis.
 */
void FreeJoint::scale(const ScaleSet& aScaleSet)
{
}

//=============================================================================
// Simbody Model building.
//=============================================================================
//_____________________________________________________________________________
void FreeJoint::addToSystem(SimTK::MultibodySystem& system) const
{
	const SimTK::Vec3& orientation = get_orientation();
	const SimTK::Vec3& location = get_location();

	// CHILD TRANSFORM
	Rotation rotation(BodyRotationSequence, orientation[0],XAxis, orientation[1],YAxis, orientation[2],ZAxis);
	SimTK::Transform childTransform(rotation, location);

	const SimTK::Vec3& orientationInParent = get_orientation_in_parent();
	const SimTK::Vec3& locationInParent = get_location_in_parent();

	// PARENT TRANSFORM
	Rotation parentRotation(BodyRotationSequence, orientationInParent[0],XAxis, orientationInParent[1],YAxis, orientationInParent[2],ZAxis);
	SimTK::Transform parentTransform(parentRotation, locationInParent);

	SimTK::Transform noTransform(Rotation(), Vec3(0));

	// CREATE MOBILIZED BODY
	/*if(_useEulerAngles){
		MobilizedBody::Translation
			simtkMasslessBody(_model->updMatterSubsystem().updMobilizedBody(getMobilizedBodyIndex(_parentBody)),
			parentTransform, SimTK::Body::Massless(), noTransform);
		MobilizedBody::Gimbal
				simtkBody(simtkMasslessBody, noTransform, SimTK::Body::Rigid(_body->getMassProperties()), childTransform);

		const MobilizedBodyIndex _masslessBodyIndex = simtkMasslessBody.getMobilizedBodyIndex();
		setMobilizedBodyIndex(_body, simtkBody.getMobilizedBodyIndex());

		// SETUP COORDINATES
		// Each coordinate needs to know it's body index and mobility index.
		for(int i =0; i < _numMobilities; i++){
			Coordinate &coord = _coordinateSet.get(i);
			coord.setJoint(*this);
			setCoordinateModel(&coord, _model);
			// Translations enabled by Translation mobilizer, first, but appear second in coordinate set
			setCoordinateMobilizedBodyIndex(&coord, ((i > 2) ? (_masslessBodyIndex) : (getMobilizedBodyIndex(_body))));
			// The mobility index is the same as the order in which the coordinate appears in the coordinate set.
			setCoordinateMobilizerQIndex(&coord, (i < 3 ? i : i-3));
		}
	}
	else {*/
		FreeJoint* mutableThis = const_cast<FreeJoint*>(this);
		mutableThis->createMobilizedBody(parentTransform, childTransform);
	//}

    // TODO: Joints require super class to be called last.
    Super::addToSystem(system);
}

void FreeJoint::initStateFromProperties(SimTK::State& s) const
{
    Super::initStateFromProperties(s);

    const MultibodySystem& system = _model->getMultibodySystem();
    const SimbodyMatterSubsystem& matter = system.getMatterSubsystem();
    if (matter.getUseEulerAngles(s))
        return;
	int zero = 0; // Workaround for really ridiculous Visual Studio 8 bug.
   
	const CoordinateSet& coordinateSet = get_CoordinateSet();

	double xangle = coordinateSet.get(zero).getDefaultValue();
    double yangle = coordinateSet.get(1).getDefaultValue();
    double zangle = coordinateSet.get(2).getDefaultValue();
    Rotation r(BodyRotationSequence, xangle, XAxis, yangle, YAxis, zangle, ZAxis);
	Vec3 t( coordinateSet.get(3).getDefaultValue(), 
			coordinateSet.get(4).getDefaultValue(), 
			coordinateSet.get(5).getDefaultValue());
	
	FreeJoint* mutableThis = const_cast<FreeJoint*>(this);
    matter.getMobilizedBody(MobilizedBodyIndex(mutableThis->updBody().getIndex())).setQToFitTransform(s, Transform(r, t));
}

void FreeJoint::setPropertiesFromState(const SimTK::State& state)
{
	Super::setPropertiesFromState(state);

    // Override default behavior in case of quaternions.
    const MultibodySystem& system = _model->getMultibodySystem();
    const SimbodyMatterSubsystem& matter = system.getMatterSubsystem();
    if (!matter.getUseEulerAngles(state)) {
        Rotation r = matter.getMobilizedBody(MobilizedBodyIndex(updBody().getIndex())).getMobilizerTransform(state).R();
		Vec3 t = matter.getMobilizedBody(MobilizedBodyIndex(updBody().getIndex())).getMobilizerTransform(state).p();
        Vec3 angles = r.convertRotationToBodyFixedXYZ();
        int zero = 0; // Workaround for really ridiculous Visual Studio 8 bug.
		
		const CoordinateSet& coordinateSet = get_CoordinateSet();
 
		coordinateSet.get(zero).setDefaultValue(angles[0]);
        coordinateSet.get(1).setDefaultValue(angles[1]);
        coordinateSet.get(2).setDefaultValue(angles[2]);
		coordinateSet.get(3).setDefaultValue(t[0]); 
		coordinateSet.get(4).setDefaultValue(t[1]); 
		coordinateSet.get(5).setDefaultValue(t[2]);
    }
}

void FreeJoint::createMobilizedBody(SimTK::Transform parentTransform, SimTK::Transform childTransform) {

	// CREATE MOBILIZED BODY
	MobilizedBody::Free
		simtkBody(_model->updMatterSubsystem().updMobilizedBody(getMobilizedBodyIndex(&updParentBody())),
		parentTransform, SimTK::Body::Rigid(updBody().getMassProperties()), childTransform);

	setMobilizedBodyIndex(&updBody(), simtkBody.getMobilizedBodyIndex());
}