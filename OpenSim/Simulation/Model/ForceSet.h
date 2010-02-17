#ifndef __ForceSet_h__
#define __ForceSet_h__

// ForceSet.h
// Author: Jack Middleton 
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


// INCLUDES
#include <OpenSim/Simulation/osimSimulationDLL.h>
#include <OpenSim/Common/Object.h>
#include <OpenSim/Common/Set.h>
#include "Force.h"
#include "Actuator.h"
#include "ModelComponentSet.h"
#include "SimTKsimbody.h"

namespace OpenSim {

class Model;

//=============================================================================
//=============================================================================
/**
 * A class for holding and managing a set of actuators for a model.
 * This class is based on ForceSet
 *
 * @authors Jack Middleton 
 * @version 1.0
 */

//=============================================================================
class OSIMSIMULATION_API ForceSet : public ModelComponentSet<Force>
{

//=============================================================================
// DATA
//=============================================================================
protected:
	/** In case the Forces in the set are loaded from file, the filename goes here
	 * and the column names go into individual functions.
	 */
	PropertyStr _dataFileNameProp;
	std::string &_dataFileName;

   /** The subset of Forces that extend Actuator. */
    Set<Actuator> _actuators;

//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
public:
	ForceSet();
	ForceSet(Model& model);
	ForceSet(Model& model, const std::string &aFileName, bool aUpdateFromXMLNode = true);
	ForceSet(const ForceSet &aForceSet);
	virtual ~ForceSet();
	virtual Object* copy() const;
	void copyData(const ForceSet &aAbsForceSet);
	void createForcesFromFile(const std::string& datafileName,
								Array<std::string>& startForceColumns,
								Array<int>& columnCount, 
								Array<std::string>& bodyNames);

	const std::string& getDataFileName() const { return _dataFileName;};
	void setDataFileName(const std::string& aNewFile) { _dataFileName = aNewFile; };

private:
	void setNull();
	void setupSerializedMembers();
	void copyForce(Force* aFrom, Force* aTo);
    void updateActuators();

	//--------------------------------------------------------------------------
	// OPERATORS
	//--------------------------------------------------------------------------
public:
#ifndef SWIG
	ForceSet& operator=(const ForceSet &aSet);
#endif
	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
public:
	void setup(Model& aModel);
	void postInit(Model& aModel);

	// FORCE
	bool remove(int aIndex);
	bool append(Force *aForce);
	bool append(ForceSet &aForceSet, bool aAllowDuplicateNames=false);
	bool set(int aIndex, Force *aForce);
    bool insert(int aIndex, Force *aObject);
    const Set<Actuator>& getActuators() const;
    Set<Actuator>& updActuators();

    // STATES
    void getStateVariableNames(Array<std::string> &rNames) const;
    //Actuator *mapStateToActuator(int aStateIndex, int &rLocalIndex) const;

	//--------------------------------------------------------------------------
	// COMPUTATIONS
	//--------------------------------------------------------------------------
	void computeEquilibrium(SimTK::State& s);
    void computeStateDerivatives(const SimTK::State& s);

	//--------------------------------------------------------------------------
	// CHECK
	//--------------------------------------------------------------------------
	bool check() const;

//=============================================================================
};	// END of class ForceSet
//=============================================================================
//=============================================================================

} // end of namespace OpenSim


#endif // __ForceSet_h__


