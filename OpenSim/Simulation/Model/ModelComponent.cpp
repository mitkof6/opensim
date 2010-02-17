// ModelComponent.cpp
// Authors: Peter Eastman
/*
 * Copyright (c) 2009, Stanford University. All rights reserved. 
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

// INCLUDES
#include "OpenSim/Simulation/Model/ModelComponent.h"

namespace OpenSim {

ModelComponent::ModelComponent() : _model(NULL)
{
}

ModelComponent::ModelComponent(const std::string& aFileName, bool aUpdateFromXMLNode) : Object(aFileName, aUpdateFromXMLNode), _model(NULL)
{
}

ModelComponent::ModelComponent(const XMLDocument* aDocument): Object(aDocument), _model(NULL)
{
}

ModelComponent::ModelComponent(DOMElement* aNode) : Object(aNode), _model(NULL)
{
}

ModelComponent::ModelComponent(const ModelComponent& copy) : Object(copy), _model(copy._model)
{
}
ModelComponent::~ModelComponent()
{
}

const Model& ModelComponent::getModel() const
{
    return *_model;
}

Model& ModelComponent::updModel()
{
    return *_model;
}

void ModelComponent::setModel(Model& model)
{
    _model = &model;
}

void ModelComponent::setupFromXML()
{
}

void ModelComponent::createSystem(SimTK::MultibodySystem& system) const
{
}

void ModelComponent::initState(SimTK::State& state) const
{
}

void ModelComponent::setDefaultsFromState(const SimTK::State& state)
{
}

} // end of namespace OpenSim
