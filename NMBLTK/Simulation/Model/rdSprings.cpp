// rdSprings.cpp
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Copyright 2000 Realistic Dynamics, Inc.
// All rights reserved.
//
// CONFIDENTIAL
//
// The material contain within this file is the sole property of
// Realistic Dynamics, Inc., and may not be read, copied, or distributed
// without the expressed writen consent of Realistic Dynamics, Inc.
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//=============================================================================
// INCLUDES
//=============================================================================
#include <math.h>
#include "rdSprings.h"


//=============================================================================
// INTERNAL TRIG CONSTANTS
//=============================================================================
const double PI = acos(-1.0);
const double TWOPI = 2.0*PI;


//=============================================================================
// EXPONENTIAL BARRIER CONSTANTS
//=============================================================================
const double E0 =  6.5905e-3;
const double E1 =  0.5336322;
//const double E1 =  0.5*0.5336322;
const double E2 = -1150.8002;
const double G0 =  0.02;
//const double G0 =  0.5*0.02;
const double G1 =  10.0;
const double G2 =  500.0;
const double KV =  1.0e3;
//const double KV =  6.0e3;



//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Default constructor.
 */
rdSprings::rdSprings()
{
}
//_____________________________________________________________________________
/**
 * Destructor.
 */
rdSprings::~rdSprings()
{
}



//=============================================================================
// SPRING TYPES
//=============================================================================

//-----------------------------------------------------------------------------
// LINEAR
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Compute a linear damping force based on a damping constant, kv, and a
 * velocity, v.
 *
 * The argument kv is assumed to be a non-negative constant.
 */
double rdSprings::
Damp(double kv,double v)
{
	return(-kv*v);
}
//_____________________________________________________________________________
/**
 * Compute a linear spring force based on a spring constant, k, and a deviation
 * from the rest length, dx.
 *
 * dx = x - x0, where x is the length of the spring and x0 is the rest
 * length of the spring.
 *
 * The argument k is assumed to be a non-negative constant.
 */
double rdSprings::
Linear(double k,double dx)
{
	return(-k*dx);
}
//_____________________________________________________________________________
/**
 * Compute a linear spring force based on a spring constant, k, a spring zero,
 * x0, and a spring length, x.
 *
 * The argument k is assumed to be a non-negative constant.
 */
double rdSprings::
Linear(double k,double x0,double x)
{
	return(-k*(x-x0));
}
//_____________________________________________________________________________
/**
 * Compute a linear damped spring force based on a damping constant, kv,
 * a velocity, v, a spring stiffness, kx, a spring zero, xo, and a spring length, x.
 *
 * The kv and kx are assumed to be non-negative constants.
 */
double rdSprings::
DampedLinear(double kv,double v,double kx,double xo,double x)
{
	return(-kv*v - kx*(x-xo));
}
//_____________________________________________________________________________
/**
 * Compute a spring zero to achieve a given force, f, given a damping
 * constant, kv, a velocity, v, a spring stiffness, kx, and a spring
 * position, x.
 *
 * @param kv Damping constant (assumed non-negative).
 * @param v Velocity of the spring.
 * @param kx Stiffness (assumed non-negative).
 * @param x Position of the spring.
 * @param f Desired force in the spring.
 */
double rdSprings::
ZeroForDampedLinear(double kv,double v,double kx,double x,double f)
{
	return( (f+kv*v)/kx + x );
}
//_____________________________________________________________________________
/**
 * Compute the spring length that will achieve a desired stiffness.
 *
 * @param kv Damping constant (assumed non-negative).
 * @param v Velocity of the spring.
 * @param kx Stiffness (assumed non-negative).
 * @param f Desired force in the spring.
 */
double rdSprings::
DisplacementOfDampedLinear(double kv,double v,double kx,double f)
{
	return( (-f-kv*v)/kx);
}

//-----------------------------------------------------------------------------
// QUADRATIC
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Compute a quadratic spring force based on a spring constant, kx, and a
 * deviation from the rest length, dx.
 *
 * dx = x - x0, where x is the length of the spring and x0 is the rest
 * length of the spring.
 *
 * The argument kx is assumed to be a non-negative constant.
 */
double rdSprings::
Quadratic(double kx,double dx)
{
	double dx2;
	if(dx<0.0) {
		dx2 = -dx*dx;
	} else {
		dx2 = dx*dx;
	}
	return(-kx*dx2);
}
//_____________________________________________________________________________
/**
 * Compute a quadratic spring force based on a spring constant, kx, a spring
 * zero, x0, and a spring length, x.
 *
 * The argument kx is assumed to be a non-negative constant.
 */
double rdSprings::
Quadratic(double kx,double x0,double x)
{
	double dx = x-x0;
	double dx2;
	if(dx<0.0) {
		dx2 = -dx*dx;
	} else {
		dx2 = dx*dx;
	}
	return(-kx*dx2);
}
//_____________________________________________________________________________
/**
 * Compute a quadratic damped spring force based on a damping constant, kv,
 * a velocity, v, a spring stiffness, kx, and a deviation from rest length,
 * dx.
 *
 * The kv and kx are assumed to be non-negative constants.
 */
double rdSprings::
DampedQuadratic(double kv,double v,double kx,double dx)
{
	double dx2;
	if(dx<0.0) {
		dx2 = -dx*dx;
	} else {
		dx2 = dx*dx;
	}
	return(-kv*v - kx*dx2);
}
//_____________________________________________________________________________
/**
 * Compute a quadratic damped spring force based on a damping constant, kv,
 * a velocity, v, a spring stiffness, kx, a spring zero, x0, and a
 * spring length, x.
 *
 * The kv and kx are assumed to be non-negative constants.
 */
double rdSprings::
DampedQuadratic(double kv,double v,double kx,double x0,double x)
{
	double dx = x-x0;
	double dx2;
	if(dx<0.0) {
		dx2 = -dx*dx;
	} else {
		dx2 = dx*dx;
	}
	return(-kv*v - kx*dx2);
}

//-----------------------------------------------------------------------------
// EXPONENTIAL
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Compute an exponential spring force based on the distance, dx, of a point
 * from a plane and the velocity of the point v.
 * This spring type is often used to represent a firm floor or a wall.
 *
 * dx is assumed to be a positive quantity.  At large dx, the force
 * is negligible.  As dx approaches 0.0, the force increases exponentially.
 * v is included so that a damping force can also be computed.  The damping
 * force allows numerical integrations to execute more efficiently.
 * The sign of v should be positive if the point is moving away from the
 * barrier (dx increasing), and negative if moving toward the barrier
 * (dx decreasing).
 */
double rdSprings::
ExponentialBarrier(double v,double dx)
{
	// EXPONENTIAL
	double de = dx - E0;
	double e = E1*exp(E2*de);

	// DAMP VELOCITY TOWARD THE BARRIER
	// The function g brings the damping into effect gradually.
	double dg,g;
	if(v<0.0) {
		dg = dx - G0;
		g = 1.0 / (1.0+G1*exp(G2*dg));
		e += g * Damp(KV,v);
	}

	return(e);
}
//_____________________________________________________________________________
/**
 * Compute the stiffness of the exponential barrier with respect to changes
 * in x.
 */
double rdSprings::
ExponentialBarrierDX(double v,double dx)
{
	// EXPONENTIAL
	double dfdx=0.0;
	double de = dx - E0;
	double e = E1*exp(E2*de);
	double dedx = E2*e;

	// DAMP VELOCITY TOWARD THE BARRIER
	// The function g brings the damping into effect gradually.
	double dg,gexp,gdenom;
	double dgdx = 0.0;
	if(v<0.0) {
		dg = dx - G0;
		gexp = G1*exp(G2*dg);
		gdenom = 1.0+gexp;
		dgdx = -Damp(KV,v)*G2*gexp / (gdenom*gdenom);
	}
	
	dfdx = dedx + dgdx;
	return(dfdx);
}
//_____________________________________________________________________________
/**
 * Compute the stiffness of the exponential barrier with respect to changes
 * in v.
 */
double rdSprings::
ExponentialBarrierDV(double v,double dx)
{
	// DAMP VELOCITY TOWARD THE BARRIER
	// The function g brings the damping into effect gradually.
	double dfdv = 0.0;
	double dg,g;
	if(v<0.0) {
		dg = dx - G0;
		g = 1.0 / (1.0+G1*exp(G2*dg));
		dfdv = -KV * g;
	}
	
	return(dfdv);
}

//_____________________________________________________________________________
/**
 * Compute an exponential spring force based on the distance, dx, of a point
 * from a plane and the velocity of the point v.
 * This spring type is often used to represent a firm floor or a wall.
 *
 * dx is assumed to be a positive quantity.  At large dx, the force
 * is negligible.  As dx approaches 0.0, the force increases exponentially.
 * v is included so that a damping force can also be computed.  The damping
 * force allows numerical integrations to execute more efficiently.
 * The sign of v should be positive if the point is moving away from the
 * barrier (dx increasing), and negative if moving toward the barrier
 * (dx decreasing).
 */
double rdSprings::
ExponentialBarrier(double aG0,double aG1,double aG2,
	double aE0,double aE1,double aE2,
	double aKV,double aV,double aDX)
{
	// EXPONENTIAL
	double de = aDX - aE0;
	double e = aE1*exp(aE2*de);

	// DAMP VELOCITY TOWARD THE BARRIER
	// The function g brings the damping into effect gradually.
	double dg,g;
	if(aV<0.0) {
		dg = aDX - aG0;
		g = 1.0 / (1.0+aG1*exp(aG2*dg));
		e += g * Damp(aKV,aV);
	}

	return(e);
}
//_____________________________________________________________________________
/**
 * Compute the stiffness of the exponential barrier with respect to changes
 * in x.
 */
double rdSprings::
ExponentialBarrierDX(double aG0,double aG1,double aG2,
	double aE0,double aE1,double aE2,
	double aKV,double aV,double aDX)
{
	// EXPONENTIAL
	double dfdx=0.0;
	double de = aDX - aE0;
	double e = aE1*exp(aE2*de);
	double dedx = aE2*e;

	// DAMP VELOCITY TOWARD THE BARRIER
	// The function g brings the damping into effect gradually.
	double dg,gexp,gdenom;
	double dgdx = 0.0;
	if(aV<0.0) {
		dg = aDX - aG0;
		gexp = aG1*exp(aG2*dg);
		gdenom = 1.0+gexp;
		dgdx = -Damp(aKV,aV)*aG2*gexp / (gdenom*gdenom);
	}
	
	dfdx = dedx + dgdx;
	return(dfdx);
}
//_____________________________________________________________________________
/**
 * Compute the stiffness of the exponential barrier with respect to changes
 * in v.
 */
double rdSprings::
ExponentialBarrierDV(double aG0,double aG1,double aG2,
	double aE0,double aE1,double aE2,
	double aKV,double aV,double aDX)
{
	// DAMP VELOCITY TOWARD THE BARRIER
	// The function g brings the damping into effect gradually.
	double dfdv = 0.0;
	double dg,g;
	if(aV<0.0) {
		dg = aDX - aG0;
		g = 1.0 / (1.0+aG1*exp(aG2*dg));
		dfdv = -aKV * g;
	}
	
	return(dfdv);
}



//-----------------------------------------------------------------------------
// OSCILLATION
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Return an oscilation amplitude as a function of time.
 *
 * The returned amplitued oscillates about 0.0 with an amplitude of
 * 1.0 (i.e., between 0.5 and 1.5) with a frequency of f.  If t is
 * less than or equal to delay, 0.0 is returned.
 */
double rdSprings::
oscillation(double delay,double t,double f)
{
	// LESS THAN OR EQUAL TO DELAY
	if(t<=delay) {
		return(0.0);
	}

	// GREATER THAN DELAY
	double a = sin(TWOPI*f*(t-delay));
	return(a);
}
