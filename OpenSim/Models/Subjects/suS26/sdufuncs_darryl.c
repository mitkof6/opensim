/*******************************************************************************

   SDUFUNCS.C

   Authors: Peter Loan
            Krystyne Blaikie

   Copyright (c) 1996-2004 MusculoGraphics, a division of Motion Analysis Corp.
   All rights reserved.

   Description: This file contains the main routine for a dynamics
		simulation, and several other utility functions that are
		independent of the musculoskeletal model in the simulation.
		This file is generated by SIMM when you choose the
		"project files" option in the "Save Dynamics" dialog box.
		You will probably want to generate it once and then customize
		it to your specific simulation.

*******************************************************************************/
#include "universal.h"
#include "model.h"
#include "user_structs.h"

/*************** DEFINES (for this file only) *********************************/

/* Tolerances and Integration parameters. */
#define ASSEMBLY_TOL 1e-7

/*************** STATIC GLOBAL VARIABLES (for this file only) *****************/
static char* fiberlength_suffix = "_mlen";
static char* excitation_suffix = "_exc";

/**************** GLOBAL VARIABLES (used in only a few files) *****************/


/*************** EXTERNED VARIABLES (declared in another file) ****************/
extern SystemInfo si;
extern MotionData* kinetics_data;
extern dpSimulationParameters params;
extern dpModelStruct* sdm;
extern char buffer[];

extern int sim_message( ErrorAction action, const char* format, ... );

/*************** PROTOTYPES for STATIC FUNCTIONS (for this file only) *********/
static int name_is_muscle(char name[], dpModelStruct* sdm, char suffix[]);
void get_ground_reactions(double time,MotionData* data,ForceVecStruct* grf,TorqueVecStruct* grt);
void apply_ground_reactions(ForceVecStruct* grf,TorqueVecStruct* grt,int num_forces,int num_torques);
void resplineFitQData(dpModelStruct* sdm,MotionData* data,double cutoffFrequency);
void resplineFitExtForces(dpModelStruct* sdm,MotionData* data,double cutoffFrequency);
void resplineFitExtTorques(dpModelStruct* sdm,MotionData* data,double cutoffFrequency);
ReturnCode reinit_spline_func(dpSplineFunction* sf, dpSplineType type,double cutoffFrequency);
void setInitStates(dpModelStruct* sdm,MotionData* data,double y[],double t);
void computeConstrainedCoords(dpModelStruct* sdm,double* y);
void swapMuscleActExc(dpModelStruct* sdm,MotionData *data);


void adjust_ground_reactions(ForceVecStruct* grf,TorqueVecStruct* grt,double *kx,double *bx,
							 double *kt,double *bt);
void computeGRSpringForces(int j1,int j2,double btcp[],double force[],double kx[],double bx[]);
void computeGRSpringTorques(int j1,int j2,double torque[],double kt[],double bt[]);

void convert_omega_to_qdot123(int body,double *omega,double *qdot);
void convert_torque123_to_torqueVec(int body,double *tor123,double *tor);
void compute_body123(int body,double *E);

/*******************************************************************************/


/* This routine (called by integrate()) computes system derivatives, given the 
 * time and state of the system.  It returns a user flag if impacts are found.
 */
void calc_derivatives(double t, double y[], double dy[], double param[], int *status)
{
   int i, err;
#if CONTACT_DETECTION
   int calc_impact = NO;
#endif

	*status = NO_FLAG;

	sdstate(t, y, &y[sdm->nq]);
	err = check_for_sderror("CALC_DERIVATIVES");
	if (err)
      goto allDone;

	// DT - Compute the current muscle-tendon lengths and velocities a priori
	// since these are not computed in the derivs function used in cmc
	for (i=0;i<sdm->num_muscles;i++) {
		check_wrapping_points(&sdm->muscles[i], y);
		calc_muscle_tendon_length(&sdm->muscles[i]);
		calc_muscle_tendon_velocity(&sdm->muscles[i]);
	}

	/* calc muscle derivatives */
	calc_muscle_derivatives(t, y, dy, param, &err);

	sdumotion(t, y, &y[sdm->nq]);
	sduforce(t, y, &y[sdm->nq]);
	sdderiv(dy, &dy[sdm->nq]);

#if CONTACT_DETECTION
	/* determine contact points */
	determine_contacts(y, dy);
	get_contact_info();
   get_bilat_contact_info();

	if (sdm->num_contacts == 0)
      goto allDone;

   /* Check for impacts. If any are found, set the flag and return. */
   if (param[0] < 0.0)
   {
      for (i = 0; i < sdm->num_contacts; i++)
      {
         if ((sdm->contacts[i].contact_type == dpImpact))
         {
            *status = IMPACT_FLAG;
            goto allDone;
         }
      }
   }

	/* if no impacts were found, find resting contact forces, apply them,
	 * and calculate accelerations
    */
	sdstate(t, y, &y[sdm->nq]);
	sdumotion(t, y, &y[sdm->nq]);
	sduforce(t, y, &y[sdm->nq]);

   compute_contact_forces(calc_impact);
	apply_forces_at_contacts(sdm->num_contacts, sdm->contacts);

	sdderiv(dy, &dy[sdm->nq]);
#endif

	err = check_for_sderror("CALC_DERIVATIVES: alldone");

allDone:
    /* We're done with calculating derivatives.  If an error occurred, we'll
     * assume it means the integrator picked a bad time/state for this guess,
     * and we'll reject the guess.  This will make the integrator cut its
     * step size, hopefully producing a better guess next time.
     *
     * If the error is "singular mass matrix" we'll ignore it, however,
     * since in this case that's just an artifact of our use of massless
     * frames when in certain configurations and does not actually cause
     * problems.
     *
     * If we reject this guess, we'll clear out dy[] which may contain
     * garbage (e.g. NaNs) resulting from the bad state.
     */
	if (err == 43 || err == 44)
   {
      print_final_information(t, y, dy, &si);
      sim_message(exit_program, "A joint is in gimbal lock.");
   }
   if ((err != 0) && (err != 47))
   {
		sim_message(none, "BAD STATE");
		print_state(y, dy);
		*status = BAD_STATE;
		sim_message(exit_program, "deriv");
   } 

}


/* SDUFORCE: this function is used to apply forces to the body segments.
 * The first section of code determines the current frame for the external
 * force data, if any exist. You may want to change this code, depending
 * on what type of external force[s] you want to apply, and how many
 * frames of data there are. Sduforce() then calls the functions to
 * apply the muscles forces, the restraint torques, and the external
 * forces, respectively.  It also calls the functions to apply spring
 * forces for spring-based contact.
 */

int sduforce(double t, double q[], double u[])
{
	ForceVecStruct grf[2];
	TorqueVecStruct grt[2];

	if (kinetics_data) {
		// Skip the force mattes approach
		//		apply_external_forces(t, kinetics_data);
		// Instead specify the segments directly to which the ground reactions act
		get_ground_reactions(t,kinetics_data,grf,grt);
//		adjust_ground_reactions(grf,grt,kx,bx,kt,bt);
		apply_ground_reactions(grf,grt,kinetics_data->num_forces,kinetics_data->num_torques);
	}

	
   apply_muscle_forces(sdm);

   apply_joint_restraint_torques(sdm, q, u);

   apply_spring_forces(sdm);

   check_for_sderror("SDUFORCE");

   return 1;
}

/* Apply prescribed motions to fixed and prescribed gencoords */
int sdumotion(double t, double q[], double u[])
{

   set_fixed_gencoords(sdm);

   set_prescribed_gencoords(t, q, u, sdm, kinetics_data);

   return 1;

}


/* calculate position errors for constrained gencoords */
void sduperr(double t, double q[], double errors[])
{
   int i, j, q_ind, constraint_num;
   double q_ind_value, q_dep_value, q_value, u_ind_value = 0.0, a_ind_value = 0.0;
   dpConstraintObject *co;

   /* constrained gencoords */
   for (i=0; i<sdm->nq; i++)
   {
      if (sdm->q[i].type == dpConstrainedQ)
      {
         q_ind = sdm->q[i].q_ind;
         q_ind_value = q[q_ind] * sdm->q[q_ind].conversion;
         q_dep_value = q[i];
         q_value = interpolate_spline(q_ind_value, sdm->q[i].constraint_func,
            zeroth, u_ind_value, a_ind_value) / sdm->q[i].conversion;
         errors[sdm->q[i].constraint_num] = q_dep_value - q_value;
      }
   }

   /* constraint objects */
   for (i = 0; i < sdm->num_constraint_objects; i++)
   {
      co = &sdm->constraint_object[i];
      if (co->active == dpNo)
         continue;
      for (j = 0; j < co->numPoints; j++)
      {
         constraint_num = co->points[j].constraint_num;
         errors[constraint_num] = calculate_constraint_position_error(co, PERR, j);
      }
   }
}


/* calculate velocity errors for constrained gencoords */
void sduverr(double t, double q[], double u[], double errors[])
{
   int i, j, q_ind, constraint_num;
   double q_ind_value, u_ind_value, u_dep_value, a_ind_value = 0.0, v_value;
   dpConstraintObject *co;

   /* constrained gencoords */
   for (i=0; i<sdm->nq; i++)
   {
      if (sdm->q[i].type == dpConstrainedQ)
      {
         q_ind = sdm->q[i].q_ind;
         q_ind_value = q[q_ind] * sdm->q[q_ind].conversion;
         u_ind_value = u[q_ind] * sdm->q[q_ind].conversion;
         u_dep_value = u[i];
         v_value = interpolate_spline(q_ind_value, sdm->q[i].constraint_func,
            first, u_ind_value, a_ind_value)/sdm->q[i].conversion;
         errors[sdm->q[i].constraint_num] = u_dep_value - v_value;
      }
   }

   /* constraint objects */
   for (i = 0; i < sdm->num_constraint_objects; i++)
   {
      co = &sdm->constraint_object[i];
      if (co->active == dpNo)
         continue;
      
      for (j = 0; j < co->numPoints; j++)
      {
         constraint_num = co->points[j].constraint_num;
         errors[constraint_num] = calculate_constraint_velocity_error(co, j);
      }
   }
}



/* calculate acceleration errors for constrained gencoords */
void sduaerr(double t, double q[], double u[], double udot[], double errors[])
{
   int i, j, q_ind, constraint_num;
   double q_ind_value, u_ind_value, a_ind_value, a_dep_value;
   double a_value;
   dpConstraintObject *co;

   /* constrained gencoords */
   for (i=0; i<sdm->nq; i++)
   {
      if (sdm->q[i].type == dpConstrainedQ)
      {
	      q_ind = sdm->q[i].q_ind;
	      q_ind_value = q[q_ind] * sdm->q[q_ind].conversion;
	      u_ind_value = u[q_ind] * sdm->q[q_ind].conversion;
	      a_ind_value = udot[q_ind] * sdm->q[q_ind].conversion;
	      a_dep_value = udot[i];
         a_value = interpolate_spline(q_ind_value, sdm->q[i].constraint_func, second,
            u_ind_value, a_ind_value)/sdm->q[i].conversion;
         errors[sdm->q[i].constraint_num] = a_dep_value - a_value;
      }
   }

   /* constraint objects */
   for (i = 0; i < sdm->num_constraint_objects; i++)
   {
      co = &sdm->constraint_object[i];
      if (co->active == dpNo)
         continue;
      
      for (j = 0; j < co->numPoints; j++)
      {
         constraint_num = co->points[j].constraint_num;
         errors[constraint_num] = calculate_constraint_acceleration_error(co, j);
      }
   }
}


/* calculate and apply constraint forces for constrained gencoords */
void sduconsfrc(double t, double q[], double u[], double mults[])
{
   int i, j, q_ind, constraint_num;
   double q_ind_value, torque, u_ind_value, a_ind_value = 0.0, int_spline;
   dpConstraintObject *co;
 
   for (i=0; i<sdm->nq; i++)
   {
      if (sdm->q[i].type == dpConstrainedQ)
      {
         q_ind = sdm->q[i].q_ind;
         q_ind_value = q[q_ind] * sdm->q[q_ind].conversion;
         u_ind_value = sdm->q[q_ind].conversion;

	      sdhinget(sdm->q[i].joint,sdm->q[i].axis,mults[sdm->q[i].constraint_num]);

         int_spline = interpolate_spline(q_ind_value, sdm->q[i].constraint_func,
            first, u_ind_value, a_ind_value) / sdm->q[i].conversion;
         torque = -mults[sdm->q[i].constraint_num] * int_spline;

         sdhinget(sdm->q[q_ind].joint,sdm->q[q_ind].axis,torque);
      }
   }

   /* constraint objects */
   for (i = 0; i < sdm->num_constraint_objects; i++)
   {
      co = &sdm->constraint_object[i];
      if (co->active == dpNo)
         continue;

      for (j = 0; j < co->numPoints; j++)
      {
         constraint_num = co->points[j].constraint_num;
         apply_constraint_forces(co, mults[constraint_num], j);
      }
   }
   check_for_sderror("SDUCONSFRC");

}

/************* Initialization Routines **************/

/* Set on/off state of prescribed motion for all Qs based on their types */
void init_motion(void)
{

   set_prescribed_motion(sdm, dpUnconstrainedQ, 0);
   set_prescribed_motion(sdm, dpConstrainedQ, 0);
   set_prescribed_motion(sdm, dpPrescribedQ, 1); 
   set_prescribed_motion(sdm, dpFixedQ, 1);

   check_for_sderror("INIT_MOTION");

}


/* Set initial conditions for all Qs in the model. The initial values
 * and velocities of all Qs, regardless of type, are set here. Values
 * for unconstrained Qs are taken from the 'initial_value' field in the
 * sdm struct.
 */
void set_initial_conditions(double *t, double y[], double dy[])
{

   int i;
   double q_ind_value;

   *t = params.startTime;

   for (i = 0; i < sdm->neq; i++)
      y[i] = dy[i] = 0.0;
	
   for (i = 0; i < sdm->nq; i++)
   {
      if (sdm->q[i].type != dpConstrainedQ)
      {
         y[i] = sdm->q[i].initial_value/sdm->q[i].conversion;
      }
   }

   for (i = 0; i < sdm->nq; i++)
   {
      if (sdm->q[i].type == dpConstrainedQ)
      {
         if (sdm->q[i].constraint_func == NULL)
            sim_message(exit_program, "Constrained gencoord %s does not have a function defined.", sdm->q[i].name);

         if (sdm->q[i].constraint_num == -1)
            sim_message(exit_program, "Constrained gencoord %s does not have an associated constraint number.", sdm->q[i].name);

         if (sdm->q[i].q_ind == -1)
            sim_message(exit_program, "Constrained gencoord %s does not have an independent q.", sdm->q[i].name);

         q_ind_value = y[sdm->q[i].q_ind] * sdm->q[sdm->q[i].q_ind].conversion;
         y[i] = interpolate_spline(q_ind_value,sdm->q[i].constraint_func,zeroth,0.0,0.0) / sdm->q[i].conversion;
      }
   }

   for (i = 0; i < sdm->nq; i++) 
   {
      if (sdm->q[i].type != dpFixedQ)
      {
         y[i + sdm->nq] = dy[i] = sdm->q[i].initial_velocity / sdm->q[i].conversion;
      }
      else
      {
         if (sdm->q[i].initial_velocity != 0.0)
            sim_message(none, "Warning: initial velocity for %s (FIXED) was not 0.0. Setting to zero...",
                        sdm->q[i].name);
         y[i + sdm->nq] = dy[i] = 0.0;
      }
   }
}


/* Assmeble the model, and make sure the gencoord velocities
 * are properly set.
 */
void assemble_model(double t, double y[])
{
   int i, fcnt, err, *lock;

   lock = (int*)simm_malloc(sdm->nq * sizeof(int));

   for (i = 0; i < sdm->nq; i++)
   {
      if (sdm->q[i].type == dpFixedQ)
         lock[i] = 1;
      else
         lock[i] = 0;
   }

   /* assemble model */
   sdassemble(t, y, lock, ASSEMBLY_TOL, 500, &fcnt, &err);
   if (err)
   {
      sim_message(none, "Assembly failed, err = %d.", err);
      sim_message(none, "Closest solution:");
      for (i = 0; i < sdm->nu; i++)
         sim_message(none, "%s = %lf (%d)", sdm->q[i].name, y[i], lock[i]);
      sim_message(exit_program, "");
   }

   /* You may want to call verify_assembly() if you know for sure that
    * none of the gencoords should be outside their range of motion.
   if (verify_assembly(sdm,y) == code_bad)
      sim_message(exit_program, "Verify assembly failed.");
    */

   sdinitvel(t, y, lock, ASSEMBLY_TOL, 500, &fcnt, &err);
   if (err)
   {
      sim_message(none, "Velocity analysis failed.");
      sim_message(exit_program, "Check that prescribed gencoord velocities are not being set to new values.");
   }

   free(lock);

}



void set_up_kinetics_input(char filename[], MotionData** data)
{
   int i, index_pres = -1;
   double grfCutoffFrequency, kinCutoffFrequency;

   if ((*data = (MotionData*)simm_calloc(1, sizeof(MotionData))) == NULL)
   {
      sim_message(exit_program, "Unable to allocate enough memory to run.");
      return;
   }
   else if (load_kinetics_data(sdm, *data, filename) == code_bad)
   {
      /* You could try to recover from an error reading the kinetics/motion
       * file, but it's probably serious enough to exit and make the user
       * fix the problem.
       */
      free_motion_data(*data);
      FREE_IFNOTNULL(*data);
      sim_message(exit_program, "Encountered fatal error while reading %s.", filename);
      return;
   }

   /* If there is position, velocity, and acceleration data for a Q in the
    * kinetics file, make it prescribed.
    */
   if ((*data)->q_data)
   {
      int position_present, velocity_present, acceleration_present;

      for (i = 0; i < sdm->nq; i++)
      {
         /* Position data must be explicitly specified (though it can be splined or not).
          * Velocity can either be specified explicitly, or calculated from position
          * (if position data is splined). Acceleration can be specified explicitly or
          * calculated from position or velocity.
          */
         position_present = (int)((*data)->q_data[i]);
         velocity_present = (*data)->u_data[i] ||
                            ((*data)->q_data[i] && (*data)->q_data[i]->type != dpStepFunction);
         acceleration_present = (*data)->udot_data[i] ||
                                ((*data)->q_data[i] && (*data)->q_data[i]->type != dpStepFunction) ||
                                ((*data)->u_data[i] && (*data)->u_data[i]->type != dpStepFunction);

         if (sdm->q[i].type == dpFixedQ)
         {
            if (position_present || velocity_present || acceleration_present)
            {
               sim_message(recover, "Warning: Pos, vel, and/or acc data for fixed Q %s was specified in %s.",
                      sdm->q[i].name, filename);
               sim_message(none, "Data will be ignored.");
            }
         }
         else if (sdm->q[i].type == dpConstrainedQ)
         {
            if (position_present || velocity_present || acceleration_present)
            {
               sim_message(recover, "Warning: Pos, vel, and/or acc data for constrained Q %s was specified in %s.",
                      sdm->q[i].name, filename);
               sim_message(none, "Data will be ignored.");
            }
         }
         else
         {
            if (position_present && velocity_present && acceleration_present)
            {
               sdm->q[i].type = dpPrescribedQ;
               index_pres = i;
            }
            else if (position_present || velocity_present || acceleration_present)
            {
               if (!position_present)
               {
                  sim_message(recover, "Warning: Position data for %s was not specified in %s.",
                     sdm->q[i].name, filename);
                  sim_message(none, "Gencoord will not be prescribed.");
               }
			   /*
               else if (!velocity_present)
               {
                  sim_message(recover, "Warning: Velocity data for %s was not specified in %s.",
                     sdm->q[i].name, filename);
                  sim_message(none, "Gencoord will not be prescribed.");
               }
               else if (!acceleration_present)
               {
                  sim_message(recover, "Warning: Acceleration data for %s was not specified in %s.",
                     sdm->q[i].name, filename);
                  sim_message(none, "Gencoord will not be prescribed.");
               }
			   */
            }
         }
      }
   }

   /* If all unconstrained gencoords are prescribed with data in the
    * kinetics file, then this is really more of an inverse dynamics
    * simulation than a forward one. So override the default values
    * of params.start_time, params.end_time, and params.step_size to
    * match the data in the kinetics file.
    */
//   for (i = 0; i < sdm->nq; i++)
//   {
//      if (sdm->q[i].type == dpUnconstrainedQ)
//         break;
//   }
//   if (i == sdm->nq)
//   {
      /* No gencoords are left as unconstrained. Use index_pres, which is the
       * index of one of the Qs that is prescribed in the file, to get the
       * time of the first and last frames of data in the file. Divide this
       * time range by the number of frames to get the step size (reporting
       * interval) for the integrator.
       */

      params.startTime = (*data)->motiondata[(*data)->time_index][0];
      params.endTime = (*data)->motiondata[(*data)->time_index][(*data)->num_frames-1];
	  //  params.stepSize = (params.endTime - params.startTime) / ((*data)->q_data[index_pres]->numpoints - 1);
	  // DT changed since we want the step size to be what it actually is in the data, not an average step size
      params.stepSize = (*data)->motiondata[(*data)->time_index][1] - (*data)->motiondata[(*data)->time_index][0];
      sim_message(none, "Based on motion data specified in %s.", filename);
      sim_message(none, "   Changing:");
      sim_message(none, "      start time to %lf", params.startTime);
      sim_message(none, "      end time to   %lf", params.endTime);
      sim_message(none, "      step size to  %lf", params.stepSize);
//   }

   	// DT - We need to spline fit the ground reaction data so that it is a continuous function
	// Also spline fit the q data since the virtual feet motion is prescribed
    grfCutoffFrequency = 40;
	kinCutoffFrequency = 40;
	resplineFitQData(sdm,*data,kinCutoffFrequency);
	resplineFitExtForces(sdm,*data,grfCutoffFrequency);
	resplineFitExtTorques(sdm,*data,grfCutoffFrequency);

}



void init_gaitsim(dpModelStruct* sdm, MotionData* data,double t,double *y) {

	int i, j, k, frame, mus;

	// First unconstrain all the gait model degrees of freedom
	for (i=0;i<sdm->nq;i++)
      if (sdm->q[i].type == dpPrescribedQ)
		  sdm->q[i].type = dpUnconstrainedQ;

	// Now re-prescribe the toe joint and virtual feet degrees of freedom
	sdm->q[subtalar_angle_r].type = dpPrescribedQ;
	sdm->q[subtalar_angle_l].type = dpPrescribedQ;
	sdm->q[mtp_angle_r].type = dpPrescribedQ;
	sdm->q[mtp_angle_l].type = dpPrescribedQ;
	sdm->q[calcn_r_tx].type = dpPrescribedQ;
	sdm->q[calcn_r_ty].type = dpPrescribedQ;
	sdm->q[calcn_r_tz].type = dpPrescribedQ;
	sdm->q[calcn_r_r1].type = dpPrescribedQ;
	sdm->q[calcn_r_r2].type = dpPrescribedQ;
	sdm->q[calcn_r_r3].type = dpPrescribedQ;
	sdm->q[calcn_l_tx].type = dpPrescribedQ;
	sdm->q[calcn_l_ty].type = dpPrescribedQ;
	sdm->q[calcn_l_tz].type = dpPrescribedQ;
	sdm->q[calcn_l_r1].type = dpPrescribedQ;
	sdm->q[calcn_l_r2].type = dpPrescribedQ;
	sdm->q[calcn_l_r3].type = dpPrescribedQ;

	// Set prescribed and unconstrained gencoords
	for (i=0;i<sdm->nq;i++) {
		if (sdm->q[i].type==dpPrescribedQ)
			sdpres(sdm->q[i].joint,sdm->q[i].axis,1);
		if (sdm->q[i].type==dpUnconstrainedQ)
			sdpres(sdm->q[i].joint,sdm->q[i].axis,0);
	}

	// Set the generalized coordinates and generalized speeds to the initial values in the motion file
	setInitStates(sdm,data,y,t);

	// Set the initial muscle states
	frame=0;

	// Pipeline reader by default classifies activations as excitations
	// Use this to set the initial activation states
	for (j=0; j<sdm->num_muscles; j++)
		sdm->muscles[j].dynamic_activation=data->musc_excitations[j]->y[frame];

	// Now scan for setting the other states - the initial fiber lengths
	for (j=0; j<data->num_elements; j++) {
		if ((mus = name_is_muscle(data->elementnames[j], sdm, fiberlength_suffix)) != -1)
			sdm->muscles[mus].fiber_length=data->motiondata[j][frame];
	}

   	// DT - Motion data file reader classifies muscle activations as excitations in a forward simulations
	//      Swap in the actual muscle excitations which have the excitation suffix
	for (i=0;i<sdm->num_muscles;i++) {
		for (j=0; j<data->num_elements; j++) {
			if ((name_is_muscle(data->elementnames[j], sdm, excitation_suffix)) == i) {
				// do the swap
				for (k=0;k<data->num_frames;k++)
					data->musc_excitations[i]->y[k] = data->motiondata[j][k];
			}
		}
	}

}



/* Get the ground reaction forces and torques that are acting on the feet
 */
void get_ground_reactions(double time,MotionData* data,ForceVecStruct* grf,TorqueVecStruct* grt) {
   int i, jc[2];
   jc[0]=calcn_r;
   jc[1]=calcn_l;
   /* Get the values */
   for (i=0;i<data->num_forces;i++) {
		get_applied_force(time,data,i,&grf[i].appl_point[0],&grf[i].force_vec[0]);
		grf[i].refSegment = data->forces[i]->segment;
		grf[i].applSegment = jc[i];
   }
   /* Get the values */
   for (i=0;i<data->num_torques;i++) {
		get_applied_torque(time,data,i, &grt[i].torque_vec[0]);
		grt[i].refSegment = data->torques[i]->segment;
		grt[i].applSegment = jc[i];
   }
}



void apply_ground_reactions(ForceVecStruct* grf,TorqueVecStruct* grt,int num_forces,int num_torques) {
   int i, j, jc;
	double force[3], pt[3], com[3], torque[3];
	com[0]=com[1]=com[2]=0.;

	for (i=0;i<num_forces;i++) {
		jc=grf[i].applSegment;
		sdpos(jc,com,pt);
		for (j=0;j<3;j++)
			pt[j] = grf[i].appl_point[j]-pt[j];
		sdtrans(grf[i].refSegment,pt,jc,pt);
		sdtrans(grf[i].refSegment,&grf[i].force_vec[0],jc,force);
		sdpointf(jc,pt,force);
	}

	for (i=0;i<num_torques;i++) {
		jc=grt[i].applSegment;
		sdtrans(grt[i].refSegment,&grt[i].torque_vec[0],jc,torque);
		sdbodyt(jc,torque);
	}
}

void resplineFitQData(dpModelStruct* sdm,MotionData* data,double cutoffFrequency) {

	int i;
	dpSplineType splineType;
    splineType = dpGCVSpline;
	for (i=0;i<sdm->nq;i++) {
		if (data->q_data[i]!=NULL) {
			if (reinit_spline_func(data->q_data[i], splineType, cutoffFrequency) == code_bad)
				sim_message(exit_program, "Error resetting up spline functions for q data.");
			 if (finish_spline_func(data->q_data[i]) == code_bad)
				sim_message(exit_program, "Error finishing spline functions for q data.");
		}
	}
}


void resplineFitExtForces(dpModelStruct* sdm,MotionData* data,double cutoffFrequency) {

	int i, j;
	dpSplineType splineType;
    splineType = dpGCVSpline;
	for (i=0;i<data->num_forces;i++) {
		for (j=0;j<3;j++) {

			if (reinit_spline_func(&data->forces[i]->force_vec[j], splineType, cutoffFrequency) == code_bad)
				sim_message(exit_program, "Error resetting up spline functions for forces data.");
			 if (finish_spline_func(&data->forces[i]->force_vec[j]) == code_bad)
				sim_message(exit_program, "Error finishing spline functions for forces data.");

			 if (reinit_spline_func(&data->forces[i]->appl_point[j], splineType, cutoffFrequency) == code_bad)
				sim_message(exit_program, "Error resetting up spline functions for force appl point data.");
			 if (finish_spline_func(&data->forces[i]->appl_point[j]) == code_bad)
				sim_message(exit_program, "Error finishing spline functions for force appl point data.");
		}
	}
}


void resplineFitExtTorques(dpModelStruct* sdm,MotionData* data,double cutoffFrequency) {

	int i, j;
	dpSplineType splineType;
    splineType = dpGCVSpline;
	for (i=0;i<data->num_torques;i++) {
		for (j=0;j<3;j++) {
			if (reinit_spline_func(&data->torques[i]->torque_vec[j], splineType, cutoffFrequency) == code_bad)
				sim_message(exit_program, "Error resetting up spline functions for torque data.");
			 if (finish_spline_func(&data->torques[i]->torque_vec[j]) == code_bad)
				sim_message(exit_program, "Error finishing spline functions for torque data.");
		}
	}
}


ReturnCode reinit_spline_func(dpSplineFunction* sf, dpSplineType type,double cutoffFrequency)
{
   int i;

   sf->type = type;
   sf->cutoff_frequency = cutoffFrequency;

   if (sf->type == dpNaturalCubic)
   {
	   if (sf->b==NULL) {
	      if ((sf->b = (double*)simm_malloc(sf->numpoints*sizeof(double))) == NULL)
		     return code_bad;
	   }
	   if (sf->c==NULL) {
	      if ((sf->c = (double*)simm_malloc(sf->numpoints*sizeof(double))) == NULL)
		     return code_bad;
	   }
	   if (sf->d==NULL) {
			if ((sf->d = (double*)simm_malloc(sf->numpoints*sizeof(double))) == NULL)
				return code_bad;
	   }
   }
   else if (sf->type == dpGCVSpline)
   {
	   if (sf->c==NULL) {
	      if ((sf->c = (double*)simm_malloc(sf->numpoints*sizeof(double))) == NULL)
		     return code_bad;
	   }
   }

   return code_fine;
}


// Set the experimental states at initial time frame
void setInitStates(dpModelStruct* sdm,MotionData* data,double y[],double t) {
	int i;
	for (i=0;i<sdm->nq;i++) {
		if ((sdm->q[i].type==dpUnconstrainedQ) || (sdm->q[i].type==dpPrescribedQ)) { 
			if (data->q_data[i]->defined) {
				y[i] = data->q_data[i]->y[0]/sdm->q[i].conversion;
//				y[i] = interpolate_spline(t,data->q_data[i],zeroth,0.0,0.0)/sdm->q[i].conversion;
//				y[i+sdm->nq] = interpolate_spline(t,data->q_data[i],first,0.0,0.0)/sdm->q[i].conversion;
			}
			else {
				y[i] = 0.;
//				y[i+sdm->nq] = 0.;
			}
			if (data->u_data[i]->defined)
				y[i+sdm->nq] = data->u_data[i]->y[0]/sdm->q[i].conversion;
			else
				y[i+sdm->nq] = 0.;
		}
	}
	computeConstrainedCoords(sdm,y);
}


void computeConstrainedCoords(dpModelStruct* sdm,double* y) {
	int i;
	double q_ind_value, u_ind_value;
	for (i=0;i<sdm->nq;i++) {
		if (sdm->q[i].type == dpConstrainedQ) {
			q_ind_value = y[sdm->q[i].q_ind] * sdm->q[sdm->q[i].q_ind].conversion;
			y[i] = interpolate_spline(q_ind_value,sdm->q[i].constraint_func,zeroth,0.0,0.0) / sdm->q[i].conversion;
			u_ind_value = y[sdm->nq+sdm->q[i].q_ind];
			y[i+sdm->nq] = u_ind_value * interpolate_spline(q_ind_value,sdm->q[i].constraint_func,first,0.0,0.0) / sdm->q[i].conversion;
	    }
   }
}


/* NAME_IS_MUSCLE: this routine checks to see if a string is the name
 * of one of the model's muscles, with an optional suffix and also
 * possibly the extra suffix "_spl" or "_gcv" (possibly followed a cutoff
 * frequency). It returns the index of the muscle if there is a match.
 */

static int name_is_muscle(char name[], dpModelStruct* sdm, char suffix[])
{
   int i, len, lenM, Mnum, index, maxLen;
   char* ptr;

   len = strlen(name);

   /* First check to see if the string begins with the name of a muscle.
    * To handle models which have overlapping muscle names, like
    * "trap1" and "trap10", check for a match with all muscles, and take
    * the longest match.
    */
   for (i = 0, index = -1, maxLen = -1; i < sdm->num_muscles; i++)
   {
      lenM = strlen(sdm->muscles[i].name);
      if (len >= lenM)
      {
         if (!strncmp(name, sdm->muscles[i].name, lenM))
         {
            if (lenM > maxLen)
            {
               index = i;
               maxLen = lenM;
            }
         }
      }
   }

   if (index == -1)
      return -1;

   /* You've found a matching muscle name, so move ptr past the name and
    * get ready to check the suffixes.
    */
   Mnum = index;
   ptr = &name[maxLen];
   len -= maxLen;

   /* If a suffix was passed in, check to see if the name ends in that suffix.
    * If it does, remove the suffix and continue on. If it does not, return -1
    * because the suffix is not optional.
    */
   if (suffix)
   {
      int suffix_len = strlen(suffix);

      if (len >= suffix_len)
      {
         if (!strncmp(ptr, suffix, suffix_len))
         {
            ptr += suffix_len;
            len -= suffix_len;
         }
         else
         {
            return -1;
         }
      }
      else
      {
         return -1;
      }
   }

   /* If there are extra characters after the suffixes, return an error. */
   if (len > 0)
      return -1;

   return Mnum;
}

#if 0

/* Computes the ground reaction forces and torques acting on the feet
	Net forces and torques is a sum of the experimental values plus a 
	spring-damper component due to not tracking the prescribed feet
	trajectories exactly
 */
void adjust_ground_reactions(ForceVecStruct* grf,TorqueVecStruct* grt,double *kx,double *bx,
							 double *kt,double *bt) {
   int i, j, jcp[2], jc[2];
   double alpha[2];
   double df[2][3], dt[2][3];
   double com[3],pos[2][3],btcp[2][3];

   jc[0]=calcn_r;
   jc[1]=calcn_l;
   jcp[0]=calcn_rp;
   jcp[1]=calcn_lp;

   // Actual forces and torque deviations are scaled by the percent of the grf support 
	alpha[0] = grf[0].force_vec[1]/(grf[0].force_vec[1]+grf[1].force_vec[1]);
	if (alpha[0]>1.)
		alpha[0]=1;
	if (alpha[0]<0.)
		alpha[0]=0.;
	alpha[1]=1.-alpha[0];

   // Compute the passive spring-damper constraints
   // First find the local coordinates on the virtual feet
   // Then compute the spring-damper force and torque deviations
	com[0]=com[1]=com[2]=0.;
	for (i=0;i<2;i++) {
		sdpos(jcp[i],com,&pos[i][0]);
		for (j=0;j<3;j++)
			btcp[i][j]=grf[i].appl_point[j]-pos[i][j];
		sdtrans(GROUND,&btcp[i][0],jcp[i],&btcp[i][0]);
		computeGRSpringForces(jcp[i],jc[i],&btcp[i][0],&df[i][0],kx,bx);
		computeGRSpringTorques(jcp[i],jc[i],&dt[i][0],kt,bt);
		for (j=0;j<3;j++) {
			grf[i].force_vec[j] += alpha[i]*df[i][j];
			grt[i].torque_vec[j] += alpha[i]*dt[i][j];
		}
		// Project the body-to-center-of-pressure point onto the actual feet 
		// to get the actual force application point
		sdpos(jc[i],&btcp[i][0],&grf[i].appl_point[0]);
		if (alpha[i]>0.01) {
			grf[i].appl_point[0] += grt[i].torque_vec[2]/grf[i].force_vec[1];
			grf[i].appl_point[2] -= grt[i].torque_vec[0]/grf[i].force_vec[1];
		}
		grt[i].torque_vec[2]=0.;
		grt[i].torque_vec[0]=0.;
	}
}




//*****************************************************************************************************
// ComputeGRSpringForces
// This routine computes passive spring-damper forces between bodies j1 and j2
//	Inputs
//		j1 - reference body
//		btcp - spring-damper contact point on the reference body, expressed in the ref body coordinates
//		j2 - the other body
//		kx - spring stiffness in the global x, y and z directions
//		bx - damping coefficients in the global x, y and z directions
//	Outputs
//		force - the force acting on the other body j2 due to the translational spring damper,
//				expressed in the global reference frame
//*****************************************************************************************************
void computeGRSpringForces(int j1,int j2,double btcp[],double force[],double kx[],double bx[]) {

	int i, j, k;
	double q[3], qdot[3], pos1[3], pos2[3], vel1[3], vel2[3], angvel21[3], angvel1[3], angvel2[3];
	double dc1[3][3], dc2[3][3], dc[3][3], t123[3];

	sdpos(j1,btcp,pos1);
	sdpos(j2,btcp,pos2);
	sdvel(j1,btcp,vel1);
	sdvel(j2,btcp,vel2);
	for (i=0;i<3;i++)
		force[i]=kx[i]*(pos1[i]-pos2[i])+bx[i]*(vel1[i]-vel2[i]);
}

//*****************************************************************************************************
// ComputeGRSpringTorques
// This routine computes passive spring-damper torques between bodies j1 and j2
//	Inputs
//		j1 - reference body
//		j2 - the other body
//		kt - spring stiffness about the 1-2-3 rotation axes
//		bt - damping coefficients about the 1-2-3 rotation axes
//	Outputs
//		torque - the torque acting on the other body j2 due to the rotational spring damper
//*****************************************************************************************************
void computeGRSpringTorques(int j1,int j2,double torque[],double kt[],double bt[]) {

	int i, j, k;
	double q[3], qdot[3], angvel21[3], angvel1[3], angvel2[3];
	double dc1[3][3], dc2[3][3], dc[3][3], t123[3];

	// Rotation angles between bodies
	// First compute the direction cosine relating body 2 to body 1
	sdorient(j1,dc1);
	sdorient(j2,dc2);
	for (i=0;i<3;i++) {
		for (j=0;j<3;j++) {
			dc[i][j]=0.;
			for (k=0;k<3;k++) {
				dc[i][j]+=dc1[k][i]*dc2[k][j];	// dc1_transpose*dc2
			}
		}
	}
	// Now determine the 1-2-3 rotation angles to rotate from body 1 to body 2
	sddc2ang(dc,&q[0],&q[1],&q[2]);

	// Angular velocities
	sdangvel(j1,angvel1);
	sdangvel(j2,angvel2);
	sdtrans(j2,angvel2,j1,angvel2);
	for (i=0;i<3;i++)
		angvel21[i] = angvel2[i]-angvel1[i];
	convert_omega_to_qdot123(j1,angvel21,qdot);
	for (i=0;i<3;i++)
		t123[i] = -kt[i]*q[i] - bt[i]*qdot[i];
	convert_torque123_to_torqueVec(j1,t123,torque);
	sdtrans(j1,torque,GROUND,torque);	// Transform to global coordinates

}

//********************************************************************************************************
// convert_omega_to_qdot123
// Converts the angular velocity (expressed in body local frame) to body-fixed 1-2-3 rotational velocities
// QDOT = E * OMEGA
//********************************************************************************************************
void convert_omega_to_qdot123(int body,double *omega,double *qdot) {
	int j, k;
	double Ev[3][3];
	compute_body123(body,&Ev[0][0]);
	for (j=0;j<3;j++) {
		qdot[j]=0.;
		for (k=0;k<3;k++)
			qdot[j]+=Ev[j][k]*omega[k];
	}
}



//********************************************************************************************************
// convert_torque123_to_torqueVec
// Converts the body-fixed 1-2-3 rotational torques to applied torque vector (expressed in body local frame)
// Torque = E'*Torque123
//********************************************************************************************************
void convert_torque123_to_torqueVec(int body,double *tor123,double *tor) {
	int j, k;
	double E[3][3];
	compute_body123(body,&E[0][0]);
	for (j=0;j<3;j++) {
		tor[j]=0.;
		for (k=0;k<3;k++)
			tor[j]+=E[k][j]*tor123[k];
	}
}

//********************************************************************************************************
// Compute the transformation matrix E for describing the angular velocity of the
// body in terms of time derivatives of the euler angles
// Body 3 1-2-3 rotations, Angular velocity expressed in body-fixed reference frame
//   Qdot = E*Omega
//********************************************************************************************************
void compute_body123(int body,double *E) {
	int j;
	double ang[3], dc[3][3];
	sdorient(body,dc);	
	sddc2ang(dc,&ang[0],&ang[1],&ang[2]);
	// Row 1
	j=0;	*(E+j)=cos(ang[2])/cos(ang[1]);
	j++;	*(E+j)=-sin(ang[2])/cos(ang[1]);
	j++;	*(E+j)=0.;
	// Row 2
	j++;	*(E+j)=sin(ang[2]);
	j++;	*(E+j)=cos(ang[2]);
	j++;	*(E+j)=0.;
	// Row 3
	j++;	*(E+j)=-cos(ang[2])*sin(ang[1])/cos(ang[1]);
	j++;	*(E+j)=sin(ang[1])*sin(ang[2])/cos(ang[1]);
	j++;	*(E+j)=1.;

}
#endif
