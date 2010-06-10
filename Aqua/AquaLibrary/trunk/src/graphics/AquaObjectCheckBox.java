package graphics;

import javax.swing.JCheckBox;

import coreObjects.AbstractObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class AquaObjectCheckBox extends JCheckBox
{
	/**
	 * The object the checkbox represents.
	 */
	AbstractObject obj;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param object
	 */
	public AquaObjectCheckBox(AbstractObject object)
	{
		super();
		obj = object;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param object
	 * @param text
	 */
	public AquaObjectCheckBox(AbstractObject object, String text)
	{
		super(text);
		obj = object;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the obj
	 */
	public AbstractObject getObj()
	{
		return obj;
	}
}
