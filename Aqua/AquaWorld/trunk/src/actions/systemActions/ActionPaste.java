/**
 * 
 */
package actions.systemActions;


import graphics.AquaWorld;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import actions.AbstractSystemAction;
import actions.SystemActionInterface;


/**
 * An action class that will perform a paste action that will first check to see
 * if the copyWidget or the cutWidget in the {@link AquaWorld} is null. If the
 * copyWidget variable is not null, it will perform a copy action. If the
 * copyWidget variable is null and the cutWidget is not null, it will perform a
 * cut action. After the action has been performed, where the selected widget
 * has been either cut or copied to the currently open {@link WorkareaCanvas},
 * the copyWidget or cutWidget variable will be set to null, depending on what
 * action has been performed. This action has an undo/redo function.
 * 
 * @author Bahram Malaekeh
 * @version 1.0
 */
public class ActionPaste extends AbstractSystemAction implements SystemActionInterface
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
	public ActionPaste(String text, ImageIcon icon)
	{
		super(text, icon);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionPasteDescriptionText"));
	}


	/**
	 * A constructor for the class that takes a string which will be the name of
	 * the action.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionPaste(String text)
	{
		super(text);
		putValue(SHORT_DESCRIPTION, AquaWorld.texts
				.getString("actionPasteDescriptionText"));
	}


	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		performAction(true);
	}


	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#canRedo()
	 */
	@Override
	public boolean canRedo()
	{
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#canUndo()
	 */
	@Override
	public boolean canUndo()
	{
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#die()
	 */
	@Override
	public void die()
	{

	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getPresentationName()
	 */
	@Override
	public String getPresentationName()
	{
		return AquaWorld.texts.getString("actionPasteActionPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getRedoPresentationName()
	 */
	@Override
	public String getRedoPresentationName()
	{
		return AquaWorld.texts.getString("actionPasteRedoPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getUndoPresentationName()
	 */
	@Override
	public String getUndoPresentationName()
	{
		return AquaWorld.texts.getString("actionPasteUndoPresNameText");
	}

	@Override
	public boolean isSignificant()
	{
		return true;
	}


	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#redo()
	 */
	@Override
	public void redo() throws CannotRedoException
	{

	}


	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#undo()
	 */
	@Override
	public void undo() throws CannotUndoException
	{

	}


	/*
	 * (non-Javadoc)
	 * @see actions.SystemActionInterface#performAction(boolean)
	 */
	@Override
	public void performAction(boolean undoable)
	{

	}

}
