#ifndef __Units_h__
#define __Units_h__

// Units.h
// Author: Peter Loan
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


// INCLUDE
#include <iostream>
#include <string>
#include "osimCommonDLL.h"

namespace OpenSim {

//=============================================================================
//=============================================================================
/**
 * A class implementing various units for measuring quantities.
 *
 * @author Peter Loan
 * @version 1.0
 */
class OSIMCOMMON_API Units
{

public:
	enum UnitType
	{
		simmUnknownUnits = 0,
		simmRadians,
		simmDegrees,
		simmMillimeters,
		simmCentimeters,
		simmMeters,
		simmSeconds,
		simmMilliseconds,
		simmNewtons
	};

//=============================================================================
// DATA
//=============================================================================
private:
	UnitType _type;

//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
public:
	Units();
	Units(const Units& aUnits);
	Units(std::string& aString);
	Units(UnitType aType);
	virtual ~Units();
	double convertTo(UnitType aType, double aValue) const;
	double convertTo(UnitType aType) const;
	double convertTo(const Units& aUnit) const;
	UnitType getType() const { return _type; }
	std::string getLabel() const;
	std::string getAbbreviation() const;

//=============================================================================
};	// END of class Units
//=============================================================================
//=============================================================================

} // end of namespace OpenSim

#endif // __Units_h__


