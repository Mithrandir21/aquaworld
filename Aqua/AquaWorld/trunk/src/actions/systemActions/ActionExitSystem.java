/**
 * 
 */
package actions.systemActions;


import graphics.AquaWorld;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import actions.AbstractSystemAction;


/**
 * This action calls the process that will exit and close the entire program.
 * The process called is the exitProcess in {@link AquaWorld}.
 * 
 * @author Bahram Malaekeh
 */
public class ActionExitSystem extends AbstractSystemAction
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
	public ActionExitSystem(String text, ImageIcon icon)
	{
		super(text, icon);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionExitSystemDescriptionText"));
	}


	/**
	 * A constructor for the class that takes a string which will be the name of
	 * the action.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionExitSystem(String text)
	{
		super(text);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionExitSystemDescriptionText"));
	}



	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		AquaWorld.exitProcess();
	}
}
