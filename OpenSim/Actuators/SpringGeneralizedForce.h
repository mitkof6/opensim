#ifndef _SpringGeneralizedForce_h_
#define _SpringGeneralizedForce_h_
// SpringGeneralizedForce.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	AUTHOR: Frank C. Anderson
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//=============================================================================
// INCLUDES
//=============================================================================
#include <OpenSim/Common/rdMath.h>
#include <OpenSim/Common/PropertyDbl.h>
#include <OpenSim/Common/Storage.h>
#include "GeneralizedForce.h"
#include "osimActuatorsDLL.h"


//=============================================================================
//=============================================================================
/**
 * An actuator that exerts a generalized force based on spring-like
 * characteristics (stiffness and viscosity).  It has one control:
 * stiffness. 
 *
 * @author Frank C. Anderson
 * @version 1.0
 */
namespace OpenSim {

class AbstractCoordinate;

class OSIMACTUATORS_API SpringGeneralizedForce : public GeneralizedForce 
{
//=============================================================================
// DATA
//=============================================================================
protected:
	// PROPERTIES
	/** Rest length. */
	PropertyDbl _propRestLength;
	/** Viscosity. */
	PropertyDbl _propViscosity;

	// REFERENCES
	double &_restLength;
	double &_viscosity;

	/** Stiffness (control 0). */
	double _stiffness;


//=============================================================================
// METHODS
//=============================================================================
public:
	SpringGeneralizedForce(std::string aQName="");
	SpringGeneralizedForce(const SpringGeneralizedForce &aActuator);
	virtual ~SpringGeneralizedForce();
	virtual Object* copy() const;
private:
	void setNull();
	void setupProperties();

public:

	//--------------------------------------------------------------------------
	// OPERATORS
	//--------------------------------------------------------------------------
	SpringGeneralizedForce&
		operator=(const SpringGeneralizedForce &aActuator);

	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
	// REST LENGTH
	void setRestLength(double aRestLength);
	double getRestLength() const;
	// VISCOSITY
	void setViscosity(double aViscosity);
	double getViscosity() const;
	// STIFFNESS
	void setStiffness(double aStiffness);
	double getStiffness() const;

	//--------------------------------------------------------------------------
	// APPLICATION
	//--------------------------------------------------------------------------

	//--------------------------------------------------------------------------
	// COMPUTATIONS
	//--------------------------------------------------------------------------
	virtual void computeActuation();

//=============================================================================
};	// END of class SpringGeneralizedForce

}; //namespace
//=============================================================================
//=============================================================================


#endif // #ifndef __SpringGeneralizedForce_h__
