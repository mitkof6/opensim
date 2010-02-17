#ifndef _BodyKinematics_h_
#define _BodyKinematics_h_
// BodyKinematics.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	AUTHOR: Frank C. Anderson
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
* Copyright (c)  2005, Stanford University. All rights reserved. 
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
#include <OpenSim/Simulation/Model/Analysis.h>
#include "osimAnalysesDLL.h"


//=============================================================================
//=============================================================================
namespace OpenSim { 

class Model;
/**
 * A class for recording the kinematics of the bodies
 * of a model during a simulation.
 *
 * @author Frank C. Anderson
 * @version 1.0
 */

class OSIMANALYSES_API BodyKinematics : public Analysis 
{
//=============================================================================
// DATA
//=============================================================================
private:

protected:
	/** Names of bodies whose kinematics are to be recorded. */
	PropertyStrArray _bodiesProp;
	Array<std::string> &_bodies;

	/** Flag indicating whether or not to express the results
	in the global or body-local frame. */
	PropertyBool _expressInLocalFrameProp;
	bool &_expressInLocalFrame;

	Array<int> _bodyIndices;
	bool _recordCenterOfMass;
	Array<double> _kin;

	Storage *_pStore;
	Storage *_vStore;
	Storage *_aStore;

//=============================================================================
// METHODS
//=============================================================================
public:
	BodyKinematics(Model *aModel=0, bool aInDegrees=true);
	BodyKinematics(const std::string &aFileName);
	// Copy constrctor and virtual copy 
	BodyKinematics(const BodyKinematics &aObject);
	virtual Object* copy() const;
	virtual ~BodyKinematics();
	//--------------------------------------------------------------------------
	// OPERATORS
	//--------------------------------------------------------------------------
#ifndef SWIG
	BodyKinematics& operator=(const BodyKinematics &aBodyKinematics);
#endif
private:
	void setNull();
	void setupProperties();
	void constructDescription();
	void constructColumnLabels();
	void allocateStorage();
	void deleteStorage();
	void updateBodiesToRecord();

public:
	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
	// STORAGE
	void setStorageCapacityIncrements(int aIncrement);
	Storage* getAccelerationStorage();
	Storage* getVelocityStorage();
	Storage* getPositionStorage();
	void setExpressResultsInLocalFrame(bool aTrueFalse);
	bool getExpressResultsInLocalFrame();

	void setRecordCenterOfMass(bool aTrueFalse) {_recordCenterOfMass = aTrueFalse;}
	void setBodiesToRecord(Array<std::string> &listOfBodies) {_bodies = listOfBodies;}


	virtual void setModel(Model& aModel);
	//--------------------------------------------------------------------------
	// ANALYSIS
	//--------------------------------------------------------------------------
    virtual int
        begin(const SimTK::State& s );
    virtual int
        step(const SimTK::State& s, int setNumber );
    virtual int
        end(const SimTK::State& s );
protected:
    virtual int
        record(const SimTK::State& s );

	//--------------------------------------------------------------------------
	// IO
	//--------------------------------------------------------------------------
public:
	virtual int
		printResults(const std::string &aBaseName,const std::string &aDir="",
		double aDT=-1.0,const std::string &aExtension=".sto");

//=============================================================================
};	// END of class BodyKinematics

}; //namespace
//=============================================================================
//=============================================================================


#endif // #ifndef __BodyKinematics_h__
