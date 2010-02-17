/*
 * -----------------------------------------------------------------
 * $Revision: 1.2 $
 * $Date: 2006/11/29 00:05:07 $
 * ----------------------------------------------------------------- 
 * Programmer: Radu Serban @ LLNL
 * -----------------------------------------------------------------
 * Copyright (c) 2006, The Regents of the University of California.
 * Produced at the Lawrence Livermore National Laboratory.
 * All rights reserved.
 * For details, see the LICENSE file.
 * -----------------------------------------------------------------
 * Common header file for the direct linear solvers in KINSOL.
 * -----------------------------------------------------------------
 */

#ifndef _KINDIRECT_H
#define _KINDIRECT_H

#ifdef __cplusplus  /* wrapper to enable C++ usage */
extern "C" {
#endif

#include <sundials/sundials_direct.h>
#include <sundials/sundials_nvector.h>

/*
 * =================================================================
 *              K I N D I R E C T     C O N S T A N T S
 * =================================================================
 */

/* 
 * -----------------------------------------------------------------
 * KINDIRECT return values 
 * -----------------------------------------------------------------
 */

#define KINDIRECT_SUCCESS           0
#define KINDIRECT_MEM_NULL         -1
#define KINDIRECT_LMEM_NULL        -2
#define KINDIRECT_ILL_INPUT        -3
#define KINDIRECT_MEM_FAIL         -4

/* Additional last_flag values */

#define KINDIRECT_JACFUNC_UNRECVR  -5
#define KINDIRECT_JACFUNC_RECVR    -6

/*
 * =================================================================
 *              F U N C T I O N   T Y P E S
 * =================================================================
 */

/*
 * -----------------------------------------------------------------
 * Type: KINDlsDenseJacFn
 * -----------------------------------------------------------------
 *
 * A dense Jacobian approximation function Jac must be of type 
 * KINDlsDenseJacFn. Its parameters are:
 *
 * N        - problem size.
 *
 * u        - current iterate (unscaled) [input]
 *
 * fu       - vector (type N_Vector) containing result of nonlinear
 *            system function evaluated at current iterate:
 *            fu = F(u) [input]
 *
 * J        - dense matrix (of type DlsMat) that will be loaded
 *            by a KINDlsDenseJacFn with an approximation to the
 *            Jacobian matrix J = (dF_i/dy_j).
 *
 * jac_data - pointer to user data - the same as the jac_data
 *            parameter passed to KINDlsSetJacFn.
 *
 * tmp1, tmp2 - available scratch vectors (volatile storage)
 *
 * A KINDlsDenseJacFn should return 0 if successful, a positive 
 * value if a recoverable error occurred, and a negative value if 
 * an unrecoverable error occurred.
 *
 * -----------------------------------------------------------------
 *
 * NOTE: The following are two efficient ways to load a dense Jac:         
 * (1) (with macros - no explicit data structure references)      
 *     for (j=0; j < Neq; j++) {                                  
 *       col_j = DENSE_COL(Jac,j);                                 
 *       for (i=0; i < Neq; i++) {                                
 *         generate J_ij = the (i,j)th Jacobian element           
 *         col_j[i] = J_ij;                                       
 *       }                                                        
 *     }                                                          
 * (2) (without macros - explicit data structure references)      
 *     for (j=0; j < Neq; j++) {                                  
 *       col_j = (Jac->data)[j];                                   
 *       for (i=0; i < Neq; i++) {                                
 *         generate J_ij = the (i,j)th Jacobian element           
 *         col_j[i] = J_ij;                                       
 *       }                                                        
 *     }                                                          
 * A third way, using the DENSE_ELEM(A,i,j) macro, is much less   
 * efficient in general.  It is only appropriate for use in small 
 * problems in which efficiency of access is NOT a major concern. 
 *                                                                
 * -----------------------------------------------------------------
 */
  
  
typedef int (*KINDlsDenseJacFn)(int N,
				N_Vector u, N_Vector fu, 
				DlsMat J, void *jac_data,
				N_Vector tmp1, N_Vector tmp2);
  
/*
 * -----------------------------------------------------------------
 * Type: KINDlsBandJacFn
 * -----------------------------------------------------------------
 *
 * A band Jacobian approximation function Jac must have the
 * prototype given below. Its parameters are:
 *
 * N is the problem size
 *
 * mupper is the upper half-bandwidth of the approximate banded
 * Jacobian. This parameter is the same as the mupper parameter
 * passed by the user to the linear solver initialization function.
 *
 * mlower is the lower half-bandwidth of the approximate banded
 * Jacobian. This parameter is the same as the mlower parameter
 * passed by the user to the linear solver initialization function.
 *
 * u        - current iterate (unscaled) [input]
 *
 * fu       - vector (type N_Vector) containing result of nonlinear
 *            system function evaluated at current iterate:
 *            fu = F(uu) [input]
 *
 * J        - band matrix (of type DlsMat) that will be loaded by a
 *            KINDlsBandJacFn with an approximation to the Jacobian
 *            matrix Jac = (dF_i/dy_j).
 *
 * jac_data - pointer to user data - the same as the jac_data
 *            parameter passed to KINBandSetJacFn.
 *
 * tmp1, tmp2 - available scratch vectors (volatile storage)
 *
 * A KINDlsBandJacFn should return 0 if successful, a positive value
 * if a recoverable error occurred, and a negative value if an 
 * unrecoverable error occurred.
 *
 * -----------------------------------------------------------------
 *
 * NOTE. Three efficient ways to load J are:
 *
 * (1) (with macros - no explicit data structure references)
 *    for (j=0; j < n; j++) {
 *       col_j = BAND_COL(Jac,j);
 *       for (i=j-mupper; i <= j+mlower; i++) {
 *         generate J_ij = the (i,j)th Jacobian element
 *         BAND_COL_ELEM(col_j,i,j) = J_ij;
 *       }
 *     }
 *
 * (2) (with BAND_COL macro, but without BAND_COL_ELEM macro)
 *    for (j=0; j < n; j++) {
 *       col_j = BAND_COL(Jac,j);
 *       for (k=-mupper; k <= mlower; k++) {
 *         generate J_ij = the (i,j)th Jacobian element, i=j+k
 *         col_j[k] = J_ij;
 *       }
 *     }
 *
 * (3) (without macros - explicit data structure references)
 *     offset = Jac->smu;
 *     for (j=0; j < n; j++) {
 *       col_j = ((Jac->data)[j])+offset;
 *       for (k=-mupper; k <= mlower; k++) {
 *         generate J_ij = the (i,j)th Jacobian element, i=j+k
 *         col_j[k] = J_ij;
 *       }
 *     }
 * Caution: Jac->smu is generally NOT the same as mupper.
 *
 * The BAND_ELEM(A,i,j) macro is appropriate for use in small
 * problems in which efficiency of access is NOT a major concern.
 *
 * -----------------------------------------------------------------
 */

typedef int (*KINDlsBandJacFn)(int N, int mupper, int mlower,
			       N_Vector u, N_Vector fu, 
			       DlsMat J, void *jac_data,
			       N_Vector tmp1, N_Vector tmp2);

/*
 * =================================================================
 *            E X P O R T E D    F U N C T I O N S 
 * =================================================================
 */

/*
 * -----------------------------------------------------------------
 * Optional inputs to the KINDIRECT linear solver
 * -----------------------------------------------------------------
 *
 * KINDlsSetJacFn specifies the Jacobian approximation routine to be
 * used. When using dense Jacobians, a user-supplied jac routine must 
 * be of type KINDlsDenseJacFn. When using banded Jacobians, a 
 * user-supplied jac routine must be of type KINDlsBandJacFn.
 * By default, a difference quotient approximation, supplied with this 
 * solver is used.
 * KINDlsSetJacFn also specifies a pointer to user data which is 
 * passed to the user's jac routine every time it is called.
 *
 * The return value of KINDlsSetJacFn is one of:
 *    KINDIRECT_SUCCESS   if successful
 *    KINDIRECT_MEM_NULL  if the KINSOL memory was NULL
 *    KINDIRECT_LMEM_NULL if the linear solver memory was NULL
 * -----------------------------------------------------------------
 */

SUNDIALS_EXPORT int KINDlsSetJacFn(void *kinmem, void *jac, void *jac_data);

/*
 * -----------------------------------------------------------------
 * Optional outputs from a KINDIRECT linear solver
 * -----------------------------------------------------------------
 *
 * KINDlsGetWorkSpace    returns the real and integer workspace used
 *                       by the KINDIRECT linear solver.
 * KINDlsGetNumJacEvals  returns the number of calls made to the
 *                       Jacobian evaluation routine.
 * KINDlsGetNumFuncEvals returns the number of calls to the user's F
 *                       routine due to finite difference Jacobian
 *                       evaluation.
 * KINDlsGetLastFlag     returns the last error flag set by any of
 *                       the KINDIRECT interface functions.
 * KINDlsGetReturnFlagName returns the name of the constant
 *                       associated with a KINDIRECT return flag
 *
 * The return value of KINDlsGet* is one of:
 *    KINDIRECT_SUCCESS   if successful
 *    KINDIRECT_MEM_NULL  if the KINSOL memory was NULL
 *    KINDIRECT_LMEM_NULL if the linear solver memory was NULL
 * -----------------------------------------------------------------
 */

SUNDIALS_EXPORT int KINDlsGetWorkSpace(void *kinmem, long int *lenrwB, long int *leniwB);
SUNDIALS_EXPORT int KINDlsGetNumJacEvals(void *kinmem, long int *njevalsB);
SUNDIALS_EXPORT int KINDlsGetNumFuncEvals(void *kinmem, long int *nfevalsB);
SUNDIALS_EXPORT int KINDlsGetLastFlag(void *kinmem, int *flag);
SUNDIALS_EXPORT char *KINDlsGetReturnFlagName(int flag);

#ifdef __cplusplus
}
#endif

#endif
