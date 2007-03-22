#ifndef _CallbackSet_h_
#define _CallbackSet_h_
// CallbackSet.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
* Copyright (c) 2005, Stanford University. All rights reserved. 
* Redistribution and use in source and binary forms, with or without 
* modification, are permitted provided that the following conditions
* are met: 
*  - Redistributions of source code must retain the above copyright 
*    notice, this list of conditions and the following disclaimer. 
*  - Redistributions in binary form must reproduce the above copyright 
*    notice, this list of conditions and the following disclaimer in the 
*    documentation and/or other materials provided with the distribution. 
*  - Neither the name of the Stanford University nor the names of its 
*    contributors may be used to endorse or promote products derived 
*    from this software without specific prior written permission. 
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
* "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
* LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS 
* FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
* COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
* INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
* BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
* CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
* LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
* ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
* POSSIBILITY OF SUCH DAMAGE. 
*/

/* Note: This code was originally developed by Realistic Dynamics Inc. 
 * Author: Frank C. Anderson 
 */


// INCLUDES
#include <OpenSim/Simulation/osimSimulationDLL.h>
#include <OpenSim/Common/Object.h>
#include "Callback.h"
#include <OpenSim/Common/Set.h>


template class OSIMSIMULATION_API OpenSim::Set<OpenSim::Callback>;


//=============================================================================
//=============================================================================
/**
 * A class for holding and managing a set of callbacks for a model.
 *
 * @author Frank C. Anderson
 * @version 1.0
 */
namespace OpenSim { 

class AbstractMOdel;

class OSIMSIMULATION_API CallbackSet : public Set<Callback>
{

//=============================================================================
// DATA
//=============================================================================
protected:
	/** Model for which the callbacks have been set. */
	Model *_model;

//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
public:
	CallbackSet(Model *aModel=0);
	virtual ~CallbackSet();
private:
	void setNull();
public:

	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
	Model* getModel();
	void setOn(bool aTrueFalse);

//=============================================================================
};	// END of class CallbackSet

}; //namespace
//=============================================================================
//=============================================================================


#endif // __CallbackSet_h__


