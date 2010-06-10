package gui.editing;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class EditingTab extends JPanel
{
	public EditingTab()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 2; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;



		JTabbedPane tabbed = new JTabbedPane();

		tabbed.addTab("Fish", new JPanel());
		tabbed.addTab("Coral", new JPanel());
		tabbed.addTab("Invertebrate", new JPanel());

		this.add(tabbed, d);



		d.fill = GridBagConstraints.NONE;
		d.weighty = 0.01; // request any extra vertical space
		d.weightx = 0.5; // request any extra vertical space
		d.gridwidth = 1;
		d.gridy = 1;

		JButton advanced = new JButton("Advanced");
		this.add(advanced, d);

		d.gridx = 1;
		JButton refresh = new JButton("Refresh");
		this.add(refresh, d);
	}
}
