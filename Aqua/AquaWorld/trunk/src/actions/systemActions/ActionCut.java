/**
 * 
 */
package actions.systemActions;


import graphics.AquaWorld;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import actions.AbstractSystemAction;


/**
 * An action class that will perform a cut action that will place the currently
 * selected Widget, if any, from the current {@link WorkareaCanvas} into the
 * {@link PrimeMain1 PrimeMain1s} 'cutWidget' variable.
 * 
 * @author Bahram Malaekeh
 * @version 1.0
 */
public class ActionCut extends AbstractSystemAction
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
	public ActionCut(String text, ImageIcon icon)
	{
		super(text, icon);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts.getString("cutLabel"));
	}


	/**
	 * A constructor for the class that takes a string which will be the name of
	 * the action.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionCut(String text)
	{
		super(text);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts.getString("cutLabel"));
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
