#ifndef _GeneralizedForcePerturbation_h_
#define _GeneralizedForcePerturbation_h_
// GeneralizedForcePerturbation.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	AUTHOR: Frank C. Anderson, Saryn R. Goldberg
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
* Copyright (c)  2005, Stanford University. All rights reserved. 
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


//=============================================================================
// INCLUDES
//=============================================================================
#include <OpenSim/Common/rdMath.h>
#include <OpenSim/Simulation/Model/DerivCallback.h>
#include <OpenSim/Simulation/Manager/Manager.h>
#include "osimAnalysesDLL.h"
#include <OpenSim/Common/GCVSpline.h>
#include "Contact.h"


//=============================================================================
//=============================================================================
/**
 * A derivatives callback used for applying a generalized force during a
 * simulation.
 *
 * @author Frank C. Anderson, Saryn R. Goldberg
 * @version 1.0
 */
namespace OpenSim { 

class Model;
class AbstractCoordinate;

class OSIMANALYSES_API GeneralizedForcePerturbation : public DerivCallback 
{
//=============================================================================
// DATA
//=============================================================================
public:

protected:
	/** Which generalized coordinate. */
	AbstractCoordinate *_genCoord;
	/** Perturbation to be applied */
	double _perturbation;
	/** Scaling factor to be applied to perturbation */
	double _scaleFactor;
   /** The function defining the generalized force to be applied **/
	GCVSpline *_genForceSpline;


//=============================================================================
// METHODS
//=============================================================================
public:
	GeneralizedForcePerturbation(Model *aModel);
	GeneralizedForcePerturbation(Model *aModel, GCVSpline *_aSpline);
	virtual ~GeneralizedForcePerturbation();
private:
	void setNull();

public:
	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
	void setGenCoord(AbstractCoordinate *aCoord);
	AbstractCoordinate *getGenCoord() const;

	void setScaleFactor(double aScaleFactor);
	double getScaleFactor() const;
	void setPerturbation(double aPerturbation);
	double getPerturbation() const;

	
	//--------------------------------------------------------------------------
	// CALLBACKS
	//--------------------------------------------------------------------------
	virtual void
		computeActuation(double aT,double *aX,double *aY);
	virtual void
		applyActuation(double aT,double *aX,double *aY);

//=============================================================================
};	// END of class GeneralizedForcePerturbation

}; //namespace
//=============================================================================
//=============================================================================


#endif // #ifndef __GeneralizedForcePerturbation_h__
