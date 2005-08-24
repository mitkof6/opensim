// Integrand.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Copyright 2005 Frank C. Anderson
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
#ifndef __Integrand_h__
#define __Integrand_h__

// INCLUDES
#include <NMBLTK/Tools/rdObject.h>
#include "rdIntegrator.h"

#ifdef SWIG
	#ifdef RDSIMULATION_API
		#undef RDSIMULATION_API
		#define RDSIMULATION_API
	#endif
#endif

//=============================================================================
//=============================================================================
/**
 * This abstract base class specifies the interface for an integrand.
 * An integrad is a function, or vector-valued fuction, that is
 * integrated.
 *
 * The assumped context is that of a simulation in time.  That is,
 * a vector of states y of size n is integrated forward in time.
 * The integrand is thus dydt, the time derivative of the states.
 * dydt is the same size as y and is typically computed by evaluating
 * a set of couple ordinary differential equations.
 *
 * Some integrators, in addition to an evaluation of dydt, require an
 * evaluation  of the Jacobian.  The Jacobian is the partial derivative of
 * the integrand with respect to the states.  The Jacobian is denoted
 * here by dydtdy.  It is thus an n x n square matrix:
 *
 * | dydt_1/dy_1 dydt_1/dy_2 ... dydt_1/dy_n | \n
 * | dydt_2/dy_1 dydt_2/dy_2 ... dydt_2/dy_n | \n
 * |     ...         ...     ...     ...     | \n
 * | dydt_n/dy_1 dydt_n/dy_2 ... dydt_n/dy_n | \n
 * 
 * The _i above indicates the ith element of a vector.
 *
 * The elements of the Jacobian matrix are assumed to be held sequentially
 * in memory as in an array.  The assumed order of the elements is the
 * first column (dydt/dy_1), followed by the second column (dydt/dy_2), ...,
 * all the way to the last column (dydt/dy_n).
 *
 * Definitions:\n
 * t: Time
 * n: Number of states, or size of the state vector.
 * y: Vector of states (size=n).
 * dydt: Integrand- the time derivative of states (size=n).
 * dydtdy: Jacobian- the partial of the integrad wrt the states (size=nxn).
 *
 * @version 1.0
 * @author Frank C. Anderson
 */
class RDSIMULATION_API Integrand : public rdObject
{
//=============================================================================
// DATA
//=============================================================================
public:

//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
	Integrand() {};
	virtual ~Integrand() {};

	//--------------------------------------------------------------------------
	// SIZE
	//--------------------------------------------------------------------------
	//__________________________________________________________________________
	/**
	 * Get the size of the state vector (y) and time derivative of the state
	 * vector (dydt).  The size is the number of integrated variables.
	 *
	 * @return Size of the state vector y.
	 */
	virtual int getSize() const = 0;

	//--------------------------------------------------------------------------
	// INITIAL STATES
	//--------------------------------------------------------------------------
	//__________________________________________________________________________
	/**
	 * Set the initial states for the integration.
	 *
	 * @param ti Time at which the initial states occur.
	 * @param yi Array of initial states (size = getSize()).
	 */
	virtual void setInitialStates(double ti,const double yi[]) {};
	//__________________________________________________________________________
	/**
	 * Get the initial states for the integration.
	 *
	 * @param yi Array of initial states (size = getSize()).
	 */
	virtual void getInitialStates(double yi[]) const {};

	//--------------------------------------------------------------------------
	// COMPUTATION
	//--------------------------------------------------------------------------
	//__________________________________________________________________________
	/**
	 * Compute the integrand. The integrand is the time derivative of
	 * the states (dydt).
	 *
	 * @param t Current time.
	 * @param y State vector (size = getSize()).
	 * @param dydt Integrand-- the time derivative of the
	 * state vector (size = getSize()).
	 */
	virtual void compute(double t,double y[],double dydt[]) = 0;

	//--------------------------------------------------------------------------
	// JACOBIAN
	//--------------------------------------------------------------------------
	//____________________________________________________________________________
	/**
	 * Compute the Jacobian of the integrand.
	 * 
	 * The Jacobian is the partial derivative of the integrand with respect
	 * to the states.  The Jacobian is denoted here by dydtdy.
	 *
	 * It is thus an n x n square matrix:
	 *
	 * | dydt_1/dy_1 dydt_1/dy_2 ... dydt_1/dy_n | \n
	 * | dydt_2/dy_1 dydt_2/dy_2 ... dydt_2/dy_n | \n
	 * |     ...         ...     ...     ...     | \n
	 * | dydt_n/dy_1 dydt_n/dy_2 ... dydt_n/dy_n | \n
	 * 
	 * The _i above indicates the ith element of a vector.
	 *
	 * The elements of the Jacobian matrix are assumed to be held sequentially
	 * in memory as in an array.  The assumed order of the elements is the
	 * first column (dydt/dy_1), followed by the second column (dydt/dy_2), ...,
	 * all the way to the last column (dydt/dy_n).
	 *
	 * @param t Current time.
	 * @param y State vector (size = getSize()).
	 * @param dydtdy Jacobian- partial derivative of the integrand with
	 * respect to the states (size = getSize() x getSize()).
	 */
	virtual void computeJacobian(double t,double y[],double *dydtdy) {};

	//--------------------------------------------------------------------------
	// HOOKS
	//--------------------------------------------------------------------------
	//__________________________________________________________________________
	/**
	 * Initialize the Integrand at the beginning of an integration.
	 *
	 * @param step Step number.
	 * @param dt Time delta for the first step.  The step size can be changed
	 * by the callees.
	 * @param ti Initial time of the integration.
	 * @param tf Final time of the simulation.
	 * @param y Initial values of the states.
	 */
	virtual void initialize(int step,double &dt,double ti,double tf,double y[]) {};
	//__________________________________________________________________________
	/**
	 * Perform any desired operations after the last successful integration step.
	 *
	 * @param step Step number.
	 * @param dt Time delta for the next integration step.  The step size
	 * can be changed by the callees.
	 * @param t Current time of the integration.
	 * @param y Current values of the states.
	 */
	virtual void processAfterStep(int step,double &dt,double t,double y[]) {};
	//__________________________________________________________________________
	/**
	 * Finalize the integrand after an integration has completed (e.g., clean up).
	 *
	 * @param step Step number.
	 * @param t Time at which the integration completed.
	 * @param y Current values of the states.
	 */
	virtual void finalize(int step,double t,double y[]) {};


//=============================================================================
};	// END class Integrand
//=============================================================================
//=============================================================================

#endif  // __Integrand_h__
