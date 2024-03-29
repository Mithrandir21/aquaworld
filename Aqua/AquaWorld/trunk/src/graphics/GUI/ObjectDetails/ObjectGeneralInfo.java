package graphics.GUI.ObjectDetails;


import graphics.AquaWorld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import coreObjects.AbstractObject;


public class ObjectGeneralInfo extends JPanel
{
	public ObjectGeneralInfo(AbstractObject obj)
	{
		if ( obj == null )
		{
			return;
		}

		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		Dimension scrollDim = new Dimension(50, 150);
		this.setPreferredSize(scrollDim);
		this.setMinimumSize(scrollDim);


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.weighty = 0.3; // request any extra vertical space
		d.weightx = 0.3; // request any extra vertical space
		d.anchor = GridBagConstraints.CENTER; // space
		d.insets = new Insets(10, 10, 10, 10); // padding
		// d.gridwidth = 1;
		d.gridy = 0;
		d.gridx = 0;


		// // THIS PART CAN BE UNCOMMENTED TO PROVIDE AN IMAGE FIELD
		// JPanel emptyPanel = new JPanel();
		// emptyPanel.setBorder(BorderFactory.createEtchedBorder());
		// this.add(emptyPanel, d);



		d.fill = GridBagConstraints.BOTH;
		d.insets = new Insets(0, 0, 0, 0); // padding
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridx = 1;

		JPanel infoPanel = getGeneralInfo(obj);
		// infoPanel.setBorder(BorderFactory.createEtchedBorder());
		this.add(infoPanel, d);

	}



	/**
	 * TODO - Description
	 */
	private JPanel getGeneralInfo(AbstractObject obj)
	{
		JPanel info = new JPanel();

		info.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 0.4; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // space
		d.insets = new Insets(5, 5, 5, 5); // padding
		// d.gridwidth = 1;
		d.gridy = 0;
		d.gridx = 0;


		info.add(
				getUniquePanel(AquaWorld.texts.getString("genus") + " "
						+ AquaWorld.texts.getString("name"), obj.getGenusName()),
				d);


		d.gridx = 1;
		info.add(
				getUniquePanel(AquaWorld.texts.getString("species") + " "
						+ AquaWorld.texts.getString("name"),
						obj.getSpeciesName()), d);


		d.weightx = 0.6; // request any extra vertical space
		d.gridx = 2;
		info.add(
				getUniquePanel(AquaWorld.texts.getString("pop") + " "
						+ AquaWorld.texts.getString("name"),
						obj.getPopulareName()), d);

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // space
		// d.insets = new Insets(10, 10, 10, 10); // padding
		d.gridwidth = 3;
		d.gridy = 1;
		d.gridx = 0;
		info.add(getDescriptionPanel(obj.getDescription()), d);

		return info;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(String labelName, String value)
	{
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEmptyBorder(), labelName));

		JTextField valueLabel = new JTextField(value);
		valueLabel.setBorder(BorderFactory.createEtchedBorder());
		valueLabel.setEditable(false);
		valueLabel.setBackground(Color.WHITE);

		panel.add(valueLabel);


		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getDescriptionPanel(String descText)
	{
		JScrollPane scroll = new JScrollPane();

		JTextArea description = new JTextArea();
		description.setText(descText);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


		scroll.setViewportView(description);


		JPanel desc = new JPanel(new GridLayout());
		desc.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEmptyBorder(), "Description"));
		desc.add(scroll);


		return desc;
	}


}
