// SimbodyTranslationDof.cpp
// Author: Peter Loan, Frank C. Anderson
/*
 * Copyright (c) 2006, Stanford University. All rights reserved. 
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

//=============================================================================
// INCLUDES
//=============================================================================
#include "SimbodyTranslationDof.h"
#include <OpenSim/Simulation/Model/AbstractCoordinate.h>

//=============================================================================
// STATICS
//=============================================================================
using namespace std;
using namespace SimTK;
using namespace OpenSim;

//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Default constructor.
 */
SimbodyTranslationDof::SimbodyTranslationDof()
{
	setNull();

	_axis[0] = _axis[1] = _axis[2] = 0.0;
	_axisIndex = xTranslation;
}

//_____________________________________________________________________________
/**
 * Destructor.
 */
SimbodyTranslationDof::~SimbodyTranslationDof()
{
}

//_____________________________________________________________________________
/**
 * Copy constructor.
 *
 * @param aDof SimbodyTranslationDof to be copied.
 */
SimbodyTranslationDof::SimbodyTranslationDof(const SimbodyTranslationDof &aDof) :
   AbstractDof(aDof)
{
	setNull();
	copyData(aDof);
}

//_____________________________________________________________________________
/**
 * Copy this dof and return a pointer to the copy.
 * The copy constructor for this class is used.
 *
 * @return Pointer to a copy of this SimbodyTranslationDof.
 */
Object* SimbodyTranslationDof::copy() const
{
	SimbodyTranslationDof *dof = new SimbodyTranslationDof(*this);
	return(dof);
}

//=============================================================================
// CONSTRUCTION METHODS
//=============================================================================
//_____________________________________________________________________________
/**
 * Perform some set up functions that need to be done each time the
 * SimbodyTranslationDof is deserialized.
 */
void SimbodyTranslationDof::updateFromXMLNode()
{
	AbstractDof::updateFromXMLNode();

	if (_name == TX_NAME)
	{
		_axis[0] = 1.0;
		_axisIndex = xTranslation;
	}
	else if (_name == TY_NAME)
	{
		_axis[1] = 1.0;
		_axisIndex = yTranslation;
	}
	else if (_name == TZ_NAME)
	{
		_axis[2] = 1.0;
		_axisIndex = zTranslation;
	}
}

//_____________________________________________________________________________
/**
 * Copy data members from one SimbodyTranslationDof to another.
 *
 * @param aDof SimbodyTranslationDof to be copied.
 */
void SimbodyTranslationDof::copyData(const SimbodyTranslationDof &aDof)
{
	aDof.getAxis(_axis);
	_axisIndex = aDof._axisIndex;
}

//_____________________________________________________________________________
/**
 * Set the data members of this SimbodyTranslationDof to their null values.
 */
void SimbodyTranslationDof::setNull()
{
	setType("SimbodyTranslationDof");
}

//=============================================================================
// OPERATORS
//=============================================================================
//_____________________________________________________________________________
/**
 * Assignment operator.
 *
 * @return Reference to this object.
 */
SimbodyTranslationDof& SimbodyTranslationDof::operator=(const SimbodyTranslationDof &aDof)
{
	// BASE CLASS
	AbstractDof::operator=(aDof);

	copyData(aDof);

	return(*this);
}

//=============================================================================
// GET AND SET
//=============================================================================
//_____________________________________________________________________________
/**
 * Get the current value of the translation dof
 *
 * @return The current value of the dof.
 */
double SimbodyTranslationDof::getValue()
{
	if (_coordinate)
		return _function->evaluate(0, _coordinate->getValue(), 0.0, 0.0);
	else
		return _function->evaluate(0, 0.0, 0.0, 0.0);
}

//_____________________________________________________________________________
/**
 * Get the translation axis.
 *
 * @param rAxis the translation axis is returned here.
 */
void SimbodyTranslationDof::getAxis(double rAxis[3]) const
{
	if (rAxis != NULL)
	{
		rAxis[0] = _axis[0];
		rAxis[1] = _axis[1];
		rAxis[2] = _axis[2];
	}
}

//_____________________________________________________________________________
/**
 * Get the translation.
 *
 * @param rVec the translation is returned here.
 */
void SimbodyTranslationDof::getTranslation(double rVec[4])
{
	double value = getValue();

	rVec[0] = _axis[0] * value;
	rVec[1] = _axis[1] * value;
	rVec[2] = _axis[2] * value;
	rVec[3] = 1.0;
}

void SimbodyTranslationDof::peteTest()
{
	cout << "TranslationDof: " << getName() << endl;
	double v[4];
	getTranslation(v);
	cout << "   trans: " << v[0] << ", " << v[1] << ", " << v[2] << endl;
	cout << "   axisIndex: " << _axisIndex << endl;
	cout << "   coordinate: " << _coordinateName << endl;
	if (_function) cout << "   function: " << *_function << endl;
}