package gui.groups.bottom;


import graphicalObjects.AquaObjectsTable;
import gui.groups.GroupsFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ResultTable extends JPanel
{
	public ResultTable()
	{

		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		// d.insets = new Insets(0, 80, 80, 80); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;

		this.setBorder(BorderFactory.createEtchedBorder());
		Dimension dim = new Dimension(700, 640);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);


		JTabbedPane results = new JTabbedPane();

		AquaObjectsTable groupResults = new AquaObjectsTable(null,
				GroupsFrame.groupObjectsTable, dim);
		results.addTab("Group Objects", groupResults);



		AquaObjectsTable searchResults = new AquaObjectsTable(null,
				GroupsFrame.searchResultsTable, dim);
		JPanel p = new JPanel(new GridLayout());
		p.add(searchResults);
		results.addTab("Search Results", p);


		this.add(results, d);
	}
}
