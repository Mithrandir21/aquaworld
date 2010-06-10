package graphics.GUI.propertiesArea.objectTypes;


import graphics.AquaWorld;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import widgetTank.Tank;
import coreObjects.Aquarium.Aquarium;

/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
public class TankPropertiesView
{
	/**
	 * TODO - Description
	 */
	public static void getTankProperties(JPanel panel, Tank tank)
	{
		// The tanks aquarium
		Aquarium aqua = tank.getAquariet();


		// The key adapter that calls the save function.
		PropertiesAdapter keyAdapter = new PropertiesAdapter();


		Dimension textFieldSize = new Dimension(5, 20);

		// Name ---------------------------------------
		JLabel nameLabel = new JLabel(AquaWorld.texts
				.getString("tankNameLabelText"), SwingConstants.TRAILING);
		nameLabel.setToolTipText(AquaWorld.texts
				.getString("tankNameLabelDescription"));
		panel.add(nameLabel);


		JTextField nameField = new JTextField(tank.getTankName());
		nameField.setToolTipText(AquaWorld.texts
				.getString("tankNameLabelDescription"));
		nameField.setMaximumSize(textFieldSize);
		nameField.setPreferredSize(textFieldSize);
		nameField.addKeyListener(keyAdapter);
		nameLabel.setLabelFor(nameField);
		nameField.setName("Name_tank");
		panel.add(nameField);



		// Salinity ---------------------------------------
		JLabel salinityLabel = new JLabel(
				AquaWorld.texts.getString("salinity"), SwingConstants.TRAILING);
		salinityLabel.setToolTipText(AquaWorld.texts
				.getString("tankSalinityLabelDescription"));
		panel.add(salinityLabel);


		JTextField salinityField = new JTextField(aqua.getSalinity() + "",
				SwingConstants.RIGHT);
		salinityField.setToolTipText(AquaWorld.texts
				.getString("tankSalinityLabelDescription"));
		salinityField.setMaximumSize(textFieldSize);
		salinityField.setPreferredSize(textFieldSize);
		salinityField.addKeyListener(keyAdapter);
		salinityLabel.setLabelFor(salinityField);
		salinityField.setName("Salinity_tank");
		panel.add(salinityField);



		// PH ---------------------------------------
		JLabel phLabel = new JLabel(AquaWorld.texts.getString("ph"),
				SwingConstants.TRAILING);
		phLabel.setToolTipText(AquaWorld.texts
				.getString("tankPHLabelDescription"));
		panel.add(phLabel);


		JTextField phField = new JTextField(aqua.getPH() + "",
				SwingConstants.EAST);
		phField.setToolTipText(AquaWorld.texts
				.getString("tankPHLabelDescription"));
		phField.setMaximumSize(textFieldSize);
		phField.setPreferredSize(textFieldSize);
		phField.addKeyListener(keyAdapter);
		phLabel.setLabelFor(phField);
		phField.setName("PH_tank");
		panel.add(phField);



		// GH ---------------------------------------
		JLabel ghLabel = new JLabel(AquaWorld.texts.getString("gh"),
				SwingConstants.TRAILING);
		ghLabel.setToolTipText(AquaWorld.texts
				.getString("tankGHLabelDescription"));
		panel.add(ghLabel);


		JTextField ghField = new JTextField(aqua.getGH() + "",
				SwingConstants.EAST);
		ghField.setToolTipText(AquaWorld.texts
				.getString("tankGHLabelDescription"));
		ghField.setMaximumSize(textFieldSize);
		ghField.setPreferredSize(textFieldSize);
		ghField.addKeyListener(keyAdapter);
		ghLabel.setLabelFor(ghField);
		ghField.setName("GH_tank");
		panel.add(ghField);



		// Temperatur ---------------------------------------
		JLabel temperaturLabel = new JLabel(AquaWorld.texts
				.getString("temperatur"), SwingConstants.TRAILING);
		temperaturLabel.setToolTipText(AquaWorld.texts
				.getString("tankTemperaturLabelDescription"));
		panel.add(temperaturLabel);


		JTextField temperaturField = new JTextField(aqua.getTemperature() + "",
				SwingConstants.EAST);
		temperaturField.setToolTipText(AquaWorld.texts
				.getString("tankTemperaturLabelDescription"));
		temperaturField.setMaximumSize(textFieldSize);
		temperaturField.setPreferredSize(textFieldSize);
		temperaturField.addKeyListener(keyAdapter);
		temperaturLabel.setLabelFor(temperaturLabel);
		temperaturField.setName("Temperatur_tank");
		panel.add(temperaturField);



		// KH ---------------------------------------
		JLabel khLabel = new JLabel(AquaWorld.texts.getString("kh"),
				SwingConstants.TRAILING);
		khLabel.setToolTipText(AquaWorld.texts
				.getString("tankKHLabelDescription"));
		panel.add(khLabel);


		JTextField khField = new JTextField(aqua.getKh() + "",
				SwingConstants.EAST);
		khField.setToolTipText(AquaWorld.texts
				.getString("tankKHLabelDescription"));
		khField.setMaximumSize(textFieldSize);
		khField.setPreferredSize(textFieldSize);
		khField.addKeyListener(keyAdapter);
		khLabel.setLabelFor(khField);
		khField.setName("KH_tank");
		panel.add(khField);



	}
}
