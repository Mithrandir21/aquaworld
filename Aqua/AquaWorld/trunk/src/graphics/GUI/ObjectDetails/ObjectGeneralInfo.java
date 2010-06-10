package graphics.GUI.ObjectDetails;


import graphics.GUI.graphicalFunctions.GraphicalFunctions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ObjectGeneralInfo extends JPanel
{
	public ObjectGeneralInfo()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.weighty = 0.3; // request any extra vertical space
		d.weightx = 0.3; // request any extra vertical space
		d.anchor = GridBagConstraints.CENTER; // space
		d.insets = new Insets(10, 10, 10, 10); // padding
		// d.gridwidth = 1;
		d.gridy = 0;
		d.gridx = 0;



		JPanel emptyPanel = new JPanel();
		emptyPanel.setBorder(BorderFactory.createEtchedBorder());
		this.add(emptyPanel, d);



		d.fill = GridBagConstraints.BOTH;
		d.insets = new Insets(0, 0, 0, 0); // padding
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridx = 1;

		JPanel infoPanel = getGeneralInfo();
		infoPanel.setBorder(BorderFactory.createEtchedBorder());
		this.add(infoPanel, d);

	}



	/**
	 * TODO - Description
	 */
	private JPanel getGeneralInfo()
	{
		JPanel info = new JPanel();
		
		info.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.NONE;
		// d.ipady = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		// d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // space
		// d.insets = new Insets(10, 10, 10, 10); // padding
		// d.gridwidth = 1;
		d.gridy = 0;
		d.gridx = 0;


		info.add(GraphicalFunctions.getUniquePanel("Genus", "Fish Genus"), d);


		d.gridx = 1;
		info.add(GraphicalFunctions.getUniquePanel("Arts Navn", "Fish Art"), d);



		d.gridx = 2;
		info.add(GraphicalFunctions.getUniquePanel("Common", "Fish Common"), d);



		return info;
	}




}
