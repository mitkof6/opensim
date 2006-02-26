#ifndef __suCoordinate_h__
#define __suCoordinate_h__

#include <iostream>
#include <NMBLTK/Tools/rdMath.h>

// suCoordinate.h
// Author: Ayman Habib
/* Copyright (c) 2005, Stanford University and Ayman Habib.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject
 * to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


// INCLUDE
#include <iostream>
#include <string>
#include <math.h>
#include <NMBLTK/Simulation/rdSimulationDLL.h>
#include <NMBLTK/Tools/rdObject.h>

//=============================================================================
//=============================================================================
/**
 * Aan abstract class specifying the interface for a generalized coordinate.
 *
 * @author Ayman Habib
 * @version 1.0
 */
class RDSIMULATION_API suCoordinate : public rdObject  
{
public:
	virtual ~suCoordinate() {}
	suCoordinate() {}
	suCoordinate(const std::string &aFileName) :
		rdObject(aFileName)
		{}
	suCoordinate::suCoordinate(DOMElement *aElement) :
		rdObject(aElement)
		{}

	suCoordinate& suCoordinate::operator=(const suCoordinate &aKE)
	{
		rdObject::operator=(aKE);
		return(*this);
	}
	virtual double getRangeMin() const
	{
				std::cout<< "Error, RangeMin not implemented for Coordinate.\n";
				return rdMath::NAN;
	}

	virtual double getRangeMax() const
	{
				std::cout<< "Error, RangeMax not implemented for Coordinate.\n";
				return rdMath::NAN;
	}
};
#endif // __suCoordinate_h__


