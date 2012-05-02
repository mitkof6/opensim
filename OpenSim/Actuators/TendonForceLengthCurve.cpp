/* Author: Matthew Millard
/*
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included in *
 * all copies or substantial portions of the Software.                        *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,   *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL    *
 * THE AUTHORS, CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,    *
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR      *
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE  *
 * USE OR OTHER DEALINGS IN THE SOFTWARE.                                     *
 * -------------------------------------------------------------------------- */
#include "TendonForceLengthCurve.h"

using namespace OpenSim;
using namespace SimTK;
using namespace std;

//=============================================================================
// CONSTRUCTION, COPY CONSTRUCTION, ASSIGNMENT
//=============================================================================
// Uses default (compiler-generated) destructor, copy constructor, copy 
// assignment operator.

TendonForceLengthCurve::TendonForceLengthCurve()
{
    setNull();
    constructProperties();
    setName("default_TendonForceLengthCurve");
}

TendonForceLengthCurve::TendonForceLengthCurve( double strainAtOneNormForce, 
                                                double stiffnessAtOneNormForce,
                                                double curviness,
                                                const std::string& muscleName)
{
    setNull();
    constructProperties();
    setName(muscleName + "_TendonForceLengthCurve");

    setStrainAtOneNormForce(strainAtOneNormForce);
    setStiffnessAtOneNormForce(stiffnessAtOneNormForce);
    setCurviness(curviness);

    buildCurve();
}


void TendonForceLengthCurve::setNull()
{
    m_curveUpToDate = false;
}

void TendonForceLengthCurve::constructProperties()
{   
    constructProperty_strain_at_one_norm_force(0.04);
    constructProperty_stiffness_at_one_norm_force(42);
    constructProperty_curviness(0.75);
}


void TendonForceLengthCurve::buildCurve()
{
    if(m_curveUpToDate == false){
        
        double e0   =  getStrainAtOneNormForce();
        double kiso =  getStiffnessAtOneNormForce();
        double c    =  getCurviness();        

        //Here's where you call the MuscleCurveFunctionFactory
        MuscleCurveFunction tmp = MuscleCurveFunctionFactory::
                                    createTendonForceLengthCurve(   e0,
                                                                    kiso,
                                                                    c,
                                                                    true,
                                                                    getName());            

        this->m_curve = tmp;
          
    }
    m_curveUpToDate = true;
}


//=============================================================================
// MODEL COMPPONENT INTERFACE
//=============================================================================
void TendonForceLengthCurve::setup(Model& model)
{
    Super::setup(model);
}

void TendonForceLengthCurve::initState(SimTK::State& s) const
{
    Super::initState(s);
}

void TendonForceLengthCurve::createSystem(SimTK::MultibodySystem& system) const
{
    Super::createSystem(system);

    TendonForceLengthCurve* mthis = const_cast<TendonForceLengthCurve*>(this);    
    mthis->buildCurve();
}



//=============================================================================
// GET & SET METHODS
//=============================================================================
double TendonForceLengthCurve::getStrainAtOneNormForce()
{
    return getProperty_strain_at_one_norm_force();
}

double TendonForceLengthCurve::getStiffnessAtOneNormForce()
{
    return getProperty_stiffness_at_one_norm_force();
}

double TendonForceLengthCurve::getCurviness()
{
    return getProperty_curviness();
}


void TendonForceLengthCurve::
    setStrainAtOneNormForce(double aStrainAtOneNormForce)
{
    if(aStrainAtOneNormForce != getStrainAtOneNormForce() )
    {
        setProperty_strain_at_one_norm_force(aStrainAtOneNormForce);
        m_curveUpToDate = false;
    }
}

void TendonForceLengthCurve::
        setStiffnessAtOneNormForce(double aStiffnessAtOneNormForce)
{
    if(aStiffnessAtOneNormForce != getStiffnessAtOneNormForce() )
    {
        setProperty_stiffness_at_one_norm_force(aStiffnessAtOneNormForce);
        m_curveUpToDate = false;
    }
}

void TendonForceLengthCurve::setCurviness(double aCurviness)
{
    if(aCurviness != getCurviness() )
    {
        setProperty_curviness(aCurviness);
        m_curveUpToDate = false;
    }
}


//=============================================================================
// SERVICES
//=============================================================================

double TendonForceLengthCurve::
    calcValue(double aNormLength) const
{
    if(m_curveUpToDate == false){
        TendonForceLengthCurve* mthis = 
            const_cast<TendonForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    return m_curve.calcValue(aNormLength);
}

double TendonForceLengthCurve::
    calcDerivative(double aNormLength, int order) const
{
    SimTK_ERRCHK1_ALWAYS(order >= 0 && order <= 2, 
        "TendonForceLengthCurve::calcDerivative",
        "order must be 0, 1, or 2, but %i was entered", order);
    
    if(m_curveUpToDate == false){
        TendonForceLengthCurve* mthis = 
            const_cast<TendonForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    return m_curve.calcDerivative(aNormLength,order);
}

SimTK::Vec2 TendonForceLengthCurve::getCurveDomain() const
{
    if(m_curveUpToDate == false){
        TendonForceLengthCurve* mthis = 
            const_cast<TendonForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    return m_curve.getCurveDomain();
}

void TendonForceLengthCurve::
    printMuscleCurveToCSVFile(const std::string& path) const
{
    if(m_curveUpToDate == false){
        TendonForceLengthCurve* mthis = 
            const_cast<TendonForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    m_curve.printMuscleCurveToCSVFile(path);
}