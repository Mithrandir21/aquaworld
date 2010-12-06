package gui.views;


import graphicalObjects.AquaAutoCompleteComboBox;
import graphicalObjects.AquaField;
import gui.AquaReg;
import gui.GraficalFunctions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import sqlLogic.SQLfunctions;
import coreObjects.AbstractObject;


public abstract class AbstractView extends JPanel implements ActionListener
{
	AquaField genusField = new AquaField(false);

	AquaField speciesField = new AquaField(true);

	AquaField popNameField = new AquaField(false);

	AquaField sizeField = new AquaField(true);

	AquaField spaceNeededField = new AquaField(false);

	AquaAutoCompleteComboBox groupField = new AquaAutoCompleteComboBox(false);


	AquaField salinityLowField = new AquaField(true);

	AquaField salinityHighField = new AquaField(true);

	AquaField phLowField = new AquaField(true);

	AquaField phHighField = new AquaField(true);

	AquaField ghLowField = new AquaField(true);

	AquaField ghHighField = new AquaField(true);

	AquaField khLowField = new AquaField(false);

	AquaField khHighField = new AquaField(false);

	AquaField tempLowField = new AquaField(true);

	AquaField tempHighField = new AquaField(true);

	AquaField othersSizeLowField = new AquaField(false);

	AquaField othersSizeHighField = new AquaField(false);


	JTextArea descriptionArea = new JTextArea();


	/**
	 * TODO - Description NEEDED!
	 */
	public AbstractView()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.gridx = 0;
		this.add(GraficalFunctions.getUniquePanel(genusField, "Genus", this,
				false, true), d);

		d.gridx = 1;
		this.add(GraficalFunctions.getUniquePanel(speciesField, "Species",
				this, true, false), d);

		d.gridx = 2;
		this.add(GraficalFunctions.getUniquePanel(popNameField,
				"Populare Name", this, false, false), d);

		d.gridx = 3;
		this.add(GraficalFunctions.getUniquePanel(sizeField, "Size", this,
				true, true), d);

		d.gridx = 4;
		this.add(GraficalFunctions.getUniquePanel(spaceNeededField,
				"Space Needed", this, false, true), d);

		Connection con = AquaReg.getConnectionToDB();
		String[] arrayNames = SQLfunctions.databaseGetGroupNames(con);
		AquaReg.closeConnection(con);
		if ( arrayNames != null )
		{
			List<String> groupNames = new ArrayList<String>(arrayNames.length);
			for ( String s : arrayNames )
			{
				groupNames.add(s);
			}
			groupField.setAutoComplete(groupNames);
			groupField.setSelectedIndex(-1);
		}
		d.gridx = 5;
		this.add(GraficalFunctions.getUniquePanel(groupField, "Group", this,
				false, true), d);


		d.gridy = 1;

		d.gridx = 0; // aligned with button 2
		this.add(GraficalFunctions.getLowHighPanel(salinityLowField,
				salinityHighField, "Salinity", this, true), d);

		d.gridx = 1;
		this.add(GraficalFunctions.getLowHighPanel(phLowField, phHighField,
				"PH", this, true), d);
		// this.add(panel1, c);

		d.gridx = 2;
		this.add(GraficalFunctions.getLowHighPanel(ghLowField, ghHighField,
				"GH", this, true), d);
		// this.add(panel1, c);

		d.gridx = 3;
		this.add(GraficalFunctions.getLowHighPanel(khLowField, khHighField,
				"KH", this, false), d);
		// this.add(panel1, c);

		d.gridx = 4;
		this.add(GraficalFunctions.getLowHighPanel(tempLowField, tempHighField,
				"Temperature", this, true), d);
		// this.add(panel1, c);

		d.gridx = 5;
		this.add(GraficalFunctions.getLowHighPanel(othersSizeLowField,
				othersSizeHighField, "Others Size", this, false), d);



		d.weighty = 0; // request any extra vertical space
		d.anchor = GridBagConstraints.LAST_LINE_START; // bottom of space
		d.gridy = 2;
		d.gridx = 0;
		d.gridwidth = 5;
		Dimension descSize = new Dimension(550, 130);
		this.add(GraficalFunctions.getDescriptionPanel(descriptionArea,
				descSize), d);


		d.weighty = 0; // request any extra vertical space
		d.anchor = GridBagConstraints.LAST_LINE_END; // bottom of space
		d.gridy = 2;
		d.gridx = 5;
		d.gridwidth = 1;
		this.add(GraficalFunctions.getButtons(this), d);

	}


	/**
	 * Resets the given field if it is editable. It also resets the background.
	 */
	private void resetSingleField(AquaField field)
	{
		if ( field.isEditable() )
		{
			field.setText("");

			if ( field.necessaryField )
			{
				field.setBackground(Color.CYAN);
			}
			else
			{
				field.setBackground(Color.WHITE);
			}
		}
	}


	/**
	 * Resets both given fields if they are editable. It also resets the
	 * backgrounds.
	 */
	private void resetRangeFields(AquaField low, AquaField high)
	{
		if ( low.isEditable() )
		{
			low.setText("");
			high.setText("");

			if ( low.necessaryField )
			{
				low.setBackground(Color.CYAN);
				high.setBackground(Color.CYAN);
			}
			else
			{
				low.setBackground(Color.WHITE);
				high.setBackground(Color.WHITE);
			}
		}
	}


	/**
	 * Resets the fields that are not locked and resets the backgrounds.
	 */
	public void resetAction()
	{
		// The single fields
		resetSingleField(genusField);
		resetSingleField(speciesField);
		resetSingleField(popNameField);
		resetSingleField(sizeField);
		resetSingleField(spaceNeededField);

		groupField.setSelectedIndex(-1);
		groupField.setBackgroundAsEmpty();

		// The range fields
		resetRangeFields(salinityLowField, salinityHighField);
		resetRangeFields(phLowField, phHighField);
		resetRangeFields(ghLowField, ghHighField);
		resetRangeFields(khLowField, khHighField);
		resetRangeFields(tempLowField, tempHighField);
		resetRangeFields(othersSizeLowField, othersSizeHighField);
	}


	/**
	 * TODO - Description
	 */
	private boolean checkSingleField(AquaField field, Class inputType)
	{
		if ( field.getText().equals("") )
		{
			if ( field.necessaryField )
			{
				field.setBackgroundAsError();
				return false;
			}
		}
		else
		{
			// Int
			if ( inputType.equals(Integer.class) )
			{
				try
				{
					Integer.parseInt(field.getText());
				}
				catch ( NumberFormatException e )
				{
					field.setBackgroundAsError();
					return false;
				}
			}
			// Double
			else if ( inputType.equals(Double.class) )
			{

				try
				{
					Double.parseDouble(field.getText());
				}
				catch ( NumberFormatException e )
				{
					field.setBackgroundAsError();
					return false;
				}
			}
			// String
			else if ( inputType.equals(String.class) )
			{
				// try
				// {
				// int check = Integer.parseInt(field.getText());
				// }
				// catch ( NumberFormatException e )
				// {
				// field.setBackgroundAsError();
				// return false;
				// }
			}
		}


		field.setBackgroundAsCorrect();
		return true;
	}


	/**
	 * TODO - Description
	 */
	private int getFieldInt(AquaField field)
	{
		int fieldNumber = -1;


		if ( field.getText().equals("") )
		{
			if ( field.necessaryField )
			{
				field.setBackgroundAsError();
				return -1;
			}
		}
		else
		{
			try
			{
				fieldNumber = Integer.parseInt(field.getText());
			}
			catch ( NumberFormatException e )
			{
				field.setBackgroundAsError();
				return -1;
			}
		}


		field.setBackgroundAsCorrect();
		return fieldNumber;
	}


	/**
	 * This function attempts to determine if the given field contains a valid
	 * double. Will return -1.0 if anything is wrong.
	 */
	public double getFieldDouble(AquaField field)
	{
		double fieldNumber = -1.0;


		if ( field.getText().equals("") )
		{
			if ( field.necessaryField )
			{
				field.setBackgroundAsError();
				return -1.0;
			}
		}
		else
		{
			try
			{
				fieldNumber = Double.parseDouble(field.getText());
			}
			catch ( NumberFormatException e )
			{
				field.setBackgroundAsError();
				return -1.0;
			}
		}


		field.setBackgroundAsCorrect();
		return fieldNumber;
	}


	/**
	 * This function determines if the given fields contain values that match
	 * the given input type(Class). The function will also determine if the
	 * given values in the fields create a valid range.
	 */
	private boolean checkRangeFields(AquaField low, AquaField high,
			Class inputType)
	{
		boolean lowVerified = true;
		boolean highVerified = true;

		// Verifies the actual text in the field
		lowVerified = checkSingleField(low, inputType);

		// Verifies the actual text in the field
		highVerified = checkSingleField(high, inputType);


		// If both are the correct number type(Double or Integer)
		if ( lowVerified && highVerified )
		{
			// Tells whether or not the range is verified
			boolean rangeVerified = false;

			// If the given class is Integer
			if ( inputType.equals(Integer.class) )
			{
				int lowNumber = getFieldInt(low);
				int highNumber = getFieldInt(high);

				// Verifies that low is above 0 and lower then high
				rangeVerified = checkRangeAboveZero(lowNumber, highNumber);
			}
			// If the given class is Double
			else if ( inputType.equals(Double.class) )
			{
				double lowNumber = getFieldDouble(low);
				double highNumber = getFieldDouble(high);

				// Verifies that low is above 0 and lower then high
				rangeVerified = checkRangeAboveZero(lowNumber, highNumber);
			}

			// If the range is not correct
			if ( !rangeVerified )
			{
				if ( !(low.getText().equals("")) )
				{
					low.setBackgroundAsError();
				}

				if ( !(high.getText().equals("")) )
				{
					high.setBackgroundAsError();
				}
				return false;
			}


			// If the range is not correct
			low.setBackgroundAsCorrect();
			high.setBackgroundAsCorrect();
			return true;
		}

		// The text in either low or high is not right
		return false;
	}


	/**
	 * TODO - Description
	 */
	public boolean saveAction()
	{
		boolean genusDataVerified = false;
		boolean speciesDataVerified = false;
		boolean popNameDataVerified = false;
		boolean sizeDataVerified = false;
		boolean spaceNeededDataVerified = false;

		boolean salinityDataVerified = false;
		boolean phDataVerified = false;
		boolean ghDataVerified = false;
		boolean khDataVerified = false;
		boolean tempDataVerified = false;
		boolean othersSizeDataVerified = false;
		boolean allDataVerified = false;


		// If the fields are not empty
		if ( !(genusField.getText().equals("")) )
		{
			genusDataVerified = checkSingleField(genusField, String.class);
		}
		else
		{
			// If the field is not necessary
			if ( genusField.necessaryField )
			{
				genusField.setBackgroundAsError();
			}
			else
			{
				genusDataVerified = true;
			}
		}



		// If the fields are not empty
		if ( !(speciesField.getText().equals("")) )
		{
			speciesDataVerified = checkSingleField(speciesField, String.class);
		}
		else
		{
			// If the field is not necessary
			if ( speciesField.necessaryField )
			{
				speciesField.setBackgroundAsError();
			}
			else
			{
				speciesDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(popNameField.getText().equals("")) )
		{
			popNameDataVerified = checkSingleField(popNameField, String.class);
		}
		else
		{
			// If the field is not necessary
			if ( popNameField.necessaryField )
			{
				popNameField.setBackgroundAsError();
			}
			else
			{
				popNameDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(sizeField.getText().equals("")) )
		{
			sizeDataVerified = checkSingleField(sizeField, Integer.class);
		}
		else
		{
			// If the field is not necessary
			if ( sizeField.necessaryField )
			{
				sizeField.setBackgroundAsError();
			}
			else
			{
				sizeDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(spaceNeededField.getText().equals("")) )
		{
			spaceNeededDataVerified = checkSingleField(spaceNeededField,
					Double.class);
		}
		else
		{
			// If the field is not necessary
			if ( spaceNeededField.necessaryField )
			{
				spaceNeededField.setBackgroundAsError();
			}
			else
			{
				spaceNeededDataVerified = true;
			}
		}




		// If the fields are not empty
		if ( !(checkRangeFieldsAreEmpty(salinityLowField, salinityHighField)) )
		{
			salinityDataVerified = checkRangeFields(salinityLowField,
					salinityHighField, Double.class);
		}
		else
		{
			// If the field is not necessary
			if ( salinityLowField.necessaryField )
			{
				salinityLowField.setBackgroundAsError();
				salinityHighField.setBackgroundAsError();
			}
			else
			{
				salinityDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(checkRangeFieldsAreEmpty(phLowField, phHighField)) )
		{
			phDataVerified = checkRangeFields(phLowField, phHighField,
					Double.class);
		}
		else
		{
			// If the field is not necessary
			if ( phLowField.necessaryField )
			{
				phLowField.setBackgroundAsError();
				phHighField.setBackgroundAsError();
			}
			else
			{
				phDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(checkRangeFieldsAreEmpty(ghLowField, ghHighField)) )
		{
			ghDataVerified = checkRangeFields(ghLowField, ghHighField,
					Double.class);
		}
		else
		{
			// If the field is not necessary
			if ( ghLowField.necessaryField )
			{
				ghLowField.setBackgroundAsError();
				ghHighField.setBackgroundAsError();
			}
			else
			{
				ghDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(checkRangeFieldsAreEmpty(khLowField, khHighField)) )
		{
			khDataVerified = checkRangeFields(khLowField, khHighField,
					Double.class);
		}
		else
		{
			// If the field is not necessary
			if ( khLowField.necessaryField )
			{
				khLowField.setBackgroundAsError();
				khHighField.setBackgroundAsError();
			}
			else
			{
				khDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(checkRangeFieldsAreEmpty(tempLowField, tempHighField)) )
		{
			tempDataVerified = checkRangeFields(tempLowField, tempHighField,
					Double.class);
		}
		else
		{
			// If the field is not necessary
			if ( tempLowField.necessaryField )
			{
				tempLowField.setBackgroundAsError();
				tempHighField.setBackgroundAsError();
			}
			else
			{
				tempDataVerified = true;
			}
		}

		// If the fields are not empty
		if ( !(checkRangeFieldsAreEmpty(othersSizeLowField, othersSizeHighField)) )
		{
			othersSizeDataVerified = checkRangeFields(othersSizeLowField,
					othersSizeHighField, Double.class);
		}
		else
		{
			// If the field is not necessary
			if ( othersSizeLowField.necessaryField )
			{
				othersSizeLowField.setBackgroundAsError();
				othersSizeHighField.setBackgroundAsError();
			}
			else
			{
				othersSizeDataVerified = true;
			}
		}


		if ( genusDataVerified == true && speciesDataVerified == true
				&& popNameDataVerified == true && sizeDataVerified == true
				&& spaceNeededDataVerified == true
				&& salinityDataVerified == true && phDataVerified == true
				&& ghDataVerified == true && khDataVerified == true
				&& tempDataVerified == true && othersSizeDataVerified == true )
		{
			allDataVerified = true;
		}


		return allDataVerified;
	}


	/**
	 * TODO - Description
	 */
	public int insertObjectParameters()
	{
		// The ID that will be returned of the entry that is to be created
		int parametersID = -1;

		// The initial fields
		double[] sal = new double[2];
		double[] ph = new double[2];
		double[] gh = new double[2];
		double[] kh = new double[2];
		double[] temp = new double[2];
		double[] magnesium = { 300, 4500 };
		double[] calcium = { 1300, 1500 };
		double spaceNeeded = -1.0;
		double[] othersSize = new double[2];

		/**
		 * Getting the data from the fields. When the program gets here the
		 * fields have been checked and verified. -1 will be returned for
		 * invalid numbers and fields.
		 */
		sal[0] = getFieldDouble(salinityLowField);
		sal[1] = getFieldDouble(salinityHighField);
		ph[0] = getFieldDouble(phLowField);
		ph[1] = getFieldDouble(phHighField);
		gh[0] = getFieldDouble(ghLowField);
		gh[1] = getFieldDouble(ghHighField);
		kh[0] = getFieldDouble(khLowField);
		kh[1] = getFieldDouble(khHighField);
		temp[0] = getFieldDouble(tempLowField);
		temp[1] = getFieldDouble(tempHighField);
		othersSize[0] = getFieldDouble(othersSizeLowField);
		othersSize[1] = getFieldDouble(othersSizeHighField);
		spaceNeeded = getFieldInt(spaceNeededField);


		/**
		 * Creating the INSERT string with null as the ID so the field is auto
		 * incremented by the SQL server. That ID is then returned.
		 */
		String parameters = "INSERT INTO ObjectParameters " + "VALUES (" + null
				+ ", " + "" + sal[0] + // Salinity Low
				", " + sal[1] + // Salinity High
				", " + ph[0] + // PH Low
				", " + ph[1] + // PH High
				", " + gh[0] + // GH Low
				", " + gh[1] + // GH High
				", " + temp[0] + // Temperature Low
				", " + temp[1] + // Temperature High
				", " + kh[0] + // KH Low
				", " + kh[1] + // KH High
				", " + magnesium[0] + // Magnesium Low
				", " + magnesium[1] + // Magnesium High
				", " + calcium[0] + // Calcium Low
				", " + calcium[1] + // Calcium High
				", " + spaceNeeded + // Space Needed
				", " + othersSize[0] + // Others Size Low
				", " + othersSize[1] + // Others Size High
				");";


		Connection connection = null;
		try
		{
			connection = AquaReg.getConnectionToDB();

			// If the returned connection is not null
			if ( connection != null )
			{
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(parameters,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();
				statement.executeUpdate("COMMIT;");


				if ( rs.next() )
				{
					parametersID = rs.getInt(1);
				}
			}
		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{
			try
			{
				if ( connection != null )
					connection.close();
			}
			catch ( SQLException e )
			{
				// connection close failed.
				System.err.println(e);
			}
		}


		return parametersID;
	}


	/**
	 * TODO - Description
	 */
	public boolean updateObjectParameters(AbstractObject obj)
	{
		// The ID that will be returned of the entry that is to be created
		int parametersID = obj.getParameters().getObjectParametersID();

		// The initial fields
		double[] sal = new double[2];
		double[] ph = new double[2];
		double[] gh = new double[2];
		double[] kh = new double[2];
		double[] temp = new double[2];
		double[] magnesium = { 300, 4500 };
		double[] calcium = { 1300, 1500 };
		double spaceNeeded = -1.0;
		double[] othersSize = new double[2];

		/**
		 * Getting the data from the fields. When the program gets here the
		 * fields have been checked and verified. -1 will be returned for
		 * invalid numbers and fields.
		 */
		sal[0] = getFieldDouble(salinityLowField);
		sal[1] = getFieldDouble(salinityHighField);
		ph[0] = getFieldDouble(phLowField);
		ph[1] = getFieldDouble(phHighField);
		gh[0] = getFieldDouble(ghLowField);
		gh[1] = getFieldDouble(ghHighField);
		kh[0] = getFieldDouble(khLowField);
		kh[1] = getFieldDouble(khHighField);
		temp[0] = getFieldDouble(tempLowField);
		temp[1] = getFieldDouble(tempHighField);
		othersSize[0] = getFieldDouble(othersSizeLowField);
		othersSize[1] = getFieldDouble(othersSizeHighField);
		spaceNeeded = getFieldInt(spaceNeededField);


		/**
		 * Creating the UPDATE string
		 */
		String parameters = "UPDATE ObjectParameters " + "SET "
				+ "SalinityLow="
				+ sal[0] + // Salinity Low
				", SalinityHigh=" + sal[1] + // Salinity High
				", PHLow=" + ph[0] + // PH Low
				", PHHigh=" + ph[1] + // PH High
				", GHLow=" + gh[0] + // GH Low
				", GHHigh=" + gh[1] + // GH High
				", TemperatureLow=" + temp[0] + // Temperature Low
				", TemperatureHigh=" + temp[1] + // Temperature High
				", KHLow=" + kh[0] + // KH Low
				", KHHigh=" + kh[1] + // KH High
				", MagnesiumLow=" + magnesium[0] + // Magnesium Low
				", MagnesiumHigh=" + magnesium[1] + // Magnesium High
				", CalciumLow=" + calcium[0] + // Calcium Low
				", CalciumHigh=" + calcium[1] + // Calcium High
				", SpaceNeeded=" + spaceNeeded + // Space Needed
				", OthersSizeLow=" + othersSize[0] + // Others Size Low
				", OthersSizeHigh=" + othersSize[1] + // Others Size High
				" WHERE ObjectParametersID=" + parametersID;


		Connection connection = null;
		try
		{
			connection = AquaReg.getConnectionToDB();

			// If the returned connection is not null
			if ( connection != null )
			{
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(parameters);
				statement.executeUpdate("COMMIT;");
			}
		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}
		finally
		{
			try
			{
				if ( connection != null )
					connection.close();
			}
			catch ( SQLException e )
			{
				// connection close failed.
				System.err.println(e);
			}
		}


		return true;
	}



	/**
	 * Checks the two given numbers to see whether any of them is below 0(zero)
	 * and that low is lower then high.
	 */
	private boolean checkRangeAboveZero(double low, double high)
	{
		// If low or high is below zero or low is higher then high
		if ( low < 0.0 || high < 0.0 || low > high )
		{
			return false;
		}

		return true;
	}


	/**
	 * Checks if both the given fields are empty for any text.
	 */
	private boolean checkRangeFieldsAreEmpty(AquaField low, AquaField high)
	{
		if ( low.getText().equals("") && high.getText().equals("") )
		{
			return true;
		}

		return false;
	}

}
