package gui.groups.bottom;


import gui.groups.ResultsListPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class GroupResultsPanel extends JPanel
{

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param lis
	 */
	public GroupResultsPanel(ActionListener lis)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		// this.setBorder(BorderFactory.createEtchedBorder());


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 0.2; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;

		this.add(new ResultsListPanel(), d);



		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridx = 1;
		this.add(new ResultTable(), d);
	}
}
