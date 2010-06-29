/**
 * 
 */
package gui.views;


import graphicalObjects.AquaField;

import java.awt.event.ActionEvent;

import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class EditingView extends AbstractView
{
	/**
	 * Empty constructor
	 */
	public EditingView()
	{

	}


	public void populateFields(AbstractObject obj)
	{
		ObjectParameters par = obj.getParameters();

		// Gets the genus
		populateField(genusField, obj.getGenusName());

		// Gets the species
		populateField(speciesField, obj.getSpeciesName());

		// Gets the popular name
		populateField(popNameField, obj.getPopulareName());

		// Gets the size
		populateField(sizeField, "");

		// Gets the space needed
		populateField(spaceNeededField, par.getSpaceNeeded());


		// Gets the salinity low
		populateField(salinityLowField, par.getSalinityLow());

		// Gets the salinity high
		populateField(salinityHighField, par.getSalinityHigh());


		// Gets the ph low
		populateField(phLowField, par.getPHlow());

		// Gets the ph high
		populateField(phHighField, par.getPHhigh());


		// Gets the gh low
		populateField(ghLowField, par.getGHlow());

		// Gets the gh high
		populateField(ghHighField, par.getGHhigh());


		// Gets the kh low
		populateField(khLowField, par.getKhLow());

		// Gets the kh high
		populateField(khHighField, par.getKhHigh());


		// Gets the temp low
		populateField(tempLowField, par.getTemperatureLow());

		// Gets the temp high
		populateField(tempHighField, par.getTemperatureHigh());


		// Gets the others size low
		populateField(othersSizeLowField, par.getOthersSizeLow());

		// Gets the others size high
		populateField(othersSizeHighField, par.getOthersSizeHigh());


		String text = obj.getDescription();
		if ( text != null && !(text.equalsIgnoreCase(""))
				&& !(text.equalsIgnoreCase("null")) )
		{
			descriptionArea.setText(text);
		}
		else
		{
			descriptionArea.setText("");
		}

		// AquaAutoCompleteComboBox groupField = new AquaAutoCompleteComboBox(false);

		this.revalidate();
		this.repaint();
	}



	/**
	 * TODO - Description
	 * 
	 */
	private void populateField(AquaField field, String text)
	{
		if ( text != null && !(text.equalsIgnoreCase(""))
				&& !(text.equalsIgnoreCase("null")) )
		{
			field.setText(text);
		}
		else
		{
			field.setText("");
		}
	}



	/**
	 * TODO - Description
	 * 
	 */
	private void populateField(AquaField field, int number)
	{
		if ( number > 0 )
		{
			field.setText("" + number);
		}
		else
		{
			field.setText("");
		}
	}



	/**
	 * TODO - Description
	 * 
	 */
	private void populateField(AquaField field, double number)
	{
		if ( number > 0.0 )
		{
			field.setText("" + number);
		}
		else
		{
			field.setText("");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
