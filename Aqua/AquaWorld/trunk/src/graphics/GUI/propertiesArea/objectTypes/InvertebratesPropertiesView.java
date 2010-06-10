package graphics.GUI.propertiesArea.objectTypes;


import graphics.AquaWorld;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	public static void getInvertebratesProperties(JPanel panel,
			WidgetInvertebrates WidInvertebrate, boolean additionalInfo)
	{
		// Gets the coral object where the information is
		invertebrate = WidInvertebrate.getObject();


		// Latin Name ---------------------------------------
		JLabel latinNameLabel = new JLabel(AquaWorld.texts
				.getString("invertebrateLatinNameLabelText"),
				SwingConstants.TRAILING);
		latinNameLabel.setToolTipText(AquaWorld.texts
				.getString("invertebrateLatinNameLabelDescrtiption"));
		panel.add(latinNameLabel);


		JTextField latinNameField = new JTextField(invertebrate.getSpeciesName());
		latinNameField.setToolTipText(AquaWorld.texts
				.getString("invertebrateLatinNameLabelDescrtiption"));
		latinNameField.setMaximumSize(textFieldSize);
		latinNameField.setPreferredSize(textFieldSize);
		latinNameField.setEditable(false);
		latinNameField.setBackground(white);
		latinNameLabel.setLabelFor(latinNameField);
		latinNameField.setName("Latin_Name_invertebrate");
		panel.add(latinNameField);


		// Name ---------------------------------------
		JLabel nameLabel = new JLabel(AquaWorld.texts
				.getString("invertebrateNameLabelText"),
				SwingConstants.TRAILING);
		nameLabel.setToolTipText(AquaWorld.texts
				.getString("invertebrateNameLabelDescription"));
		panel.add(nameLabel);


		JTextField nameField = new JTextField(invertebrate.getPopulareName());
		nameField.setToolTipText(AquaWorld.texts
				.getString("invertebrateNameLabelDescription"));
		nameField.setMaximumSize(textFieldSize);
		nameField.setPreferredSize(textFieldSize);
		nameField.setEditable(false);
		nameField.setBackground(white);
		nameLabel.setLabelFor(nameField);
		nameField.setName("Name_invertebrate");
		panel.add(nameField);


		// Type ---------------------------------------
		JLabel typeLabel = new JLabel(AquaWorld.texts
				.getString("invertebrateTypeLabelText"),
				SwingConstants.TRAILING);
		typeLabel.setToolTipText(AquaWorld.texts
				.getString("invertebrateTypeLabelDescription"));
		panel.add(typeLabel);


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
		panel.add(typeField);



		if ( additionalInfo )
		{
			additionalInfo(panel, WidInvertebrate);
		}
	}


	/**
	 * Add additional info to the given JPanel about the given Widget object.
	 */
	private static void additionalInfo(JPanel moreInfo,
			WidgetInvertebrates invertebrateWidget)
	{
		// The invertebrate parameters
		ObjectParameters par = invertebrateWidget.getObject()
				.getParameters();


		// Salinity ---------------------------------------
		JLabel salinityLabel = new JLabel(
				AquaWorld.texts.getString("salinity"), SwingConstants.TRAILING);
		salinityLabel.setToolTipText(AquaWorld.texts
				.getString("salinityFieldDescription"));
		moreInfo.add(salinityLabel);


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
		moreInfo.add(salinityField);


		// PH Size ---------------------------------------
		JLabel phLabel = new JLabel(AquaWorld.texts.getString("ph"),
				SwingConstants.TRAILING);
		phLabel.setToolTipText(AquaWorld.texts.getString("phFieldDescription"));
		moreInfo.add(phLabel);

		String phString = par.getPHlow() + " - " + par.getPHhigh();

		JTextField phField = new JTextField(phString);
		phField.setToolTipText(AquaWorld.texts.getString("phFieldDescription"));
		phField.setMaximumSize(textFieldSize);
		phField.setPreferredSize(textFieldSize);
		phField.setEditable(false);
		phField.setBackground(white);
		phLabel.setLabelFor(phField);
		phField.setName("PH_invertebrate");
		moreInfo.add(phField);


		// GH Size ---------------------------------------
		JLabel ghLabel = new JLabel(AquaWorld.texts.getString("gh"),
				SwingConstants.TRAILING);
		ghLabel.setToolTipText(AquaWorld.texts.getString("ghFieldDescription"));
		moreInfo.add(ghLabel);

		String ghString = par.getGHlow() + " - " + par.getGHhigh();

		JTextField ghField = new JTextField(ghString);
		ghField.setToolTipText(AquaWorld.texts.getString("ghFieldDescription"));
		ghField.setMaximumSize(textFieldSize);
		ghField.setPreferredSize(textFieldSize);
		ghField.setEditable(false);
		ghField.setBackground(white);
		ghLabel.setLabelFor(ghField);
		ghField.setName("GH_invertebrate");
		moreInfo.add(ghField);


		// Temperatur Size ---------------------------------------
		JLabel tempLabel = new JLabel(AquaWorld.texts.getString("temperatur"),
				SwingConstants.TRAILING);
		tempLabel.setToolTipText(AquaWorld.texts
				.getString("temperaturFieldDescription"));
		moreInfo.add(tempLabel);

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
		moreInfo.add(tempField);


		// KH Size ---------------------------------------
		JLabel khLabel = new JLabel(AquaWorld.texts.getString("kh"),
				SwingConstants.TRAILING);
		khLabel.setToolTipText(AquaWorld.texts.getString("khFieldDescription"));
		moreInfo.add(khLabel);

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
		moreInfo.add(sizeField);


		// Magnesium Size ---------------------------------------
		JLabel magnesiumLabel = new JLabel(AquaWorld.texts
				.getString("magnesium"), SwingConstants.TRAILING);
		magnesiumLabel.setToolTipText(AquaWorld.texts
				.getString("magnesiumFieldDescription"));
		moreInfo.add(magnesiumLabel);

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
		moreInfo.add(magnesiumField);


		// Calsium Size ---------------------------------------
		JLabel calciumLabel = new JLabel(AquaWorld.texts.getString("calcium"),
				SwingConstants.TRAILING);
		calciumLabel.setToolTipText(AquaWorld.texts
				.getString("calciumFieldDescription"));
		moreInfo.add(calciumLabel);

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
		moreInfo.add(calciumField);
	}
}
