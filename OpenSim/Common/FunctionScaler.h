#ifndef __FunctionScaler_h__
#define __FunctionScaler_h__
// FunctionScaler.cpp
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
* Copyright (c) 2009-2009, Stanford University. All rights reserved. 
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


// INCLUDES
#include "Function.h"



namespace OpenSim { 

//=============================================================================
//=============================================================================
/**
 * This is a SimTK::Function that multiplies the value of another function by
 * a constant.
 *
 * @author Peter Eastman
 */
class OSIMCOMMON_API FunctionScaler : public SimTK::Function
{
//=============================================================================
// DATA
//=============================================================================
protected:
    /** The function to be scaled. */
	const SimTK::Function* _function;
    /** The scale factor. */
    const double _scale;

//=============================================================================
// METHODS
//=============================================================================
public:
	FunctionScaler(const SimTK::Function* function, double scale);
    ~FunctionScaler();
    double calcValue(const SimTK::Vector& x) const;
    double calcDerivative(const std::vector<int>& derivComponents, const SimTK::Vector& x) const;
    int getArgumentSize() const;
    int getMaxDerivativeOrder() const;
private:
    FunctionScaler();
    FunctionScaler& operator=(FunctionScaler& function);

//=============================================================================
};  // END class FunctionScaler

}; //namespace
//=============================================================================
//=============================================================================

#endif  // __FunctionScaler_h__
