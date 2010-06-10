package graphics.canvas.providers.canvasJMenus.JMenuWidget;



import graphics.AquaWorld;
import graphics.canvas.WorkareaCanvas;

import java.awt.Point;

import javax.swing.JPopupMenu;

import org.netbeans.api.visual.action.PopupMenuProvider;
import org.netbeans.api.visual.widget.Widget;

import widgets.WidgetTransferable;


/**
 * Javadoc-TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class JMenuWidget implements PopupMenuProvider
{

	/**
	 * 
	 */
	private WorkareaCanvas canvas;


	/**
	 * Javadoc-TODO - Description NEEDED!
	 * 
	 * @param canvas
	 */
	public JMenuWidget(WorkareaCanvas canvas)
	{
		this.canvas = canvas;
	}


	/*
	 * (non-Javadoc)
	 * @see
	 * org.netbeans.api.visual.action.PopupMenuProvider#getPopupMenu(org.netbeans
	 * .api.visual.widget.Widget, java.awt.Point)
	 */
	@Override
	public JPopupMenu getPopupMenu(Widget widget, Point localLocation)
	{
		// Sets the current WidgetObject for the systems current canvas
		AquaWorld.currentCanvas
				.setCurrentWidgetObject((WidgetTransferable) widget);

		JPopupWidgetMenu provider = new JPopupWidgetMenu(canvas, widget);

		return provider.createPopupMenu(widget);
	}
}
