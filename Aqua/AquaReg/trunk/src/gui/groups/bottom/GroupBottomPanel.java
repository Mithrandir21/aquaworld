package gui.groups.bottom;


import gui.editing.AquaJList;
import gui.groups.GroupsFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import coreObjects.AbstractObject;


public class GroupBottomPanel extends JPanel implements ActionListener
{
	public static JScrollPane search;

	private static JPanel rsTable;

	private JPanel listPanel;

	private static boolean searchingMode = false;



	/**
	 * TODO - Description NEEDED!
	 */
	public GroupBottomPanel()
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

		listPanel = ResultsListPanel(this, null);
		this.add(listPanel, d);



		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridx = 1;
		this.add(GroupBottomSearchResultsPanel(this), d);


		Dimension size = new Dimension(1000, 400);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
	}



	/**
	 * TODO - Description NEEDED!
	 */
	public JPanel ResultsListPanel(ActionListener lis, AbstractObject[] data)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		panel.setBorder(BorderFactory.createEtchedBorder());
		Dimension dim = new Dimension(220, 0);
		panel.setPreferredSize(dim);
		panel.setMinimumSize(dim);



		JScrollPane scroll = new JScrollPane();
		scroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		// d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		JButton searchButton = new JButton("Search");
		searchButton.setActionCommand("searchToggle");
		searchButton.addActionListener(lis);
		panel.add(searchButton, d);


		JPanel listPanel = new JPanel();
		GroupsFrame.groupObjectsList = new AquaJList(data);
		// list.setCellRenderer(new CustomAquaObjectListRenderer());
		listPanel.setLayout(new GridLayout());

		listPanel.add(GroupsFrame.groupObjectsList);


		scroll.setViewportView(listPanel);
		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 1; // second row
		d.gridx = 0;

		panel.add(scroll, d);


		return panel;
	}



	public static void changeMode()
	{
		searchingMode = !searchingMode;

		search.setVisible(searchingMode);
		rsTable.setVisible(!searchingMode);
	}




	public JPanel GroupBottomSearchResultsPanel(ActionListener lis)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
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

		JPanel searchPanel = new GroupSearchPanel();
		search = new JScrollPane(searchPanel);
		search.setVisible(false);
		panel.add(search, d);


		rsTable = new ResultTable();
		rsTable.setVisible(true);
		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		// d.insets = new Insets(0, 80, 80, 80); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;
		panel.add(rsTable, d);


		return panel;
	}





	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() instanceof JButton )
		{
			String action = e.getActionCommand();
			if ( action.equalsIgnoreCase("searchToggle") )
			{
				changeMode();
			}
		}
	}
}
