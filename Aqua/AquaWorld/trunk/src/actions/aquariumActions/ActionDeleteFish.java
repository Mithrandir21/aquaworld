package actions.aquariumActions;


import graphics.AquaWorld;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import actions.AbstractSystemAction;
import actions.SystemActionInterface;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ActionDeleteFish extends AbstractSystemAction implements SystemActionInterface
{
	/**
	 * A constructor for the class that takes a string, the action name, and an
	 * Icon.
	 * 
	 * @param text
	 *            The name of the action.
	 * @param icon
	 *            The icon representing the action.
	 */
	public ActionDeleteFish(String text, ImageIcon icon)
	{
		super(text, icon);
	}


	/**
	 * A constructor for the class that takes a string which will be the name of
	 * the action.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionDeleteFish(String text)
	{
		super(text);
	}


	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
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
		return AquaWorld.texts.getString("actionDeleteFiskActionPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getRedoPresentationName()
	 */
	@Override
	public String getRedoPresentationName()
	{
		return AquaWorld.texts.getString("actionDeleteFiskRedoPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getUndoPresentationName()
	 */
	@Override
	public String getUndoPresentationName()
	{
		return AquaWorld.texts.getString("actionDeleteFiskUndoPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#isSignificant()
	 */
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
	 * @see actions.AbstractSystemAction#performAction()
	 */
	@Override
	public void performAction(boolean undoable)
	{

	}
}
