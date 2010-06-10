/**
 * 
 */
package actions.systemActions;



import graphics.AquaWorld;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import actions.AbstractSystemAction;


/**
 * An action class that will call function to open a {@link WorkareaCanvas}.
 * 
 * @author Bahram Malaekeh
 * @version 1.0
 */
public class ActionOpenfile extends AbstractSystemAction
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
	public ActionOpenfile(String text, ImageIcon icon)
	{
		super(text, icon);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionOpenFileText"));
	}


	/**
	 * A constructor for the class that takes a string which will be the name of
	 * the action.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionOpenfile(String text)
	{
		super(text);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionOpenFileText"));
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
