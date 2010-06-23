package graphics.GUI.propertiesArea.objectTypes;


import graphics.AquaWorld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXCollapsiblePane;

import widgets.WidgetInvertebrates;
import coreObjects.ObjectParameters;
import coreObjects.Invertebrates.InvertebratesObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class InvertebratesPropertiesView
{
	// Gets the coral object
	private static InvertebratesObject invertebrate;

	// The color of the textFields
	private static Color white = Color.WHITE;

	private static Dimension textFieldSize = new Dimension(5, 20);



	/**
	 * TODO - Description
	 */
	public static JPanel getInvertebratesProperties(
			WidgetInvertebrates WidInvertebrate)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		// d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridx = 0;


		// Gets the coral object where the information is
		invertebrate = WidInvertebrate.getObject();


		// Latin Name ---------------------------------------
		JLabel latinNameLabel = new JLabel(AquaWorld.texts
				.getString("invertebrateLatinNameLabelText"),
				SwingConstants.TRAILING);
		latinNameLabel.setToolTipText(AquaWorld.texts
				.getString("invertebrateLatinNameLabelDescrtiption"));
		d.gridy = 0;
		panel.add(latinNameLabel, d);


		JTextField latinNameField = new JTextField(invertebrate
				.getSpeciesName());
		latinNameField.setToolTipText(AquaWorld.texts
				.getString("invertebrateLatinNameLabelDescrtiption"));
		latinNameField.setMaximumSize(textFieldSize);
		latinNameField.setPreferredSize(textFieldSize);
		latinNameField.setEditable(false);
		latinNameField.setBackground(white);
		latinNameLabel.setLabelFor(latinNameField);
		latinNameField.setName("Latin_Name_invertebrate");
		d.gridy = 1;
		panel.add(latinNameField, d);


		// Name ---------------------------------------
		JLabel nameLabel = new JLabel(AquaWorld.texts
				.getString("invertebrateNameLabelText"),
				SwingConstants.TRAILING);
		nameLabel.setToolTipText(AquaWorld.texts
				.getString("invertebrateNameLabelDescription"));
		d.gridy = 2;
		panel.add(nameLabel, d);


		JTextField nameField = new JTextField(invertebrate.getPopulareName());
		nameField.setToolTipText(AquaWorld.texts
				.getString("invertebrateNameLabelDescription"));
		nameField.setMaximumSize(textFieldSize);
		nameField.setPreferredSize(textFieldSize);
		nameField.setEditable(false);
		nameField.setBackground(white);
		nameLabel.setLabelFor(nameField);
		nameField.setName("Name_invertebrate");
		d.gridy = 3;
		panel.add(nameField, d);


		// Type ---------------------------------------
		JLabel typeLabel = new JLabel(AquaWorld.texts
				.getString("invertebrateTypeLabelText"),
				SwingConstants.TRAILING);
		typeLabel.setToolTipText(AquaWorld.texts
				.getString("invertebrateTypeLabelDescription"));
		d.gridy = 4;
		panel.add(typeLabel, d);


		JTextField typeField = new JTextField(invertebrate
				.getInvertebrateType().toString());
		typeField.setToolTipText(AquaWorld.texts
				.getString("invertebrateTypeLabelDescription"));
		typeField.setMaximumSize(textFieldSize);
		typeField.setPreferredSize(textFieldSize);
		typeField.setEditable(false);
		typeField.setBackground(white);
		typeLabel.setLabelFor(typeField);
		typeField.setName("Type_invertebrate");
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridy = 5;
		panel.add(typeField, d);




		return panel;
	}


	/**
	 * Add additional info to the given JPanel about the given Widget object.
	 */
	public static JXCollapsiblePane additionalInfo(
			WidgetInvertebrates invertebrateWidget)
	{
		JXCollapsiblePane panel = new JXCollapsiblePane();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridx = 0;


		// The invertebrate parameters
		ObjectParameters par = invertebrateWidget.getObject().getParameters();


		// Salinity ---------------------------------------
		JLabel salinityLabel = new JLabel(
				AquaWorld.texts.getString("salinity"), SwingConstants.TRAILING);
		salinityLabel.setToolTipText(AquaWorld.texts
				.getString("salinityFieldDescription"));
		d.gridy = 0;
		panel.add(salinityLabel, d);


		String salinityString = par.getSalinityLow() + " - "
				+ par.getSalinityHigh();

		JTextField salinityField = new JTextField(salinityString);
		salinityField.setToolTipText(AquaWorld.texts
				.getString("salinityFieldDescription"));
		salinityField.setMaximumSize(textFieldSize);
		salinityField.setPreferredSize(textFieldSize);
		salinityField.setEditable(false);
		salinityField.setBackground(white);
		salinityLabel.setLabelFor(salinityField);
		salinityField.setName("Salinity_invertebrate");
		d.gridy = 1;
		panel.add(salinityField, d);


		// PH Size ---------------------------------------
		JLabel phLabel = new JLabel(AquaWorld.texts.getString("ph"),
				SwingConstants.TRAILING);
		phLabel.setToolTipText(AquaWorld.texts.getString("phFieldDescription"));
		d.gridy = 2;
		panel.add(phLabel, d);

		String phString = par.getPHlow() + " - " + par.getPHhigh();

		JTextField phField = new JTextField(phString);
		phField.setToolTipText(AquaWorld.texts.getString("phFieldDescription"));
		phField.setMaximumSize(textFieldSize);
		phField.setPreferredSize(textFieldSize);
		phField.setEditable(false);
		phField.setBackground(white);
		phLabel.setLabelFor(phField);
		phField.setName("PH_invertebrate");
		d.gridy = 3;
		panel.add(phField, d);


		// GH Size ---------------------------------------
		JLabel ghLabel = new JLabel(AquaWorld.texts.getString("gh"),
				SwingConstants.TRAILING);
		ghLabel.setToolTipText(AquaWorld.texts.getString("ghFieldDescription"));
		d.gridy = 4;
		panel.add(ghLabel, d);

		String ghString = par.getGHlow() + " - " + par.getGHhigh();

		JTextField ghField = new JTextField(ghString);
		ghField.setToolTipText(AquaWorld.texts.getString("ghFieldDescription"));
		ghField.setMaximumSize(textFieldSize);
		ghField.setPreferredSize(textFieldSize);
		ghField.setEditable(false);
		ghField.setBackground(white);
		ghLabel.setLabelFor(ghField);
		ghField.setName("GH_invertebrate");
		d.gridy = 5;
		panel.add(ghField, d);


		// Temperatur Size ---------------------------------------
		JLabel tempLabel = new JLabel(AquaWorld.texts.getString("temperatur"),
				SwingConstants.TRAILING);
		tempLabel.setToolTipText(AquaWorld.texts
				.getString("temperaturFieldDescription"));
		d.gridy = 6;
		panel.add(tempLabel, d);

		String tempString = par.getTemperatureLow() + " - "
				+ par.getTemperatureHigh();

		JTextField tempField = new JTextField(tempString);
		tempField.setToolTipText(AquaWorld.texts
				.getString("temperaturFieldDescription"));
		tempField.setMaximumSize(textFieldSize);
		tempField.setPreferredSize(textFieldSize);
		tempField.setEditable(false);
		tempField.setBackground(white);
		tempLabel.setLabelFor(tempField);
		tempField.setName("Temperatur_invertebrate");
		d.gridy = 7;
		panel.add(tempField, d);


		// KH Size ---------------------------------------
		JLabel khLabel = new JLabel(AquaWorld.texts.getString("kh"),
				SwingConstants.TRAILING);
		khLabel.setToolTipText(AquaWorld.texts.getString("khFieldDescription"));
		d.gridy = 8;
		panel.add(khLabel, d);

		String khString = "";

		if ( par.getKhLow() > 0 )
		{
			khString = par.getKhLow() + " - " + par.getKhHigh();
		}

		JTextField sizeField = new JTextField(khString);
		sizeField.setToolTipText(AquaWorld.texts
				.getString("khFieldDescription"));
		sizeField.setMaximumSize(textFieldSize);
		sizeField.setPreferredSize(textFieldSize);
		sizeField.setEditable(false);
		sizeField.setBackground(white);
		khLabel.setLabelFor(sizeField);
		sizeField.setName("KH_invertebrate");
		d.gridy = 9;
		panel.add(sizeField, d);


		// Magnesium Size ---------------------------------------
		JLabel magnesiumLabel = new JLabel(AquaWorld.texts
				.getString("magnesium"), SwingConstants.TRAILING);
		magnesiumLabel.setToolTipText(AquaWorld.texts
				.getString("magnesiumFieldDescription"));
		d.gridy = 10;
		panel.add(magnesiumLabel, d);

		String magnesiumString = "";

		if ( par.getMagnesiumLow() > 0 )
		{
			magnesiumString = par.getMagnesiumLow() + " - "
					+ par.getMagnesiumHigh();
		}

		JTextField magnesiumField = new JTextField(magnesiumString);
		magnesiumField.setToolTipText(AquaWorld.texts
				.getString("magnesiumFieldDescription"));
		magnesiumField.setMaximumSize(textFieldSize);
		magnesiumField.setPreferredSize(textFieldSize);
		magnesiumField.setEditable(false);
		magnesiumField.setBackground(white);
		magnesiumLabel.setLabelFor(magnesiumField);
		magnesiumField.setName("Magnesium_invertebrate");
		d.gridy = 11;
		panel.add(magnesiumField, d);


		// Calsium Size ---------------------------------------
		JLabel calciumLabel = new JLabel(AquaWorld.texts.getString("calcium"),
				SwingConstants.TRAILING);
		calciumLabel.setToolTipText(AquaWorld.texts
				.getString("calciumFieldDescription"));
		d.gridy = 12;
		panel.add(calciumLabel, d);

		String calciumString = "";

		if ( par.getCalsiumLow() > 0 )
		{
			calciumString = par.getCalsiumLow() + " - " + par.getCalsiumHigh();
		}

		JTextField calciumField = new JTextField(calciumString);
		calciumField.setToolTipText(AquaWorld.texts
				.getString("calciumFieldDescription"));
		calciumField.setMaximumSize(textFieldSize);
		calciumField.setPreferredSize(textFieldSize);
		calciumField.setEditable(false);
		calciumField.setBackground(white);
		calciumLabel.setLabelFor(calciumField);
		calciumField.setName("Calcium_invertebrate");
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridy = 13;
		panel.add(calciumField, d);



		return panel;
	}
}
