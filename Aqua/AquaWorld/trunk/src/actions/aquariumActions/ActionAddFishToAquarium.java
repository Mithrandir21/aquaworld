package actions.aquariumActions;


import graphics.AquaWorld;
import graphics.canvas.WorkareaCanvas;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import widgets.WidgetTransferable;
import actions.AbstractSystemAction;
import actions.SystemActionInterface;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ActionAddFishToAquarium extends AbstractSystemAction implements SystemActionInterface
{
	// The canvas where the deletion is taking place
	private WorkareaCanvas canvas = null;

	// The widget object
	private WidgetTransferable widObject = null;

	// The point where the Object is to be added
	private Point objectPoint;



	/**
	 * A constructor for the class that takes a string, the action name, an
	 * Icon, a {@link WorkareaCanvas}, a {@link WidgetTransferable} and a
	 * {@link Point}.
	 * 
	 * @param text
	 *            The name of the action.
	 * @param icon
	 *            The icon representing the action.
	 * @param canvas
	 *            The {@link WorkareaCanvas} that the given
	 *            {@link WidgetTransferable} is to be added to.
	 * @param widObject
	 *            The {@link WidgetTransferable} that is to be added to the
	 *            given {@link WorkareaCanvas}.
	 * @param objectPoint
	 *            The {@link Point} where the {@link WidgetTransferable} is to
	 *            be placed on the {@link WorkareaCanvas}.
	 */
	public ActionAddFishToAquarium(String text, ImageIcon icon,
			WorkareaCanvas canvas, WidgetTransferable widObject, Point objectPoint)
	{
		super(text, icon);
		this.canvas = canvas;
		this.widObject = widObject;
		this.objectPoint = objectPoint;
	}



	/**
	 * A constructor for the class that takes a string, the action name, an
	 * Icon, a {@link WorkareaCanvas}, a {@link WidgetTransferable} and a
	 * {@link Point}.
	 * 
	 * @param text
	 *            The name of the action.
	 * @param icon
	 *            The icon representing the action.
	 * @param canvas
	 *            The {@link WorkareaCanvas} that the given
	 *            {@link WidgetTransferable} is to be added to.
	 * @param widObject
	 *            The {@link WidgetTransferable} that is to be added to the
	 *            given {@link WorkareaCanvas}.
	 * @param objectPoint
	 *            The {@link Point} where the {@link WidgetTransferable} is to
	 *            be placed on the {@link WorkareaCanvas}.
	 */
	public ActionAddFishToAquarium(String text, WorkareaCanvas canvas,
			WidgetTransferable widObject, Point objectPoint)
	{
		super(text);
		this.canvas = canvas;
		this.widObject = widObject;
		this.objectPoint = objectPoint;
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
		return AquaWorld.texts.getString("actionAddFishActionPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getRedoPresentationName()
	 */
	@Override
	public String getRedoPresentationName()
	{
		return AquaWorld.texts.getString("actionAddFishRedoPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see actions.AbstractSystemAction#getUndoPresentationName()
	 */
	@Override
	public String getUndoPresentationName()
	{
		return AquaWorld.texts.getString("actionAddFishUndoPresNameText");
	}

	/*
	 * (non-Javadoc)
	 * @see logistical.AbstractSystemAction#isSignificant()
	 */
	@Override
	public boolean isSignificant()
	{
		return true;
	}


	/*
	 * (non-Javadoc)
	 * @see logistical.AbstractSystemAction#redo()
	 */
	@Override
	public void redo() throws CannotRedoException
	{

	}


	/*
	 * (non-Javadoc)
	 * @see logistical.AbstractSystemAction#undo()
	 */
	@Override
	public void undo() throws CannotUndoException
	{

	}


	/*
	 * (non-Javadoc)
	 * @see logistical.SystemActionInterface#performAction()
	 */
	@Override
	public void performAction(boolean undoable)
	{

	}
}
