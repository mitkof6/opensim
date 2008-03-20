#ifndef _BodyIndAccCOM_h_
#define _BodyIndAccCOM_h_
// BodyIndAccCOM.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	AUTHOR: Frank C. Anderson & Saryn R. Goldberg
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
#include <OpenSim/Common/rdMath.h>
#include "osimAnalysesDLL.h"
#include "IndAcc.h"
#include "BodyIndAcc.h"


//=============================================================================
//=============================================================================
/**
 * A class for computing induced accelerations of the COM of a specified set of
 * the body segments of a model.
 *
 * @author Frank C. Anderson & Saryn R. Goldberg
 * @version 1.0
 */
namespace OpenSim { 

class Model;
class AbstractBody;

class OSIMANALYSES_API BodyIndAccCOM : public BodyIndAcc 
{
//=============================================================================
// DATA
//=============================================================================
private:
	Storage *_aeCOMBodyStore;
	Storage *_veCOMBodyStore;
	Storage *_peCOMBodyStore;
	Storage *_posStore;
	Storage *_velStore;
	int _aN;
	AbstractBody* *_aBodyList;

//=============================================================================
// METHODS
//=============================================================================
public:
	BodyIndAccCOM(Model *aModel, int aN=0, AbstractBody* aBodyList[] = NULL);
	BodyIndAccCOM(Model *aModel,Storage *aStates,Storage *aControls,
		char *aBaseName,char *aDir=NULL,char *aExtension=NULL,
		int aN=0,AbstractBody* aBodyList[]=NULL);
	virtual ~BodyIndAccCOM();
private:
	void constructDescription();
	void constructColumnLabels();
	void setBodyList(AbstractBody* aBodyList[]);
	void allocateBodyStorage();
	void deleteBodyStorage();

public:
	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
	virtual void setStorageCapacityIncrements(int aIncrement);

	//--------------------------------------------------------------------------
	// OPERATIONS
	//--------------------------------------------------------------------------
	int computeBodyCOMAccelerations();

	//--------------------------------------------------------------------------
	// UTILITY
	//--------------------------------------------------------------------------
	void sumBodyCOMAccelerationResults();

	//--------------------------------------------------------------------------
	// IO
	//--------------------------------------------------------------------------
	virtual int
		printResults(const std::string &aBaseName,const std::string &aDir="",
		double aDT=-1.0,const std::string &aExtension=".sto");

//=============================================================================
};	// END of class BodyIndAccCOM

}; //namespace
//=============================================================================
//=============================================================================


#endif // #ifndef __BodyIndAccCOM_h__
