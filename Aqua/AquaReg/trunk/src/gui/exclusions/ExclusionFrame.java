package gui.exclusions;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class ExclusionFrame extends JFrame
{
	public ExclusionFrame()
	{
		super("Exclusions");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra horizontal space
		// d.anchor = GridBagConstraints.CENTER; // location
		// d.insets = new Insets(10, 10, 10, 10); // padding
		// d.gridwidth = 1; // 2 row wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // row
		d.gridx = 0; // column



		this.add(new ExclusionPanel(), d);


		// this.setResizable(false);
		this.setPreferredSize(new Dimension(1100, 800));
		this.setMinimumSize(new Dimension(1100, 800));
		this.setVisible(true);
		this.pack();
	}

	public static void main(String[] args)
	{
		new ExclusionFrame();
	}
}
