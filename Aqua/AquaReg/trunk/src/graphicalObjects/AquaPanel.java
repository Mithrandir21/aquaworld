/**
 * 
 */
package graphicalObjects;


import graphics.RoundedBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
public class AquaPanel extends JPanel
{
	private JCheckBox selectObjectCheck;

	public AquaPanel(MouseListener lis, ActionListener actLis)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		Dimension dim = new Dimension(150, 140);
		this.setSize(dim);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);
		this.setPreferredSize(dim);
		this.setOpaque(false);
		this.addMouseListener(lis);


		d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.1; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTHWEST; // bottom of space
		d.insets = new Insets(3, 3, 3, 3); // top padding
		d.gridwidth = 5; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row



		selectObjectCheck = new JCheckBox("Select Fish");
		selectObjectCheck.addActionListener(actLis);
		this.add(selectObjectCheck, d);



		d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTHWEST; // bottom of space
		d.insets = new Insets(0, 6, 0, 0); // top padding
		d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 1; // third row
		d.gridx = 0; // third row


		JLabel Genuslabel = new JLabel("Genus: ");
		JLabel Genus = new JLabel("Tetraodon");

		this.add(Genuslabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		this.add(Genus, d);


		JLabel PHlabel = new JLabel("PH: ");
		JLabel PH = new JLabel("5.7 - 8.9");


		d.insets = new Insets(0, 6, 0, 0); // top padding
		d.gridy = 2;
		d.gridx = 0;
		this.add(PHlabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		this.add(PH, d);



		JLabel GHlabel = new JLabel("GH: ");
		JLabel GH = new JLabel("6.5 - 7.3");


		d.insets = new Insets(0, 6, 0, 0); // top padding
		d.gridy = 3;
		d.gridx = 0;
		this.add(GHlabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		this.add(GH, d);



		JLabel Templabel = new JLabel("Temp: ");
		JLabel Temp = new JLabel("25 - 27");




		d.insets = new Insets(0, 6, 0, 0); // top padding
		d.gridy = 4;
		d.gridx = 0;
		this.add(Templabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		this.add(Temp, d);




		JPanel p = new JPanel();
		// p.setBorder(BorderFactory.createEtchedBorder());

		d.fill = GridBagConstraints.BOTH;
		d.insets = new Insets(6, 6, 6, 6); // top padding
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridwidth = 2; // 2 columns wide
		d.gridy = 5;
		d.gridx = 0;
		this.add(p, d);
	}



	/**
	 * TODO - Description
	 * 
	 */
	public void toggle()
	{
		boolean selected = !selectObjectCheck.isSelected();


		if ( selected )
		{
			this.setBorder(new RoundedBorder(10, 7.0f, new Color(30, 144, 255)));
		}
		else
		{
			this.setBorder(new RoundedBorder(10, 2.0f, new Color(0, 191, 255)));
		}

		selectObjectCheck.setSelected(selected);
	}



	/**
	 * TODO - Description
	 * 
	 */
	public void toggle(boolean selected)
	{
		if ( selected )
		{
			this.setBorder(new RoundedBorder(10, 7.0f, new Color(30, 144, 255)));
		}
		else
		{
			this.setBorder(new RoundedBorder(10, 2.0f, new Color(0, 191, 255)));
		}

		selectObjectCheck.setSelected(selected);
	}
}
