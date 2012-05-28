// SpatialTransform.cpp
// Author: Ajay Seth
/*
 * Copyright (c)  2006, Stanford University. All rights reserved. 
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

#include <OpenSim/Common/Constant.h>
#include <OpenSim/Common/MultiplierFunction.h>
#include <OpenSim/Common/LinearFunction.h>

#include "SpatialTransform.h"

using namespace std;
using namespace OpenSim;
using namespace SimTK;


//=============================================================================
// DESTRUCTOR AND CONSTRUCTORS
//=============================================================================

//_____________________________________________________________________________
/*
 * Default constructor of a SpatialTransform.
 */
SpatialTransform::SpatialTransform()
{
	setNull();
	constructProperties();
}

//=============================================================================
// CONSTRUCTION METHODS
//=============================================================================
/**
 * Set the data members of this SpatialTransform to their null values.
 */
void SpatialTransform::setNull()
{
}

//_____________________________________________________________________________
/**
 * Initialize properties.
 */
void SpatialTransform::constructProperties()
{
	constructProperty_rotation1(TransformAxis(Array<string>(), Vec3(1,0,0)));
	constructProperty_rotation2(TransformAxis(Array<string>(), Vec3(0,1,0)));
	constructProperty_rotation3(TransformAxis(Array<string>(), Vec3(0,0,1)));
	constructProperty_translation1(TransformAxis(Array<string>(), Vec3(1,0,0)));
	constructProperty_translation2(TransformAxis(Array<string>(), Vec3(0,1,0)));
	constructProperty_translation3(TransformAxis(Array<string>(), Vec3(0,0,1)));
}


const TransformAxis& SpatialTransform::getTransformAxis(int whichAxis) const
{
	 switch(whichAxis){
		case 0: return get_rotation1();
		case 1: return get_rotation2();
		case 2: return get_rotation3();
		case 3: return get_translation1();
		case 4: return get_translation2();
		case 5: return get_translation3();
		default:
			throw Exception("SpatialTransform: Attempting to access beyond 6 axes.");
	 }
}

TransformAxis& SpatialTransform::updTransformAxis(int whichAxis)
{
	 switch(whichAxis){
		case 0: return upd_rotation1();
		case 1: return upd_rotation2();
		case 2: return upd_rotation3();
		case 3: return upd_translation1();
		case 4: return upd_translation2();
		case 5: return upd_translation3();
		default:
			throw Exception("SpatialTransform: Attempting to access beyond 6 axes.");
	 }
}

// SETUP
void SpatialTransform::setup(CustomJoint& owningJoint)
{
	// define default function for TransformAxes that have none specified
	for(int i=0; i < NumTransformAxes; ++i) {
        TransformAxis& transform = updTransformAxis(i);

		// Call the transform axis setup function.
		transform.setup(*((Joint*)(&owningJoint)));

		// check if it has a function
		if(!transform.hasFunction()){
			// does it have a coordinate?
			if(transform.getCoordinateNames().size() == 1)
				transform.setFunction(new LinearFunction());
			else if(transform.getCoordinateNames().size() > 1)
				throw Exception("TransformAxis: an appropriate multicoordinate function was not supplied");
			else
				transform.setFunction(new Constant());
		}
	}
}

// Spatial Transform specific methods
OpenSim::Array<string> SpatialTransform::getCoordinateNames() const
{
	OpenSim::Array<string> coordinateNames;

	for(int i=0; i < NumTransformAxes; i++){
		const TransformAxis& transform = getTransformAxis(i);
		for(int j = 0; j < transform.getCoordinateNames().size(); j++){
			string name = transform.getCoordinateNames()[j];
			if(coordinateNames.findIndex(name) < 0)
				coordinateNames.append(name);
		}
	}
	return coordinateNames;
}

std::vector<std::vector<int> > SpatialTransform::getCoordinateIndices() const
{
	std::vector<std::vector<int> > coordIndices(6);
	Array<string> coordinateNames = getCoordinateNames();

	for(int i=0; i < NumTransformAxes; i++){
		const TransformAxis& transform = getTransformAxis(i);
		// Get the number of coordinates that dictate motion along this axis
		int ncoords = transform.getCoordinateNames().size();
		std::vector<int> findex(ncoords);
		for(int j=0; j< ncoords; j++){
			int ind = coordinateNames.findIndex(transform.getCoordinateNames()[j]);
			if (ind > -1)
				findex[j] = ind;
		}
		coordIndices[i] = findex;	
	}
	
	return coordIndices;
}
std::vector<const SimTK::Function*> SpatialTransform::getFunctions() const
{
	std::vector<const SimTK::Function*> functions(NumTransformAxes);
	for(int i=0; i < NumTransformAxes; i++){
		functions[i] = getTransformAxis(i).getFunction().createSimTKFunction();
	}
	return functions;
}
std::vector<SimTK::Vec3> SpatialTransform::getAxes() const
{
	std::vector<SimTK::Vec3> axes(NumTransformAxes);
	for(int i=0; i<NumTransformAxes; i++){
		axes[i] = getTransformAxis(i).getAxis();
	}

	return axes;
}


void SpatialTransform::scale(const SimTK::Vec3 scaleFactors)
{
	// Scale the spatial transform functions of translations only
	for (int i = 3; i < NumTransformAxes; i++) {
		TransformAxis& transform = updTransformAxis(i);
        if (transform.hasFunction()) {
			Function& function = transform.updFunction();
			// If the function is a linear function with coefficients of 1.0 and 0.0, do
			// not scale it because this transform axis represents a degree of freedom.
			LinearFunction* lf = dynamic_cast<LinearFunction*>(&function);
			if (lf) {
				const Array<double> coefficients = lf->getCoefficients();
				if (coefficients[0] == 1.0 && coefficients[1] == 0.0)
					continue;
			}
			SimTK::Vec3 axis;
            transform.getAxis(axis);
            double scaleFactor = ~axis * scaleFactors;
			// If the function is already a MultiplierFunction, just update its scale factor.
			// Otherwise, make a MultiplierFunction from it and make the transform axis use
			// the new MultiplierFunction.
			MultiplierFunction* mf = dynamic_cast<MultiplierFunction*>(&function);
			if (mf) {
				mf->setScale(mf->getScale() * scaleFactor);
			} 
			else {
				mf = new MultiplierFunction();
				mf->setScale(scaleFactor);
				// Make a copy of the original function and delete the original
				// (so its node will be removed from the XML document).
				mf->setFunction(function.clone());
				transform.setFunction(mf);
			}
		}
	}
}
/**
 * constructIndependentAxes checks if the TransformAxis at indices startIndex, 
 * startIndex+1, startIndex+2 
 * are independent and fixes them otherwise. It assumes that the first nAxes are ok
 */
void SpatialTransform::constructIndependentAxes(int nAxes, int startIndex)
{
	if (nAxes == 3 || nAxes==0)	return;		// Nothing to do
	Vec3 v1 = getTransformAxis(0+startIndex).getAxis();
	Vec3 v2 = getTransformAxis(1+startIndex).getAxis();
	Vec3 v3 = getTransformAxis(2+startIndex).getAxis();
	if (nAxes ==2){ // Easy, make third axis the cross of the first 2.
		SimTK::Vec3 cross= (v1 % v2);
		cross.normalize();
		updTransformAxis(2+startIndex).setAxis(cross);
	}
	else {	// only v1 was specified, check if v2 is collinear if so, exchange v2, v3
		if (fabs(fabs(~v1 * v2) -1) < 1e-4){
			updTransformAxis(1+startIndex).setAxis(v3);
		}
		v2 = getTransformAxis(1+startIndex).getAxis();
		SimTK::Vec3 cross= (v2 % v1);
		cross.normalize();
		updTransformAxis(2+startIndex).setAxis(cross);	
	}
}
