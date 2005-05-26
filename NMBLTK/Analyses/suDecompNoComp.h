// suDecompNoComp.h
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	AUTHOR: Frank C. Anderson
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
#ifndef __suDecompNoComp_h__
#define __suDecompNoComp_h__


//=============================================================================
// INCLUDES
//=============================================================================
#include <RD/Tools/rdTools.h>
#include <RD/Tools/rdMath.h>
#include <RD/Tools/rdStorage.h>
#include <RD/Simulation/Model/rdModel.h>
#include <RD/Simulation/Model/rdAnalysis.h>
#include "suAnalysesDLL.h"


//=============================================================================
//=============================================================================
/**
 * An abstract base class for supporting the decomposition of contact
 * forces.
 *
 * @author Frank C. Anderson
 * @version 1.0
 */
class SUANALYSES_API suDecompNoComp : public rdAnalysis 
{
//=============================================================================
// DATA
//=============================================================================
public:
	static const char *ADDON_COMPONENT_NAMES[];

protected:
	/** Number of action components. */
	int _nc;
	/** Number of independent action components. */
	int _nic;
	/** Number of contact points. */
	int _np;
	/** Contact threashold for when to perform a decomposition. */
	double _contactThreshold;
	/** Flag to indicate whether or not to use preset contact established
	settings.  If this flag is set to true, computation of contact forces
	is not performed in order to determine if contact has been established.
	Rather, it is assumed that the caller has preset the desired
	contact-established settings. */
	bool _usePresetContactEstablishedSettings;
	/** Array of flags to indicate whether or not contact has been established
	at each of the contact pooints. */
	bool *_contactEstablished;
	/** Contiguous memory allocation for the force decomposition results. */
	double *_fContig;
	/** Arrays for storing the current force decomposition. */
	double ***_f;
	/** Storage objects for storing the time history of the decomposition. */
	rdStorage **_fStore;
	/** Storage objects for storing the contact point accelerations */
	rdStorage **_cpaStore;
	/** Flag which indicates whether or not the contact point accelerations
	are being recorded */
	bool _recordContactPointAccelerations;

private:
	/** Flag which indicates whether or not the decomposition is NULL.  A
	NULL decomposition means no decompostion- all induced contact forces
	zero. */
	bool _useNullDecomposition;

//=============================================================================
// METHODS
//=============================================================================
public:
	suDecompNoComp(rdModel *aModel);
	suDecompNoComp(rdModel *aModel,char *aBaseName,char *aDir=NULL,
		char *aExtension=NULL);
	virtual ~suDecompNoComp();
private:
	void setNull();
	void initializeNumbers();
	void constructDescription();
	void constructColumnLabels();
	void allocateElementVectors();
	void allocateStoragePointers();
	void allocateStorage();
	void deleteStorage();
	void createNullDecomposition();

public:
	//--------------------------------------------------------------------------
	// GET AND SET
	//--------------------------------------------------------------------------
	// NUMBERS
	int getNumComponents();
	int getNumIndependentComponents();
	int getNumElements();
	// CONTACT THREASHOLD
	void setContactThreshold(double aThreshold);
	double getContactThreshold();
	// CONTACT ESTABLISHED
	void setUsePresetContactEstablishedSettings(bool aTrueFalse);
	bool getUsePresetContactEstablishedSettings() const;
	void setContactEstablished(int aIndex,bool aTrueFalse);
	bool getContactEstablished(int aIndex) const;
	// RECORD CONTACT POINT ACCELERATIONS
	void setRecordContactPointAccelerations(bool aTrueFalse);
	bool getRecordContactPointAccelerations();
	// STORAGE
	virtual void setStorageCapacityIncrements(int aIncrement);
	const rdStorage* getDecomposition(int aC) const;
	// NULL DECOMPOSITION
	bool getUseNullDecomposition();

	//--------------------------------------------------------------------------
	// OPERATIONS
	//--------------------------------------------------------------------------
	virtual void compute(double *aXPrev,double *aYPrev,
		int aStep,double aDT,double aT,double *aX,double *aY) = 0;

	//--------------------------------------------------------------------------
	// UTILITY
	//--------------------------------------------------------------------------

	//--------------------------------------------------------------------------
	// ANALYSIS
	//--------------------------------------------------------------------------
	virtual int
		begin(int aStep,double aDT,double aT,double *aX,double *aY,
		void *aClientData=NULL);
	virtual int
		step(double *aXPrev,double *aYPrev,
		int aStep,double aDT,double aT,double *aX,double *aY,
		void *aClientData=NULL);
	virtual int
		end(int aStep,double aDT,double aT,double *aX,double *aY,
		void *aClientData=NULL);

	//--------------------------------------------------------------------------
	// IO
	//--------------------------------------------------------------------------
	virtual int
		printResults(const char *aBaseName,const char *aDir=NULL,
		double aDT=-1.0,const char *aExtension=".sto");
private:
	virtual int
		readDecomposition(char *aBaseName,char *aDir=NULL,
		char *aExtension=NULL);


//=============================================================================
};	// END of class suDecompNoComp
//=============================================================================
//=============================================================================


#endif // #ifndef __suDecompNoComp_h__
