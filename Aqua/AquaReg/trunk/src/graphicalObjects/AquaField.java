/**
 * 
 */
package graphicalObjects;


import java.awt.Color;

import javax.swing.JTextField;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class AquaField extends JTextField
{
	/**
	 * Whether or not the field is necessary for the creation of an object.
	 */
	public boolean necessaryField = false;


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param necField
	 */
	public AquaField(boolean necField)
	{
		necessaryField = necField;
		if ( necField )
		{
			this.setBackground(Color.cyan);
		}
	}




	public void setBackgroundAsError()
	{
		this.setBackground(Color.RED);
	}

	public void setBackgroundAsEmpty()
	{
		if ( necessaryField )
		{
			this.setBackground(Color.CYAN);
		}
		else
		{
			this.setBackground(Color.WHITE);
		}
	}

	public void setBackgroundAsCorrect()
	{
		if ( necessaryField )
		{
			this.setBackground(Color.GREEN);
		}
		else
		{
			this.setBackground(Color.WHITE);
		}
	}
}
