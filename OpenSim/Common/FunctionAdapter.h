#ifndef __FunctionAdapter_h__
#define __FunctionAdapter_h__
// FunctionAdapter.cpp
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
* Copyright (c)  2008, Stanford University. All rights reserved. 
* Use of the OpenSim software in source form is permitted provided that the following
* conditions are met:
*   1. The software is used only for non-commercial research and education. It may not
*     be used in relation to any commercial activity.
*   2. The software is not distributed or redistributed.  Software distribution is allowed 
*     only through https://simtk.org/home/opensim.
*   3. Use of the OpenSim software or derivatives must be acknowledged in all publications,
*      presentations, or documents describing work in which OpenSim or derivatives are used.
*   4. Credits to developers may not be removed from executables
*     created from modifications of the source.
*   5. Modifications of source code must retain the above copyright notice, this list of
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

/* Note: This code was originally developed by Realistic Dynamics Inc. 
 * Author: Frank C. Anderson 
 */


// INCLUDES
#include "Function.h"


//=============================================================================
//=============================================================================
/**
 * This is a SimTK::Function that acts as a wrapper around an OpenMM::Function.
 *
 * @author Peter Eastman
 */
namespace OpenSim { 

class OSIMCOMMON_API FunctionAdapter : public SimTK::Function<1>
{
//=============================================================================
// DATA
//=============================================================================
protected:
    // PROPERTIES
    /** The number of arguments to the function. */
    int _argumentSize;
    // REFERENCES
    /** The OpenSim::Function used to evaluate this function. */
	const OpenSim::Function& _function;

//=============================================================================
// METHODS
//=============================================================================
public:
	FunctionAdapter(const OpenSim::Function &aFunction, int argumentSize);
    SimTK::Vec1 calcValue(const SimTK::Vector& x) const;
    SimTK::Vec1 calcDerivative(const std::vector<int>& derivComponents, const SimTK::Vector& x) const;
    int getArgumentSize() const;
    int getMaxDerivativeOrder() const;
private:
    FunctionAdapter();
    FunctionAdapter& operator=(FunctionAdapter& function);

//=============================================================================
};  // END class FunctionAdapter

}; //namespace
//=============================================================================
//=============================================================================

#endif  // __FunctionAdapter_h__