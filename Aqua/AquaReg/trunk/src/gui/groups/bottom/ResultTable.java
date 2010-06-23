package gui.groups.bottom;


import graphicalObjects.AquaObjectsTable;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;
import coreObjects.Coral.CoralObject;
import coreObjects.Coral.CoralObject.CoralTypes;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;
import coreObjects.Fish.FishObject.FishGender;
import coreObjects.Invertebrates.InvertebrateExclusions;
import coreObjects.Invertebrates.InvertebratesObject;
import coreObjects.Invertebrates.InvertebratesObject.InvertebratesTypes;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ResultTable extends JPanel
{
	public ResultTable()
	{
		this.setLayout(new GridLayout());
		this.setBorder(BorderFactory.createEtchedBorder());


		JTabbedPane results = new JTabbedPane();


		/**
		 * sample table data
		 */
		Object[][] data = {
				{ "Mary", "Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione" },
				{ "Alison", "Huml", "Rowing", 3, Boolean.FALSE, "Huml",
						"Rowing", 3, Boolean.FALSE, "Huml" },
				{ "Kathy", "Walrath", "Knitting", 2, Boolean.FALSE, "Walrath",
						"Knitting", 2, Boolean.FALSE, "Walrath" },
				{ "Sharon", "Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour" },
				{ "Philip", "Milne", "Pool", 10, Boolean.FALSE, "Milne",
						"Pool", 10, Boolean.FALSE, "Milne" },
				{ "Mary", "Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione" },
				{ "Alison", "Huml", "Rowing", 3, Boolean.FALSE, "Huml",
						"Rowing", 3, Boolean.FALSE, "Huml" },
				{ "Kathy", "Walrath", "Knitting", 2, Boolean.FALSE, "Walrath",
						"Knitting", 2, Boolean.FALSE, "Walrath" },
				{ "Sharon", "Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour" },
				{ "Philip", "Milne", "Pool", 10, Boolean.FALSE, "Milne",
						"Pool", 10, Boolean.FALSE, "Milne" },
				{ "Mary", "Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione" },
				{ "Alison", "Huml", "Rowing", 3, Boolean.FALSE, "Huml",
						"Rowing", 3, Boolean.FALSE, "Huml" },
				{ "Kathy", "Walrath", "Knitting", 2, Boolean.FALSE, "Walrath",
						"Knitting", 2, Boolean.FALSE, "Walrath" },
				{ "Sharon", "Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour" },
				{ "Philip", "Milne", "Pool", 10, Boolean.FALSE, "Milne",
						"Pool", 10, Boolean.FALSE, "Milne" },
				{ "Mary", "Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione" },
				{ "Alison", "Huml", "Rowing", 3, Boolean.FALSE, "Huml",
						"Rowing", 3, Boolean.FALSE, "Huml" },
				{ "Kathy", "Walrath", "Knitting", 2, Boolean.FALSE, "Walrath",
						"Knitting", 2, Boolean.FALSE, "Walrath" },
				{ "Sharon", "Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour" },
				{ "Philip", "Milne", "Pool", 10, Boolean.FALSE, "Milne",
						"Pool", 10, Boolean.FALSE, "Milne" },
				{ "Mary", "Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione" },
				{ "Alison", "Huml", "Rowing", 3, Boolean.FALSE, "Huml",
						"Rowing", 3, Boolean.FALSE, "Huml" },
				{ "Kathy", "Walrath", "Knitting", 2, Boolean.FALSE, "Walrath",
						"Knitting", 2, Boolean.FALSE, "Walrath" },
				{ "Sharon", "Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour" },
				{ "Philip", "Milne", "Pool", 10, Boolean.FALSE, "Milne",
						"Pool", 10, Boolean.FALSE, "Milne" },
				{ "Mary", "Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione" },
				{ "Alison", "Huml", "Rowing", 3, Boolean.FALSE, "Huml",
						"Rowing", 3, Boolean.FALSE, "Huml" },
				{ "Kathy", "Walrath", "Knitting", 2, Boolean.FALSE, "Walrath",
						"Knitting", 2, Boolean.FALSE, "Walrath" },
				{ "Sharon", "Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour" },
				{ "Philip", "Milne", "Pool", 10, Boolean.FALSE, "Milne",
						"Pool", 10, Boolean.FALSE, "Milne" },
				{ "Mary", "Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione", "Snowboarding", 5, Boolean.FALSE,
						"Campione" },
				{ "Alison", "Huml", "Rowing", 3, Boolean.FALSE, "Huml",
						"Rowing", 3, Boolean.FALSE, "Huml" },
				{ "Kathy", "Walrath", "Knitting", 2, Boolean.FALSE, "Walrath",
						"Knitting", 2, Boolean.FALSE, "Walrath" },
				{ "Sharon", "Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour", "Speed reading", 20, Boolean.FALSE,
						"Zakhour" },
				{ "Philip", "Milne", "Pool", 10, Boolean.FALSE, "Milne",
						"Pool", 10, Boolean.FALSE, "Milne" } };



		double[] sal = { 1.0, 1.0 };
		double[] ph = { 5.6, 8.0 };
		double[] gh = { 1.0, 9.0 };
		double[] temp = { 23, 27.5 };
		double[] kh = { 6.0, 10.0 };
		double[] magnesium = { 300, 4500 };
		double[] calcium = { 1300, 1500 };

		// ---------------------------------------------------
		ObjectParameters parameter = new ObjectParameters(00001, sal, ph, gh,
				temp);
		parameter.setKh(kh);
		parameter.setMagnesium(magnesium);
		parameter.setCalcium(calcium);
		FishExclusions fishEx = new FishExclusions(00001);

		FishObject fish = new FishObject(00001, "Gullfiskius", "...Gullfish",
				FishGender.UNISEX, 7.5, parameter, fishEx);
		fish.setGenusName("Carassius");

		// ---------------------------------------------------

		CoralObject coral = new CoralObject(00002, "Coralius", "...Coral",
				CoralTypes.LargePolipedCoral, parameter);
		coral.setGenusName("Acropora");


		InvertebrateExclusions invEx = new InvertebrateExclusions(957);
		// --------------------------------------------------

		InvertebratesObject invertebrate = new InvertebratesObject(00003,
				"Ivenius", "...Invertebrate", InvertebratesTypes.Anemones,
				parameter, invEx);
		invertebrate.setGenusName("InvGenus");


		AbstractObject[] objects = { fish, coral, invertebrate };




		// String[][] data = DataRetrival.getObjectsData(objects);



		// JScrollPane scroll = new JScrollPane(table);

		AquaObjectsTable table = new AquaObjectsTable(data);
		JPanel p = new JPanel(new GridLayout());
		p.add(table);
		results.addTab("Search Results", p);



		results.addTab("Group Objects", new JPanel());


		this.add(results);
	}
}
