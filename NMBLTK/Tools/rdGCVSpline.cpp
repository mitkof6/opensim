// rdGCVSpline.cpp
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Copyright 2002
// All rights reserved.
//
// Authors: Frank C. Anderson
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


// C++ INCLUDES
#include "rdGCVSpline.h"
#include "rdMath.h"
#include "rdPropertyInt.h"
#include "rdPropertyDbl.h"
#include "rdPropertyDblArray.h"
#include "gcvspl.h"


using namespace std;


//=============================================================================
// STATICS
//=============================================================================


//=============================================================================
// DESTRUCTOR AND CONSTRUCTORS
//=============================================================================
//_____________________________________________________________________________
/**
 * Destructor.
 */
rdGCVSpline::~rdGCVSpline()
{
}
//_____________________________________________________________________________
/**
 * Default constructor.
 */
rdGCVSpline::
rdGCVSpline() :
	_halfOrder(_propHalfOrder.getValueInt()),
	_errorVariance(_propErrorVariance.getValueDbl()),
	_x(_propX.getValueDblArray()),
	_weights(_propWeights.getValueDblArray()),
	_coefficients(_propCoefficients.getValueDblArray()),
	_wk(_propWk.getValueDblArray()),
	_workEval(0.0)
{
	setNull();
}
//_____________________________________________________________________________
/**
 * Construct a spline of a specified degree given arrays of paired data points
 * (x,f(x)). A name for the spline may be specified.
 *
 * @param aDegree Degree of the spline.  Only the following degrees
 * are supported: 1 = linear, 3 = cubic, 5 = qunitic, and 7 = heptic.
 * @param aN Number of data points.
 * @param aX Array of independent values- should be aN long.
 * @param aF Array of function values- should be aN long.
 * @param aName Optional name of the spline.
 * @param aErrorVariance Estimate of the variance of the error in the data to
 * be fit.  If negative, the variance will be estimated.  If 0.0, the fit will
 * try to fit the data points exactly- no smoothing.  If positive, the fit
 * will be smoothed according to the specified variance. The larger the error
 * variance, the more the smoothing.  The smoothing parameter, p, in
 * Woltring (1986) is computed based on the error variance.
 */
rdGCVSpline::
rdGCVSpline(int aDegree,int aN,const double *aX,const double *aF,
	const string &aName,double aErrorVariance) :
	_halfOrder(_propHalfOrder.getValueInt()),
	_errorVariance(_propErrorVariance.getValueDbl()),
	_x(_propX.getValueDblArray()),
	_weights(_propWeights.getValueDblArray()),
	_coefficients(_propCoefficients.getValueDblArray()),
	_wk(_propWk.getValueDblArray()),
	_workEval(0.0)
{
	setNull();

	// OBJECT TYPE AND NAME
	setName(aName);

	// DEGREE
	setDegree(aDegree);

	// NUMBER OF DATA POINTS
	if(aN < (2*getOrder())) {
		printf("rdGCVSpline: ERROR- there must be %d or more data points.\n",
			2*getOrder());
		return;
	}

	// CHECK DATA
	if((aX==NULL)||(aF==NULL)) {
		printf("rdGCVSpline: ERROR- NULL arrays for data points encountered.\n");
		return;
	}

	// INDEPENDENT VALUES (KNOT SEQUENCE)
	_x.setSize(0);
	_x.append(aN,aX);

	// WEIGHTS
	int i;
	_weights.setSize(_x.getSize());
	for(i=0;i<_weights.getSize();i++) _weights[i] = 1.0;

	// WORK ARRAY FOR EVALUATION
	int nw = 2 * _halfOrder;
	_workEval.setSize(nw);

	// ALLOCATE COEFFICIENTS
	_coefficients.setSize(_x.getSize());

	// FIT THE SPLINE
	int ierr=0;
	_errorVariance = aErrorVariance;
	int nwk = _x.getSize() + 6*(_x.getSize()*_halfOrder+1);
	_wk.setSize(nwk);
	double *f = new double[_x.getSize()];
	memcpy(f,aF,_x.getSize()*sizeof(double));
	gcvspl(_x.get(),f,_weights.get(),_halfOrder,_x.getSize(),
		_coefficients.get(),_errorVariance,_wk.get(),ierr);

	// CLEANUP
	delete[] f;
}
//_____________________________________________________________________________
/**
 * Construct a function from an XML Element.
 *
 * @param aElement XML element.
 */
rdGCVSpline::
rdGCVSpline(DOMElement *aElement) :
	rdFunction(aElement),
	_halfOrder(_propHalfOrder.getValueInt()),
	_errorVariance(_propErrorVariance.getValueDbl()),
	_x(_propX.getValueDblArray()),
	_weights(_propWeights.getValueDblArray()),
	_coefficients(_propCoefficients.getValueDblArray()),
	_wk(_propWk.getValueDblArray()),
	_workEval(0.0)
{
	setNull();
	updateFromXMLNode();
}
//_____________________________________________________________________________
/**
 * Copy constructor.
 * All data members of the specified spline are copied.
 *
 * @param aSpline rdGCVSpline object to be copied.
 */
rdGCVSpline::
rdGCVSpline(const rdGCVSpline &aSpline) :
	rdFunction(aSpline),
	_halfOrder(_propHalfOrder.getValueInt()),
	_errorVariance(_propErrorVariance.getValueDbl()),
	_x(_propX.getValueDblArray()),
	_weights(_propWeights.getValueDblArray()),
	_coefficients(_propCoefficients.getValueDblArray()),
	_wk(_propWk.getValueDblArray()),
	_workEval(0.0)
{
	setEqual(aSpline);
}
//_____________________________________________________________________________
/**
 * Copy this object.
 *
 * @return Pointer to a copy of this object.
 */
rdObject* rdGCVSpline::
copy() const
{
	rdGCVSpline *spline = new rdGCVSpline(*this);
	return(spline);
}
//_____________________________________________________________________________
/**
 * Copy this object and modify the copy so that it is consistent
 * with a specified XML element node.
 *
 * The copy is constructed by first using
 * rdGCVSpline::rdGCVSpline(DOMElement*) in order to establish the
 * XML node.  Then, the assignment operator is used to set all
 * data members of the copy to the values of this object.  Finally, the
 * data members of the copy are updated using rdGCVSpline::updateObject().
 *
 * @param aElement XML element. 
 * @return Pointer to a copy of this object modified by the specified
 * XML element.
 */
rdObject* rdGCVSpline::
copy(DOMElement *aElement) const
{
	// CONSTRUCT FUNCTION BASED ON XML ELEMENT
	rdGCVSpline *func = new rdGCVSpline(aElement);

	// ASSIGN DATA ACCORDING TO THIS ACTUATOR
	*func = *this;

	// UPDATE DATA CCORDING TO THE XML ELEMENT
	func->updateFromXMLNode();

	return(func);
}


//=============================================================================
// CONSTRUCTION
//=============================================================================
//_____________________________________________________________________________
/**
 * Set all member variables to their NULL or default values.
 */
void rdGCVSpline::
setNull()
{
	setType("rdGCVSpline");
	setupProperties();
	_knotIndex = 0;
}
//_____________________________________________________________________________
/**
 * Set up the serialized member variables.  This involves both generating
 * the properties and connecting them to the local pointers used to access
 * the serialized member variables.
 */
void rdGCVSpline::
setupProperties()
{
//const char rdGCVSpline::PROP_WK[] = "wk";

	// HALF ORDER
	_propHalfOrder.setName("half_order");
	_propHalfOrder.setValue(0);
	_propertySet.append( &_propHalfOrder );

	// ERROR VARIANCE
	_propErrorVariance.setName("error_variance");
	_propErrorVariance.setValue(0.0);
	_propertySet.append( &_propErrorVariance );

	// X- INDEPENDENT VARIABLES
	_propX.setName("x");
	rdArray<double> x(0.0);
	_propX.setValue(x);
	_propertySet.append( &_propX );

	// WEIGHTS
	_propWeights.setName("weights");
	rdArray<double> weights(1.0);
	_propWeights.setValue(weights);
	_propertySet.append( &_propWeights );

	// COEFFICIENTS
	_propCoefficients.setName("coefficients");
	rdArray<double> coefs(0.0);
	_propCoefficients.setValue(coefs);
	_propertySet.append( &_propCoefficients );

	// WORK ARRAY
	_propWk.setName("wk");
	rdArray<double> wk(0.0);
	_propWk.setValue(wk);
	_propertySet.append( &_propWk );
}
//_____________________________________________________________________________
/**
 * Set all member variables equal to the members of another object.
 * Note that this method is private.  It is only meant for copying the data
 * members defined in this class.  It does not, for example, make any changes
 * to data members of base classes.
 */
void rdGCVSpline::
setEqual(const rdGCVSpline &aSpline)
{
	setNull();

	// VALUES
	_halfOrder = aSpline._halfOrder;
	_errorVariance = aSpline._errorVariance;
	_knotIndex = aSpline._knotIndex;

	// CHECK ARRAY SIZES
	if(aSpline.getSize()<=0) return;
	if(_halfOrder<=0) return;

	// ALLOCATE ARRAYS
	_x = aSpline._x;
	_weights = aSpline._weights;
	_coefficients = aSpline._coefficients;
	_wk = aSpline._wk;
	_workEval = aSpline._workEval;
}


//=============================================================================
// OPERATORS
//=============================================================================
//_____________________________________________________________________________
/**
 * Assignment operator.
 * Note that data members of the base class are also assigned.
 *
 * @return Reference to this object.
 */
rdGCVSpline& rdGCVSpline::
operator=(const rdGCVSpline &aSpline)
{
	// BASE CLASS
	rdFunction::operator=(aSpline);

	// DATA
	setEqual(aSpline);

	return(*this);
}


//=============================================================================
// SET AND GET
//=============================================================================
//-----------------------------------------------------------------------------
// DEGREE
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Set the degree of this spline.
 *
 * @param aDegree Degree of spline.  Legal values: 1 = linear, 3 = cubic,
 * 5 = qunitic, 7 = heptic.
 */
void rdGCVSpline::
setDegree(int aDegree)
{
	_halfOrder = (aDegree + 1) / 2;

	// TOO SMALL
	if(_halfOrder<1) {
		printf("rdGCVSpline.setDegree: WARN- invalid half order %d.\n",
			_halfOrder);
		printf("\tSetting degree = 1 (linear spline.)\n");
		_halfOrder = 1;
	}

	// TOO LARGE
	if(_halfOrder>4) {
		printf("rdGCVSpline.setDegree: WARN- invalid half order %d.\n",
			_halfOrder);
		printf("\tSetting degree = 7 (heptic spline.)\n");
		_halfOrder = 4;
	}
}
//_____________________________________________________________________________
/**
 * Get the degree of this spline.
 *
 * @return Degree of spline: 1 = linear, 3 = cubic, 5 = qunitic, 7 = heptic.
 */
int rdGCVSpline::
getDegree() const
{
	int degree = 2*_halfOrder - 1;
	return(degree);
}

//-----------------------------------------------------------------------------
// ORDER
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the order of this spline.
 *
 * @return Order of spline: 2 = linear, 4 = cubic, 6 = qunitic, 8 = heptic.
 */
int rdGCVSpline::
getOrder() const
{
	int order = 2*_halfOrder;
	return(order);
}

//-----------------------------------------------------------------------------
// HALF ORDER
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the half order of this spline.
 *
 * @return Half order of spline: 1 = linear, 2 = cubic, 3 = qunitic, 4 = heptic.
 */
int rdGCVSpline::
getHalfOrder() const
{
	return(_halfOrder);
}

//-----------------------------------------------------------------------------
// NUMBER OF DATA POINTS (N)
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get size or number of independent data points (or number of coefficients)
 * used to construct the spline.
 *
 * @return Number of data points (or number of coefficients).
 */
int rdGCVSpline::
getSize() const
{
	return(_x.getSize());
}

//-----------------------------------------------------------------------------
// MIN AND MAX X
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the minimum value of the independent variable.
 *
 * @return Minimum value of the independent variable.
 */
double rdGCVSpline::
getMinX() const
{
	if(getSize()<=0) return(rdMath::NAN);
	return(_x.get(0));
}
//_____________________________________________________________________________
/**
 * Get the maximum value of the independent variable.
 *
 * @return Maximum value of the independent variable.
 */
double rdGCVSpline::
getMaxX() const
{
	if(getSize()<=0) return(rdMath::NAN);
	return(_x.getLast());
}

//-----------------------------------------------------------------------------
// X AND COEFFICIENTS
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Get the array of independent variables used to construct the spline.
 * For the number of independent variable data points use getN().
 *
 * @return Pointer to the independent variable data points.
 * @see getN();
 */
const rdArray<double>& rdGCVSpline::
getX() const
{
	return(_x);
}
//_____________________________________________________________________________
/**
 * Get the array of coefficients for the spline.
 * For the number of coefficients use getNX().
 *
 * @return Pointer to the coefficients.
 * @see getCoefficients();
 */
const rdArray<double>& rdGCVSpline::
getCoefficients() const
{
	return(_coefficients);
}



//=============================================================================
// EVALUATION
//=============================================================================
//_____________________________________________________________________________
/**
 * Update the bounding box for this function.
 *
 * For an rdGCVSpline, there is only one indepdendent variable x, so the 
 * minimum and maximum values of indepdent variables y and z is 0.0.
 *
 * When this method is called, the minimum and maximum x of the bounding box
 * is simply set to the minimum and maximum values of the x data points that
 * were used to construct the spline, that is, min x = x[0] and
 * max x = x[getN()-1].
 *
 * @see rdFunction
 */
void rdGCVSpline::
updateBoundingBox()
{
	setMinX(0.0);
	setMinY(0.0);
	setMinZ(0.0);
	setMaxX(0.0);
	setMaxY(0.0);
	setMaxZ(0.0);

	if(getSize()<=0) return;

	setMinX(_x.get(0));
	setMaxX(_x.getLast());
}

//_____________________________________________________________________________
/**
 * Evaluate this function or a derivative of this function given a set of
 * independent variables.  Only splines of one dimension are supported by
 * this class, so values of independent variables y and z are ignored.
 *
 * @param aDerivOrder Derivative order.  If aDerivOrder == 0, the function
 * is evaluated.  Otherwise, if aDerivOrder > 0, the aDerivOrder'th
 * derivative of the function is evaluated.  For example, if aDerivOrder == 1,
 * the first derivative of the function is returned.  Negative values of
 * aDerivOrder (integrals of the function) are not supported.
 * @param aX Value of the x independent variable at which to evaluate
 * this function or its derivatives.
 * @param aY Value of the y independent variable at which to evaluate
 * this function or its derivatives (ignored).
 * @param aZ Value of the z independent variable at which to evaluate
 * this function or its derivatives (ignored).
 * @return Value of the function or one of its derivatives.
 */
double rdGCVSpline::
evaluate(int aDerivOrder,double aX,double aY,double aZ)
{
	// NOT A NUMBER
	if(_coefficients==NULL) return(rdMath::NAN);
	if(aX<getMinX()) return(rdMath::NAN);
	if(aX>getMaxX()) return(rdMath::NAN);
	if(aDerivOrder<0) return(rdMath::NAN);

	// EVALUATE
	double value;
	if(aDerivOrder>getDegree()) {
		value = 0.0;
	} else {
		value = splder(aDerivOrder,_halfOrder,getSize(),aX,
			_x.get(),_coefficients.get(),&_knotIndex,_workEval.get());
	}

	return(value);
}

