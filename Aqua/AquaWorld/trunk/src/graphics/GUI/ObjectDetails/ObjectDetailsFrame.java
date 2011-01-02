package graphics.GUI.ObjectDetails;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import coreObjects.ObjectParameters;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;
import coreObjects.Fish.FishObject.FishAgeType;
import coreObjects.Fish.FishObject.FishGender;


public class ObjectDetailsFrame extends JFrame
{
	public ObjectDetailsFrame()
	{
		super("AquaReg");

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// Get the default toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Get the current screen size
		Dimension scrnsize = toolkit.getScreenSize();

		// Set size for the settings JFrame
		Dimension size = new Dimension(650, 525);

		int initYLocation = (scrnsize.height - size.height) / 3;
		int initXLocation = (scrnsize.width - size.width) / 3;

		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.weighty = 0.25; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0;
		d.gridx = 0;





		// CREATING THE OBJECTS
		// ---------------------------------------------------

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
				FishGender.UNISEX, 7.5, parameter, fishEx, FishAgeType.YOUNG);
		fish.setGenusName("Carassius");
		//
		// // ---------------------------------------------------
		//
		// CoralObject coral = new CoralObject(00002, "CoralNavn", "Coralius",
		// "...Coral", CoralTypes.LargePolipedCoral, parameter);
		// coral.setGenusName("Acropora");
		//
		//
		// // --------------------------------------------------
		//
		// InvertebratesObject invertebrate = new InvertebratesObject(00003,
		// "Iven", "Ivenius", "...Invertebrate",
		// InvertebratesTypes.Anemones, parameter);
		// invertebrate.setGenusName("InvGenus");
		//
		//
		// AbstractObject[] objects = { fish, coral, invertebrate };


		ObjectGeneralInfo panel1 = new ObjectGeneralInfo(fish);
		panel1.setBorder(BorderFactory.createEtchedBorder());
		this.add(panel1, d);






		d.weighty = 1.0; // request any extra vertical space
		d.gridy = 1; // third row

		// JPanel panel2 = new JPanel();
		// panel2.setBorder(BorderFactory.createEtchedBorder());
		this.add(new ObjectDetailedInfo(fish), d);



		// this.setResizable(false);
		this.setLocation(initXLocation, initYLocation);
		this.setPreferredSize(new Dimension(700, 600));
		this.setMinimumSize(new Dimension(600, 520));
		this.setVisible(true);
		// this.pack();
	}



	public static void main(String arg[])
	{
		new ObjectDetailsFrame();
	}
}
