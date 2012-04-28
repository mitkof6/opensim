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
#include "FiberForceLengthCurve.h"

using namespace OpenSim;
using namespace SimTK;
using namespace std;

static const char* StrainAtOneNormForceName     = "strain_at_one_norm_force";
static const char* StiffnessAtOneNormForceName  = "stiffness_at_one_norm_force";
static const char* CurvinessName                = "curviness";

//=============================================================================
// CONSTRUCTION, COPY CONSTRUCTION, ASSIGNMENT
//=============================================================================

FiberForceLengthCurve::FiberForceLengthCurve():m_curveUpToDate(false)
{
        setNull();
        addProperties();
}

FiberForceLengthCurve::~FiberForceLengthCurve()
{
}

FiberForceLengthCurve::FiberForceLengthCurve(
    const FiberForceLengthCurve& source)                                   
{
        setNull();
        addProperties();
        copyData(source);   
}

FiberForceLengthCurve& FiberForceLengthCurve::
                                operator=(const FiberForceLengthCurve &source)
{
    if(&source != this){
        ModelComponent::operator=(source);
        copyData(source);        
    }
    return(*this);
}

FiberForceLengthCurve::FiberForceLengthCurve( double strainAtOneNormForce, 
                                                double stiffnessAtOneNormForce,
                                                double curviness,
                                                const std::string muscleName)
                                                :m_curveUpToDate(false)
{


    std::string curveName = muscleName;
    curveName.append("_FiberForceLengthCurve");

    setNull();
    addProperties();

   setStrainAtOneNormForce(strainAtOneNormForce);
   setStiffnessAtOneNormForce(stiffnessAtOneNormForce);
   setCurviness(curviness);


    buildCurve();
}


void FiberForceLengthCurve::setNull()
{
    m_curveUpToDate =false;
}

void FiberForceLengthCurve::addProperties()
{   
    setName("default_FiberForceLengthCurve");

    addProperty<double>(StrainAtOneNormForceName, 
        "Fiber strain at a tension of 1 normalized force",
        0.6);

    addProperty<double>(StiffnessAtOneNormForceName, 
        "Fiber stiffness at a tension of 1 normalized force",
        8.4);

    addProperty<double>(CurvinessName, 
        "Fiber curve bend, from linear to maximum bend (0-1)",
        0.65);
}

void FiberForceLengthCurve::copyData(const FiberForceLengthCurve &source)
{
    if(&source != this){
        setPropertyValue(StrainAtOneNormForceName,
            source.getPropertyValue<double>(StrainAtOneNormForceName));

        setPropertyValue(StiffnessAtOneNormForceName,
            source.getPropertyValue<double>(StiffnessAtOneNormForceName));

        setPropertyValue(CurvinessName,
            source.getPropertyValue<double>(CurvinessName));

        m_curveUpToDate = source.m_curveUpToDate;
        
        m_curve = source.m_curve;
    }
}


void FiberForceLengthCurve::buildCurve()
{
    if(m_curveUpToDate == false){
        
        double e0   =  getStrainAtOneNormForce();
        double kiso =  getStiffnessAtOneNormForce();
        double c    =  getCurviness();        

        //Here's where you call the MuscleCurveFunctionFactory
        MuscleCurveFunction tmp = MuscleCurveFunctionFactory::
                                    createFiberForceLengthCurve(   e0,
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
void FiberForceLengthCurve::setup(Model& aModel)
{
    ModelComponent::setup(aModel);
}

void FiberForceLengthCurve::initState(SimTK::State& s) const
{
    ModelComponent::initState(s);
}

void FiberForceLengthCurve::createSystem(SimTK::MultibodySystem& system) const
{
    Super::createSystem(system);

    FiberForceLengthCurve* mthis = const_cast<FiberForceLengthCurve*>(this);    
    mthis->buildCurve();
}



//=============================================================================
// GET & SET METHODS
//=============================================================================
double FiberForceLengthCurve::getStrainAtOneNormForce()
{
    return getPropertyValue<double>(StrainAtOneNormForceName);
}

double FiberForceLengthCurve::getStiffnessAtOneNormForce()
{
    return getPropertyValue<double>(StiffnessAtOneNormForceName);
}

double FiberForceLengthCurve::getCurviness()
{
    return getPropertyValue<double>(CurvinessName);
}


void FiberForceLengthCurve::
    setStrainAtOneNormForce(double aStrainAtOneNormForce)
{
    if(aStrainAtOneNormForce != getStrainAtOneNormForce() )
    {
        setPropertyValue(StrainAtOneNormForceName,
                         aStrainAtOneNormForce);
        m_curveUpToDate = false;
    }
}

void FiberForceLengthCurve::
        setStiffnessAtOneNormForce(double aStiffnessAtOneNormForce)
{
    if(aStiffnessAtOneNormForce != getStiffnessAtOneNormForce() )
    {
        setPropertyValue(StiffnessAtOneNormForceName,
                         aStiffnessAtOneNormForce);
        m_curveUpToDate = false;
    }
}

void FiberForceLengthCurve::setCurviness(double aCurviness)
{
    if(aCurviness != getCurviness() )
    {
        setPropertyValue(CurvinessName,
                         aCurviness);
        m_curveUpToDate = false;
    }
}


//=============================================================================
// SERVICES
//=============================================================================

double FiberForceLengthCurve::
    calcValue(double aNormLength) const
{
    if(m_curveUpToDate == false){
        FiberForceLengthCurve* mthis = 
            const_cast<FiberForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    return m_curve.calcValue(aNormLength);
}

double FiberForceLengthCurve::
    calcDerivative(double aNormLength, int order) const
{
    SimTK_ERRCHK1_ALWAYS(order >= 0 && order <= 2, 
        "FiberForceLengthCurve::calcDerivative",
        "order must be 0, 1, or 2, but %i was entered", order);
    
    if(m_curveUpToDate == false){
        FiberForceLengthCurve* mthis = 
            const_cast<FiberForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    return m_curve.calcDerivative(aNormLength,order);
}

SimTK::Vec2 FiberForceLengthCurve::getCurveDomain() const
{
    if(m_curveUpToDate == false){
        FiberForceLengthCurve* mthis = 
            const_cast<FiberForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    return m_curve.getCurveDomain();
}

void FiberForceLengthCurve::
    printMuscleCurveToCSVFile(const std::string& path) const
{
    if(m_curveUpToDate == false){
        FiberForceLengthCurve* mthis = 
            const_cast<FiberForceLengthCurve*>(this);    
        mthis->buildCurve();    
    }

    m_curve.printMuscleCurveToCSVFile(path);
}