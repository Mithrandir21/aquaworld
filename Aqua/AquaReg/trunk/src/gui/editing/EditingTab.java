package gui.editing;


import exceptions.MoreTheOneResultObject;
import exceptions.ObjectIDnotFoundInDatabaseException;
import gui.AquaReg;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sqlLogic.SQLfunctions;
import coreObjects.AbstractObject;
import coreObjects.Coral.CoralObject;
import coreObjects.Fish.FishObject;
import coreObjects.Invertebrates.InvertebratesObject;


public class EditingTab extends JPanel implements ChangeListener
{
	public JList groupsFishList = new JList();

	public JList groupsCoralList = new JList();

	public JList groupsInvertebrateList = new JList();

	private String[][] fishData;

	private String[][] coralData;

	private String[][] invertebrateData;

	private JTabbedPane tabbed = new JTabbedPane();

	private boolean clearingSelections;

	public EditingTab()
	{
		// Resets all the fields when something is selected.
		EditingFrame.editingObjectView.resetAction();

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




		// Gets the connection to the database
		Connection con = AquaReg.getConnectionToDB();


		// Get the data for the objects
		fishData = SQLfunctions.databaseGetObjectIDsandNamesFromTable(con,
				FishObject.class);

		coralData = SQLfunctions.databaseGetObjectIDsandNamesFromTable(con,
				CoralObject.class);

		invertebrateData = SQLfunctions.databaseGetObjectIDsandNamesFromTable(
				con, InvertebratesObject.class);



		// Gets all the names of the objects in the fish database
		String[] fishNames = getNameStrings(fishData);

		// Gets all the names of the objects in the coral database
		String[] coralNames = getNameStrings(coralData);

		// Gets all the names of the objects in the invertebrate database
		String[] invertebrateNames = getNameStrings(invertebrateData);


		AquaReg.closeConnection(con);

		// Sets all the names in the JList
		if ( fishNames != null && fishNames.length != 0 )
		{
			groupsFishList.setListData(fishNames);
		}
		else
		{
			groupsFishList.setListData(new Object[0]);
		}

		// Sets all the names in the JList
		if ( coralNames != null && coralNames.length != 0 )
		{
			groupsCoralList.setListData(coralNames);
		}
		else
		{
			groupsCoralList.setListData(new Object[0]);
		}

		// Sets all the names in the JList
		if ( invertebrateNames != null && invertebrateNames.length != 0 )
		{
			groupsInvertebrateList.setListData(invertebrateNames);
		}
		else
		{
			groupsInvertebrateList.setListData(new Object[0]);
		}



		groupsFishList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		groupsCoralList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		groupsInvertebrateList
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		groupsFishList
				.addListSelectionListener(new ObjectListSelectionListener());
		groupsFishList.setName("fishObjects");
		groupsCoralList
				.addListSelectionListener(new ObjectListSelectionListener());
		groupsFishList.setName("coralObjects");
		groupsInvertebrateList
				.addListSelectionListener(new ObjectListSelectionListener());
		groupsFishList.setName("invertebrateObjects");



		tabbed.addTab("Fish", groupsFishList);
		tabbed.addTab("Coral", groupsCoralList);
		tabbed.addTab("Invertebrate", groupsInvertebrateList);

		this.add(tabbed, d);
		tabbed.addChangeListener(this);


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




	class ObjectListSelectionListener implements ListSelectionListener
	{
		/*
		 * (non-Javadoc)
		 * @see
		 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.
		 * event.ListSelectionEvent)
		 */
		@Override
		public void valueChanged(ListSelectionEvent e)
		{
			// If pointer moving
			if ( e.getValueIsAdjusting() || clearingSelections )
			{
				return;
			}

			// Resets all the fields when something is selected.
			EditingFrame.editingObjectView.resetAction();

			JList list = (JList) e.getSource();

			// Now the type of selected object will be determined
			Class objClass = null;
			String[][] data = null;


			if ( list == groupsFishList )
			{
				objClass = FishObject.class;
				data = fishData;
			}
			else if ( list == groupsCoralList )
			{
				objClass = CoralObject.class;
				data = coralData;
			}
			else if ( list == groupsInvertebrateList )
			{
				objClass = InvertebratesObject.class;
				data = invertebrateData;
			}


			// The object class must be set
			if ( objClass != null && data != null )
			{
				// Gets the name that is displayed, or null if nothing is
				// selected
				String selectedGroupName = (String) list.getSelectedValue();

				if ( selectedGroupName != null )
				{
					// Here the ID of the selected Object is found
					int index = getNameID(data, selectedGroupName);

					Connection con = AquaReg.getConnectionToDB();

					try
					{
						// Gets the Object for the DB(exceptions thrown).
						AbstractObject obj = SQLfunctions.databaseGetObject(
								con, index, objClass);

						EditingFrame.editingObjectView.populateFields(obj);

						EditingFrame.editingObject = obj;
					}
					catch ( MoreTheOneResultObject e1 )
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					catch ( ObjectIDnotFoundInDatabaseException e1 )
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}



	/**
	 * This function returns the index in the given array where the first given
	 * name can be found. Returns -1 if the name is not found or the array or
	 * name is null. If will also return -1 if the place where IDs are contained
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
	 * This function takes a mulit-dim array and returns an array of the second
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



	@Override
	public void stateChanged(ChangeEvent e)
	{
		int index = tabbed.getSelectedIndex();

		if ( index > -1 )
		{
			// Gets the name of the tab
			String tabSelected = tabbed.getTitleAt(tabbed.getSelectedIndex());

			// Setting for not reseting the editing view
			clearingSelections = true;

			if ( tabSelected.equals("Fish") )
			{
				// groupsFishList.clearSelection();
				groupsCoralList.clearSelection();
				groupsInvertebrateList.clearSelection();
			}
			else if ( tabSelected.equals("Coral") )
			{
				// groupsCoralList.clearSelection();
				groupsFishList.clearSelection();
				groupsInvertebrateList.clearSelection();
			}
			else if ( tabSelected.equals("Invertebrate") )
			{
				// groupsInvertebrateList.clearSelection();
				groupsFishList.clearSelection();
				groupsCoralList.clearSelection();
			}

			// Reseting the setting for editing view reseting
			clearingSelections = false;
		}
	}



	public void refreshJLists()
	{ // Gets the connection to the database
		Connection con = AquaReg.getConnectionToDB();


		// Get the data for the objects
		fishData = SQLfunctions.databaseGetObjectIDsandNamesFromTable(con,
				FishObject.class);

		coralData = SQLfunctions.databaseGetObjectIDsandNamesFromTable(con,
				CoralObject.class);

		invertebrateData = SQLfunctions.databaseGetObjectIDsandNamesFromTable(
				con, InvertebratesObject.class);



		// Gets all the names of the objects in the fish database
		String[] fishNames = getNameStrings(fishData);

		// Gets all the names of the objects in the coral database
		String[] coralNames = getNameStrings(coralData);

		// Gets all the names of the objects in the invertebrate database
		String[] invertebrateNames = getNameStrings(invertebrateData);


		AquaReg.closeConnection(con);

		// Sets all the names in the JList
		if ( fishNames != null && fishNames.length != 0 )
		{
			groupsFishList.removeAll();
			groupsFishList.setListData(fishNames);
		}
		else
		{
			groupsFishList.removeAll();
			groupsFishList.setListData(new Object[0]);
		}

		// Sets all the names in the JList
		if ( coralNames != null && coralNames.length != 0 )
		{
			groupsCoralList.removeAll();
			groupsCoralList.setListData(coralNames);
		}
		else
		{
			groupsCoralList.removeAll();
			groupsCoralList.setListData(new Object[0]);
		}

		// Sets all the names in the JList
		if ( invertebrateNames != null && invertebrateNames.length != 0 )
		{
			groupsInvertebrateList.removeAll();
			groupsInvertebrateList.setListData(invertebrateNames);
		}
		else
		{
			groupsInvertebrateList.removeAll();
			groupsInvertebrateList.setListData(new Object[0]);
		}
	}
}
