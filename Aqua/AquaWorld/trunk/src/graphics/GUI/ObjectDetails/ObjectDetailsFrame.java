package graphics.GUI.ObjectDetails;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObjectDetailsFrame extends JFrame
{
	public ObjectDetailsFrame()
	{
		super("AquaReg");


		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 0.25; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;



		ObjectGeneralInfo panel1 = new ObjectGeneralInfo();
		panel1.setBorder(BorderFactory.createEtchedBorder());
		this.add(panel1, d);


		d.weighty = 1.0; // request any extra vertical space
		d.gridy = 1; // third row

		JPanel panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createEtchedBorder());
		this.add(panel2, d);



		this.setResizable(false);
		this.setPreferredSize(new Dimension(730, 550));
		this.setVisible(true);
		this.pack();
	}



	public static void main(String arg[])
	{
		new ObjectDetailsFrame();
	}
}
