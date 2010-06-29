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

		// Gets all the names of the objects in the fish database
		String[] fishNames = SQLfunctions.databaseGetObjectNamesFromTable(con,
				FishObject.class);

		// Gets all the names of the objects in the coral database
		String[] coralNames = SQLfunctions.databaseGetObjectNamesFromTable(con,
				CoralObject.class);

		// Gets all the names of the objects in the invertebrate database
		String[] invertebrateNames = SQLfunctions
				.databaseGetObjectNamesFromTable(con, InvertebratesObject.class);
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
		 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
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

			// Gets the name that is displayed, or null if nothing is selected
			String selectedGroupName = (String) list.getSelectedValue();

			if ( selectedGroupName != null )
			{
				Connection con = AquaReg.getConnectionToDB();
				try
				{


					if ( e.getSource().equals(groupsFishList) )
					{
						AbstractObject obj = SQLfunctions.databaseGetObject(
								con, 1, FishObject.class);

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
