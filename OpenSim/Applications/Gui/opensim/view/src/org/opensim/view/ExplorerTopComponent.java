/*
 * Copyright (c)  2005-2008, Stanford University
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
package org.opensim.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import org.openide.ErrorManager;
import org.openide.awt.UndoRedo;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Mutex;
import org.openide.util.MutexException;
import org.opensim.modeling.Marker;
import org.opensim.modeling.Model;
import org.opensim.view.experimentaldata.ModelForExperimentalData;
import org.opensim.modeling.OpenSimObject;
import org.opensim.view.markerEditor.MarkerEditorTopComponent;
import org.opensim.view.nodes.ConcreteModelNode;
import org.opensim.view.experimentaldata.ExperimentalDataTopNode;
import org.opensim.view.nodes.MarkersNode;
import org.opensim.view.nodes.OneMarkerNode;
import org.opensim.view.nodes.OpenSimNode;
import org.opensim.view.nodes.OpenSimObjectNode;
import org.opensim.view.pub.OpenSimDB;

/**
 * Top component which displays something.
 */
final public class ExplorerTopComponent extends TopComponent
        implements Observer, ExplorerManager.Provider {
   
   private static final long serialVersionUID = 1L;
   
   private static ExplorerTopComponent instance;
   /** path to the icon used by the component and its open action */
   //    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
   
   private static final String PREFERRED_ID = "ExplorerTopComponent";

   private final ExplorerManager manager = new ExplorerManager();
   private final BeanTreeView modelTree = new BeanTreeView();
   
   private UndoRedo.Manager undoRedoManager = new UndoRedoManager();

   private ExplorerTopComponent() {
      initComponents();
      SwingUtilities.invokeLater(new Runnable(){

            public void run() {
                setName(NbBundle.getMessage(ExplorerTopComponent.class, "CTL_ExplorerTopComponent"));
            }
        });
      //setToolTipText(NbBundle.getMessage(ExplorerTopComponent.class, "HINT_ExplorerTopComponent"));
      // Add explorer as observer of the database
      OpenSimDB.getInstance().addObserver(this);
      //        setIcon(Utilities.loadImage(ICON_PATH, true));
      setLayout(new BorderLayout());
      add(modelTree, BorderLayout.CENTER);
      modelTree.setRootVisible(false);
      OpenSimNode root = new OpenSimNode.RootNode();
      manager.setRootContext(root);
      getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "handleDelete");
      getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "handleDelete");
      getActionMap().put("handleDelete", new handleDelete());
      associateLookup(ExplorerUtils.createLookup(manager, getActionMap()));
      /*
      this.addComponentListener(new ComponentAdapter(){
          public void componentResized(ComponentEvent e) {
              WindowManager.getDefault().getMainWindow().validate();
          }
      });*/
   }

   final class handleDelete extends AbstractAction {
       public void actionPerformed(ActionEvent e) {
          Node[] selectedNodes = manager.getSelectedNodes();
          ArrayList<Marker> markers = new ArrayList<Marker>(0);
          for (int i=0; i<selectedNodes.length; i++) {
             if (selectedNodes[i] instanceof OneMarkerNode) {
                OpenSimObjectNode node = (OpenSimObjectNode)selectedNodes[i];
                markers.add((Marker)node.getOpenSimObject());
             }
          }
          if (markers.size() > 0) {
             MarkerEditorTopComponent win = MarkerEditorTopComponent.findInstance();
             win.deleteMarkers(markers, true);
          }
       }           
   }

   BeanTreeView getTree() {
      return modelTree;
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(0, 400, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(0, 300, Short.MAX_VALUE)
      );
   }// </editor-fold>//GEN-END:initComponents
        
        
   // Variables declaration - do not modify//GEN-BEGIN:variables
   // End of variables declaration//GEN-END:variables
        
        /**
         * Gets default instance. Do not use directly: reserved for *.settings files only,
         * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
         * To obtain the singleton instance, use {@link findInstance}.
         */
        public static synchronized ExplorerTopComponent getDefault() {
           if (instance == null) {
              instance = new ExplorerTopComponent();
           }
           return instance;
        }
        
        /**
         * Obtain the ExplorerTopComponent instance. Never call {@link #getDefault} directly!
         */
        public static synchronized ExplorerTopComponent findInstance() {
           TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
           if (win == null) {
              ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find Explorer component. It will not be located properly in the window system.");
              return getDefault();
           }
           if (win instanceof ExplorerTopComponent) {
              return (ExplorerTopComponent)win;
           }
           ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
           return getDefault();
        }
        
        public int getPersistenceType() {
           return TopComponent.PERSISTENCE_ALWAYS;
        }
        // It is good idea to switch all listeners on and off when the
        // component is shown or hidden. In the case of TopComponent use:
        protected void componentActivated() {
           ExplorerUtils.activateActions(getExplorerManager(), true);
        }
        protected void componentDeactivated() {
           ExplorerUtils.activateActions(getExplorerManager(), false);
        }
        
        public void componentOpened() {
           redisplay();
        }
        
        public void componentClosed() {
        }
                
        /** replaces this in object stream */
        public Object writeReplace() {
           return new ResolvableHelper();
        }
        
        protected String preferredID() {
           return PREFERRED_ID;
        }
        
        public void update(Observable o, Object arg) {
           // Observable is OpenSimDB
           if (arg instanceof ObjectsAddedEvent) {
              final ObjectsAddedEvent evnt = (ObjectsAddedEvent)arg;
              final Vector<OpenSimObject> objs = evnt.getObjects();
              for (int i=0; i<objs.size(); i++) {
                 if (objs.get(i) instanceof Model) {
                    final int index = i;
                    // Add the model to the Tree window.
                    SwingUtilities.invokeLater(new Runnable() {
                       public void run() {
                          ExplorerTopComponent tree = ExplorerTopComponent.findInstance();
                          Node rootNode = tree.getExplorerManager().getRootContext();
                          Model newModel = (Model)objs.get(index);
                          ConcreteModelNode newModelNode = new ConcreteModelNode(newModel);
                          rootNode.getChildren().add(new Node[] { newModelNode});
                          updateCurrentModelNode(newModel);
                       }
                    }
                    );
                 } else if (objs.get(i) instanceof Marker) {
                    Marker marker = (Marker)objs.get(i);
                    Model model = evnt.getModel();
                    ConcreteModelNode modelNode = getModelNode(model);
                    Children children = modelNode.getChildren();
                    Node[] nodes = children.getNodes();
                    String markersNodeName = NbBundle.getMessage(MarkersNode.class, "CTL_Markers");
                    for (int j=0; j < nodes.length; j++) {
                       if (nodes[j].getDisplayName().equals(markersNodeName)) {
                          OneMarkerNode newMarkerNode = new OneMarkerNode(marker);
                          nodes[j].getChildren().add(new Node[] {newMarkerNode});
                          break;
                       }
                    }
                 }
              }
           } else if (arg instanceof ObjectsDeletedEvent) {
              final ObjectsDeletedEvent evnt = (ObjectsDeletedEvent)arg;
              final Vector<OpenSimObject> objs = evnt.getObjects();
              for (int i=0; i<objs.size(); i++) {
                 if (objs.get(i) instanceof Marker) {
                    Marker marker = (Marker)objs.get(i);
                    Model model = evnt.getModel();
                    ConcreteModelNode modelNode = getModelNode(model);
                    Children children = modelNode.getChildren();
                    Node[] nodes = children.getNodes();
                    String markersNodeName = NbBundle.getMessage(MarkersNode.class, "CTL_Markers");
                    for (int j=0; j < nodes.length; j++) {
                       if (nodes[j].getDisplayName().equals(markersNodeName)) {
                          children = nodes[j].getChildren();
                          nodes = children.getNodes();
                          for (int k=0; k<nodes.length; k++) {
                             if (nodes[k] instanceof OneMarkerNode) {
                                OneMarkerNode omn = (OneMarkerNode)nodes[k];
                                if (Marker.getCPtr(omn.getOpenSimObject()) == Marker.getCPtr(marker)) {
                                   try {
                                      children.remove(new Node[] {nodes[k]});
                                      if (nodes[k] != null)
                                         nodes[k].destroy();
                                   } catch (IOException ex) {
                                      ex.printStackTrace();
                                   }
                                }
                             }
                          }
                          break;
                       }
                    }
                 }
              }
           } else if (arg instanceof ObjectSetCurrentEvent) {
              ObjectSetCurrentEvent evnt = (ObjectSetCurrentEvent)arg;
              Vector<OpenSimObject> objs = evnt.getObjects();
              for (int i=0; i<objs.size(); i++) {
                 if (objs.get(i) instanceof Model) {
                    final Model currentModel = (Model)objs.get(i);
                    SwingUtilities.invokeLater(new Runnable() {
                       public void run() {
                          updateCurrentModelNode(currentModel);
                       }
                    }
                    );
                    break;
                 }
              }
           } else if (arg instanceof ModelEvent) {
              final ModelEvent evnt = (ModelEvent)arg;
              // Add the model to the Tree window.
              SwingUtilities.invokeLater(new Runnable() {
                 public void run() {
                    ExplorerTopComponent tree = ExplorerTopComponent.findInstance();
                    
                    Node rootNode = tree.getExplorerManager().getRootContext();
                    switch(evnt.getOperation()) {
                       case Open :
                       {
                          Model newModel = evnt.getModel();
                          ConcreteModelNode newModelNode;
                          if (newModel instanceof ModelForExperimentalData)
                              newModelNode = new ExperimentalDataTopNode(newModel);
                          else
                            newModelNode = new ConcreteModelNode(newModel);
                          rootNode.getChildren().add(new Node[] { newModelNode});
                          updateCurrentModelNode(newModel);
                          break;
                       }
                       case Close:
                       {
                          Model closingModel = evnt.getModel();
                          ConcreteModelNode modelNode = getModelNode(closingModel);
                          try {
                             rootNode.getChildren().remove(new Node[] {modelNode});
                             if(modelNode != null) modelNode.destroy();
                             updateCurrentModelNode(null);
                          } catch (IOException ex) {
                             ex.printStackTrace();
                          }
                          break;
                       }
                       case SetCurrent :
                       {
                          updateCurrentModelNode(evnt.getModel());
                          break;
                       }
                    }
                 }
              }
              );
           } else if (arg instanceof ObjectsRenamedEvent) {
              final ObjectsRenamedEvent ev = (ObjectsRenamedEvent)arg;
              Vector<OpenSimObject> objs = ev.getObjects();
              for (int i=0; i<objs.size(); i++) {
                 ExplorerTopComponent tree = ExplorerTopComponent.findInstance();
                 Node rootNode = tree.getExplorerManager().getRootContext();
                 Node[] nodes = rootNode.getChildren().getNodes();
                 for (int j=0; j<nodes.length; j++) {
                    if (nodes[j] instanceof OpenSimNode) {
                       ((OpenSimNode)nodes[j]).renameObjectNode(objs.get(i), objs.get(i).getName());
                    }
                 }
              }
           }
        }
        
        public ExplorerManager getExplorerManager() {
           return manager;
        }
        
        final static class ResolvableHelper implements Serializable {
           private static final long serialVersionUID = 1L;
           public Object readResolve() {
              return ExplorerTopComponent.getDefault();
           }
        }
        
        public void redisplay() {
           // Sync. up the tree with the OpenSimDB
           OpenSimDB db = OpenSimDB.getInstance();
           
           
           Node rootNode = getExplorerManager().getRootContext();
           
           Object[] models = db.getAllModels();
           rootNode.getChildren().remove(rootNode.getChildren().getNodes());
           for(int i=0; i < models.length; i++)
              rootNode.getChildren().add(new Node[] { new ConcreteModelNode((Model)models[i]) });
           
        }
        /**
         * Update marker of current model in navigator view
         *
         * @param new currentModel, null if not explicitly specified
         */
        public void updateCurrentModelNode(Model currentModel) {
           Object[] models = OpenSimDB.getInstance().getAllModels();
           Children children = getExplorerManager().getRootContext().getChildren();
           Node[] nodes = children.getNodes();
           for(int i=0; i < nodes.length; i++) {
              if (nodes[i] instanceof ConcreteModelNode) {
                 ConcreteModelNode node = ((ConcreteModelNode)(nodes[i]));
                 node.setName(node.getModel().getName());
              }
           }
           
           
        }
        /**
         * Get a reference to the navigator/explorer node represtning the passed in model
         */
        public ConcreteModelNode getModelNode(final Model abstractModel) {
           Node rootNode = getExplorerManager().getRootContext();
           for(Node child : rootNode.getChildren().getNodes())
              if((child instanceof ConcreteModelNode) && ((ConcreteModelNode)child).getModel()==abstractModel)
                 return (ConcreteModelNode)child;
           return null;
        }

        /**
         * Disallow closing the explorer view as we depend on it everywhere
         *
        public boolean canClose() {
           return false;
        }*/
        
        // Undo Support
        public UndoRedo getUndoRedo(){
            return getUndoRedoManager();
}
        public UndoRedo.Manager getUndoRedoManager() {
            if (undoRedoManager == null) {
                undoRedoManager = new UndoRedoManager();
                undoRedoManager.setLimit(50);
            }
            return undoRedoManager;
        }
        // [Undo manager performing undo/redo in AWT event thread 
        static class UndoRedoManager extends UndoRedo.Manager {
            private Mutex.ExceptionAction runUndo = new Mutex.ExceptionAction() {
                public Object run() throws Exception {
                    superUndo();
                    return null;
                }
            };
            private Mutex.ExceptionAction runRedo = new Mutex.ExceptionAction() {
                public Object run() throws Exception {
                    superRedo();
                    return null;
                }
            };
            public void superUndo() throws CannotUndoException {
                super.undo();
            }
            public void superRedo() throws CannotRedoException {
                super.redo();
            }
            public void undo() throws CannotUndoException {
                if (java.awt.EventQueue.isDispatchThread()) {
                    superUndo();
                } else {
                    try {
                        Mutex.EVENT.readAccess(runUndo);
                    } catch (MutexException ex) {
                        Exception e = ex.getException();
                        if (e instanceof CannotUndoException)
                            throw (CannotUndoException) e;
                        else // should not happen, ignore
                            e.printStackTrace();
                    }
                }
            }
            public void redo() throws CannotRedoException {
                if (java.awt.EventQueue.isDispatchThread()) {
                    superRedo();
                } else {
                    try {
                        Mutex.EVENT.readAccess(runRedo);
                    } catch (MutexException ex) {
                        Exception e = ex.getException();
                        if (e instanceof CannotRedoException)
                            throw (CannotRedoException) e;
                        else // should not happen, ignore
                            e.printStackTrace();
                    }
                }
            }
        }
        
        public static void addUndoableEdit(AbstractUndoableEdit aUndoableEdit)
        {
            getDefault().getUndoRedoManager().addEdit(aUndoableEdit);
        }
        public static void addFinalEdit()
        {
            getDefault().getUndoRedoManager().discardAllEdits();
        }
}
