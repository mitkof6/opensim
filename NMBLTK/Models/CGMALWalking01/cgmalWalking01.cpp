// cgmalWalking01.cpp
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//=============================================================================
// INCLUDES
//=============================================================================
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <float.h>
#include <RD/Tools/rdMath.h>
#include <RD/Simulation/Model/rdBody.h>
#include <RD/Simulation/Model/rdModel.h>
#include <RD/Simulation/Model/rdSprings.h>
#include <RD/Simulation/SDFast/sdfast.h>
#include "cgmalWalking01.h"


//=============================================================================
// CONSTANTS
//=============================================================================

// NAMES
static char* bNames[] =
	{ "RFoot","RTibia","RFemur","HAT","LFemur","LTibia","LFoot" };
static char* qNames[] =
	{	"RFoot_X","RFoot_Y","RFoot_Angle",
		"RAnkle_Plantarflexion","RKnee_Flexion","RHip_Extension",
		"LHip_Extension","LKnee_Flexion","LAnkle_Plantarflexion" };
static char* uNames[] =
	{	"RFoot_X_u","RFoot_Y_u","RFoot_Angle_u",
		"RAnkle_Plantarflexion_u","RKnee_Flexion_u","RHip_Extension_u",
		"LHip_Extension_u","LKnee_Flexion_u","LAnkle_Plantarflexion_u" };

static char* geomFileNames[] =
{ 
	"Geometry//r_foot.vtp",
	"Geometry//r_tibia.vtp",
	"Geometry//r_femur.vtp",
	"Geometry//r_pelvis.vtp",
	"Geometry//sacrum.vtp",
	"Geometry//l_pelvis.vtp",
	"Geometry//l_femur.vtp",
	"Geometry//l_tibia.vtp",
	"Geometry//l_foot.vtp" 
};

static int numGeomFiles[] =
{
	1, 1, 1, 3, 1, 1, 1
};

//=============================================================================
// CONSTRUCTOR(S) AND DESTRUCTOR
//=============================================================================
//_____________________________________________________________________________
/**
 * Destructor.
 */
cgmalWalking01::~cgmalWalking01()
{
}
//_____________________________________________________________________________
/**
 * Default constructor.
 */
cgmalWalking01::cgmalWalking01(rdActuatorSet *aActuators,rdContactForceSet *aContacts) :
	rdActuatedModel_SDFast(aActuators,aContacts)
{
	setNull();

	// CONSTRUCT INITIAL STATES
	constructInitialStates();

	// CONSTRUCT GEOMETRIC BODIES
	constructBodies();
	constructGeometry();

	// CONSTRUCT NAMES
	constructNames();

	// Set model name for display purposes
	setName("cgmalWalking");

	// Set initial states here. Probably this will need to move
	int i;
	int numStates = getNY();
	double *stateValues = new double[numStates];
	for(i=0; i<numStates; i++)
		stateValues[i] = 0.0;
	
	setStates(stateValues);
	delete[] stateValues;

	// Set Body xforms 
	double *origin = new double[3];
	origin[0] = origin[1] = origin[2] = 0.0;
	double *translation = new double[3];
	double *rotations = new double[3];
	double	dirCos[3][3];

	for(i=0;i<getNB(); i++){
		if (i==getGroundID())
			continue;
		for(int di=0; di<3; di++)
			for(int dj=0; dj<3; dj++)
				dirCos[di][dj]=0.0;
		getPosition(i, origin, translation);
		getDirectionCosines(i, dirCos);
		// Get the rotation angles. Assumtion is X, Y, then Z
		convertDirectionCosinesToAngles(dirCos, &rotations[0], &rotations[1], &rotations[2]);
		rdBody *curBody = getBody(i);
		curBody->rotateDegrees(rotations);
		curBody->translate(translation);
	}
}


//=============================================================================
// CONSTRUCTION METHODS
//=============================================================================
//_____________________________________________________________________________
/**
 * Set member variables to their appropriate null values.
 */
void cgmalWalking01::
setNull()
{
}
//_____________________________________________________________________________
/**
 * Construct the valid initial states.
 */
void cgmalWalking01::
constructInitialStates()
{
	rdArray<double> yi(0.0,getNY());
	getInitialStates(&yi[0]);
	// specify initial states here...
	setInitialStates(&yi[0]);
}
//_____________________________________________________________________________
/**
 * Construct the names of the various components of the model.
 */
void cgmalWalking01::
constructNames()
{
	int i;
	int nq = cgmalWalking01::getNQ();
	int nu = cgmalWalking01::getNU();

	// BODIES
	for(i=0;i<getNB();i++) {
		setBodyName(i,bNames[i]);
		if (i!=getGroundID())
			getBody(i)->setName(bNames[i]);
	}

	// Q
	for(i=0;i<nq;i++) setCoordinateName(i,qNames[i]);

	// U
	for(i=0;i<nu;i++) setSpeedName(i,uNames[i]);
}

//_____________________________________________________________________________
/**
 * Read system description and fill in data to describe visible properties of model.
 */	

void cgmalWalking01::
constructGeometry()
{
	// Body Geometry abd preferences
	int curIndex =0;
	char *resourceDirectory= getenv("SIMTK_RESOURCE_DIR");
	char *curDirectory = ".";
	if (!resourceDirectory)
		resourceDirectory = curDirectory;
	for(int i=0;i<getNB();i++) {
		// Actual body has been constructed by constructBodies()
		if (i==getGroundID())
			continue;
		int numFiles = numGeomFiles[i];
		getBody(i)->setNumGeometryFiles(numFiles);
		// Set actual file names
		for(int subSegment=0; subSegment<numFiles; subSegment++, curIndex++){
			char *fullFileName = new char[strlen(resourceDirectory)+strlen(geomFileNames[curIndex])+1];
			strcpy(fullFileName, resourceDirectory);
			strcat(fullFileName, geomFileNames[curIndex]);
			getBody(i)->setGeometryFileName(subSegment, fullFileName);
			delete[] fullFileName;
		}
	}
}


