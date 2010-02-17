#ifndef __PointConstraint_h__
#define __PointConstraint_h__

// PointConstraint.h
// Author: Ajay Seth
/*
 * Copyright (c) 2008, Stanford University. All rights reserved. 
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


// INCLUDE
#include <string>
#include <OpenSim/Simulation/osimSimulationDLL.h>
#include <OpenSim/Common/PropertyStr.h>
#include <OpenSim/Common/PropertyStrArray.h>
#include <OpenSim/Common/PropertyDblVec3.h>
#include "Constraint.h"
#include "Body.h"

namespace OpenSim {

//=============================================================================
//=============================================================================
/**
 * A class implementing a Point Constraint.  The underlying Constraint in Simbody
 * is a Constraint::Point
 *
 * @author Ajay Seth
 * @version 1.0
 */
class OSIMSIMULATION_API PointConstraint : public Constraint  
{

//=============================================================================
// DATA
//=============================================================================
protected:
	/** Specify first of two bodies connected together by the constraint. */
	PropertyStr _body1NameProp;
	std::string& _body1Name;

	/** Specify second of two bodies connected by the constraint. */
	PropertyStr _body2NameProp;
	std::string& _body2Name;

	/** Location of the point in first body specified in body1 reference frame. */
	PropertyDblVec3 _locationInBody1Prop;
	SimTK::Vec3& _locationInBody1;

	/** Location of the point in second body specified in body2 reference frame. */
	PropertyDblVec3 _locationInBody2Prop;
	SimTK::Vec3& _locationInBody2;


	/** First body point constraint joins. */
	Body *_body1;

	/** Second body point constraint joins. */
	Body *_body2;

//=============================================================================
// METHODS
//=============================================================================
public:
	// CONSTRUCTION
	PointConstraint();
	PointConstraint(const PointConstraint &aConstraint);
	virtual ~PointConstraint();
	virtual Object* copy() const;
	PointConstraint& operator=(const PointConstraint &aConstraint);
	void copyData(const PointConstraint &aConstraint);
	void setup(SimTK::State& s, Model& aModel);

	//SET 
	void setBody1ByName(std::string aBodyName);
	void setBody1PointLocation(SimTK::Vec3 location);
	void setBody2ByName(std::string aBodyName);
	void setBody2PointLocation(SimTK::Vec3 location);

private:
	void setNull();
	void setupProperties();
	friend class SimbodyEngine;

//=============================================================================
};	// END of class PointConstraint
//=============================================================================
//=============================================================================

} // end of namespace OpenSim

#endif // __PointConstraint_h__


