#ifndef _PropertyStrArray_h_
#define _PropertyStrArray_h_
/* -------------------------------------------------------------------------- *
 *                        OpenSim:  PropertyStrArray.h                        *
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


// INCLUDES
#include "osimCommonDLL.h"
#include <string>
#include "Property_Deprecated.h"
#ifdef WIN32
#pragma warning( disable : 4251 )
#endif

//=============================================================================
//=============================================================================
/**
 * Class PropertyStrArray extends class Property.  It consists of an
 * array of strings (i.e., Array<string>) and the methods for accessing
 * and modifying this array.
 *
 * @version 1.0
 * @author Frank C. Anderson
 */
namespace OpenSim { 

class OSIMCOMMON_API PropertyStrArray : public Property_Deprecated
{

//=============================================================================
// DATA
//=============================================================================
private:
	/** Array of integers. */
	Array<std::string> _array;

//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
public:
	PropertyStrArray();
	PropertyStrArray(const std::string &aName,
		const Array<std::string> &aArray);
	PropertyStrArray(const std::string &aName,
		int aSize,const std::string aArray[]);
	PropertyStrArray(const PropertyStrArray &aProperty);

    bool isArrayProperty() const OVERRIDE_11 {return true;}

	PropertyStrArray* clone() const OVERRIDE_11;

    int getNumValues() const OVERRIDE_11 {return getArraySize();}

	//--------------------------------------------------------------------------
	// OPERATORS
	//--------------------------------------------------------------------------
public:
	PropertyStrArray& operator=(const PropertyStrArray &aProperty);

	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
public:
	// TYPE
	virtual std::string getTypeName() const OVERRIDE_11;
	// VALUE
	virtual void setValue(const Array<std::string> &aArray);
	virtual void setValue(int aSize,const std::string aArray[]);
	virtual Array<std::string>& getValueStrArray();
	virtual const Array<std::string>& getValueStrArray() const;
    virtual void clearValues() OVERRIDE_11 { _array.setSize(0); }
	// SIZE
	virtual int getArraySize() const { return _array.getSize(); }
	// VALUE as String
	virtual std::string toString() const;
    virtual void clearValues() OVERRIDE_11 {
        _array.setSize(0);
    }

//=============================================================================
};	// END of class PropertyStrArray

}; //namespace
//=============================================================================
//=============================================================================

#endif //__PropertyStrArray_h__
