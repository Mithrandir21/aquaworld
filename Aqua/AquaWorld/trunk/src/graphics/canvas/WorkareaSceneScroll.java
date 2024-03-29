package graphics.canvas;


import graphics.canvas.providers.ActionsAdder;

import javax.swing.JScrollPane;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class WorkareaSceneScroll extends JScrollPane
{
	private WorkareaCanvas canvas;


	/**
	 * A constructor that takes a WorkareaCanvas and sets it to the classes private WorkareaCanvas.
	 * 
	 * @param canvas
	 *            The WorkareaCanvas that is to be placed inside the tab.
	 */
	public WorkareaSceneScroll(WorkareaCanvas canvas)
	{
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);

		this.canvas = canvas;
		ActionsAdder.makeWorkareaCanvasReady(canvas);
		createNewCanvas(canvas.getTankName());
	}



	/**
	 * A constructor that takes a WorkareaCanvas and sets it to the classes private WorkareaCanvas. This function calls
	 * a method that sets the given name as the name of the given WorkareaCanvas.
	 * 
	 * @param name
	 *            The name of the tab which will contain the given WorkareaCanvas.
	 * @param canvas
	 *            The WorkareaCanvas that is to be placed inside the tab.
	 */
	public WorkareaSceneScroll(String name, WorkareaCanvas canvas)
	{
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);

		this.canvas = canvas;
		ActionsAdder.makeWorkareaCanvasReady(canvas);
		createNewCanvas(name);
	}


	/**
	 * Sets this JScrollPanes view to the classes WorkareaCanvas. It also adds the the given and adds the given
	 * WorkareaCanvas with the given name to the systems array of WorkareaCanvases.
	 * 
	 * @param name
	 *            The name of the canvas.
	 */
	public void createNewCanvas(String name)
	{
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);

		this.setViewportView(canvas.getMyView());


		// Adds the canvas the array of currently active WorkareaCanvas
		// DesktopCanvasManagment.addCanvas(canvas, name);
	}


	/**
	 * Gets the classes WorkareaCanvas.
	 * 
	 * @return the canvas
	 */
	public WorkareaCanvas getCanvas()
	{
		return canvas;
	}
}
