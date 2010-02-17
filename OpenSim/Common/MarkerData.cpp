// MarkerData.cpp
// Author: Peter Loan
/* Copyright (c)  2005, Stanford University and Peter Loan.
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
#include <iostream>
#include <fstream>
#include <math.h>
#include <float.h>
#include "MarkerData.h"
#include "SimmIO.h"
#include "SimmMacros.h"
#include "SimTKcommon.h"

//=============================================================================
// STATICS
//=============================================================================
using namespace std;
using namespace OpenSim;
using SimTK::Vec3;

//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Default constructor.
 */
MarkerData::MarkerData() :
	_numFrames(0),
	_numMarkers(0),
	_markerNames("")
{
}

//_____________________________________________________________________________
/**
 * Constructor from a TRB/TRC file.
 */
MarkerData::MarkerData(const string& aFileName) :
	_numFrames(0),
	_numMarkers(0),
	_markerNames("")
{

#if 0
   if (!aFileName)
		return;

   if (!lookForFile(aFileName, gWorkingDir.c_str(), actualFilename))
   {
      return smFileError;
   }
#endif

   /* Check if the suffix is TRC or TRB. Will read TRC by default */
	string suffix;
   int dot = aFileName.find_last_of(".");
   suffix.assign(aFileName, dot+1, 3);

   if ((suffix == "TRB") || (suffix == "trb"))
      readTRBFile(aFileName, *this);
   else
      readTRCFile(aFileName, *this);

	_fileName = aFileName;

	cout << "Loaded marker file " << _fileName << " (" << _numMarkers << " markers, " << _numFrames << " frames)" << endl;
}

//_____________________________________________________________________________
/**
 * Destructor.
 */
MarkerData::~MarkerData()
{
}

//=============================================================================
// I/O
//=============================================================================
//_____________________________________________________________________________
/**
 * Read TRC file.
 *
 * @param aFilename name of TRC file.
 * @param aSMD MarkerData object to hold the file contents
 */
void MarkerData::readTRCFile(const string& aFileName, MarkerData& aSMD)
{
   ifstream in;
   string line, buffer;
   int frameNum, coordsRead;
   double time;
	SimTK::Vec3 coords;

	if (aFileName.empty())
		throw Exception("MarkerData.readTRCFile: ERROR- Marker file name is empty",__FILE__,__LINE__);

   in.open(aFileName.c_str());

	if (!in.good())
	{
		string errorMessage;
		errorMessage = "Unable to open marker file " + aFileName;
		throw Exception(errorMessage);
	}

   readTRCFileHeader(in, aFileName, aSMD);

   /* read frame data */
   while (getline(in, line))
   {
      /* skip over any blank lines */
      if (findFirstNonWhiteSpace(line) == -1)
         continue;

		if (aSMD._frames.getSize() == aSMD._numFrames)
		{
#if 0
			if (gUseGlobalMessages)
			{
				gErrorBuffer += "Extra data found at end of tracked marker file. ";
				gErrorBuffer += "Header declared only " + intToString(trc->header.numFrames) + " frames.\n";
			}
			rc = smFileWarning;
#endif
			break;
		}

      if (!readIntegerFromString(line, &frameNum))
      {
#if 0
         if (gUseGlobalMessages)
            gErrorBuffer += "Could not read frame number in tracked marker file.\n";
         rc = smFileError;
         goto cleanup;
#endif
      }

      if (!readDoubleFromString(line, &time))
      {
#if 0
         if (gUseGlobalMessages)
            gErrorBuffer += "Could not read time in tracked marker file.\n";
         rc = smFileError;
         goto cleanup;
#endif
      }

		MarkerFrame *frame = new MarkerFrame(aSMD._numMarkers, frameNum, time, aSMD._units);

      /* keep reading sets of coordinates until the end of the line is
       * reached. If more coordinates were read than there are markers,
       * return an error.
       */
      coordsRead = 0;
      while (readCoordinatesFromString(line, &coords[0]))
      {
         if (coordsRead >= aSMD._numMarkers)
         {
            break;

#if 0  // Don't return an error because many TRC files have extra data at the ends of rows
            if (gUseGlobalMessages)
               gErrorBuffer += "Extra data found in frame number " + intToString(frameNum) +
                               " in tracked marker file.\n";
            rc = smFileError;
            // delete the current markerCoordList because framesRead has not been incremented yet.
            delete [] f->markerCoordList;
            goto cleanup;
#endif
         }
         if (coordsRead < aSMD._numMarkers)
				frame->addMarker(coords);
         coordsRead++;
      }

      if (coordsRead < aSMD._numMarkers)
      {
#if 0
         if (gUseGlobalMessages)
            gErrorBuffer += " Missing data in frame number " + intToString(frameNum) +
                            " in tracked marker file.\n";
         rc = smFileError;
         // delete the current markerCoordList because framesRead has not been incremented yet.
         delete [] f->markerCoordList;
         goto cleanup;
#endif
      }
		aSMD._frames.append(frame);
   }

   if (aSMD._frames.getSize() < aSMD._numFrames)
   {
#if 0
      if (gUseGlobalMessages)
         gErrorBuffer += "Missing data in tracked marker file. Only " + intToString(framesRead) + " of " +
                         intToString(trc->header.numFrames) + " frames found.\n";
      rc = smFileError;
      goto cleanup;
#endif
		aSMD._numFrames = aSMD._frames.getSize();
   }

   /* If the user-defined frame numbers are not continguous from the first frame to the
    * last, reset them to a contiguous array. This is necessary because the user-defined
    * numbers are used to index the array of frames.
    */
	if (aSMD._frames[aSMD._numFrames-1]->getFrameNumber() - aSMD._frames[0]->getFrameNumber() !=
		 aSMD._numFrames - 1)
   {
		int firstIndex = aSMD._frames[0]->getFrameNumber();
      for (int i = 1; i < aSMD._numFrames; i++)
			aSMD._frames[i]->setFrameNumber(firstIndex + i);
   }

#if 0
   if (gUseGlobalMessages)
   {
      gMessage += "TRC file " + actualFileName + "\n\t" + intToString(trc->header.numFrames)
                  + " frames\n\t" + intToString(trc->header.numMarkers) + " markers/frame\n";
      gMessage += "Read " + intToString(framesRead) + " frames.\n";
   }
#endif

//cleanup:
   in.close();
}

//_____________________________________________________________________________
/**
 * Read TRC header.
 *
 * @param aStream stream to read from.
 * @param aFileName name of file that stream is from.
 * @param aSMD MarkerData object to hold the file contents
 */
void MarkerData::readTRCFileHeader(ifstream &aStream, const string& aFileName, MarkerData& aSMD)
{
   string line, buffer;
   int pathFileType, markersRead;
   bool ok = true;

   /* read first line in TRC header */
   getline(aStream, line);

   /* read "PathFileType" and path file type */
   readStringFromString(line, buffer);
   readIntegerFromString(line, &pathFileType);
   if (buffer != "PathFileType" || (pathFileType != 3 && pathFileType != 4))
   {
		throw Exception("MarkerData: ERR- File "+aFileName+" does not appear to be a valid TRC file",__FILE__,__LINE__);
#if 0
      if (gUseGlobalMessages)
         gErrorBuffer += "Unknown file type " + intToString(pathFileType) + " in TRC file" + actualFileName;
      return smFileError;
#endif
   }

   /* read line 2 - header info column names */
   getline(aStream, line);

   /* read line 3 - header info */
   getline(aStream, line);
   
   /* read first 5 parameters from file */
   ok = readDoubleFromString(line, &aSMD._dataRate);
   ok = ok && readDoubleFromString(line, &aSMD._cameraRate);
   ok = ok && readIntegerFromString(line, &aSMD._numFrames);
   ok = ok && readIntegerFromString(line, &aSMD._numMarkers);
   ok = ok && readStringFromString(line, buffer);

   if (pathFileType == 3)
   {
      if (!ok)
      {
#if 0
         if (gUseGlobalMessages)
            gErrorBuffer += "Could not read line 3 in TRC file " + actualFileName + ".\n";
         return smFormatError;
#endif
      }
      aSMD._originalDataRate = aSMD._dataRate;
      aSMD._originalStartFrame = 1;
      aSMD._originalNumFrames = aSMD._numFrames;
   }
   else if (pathFileType == 4)
   {
      ok = ok && readDoubleFromString(line, &aSMD._originalDataRate);
      ok = ok && readIntegerFromString(line, &aSMD._originalStartFrame);
      ok = ok && readIntegerFromString(line, &aSMD._originalNumFrames);
      if (!ok)
      {
#if 0
         if (gUseGlobalMessages)
            gErrorBuffer += "Could not read line3 in TRC file " + actualFileName + ".\n";
         return smFormatError;
#endif
      }
   }

   aSMD._units = Units(buffer);

   /* read line 4 - trc data column names */
   getline(aStream, line);

   /* read Frame# and Time */
   readStringFromString(line, buffer);
   readStringFromString(line, buffer);

   /* read the marker names */
   markersRead = 0;
   while (!line.empty())
   {
      if (!readTabDelimitedStringFromString(line, buffer))
         break;
      if (markersRead >= aSMD._numMarkers)
      {
#if 0
         if (gUseGlobalMessages)
            gMessage += "More marker names in TRC file than in model. Ignoring extra marker names.\n";
         break;
#endif
      }
		aSMD._markerNames.append(buffer);
      markersRead++;
   }

	/* If we don't read the header, we'll throw meaningful exception and abort rather than crash the machine!! */
  if (markersRead < aSMD._numMarkers)
   {
		string errorMessage;
		errorMessage = "Could not read all marker names in TRC file " + aFileName + 
			". Make sure there's exactly one tab per column & that Marker names are tab separated in header.\n";
		throw Exception(errorMessage);

   }

   /* Store the position of the pointer into the file just before reading the
    * coordinate labels. This is done because the first frame is read incorrectly
    * in certain cases.
	 */
   long pos = aStream.tellg();
   /* read line 5 - coordinate labels (X1 Y1 Z1 X2 Y2 Z2 ...) */
   getline(aStream, line);

   /* The following code supports 0 or 1 blank lines before the first
    * frame of data.  Read the line of code - if there is a blank line of code,
    * read the next line which will contain the data.
    */
   getline(aStream, line);
   if (line.empty())
      getline(aStream, line);

   if (!readIntegerFromString(line, &aSMD._firstFrameNumber))
      aSMD._firstFrameNumber = 1;

   /* reposition the pointer into the file so it points to before the coordinate
    * labels */
   aStream.seekg(pos, ios::beg);

   /* reread the coordinate labels so pointer into file points to data */
   getline(aStream, line);
   if (line.empty())
      getline(aStream, line);
}

//_____________________________________________________________________________
/**
 * Read TRB file.
 *
 * @param aFileName name of file to read.
 * @param aSMD MarkerData object to hold the file contents
 */
void MarkerData::readTRBFile(const string& aFileName, MarkerData& aSMD)
{
#if 0
   int i, j, index, headerSize, numMarkersThisFrame;
   unsigned short header[6];
   long data[100];
   FILE* file;

   trc->filename = new char [actualFileName.size() + 1];
   strcpy(trc->filename, actualFileName.c_str());

   readTRBFileHeader(actualFileName, &trc->header, headerSize);

   file = fopen(actualFileName.c_str(), "rb");

   trc->frameList = new smTRCFrame [trc->header.numFrames];

   fseek(file, headerSize, SEEK_SET);

   for (i = 0; i < trc->header.numFrames; i++)
   {
      trc->frameList[i].frameNum = i;
      trc->frameList[i].time = (double) i / trc->header.dataRate;
      trc->frameList[i].units = trc->header.units;

      trc->frameList[i].numMarkers = trc->header.numMarkers;
      trc->frameList[i].markerCoordList = new smPoint3 [trc->frameList[i].numMarkers];

      // initialize all the markers to UNDEFINED
      for (j = 0; j < trc->frameList[i].numMarkers; j++)
      {
         trc->frameList[i].markerCoordList[j][0] = UNDEFINED_DOUBLE;
         trc->frameList[i].markerCoordList[j][1] = UNDEFINED_DOUBLE;
         trc->frameList[i].markerCoordList[j][2] = UNDEFINED_DOUBLE;
      }

      // now read the header to see how many markers are present
      for (j = 0; j < 6; j++)
         header[j] = _read_binary_unsigned_short(file);

      numMarkersThisFrame = (header[4] - 3) / 6;

      for (j = 0; j < numMarkersThisFrame; j++)
      {
         fread(data, 6*4, 1, file);

         // the index of this marker is stored in the first data element
         index = data[0] - 1;

         // if the index is good, copy the marker coordinates
         if (index >= 0 && index < trc->frameList[i].numMarkers)
         {
            trc->frameList[i].markerCoordList[index][0] = *(float *)(&data[1]);
            trc->frameList[i].markerCoordList[index][1] = *(float *)(&data[2]);
            trc->frameList[i].markerCoordList[index][2] = *(float *)(&data[3]);
         }
      }
   }

   goto finish;

//invalid:
   if (gUseGlobalMessages)
      gErrorBuffer += "Cannot read " + actualFileName + ". File format is invalid.";
   return smFormatError;

   smFreeTRCStruct(trc);

finish:
   fclose(file);
   return smNoError;
#endif
}

//=============================================================================
// UTILITY
//=============================================================================
//_____________________________________________________________________________
/**
 * Find the range of frames that is between start time and end time
 * (inclusive).
 *
 * @param aStartTime start time.
 * @param aEndTime end time.
 * @param rStartFrame index of start frame is returned here.
 * @param rEndFrame index of end frame is returned here.
 */
void MarkerData::findFrameRange(double aStartTime, double aEndTime, int& rStartFrame, int& rEndFrame) const
{
	int i;

	rStartFrame = 0;
	rEndFrame = _numFrames - 1;

	if (aStartTime > aEndTime)
	{
		double tmp = aStartTime;
		aStartTime = aEndTime;
		aEndTime = tmp;
	}

	for (i = _numFrames - 1; i >= 0 ; i--)
	{
		if (_frames[i]->getFrameTime() <= aStartTime + SimTK::Zero)
		{
			rStartFrame = i;
			break;
		}
	}

	for (i = rStartFrame; i < _numFrames; i++)
	{
		if (_frames[i]->getFrameTime() >= aEndTime - SimTK::Zero)
		{
			rEndFrame = i;
			break;
		}
	}
}
//_____________________________________________________________________________
/**
 * Utilities to support the GUI
 *
 * getStartFrameTime: Exposes the time for first frame
 */

double MarkerData::getStartFrameTime() const
{
	if (_numFrames<=0)
		return 1.0;

	return(_frames[0]->getFrameTime());

}
/**
 * Utilities to support the GUI
 *
 * getLastFrameTime: Expose the time for the last frame
 */
double MarkerData::getLastFrameTime() const
{
	if (_numFrames<=0)
		return -1.0;

	return(_frames[_numFrames-1]->getFrameTime());
}

//_____________________________________________________________________________
/**
 * Average all the frames between aStartTime and
 * aEndTime (inclusive) and store the result in the first
 * frame. All other frames are deleted. The time and frame
 * number of this one remaining frame are copied from the
 * startIndex frame. The aThreshold parameter is for printing
 * a warning if any marker moves more than that amount in
 * the averaged frames. aThreshold is specified by the user,
 * and is assumed to be in the units of the marker data.
 *
 * @param aThreshold amount of marker movement that is allowed for averaging.
 * @param aStartTime start time of frame range to average.
 * @param aEndTime end time of frame range to average.
 */
void MarkerData::averageFrames(double aThreshold, double aStartTime, double aEndTime)
{
	if (_numFrames < 2)
		return;

	int startIndex = 0, endIndex = 1;
	double *minX = NULL, *minY = NULL, *minZ = NULL, *maxX = NULL, *maxY = NULL, *maxZ = NULL;

	findFrameRange(aStartTime, aEndTime, startIndex, endIndex);
	MarkerFrame *averagedFrame = new MarkerFrame(*_frames[startIndex]);

	/* If aThreshold is greater than zero, then calculate
	 * the movement of each marker so you can check if it
	 * is greater than aThreshold.
	 */
	if (aThreshold > 0.0)
	{
		minX = new double [_numMarkers];
		minY = new double [_numMarkers];
		minZ = new double [_numMarkers];
		maxX = new double [_numMarkers];
		maxY = new double [_numMarkers];
		maxZ = new double [_numMarkers];
		for (int i = 0; i < _numMarkers; i++)
		{
			minX[i] = minY[i] = minZ[i] =  SimTK::Infinity;
			maxX[i] = maxY[i] = maxZ[i] = -SimTK::Infinity;
		}
	}

	/* Initialize all the averaged marker locations to 0,0,0. Then
	 * loop through the frames to be averaged, adding each marker location
	 * to averagedFrame. Keep track of the min/max XYZ for each marker
	 * so you can compare it to aThreshold when you're done.
	 */
	for (int i = 0; i < _numMarkers; i++)
	{
		int numFrames = 0;
		SimmPoint& avePt = averagedFrame->getMarker(i);
		avePt.set(0.0, 0.0, 0.0);

		for (int j = startIndex; j <= endIndex; j++)
		{
			SimmPoint& pt = _frames[j]->getMarker(i);
			if (pt.isVisible())
			{
				Vec3& coords = pt.get();
				avePt += pt;
				numFrames++;
				if (aThreshold > 0.0)
				{
					if (coords[0] < minX[i])
						minX[i] = coords[0];
					if (coords[0] > maxX[i])
						maxX[i] = coords[0];
					if (coords[1] < minY[i])
						minY[i] = coords[1];
					if (coords[1] > maxY[i])
						maxY[i] = coords[1];
					if (coords[2] < minZ[i])
						minZ[i] = coords[2];
					if (coords[2] > maxZ[i])
						maxZ[i] = coords[2];
				}
			}
		}

		/* Now divide by the number of frames to get the average. */
		if (numFrames > 0)
			avePt /= (double)numFrames;
		else
			avePt.set(SimTK::NaN, SimTK::NaN, SimTK::NaN);
	}

	/* Store the indices from the file of the first frame and
	 * last frame that were averaged, so you can report them later.
	 */
	int startUserIndex = _frames[startIndex]->getFrameNumber();
	int endUserIndex = _frames[endIndex]->getFrameNumber();

	/* Now delete all the existing frames and insert the averaged one. */
	_frames.clearAndDestroy();
	_frames.append(averagedFrame);
	_numFrames = 1;
	_firstFrameNumber = _frames[0]->getFrameNumber();

	if (aThreshold > 0.0)
	{
		for (int i = 0; i < _numMarkers; i++)
		{
			SimmPoint& pt = _frames[0]->getMarker(i);

			if (!pt.isVisible())
			{
				cout << "___WARNING___: marker " << _markerNames[i] << " is missing in frames " << startUserIndex
					  << " to " << endUserIndex << ". Coordinates will be set to NAN." << endl;
			}
			else if (maxX[i] - minX[i] > aThreshold ||
				      maxY[i] - minY[i] > aThreshold ||
				      maxZ[i] - minZ[i] > aThreshold)
			{
				double maxDim = maxX[i] - minX[i];
				maxDim = MAX(maxDim, (maxY[i] - minY[i]));
				maxDim = MAX(maxDim, (maxZ[i] - minZ[i]));
				cout << "___WARNING___: movement of marker " << _markerNames[i] << " in " << _fileName
					  << " is " << maxDim << " (threshold = " << aThreshold << ")" << endl;
			}
		}
	}

	cout << "Averaged frames from time " << aStartTime << " to " << aEndTime << " in " << _fileName
		  << " (frames " << startUserIndex << " to " << endUserIndex << ")" << endl;

	if (aThreshold > 0.0)
	{
		delete [] minX;
		delete [] minY;
		delete [] minZ;
		delete [] maxX;
		delete [] maxY;
		delete [] maxZ;
	}
}

//_____________________________________________________________________________
/**
 * Store the marker data in an Storage object. The object
 * is emptied before adding the marker data.
 *
 * @param aStorage storage block to fill in with marker data.
 */
void MarkerData::makeRdStorage(Storage& rStorage)
{
	/* First clear any existing frames. */
	rStorage.reset(0);

	/* Make the column labels. */
	Array<string> columnLabels;
	columnLabels.append("time");
	for (int i = 0; i < _numMarkers; i++)
	{
		columnLabels.append(_markerNames[i] + "_tx");
		columnLabels.append(_markerNames[i] + "_ty");
		columnLabels.append(_markerNames[i] + "_tz");
	}
	rStorage.setColumnLabels(columnLabels);

	/* Store the marker coordinates in an array of doubles
	 * and add it to the Storage.
	 */
	int numColumns = _numMarkers * 3;
	double* row = new double [numColumns];

	for (int i = 0; i < _numFrames; i++)
	{
		for (int j = 0, index = 0; j < _numMarkers; j++)
		{
			SimTK::Vec3& marker = _frames[i]->getMarker(j).get();
			for (int k = 0; k < 3; k++)
				row[index++] = marker[k];
		}
		rStorage.append(_frames[i]->getFrameTime(), numColumns, row);
	}

	delete [] row;
}

//_____________________________________________________________________________
/**
 * Convert all marker coordinates to the specified units.
 *
 * @param aUnits units to convert to.
 */
void MarkerData::convertToUnits(const Units& aUnits)
{
	double scaleFactor = _units.convertTo(aUnits);

	if (!SimTK::isNaN(scaleFactor))
	{
		/* Scale all marker locations by the conversion factor. */
		for (int i = 0; i < _frames.getSize(); i++)
			_frames[i]->scale(scaleFactor);

		/* Change the units for this object to the new ones. */
		_units = aUnits;
	}
	else
		throw Exception("MarkerData.convertToUnits: ERROR- Model has unspecified units",__FILE__,__LINE__);
}

//=============================================================================
// GET AND SET
//=============================================================================
//_____________________________________________________________________________
/**
 * Get a frame of marker data.
 *
 * @param aIndex index of the row to get.
 * @return Pointer to the frame of data.
 */
MarkerFrame* MarkerData::getFrame(int aIndex) const
{
	if (aIndex < 0 || aIndex >= _numFrames)
		return NULL;

	return _frames[aIndex];
}

//_____________________________________________________________________________
/**
 * Get the index of a marker, given its name.
 *
 * @param aName name of marker.
 * @return Index of the named marker.
 */
int MarkerData::getMarkerIndex(const string& aName) const
{
	for (int i = 0; i < _markerNames.getSize(); i++)
	{
		if (_markerNames[i] == aName)
			return i;
	}

	return -1;
}
