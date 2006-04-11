// simmIKTrialParams.cpp
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


//=============================================================================
// INCLUDES
//=============================================================================
#include "simmIKTrialParams.h"
#include "simmModel.h"
#include "simmMotionData.h"

//=============================================================================
// STATICS
//=============================================================================
using namespace std;

//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Default constructor.
 */
simmIKTrialParams::simmIKTrialParams() :
   _inputMarkerFileName(_inputMarkerFileNameProp.getValueStr()),
   _inputCoordinateFileName(_inputCoordinateFileNameProp.getValueStr()),
   _inputAnalogFileName(_inputAnalogFileNameProp.getValueStr()),
	_timeRange(_timeRangeProp.getValueDblArray()),
   _kinematicsSmoothing(_kinematicsSmoothingProp.getValueDbl()),
   _groundReactionSmoothing(_groundReactionSmoothingProp.getValueDbl()),
   _includeMarkers(_includeMarkersProp.getValueBool()),
	_outputMotionFileName(_outputMotionFileNameProp.getValueStr()),
	_notes(_notesProp.getValueStr())
{
	setNull();
}
//_____________________________________________________________________________
/**
 * Constructor from an XML node
 */
simmIKTrialParams::simmIKTrialParams(DOMElement *aElement) :
   rdObject(aElement),
   _inputMarkerFileName(_inputMarkerFileNameProp.getValueStr()),
   _inputCoordinateFileName(_inputCoordinateFileNameProp.getValueStr()),
   _inputAnalogFileName(_inputAnalogFileNameProp.getValueStr()),
	_timeRange(_timeRangeProp.getValueDblArray()),
   _kinematicsSmoothing(_kinematicsSmoothingProp.getValueDbl()),
   _groundReactionSmoothing(_groundReactionSmoothingProp.getValueDbl()),
   _includeMarkers(_includeMarkersProp.getValueBool()),
	_outputMotionFileName(_outputMotionFileNameProp.getValueStr()),
	_notes(_notesProp.getValueStr())
{
	setNull();
	updateFromXMLNode();
}

//_____________________________________________________________________________
/**
 * Destructor.
 */
simmIKTrialParams::~simmIKTrialParams()
{
}

//_____________________________________________________________________________
/**
 * Copy constructor.
 *
 * @param aMarkerPlacementParams simmIKTrialParams to be copied.
 */
simmIKTrialParams::simmIKTrialParams(const simmIKTrialParams &aIKTrialParams) :
   rdObject(aIKTrialParams),
   _inputMarkerFileName(_inputMarkerFileNameProp.getValueStr()),
   _inputCoordinateFileName(_inputCoordinateFileNameProp.getValueStr()),
   _inputAnalogFileName(_inputAnalogFileNameProp.getValueStr()),
	_timeRange(_timeRangeProp.getValueDblArray()),
   _kinematicsSmoothing(_kinematicsSmoothingProp.getValueDbl()),
   _groundReactionSmoothing(_groundReactionSmoothingProp.getValueDbl()),
   _includeMarkers(_includeMarkersProp.getValueBool()),
	_outputMotionFileName(_outputMotionFileNameProp.getValueStr()),
	_notes(_notesProp.getValueStr())
{
	setupProperties();
	copyData(aIKTrialParams);
}
//_____________________________________________________________________________
/**
 * Copy this IK Trial params and return a pointer to the copy.
 * The copy constructor for this class is used.
 *
 * @return Pointer to a copy of this simmIKTrialParams.
 */
rdObject* simmIKTrialParams::copy() const
{
	simmIKTrialParams *IKTrialParams = new simmIKTrialParams(*this);
	return(IKTrialParams);
}
//_____________________________________________________________________________
/**
 * Copy this simmIKTrialParams and modify the copy so that it is consistent
 * with a specified XML element node.
 *
 * The copy is constructed by first using
 * simmIKTrialParams::simmIKTrialParams(DOMElement*) in order to establish the
 * relationship of the simmIKTrialParams object with the XML node. Then, the
 * assignment operator is used to set all data members of the copy to the
 * values of this simmIKTrialParams object. Finally, the data members of the
 * copy are updated using simmIKTrialParams::updateFromXMLNode().
 *
 * @param aElement XML element. 
 * @return Pointer to a copy of this simmIKTrialParams.
 */
rdObject* simmIKTrialParams::copy(DOMElement *aElement) const
{
	simmIKTrialParams *IKTrialParams = new simmIKTrialParams(aElement);
	*IKTrialParams = *this;
	IKTrialParams->updateFromXMLNode();
	return(IKTrialParams);
}

void simmIKTrialParams::copyData(const simmIKTrialParams &aIKTrialParams)
{
	_inputMarkerFileName = aIKTrialParams._inputMarkerFileName;
	_inputCoordinateFileName = aIKTrialParams._inputCoordinateFileName;
	_inputAnalogFileNameProp = aIKTrialParams._inputAnalogFileNameProp;
	_timeRange = aIKTrialParams._timeRange;
	_kinematicsSmoothing = aIKTrialParams._kinematicsSmoothing;
	_groundReactionSmoothing = aIKTrialParams._groundReactionSmoothing;
	_includeMarkers = aIKTrialParams._includeMarkers;
	_outputMotionFileName = aIKTrialParams._outputMotionFileName;
	_notes = aIKTrialParams._notes;
}


//=============================================================================
// CONSTRUCTION
//=============================================================================
//_____________________________________________________________________________
/**
 * Set the data members of this simmIKTrialParams to their null values.
 */
void simmIKTrialParams::setNull()
{
	setupProperties();
	setType("IKTrial");
	setName("");
}
//_____________________________________________________________________________
/**
 * Connect properties to local pointers.
 */
void simmIKTrialParams::setupProperties()
{
	_inputMarkerFileNameProp.setName("inputMarkerFile");
	_propertySet.append(&_inputMarkerFileNameProp);

	_inputCoordinateFileNameProp.setName("inputCoordinateFile");
	_propertySet.append(&_inputCoordinateFileNameProp);

	_inputAnalogFileNameProp.setName("inputAnalogFile");
	_propertySet.append(&_inputAnalogFileNameProp);

	const double defaultTimeRange[] = {-1.0, -1.0};
	_timeRangeProp.setName("timeRange");
	_timeRangeProp.setValue(2, defaultTimeRange);
	_propertySet.append(&_timeRangeProp);

	_kinematicsSmoothingProp.setName("kinematicsSmoothing");
	_kinematicsSmoothingProp.setValue(-1.0);
	_propertySet.append(&_kinematicsSmoothingProp);

	_groundReactionSmoothingProp.setName("groundReactionSmoothing");
	_groundReactionSmoothingProp.setValue(-1.0);
	_propertySet.append(&_groundReactionSmoothingProp);

	_includeMarkersProp.setName("includeMarkers");
	_includeMarkersProp.setValue(false);
	_propertySet.append(&_includeMarkersProp);

	_outputMotionFileNameProp.setName("outputMotionFile");
	_propertySet.append(&_outputMotionFileNameProp);

	_notesProp.setName("notes");
	_propertySet.append(&_notesProp);
}

simmIKTrialParams& simmIKTrialParams::operator=(const simmIKTrialParams &aIKTrialParams)
{
	// BASE CLASS
	rdObject::operator=(aIKTrialParams);

	copyData(aIKTrialParams);

	return(*this);
}

//_____________________________________________________________________________
/**
 * Get correct data for coordinate values (based on input coordinate file specification).
 * If file is specified, then it's read, and any coordinate that's specified as "FromFile" 
 * is updated from this file. N
 OTE: Caller is responsible for freeing up the returned simmMotionData
 *
 * @param aModel simmModel to use. 
 * @return Pointer to a simmMotionData.
 */
simmMotionData *simmIKTrialParams::getCoordinateValues(simmModel& aModel) const
{
	simmMotionData* outputMotionData=0;
	/* Update the model with the coordinates specified
	* by the user in the IKParameters section. If "fromFile"
	* was specified as a value in aCoordinateSet, it will remain
	* that way in the model's coordinate array.
	*/

	if (!_inputCoordinateFileNameProp.getUseDefault())
	{
		simmMotionData* coordinateValues = new simmMotionData(_inputCoordinateFileName);

		/* For each coordinate whose "value" field the user specified
		* as "fromFile", read the value from the first frame in the
		* coordinate file (a SIMM motion file) and use it to overwrite
		* the "fromFile" specification. For coordinates whose "value"
		* field is not "fromFile," remove that coordinate from the
		* file by changing the column name to something that will
		* not be recognized. This must be done because during IK,
		* all coordinates that have data in the file will use that
		* data, even if the coordinate was not specified "fromFile."
		*/
		if (coordinateValues->getNumColumns() > 0)
		{
			for (int i = 0; i < aModel.getCoordinates().getSize(); i++)
			{
				double value = coordinateValues->getValue(aModel.getCoordinates()[i]->getName(), 0);

				/* If the coordinate was not found in the file, NAN is returned. */
				if (value == rdMath::NAN)
				{
					/* If fromFile was specified, report an error and reset
					* the value field to 0.0.
					*/
					if (aModel.getCoordinates()[i]->getValueStr() == "fromFile")
					{
						aModel.getCoordinates()[i]->setValue(0.0);
						string errorMessage = "Coordinate " + aModel.getCoordinates()[i]->getName() +
							"specified as /'fromFile/', but no value found in " + _inputCoordinateFileName;
						throw rdException(errorMessage);
					}
				}
				else
				{
					/* If the coordinate was found in the file, and if fromFile
					* was specified, initialize the coordinate's value to the
					* value from the first row of data in the file.
					*/
					if (aModel.getCoordinates()[i]->getValueStr() == "fromFile")
					{
						bool lockedState = aModel.getCoordinates()[i]->isLocked();
						aModel.getCoordinates()[i]->setLocked(false);
						aModel.getCoordinates()[i]->setValue(value);
						aModel.getCoordinates()[i]->setLocked(lockedState);
						cout << "Values for coordinate " << aModel.getCoordinates()[i]->getName() << " will be read from " <<	_inputCoordinateFileName << endl;
					}
					else
					{
						/* The coordinate was found in the file, but fromFile was
						* not specified. Change the name of the column in the file
						* so it will be ignored by the IK.
						*/
						int columnIndex = coordinateValues->getColumnIndex(aModel.getCoordinates()[i]->getName());
						if (columnIndex >= 0)
							coordinateValues->setColumnLabel(columnIndex, string("ZZZZ"));
					}
				}
			}
		}
		outputMotionData = coordinateValues;
	}

	return outputMotionData;
}
		
/* Find the range of frames that is between start time and end time
 * (inclusive). Return the indices of the bounding frames.
 */
void simmIKTrialParams::findFrameRange(const rdStorage& aData, int& oStartFrame, int& oEndFrame) const
{
	int i;
	double time;

	oStartFrame = 0;
	oEndFrame = aData.getSize() - 1;

	if (_timeRange[0] > _timeRange[1])
	{
		double tmp = _timeRange[0];
		_timeRange[0] = _timeRange[1];
		_timeRange[1] = tmp;
	}

	for (i = aData.getSize() - 1; i >= 0 ; i--)
	{
		aData.getTime(i, time);
		if (time <= _timeRange[0] + rdMath::ZERO)
		{
			oStartFrame = i;
			break;
		}
	}

	for (i = oStartFrame; i < aData.getSize(); i++)
	{
		aData.getTime(i, time);
		if (time >= _timeRange[1] - rdMath::ZERO)
		{
			oEndFrame = i;
			break;
		}
	}
}

void simmIKTrialParams::peteTest() const
{
	cout << "   IKTrial: " << getName() << endl;
	cout << "      inputMarkerFileName: " << _inputMarkerFileName << endl;
	cout << "      inputCoordinateFileName: " << _inputCoordinateFileName << endl;
	cout << "      inputAnalogFileName: " << _inputAnalogFileName << endl;
	cout << "      timeRange: " << _timeRange << endl;
	cout << "      kinematicsSmoothing: " << _kinematicsSmoothing << endl;
	cout << "      groundReactionSmoothing: " << _groundReactionSmoothing << endl;
	cout << "      includeMarkers: " << _includeMarkers << endl;
	cout << "      outputMotionFile: " << _outputMotionFileName << endl;
	cout << "      notes: " << _notes << endl;
}
