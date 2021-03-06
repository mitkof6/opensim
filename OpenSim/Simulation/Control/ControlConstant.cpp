/* -------------------------------------------------------------------------- *
 *                       OpenSim:  ControlConstant.cpp                        *
 * -------------------------------------------------------------------------- *
 * The OpenSim API is a toolkit for musculoskeletal modeling and simulation.  *
 * See http://opensim.stanford.edu and the NOTICE file for more information.  *
 * OpenSim is developed at Stanford University and supported by the US        *
 * National Institutes of Health (U54 GM072970, R24 HD065690) and by DARPA    *
 * through the Warrior Web program.                                           *
 *                                                                            *
 * Copyright (c) 2005-2012 Stanford University and the Authors                *
 * Author(s): Frank C. Anderson                                               *
 *                                                                            *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may    *
 * not use this file except in compliance with the License. You may obtain a  *
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0.         *
 *                                                                            *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 * -------------------------------------------------------------------------- */

/* Note: This code was originally developed by Realistic Dynamics Inc. 
 * Author: Frank C. Anderson 
 */
#include <OpenSim/Simulation/osimSimulationDLL.h>
#include <OpenSim/Common/Property_Deprecated.h>
#include <OpenSim/Common/PropertyDbl.h>
#include "ControlConstant.h"
#include "SimTKcommon.h"


//=============================================================================
// CONSTRUCTOR(S)
//=============================================================================
//_____________________________________________________________________________


using namespace OpenSim;
/**
 * Destructor.
 */
ControlConstant::~ControlConstant()
{
}
//_____________________________________________________________________________
/**
 * Default constructor.
 *
 * @param aX Value of the control.  By default, the control is assigned a
 * value of 0.0.
 * @param aName Name of the control.  By default, the control is given the
 * name "UNKNOWN".
 */
ControlConstant::ControlConstant(double aX,const char *aName) :
	_x(_propX.getValueDbl())
{
	setNull();
	setIsModelControl(false);
	_x = aX;
	setName(aName);
}
//_____________________________________________________________________________
/**
 * Copy constructor.
 *
 * @param aControl Control to copy.
 */
ControlConstant::ControlConstant(const ControlConstant &aControl) :
	Control(aControl),
	_x(_propX.getValueDbl())
{
	setNull();
	copyData(aControl);
}


//=============================================================================
// CONSTRUCTION/DESTRUCTION
//=============================================================================
//_____________________________________________________________________________
/**
 * Set the member data to their NULL values.
 */
void ControlConstant::
setNull()
{
	setupProperties();
	_x = 0.0;
}
//_____________________________________________________________________________
/**
 * Connect properties to local pointers.
 */
void ControlConstant::
setupProperties()
{
	_propX.setName("value");
	_propX.setValue(0.0);
	_propertySet.append( &_propX );
}
//_____________________________________________________________________________
/**
 * Copy the member variables of the specified control.
 */
void ControlConstant::
copyData(const ControlConstant &aControl)
{
	_x = aControl.getParameterValue(0);
}


//=============================================================================
// OPERATORS
//=============================================================================
//-----------------------------------------------------------------------------
// ASSIGNMENT
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Assignment operator.
 *
 * @return  Reference to the altered object.
 */
ControlConstant& ControlConstant::
operator=(const ControlConstant &aControl)
{
	// BASE CLASS
	Control::operator=(aControl);

	// DATA
	copyData(aControl);

	return(*this);
}


//=============================================================================
// GET AND SET
//=============================================================================
//-----------------------------------------------------------------------------
// NUMBER OF PARAMETERS
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the number of parameters that are used to specify the control curve.
 *
 * @return Number of parameters.
 */
int ControlConstant::
getNumParameters() const
{
	return(1);
}

//-----------------------------------------------------------------------------
// PARAMETER MIN
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Set the minimum value of a control parameter.
 *
 * @param aI Index of the parameter.
 * @param aMin Minimum value of the parameter.
 */
void ControlConstant::
setParameterMin(int aI,double aMin)
{
	setDefaultParameterMin(aMin);
}
//_____________________________________________________________________________
/**
 * Get the minimum value of a control parameter.
 *
 * @param aI Index of the parameter.
 * @return Minimum value of the parameter.
 */
double ControlConstant::
getParameterMin(int aI) const
{
	return(getDefaultParameterMin());
}

//-----------------------------------------------------------------------------
// PARAMETER MAX
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Set the maximum value of a control parameter.
 *
 * @param aI Index of the parameter.
 * @param aMax Maximum value of the parameter.
 */
void ControlConstant::
setParameterMax(int aI,double aMax)
{
	setDefaultParameterMax(aMax);
}
//_____________________________________________________________________________
/**
 * Get the maximum value of a control parameter.
 *
 * @param aI Index of the parameter.
 * @return Maximum value of the parameter.
 */
double ControlConstant::
getParameterMax(int aI) const
{
	return(getDefaultParameterMax());
}

//-----------------------------------------------------------------------------
// PARAMETER TIME
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the time at which a parameter is specified.
 *
 * Parameters for some types of control curves do not have a time at which
 * they are specified.  For example, in a Fourier series the control
 * parameters are the cooefficients in the expansion, and each term in
 * the expansion corresponds not to a specific time but to a frequency.
 * Another example is a constant that has the same value for all times.
 * In these cases, this method returns SimTK::NaN.
 *
 * @param aI Index of the parameter.
 * @return Time at which the control parameter occurs.  For ControlConstant
 * this value is not defined, and so SimTK::getNan() is always returned.
 */
double ControlConstant::
getParameterTime(int aI) const
{
	return(SimTK::NaN);
}

//-----------------------------------------------------------------------------
// PARAMETER NEIGHBORHOOD
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the time neighborhood (i.e., the lower and upper bounds of time)
 * in which a control parameter affects the value of the control curve.
 *
 * Changes in the specified parameter are guarranteed not to change the value
 * of the control curve below the lower bound time or above the upper bound
 * time.  If a parameter influences the value of the control curve for all
 * times, -SimTK::Infinity and SimTK::Infinity are returned for
 * the upper and lower bound times, respectively.
 *
 * @param aI Index of the parameter.
 * @param aTLower Time below which the curve is not affected the specified
 * parameter.  For ControlConstant, -SimTK::Infinity  is always
 * returned.
 * @param aTUpper Time above which the curve is not affected the specified
 * parameter.  For ControlConstant, SimTK::Infinity  is always
 * returned.
 */
void ControlConstant::
getParameterNeighborhood(int aI,double &rTLower,double &rTUpper) const
{
	rTLower = -SimTK::Infinity;
	rTUpper =  SimTK::Infinity;
}

//-----------------------------------------------------------------------------
// PARAMETER LIST
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the list of parameters that affect the control curve at a
 * specified time.
 *
 * @param aT Time in question.
 * @param rList List of control parameters that affect the curve at time aT.
 * For ControlConstant, parameter 0 (i.e., the value of the constant)
 * should be the only paramter on the list.
 * @return Number of parameters in the list.  For ControlConstant, 1 should
 * always be returned.
 */
int ControlConstant::
getParameterList(double aT,Array<int> &rList)
{
	rList.setSize(0);
	rList.append(0);
	return(rList.getSize());
}
//_____________________________________________________________________________
/**
 * Get the list of parameters that affect the control curve between two
 * specified times and that do NOT affect the control curve below the lower
 * of these two times.
 *
 * This method is useful when solving for a set of controls for a dynamic
 * simulation.  When solving for a set of controls, one always wants to
 * go forward in time.  Therefore, one does not want to change control
 * parameters that affect the control curve at past times.
 *
 * A control parameter is included in the list only if it affects
 * the control curve in the specified time interval AND does NOT
 * affect the control curve below the lower bound of the
 * specified time interval.  So, it is possible that some of the
 * parameters on the returned list could affect the control curve at
 * times greater than the upper bound of the specified time interval.
 *
 * @param aTLower Lower time bound.  The control curve is guarranteed
 * not to be affected below this time by any of the returned parameters.
 * @param aTUpper Upper time bound.  The control curve is NOT guarranteed
 * to not be affected for times greater than this time.
 * @param rList List of control parameters that affect the curve at time aT.
 * For ControlConstant, parameter 0 (i.e., the value of the constant)
 * should be the only paramter on the list.
 * @return Number of parameters in the list.  For ControlConstant, 1 should
 * always be returned.
 */
int ControlConstant::
getParameterList(double aTLower,double aTUpper,Array<int> &rList)
{
	rList.setSize(0);
	return(rList.getSize());
}

//-----------------------------------------------------------------------------
// PARAMETER VALUE
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Set the value of a control parameter.
 *
 * Class ControlConstant has only 1 parameter, which is the value of
 * the control.\n\n
 * Index     Parameter\n
 *   0       Control value
 *
 * @param aI Index of the parameter (only 0 is valid for ControlConstant).
 * @param aX Value of the parameter (value of the control for ControlConstant).
 * @see getNumParameters()
 */
void ControlConstant::
setParameterValue(int aI,double aX)
{
	_x = aX;
}
//_____________________________________________________________________________
/**
 * Get the value of a control parameter.
 *
 * Class ControlConstant has only 1 parameter, which is the value of
 * the control.\n\n
 * Index     Parameter\n
 *   0       Control value
 *
 * @param aI Index of the parameter (only 0 is valid in this case).
 * @return Value of the parameter (value of the control in this case).
 */
double ControlConstant::
getParameterValue(int aI) const
{
	return(_x);
}

//-----------------------------------------------------------------------------
// CONTROL VALUE
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Set the value of this control at time aT.
 *
 * @param aT Time at which to set the control.
 * @param aX Control value.
 */
void ControlConstant::
setControlValue(double aT,double aX)
{
	_x = aX;
}
//_____________________________________________________________________________
/**
 * Get the value of this control at time aT.
 *
 * @param aT Time at which to get the control.
 * @return Control value.  For ControlConstant, aT is not used since the
 * control has a constant, time-independent value.
 */
double ControlConstant::
getControlValue(double aT)
{
	return(_x);
}

//-----------------------------------------------------------------------------
// CONTROL VALUE MIN
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Set the minimum allowed value of this control at time aT.
 *
 * @param aT Time.
 * @param aMin Minimum control value.
 */
void ControlConstant::
setControlValueMin(double aT,double aMin)
{
	setDefaultParameterMin(aMin);
}
//_____________________________________________________________________________
/**
 * Get the minimum allowed value of this control at time aT.
 *
 * @param aT Time.
 * @return Minimum control value.
 */
double ControlConstant::
getControlValueMin(double aT)
{
	return( getDefaultParameterMin() );
}

//-----------------------------------------------------------------------------
// CONTROL VALUE MAX
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Set the maximum allowed value of this control at time aT.
 *
 * @param aT Time.
 * @param aMax Maximum control value.
 */
void ControlConstant::
setControlValueMax(double aT,double aMax)
{
	setDefaultParameterMax(aMax);
}
//_____________________________________________________________________________
/**
 * Get the maxium allowed value of this control at time aT.
 *
 * @param aT Time.
 * @return Maximum control value.
 */
double ControlConstant::
getControlValueMax(double aT)
{
	return( getDefaultParameterMax() );
}


