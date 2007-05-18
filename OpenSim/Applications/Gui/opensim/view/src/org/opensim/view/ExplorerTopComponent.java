package org.opensim.view;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ActionMap;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import org.openide.ErrorManager;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Mutex;
import org.openide.util.MutexException;
import org.opensim.modeling.Model;
import org.opensim.modeling.OpenSimObject;
import org.opensim.view.nodes.ConcreteModelNode;
import org.opensim.view.nodes.OpenSimNode;
import org.opensim.view.nodes.OpenSimObjectNode;
import org.opensim.view.pub.OpenSimDB;

/**
 * Top component which displays something.
 */
final public class ExplorerTopComponent extends TopComponent
        implements Observer, ExplorerManager.Provider, LookupListener, Lookup.Provider{
   
   private static final long serialVersionUID = 1L;
   
   private static ExplorerTopComponent instance;
   /** path to the icon used by the component and its open action */
   //    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
   
   private static final String PREFERRED_ID = "ExplorerTopComponent";
   
   private final ExplorerManager manager = new ExplorerManager();
   private final BeanTreeView modelTree = new BeanTreeView();
   private static HashMap<Model, ConcreteModelNode> mapModels2Nodes = new HashMap<Model, ConcreteModelNode>(4);
   
   private Lookup.Result result = null;
   private UndoRedo.Manager undoRedoManager = new UndoRedoManager();

   private ExplorerTopComponent() {
      initComponents();
      setName(NbBundle.getMessage(ExplorerTopComponent.class, "CTL_ExplorerTopComponent"));
      setToolTipText(NbBundle.getMessage(ExplorerTopComponent.class, "HINT_ExplorerTopComponent"));
      // Add explorer as observer of the database
      OpenSimDB.getInstance().addObserver(this);
      //        setIcon(Utilities.loadImage(ICON_PATH, true));
      setLayout(new BorderLayout());
      add(modelTree, BorderLayout.CENTER);
      modelTree.setRootVisible(false);
      OpenSimNode root = new OpenSimNode.RootNode();
      manager.setRootContext(root);
      
      // The following code activates/makes available Copy/Paste/Delete
      ActionMap map = this.getActionMap();
      map.put(DefaultEditorKit.copyAction, ExplorerUtils.actionCopy(manager));
      map.put(DefaultEditorKit.cutAction, ExplorerUtils.actionCut(manager));
      map.put(DefaultEditorKit.pasteAction, ExplorerUtils.actionPaste(manager));
      map.put("delete", ExplorerUtils.actionDelete(manager, true)); // or false
      map.put("paste", ExplorerUtils.actionPaste(manager)); // or false
      
      // following line tells the top component which lookup should be associated with it
      associateLookup(ExplorerUtils.createLookup(getExplorerManager(), map));
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
	private void initComponents() 
	{

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
           Lookup.Template tpl = new Lookup.Template(ModelWindowVTKTopComponent.class);
           result = Utilities.actionsGlobalContext().lookup(tpl);
           result.addLookupListener(this);
           redisplay();
        }
        
        public void componentClosed() {
           result.removeLookupListener(this);
           result = null;
        }
        
        public void resultChanged(LookupEvent lookupEvent) {
           Lookup.Result r = (Lookup.Result) lookupEvent.getSource();
           Collection c = r.allInstances();
                /*
                 if (!c.isEmpty()) {
                 ModelWindowVTKTopComponent o = (ModelWindowVTKTopComponent) c.iterator().next();
                 Model m = o.getModel();
                 Node modelNode = mapModels2Nodes.get(m);
                 if (modelNode==null)
                 return;
                 Node[] selectedNodes = new Node[1];
                 selectedNodes[0] = modelNode;
                 manager.setExploredContext(modelNode);
                 setActivatedNodes(selectedNodes);
                 }
                 **/
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
           if (arg instanceof ModelEvent) {
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
                          ConcreteModelNode newModelNode = new ConcreteModelNode(newModel);
                          rootNode.getChildren().add(new Node[] { newModelNode});
                          mapModels2Nodes.put(newModel, newModelNode);
                          updateCurrentModelNode(newModel);
                          break;
                       }
                       case Close:
                       {
                          Model closingModel = evnt.getModel();
                          ConcreteModelNode modelNode = mapModels2Nodes.get(closingModel);
                          try {
                             modelNode.destroy();
                             mapModels2Nodes.remove(closingModel);
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
           } else if (arg instanceof NameChangedEvent) {
              final NameChangedEvent ev = (NameChangedEvent)arg;
              OpenSimObject obj = ev.getObject();
              ExplorerTopComponent tree = ExplorerTopComponent.findInstance();
              Node rootNode = tree.getExplorerManager().getRootContext();
              Node[] nodes = rootNode.getChildren().getNodes();
              for (int i=0; i<nodes.length; i++) {
                 if (nodes[i] instanceof OpenSimNode) {
                    OpenSimObjectNode match = ((OpenSimNode)nodes[i]).findChild(obj);
                    if (match != null) {
                       //match.setName(ev.getName());
                       match.setDisplayName(ev.getName());
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
           return mapModels2Nodes.get(abstractModel);
        }
        
        /**
         * Disallow closing the explorer view as we depend on it everywhere
         */
        public boolean canClose() {
           return false;
        }
        
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
}
