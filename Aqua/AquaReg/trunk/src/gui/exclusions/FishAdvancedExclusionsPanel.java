package gui.exclusions;


import graphics.RoundedBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.Border;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FishAdvancedExclusionsPanel extends JPanel
{

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param lis
	 */
	public FishAdvancedExclusionsPanel(ActionListener lis)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		this.setBackground(Color.WHITE);


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row


		JScrollPane scroll = new JScrollPane(getAllGroupsPanel(lis));
		// Increases how far the scroll bar scrolls on one step of a mouse wheel
		scroll.getVerticalScrollBar().setUnitIncrement(20);

		this.add(scroll, d);
	}




	private JPanel getAllGroupsPanel(ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		// panel.setBorder(BorderFactory.createEtchedBorder());
		panel.setBackground(Color.WHITE);


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.2; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(5, 5, 5, 5); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row

		int panels = 4;

		for ( int i = 0; i < panels; i++ )
		{
			panel.add(getGroupPanel(lis), d);
			d.gridy++;

			panel.add(new JSeparator(), d);
			d.gridy++;
		}

		return panel;
	}


	private JPanel getGroupPanel(ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		// panel.setBorder(BorderFactory.createEtchedBorder());
		panel.setOpaque(false);


		d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.2; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(5, 5, 5, 5); // top padding
		d.gridwidth = 3; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row



		JCheckBox groupBox = new JCheckBox("Johans Group");
		groupBox.setBackground(Color.WHITE);
		groupBox.addActionListener(lis);
		panel.add(groupBox, d);



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 0.2; // request any extra vertical space
		d.weightx = 0.3; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(15, 15, 15, 15); // top padding
		d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 1;
		d.gridx = -1; // third row


		int panels = 33;
		// Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED,
		// Color.WHITE, Color.BLACK);
		Border border = new RoundedBorder(10, 2.0f, new Color(0, 191, 255));



		for ( int i = 0; i < panels; i++ )
		{
			if ( i > 3 && i % 5 == 0 )
			{
				d.gridx = 0;
				d.gridy++;
			}
			else
			{
				d.gridx++;
			}


			if ( i % 6 == 0 )
			{
				border = new RoundedBorder(10, 7.0f, new Color(30, 144, 255));
			}
			else
			{
				border = new RoundedBorder(10, 2.0f, new Color(0, 191, 255));
			}


			panel.add(getObjectPanel(border, lis), d);
		}


		return panel;
	}





	private JPanel getObjectPanel(Border border, ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		panel.setBorder(border);
		Dimension dim = new Dimension(150, 140);
		panel.setSize(dim);
		panel.setMinimumSize(dim);
		panel.setMaximumSize(dim);
		panel.setPreferredSize(dim);
		panel.setOpaque(false);


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



		JCheckBox selectObjectCheck = new JCheckBox("Select Fish");
		selectObjectCheck.addActionListener(lis);
		panel.add(selectObjectCheck, d);



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

		panel.add(Genuslabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		panel.add(Genus, d);


		JLabel PHlabel = new JLabel("PH: ");
		JLabel PH = new JLabel("5.7 - 8.9");


		d.insets = new Insets(0, 6, 0, 0); // top padding
		d.gridy = 2;
		d.gridx = 0;
		panel.add(PHlabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		panel.add(PH, d);



		JLabel GHlabel = new JLabel("GH: ");
		JLabel GH = new JLabel("6.5 - 7.3");


		d.insets = new Insets(0, 6, 0, 0); // top padding
		d.gridy = 3;
		d.gridx = 0;
		panel.add(GHlabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		panel.add(GH, d);



		JLabel Templabel = new JLabel("Temp: ");
		JLabel Temp = new JLabel("25 - 27");




		d.insets = new Insets(0, 6, 0, 0); // top padding
		d.gridy = 4;
		d.gridx = 0;
		panel.add(Templabel, d);

		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridx = 1;
		panel.add(Temp, d);




		JPanel p = new JPanel();
		// p.setBorder(BorderFactory.createEtchedBorder());

		d.fill = GridBagConstraints.BOTH;
		d.insets = new Insets(6, 6, 6, 6); // top padding
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridwidth = 2; // 2 columns wide
		d.gridy = 5;
		d.gridx = 0;
		panel.add(p, d);



		return panel;
	}
}
