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

import widgets.WidgetFish;
import coreObjects.ObjectParameters;
import coreObjects.Fish.FishObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FishPropertiesView
{
	// Gets the fish object
	private static FishObject fish;

	// The color of the textFields
	private static Color white = Color.WHITE;

	private static Dimension textFieldSize = new Dimension(5, 20);

	/**
	 * TODO - Description
	 */
	public static JPanel getFishProperties(WidgetFish fishWidget)
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




		// Gets the fish object
		fish = fishWidget.getObject();



		// Latin Name ---------------------------------------
		JLabel latinNameLabel = new JLabel(AquaWorld.texts
				.getString("fishLatinNameLabelText"), SwingConstants.TRAILING);
		latinNameLabel.setToolTipText(AquaWorld.texts
				.getString("fishLatinNameLabelDescrtiption"));
		d.gridy = 0;
		panel.add(latinNameLabel, d);


		JTextField latinNameField = new JTextField(fish.getSpeciesName());
		latinNameField.setToolTipText(AquaWorld.texts
				.getString("fishLatinNameLabelDescrtiption"));
		latinNameField.setMaximumSize(textFieldSize);
		latinNameField.setPreferredSize(textFieldSize);
		latinNameField.setEditable(false);
		latinNameField.setBackground(white);
		latinNameLabel.setLabelFor(latinNameField);
		latinNameField.setName("Latin_Name_fish");
		d.gridy = 1;
		panel.add(latinNameField, d);


		// Name ---------------------------------------
		JLabel nameLabel = new JLabel(AquaWorld.texts
				.getString("fishNameLabelText"), SwingConstants.TRAILING);
		nameLabel.setToolTipText(AquaWorld.texts
				.getString("fishNameLabelDescription"));
		d.gridy = 2;
		panel.add(nameLabel, d);


		JTextField nameField = new JTextField(fish.getPopulareName());
		nameField.setToolTipText(AquaWorld.texts
				.getString("fishNameLabelDescription"));
		nameField.setMaximumSize(textFieldSize);
		nameField.setPreferredSize(textFieldSize);
		nameField.setEditable(false);
		nameField.setBackground(white);
		nameLabel.setLabelFor(nameField);
		nameField.setName("Name_fish");
		d.gridy = 3;
		panel.add(nameField, d);



		// Gender ---------------------------------------
		JLabel genderLabel = new JLabel(AquaWorld.texts
				.getString("fishGenderLabelText"), SwingConstants.TRAILING);
		genderLabel.setToolTipText(AquaWorld.texts
				.getString("fishGenderLabelDescrtiption"));
		d.gridy = 4;
		panel.add(genderLabel, d);


		JTextField genderField = new JTextField(fish.getFishGender().toString());
		genderField.setToolTipText(AquaWorld.texts
				.getString("fishGenderLabelDescrtiption"));
		genderField.setMaximumSize(textFieldSize);
		genderField.setPreferredSize(textFieldSize);
		genderField.setEditable(false);
		genderField.setBackground(white);
		genderLabel.setLabelFor(genderField);
		genderField.setName("Gender_fish");
		d.gridy = 5;
		panel.add(genderField, d);



		// // Fish Group ---------------------------------------
		// JLabel groupLabel = new JLabel(AquaWorld.texts
		// .getString("fishGroupLabelText"), SwingConstants.TRAILING);
		// groupLabel.setToolTipText(AquaWorld.texts
		// .getString("fishGroupLabelDescrtiption"));
		// panel.add(groupLabel);
		//
		//
		// JTextField groupField = new
		// JTextField(fish.getFishGroup().toString());
		// groupField.setToolTipText(AquaWorld.texts
		// .getString("fishGroupLabelDescrtiption"));
		// groupField.setMaximumSize(textFieldSize);
		// groupField.setPreferredSize(textFieldSize);
		// groupField.setEditable(false);
		// groupField.setBackground(white);
		// groupLabel.setLabelFor(groupField);
		// groupField.setName("Group_fish");
		// panel.add(groupField);



		// Fish Size ---------------------------------------
		JLabel sizeLabel = new JLabel(AquaWorld.texts
				.getString("fishSizeLabelText"), SwingConstants.TRAILING);
		sizeLabel.setToolTipText(AquaWorld.texts
				.getString("fishSizeLabelDescrtiption"));
		d.gridy = 6;
		panel.add(sizeLabel, d);


		JTextField sizeField = new JTextField(fish.getSize() + "");
		sizeField.setToolTipText(AquaWorld.texts
				.getString("fishSizeLabelDescrtiption"));
		sizeField.setMaximumSize(textFieldSize);
		sizeField.setPreferredSize(textFieldSize);
		sizeField.setEditable(false);
		sizeField.setBackground(white);
		sizeLabel.setLabelFor(sizeField);
		sizeField.setName("Size_fish");
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridy = 7;
		panel.add(sizeField, d);


		return panel;
	}






	/**
	 * Add additional info to the given JPanel about the given Widget object.
	 */
	public static JXCollapsiblePane additionalInfo(WidgetFish fishWidget)
	{
		JXCollapsiblePane panel = new JXCollapsiblePane();
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


		// The fishes parameters
		ObjectParameters par = fishWidget.getObject().getParameters();


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
		salinityField.setName("Salinity_fish");
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
		phField.setName("PH_fish");
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
		ghField.setName("GH_fish");
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
		tempField.setName("Temperatur_fish");
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
		sizeField.setName("KH_fish");
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridy = 9;
		panel.add(sizeField, d);


		return panel;
	}
}
