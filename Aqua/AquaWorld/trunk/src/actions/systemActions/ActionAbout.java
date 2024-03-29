/**
 * 
 */
package actions.systemActions;


import graphics.AquaWorld;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import actions.AbstractSystemAction;


/**
 * This action opens an "About" window.
 * 
 * @author Bahram Malaekeh
 */
public class ActionAbout extends AbstractSystemAction
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
	public ActionAbout(String text, ImageIcon icon)
	{
		super(text, icon);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionAboutDescriptionText"));
	}


	/**
	 * A constructor for the class that takes a string which will be the name of
	 * the action.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionAbout(String text)
	{
		super(text);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionAboutDescriptionText"));
	}



	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
