package actions;


import graphics.canvas.WorkareaCanvas;

import javax.swing.undo.UndoManager;


public class CanvasUndoManager extends UndoManager
{
	// The canvas which this manager belongs to
	private WorkareaCanvas canvas = null;

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param canvas
	 */
	public CanvasUndoManager(WorkareaCanvas canvas)
	{
		this.canvas = canvas;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the canvas
	 */
	public WorkareaCanvas getCanvas()
	{
		return canvas;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param canvas
	 *            the canvas to set
	 */
	public void setCanvas(WorkareaCanvas canvas)
	{
		this.canvas = canvas;
	}
}
