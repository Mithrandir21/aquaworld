/**
 * 
 */
package graphics.GUI.propertiesArea;



import graphics.canvas.WorkareaCanvas;

import javax.swing.JScrollPane;

import widgets.WidgetTransferable;


/**
 * An extension of the JScrollPane class that is used to show the properties of any chosen canvas or object.
 * 
 * @author Bahram Malaekeh
 */
public class ObjectScrollProperties extends JScrollPane
{
	private ObjectProperties objProp;

	public ObjectScrollProperties()
	{
		setHorizontalScrollBarPolicy(this.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(this.VERTICAL_SCROLLBAR_AS_NEEDED);
	}



	/**
	 * Sets the view inside the JScrollPane to a new ObjectProperties with the given object as a parameter.
	 */
	public void newObjectSelectedPropertiesTab(WidgetTransferable object)
	{
		objProp = new ObjectProperties(object);

		this.setViewportView(objProp);
	}



	/**
	 * Sets the view inside the JScrollPane to a new ObjectProperties with the given canvas as a parameter.
	 */
	public void newObjectSelectedPropertiesTab(WorkareaCanvas canvas)
	{
		objProp = new ObjectProperties(canvas);

		this.setViewportView(objProp);
	}


	/**
	 * @return Returns the ObjectPropertie Panel that contains the actual fields and buttons.
	 */
	public ObjectProperties getObjectPropertiePanel()
	{
		return objProp;
	}
}
