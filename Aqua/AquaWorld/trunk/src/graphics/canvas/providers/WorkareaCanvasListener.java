/**
 * 
 */
package graphics.canvas.providers;


import org.netbeans.api.visual.action.WidgetAction.Adapter;
import org.netbeans.api.visual.widget.Widget;


/**
 * Javadoc-TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class WorkareaCanvasListener extends Adapter
{
	/*
	 * (non-Javadoc)
	 * @see
	 * org.netbeans.api.visual.action.WidgetAction$Adapter#mouseClicked(org.
	 * netbeans.api.visual.widget.Widget,
	 * org.netbeans.api.visual.action.WidgetAction.WidgetMouseEvent)
	 */
	@Override
	public State mouseClicked(Widget widget, WidgetMouseEvent event)
	{
		// // Sets the current WidgetObject for the systems current canvas
		// PrimeMain1.currentCanvas.setCurrentWidgetObject(null);
		//
		// // Updates the properties area with the currently showing
		// // workareaCanvas, if it is not showing already
		// PrimeMain1.updatePropertiesCanvasArea(false);

		// Consumes the action so that other listeners do not pick up the action
		return State.CONSUMED;
	}



	/*
	 * (non-Javadoc)
	 * @see
	 * org.netbeans.api.visual.action.WidgetAction.Adapter#mousePressed(org.
	 * netbeans.api.visual.widget.Widget,
	 * org.netbeans.api.visual.action.WidgetAction.WidgetMouseEvent)
	 */
	@Override
	public State mousePressed(Widget widget, WidgetMouseEvent event)
	{
		return State.REJECTED;
	}



	/*
	 * (non-Javadoc)
	 * @see
	 * org.netbeans.api.visual.action.WidgetAction.Adapter#mouseDragged(org.
	 * netbeans.api.visual.widget.Widget,
	 * org.netbeans.api.visual.action.WidgetAction.WidgetMouseEvent)
	 */
	@Override
	public State mouseDragged(Widget widget, WidgetMouseEvent event)
	{
		return State.REJECTED;
	}
}