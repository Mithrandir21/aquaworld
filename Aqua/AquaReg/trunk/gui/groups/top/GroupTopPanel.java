package gui.groups.top;


import gui.GraficalFunctions;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class GroupTopPanel extends JPanel
{
	/**
	 * TODO - Description NEEDED!
	 */
	public GroupTopPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 0.25; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		String[] data = {
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"bbb", "ccc", "ddd", "aaa", "bbb", "ccc",
				"ddd", "aaa", "bbb", "ccc", "ddd" };

		JList list = new JList(data);
		JScrollPane scroll = new JScrollPane(list);
		Dimension dim = new Dimension(1, 100);
		scroll.setMaximumSize(dim);
		scroll.setPreferredSize(dim);
		this.add(scroll, d);

		
		
		// d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 0.75; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 1;




		this.add(getGroupInfo(), d);
	}



	private JPanel getGroupInfo()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		// panel.setBorder(BorderFactory.createEtchedBorder());


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.15; // request any extra vertical space
		// d.weightx = 1.0; // request any extra horizontal space
		d.anchor = GridBagConstraints.WEST; // comp location
		d.insets = new Insets(5, 5, 5, 5); // padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row



		JLabel groupNameLabel = new JLabel("Group Name");
		panel.add(groupNameLabel, d);


		JTextField groupName = new JTextField();
		d.anchor = GridBagConstraints.NORTH; // comp location
		d.gridy = 1;
		panel.add(groupName, d);


		JLabel groupSizeLabel = new JLabel("Group Size");
		d.gridy = 2;
		panel.add(groupSizeLabel, d);


		JLabel groupSize = new JLabel("45");
		groupSize.setBorder(BorderFactory.createEtchedBorder());
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridy = 3;
		panel.add(groupSize, d);


		JLabel groupDescriptionLabel = new JLabel("Description");
		d.fill = GridBagConstraints.BOTH;
		d.gridx = 1;
		d.gridy = 0;
		panel.add(groupDescriptionLabel, d);



		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra horizontal space
		d.gridheight = 3;
		d.gridy = 1;
		panel.add(
				GraficalFunctions.getDescriptionPanel(new Dimension(100, 40)),
				d);


		return panel;
	}





}
