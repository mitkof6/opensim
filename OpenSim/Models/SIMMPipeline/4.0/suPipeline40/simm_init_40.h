// simm_init.h
// Joon H. Shim shimm@stanford.edu

#ifndef __simm_init_40_h__
#define __simm_init_40_h__

//-----------------------------------------------------------------------------
#ifdef __cplusplus

extern "C" {
#endif
//-----------------------------------------------------------------------------
//=============================================================================
// INCLUDES
//=============================================================================
#include <universal.h>

//=============================================================================
//=============================================================================
/**
 * This file contains several utility functions that are
 * independent of the musculoskeletal model in the simulation.
 * This file is from main.c generated by SIMM when you choose the
 * "project files" option in the "Save Dynamics" dialog box.
 * 
 * @authors  Peter Loan, Krystyne Blaikie
 * @modifiers Joon Shim, Frank C. Anderson
 * @version 1.0
 */

//=============================================================================
// METHODS
//=============================================================================
//public:
	void calc_derivatives(double t, double y[], double dy[], 
							 double param[], int *status);
	int sduforce(double t, double q[], double u[]);
	int sdumotion(double t, double q[], double u[]);
	void sduperr(double t, double q[], double errors[]);
	void sduverr(double t, double q[], double u[], double errors[]);
	void sduaerr(double t, double q[], double u[], 
				 double udot[], double errors[]);
	void sduconsfrc(double t, double q[], double u[], double mults[]);
	void init_model(void);
	void init_motion(void);
	void set_initial_conditions(double *t, double y[], double dy[]);
	void assemble_model(double t, double y[]);
	void set_up_kinetics_input(char filename[], MotionData** data);

//-----------------------------------------------------------------------------
#ifdef __cplusplus
}
#endif
//-----------------------------------------------------------------------------

#endif // #ifndef __simm_init_40_h__
