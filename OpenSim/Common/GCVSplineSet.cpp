// GCVSplineSet.cpp
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


// INCLUDES
#include "rdMath.h"
#include "GCVSplineSet.h"


//=============================================================================
// DESTRUCTOR AND CONSTRUCTORS
//=============================================================================
//_____________________________________________________________________________


using namespace OpenSim;
/**
 * Destructor.
 */
GCVSplineSet::~GCVSplineSet()
{
}

//_____________________________________________________________________________
/**
 * Default constructor.
 */
GCVSplineSet::
GCVSplineSet()
{
	setNull();
}
//_____________________________________________________________________________
/**
 * Construct a set of generalized cross-validated splines from file.
 *
 * @param aFileName Name of the file.
 */
GCVSplineSet::
GCVSplineSet(const char *aFileName) :
	FunctionSet(aFileName)
{
	setNull();
}
//_____________________________________________________________________________
/**
 * Construct a set of generalized cross-validated splines based on the states
 * stored in an Storage object.
 *
 * Each column in the Storage object is fit with a spline of the specified
 * degree and is named the name of its corresponding column label.  Note that
 * column labels in the storage object are assumed to be tab delimited.
 *
 * @param aDegree Degree of the constructed splines (1, 3, 5, or 7).
 * @param aStore Storage object.
 * @param aErrorVariance Estimate of the variance of the error in the data to
 * be fit.  If negative, the variance will be estimated.  If 0.0, the fit will
 * try to fit the data points exactly- no smoothing.  If
 * positive, the fits will be smoothed according to the specified variance.
 * The larger the error veriance, the more the smoothing.  Note that this is
 * the error variance assumed for each column in the Storage.  If different
 * variances should be set for the various columns, you will need to
 * construct each GCVSpline individually.
 * @see Storage
 * @see GCVSpline
 */
GCVSplineSet::
GCVSplineSet(int aDegree,Storage *aStore,double aErrorVariance)
{
	setNull();
	if(aStore==NULL) return;
	setName(aStore->getName());

	// CAPACITY
	StateVector *vec = aStore->getStateVector(0);
	if(vec==NULL) return;
	ensureCapacity(2*vec->getSize());

	// CONSTRUCT
	construct(aDegree,aStore,aErrorVariance);
}


//=============================================================================
// CONSTRUCTION
//=============================================================================
//_____________________________________________________________________________
/**
 * Set all member variables to NULL values.
 */
void GCVSplineSet::
setNull()
{
	setType("GCVSplineSet");
}
//_____________________________________________________________________________
/**
 * Construct a set of generalized cross-validated splines based on the states
 * stored in an Storage object.
 *
 * @param aDegree Degree of the constructed splines (1, 3, 5, or 7).
 * @param aStore Storage object.
 * @param aErrorVariance Error variance for the data.
 */
void GCVSplineSet::
construct(int aDegree,Storage *aStore,double aErrorVariance)
{
	if(aStore==NULL) return;

	// DESCRIPTION
	setDescription(aStore->getDescription());

	// GET COLUMN NAMES
	const Array<std::string> &labels = aStore->getColumnLabels();
	char tmp[Object::NAME_LENGTH];
	std::string name;

	// LOOP THROUGHT THE STATES
	int nTime=1,nData=1;
	double *times=NULL,*data=NULL;
	GCVSpline *spline;
	//printf("GCVSplineSet.construct:  contructing splines...\n");
	for(int i=0;nData>0;i++) {

		// GET TIMES AND DATA
		nTime = aStore->getTimeColumn(times,i);
		nData = aStore->getDataColumn(i,data);

		// CHECK
		if(nTime!=nData) {
			std::cout << "\nGCVSplineSet.construct: ERR- number of times (" << nTime << ")"
				  << " and number of data (" << nData << ") don't agree.\n";
			break;
		}
		if(nData==0) break;

		// GET COLUMN NAME
		// Note that state i is in column i+1
		if(i+1 < labels.getSize()) {
			name = labels[i+1];
		} else {
			sprintf(tmp,"data_%d",i);
			name = tmp;
		}

		// CONSTRUCT SPLINE
		//printf("%s\t",name);
		spline = new GCVSpline(aDegree,nData,times,data,name,aErrorVariance);

		// ADD SPLINE
		append(spline);
	}
	//printf("\n%d splines constructed.\n\n",i);

	// MIN AND MAX TIME
	setMinX(aStore->getFirstTime());
	setMaxX(aStore->getLastTime());

	// CLEANUP
	if(times!=NULL) delete[] times;
	if(data!=NULL) delete[] data;
}


//=============================================================================
// SET AND GET
//=============================================================================
//_____________________________________________________________________________
/**
 * Get the function at a specified index.
 *
 * @param aIndex Index of the desired function:  0 <= aIndex < getSize().
 * @return Function at index aIndex.  If aIndex is not value NULL is returned.
 */
GCVSpline* GCVSplineSet::
getGCVSpline(int aIndex)
{
	GCVSpline *func = (GCVSpline *)get(aIndex);
	return(func);
}


//=============================================================================
// UTILITY
//=============================================================================
//_____________________________________________________________________________
/**
 * Construct a storage object (see Storage) for this spline \set\ or for some
 * derivative of this spline set.
 *
 * @param aDerivOrder Derivative order.  0 constructs from the spline,
 * 1 constructs from the first derivative of the spline, 2 constructs from
 * the second derivative of the spline, etc.
 * @param aDX Spacing of the data points in the independent variable.  If
 * negative the spacing of the independent variable is taken from the
 * original data, as determined from the first non-NULL spline in the set.
 * aDX has a default value of -1.
 * @return Storage object.  If a valid storage object cannot be constructed
 * NULL is returned.
 * @see Storage
 */
Storage* GCVSplineSet::
constructStorage(int aDerivOrder,double aDX)
{
	if(aDerivOrder<0) return(NULL);
	if(getSize()<=0) return(NULL);

	// GET FIRST NON-NULL SPLINE
	GCVSpline *spl;
	int i;
	int n = getSize();
	for(i=0;i<n;i++) {
		spl = getGCVSpline(i);
		if(spl!=NULL) break;
	}
	if(spl==NULL) return(NULL);

	// HOW MANY X STEPS
	double xRange = getMaxX() - getMinX();
	int nSteps;
	if(aDX<=0.0) {
		nSteps = spl->getSize();
	} else {
		nSteps = 10 + (int)(xRange/aDX);
	}

	// CONSTRUCT STORAGE OBJECT
	char name[2*Object::NAME_LENGTH];
	if(aDerivOrder==0) {
		sprintf(name,"%s_GCVSpline",getName().c_str());
	} else {
		sprintf(name,"%s_GCVSpline_Deriv_%d",getName().c_str(),aDerivOrder);
	}
	Storage *store = new Storage(nSteps,name);

	// DESCRIPTION
	store->setDescription(getDescription());

	// SET COLUMN LABELS
	GCVSpline *spline;
	int len = n*(Object::NAME_LENGTH+4);
	Array<std::string> labels;
	labels.append("time");
	for(i=0;i<n;i++) {
		spline = getGCVSpline(i);
		if(spline==NULL) {
			sprintf(name,"data_%d",i);
			labels.append(name);
		} else {
			labels.append(spline->getName());
		}
	}
	store->setColumnLabels(labels);

	// SET STATES
	double x = getMinX();
	double *y = new double[n];

	// GET ORIGINAL INDEPENDENT VARIABLES

	// LOOP THROUGH THE DATA
	// constant increments
	if(aDX>0.0) {
		while(x <= getMaxX()) {

			// LOOP THROUGH SPLINES
			for(i=0;i<n;i++) {
				spline = getGCVSpline(i);

				// SET Y
				if(spline==NULL) {
					y[i] = rdMath::NAN;
				} else {
					y[i] = spline->evaluate(aDerivOrder,x);
				}
			}

			// APPEND
			store->append(x,n,y);

			// ADVANCE X
			if(x < getMaxX()) {
				x += aDX;
				if(x > getMaxX())  x = getMaxX();

			// FINISHED
			} else {
				break;
			}
		}

	// original independent variable increments
	} else {

		int ix;
		const Array<double> &xOrig = spl->getX();
		for(ix=0;ix<nSteps;ix++) {

			// ONLY WITHIN BOUNDS OF THE SET
			if(xOrig[ix]<getMinX()) continue;
			if(xOrig[ix]>getMaxX()) break;

			// LOOP THROUGH SPLINES
			for(i=0;i<n;i++) {
				spline = getGCVSpline(i);

				// SET Y
				if(spline==NULL) {
					y[i] = rdMath::NAN;
				} else {
					y[i] = spline->evaluate(aDerivOrder,xOrig[ix]);
				}
			}

			// APPEND
			store->append(xOrig[ix],n,y);
		}
	}

	// CLEANUP
	if(y!=NULL) delete[] y;

	return(store);
}
