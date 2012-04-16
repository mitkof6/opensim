// VisibleObject.cpp
// Author: Ayman Habib
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

/*  
 * Author:  
 */


//============================================================================
// INCLUDES
//============================================================================
#include <OpenSim/Common/XMLDocument.h>
#include "VisibleObject.h"
#include "Exception.h"
#include "PropertyInt.h"
#include "PropertyStr.h"
#include "PropertyObj.h"
#include "PropertyStrArray.h"
#include "PropertyDblArray.h"
#include "PropertyTransform.h"
#include "Geometry.h"
#include "GeometrySet.h"


using namespace OpenSim;
using namespace std;
using SimTK::Vec3;
using OpenSim::GeometrySet;

//============================================================================
// CONSTANTS
//============================================================================


//=============================================================================
// CONSTRUCTOR(S)
//=============================================================================
//_____________________________________________________________________________
/**
 * Destructor.
 */
VisibleObject::~VisibleObject()
{
	freeGeometry();
	_owner = NULL;
	_dependents.setSize(0);
};

//_____________________________________________________________________________
/**
 * Default constructor.
 */
VisibleObject::VisibleObject():
Object(),
_propGeometrySet(PropertyObj("", GeometrySet())),
_geometrySet((GeometrySet&)_propGeometrySet.getValueObj()),
_scaleFactors(_propScaleFactors.getValueDblVec()),
_transformProp(PropertyTransform("transform", SimTK::Transform())),
_transform(_transformProp.getValueTransform()),
_showAxes(_propShowAxes.getValueBool()),
_displayPreference((DisplayGeometry::DisplayPreference&)_propDisplayPreference.getValueInt()),
_allGeometry(0),
_dependents(0)
{
	// NULL STATES
	setNull();

	// MEMBER VARIABLES
	setName("");
}

//_____________________________________________________________________________
/**
 * Construct an object from file.
 *
 * The object is constructed from the root element of the XML document.
 * The type of object is the tag name of the XML root element.
 *
 * @param aFileName File name of the document.
 */
VisibleObject::VisibleObject(const string &aFileName):
Object(aFileName, false),
_propGeometrySet(PropertyObj("", GeometrySet())),
_geometrySet((GeometrySet&)_propGeometrySet.getValueObj()),
_scaleFactors(_propScaleFactors.getValueDblVec()),
_transformProp(PropertyTransform("transform", SimTK::Transform())),
_transform(_transformProp.getValueTransform()),
_showAxes(_propShowAxes.getValueBool()),
_displayPreference((DisplayGeometry::DisplayPreference&)_propDisplayPreference.getValueInt()),
_allGeometry(0),
_dependents(0)
{
	// NULL STATES
	setNull();

	SimTK::Xml::Element e = updDocument()->getRootDataElement(); 
	updateFromXMLNode(e);
}
//_____________________________________________________________________________
/**
 * Copy constructor.
 *
 * Copy constructors for all VisibleObject's only copy the non-XML variable
 * members of the object; that is, the object's DOMnode and XMLDocument
 * are not copied but set to NULL.  The reason for this is that for the
 * object and all its derived classes to establish the correct connection
 * to the XML document nodes, the the object would need to reconstruct based
 * on the XML document not the values of the object's member variables.
 *
 * There are three proper ways to generate an XML document for an VisibleObject:
 *
 * 1) Construction based on XML file (@see VisibleObject(const char *aFileName)).
 * In this case, the XML document is created by parsing the XML file.
 *
 * 2) Construction by VisibleObject(const XMLDocument *aDocument).
 * This constructor explictly requests construction based on an
 * XML document.  In this way the proper connection between an object's node
 * and the corresponding node within the XML document is established.
 * This constructor is a copy constructor of sorts because all essential
 * VisibleObject member variables should be held within the XML document.
 * The advantage of this style of construction is that nodes
 * within the XML document, such as comments that may not have any
 * associated VisibleObject member variable, are preserved.
 *
 * 3) A call to generateXMLDocument().
 * This method generates an XML document for the VisibleObject from scratch.
 * Only the essential document nodes are created (that is, nodes that
 * correspond directly to member variables.).
 *
 * @param aObject Object to be copied.
 * @see VisibleObject(const XMLDocument *aDocument)
 * @see VisibleObject(const char *aFileName)
 * @see generateXMLDocument()
 */
VisibleObject::VisibleObject(const VisibleObject &aObject):
Object(aObject),
_propGeometrySet(PropertyObj("", GeometrySet())),
_geometrySet((GeometrySet&)_propGeometrySet.getValueObj()),
_scaleFactors(_propScaleFactors.getValueDblVec()),
_transformProp(PropertyTransform("transform", SimTK::Transform())),
_transform(_transformProp.getValueTransform()),
_showAxes(_propShowAxes.getValueBool()),
_displayPreference((DisplayGeometry::DisplayPreference&)_propDisplayPreference.getValueInt()),
_allGeometry(0),
_dependents(0)
{
	// NULL MEMBER VARIABLES
	setNull();

	// COPY TYPE AND NAME
	*this = aObject;
}


//=============================================================================
// CONSTRUCTION METHODS
//=============================================================================
//_____________________________________________________________________________
/**
 * Set all member variables to their null or default values.
 */
void VisibleObject::setNull()
{
	setupProperties();

	_scaleFactors = 1.0;
	_transform = SimTK::Transform();
	_owner = 0;
	_dependents.setMemoryOwner(false);
	_showAxes=false;
	_displayPreference=DisplayGeometry::GouraudShaded;


}

//_____________________________________________________________________________
/**
 * Connect properties to local pointers.
 */
void VisibleObject::setupProperties()
{

	_propGeometrySet.setName("GeometrySet");
	_propGeometrySet.setComment("Set of geometry files and associated attributes, allow .vtp, .stl, .obj");

	_propertySet.append(&_propGeometrySet);

	_propScaleFactors.setName("scale_factors");
	_propScaleFactors.setComment("Three scale factors for display purposes: scaleX scaleY scaleZ");
	_propertySet.append(&_propScaleFactors);

	_transformProp.setName("transform");
	_transformProp.setComment("transform relative to owner specified as 3 rotations (rad) followed by 3 translations rX rY rZ tx ty tz");
	_propertySet.append(&_transformProp);

	_propShowAxes.setName("show_axes");
	_propShowAxes.setComment("Whether to show a coordinate frame");
	_propertySet.append(&_propShowAxes);

	_propDisplayPreference.setName("display_preference");
	_propDisplayPreference.setComment("Display Pref. 0:Hide 1:Wire 3:Flat 4:Shaded Can be overriden for individual geometries");
	_propertySet.append(&_propDisplayPreference);

}

//=============================================================================
// OPERATORS
//=============================================================================
//-----------------------------------------------------------------------------
// ASSIGNMENT
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Assign this object to the values of another.
 *
 * @return Reference to this object.
 */
VisibleObject& VisibleObject::operator=(const VisibleObject &aObject)
{
	// BASE CLASS
	Object::operator=(aObject);

	_geometrySet = aObject._geometrySet;
	_scaleFactors = aObject._scaleFactors;
	_transform = aObject._transform;
	_showAxes = aObject._showAxes;
	_displayPreference = aObject._displayPreference;
	return(*this);
}

//-----------------------------------------------------------------------------
// EQUALITY
//-----------------------------------------------------------------------------
//_____________________________________________________________________________
/**
 * Determine if two objects are equal.
 *
 * @return True if the two objects are equal, false otherwise.
 */
bool VisibleObject::operator==(const VisibleObject &aObject)
{
	return(Object::operator==(aObject));
}


//=============================================================================
// GET AND SET
//=============================================================================
//_____________________________________________________________________________
/**
 * Set Scale factors for geometry.
 *
 */
void VisibleObject::setScaleFactors(const SimTK::Vec3& aScaleFactors)
{
	_propScaleFactors.setUseDefault(false);
	_scaleFactors=aScaleFactors;
}
//_____________________________________________________________________________
/**
 * Get Scale factors for geometry.
 *
 */
void VisibleObject::getScaleFactors(SimTK::Vec3& aScaleFactors) const
{
	aScaleFactors = _scaleFactors;
}

void VisibleObject::getRotationsAndTranslationsAsArray6(double aArray[]) const
{
	_transformProp.getRotationsAndTranslationsAsArray6(aArray);
}


void VisibleObject::setGeometryFileName(int i, const std::string &aGeometryFileName)
{
	_geometrySet.append(new DisplayGeometry(aGeometryFileName));
}

const int VisibleObject::getNumGeometryFiles() const
{
	return _geometrySet.getSize();
}
void VisibleObject::setNumGeometryFiles(int n)
{
	_geometrySet.setSize(n);
}
const std::string& VisibleObject::getGeometryFileName(int idx) const 
{
	if (idx > _geometrySet.getSize()-1)
		throw ( Exception("getGeometryFileName: no geometry corresponding to index") );
	return _geometrySet[idx].getGeometryFile();
}

// DisplayPreference
DisplayGeometry::DisplayPreference VisibleObject::getDisplayPreference() const
{
	return _displayPreference;
}
void VisibleObject::setDisplayPreference(const DisplayGeometry::DisplayPreference& aPreference)
{
	_displayPreference = aPreference;
	// Push preference down to pieces
	for(int i=0; i<_geometrySet.getSize(); i++)
		_geometrySet[i].setDisplayPreference(aPreference);
}
// Handle conversion from older format
void VisibleObject::updateFromXMLNode(SimTK::Xml::Element& aNode, int versionNumber)
{ 
	if ( versionNumber < XMLDocument::getLatestVersion()){
		if (versionNumber<20101){
			SimTK::Xml::element_iterator visPropIter = aNode.element_begin("VisibleProperties");
			// Get geometry files and Preferences if any and set them into 
			if (visPropIter!=aNode.element_end()){
				// Move display_prference, and show_axes nodes up to VisibleObject
				SimTK::Xml::element_iterator  prefIter = visPropIter->element_begin("display_preference");
				if (prefIter!= visPropIter->element_end()){
					SimTK::Xml::Node moveNode = visPropIter->removeNode(prefIter);
					aNode.insertNodeAfter(aNode.element_end(), moveNode);
				}
				SimTK::Xml::element_iterator  showAxesIter = visPropIter->element_begin("show_axes");
				if (showAxesIter!=aNode.element_end()){
					SimTK::Xml::Node moveNode = visPropIter->removeNode(showAxesIter);
					aNode.insertNodeAfter(aNode.element_end(), moveNode);
				}
			}
			SimTK::Xml::element_iterator geometryIter = aNode.element_begin("geometry_files");
			string propValue="";
			bool hasPieces=false;
			if (geometryIter!= aNode.element_end()){
				SimTK::Array_<SimTK::String> value;
				geometryIter->getValueAs(value);
				for(unsigned i=0;i< value.size(); i++) {
					setGeometryFileName(0, value[i]);	// This actually appends
							hasPieces=true;
						}
					}
				}
			}
	Object::updateFromXMLNode(aNode, versionNumber);
}
