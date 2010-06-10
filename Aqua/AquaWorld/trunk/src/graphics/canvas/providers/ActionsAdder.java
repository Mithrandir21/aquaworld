/**
 * 
 */
package graphics.canvas.providers;


import graphics.canvas.WorkareaCanvas;
import graphics.canvas.WorkareaTargetListener;
import graphics.canvas.providers.canvasJMenus.JMenuCanvas.JMenuWorkareaCanvas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.dnd.DropTarget;

import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.AlignWithMoveDecorator;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.Scene;

import widgets.WidgetTransferable;


/**
 * Javadoc-TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ActionsAdder
{
	/**
	 * Javadoc-TODO - Description
	 * 
	 * @param canvas
	 */
	public static void makeWorkareaCanvasReady(WorkareaCanvas canvas)
	{
		// Adds the drag and drop action to the WorkareaCanvas
		canvas.setDropTarget(new DropTarget(canvas.getMyView(),
				new WorkareaTargetListener(canvas)));

		// Adds the zoom feature to the scene.
		canvas.getScene().getActions().addAction(
				ActionFactory.createZoomAction());
		canvas.getScene().getActions().addAction(
				ActionFactory.createPanAction());
		canvas.getScene().getActions().addAction(
				ActionFactory.createPopupMenuAction(new JMenuWorkareaCanvas(
						canvas)));


		canvas.getScene().getActions().addAction(new WorkareaCanvasListener());


		// canvas.getScene().getActions().addAction(
		// new RectangularAreaSelection(
		// new PrimeRectangularSelectDecorator(canvas), canvas
		// .getInteractionLayer(),
		// new PrimeObjectSceneRectangularSelectProvider(canvas)));
		//
		//
		// canvas.setNetworkInfo(new WorkareaCanvasNetworkInfo(canvas));
	}



	/**
	 * Javadoc-TODO - Description
	 */
	public static void makeWidgetObjectReady(WorkareaCanvas canvas,
			WidgetTransferable newObject)
	{
		// // Here the create a connection between widgets on the scene is created
		// newObject.getActions().addAction(
		// new ExtendedWidgetConnectAction(ActionFactory
		// .createDefaultConnectDecorator(), canvas
		// .getInteractionLayer(), new GUIsceneConnectProvider(
		// canvas)));
		//
		// // Adds the action of a user clicking on the object
		// newObject.getActions().addAction(
		// ActionFactory.createSelectAction(new CreateProvider()));
		//
		//
		// // Creates and add the move with align action
		// newObject.getActions().addAction(
		// ActionFactory.createAlignWithMoveAction(canvas.getMainLayer(),
		// canvas.getInteractionLayer(), null));
		//
		//
		// // Adds the double clicking feature for the WidgetObject
		// newObject.getActions().addAction(new WidgetAdapterExtended());
		//
		//
		// newObject.getActions().addAction(
		// ActionFactory.createPopupMenuAction(new JMenuWidget(canvas)));

		// Cleans up the canvas
		canvas.cleanUp();
	}

	
	private static AlignWithMoveDecorator decorator = new AlignWithMoveDecorator()
	{
		public ConnectionWidget createLineWidget(Scene scene)
		{
			ConnectionWidget widget = new ConnectionWidget(scene);
			BasicStroke STROKE = new BasicStroke(1.0f, BasicStroke.JOIN_BEVEL,
					BasicStroke.CAP_BUTT, 5.0f, new float[] { 6.0f, 3.0f },
					0.0f);
			widget.setStroke(STROKE);
			widget.setForeground(Color.BLUE);
			return widget;
		}
	};
}
