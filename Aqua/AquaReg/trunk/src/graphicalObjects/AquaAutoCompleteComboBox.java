/**
 * 
 */
package graphicalObjects;


import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class AquaAutoCompleteComboBox extends JComboBox
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
	public AquaAutoCompleteComboBox(boolean necField)
	{
		necessaryField = necField;
		this.setEditable(true);
		if ( necField )
		{
			this.setBackground(Color.cyan);
		}
	}



	/**
	 * This function sets the auto complete function to the this field.
	 */
	public void setAutoComplete(List<String> names)
	{
		this.setModel(new ListComboBoxModel<String>(names));
		AutoCompleteDecorator.decorate(this);
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
