package gui.groups.bottom;


import gui.AquaReg;
import gui.editing.AquaJList;
import gui.editing.JPopupEditingList;
import gui.groups.GroupsFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import logistical.DataRetrival;
import sqlLogic.SQLfunctions;
import coreObjects.AbstractObject;


public class GroupBottomPanel extends JPanel implements ActionListener
{
	public static JScrollPane search;

	private static JPanel rsTable;

	private JPanel listPanel;

	private static boolean searchingMode = false;

	private String groupName;



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
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



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
		addMouseLis(GroupsFrame.groupObjectsList);
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


	// /**
	// * This function attempts to find and return the {@link AbstractObject}
	// represented by the
	// */
	// private AbstractObject getListObject(String groupName, int index)
	// {
	// if ( groupName != null && index > -1 )
	// {
	// try
	// {
	// Connection con = AquaReg.getConnectionToDB();
	//
	// // Gets all the objects from the group(Fish, Invertebrate and
	// // Coral)
	// AbstractObject[] objects = SQLfunctions
	// .databaseGetObjectsFromGroup(con, groupName);
	//
	// // Gets the data inside each object
	// String[][] data = DataRetrival.getObjectsData(objects);
	//
	// // The object class must be set
	// if ( GroupsFrame.groupObjectsList != null && data != null )
	// {
	// // Gets the name that is displayed, or null if nothing is
	// // selected
	// String selectedGroupName = (String) GroupsFrame.groupObjectsList
	// .getModel().getElementAt(index);
	//
	// if ( selectedGroupName != null )
	// {
	// // Here the ID of the selected Object is found
	// int ID = getNameID(data, selectedGroupName);
	//
	// // Gets the Object for the DB(exceptions thrown).
	// AbstractObject obj = SQLfunctions.databaseGetObject(
	// con, ID, FishObject.class);
	//
	// return obj;
	// }
	// }
	//
	// }
	// catch ( MoreTheOneResultObject e1 )
	// {
	// e1.printStackTrace();
	// }
	// catch ( ObjectIDnotFoundInDatabaseException e1 )
	// {
	// e1.printStackTrace();
	// }
	// }
	//
	// return null;
	// }




	//
	/**
	* This function returns the index in the given array where the first
	given
	* name can be found. Returns -1 if the name is not found or the array or
	* name is null. If will also return -1 if the place where IDs are
	contained
	* contains something other then an Integer.
	*/
	public static int getNameID(String[][] data, String name)
	{
		if ( data != null && data.length > 0 && name != null )
		{
			for ( int i = 0; i < data.length; i++ )
			{
				// If the index is not null and it equals the given names.
				if ( data[i] != null && data[i][1].equals(name) )
				{
					try
					{
						return Integer.parseInt(data[i][0]);
					}
					catch ( NumberFormatException e )
					{
						return -1;
					}
				}
			}
		}

		return -1;
	}



	/**
	* This function takes a mulit-dim array and returns an array of the
	second
	* index.
	*/
	public static String[] getNameStrings(String[][] data)
	{
		if ( data != null && data.length > 0 && data[0].length > 1 )
		{
			String[] array = new String[data.length];

			for ( int i = 0; i < data.length; i++ )
			{
				if ( data[i] != null )
				{
					if ( data[i][0] != null && data[i][1] != null )
					{
						array[i] = data[i][1];
					}
				}
			}

			return array;
		}


		return null;
	}



	private void addMouseLis(final JList list)
	{
		list.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(final MouseEvent e)
			{
				if ( e.getButton() == MouseEvent.BUTTON3 )
				{
					int index = list.locationToIndex(e.getPoint());

					if ( index > -1 )
					{
						// Gets the name that is displayed, or null if nothing
						// is
						// selected
						AbstractObject obj = (AbstractObject) list.getModel()
								.getElementAt(index);

						if ( obj != null )
						{
							list.setSelectedIndex(index);

							JPopupEditingList pop = new JPopupEditingList(obj,
									e.getPoint());
							pop.show(list, e.getPoint().x, e.getPoint().y);
						}
					}
				}
			}
		});
	}



	/**
	 * Refreshes the JList on {@link AbstractObject} objects in the Groups JList.
	 */
	public static void refreshObjList()
	{
		if ( GroupsFrame.groupsList != null )
		{
			// Gets the name that is displayed, or null if nothing is selected
			String selectedGroupName = (String) GroupsFrame.groupsList
					.getSelectedValue();


			if ( selectedGroupName != null )
			{
				Connection con = AquaReg.getConnectionToDB();

				// Gets all the objects from the group(Fish, Invertebrate and
				// Coral)
				AbstractObject[] objects = SQLfunctions
						.databaseGetObjectsFromGroup(con, selectedGroupName);

				// Gets the data inside each object
				String[][] data = DataRetrival.getObjectsData(objects);

				DefaultTableModel model = new DefaultTableModel(data,
						GroupsFrame.columnNames);

				// Sets the data for the table
				GroupsFrame.groupObjectsTable.setModel(model);


				if ( objects != null && objects.length != 0 )
				{
					GroupsFrame.groupObjectsList.setListData(objects);
				}
				else
				{
					GroupsFrame.groupObjectsList.setListData(new Object[0]);
				}

				AquaReg.closeConnection(con);
			}
		}
	}



}
