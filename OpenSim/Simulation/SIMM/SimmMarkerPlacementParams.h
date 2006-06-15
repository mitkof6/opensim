#ifndef _SimmMarkerPlacementParams_h_
#define _SimmMarkerPlacementParams_h_

// SimmMarkerPlacementParams.h
// Author: Peter Loan
/* Copyright (c) 2005, Stanford University and Peter Loan.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject
 * to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


// INCLUDE
#include <iostream>
#include <string>
#include <math.h>
#include <OpenSim/Simulation/rdSimulationDLL.h>
#include <OpenSim/Tools/PropertyDblArray.h>
#include <OpenSim/Tools/PropertyObjArray.h>
#include <OpenSim/Tools/PropertyBool.h>
#include <OpenSim/Tools/PropertyStr.h>
#include <OpenSim/Tools/PropertyStrArray.h>
#include <OpenSim/Tools/Storage.h>
#include <OpenSim/Tools/XMLDocument.h>

#include "SimmModel.h"
#include "SimmCoordinate.h"
#include "SimmMarker.h"

//=============================================================================
//=============================================================================
/**
 * A class implementing a set of parameters describing how to place markers
 * on a model (presumably after it has been scaled to fit a subject).
 *
 * @author Peter Loan
 * @version 1.0
 */
namespace OpenSim { 

class RDSIMULATION_API SimmMarkerPlacementParams : public Object  
{

//=============================================================================
// DATA
//=============================================================================
private:

protected:
	// name of marker file that contains marker locations in the static pose
	PropertyStr _markerFileNameProp;
	std::string &_markerFileName;

	// range of frames to average in static pose marker file, specified by time
	PropertyDblArray _timeRangeProp;
	Array<double> &_timeRange;

	// name of SIMM motion file that contains [optional] coordinates for the static pose
	PropertyStr _coordinateFileNameProp;
	std::string &_coordinateFileName;

	// coordinate set for updating coordinates in scaled model
	PropertyObjArray _coordinateSetProp;
	ArrayPtrs<SimmCoordinate> &_coordinateSet;

	// marker set for updating markers in scaled model
	PropertyObjArray _markerSetProp;
	ArrayPtrs<SimmMarker> &_markerSet;

	// name of SIMM joint file to write when done placing markers
	PropertyStr _outputJointFileNameProp;
	std::string &_outputJointFileName;

	// name of SIMM muscle file to write when done placing markers
	PropertyStr _outputMuscleFileNameProp;
	std::string &_outputMuscleFileName;

	// name of XML model file to write when done placing markers
	PropertyStr _outputModelFileNameProp;
	std::string &_outputModelFileName;

	// name of marker file to write when done placing markers
	PropertyStr _outputMarkerFileNameProp;
	std::string &_outputMarkerFileName;

	// name of motion file (containing solved static pose) when done placing markers
	PropertyStr _outputMotionFileNameProp;
	std::string &_outputMotionFileName;

//=============================================================================
// METHODS
//=============================================================================
	//--------------------------------------------------------------------------
	// CONSTRUCTION
	//--------------------------------------------------------------------------
public:
	SimmMarkerPlacementParams();
	SimmMarkerPlacementParams(DOMElement *aElement);
	SimmMarkerPlacementParams(const SimmMarkerPlacementParams &aMarkerPlacementParams);
	virtual ~SimmMarkerPlacementParams();
	virtual Object* copy() const;
	virtual Object* copy(DOMElement *aElement) const;

#ifndef SWIG
	SimmMarkerPlacementParams& operator=(const SimmMarkerPlacementParams &aMarkerPlacementParams);
#endif
   void SimmMarkerPlacementParams::copyData(const SimmMarkerPlacementParams &aMarkerPlacementParams);

	void peteTest() const;

	bool isDefault() const;

	ArrayPtrs<SimmMarker> &getMarkerSet() const
	{
		return _markerSet;
	}
	std::string &getStaticPoseFilename() const
	{
		return _markerFileName;
	}
	void getTimeRange(double& startTime, double &endTime) const
	{
		startTime = _timeRange[0];
		endTime = _timeRange[1];
	}
	std::string &SimmMarkerPlacementParams::getCoordinateFileName() const
    {
        return _coordinateFileName;
    }
    
    ArrayPtrs<SimmCoordinate> &getCoordinateSet()
    {
        return _coordinateSet;
    }


	/** Add a coordinate to the coordinate set */
	void addCoordinate(SimmCoordinate *aCoordinate);
	void writeOutputFiles(SimmModel* aModel, Storage& aStorage) const;
protected:

private:
	void setNull();
	void setupProperties();
//=============================================================================
};	// END of class SimmMarkerPlacementParams

}; //namespace
//=============================================================================
//=============================================================================

#endif // __SimmMarkerPlacementParams_h__


