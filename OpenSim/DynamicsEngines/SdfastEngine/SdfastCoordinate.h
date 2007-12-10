#ifndef __SdfastCoordinate_h__
#define __SdfastCoordinate_h__

// SdfastCoordinate.h
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
#include <string>
#include "osimSdfastEngineDLL.h"
#include <OpenSim/Common/PropertyBool.h>
#include <OpenSim/Common/PropertyInt.h>
#include <OpenSim/Common/PropertyDbl.h>
#include <OpenSim/Common/PropertyDblArray.h>
#include <OpenSim/Common/PropertyStr.h>
#include <OpenSim/Common/PropertyStrArray.h>
#include <OpenSim/Common/PropertyObjPtr.h>
#include <OpenSim/Common/Function.h>
#include <OpenSim/Simulation/Model/AbstractCoordinate.h>
#include <OpenSim/Simulation/Model/AbstractDof.h>

namespace OpenSim {

class SdfastEngine;

//=============================================================================
//=============================================================================
/**
 * A class implementing an SD/FAST generalized coordinate.
 *
 * @author Peter Loan
 * @version 1.0
 */
class OSIMSDFASTENGINE_API SdfastCoordinate : public AbstractCoordinate  
{
//=============================================================================
// DATA
//=============================================================================
public:
	typedef enum
	{
		dpUnconstrained,
		dpConstrained,
		dpFixed,
		dpPrescribed
	} SdfastQType;

protected:
	PropertyDbl _defaultValueProp;
	double &_defaultValue;

	PropertyDbl _initialValueProp;
	double &_initialValue;

	PropertyDbl _toleranceProp;
	double &_tolerance;

	PropertyDbl _stiffnessProp;
	double &_stiffness;

	PropertyDblArray _rangeProp;
	Array<double>& _range;

	PropertyStrArray _keysProp;
	Array<std::string>& _keys;

	/** Flag indicating whether the joint is clamped or not.  Clamped means
	that the coordinate is not allowed to go outside its range. */
	PropertyBool _clampedProp;
	bool &_clamped;

	/** Flag indicating whether the joint is locked or not.  Locked means
	fixed at one value. */
	PropertyBool _lockedProp;
	bool &_locked;

	/** Flag specifying what joint of coordinate this coordinate is (constrained, unconstrained). */
	PropertyInt _QTypeProp;
	int &_QType;

	PropertyObjPtr<Function> _restraintFunctionProp;
	Function *&_restraintFunction;

	PropertyObjPtr<Function> _minRestraintFunctionProp;
	Function *&_minRestraintFunction;

	PropertyObjPtr<Function> _maxRestraintFunctionProp;
	Function *&_maxRestraintFunction;

	PropertyBool _restraintActiveProp;
	bool &_restraintActive;

	PropertyStr _constraintIndependentCoordinateNameProp;
	std::string &_constraintIndependentCoordinateName;

	SdfastCoordinate *_constraintIndependentCoordinate;

	PropertyInt _constraintNumberProp;
	int &_constraintNumber;

	PropertyObjPtr<Function> _constraintFunctionProp;
	Function *&_constraintFunction;

	/** Type of motion of this coordinate (rotational or translationa). */
	AbstractDof::DofType _motionType;

	/** Index of this coordinate in the SD/FAST code. */
	PropertyInt _indexProp;
	int &_index;

	/** Index of the SD/FAST joint that this coordinate is a part of. */
	PropertyInt _jointProp;
	int &_joint;

	/** Index of the joint axis in SD/FAST that this coordinate refers to. */
	PropertyInt _axisProp;
	int &_axis;

	/** Sdfast dynamics engine that contains this coordinate. */
	SdfastEngine* _SdfastEngine;
//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
public:
	SdfastCoordinate();
	SdfastCoordinate(const SdfastCoordinate &aCoordinate);
	SdfastCoordinate(const AbstractCoordinate &aCoordinate);
	virtual ~SdfastCoordinate();
	virtual Object* copy() const;

	SdfastCoordinate& operator=(const SdfastCoordinate &aCoordinate);
	void copyData(const SdfastCoordinate &aCoordinate);
	void copyData(const AbstractCoordinate &aCoordinate);

	void setup(AbstractDynamicsEngine* aEngine);

	virtual void updateFromCoordinate(const AbstractCoordinate &aCoordinate);
	virtual double getValue() const;
	virtual bool setValue(double aValue);
	virtual bool getValueUseDefault() const { return true; }
	virtual void getRange(double rRange[2]) const { rRange[0] = _range[0]; rRange[1] = _range[1]; }
	virtual bool setRange(double aRange[2]);
	virtual double getRangeMin() const { return _range[0]; }
	virtual double getRangeMax() const { return _range[1]; }
	virtual bool setRangeMin(double aMin);
	virtual bool setRangeMax(double aMax);
	virtual bool getRangeUseDefault() const { return _rangeProp.getUseDefault(); }
	virtual double getTolerance() const { return _tolerance; }
	virtual bool setTolerance(double aTolerance);
	virtual bool getToleranceUseDefault() const { return _toleranceProp.getUseDefault(); }
	virtual double getStiffness() const { return _stiffness; }
	virtual bool setStiffness(double aStiffness);
	virtual bool getStiffnessUseDefault() const { return _stiffnessProp.getUseDefault(); }
	virtual double getDefaultValue() const { return _defaultValue; }
	virtual bool setDefaultValue(double aDefaultValue);
	virtual double getInitialValue() const { return _initialValue; }
	virtual void setInitialValue(double aInitialValue);
	virtual bool getDefaultValueUseDefault() const { return _defaultValueProp.getUseDefault(); }
	virtual bool getClamped() const { return _clamped; }
	virtual bool setClamped(bool aClamped) { _clamped = aClamped; return true; }
	virtual bool getClampedUseDefault() const { return _clampedProp.getUseDefault(); }
	virtual bool getLocked() const { return _locked; }
	virtual bool setLocked(bool aLocked) { _locked = aLocked; return true; }
	virtual bool getLockedUseDefault() const { return _lockedProp.getUseDefault(); }
	virtual AbstractDof::DofType getMotionType() const { return _motionType; }

	void getKeys(std::string rKeys[]) const;
	const Array<std::string>& getKeys() const { return _keys; }
	virtual bool isUsedInModel() const { return true; }
	bool isRestraintActive() const { return _restraintActive; }
	Function* getRestraintFunction() const;
	Function* getMinRestraintFunction() const;
	Function* getMaxRestraintFunction() const;
	void setConstraintIndependentCoordinateName(const std::string &aName) { _constraintIndependentCoordinateName = aName; }
	SdfastCoordinate* getConstraintIndependentCoordinate() { return _constraintIndependentCoordinate; }
	void setConstraintNumber(int aNumber) { _constraintNumber = aNumber; }
	int getConstraintNumber() const { return _constraintNumber; }
	Function* getConstraintFunction() const;
	void setConstraintFunction(const Function *function);

	bool getConstrained() const { return _constraintFunction!=0; }

	void setSdfastType(SdfastQType aType) { _QType = aType; }
	int getSdfastType() const { return _QType; }
	void setSdfastIndex(int aIndex) { _index = aIndex; }
	int getSdfastIndex() const { return _index; }
	void setJointIndex(int aJointIndex) { _joint = aJointIndex; }
	int getJointIndex() const { return _joint; }
	void setAxisIndex(int aAxisIndex) { _axis = aAxisIndex; }
	int getAxisIndex() const { return _axis; }

private:
	void setNull();
	void setupProperties();
	void determineType();

//=============================================================================
};	// END of class SdfastCoordinate
//=============================================================================
//=============================================================================

} // end of namespace OpenSim

#endif // __SdfastCoordinate_h__


