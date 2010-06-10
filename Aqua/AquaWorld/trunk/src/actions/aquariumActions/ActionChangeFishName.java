package actions.aquariumActions;


import graphics.AquaWorld;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import actions.AbstractSystemAction;
import actions.SystemActionInterface;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ActionChangeFishName extends AbstractSystemAction implements SystemActionInterface
{
	/**
	 * A constructor for the class that takes a string, the action name, an
	 * Icon, a {@link WidgetFish} and a String that is to be the new name of
	 * the given {@link WidgetFish}.
	 * 
	 * @param text
	 *            The name of the action.
	 * @param icon
	 */
	public ActionChangeFishName(String text, ImageIcon icon)
	{
		super(text, icon);
	}

	/**
	 * A constructor for the class that takes a string, the action name, a
	 * {@link WidgetFish} and a String that is to be the new name of
	 * the given {@link WidgetFish}.
	 * 
	 * @param text
	 *            The name of the action.
	 */
	public ActionChangeFishName(String text)
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
	 * @see actions.AbstractSystemAction#addEdit(javax.swing.undo.UndoableEdit)
	 */
	@Override
	public boolean addEdit(UndoableEdit anEdit)
	{
		return false;
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
		return AquaWorld.texts
				.getString("actionChangeFishNameActionPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getRedoPresentationName()
	 */
	@Override
	public String getRedoPresentationName()
	{
		return AquaWorld.texts
				.getString("actionChangeFishNameRedoPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getUndoPresentationName()
	 */
	@Override
	public String getUndoPresentationName()
	{
		return AquaWorld.texts
				.getString("actionChangeFishNameUndoPresNameText");
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
	 * @see actions.SystemActionInterface#performAction(boolean)
	 */
	@Override
	public void performAction(boolean undoable)
	{

	}
}
