package gui.groups;


import gui.editing.AquaJList;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;
import coreObjects.Coral.CoralObject;
import coreObjects.Coral.CoralObject.CoralTypes;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;
import coreObjects.Fish.FishObject.FishGender;
import coreObjects.Invertebrates.InvertebratesObject;
import coreObjects.Invertebrates.InvertebratesObject.InvertebratesTypes;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ResultsListPanel extends JPanel
{

	/**
	 * TODO - Description NEEDED!
	 */
	public ResultsListPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		this.setBorder(BorderFactory.createEtchedBorder());
		Dimension dim = new Dimension(120, 0);
		this.setMinimumSize(dim);



		JScrollPane scroll = new JScrollPane();
		scroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// String[] data = { "aaa", "bbb", "ccc", "ddd" };




		double[] sal = { 1.0, 1.0 };
		double[] ph = { 5.6, 8.0 };
		double[] gh = { 1.0, 9.0 };
		double[] temp = { 23, 27.5 };
		double[] kh = { 6.0, 10.0 };
		double[] magnesium = { 300, 4500 };
		double[] calcium = { 1300, 1500 };

		// ---------------------------------------------------
		ObjectParameters parameter = new ObjectParameters(sal, ph, gh, temp);
		FishExclusions fishEx = new FishExclusions();

		FishObject fish = new FishObject(00001, "Gullfiskius", "...Gullfish",
				FishGender.UNISEX, 7.5, parameter, fishEx);
		fish.setGenusName("Carassius");

		// ---------------------------------------------------
		parameter.setKh(kh);
		parameter.setMagnesium(magnesium);
		parameter.setCalcium(calcium);

		CoralObject coral = new CoralObject(00002, "CoralNavn", "Coralius",
				"...Coral", CoralTypes.LargePolipedCoral, parameter);
		coral.setGenusName("Acropora");


		// --------------------------------------------------

		InvertebratesObject invertebrate = new InvertebratesObject(00003,
				"Iven", "Ivenius", "...Invertebrate",
				InvertebratesTypes.Anemones, parameter);
		invertebrate.setGenusName("InvGenus");


		AbstractObject[] data = { fish, coral, invertebrate };





		JPanel listPanel = new JPanel();
		AquaJList list = new AquaJList(data);
		// list.setCellRenderer(new CustomAquaObjectListRenderer());
		listPanel.setLayout(new GridLayout());

		listPanel.add(list);


		scroll.setViewportView(listPanel);




		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		this.add(scroll, d);
	}
}
