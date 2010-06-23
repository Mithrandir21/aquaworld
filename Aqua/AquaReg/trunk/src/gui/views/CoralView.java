package gui.views;


import graphicalObjects.AquaField;
import graphicalObjects.LockCheckBox;
import graphicalObjects.RangeLockCheckBox;
import gui.GraficalFunctions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sqlLogic.SQLfunctions;
import coreObjects.ObjectParameters;
import coreObjects.Fish.FishObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class CoralView extends JPanel implements ActionListener
{
	AquaField genusField = new AquaField(false);

	AquaField speciesField = new AquaField(true);

	AquaField popNameField = new AquaField(false);

	AquaField sizeField = new AquaField(true);

	AquaField spaceNeededField = new AquaField(false);

	AquaField groupField = new AquaField(false);


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



	public CoralView()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		// d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridy = 0; // third row


		d.gridx = 0;
		this.add(getUniquePanel(genusField, "Genus", this, false, true), d);

		d.gridx = 1;
		this.add(getUniquePanel(speciesField, "Species", this, true, false), d);

		d.gridx = 2;
		this.add(getUniquePanel(popNameField, "Populare Name", this, false,
				false), d);

		d.gridx = 3;
		this.add(getUniquePanel(sizeField, "Size", this, true, true), d);

		d.gridx = 4;
		this.add(getUniquePanel(spaceNeededField, "Space Needed", this, false,
				true), d);

		d.gridx = 5;
		this.add(getUniquePanel(groupField, "Group", this, false, true), d);



		d.gridy = 1;

		d.gridx = 0; // aligned with button 2
		this.add(getLowHighPanel(salinityLowField, salinityHighField,
				"Salinity", this, true), d);

		d.gridx = 1;
		this.add(getLowHighPanel(phLowField, phHighField, "PH", this, true), d);
		// this.add(panel1, c);

		d.gridx = 2;
		this.add(getLowHighPanel(ghLowField, ghHighField, "GH", this, true), d);
		// this.add(panel1, c);

		d.gridx = 3;
		this
				.add(
						getLowHighPanel(khLowField, khHighField, "KH", this,
								false), d);
		// this.add(panel1, c);

		d.gridx = 4;
		this.add(getLowHighPanel(tempLowField, tempHighField, "Temperature",
				this, true), d);
		// this.add(panel1, c);

		d.gridx = 5;
		this.add(getLowHighPanel(othersSizeLowField, othersSizeHighField,
				"Others Size", this, false), d);



		d.weighty = 0; // request any extra vertical space
		d.anchor = GridBagConstraints.LAST_LINE_START; // bottom of space
		d.gridy = 2;
		d.gridx = 0;
		d.gridwidth = 5;
		Dimension descSize = new Dimension(550, 130);
		this.add(GraficalFunctions.getDescriptionPanel(descSize), d);


		d.weighty = 0; // request any extra vertical space
		d.anchor = GridBagConstraints.LAST_LINE_END; // bottom of space
		d.gridy = 2;
		d.gridx = 5;
		d.gridwidth = 1;
		this.add(GraficalFunctions.getButtons(this), d);

	}


	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() instanceof JCheckBox )
		{
			if ( e.getSource() instanceof LockCheckBox )
			{
				LockCheckBox box = (LockCheckBox) e.getSource();

				box.getJTextField().setEditable(!box.isSelected());
			}
			else if ( e.getSource() instanceof RangeLockCheckBox )
			{
				RangeLockCheckBox box = (RangeLockCheckBox) e.getSource();

				box.getLowJTextField().setEditable(!box.isSelected());
				box.getHighJTextField().setEditable(!box.isSelected());
			}
		}
		else if ( e.getSource() instanceof JButton )
		{
			JButton button = (JButton) e.getSource();

			if ( button.getActionCommand().equals("reset") )
			{
				resetAction();
			}
			else if ( button.getActionCommand().equals("save") )
			{
				saveAction();
			}
		}
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
	 * Resets both given fields if they are editable. It also resets the backgrounds.
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
	private void resetAction()
	{
		// The single fields
		resetSingleField(genusField);
		resetSingleField(speciesField);
		resetSingleField(popNameField);
		resetSingleField(sizeField);
		resetSingleField(spaceNeededField);
		resetSingleField(groupField);


		// The range fields
		resetRangeFields(salinityLowField, salinityHighField);
		resetRangeFields(phLowField, phHighField);
		resetRangeFields(ghLowField, ghHighField);
		resetRangeFields(khLowField, khHighField);
		resetRangeFields(tempLowField, tempHighField);
		resetRangeFields(othersSizeLowField, othersSizeHighField);
	}




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


	private double getFieldDouble(AquaField field)
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
	private void saveAction()
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


		genusDataVerified = checkSingleField(genusField, String.class);

		speciesDataVerified = checkSingleField(speciesField, String.class);

		popNameDataVerified = checkSingleField(popNameField, String.class);

		sizeDataVerified = checkSingleField(sizeField, Integer.class);

		spaceNeededDataVerified = checkSingleField(spaceNeededField,
				Double.class);

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


		System.out.println(allDataVerified);



		if ( allDataVerified )
		{
			// insertObjectParameters();
		}
	}



	private FishObject insertCoralObject()
	{

		return null;
	}


	private ObjectParameters insertObjectParameters()
	{
		double[] sal = new double[2];
		double[] ph = new double[2];
		double[] gh = new double[2];
		double[] kh = new double[2];
		double[] temp = new double[2];
		double[] magnesium = { 300, 4500 };
		double[] calcium = { 1300, 1500 };
		double spaceNeeded = -1.0;
		double[] othersSize = new double[2];


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

		System.out.println(parameters);


		try
		{
			Class.forName("org.sqlite.JDBC");
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch ( ClassNotFoundException e1 )
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long time = System.currentTimeMillis();


		Connection connection = null;

		try
		{
			String url = "jdbc:mysql://db4free.net:3306/aquaworld";
			String user = "mithrandir21";
			String pass = "sauron21";
			// create a database connection
			connection = DriverManager.getConnection(url, user, pass);


			// connection = DriverManager.getConnection("jdbc:sqlite:Fish.db");

			SQLfunctions.databaseStatementExecution(connection, parameters);
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

		time = System.currentTimeMillis() - time;

		System.out.println(time);
		// }
		// else
		// {
		//		
		// }
		// }


		return null;
	}



	/**
	 * Checks the two given numbers to see whether any of them is below 0(zero) and that low is lower then high.
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



	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(AquaField field, String valueName,
			ActionListener lis, boolean necessaryField, boolean lockPossible)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 65);
		panel.setPreferredSize(panelSize);
		panel.setMinimumSize(panelSize);
		panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());

		// JPanel panel1 = new JPanel(new GridBagLayout());
		// Dimension panelSize1 = new Dimension(200, 400);
		// panel1.setPreferredSize(panelSize1);
		// panel1.setMinimumSize(panelSize1);
		// panel1.setMaximumSize(panelSize1);
		// panel1.setBorder(BorderFactory.createEtchedBorder());

		GridBagConstraints c = new GridBagConstraints();


		JLabel label = new JLabel(valueName);
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.CENTER; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 0; // third row
		panel.add(label, c);


		field.setActionCommand(valueName);
		Dimension textSize = new Dimension(100, 20);
		field.setPreferredSize(textSize);
		field.setMinimumSize(textSize);
		field.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(7, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(field, c);



		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row

		JPanel lockPanel = new JPanel(new GridLayout());

		if ( lockPossible )
		{
			LockCheckBox lock = new LockCheckBox(field);
			lock.setActionCommand(valueName);
			lock.addActionListener(lis);
			lock.setFocusable(false);
			lockPanel.add(lock, c);
		}

		panel.add(lockPanel, c);



		return panel;
	}




	/**
	 * TODO - Description
	 */
	public static JPanel getLowHighPanel(AquaField low, AquaField high,
			String valueName, ActionListener lis, boolean necessaryField)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 90);
		panel.setPreferredSize(panelSize);
		panel.setMinimumSize(panelSize);
		panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());

		// JPanel panel1 = new JPanel(new GridBagLayout());
		// Dimension panelSize1 = new Dimension(200, 400);
		// panel1.setPreferredSize(panelSize1);
		// panel1.setMinimumSize(panelSize1);
		// panel1.setMaximumSize(panelSize1);
		// panel1.setBorder(BorderFactory.createEtchedBorder());

		GridBagConstraints c = new GridBagConstraints();


		JLabel label1 = new JLabel(valueName);
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.CENTER; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 0; // third row
		panel.add(label1, c);


		Dimension textSize = new Dimension(40, 20);
		low.setPreferredSize(textSize);
		low.setMinimumSize(textSize);
		low.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(0, 0, 0, 10); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 1; // third row
		panel.add(low, c);


		high.setPreferredSize(textSize);
		high.setMinimumSize(textSize);
		high.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 1; // third row
		panel.add(high, c);


		JLabel label2 = new JLabel("Low");
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(label2, c);


		JLabel label3 = new JLabel("High");
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(label3, c);


		RangeLockCheckBox lock = new RangeLockCheckBox(low, high);
		lock.setActionCommand(valueName);
		lock.addActionListener(lis);
		lock.setFocusable(false);
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row
		panel.add(lock, c);


		return panel;
	}
}
