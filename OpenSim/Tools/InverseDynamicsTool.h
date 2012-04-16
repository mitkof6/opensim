#ifndef __InverseDynamicsTool_h__
#define __InverseDynamicsTool_h__
// InverseDynamicsTool.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
* Copyright (c)  2010, Stanford University. All rights reserved. 
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

#include "osimToolsDLL.h"
#include <OpenSim/Common/Object.h>
#include <OpenSim/Common/PropertyBool.h>
#include <OpenSim/Common/PropertyDbl.h>
#include <OpenSim/Common/PropertyStr.h>
#include <OpenSim/Common/PropertyDblArray.h>
#include "DynamicsTool.h"

#ifdef SWIG
	#ifdef OSIMTOOLS_API
		#undef OSIMTOOLS_API
		#define OSIMTOOLS_API
	#endif
#endif

namespace OpenSim {

class Model;
class JointSet;

//=============================================================================
//=============================================================================
/**
 * A Tool that performs an Inverse Dynamics analysis with a given model.
 * Inverse Dynamics is the solution for the generalized-coordinate forces that
 * generate given generalized-coordinate accelerations at a given state.
 * This Tool determines the state from provided coordinate trajectories as
 * functions as that are twice differntiable to estimate velocities and
 * accelerations.
 *
 * @author Ajay Seth
 * @version 1.0
 */
class OSIMTOOLS_API InverseDynamicsTool: public DynamicsTool {
OpenSim_DECLARE_CONCRETE_OBJECT(InverseDynamicsTool, DynamicsTool);

//=============================================================================
// MEMBER VARIABLES
//=============================================================================
	Storage* _coordinateValues;
protected:
	
	/** name of storage file that contains coordinate values for inverse dynamics solving */
	PropertyStr _coordinatesFileNameProp;
	std::string &_coordinatesFileName;

	/** Low-pass cut-off frequency for filtering the coordinates (does not apply to states). */
	PropertyDbl _lowpassCutoffFrequencyProp;
	double &_lowpassCutoffFrequency;

	// name of storage file containing generalized forces from innverse dynamics
	PropertyStr _outputGenForceFileNameProp;
	std::string &_outputGenForceFileName;

	/** Idenitify the list of joints for which equivalent body forces acting at the joint should be reported */
	PropertyStrArray _jointsForReportingBodyForcesProp;
	Array<std::string> &_jointsForReportingBodyForces;

	// name of storage file containing generalized forces from innverse dynamics
	PropertyStr _outputBodyForcesAtJointsFileNameProp;
	std::string &_outputBodyForcesAtJointsFileName;

//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
public:
	virtual ~InverseDynamicsTool();
	InverseDynamicsTool();
	InverseDynamicsTool(const std::string &aFileName, bool aLoadModel=true) SWIG_DECLARE_EXCEPTION;
	InverseDynamicsTool(const InverseDynamicsTool &aObject);

	/* Register types to be used when reading an InverseDynamicsTool object from xml file. */
	static void registerTypes();
	/* Handle reading older formats/Versioning */
	virtual void updateFromXMLNode(SimTK::Xml::Element& aNode, int versionNumber=-1);

protected:
	/** helper method to get a list of model joints by name */
	void getJointsByName(Model &model, const Array<std::string> &jointNames, JointSet &joints) const;

private:
	void setNull();
	void setupProperties();

	//--------------------------------------------------------------------------
	// OPERATORS
	//--------------------------------------------------------------------------
public:
#ifndef SWIG
	InverseDynamicsTool& operator=(const InverseDynamicsTool &aInverseDynamicsTool);
#endif

	//--------------------------------------------------------------------------	
	// GET AND SET
	//--------------------------------------------------------------------------
	void setCoordinateValues(const OpenSim::Storage& aStorage);
	bool hasCoordinateValues();

	std::string getOutputGenForceFileName() { return _outputGenForceFileName;}
	const std::string& getCoordinatesFileName() const { return _coordinatesFileName;};
	void setCoordinatesFileName(const std::string& aCoordinateFile)  { 
		_coordinatesFileName=aCoordinateFile;
	};
	const double getLowpassCutoffFrequency() const {
		return _lowpassCutoffFrequency;
	};
	void setLowpassCutoffFrequency(double aFrequency) {
		_lowpassCutoffFrequency = aFrequency;
	}
	//--------------------------------------------------------------------------
	// INTERFACE
	//--------------------------------------------------------------------------
	virtual bool run() SWIG_DECLARE_EXCEPTION;


//=============================================================================
};	// END of class InverseDynamicsTool
//=============================================================================
} // namespace

#endif // __InverseDynamicsTool_h__
