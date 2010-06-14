/**
 * 
 */
package graphics;


import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class AquaUneditableJCheckBox extends JCheckBox
{
	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param labelName
	 */
	public AquaUneditableJCheckBox(String labelName)
	{
		super(labelName);
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param labelName
	 * @param selected
	 */
	public AquaUneditableJCheckBox(String labelName, boolean selected)
	{
		super(labelName, selected);
	}



	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#processMouseEvent(java.awt.event.MouseEvent)
	 */
	@Override
	protected void processMouseEvent(MouseEvent e)
	{
		// Just don't do anything
	}
}
