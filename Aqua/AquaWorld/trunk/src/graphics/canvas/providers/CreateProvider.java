package graphics.canvas.providers;


import graphics.AquaWorld;

import java.awt.Point;

import org.netbeans.api.visual.action.SelectProvider;
import org.netbeans.api.visual.widget.Widget;

import widgets.WidgetTransferable;


/**
 * Javadoc-TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class CreateProvider implements SelectProvider
{
	/*
	 * (non-Javadoc)
	 * @see
	 * org.netbeans.api.visual.action.SelectProvider#isAimingAllowed(org.netbeans
	 * .api.visual.widget.Widget, java.awt.Point, boolean)
	 */
	public boolean isAimingAllowed(Widget arg0, Point arg1, boolean arg2)
	{
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.netbeans.api.visual.action.SelectProvider#isSelectionAllowed(org.
	 * netbeans.api.visual.widget.Widget, java.awt.Point, boolean)
	 */
	public boolean isSelectionAllowed(Widget arg0, Point arg1, boolean arg2)
	{
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.netbeans.api.visual.action.SelectProvider#select(org.netbeans.api
	 * .visual.widget.Widget, java.awt.Point, boolean)
	 */
	public void select(Widget relatedWidget, Point localLocation,
			boolean invertSelection)
	{
		if ( relatedWidget instanceof WidgetTransferable )
		{
			relatedWidget.bringToFront();

			WidgetTransferable widgetobj = (WidgetTransferable) relatedWidget;

			// Sets the current WidgetObject for the systems current canvas
			AquaWorld.currentCanvas.setCurrentWidgetObject(widgetobj);

			// Updates the information panel with information from the selected
			// object.
			// PrimeMain1.updatePropertiesObjectArea(widgetobj.getObject(),
			// false);
		}
	}
}
