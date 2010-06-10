/**
 * 
 */
package actions.systemActions;


import graphics.AquaWorld;
import graphics.canvas.WorkareaCanvas;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import widgetTank.Tank;
import actions.AbstractSystemAction;


/**
 * This action is used when the currently open {@link Tank} is to be exported as
 * a file. It will call the exportWorkareaCanvasAsImage function in the
 * {@link DesktopFileManagment} class and given the current
 * {@link WorkareaCanvas} in the {@link PrimeMain1} class as a variable.
 * 
 * @author Bahram Malaekeh
 */
public class ActionExportCanvasAsImage extends AbstractSystemAction
{
	/**
	 * A constructor for the class that takes a string, the action name, and a
	 * Icon.
	 * 
	 * @param text
	 *            The name of the action.
	 * @param icon
	 *            The icon representing the action.
	 */
	public ActionExportCanvasAsImage(String text, ImageIcon icon)
	{
		super(text, icon);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionExportAquariumToImageText"));
	}


	/**
	 * A constructor for the class that takes a string which will be the name of
	 * the action.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionExportCanvasAsImage(String text)
	{
		super(text);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionExportAquariumToImageText"));
	}


	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{

	}

}
