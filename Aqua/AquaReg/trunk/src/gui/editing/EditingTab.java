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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sqlLogic.SQLfunctions;
import coreObjects.AbstractObject;
import coreObjects.Coral.CoralObject;
import coreObjects.Fish.FishObject;
import coreObjects.Invertebrates.InvertebratesObject;


public class EditingTab extends JPanel
{
	public static JList groupsFishList = new JList();

	public static JList groupsCoralList = new JList();

	public static JList groupsInvertebrateList = new JList();

	private String[][] fishData;

	private String[][] coralData;

	private String[][] invertebrateData;


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
			if ( e.getValueIsAdjusting() )
			{
				return;
			}

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
			if ( objClass != null )
			{
				// Gets the name that is displayed, or null if nothing is
				// selected
				String selectedGroupName = (String) list.getSelectedValue();

				// Here the ID of the selected Object is found

				if ( selectedGroupName != null )
				{
					Connection con = AquaReg.getConnectionToDB();

					try
					{
						if ( e.getSource().equals(groupsFishList) )
						{
							AbstractObject obj = SQLfunctions
									.databaseGetObject(con, 1, objClass);

							EditingFrame.editingObjectView.populateFields(obj);

							EditingFrame.editingObject = obj;
						}
						else if ( e.getSource().equals(groupsCoralList) )
						{
							System.out.println("coral");
						}
						else if ( e.getSource().equals(groupsInvertebrateList) )
						{
							System.out.println("invertebrate");
						}
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
	 * This function takes a mulit-dim array and returns an array of the second
	 * index.
	 */
	public static String[] getNameStrings(String[][] data)
	{
		if ( data != null && data[0].length > 1 )
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
}
