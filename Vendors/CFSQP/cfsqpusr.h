/*************************************************************/
/*  CFSQP - Header file to be included in user's main        */
/*          program.                                         */
/*************************************************************/

#include "suCFSQPDLL.h"

#include <stdio.h>
#include <math.h>
#include <stdlib.h>

// FOR LINKING WITH C++ PROGRAMS
#ifdef __cplusplus
extern "C" {
#endif

#ifndef __STDC__
#ifdef apollo
extern char *calloc();
#else
#include <malloc.h>
#endif
#endif

#define TRUE 1
#define FALSE 0

/* Declare and initialize user-accessible flag indicating    */
/* whether x sent to user functions has been changed within  */
/* CFSQP.				 		     */
extern SUCFSQP_API int x_is_new;

/* Declare and initialize user-accessible stopping criterion */
extern SUCFSQP_API double objeps;
extern SUCFSQP_API double objrep;
extern SUCFSQP_API double gLgeps;
extern SUCFSQP_API int nstop;

/**************************************************************/
/*     Gradients - Finite Difference                          */
/**************************************************************/

#ifdef __STDC__
SUCFSQP_API void grobfd(int,int,double *,double *,void (*)(int,int,
               double *,double *,void *),void *);
SUCFSQP_API void grcnfd(int,int,double *,double *,void (*)(int,int,
               double *,double *,void *),void *);
#else
SUCFSQP_API void grobfd();
SUCFSQP_API void grcnfd();
#endif

/**************************************************************/
/*     Prototype for CFSQP -   	                              */
/**************************************************************/

#ifdef __STDC__
SUCFSQP_API void cfsqp(int,int,int,int,int,int,int,int,int,int *,int,int,
              int,int *,double,double,double,double,double *,
              double *,double *,double *,double *,double *,
              void (*)(int,int,double *,double *,void *),
              void (*)(int,int,double *,double *,void *),
              void (*)(int,int,double *,double *,
                   void (*)(int,int,double *,double *,void *),void *),
              void (*)(int,int,double *,double *,
                   void (*)(int,int,double *,double *,void *),void *),
              void *);
#else
SUCFSQP_API void cfsqp();
#endif

// FOR LINKING WITH C++ PROGRAMS
#ifdef __cplusplus
}
#endif

