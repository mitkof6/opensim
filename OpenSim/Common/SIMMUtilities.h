#ifndef _SIMMUtilities_h_
#define _SIMMUtilities_h_
// SIMMUtilities.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
* Copyright (c) 2005, Stanford University. All rights reserved. 
* Redistribution and use in source and binary forms, with or without 
* modification, are permitted provided that the following conditions
* are met: 
*  - Redistributions of source code must retain the above copyright 
*    notice, this list of conditions and the following disclaimer. 
*  - Redistributions in binary form must reproduce the above copyright 
*    notice, this list of conditions and the following disclaimer in the 
*    documentation and/or other materials provided with the distribution. 
*  - Neither the name of the Stanford University nor the names of its 
*    contributors may be used to endorse or promote products derived 
*    from this software without specific prior written permission. 
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
* "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
* LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS 
* FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
* COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
* INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
* BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
* CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
* LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
* ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
* POSSIBILITY OF SUCH DAMAGE. 
*/

/* Note: This code was originally developed by Realistic Dynamics Inc. 
 * Author: Frank C. Anderson 
 */


#include "osimCommon.h"

// Need these undefined to make this work on linux
#ifdef NAN
#undef NAN
#endif


namespace OpenSim { 

class Line;
class Plane;


//=============================================================================
//=============================================================================
/**
 * This class provides basic math functions and constants.
 */
class OSIMCOMMON_API SIMMUtilities
{
//=============================================================================
// DATA
//=============================================================================
public:
	static const double PI;
	static const double RTD;
	static const double DTR;
	static const double SMALL;
	static const double ZERO;
	static const double NAN;
	static const double INF;

//=============================================================================
// METHODS
//=============================================================================
public:

	//--------------------------------------------------------------------------
	// BONES
	//--------------------------------------------------------------------------
	static int
		LoadBone(const char *aFileName,double rBoundingBox[6],
		int &rNumVert,double *&rVerts,double *&rNormals,
		int &rNumFaces,int *&rFaceCounts,int *&rFaces);

//=============================================================================
};	// END class SIMMUtilities

}; //namespace
//=============================================================================
//=============================================================================

#endif // __SIMMUtilities_h__

