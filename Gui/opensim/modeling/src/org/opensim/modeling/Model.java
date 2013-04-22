/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Model extends ModelComponent {
  private long swigCPtr;

  public Model(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.Model_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Model obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_Model(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  private String originalModelPath = null;
  // Important that we only refer to originalModelPath if the model's getInputFileName() is not set
  public void setOriginalModelPathFromModel(Model model) {
    originalModelPath = null;
    if(model.getInputFileName()!=null && !model.getInputFileName().equals(""))
      originalModelPath = (new java.io.File(model.getInputFileName())).getParent();
	 else if(model.originalModelPath!=null && !model.originalModelPath.equals(""))
      originalModelPath = model.originalModelPath;
  }
  public String getFilePath() {
    if(getInputFileName()!=null && !getInputFileName().equals("") && (new java.io.File(getInputFileName())).getParent()!=null)
      return (new java.io.File(getInputFileName())).getParent() + java.io.File.separator;
    else if(originalModelPath!=null && !originalModelPath.equals(""))
      return originalModelPath + java.io.File.separator;
    else return "";
  }

  public void addComponent(ModelComponent aComponent) {
	aComponent.markAdopted();
    addComponentImpl(aComponent);
  }

  public void addBody(Body aBody) {
	aBody.markAdopted();
    addBodyImpl(aBody);
  }

  public void addConstraint(Constraint aConstraint) {
	aConstraint.markAdopted();
    addConstraintImpl(aConstraint);
  }

  public void addProbe(Probe aProbe) {
	aProbe.markAdopted();
    addProbeImpl(aProbe);
  }  
  
  public void addContactGeometry(ContactGeometry aContactGeometry) {
	aContactGeometry.markAdopted();
    addContactGeometryImpl(aContactGeometry);
  }

  public void addAnalysis(Analysis aAnalysis) {
	aAnalysis.markAdopted();
	addAnalysisImpl(aAnalysis);
  }

  public void addForce(Force aForce) {
	aForce.markAdopted();
	addForceImpl(aForce);
  }

  public void addController(Controller aController) {
	aController.markAdopted();
	addControllerImpl(aController);
  }

  public static Model safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Model_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Model(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.Model_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.Model_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.Model_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new Model(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.Model_getConcreteClassName(swigCPtr, this);
  }

  public Model() {
    this(opensimModelJNI.new_Model__SWIG_0(), true);
  }

  public Model(String filename) throws java.io.IOException {
    this(opensimModelJNI.new_Model__SWIG_1(filename), true);
  }

  public Model(Model source) {
    this(opensimModelJNI.new_Model__SWIG_2(Model.getCPtr(source), source), true);
  }

  public void setup() throws java.io.IOException {
    opensimModelJNI.Model_setup(swigCPtr, this);
  }

  public void cleanup() {
    opensimModelJNI.Model_cleanup(swigCPtr, this);
  }

  public ModelDisplayHints getDisplayHints() {
    return new ModelDisplayHints(opensimModelJNI.Model_getDisplayHints(swigCPtr, this), false);
  }

  public ModelDisplayHints updDisplayHints() {
    return new ModelDisplayHints(opensimModelJNI.Model_updDisplayHints(swigCPtr, this), false);
  }

  public void setUseVisualizer(boolean visualize) {
    opensimModelJNI.Model_setUseVisualizer(swigCPtr, this, visualize);
  }

  public boolean getUseVisualizer() {
    return opensimModelJNI.Model_getUseVisualizer(swigCPtr, this);
  }

  public boolean hasVisualizer() {
    return opensimModelJNI.Model_hasVisualizer(swigCPtr, this);
  }

  public ModelVisualizer getVisualizer() {
    return new ModelVisualizer(opensimModelJNI.Model_getVisualizer(swigCPtr, this), false);
  }

  public ModelVisualizer updVisualizer() {
    return new ModelVisualizer(opensimModelJNI.Model_updVisualizer(swigCPtr, this), false);
  }

  public void buildSystem() {
    opensimModelJNI.Model_buildSystem(swigCPtr, this);
  }

  public State initializeState() {
    return new State(opensimModelJNI.Model_initializeState(swigCPtr, this), false);
  }

  public State initSystem() throws java.io.IOException {
    return new State(opensimModelJNI.Model_initSystem(swigCPtr, this), false);
  }

  public State getWorkingState() {
    return new State(opensimModelJNI.Model_getWorkingState(swigCPtr, this), false);
  }

  public State updWorkingState() {
    return new State(opensimModelJNI.Model_updWorkingState(swigCPtr, this), false);
  }

  public void copyDefaultStateIntoWorkingState() {
    opensimModelJNI.Model_copyDefaultStateIntoWorkingState(swigCPtr, this);
  }

  public void initStateWithoutRecreatingSystem(State state) {
    opensimModelJNI.Model_initStateWithoutRecreatingSystem(swigCPtr, this, State.getCPtr(state), state);
  }

  public void invalidateSystem() {
    opensimModelJNI.Model_invalidateSystem(swigCPtr, this);
  }

  public boolean isValidSystem() {
    return opensimModelJNI.Model_isValidSystem(swigCPtr, this);
  }

  public void formStateStorage(Storage originalStorage, Storage statesStorage) {
    opensimModelJNI.Model_formStateStorage(swigCPtr, this, Storage.getCPtr(originalStorage), originalStorage, Storage.getCPtr(statesStorage), statesStorage);
  }

  public void formQStorage(Storage originalStorage, Storage qStorage) {
    opensimModelJNI.Model_formQStorage(swigCPtr, this, Storage.getCPtr(originalStorage), originalStorage, Storage.getCPtr(qStorage), qStorage);
  }

  public void updateAssemblyConditions(State s) {
    opensimModelJNI.Model_updateAssemblyConditions(swigCPtr, this, State.getCPtr(s), s);
  }

  public void assemble(State state, Coordinate coord, double weight) {
    opensimModelJNI.Model_assemble__SWIG_0(swigCPtr, this, State.getCPtr(state), state, Coordinate.getCPtr(coord), coord, weight);
  }

  public void assemble(State state, Coordinate coord) {
    opensimModelJNI.Model_assemble__SWIG_1(swigCPtr, this, State.getCPtr(state), state, Coordinate.getCPtr(coord), coord);
  }

  public void assemble(State state) {
    opensimModelJNI.Model_assemble__SWIG_2(swigCPtr, this, State.getCPtr(state), state);
  }

  public void equilibrateMuscles(State state) {
    opensimModelJNI.Model_equilibrateMuscles(swigCPtr, this, State.getCPtr(state), state);
  }

  public SWIGTYPE_p_SimTK__MultibodySystem getMultibodySystem() {
    return new SWIGTYPE_p_SimTK__MultibodySystem(opensimModelJNI.Model_getMultibodySystem(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__MultibodySystem updMultibodySystem() {
    return new SWIGTYPE_p_SimTK__MultibodySystem(opensimModelJNI.Model_updMultibodySystem(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__DefaultSystemSubsystem getDefaultSubsystem() {
    return new SWIGTYPE_p_SimTK__DefaultSystemSubsystem(opensimModelJNI.Model_getDefaultSubsystem(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__DefaultSystemSubsystem updDefaultSubsystem() {
    return new SWIGTYPE_p_SimTK__DefaultSystemSubsystem(opensimModelJNI.Model_updDefaultSubsystem(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__SimbodyMatterSubsystem getMatterSubsystem() {
    return new SWIGTYPE_p_SimTK__SimbodyMatterSubsystem(opensimModelJNI.Model_getMatterSubsystem(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__SimbodyMatterSubsystem updMatterSubsystem() {
    return new SWIGTYPE_p_SimTK__SimbodyMatterSubsystem(opensimModelJNI.Model_updMatterSubsystem(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__Force__Gravity getGravityForce() {
    return new SWIGTYPE_p_SimTK__Force__Gravity(opensimModelJNI.Model_getGravityForce(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__Force__Gravity updGravityForce() {
    return new SWIGTYPE_p_SimTK__Force__Gravity(opensimModelJNI.Model_updGravityForce(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__GeneralForceSubsystem getForceSubsystem() {
    return new SWIGTYPE_p_SimTK__GeneralForceSubsystem(opensimModelJNI.Model_getForceSubsystem(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__GeneralForceSubsystem updForceSubsystem() {
    return new SWIGTYPE_p_SimTK__GeneralForceSubsystem(opensimModelJNI.Model_updForceSubsystem(swigCPtr, this), false);
  }

  public int getNumStateVariables() {
    return opensimModelJNI.Model_getNumStateVariables(swigCPtr, this);
  }

  public void addComponentImpl(ModelComponent aComponent) {
    opensimModelJNI.Model_addComponentImpl(swigCPtr, this, ModelComponent.getCPtr(aComponent), aComponent);
  }

  public void addBodyImpl(Body aBody) {
    opensimModelJNI.Model_addBodyImpl(swigCPtr, this, Body.getCPtr(aBody), aBody);
  }

  public void addConstraintImpl(Constraint aConstraint) {
    opensimModelJNI.Model_addConstraintImpl(swigCPtr, this, Constraint.getCPtr(aConstraint), aConstraint);
  }

  public void addForceImpl(Force aForce) {
    opensimModelJNI.Model_addForceImpl(swigCPtr, this, Force.getCPtr(aForce), aForce);
  }

  public void addProbeImpl(Probe aProbe) {
    opensimModelJNI.Model_addProbeImpl(swigCPtr, this, Probe.getCPtr(aProbe), aProbe);
  }

  public void addContactGeometryImpl(ContactGeometry aContactGeometry) {
    opensimModelJNI.Model_addContactGeometryImpl(swigCPtr, this, ContactGeometry.getCPtr(aContactGeometry), aContactGeometry);
  }

  public void removeProbe(Probe aProbe) {
    opensimModelJNI.Model_removeProbe(swigCPtr, this, Probe.getCPtr(aProbe), aProbe);
  }

  public String getInputFileName() {
    return opensimModelJNI.Model_getInputFileName(swigCPtr, this);
  }

  public void setInputFileName(String fileName) {
    opensimModelJNI.Model_setInputFileName(swigCPtr, this, fileName);
  }

  public String getCredits() {
    return opensimModelJNI.Model_getCredits(swigCPtr, this);
  }

  public void setAuthors(String aCredits) {
    opensimModelJNI.Model_setAuthors(swigCPtr, this, aCredits);
  }

  public String getPublications() {
    return opensimModelJNI.Model_getPublications(swigCPtr, this);
  }

  public void setPublications(String aPublications) {
    opensimModelJNI.Model_setPublications(swigCPtr, this, aPublications);
  }

  public Units getLengthUnits() {
    return new Units(opensimModelJNI.Model_getLengthUnits(swigCPtr, this), false);
  }

  public Units getForceUnits() {
    return new Units(opensimModelJNI.Model_getForceUnits(swigCPtr, this), false);
  }

  public Vec3 getGravity() {
    return new Vec3(opensimModelJNI.Model_getGravity(swigCPtr, this), true);
  }

  public boolean setGravity(Vec3 aGrav) {
    return opensimModelJNI.Model_setGravity(swigCPtr, this, Vec3.getCPtr(aGrav), aGrav);
  }

  public int getNumMarkers() {
    return opensimModelJNI.Model_getNumMarkers(swigCPtr, this);
  }

  public int getNumContactGeometries() {
    return opensimModelJNI.Model_getNumContactGeometries(swigCPtr, this);
  }

  public int getNumBodies() {
    return opensimModelJNI.Model_getNumBodies(swigCPtr, this);
  }

  public int getNumJoints() {
    return opensimModelJNI.Model_getNumJoints(swigCPtr, this);
  }

  public int getNumCoordinates() {
    return opensimModelJNI.Model_getNumCoordinates(swigCPtr, this);
  }

  public int getNumSpeeds() {
    return opensimModelJNI.Model_getNumSpeeds(swigCPtr, this);
  }

  public int getNumProbes() {
    return opensimModelJNI.Model_getNumProbes(swigCPtr, this);
  }

  public SetActuators getActuators() {
    return new SetActuators(opensimModelJNI.Model_getActuators(swigCPtr, this), false);
  }

  public SetActuators updActuators() {
    return new SetActuators(opensimModelJNI.Model_updActuators(swigCPtr, this), false);
  }

  public SetMuscles getMuscles() {
    return new SetMuscles(opensimModelJNI.Model_getMuscles(swigCPtr, this), false);
  }

  public SetMuscles updMuscles() {
    return new SetMuscles(opensimModelJNI.Model_updMuscles(swigCPtr, this), false);
  }

  public ForceSet getForceSet() {
    return new ForceSet(opensimModelJNI.Model_getForceSet(swigCPtr, this), false);
  }

  public ForceSet updForceSet() {
    return new ForceSet(opensimModelJNI.Model_updForceSet(swigCPtr, this), false);
  }

  public ProbeSet getProbeSet() {
    return new ProbeSet(opensimModelJNI.Model_getProbeSet(swigCPtr, this), false);
  }

  public ProbeSet updProbeSet() {
    return new ProbeSet(opensimModelJNI.Model_updProbeSet(swigCPtr, this), false);
  }

  public ComponentSet getMiscModelComponentSet() {
    return new ComponentSet(opensimModelJNI.Model_getMiscModelComponentSet(swigCPtr, this), false);
  }

  public ComponentSet updMiscModelComponentSet() {
    return new ComponentSet(opensimModelJNI.Model_updMiscModelComponentSet(swigCPtr, this), false);
  }

  public int getNumAnalyses() {
    return opensimModelJNI.Model_getNumAnalyses(swigCPtr, this);
  }

  public int getNumControls() {
    return opensimModelJNI.Model_getNumControls(swigCPtr, this);
  }

  public Vector updDefaultControls() {
    return new Vector(opensimModelJNI.Model_updDefaultControls(swigCPtr, this), false);
  }

  public void setDefaultControls(Vector controls) {
    opensimModelJNI.Model_setDefaultControls__SWIG_0(swigCPtr, this, Vector.getCPtr(controls), controls);
  }

  public Vector getDefaultControls() {
    return new Vector(opensimModelJNI.Model_getDefaultControls(swigCPtr, this), false);
  }

  public Vector updControls(State s) {
    return new Vector(opensimModelJNI.Model_updControls(swigCPtr, this, State.getCPtr(s), s), false);
  }

  public void setControls(State s, Vector controls) {
    opensimModelJNI.Model_setControls(swigCPtr, this, State.getCPtr(s), s, Vector.getCPtr(controls), controls);
  }

  public Vector getControls(State s) {
    return new Vector(opensimModelJNI.Model_getControls(swigCPtr, this, State.getCPtr(s), s), false);
  }

  public void computeControls(State state, Vector controls) {
    opensimModelJNI.Model_computeControls(swigCPtr, this, State.getCPtr(state), state, Vector.getCPtr(controls), controls);
  }

  public boolean isControlled() {
    return opensimModelJNI.Model_isControlled(swigCPtr, this);
  }

  public void storeControls(State s, int step) {
    opensimModelJNI.Model_storeControls(swigCPtr, this, State.getCPtr(s), s, step);
  }

  public void printControlStorage(String fileName) {
    opensimModelJNI.Model_printControlStorage(swigCPtr, this, fileName);
  }

  public ControllerSet getControllerSet() {
    return new ControllerSet(opensimModelJNI.Model_getControllerSet(swigCPtr, this), false);
  }

  public ControllerSet updControllerSet() {
    return new ControllerSet(opensimModelJNI.Model_updControllerSet(swigCPtr, this), false);
  }

  public boolean getAllControllersEnabled() {
    return opensimModelJNI.Model_getAllControllersEnabled(swigCPtr, this);
  }

  public void setAllControllersEnabled(boolean enabled) {
    opensimModelJNI.Model_setAllControllersEnabled(swigCPtr, this, enabled);
  }

  public void applyDefaultConfiguration(State s) {
    opensimModelJNI.Model_applyDefaultConfiguration(swigCPtr, this, State.getCPtr(s), s);
  }

  public SimbodyEngine getSimbodyEngine() {
    return new SimbodyEngine(opensimModelJNI.Model_getSimbodyEngine(swigCPtr, this), false);
  }

  public SimbodyEngine updSimbodyEngine() {
    return new SimbodyEngine(opensimModelJNI.Model_updSimbodyEngine(swigCPtr, this), false);
  }

  public void getStateValues(State state, ArrayDouble stateValues) {
    opensimModelJNI.Model_getStateValues__SWIG_0(swigCPtr, this, State.getCPtr(state), state, ArrayDouble.getCPtr(stateValues), stateValues);
  }

  public Vector getStateValues(State s) {
    return new Vector(opensimModelJNI.Model_getStateValues__SWIG_1(swigCPtr, this, State.getCPtr(s), s), true);
  }

  public void setStateValues(State state, SWIGTYPE_p_double stateValues) {
    opensimModelJNI.Model_setStateValues(swigCPtr, this, State.getCPtr(state), state, SWIGTYPE_p_double.getCPtr(stateValues));
  }

  public int getNumMuscleStates() {
    return opensimModelJNI.Model_getNumMuscleStates(swigCPtr, this);
  }

  public int getNumProbeStates() {
    return opensimModelJNI.Model_getNumProbeStates(swigCPtr, this);
  }

  public CoordinateSet updCoordinateSet() {
    return new CoordinateSet(opensimModelJNI.Model_updCoordinateSet(swigCPtr, this), false);
  }

  public CoordinateSet getCoordinateSet() {
    return new CoordinateSet(opensimModelJNI.Model_getCoordinateSet(swigCPtr, this), false);
  }

  public BodySet updBodySet() {
    return new BodySet(opensimModelJNI.Model_updBodySet(swigCPtr, this), false);
  }

  public BodySet getBodySet() {
    return new BodySet(opensimModelJNI.Model_getBodySet(swigCPtr, this), false);
  }

  public JointSet updJointSet() {
    return new JointSet(opensimModelJNI.Model_updJointSet(swigCPtr, this), false);
  }

  public JointSet getJointSet() {
    return new JointSet(opensimModelJNI.Model_getJointSet(swigCPtr, this), false);
  }

  public AnalysisSet updAnalysisSet() {
    return new AnalysisSet(opensimModelJNI.Model_updAnalysisSet(swigCPtr, this), false);
  }

  public AnalysisSet getAnalysisSet() {
    return new AnalysisSet(opensimModelJNI.Model_getAnalysisSet(swigCPtr, this), false);
  }

  public ContactGeometrySet updContactGeometrySet() {
    return new ContactGeometrySet(opensimModelJNI.Model_updContactGeometrySet(swigCPtr, this), false);
  }

  public ContactGeometrySet getContactGeometrySet() {
    return new ContactGeometrySet(opensimModelJNI.Model_getContactGeometrySet(swigCPtr, this), false);
  }

  public Body getGroundBody() {
    return new Body(opensimModelJNI.Model_getGroundBody(swigCPtr, this), false);
  }

  public ConstraintSet updConstraintSet() {
    return new ConstraintSet(opensimModelJNI.Model_updConstraintSet(swigCPtr, this), false);
  }

  public ConstraintSet getConstraintSet() {
    return new ConstraintSet(opensimModelJNI.Model_getConstraintSet(swigCPtr, this), false);
  }

  public MarkerSet updMarkerSet() {
    return new MarkerSet(opensimModelJNI.Model_updMarkerSet(swigCPtr, this), false);
  }

  public MarkerSet getMarkerSet() {
    return new MarkerSet(opensimModelJNI.Model_getMarkerSet(swigCPtr, this), false);
  }

  public int replaceMarkerSet(State s, MarkerSet aMarkerSet) {
    return opensimModelJNI.Model_replaceMarkerSet(swigCPtr, this, State.getCPtr(s), s, MarkerSet.getCPtr(aMarkerSet), aMarkerSet);
  }

  public void writeMarkerFile(String aFileName) {
    opensimModelJNI.Model_writeMarkerFile(swigCPtr, this, aFileName);
  }

  public void updateMarkerSet(MarkerSet aMarkerSet) {
    opensimModelJNI.Model_updateMarkerSet(swigCPtr, this, MarkerSet.getCPtr(aMarkerSet), aMarkerSet);
  }

  public int deleteUnusedMarkers(ArrayStr aMarkerNames) {
    return opensimModelJNI.Model_deleteUnusedMarkers(swigCPtr, this, ArrayStr.getCPtr(aMarkerNames), aMarkerNames);
  }

  public void addAnalysisImpl(Analysis analysis) {
    opensimModelJNI.Model_addAnalysisImpl(swigCPtr, this, Analysis.getCPtr(analysis), analysis);
  }

  public void addControllerImpl(Controller aController) {
    opensimModelJNI.Model_addControllerImpl(swigCPtr, this, Controller.getCPtr(aController), aController);
  }

  public void removeAnalysis(Analysis analysis, boolean deleteIt) {
    opensimModelJNI.Model_removeAnalysis__SWIG_0(swigCPtr, this, Analysis.getCPtr(analysis), analysis, deleteIt);
  }

  public void removeAnalysis(Analysis analysis) {
    opensimModelJNI.Model_removeAnalysis__SWIG_1(swigCPtr, this, Analysis.getCPtr(analysis), analysis);
  }

  public void removeController(Controller aController) {
    opensimModelJNI.Model_removeController(swigCPtr, this, Controller.getCPtr(aController), aController);
  }

  public boolean scale(State state, ScaleSet scaleSet, double finalMass, boolean preserveMassDist) {
    return opensimModelJNI.Model_scale__SWIG_0(swigCPtr, this, State.getCPtr(state), state, ScaleSet.getCPtr(scaleSet), scaleSet, finalMass, preserveMassDist);
  }

  public boolean scale(State state, ScaleSet scaleSet, double finalMass) {
    return opensimModelJNI.Model_scale__SWIG_1(swigCPtr, this, State.getCPtr(state), state, ScaleSet.getCPtr(scaleSet), scaleSet, finalMass);
  }

  public boolean scale(State state, ScaleSet scaleSet) {
    return opensimModelJNI.Model_scale__SWIG_2(swigCPtr, this, State.getCPtr(state), state, ScaleSet.getCPtr(scaleSet), scaleSet);
  }

  public void printBasicInfo(SWIGTYPE_p_std__ostream aOStream) {
    opensimModelJNI.Model_printBasicInfo(swigCPtr, this, SWIGTYPE_p_std__ostream.getCPtr(aOStream));
  }

  public void printDetailedInfo(State s, SWIGTYPE_p_std__ostream aOStream) {
    opensimModelJNI.Model_printDetailedInfo(swigCPtr, this, State.getCPtr(s), s, SWIGTYPE_p_std__ostream.getCPtr(aOStream));
  }

  public void disownAllComponents() {
    opensimModelJNI.Model_disownAllComponents(swigCPtr, this);
  }

  public void overrideAllActuators(State s, boolean flag) {
    opensimModelJNI.Model_overrideAllActuators(swigCPtr, this, State.getCPtr(s), s, flag);
  }

  public String getValidationLog() {
    return opensimModelJNI.Model_getValidationLog(swigCPtr, this);
  }

  public void clearValidationLog() {
    opensimModelJNI.Model_clearValidationLog(swigCPtr, this);
  }

  public OpenSimObject getObjectByTypeAndName(String typeString, String nameString) throws java.io.IOException {
    return new OpenSimObject(opensimModelJNI.Model_getObjectByTypeAndName(swigCPtr, this, typeString, nameString), false);
  }

  public void updateFromXMLNode(SWIGTYPE_p_SimTK__Xml__Element aNode, int versionNumber) {
    opensimModelJNI.Model_updateFromXMLNode__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Xml__Element.getCPtr(aNode), versionNumber);
  }

  public void updateFromXMLNode(SWIGTYPE_p_SimTK__Xml__Element aNode) {
    opensimModelJNI.Model_updateFromXMLNode__SWIG_1(swigCPtr, this, SWIGTYPE_p_SimTK__Xml__Element.getCPtr(aNode));
  }

  public void connectToModel(Model model) {
    opensimModelJNI.Model_connectToModel(swigCPtr, this, Model.getCPtr(model), model);
  }

  public void addToSystem(SWIGTYPE_p_SimTK__MultibodySystem system) {
    opensimModelJNI.Model_addToSystem(swigCPtr, this, SWIGTYPE_p_SimTK__MultibodySystem.getCPtr(system));
  }

  public void initStateFromProperties(State state) {
    opensimModelJNI.Model_initStateFromProperties(swigCPtr, this, State.getCPtr(state), state);
  }

  public void setPropertiesFromState(State state) {
    opensimModelJNI.Model_setPropertiesFromState(swigCPtr, this, State.getCPtr(state), state);
  }

  public void generateDecorations(boolean fixed, ModelDisplayHints hints, State state, SWIGTYPE_p_SimTK__Array_T_SimTK__DecorativeGeometry_t appendToThis) {
    opensimModelJNI.Model_generateDecorations(swigCPtr, this, fixed, ModelDisplayHints.getCPtr(hints), hints, State.getCPtr(state), state, SWIGTYPE_p_SimTK__Array_T_SimTK__DecorativeGeometry_t.getCPtr(appendToThis));
  }

  public ArrayStr getStateVariableNames() {
    return new ArrayStr(opensimModelJNI.Model_getStateVariableNames(swigCPtr, this), true);
  }

  public SWIGTYPE_p_OpenSim__ArrayT_SimTK__SystemYIndex_t getStateVariableSystemIndices() {
    return new SWIGTYPE_p_OpenSim__ArrayT_SimTK__SystemYIndex_t(opensimModelJNI.Model_getStateVariableSystemIndices(swigCPtr, this), false);
  }

  public double getStateVariable(State s, String name) {
    return opensimModelJNI.Model_getStateVariable(swigCPtr, this, State.getCPtr(s), s, name);
  }

  public void setStateVariable(State s, String name, double value) {
    opensimModelJNI.Model_setStateVariable(swigCPtr, this, State.getCPtr(s), s, name, value);
  }

  public SWIGTYPE_p_SimTK__SystemYIndex getStateVariableSystemIndex(String stateVariableName) {
    return new SWIGTYPE_p_SimTK__SystemYIndex(opensimModelJNI.Model_getStateVariableSystemIndex(swigCPtr, this, stateVariableName), true);
  }

  public static void LoadOpenSimLibrary(String libraryName) {
    opensimModelJNI.Model_LoadOpenSimLibrary(libraryName);
  }

}
