/**
 * 
 */
package graphics.canvas.providers.canvasJMenus.JMenuCanvas;



import graphics.AquaWorld;
import graphics.canvas.WorkareaCanvas;

import java.awt.Point;

import javax.swing.JPopupMenu;

import org.netbeans.api.visual.action.PopupMenuProvider;
import org.netbeans.api.visual.widget.Widget;


/**
 * This class provides a JPopupMenu by implementing the PopupMenuProvider.
 * 
 * @author Bahram Malaekeh
 */
public class JMenuWorkareaCanvas implements PopupMenuProvider
{
	/**
	 * The canvas that the menu will be shown on.
	 */
	private WorkareaCanvas canvas;


	/**
	 * A constructor for this class.
	 * 
	 * @param canvas
	 *            The {@link WorkareaCanvas} this PopupMenuProvider belongs to.
	 */
	public JMenuWorkareaCanvas(WorkareaCanvas canvas)
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
		AquaWorld.currentCanvas.setCurrentWidgetObject(null);

		JPopupCanvasMenu provider = new JPopupCanvasMenu(canvas);


		return provider.createPopupMenu(localLocation);
	}

}
