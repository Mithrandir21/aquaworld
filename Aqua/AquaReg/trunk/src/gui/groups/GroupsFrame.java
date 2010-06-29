package gui.groups;


import gui.editing.AquaJList;
import gui.groups.bottom.GroupBottomPanel;
import gui.groups.top.GroupTopPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXTable;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class GroupsFrame extends JFrame
{
	public static JList groupsList = new JList();

	public static AquaJList groupObjectsList;

	public static JXTable searchResultsTable = new JXTable();

	public static JXTable groupObjectsTable = new JXTable();


	/**
	 * sample data column names
	 */
	public static String[] columnNames = { "Genus Name", "Species Name",
			"Pop Name", "Salinity", "PH", "GH", "Temperature", "KH",
			"Magnesium", "Calcium", "Space Needed", "Others Sizes" };


	/**
	 * TODO - Description NEEDED!
	 */
	public GroupsFrame()
	{
		super("Groups");

		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		d.weighty = 0.2; // request any extra vertical space
		d.weightx = 1.0;
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridy = 0; // third row


		JPanel panel1 = new GroupTopPanel();
		// panel1.setBorder(BorderFactory.createEtchedBorder());
		// Dimension panelSize = new Dimension(650, 100);
		// panel1.setPreferredSize(panelSize);
		// panel1.setMinimumSize(panelSize);
		// panel1.setMaximumSize(panelSize);
		this.add(panel1, d);




		d.fill = GridBagConstraints.BOTH;
		d.weighty = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.SOUTH; // bottom of space
		d.insets = new Insets(0, 0, 10, 0); // top padding
		d.gridy = 1; // third row


		JPanel panel2 = new GroupBottomPanel();
		// panel2.setBorder(BorderFactory.createEtchedBorder());
		// Dimension panel2Size = new Dimension(650, 380);
		// panel2.setPreferredSize(panel2Size);
		// panel2.setMinimumSize(panel2Size);
		// panel2.setMaximumSize(panel2Size);
		this.add(panel2, d);




		// this.setResizable(false);
		this.setPreferredSize(new Dimension(1000, 700));
		this.setMinimumSize(new Dimension(1000, 700));
		this.setVisible(true);
		this.pack();
	}
}
