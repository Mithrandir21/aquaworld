package gui.exclusions;


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ExclusionPanel extends JPanel
{
	public ExclusionPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.15; // request any extra vertical space
		// d.weightx = 1.0; // request any extra horizontal space
		d.anchor = GridBagConstraints.WEST; // comp location
		d.insets = new Insets(10, 10, 10, 10); // padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row




		this.add(generalPanel(), d);



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(0, 0, 0, 0); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 1; // third row
		d.gridx = 0; // third row

		this.add(new FishExclusionView(), d);




		d.fill = GridBagConstraints.NONE;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 0; // request any extra vertical space
		d.weightx = 0; // request any extra vertical space
		d.anchor = GridBagConstraints.EAST; // bottom of space
		d.insets = new Insets(5, 5, 5, 5); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 2; // third row
		d.gridx = 0; // third row


		this.add(getButtonPanel(), d);
	}




	private JPanel getButtonPanel()
	{
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.3; // request any extra vertical space
		// d.weightx = 1.0; // request any extra horizontal space
		d.anchor = GridBagConstraints.EAST; // comp location
		// d.insets = new Insets(10, 10, 10, 10); // padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row


		JButton save = new JButton("Save");
		JButton reset = new JButton("Reset");

		panel.add(reset, d);


		d.gridx = 1;
		panel.add(save, d);


		return panel;
	}




	private JPanel generalPanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEtchedBorder());

		panel.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.3; // request any extra vertical space
		// d.weightx = 1.0; // request any extra horizontal space
		d.anchor = GridBagConstraints.WEST; // comp location
		// d.insets = new Insets(10, 10, 10, 10); // padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row


		JLabel nameLabel = new JLabel("Family Species: ");
		JLabel name = new JLabel("Pantodon Bucholzi");
		Font font = new Font("BamFont", Font.BOLD, 20);
		name.setFont(font);

		panel.add(nameLabel, d);

		d.weightx = 1.0; // request any extra horizontal space
		d.gridx = 1;
		panel.add(name, d);


		return panel;
	}
}
