/**
 * 
 */
package graphics.canvas;


import java.awt.Point;
import java.awt.dnd.DropTarget;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.undo.UndoableEdit;

import org.netbeans.api.visual.model.ObjectScene;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

import widgetTank.Tank;
import widgets.WidgetFish;
import widgets.WidgetTransferable;
import actions.CanvasUndoManager;
import coreObjects.Aquarium.Aquarium;




/**
 * A visual canvas that will hold all the object of any given network. The
 * object can be moved around, deleted or connected to other object. The canvas
 * has some special feature like zooming, scrolling and panning. The canvas has
 * D'n'D(Drag and Drop) features. Any Widget can be dragged and dropped onto the
 * the canvas. The widget will then be converted into a {@link WidgetFish
 * WidgetObject} and a standard object will be created. The object class depends
 * on the class of the dragged widget. The object will be created and place
 * within the WidgetObject.
 * 
 * @author Bahram Malaekeh
 * @version 1.0
 */

public class WorkareaCanvas extends JPanel
{
	// The transferHandler that will take care of the drag and drop feature for
	// the canvas
	private TransferHandler TransHandler = new WidgetTransferHandler();

	private DropTarget dt = null;

	// The scene on the canvas which all objects and layers will be placed
	private ObjectScene scene = new ObjectScene();

	private JComponent myView = scene.createView();

	// The main layer of the scene where the WidgetObjects are placed
	private LayerWidget mainLayer = null;

	// The interaction layer where the interaction between the user and the
	// WidgetObjects takes place
	private LayerWidget interactionLayer = null;

	// The current WidgetTransferable in view
	private WidgetTransferable currentWidgetObject = null;


	// FIXME - Create array of amount of different object types on the scene
	private int numberOfWidgetsOnTheScene = 0;

	// A boolean saying if the canvas has been saved
	private boolean saved = false;

	// A boolean saying if the canvas has been changed in any way
	private boolean changed = false;

	// The undo manager for this canvas
	private CanvasUndoManager undoManager;

	/**
	 * The {@link Tank} pointer that contains the {@link Aquarium} object.
	 */
	private Tank tank;



	/**
	 * A constructor for the canvas class. This constructor will set the drop
	 * handling and all the special features the canvas has.
	 * 
	 * @param tank
	 *            The {@link Tank} that will be added to the
	 *            {@link WorkareaCanvas}.
	 */
	public WorkareaCanvas(Tank tank)
	{
		this.tank = tank;
		makeCanvasReady();
	}


	/**
	 * A constructor for the canvas class. This constructor will set the drop
	 * handling and all the special features the canvas has.
	 * 
	 * @param canvasName
	 *            The name of the Canvas.
	 * @param aquarium
	 */
	public WorkareaCanvas(String canvasName, Aquarium aquarium)
	{
		tank = new Tank(canvasName, aquarium);
		makeCanvasReady();
	}




	/**
	 * This constructor will set the drop handling and all the special features
	 * the canvas has.
	 */
	public void makeCanvasReady()
	{
		// Creating the actual view
		myView.setTransferHandler(TransHandler);

		// scene.getActions().addAction(ActionFactory.createSelectAction(new
		// CreateProvider()));
		// this.addMouseListener(new WorkareaCanvasListener(this));


		// This is the main layer of the scene where the WidgetsObjects are
		// placed.
		mainLayer = new LayerWidget(scene);
		scene.addChild(mainLayer);

		// This is the interaction layer
		interactionLayer = new LayerWidget(scene);
		scene.addChild(interactionLayer);


		// Initiates the undomanager for this canvas
		undoManager = new CanvasUndoManager(this);

		saved = false;
		changed = false;
	}



	/**
	 * Returns the name of the {@link Tank} object.
	 */
	public String getTankName()
	{
		return tank.getTankName();
	}



	/**
	 * Javadoc-TODO - Description NEEDED!
	 * 
	 * @return the dt
	 */
	public DropTarget getDropTarget()
	{
		return dt;
	}


	/**
	 * Gets the scene.
	 * 
	 * @see org.netbeans.api.visual.widget.Scene Scene
	 * @return the scene
	 */
	public Scene getScene()
	{
		return scene;
	}


	/**
	 * Gets the scene.
	 * 
	 * @see org.netbeans.api.visual.widget.Scene Scene
	 * @return the scene
	 */
	public ObjectScene getObjectScene()
	{
		return scene;
	}


	/**
	 * Gets the view of the scene. Scene can only be viewed through a view like
	 * this.
	 * 
	 * @see org.netbeans.api.visual.widget.Scene#getView() View
	 * @return the myView
	 */
	public JComponent getMyView()
	{
		return myView;
	}


	/**
	 * Returns the main layer of the scene. This is where the {@link WidgetFish WidgetObjects} are placed.
	 * 
	 * @see org.netbeans.api.visual.widget.LayerWidget LayerWidget
	 * @return the mainLayer
	 */
	public LayerWidget getMainLayer()
	{
		return mainLayer;
	}


	/**
	 * Returns the interaction layer of the scene. This is where the actions a
	 * user sees take place like clicks and menus.
	 * 
	 * @see org.netbeans.api.visual.widget.LayerWidget LayerWidget
	 * @return the interactionLayer
	 */
	public LayerWidget getInteractionLayer()
	{
		return interactionLayer;
	}


	/**
	 * Returns the {@link Tank} object that contains the {@link Aquarium}
	 * object.
	 */
	public Tank getTank()
	{
		return tank;
	}


	/**
	 * Gets the number of objects on the Scene.
	 * 
	 * @return the numberOfWidgetsOnTheScene
	 */
	public int getNumberOfWidgetsOnTheScene()
	{
		return numberOfWidgetsOnTheScene;
	}


	/**
	 * Gets a boolean that tells whether or not this {@link WorkareaCanvas} has
	 * been saved.
	 */
	public boolean isSaved()
	{
		return saved;
	}


	/**
	 * Gets a boolean that tells whether or not this {@link WorkareaCanvas} has
	 * been altered and not saved.
	 */
	public boolean isChanged()
	{
		return changed;
	}


	/**
	 * Gets all the {@link WidgetFish WidgetObjectes} on the scene of this {@link WorkareaCanvas}.
	 * 
	 * @return An {@link WidgetFish} array with all the {@link WidgetFish
	 *         WidgetObjectes} on the scene.
	 */
	public WidgetTransferable[] getWidgetObjectsOnTheScene()
	{
		// Get a list of Widgets in the mainlayer
		List<Widget> l = mainLayer.getChildren();

		// Converts that list to an array of Objects
		java.lang.Object[] childrenTemp = l.toArray();

		// Creates an array with the length of the all the children on the
		// canvas
		WidgetTransferable[] childrenWidgets = new WidgetTransferable[childrenTemp.length];

		// Casts all the objects in the converted list to widgetobjects
		for ( int i = 0; i < childrenWidgets.length; i++ )
		{
			childrenWidgets[i] = (WidgetFish) childrenTemp[i];
		}


		return childrenWidgets;
	}


	//
	// /**
	// * This method gets all the objects on the scene.
	// */
	// public WidgetTransferable[] getObjectsOnTheScene()
	// {
	// // Get a list of Widgets in the mainlayer
	// List<Widget> l = mainLayer.getChildren();
	//
	// // Converts that list to an array of Objects
	// java.lang.Object[] childrenTemp = l.toArray();
	//
	// // Creates an array with the length of the all the children on the
	// // canvas
	// WidgetTransferable[] childrenWidgets = new
	// WidgetTransferable[childrenTemp.length];
	//
	// // Casts all the objects in the converted list to widgetobjects
	// for ( int i = 0; i < childrenWidgets.length; i++ )
	// {
	// childrenWidgets[i] = (WidgetTransferable) childrenTemp[i];
	// }
	//
	// // Creates an array with the length of the all the children on the
	// // canvas
	// WidgetTransferable[] childrenObject = new Object[childrenTemp.length];
	//
	// // Gets and places all the objects from within every widgetobject in an
	// // array
	// for ( int i = 0; i < childrenObject.length; i++ )
	// {
	// childrenObject[i] = childrenWidgets[i].getObject();
	// }
	//
	// // Returns an array with only the scenes objects.
	// return childrenObject;
	// }


	/**
	 * Adds one int to the number of Widgets on the canvas scene.
	 */
	public void addToNumberOfWidgetsOnTheCanvas()
	{
		numberOfWidgetsOnTheScene++;
	}



	/**
	 * Subtracts one int from the the number of Widgets on the canvas scene.
	 */
	public void subtractFromNumberOgWidgetsOnTheCanvas()
	{
		numberOfWidgetsOnTheScene--;
	}


	/**
	 * Gets the currently selected widgetObject.
	 * 
	 * @return Returns the currently selected widgetObject.
	 */
	public WidgetTransferable getCurrentWidgetObject()
	{
		return currentWidgetObject;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the undoManager
	 */
	public CanvasUndoManager getUndoManager()
	{
		return undoManager;
	}




	/**
	 * Sets the name of the {@link Tank} object.
	 */
	public void setTankName(String name)
	{
		tank.setTankName(name);
	}


	/**
	 * Javadoc-TODO - Description NEEDED!
	 */
	public void setDropTarget(DropTarget dt)
	{
		this.dt = dt;
	}


	/**
	 * Sets the WorkareaCanvases scene.
	 */
	public void setScene(ObjectScene scene)
	{
		this.scene = scene;
	}




	/**
	 * Sets the view of the scene. Scene can only be viewed through a view like
	 * this.
	 * 
	 * @see org.netbeans.api.visual.widget.Scene#getView() View
	 */
	public void setMyView(JComponent view)
	{
		myView = view;
	}


	/**
	 * Sets the main layer of the scene. This is where the {@link WidgetFish
	 * WidgetObjects} are placed.
	 * 
	 * @see org.netbeans.api.visual.widget.LayerWidget LayerWidget
	 */
	public void setMainLayer(LayerWidget main)
	{
		mainLayer = main;
	}


	/**
	 * Sets the interaction layer of the scene. This is where the actions a user
	 * sees take place like clicks and menus.
	 * 
	 * @see org.netbeans.api.visual.widget.LayerWidget LayerWidget
	 */
	public void setInteractionLayer(LayerWidget inter)
	{
		interactionLayer = inter;
	}


	/**
	 * Sets the current widgetObject.
	 * 
	 * @param currentWidgetObject
	 */
	public void setCurrentWidgetObject(WidgetTransferable currentWidgetObject)
	{
		// If the given WidgetObject is null
		if ( currentWidgetObject == null )
		{
			// If the current selected widgetObject is not null
			if ( this.currentWidgetObject != null )
			{
				// // Removes the borders around the current selected object
				// this.currentWidgetObject.setBorder(BorderFactory
				// .createEmptyBorder());
				this.currentWidgetObject = null;
			}
		}
		else
		{
			// If the current selected widgetObject is not null
			if ( this.currentWidgetObject != null )
			{
				// // Removes the borders around the current selected object
				// this.currentWidgetObject.setBorder(BorderFactory
				// .createEmptyBorder());
				this.currentWidgetObject = null;
			}

			// The now currently selected widgetObject is given a border
			this.currentWidgetObject = currentWidgetObject;
			// this.currentWidgetObject.setBorder(BorderFactory
			// .createRoundedBorder(7, 7, Color.white, Color.black));
		}
	}



	/**
	 * Sets a boolean on whether or not this {@link WorkareaCanvas} has been
	 * saved.
	 */
	public void setSaved(boolean saved)
	{
		this.saved = saved;
	}


	/**
	 * Sets a boolean on whether or not this {@link WorkareaCanvas} has been
	 * altered and not saved.
	 */
	public void setChanged(boolean changed)
	{
		this.changed = changed;
	}


	/**
	 * Adds the given WidgetObject at the given point on the scene.
	 * 
	 * @param newObject
	 * @param objectPoint
	 */
	public void addWidgetObject(WidgetTransferable newObject,
			Point objectPoint, boolean withCleanUp)
	{
		// Sets the location of the object.
		newObject.setWidgetLocation(objectPoint);
		//
		// WorkareaCanvasActions.addWidgetToCanvas(newObject, objectPoint, this,
		// withCleanUp);
	}


	/**
	 * Adds a undoable action to the canvases undomanager.
	 */
	public void addUndoableAction(UndoableEdit action)
	{
		undoManager.addEdit(action);
	}


	/**
	 * This method cleans up the canvas. The scene and all the views are
	 * repainted and revalidated. The properties panel is also updated.
	 */
	public void cleanUp()
	{
		doRepaint();

		saved = false;
		changed = true;

		scene.revalidate();
		scene.repaint();

		myView.revalidate();
		myView.repaint();

		mainLayer.revalidate();
		mainLayer.repaint();

		interactionLayer.revalidate();
		interactionLayer.repaint();

	}




	/**
	 * This function goes through all the widgetObjects on the scene and sets
	 * the location of the widget on the scene to the location of the object
	 * within the WidgetObject.
	 */
	public void revalidateWidgetLocations()
	{

		// The Widgets on the scene
		WidgetTransferable[] widgets = this.getWidgetObjectsOnTheScene();

		// Iterates through the Object list
		for ( int i = 0; i < widgets.length; i++ )
		{
			// Gets the object from the widget
			WidgetTransferable obj = widgets[i];

			// Sets the object location
			obj.setWidgetLocation(widgets[i].getWidgetLocation());
		}
	}




	/**
	 * This function stops the random NullPointerExceptions. (Combined
	 * org.netbeans.api and Java bug).
	 */
	public void doRepaint()
	{
		// The Nodes API can fire events outside the AWT Thread
		if ( SwingUtilities.isEventDispatchThread() )
		{
			repaint();
			scene.getScene().validate();
			// required or repaint() doesn�t work
		}
		else
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					repaint();
					scene.getScene().validate();
				}
			});
		}
	}
}