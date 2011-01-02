package gui.groups.top;


import exceptions.MoreTheOneResultObject;
import gui.AquaReg;
import gui.GraficalFunctions;
import gui.groups.GroupsFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import logistical.DataRetrival;
import sqlLogic.SQLfunctions;
import coreObjects.AbstractObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class GroupTopPanel extends JPanel implements ActionListener
{
	JTextField groupNameField = new JTextField();

	JTextArea descriptionArea = new JTextArea();

	JLabel groupSize = new JLabel(" ");

	/**
	 * TODO - Description NEEDED!
	 */
	public GroupTopPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 0.25; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		Connection con = AquaReg.getConnectionToDB();
		String[] arrayNames = SQLfunctions.databaseGetGroupNames(con);
		AquaReg.closeConnection(con);

		if ( arrayNames != null && arrayNames.length != 0 )
		{
			GroupsFrame.groupsList.setListData(arrayNames);
		}
		else
		{
			GroupsFrame.groupsList.setListData(new Object[0]);
		}
		GroupsFrame.groupsList
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ListSelectionModel listSelectionModel = list.getSelectionModel();
		GroupsFrame.groupsList
				.addListSelectionListener(new GroupListSelectionListener());
		JScrollPane scroll = new JScrollPane(GroupsFrame.groupsList);
		Dimension dim = new Dimension(1, 100);
		scroll.setMaximumSize(dim);
		scroll.setPreferredSize(dim);
		this.add(scroll, d);



		// d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 0.75; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 1;




		this.add(getGroupInfo("", ""), d);
		Dimension size = new Dimension(700, 200);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
	}



	private JPanel getGroupInfo(String groupName, String groupDesc)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		// panel.setBorder(BorderFactory.createEtchedBorder());


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.15; // request any extra vertical space
		// d.weightx = 1.0; // request any extra horizontal space
		d.anchor = GridBagConstraints.WEST; // comp location
		d.insets = new Insets(5, 5, 5, 5); // padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row



		JLabel groupNameLabel = new JLabel("Group Name");
		panel.add(groupNameLabel, d);


		groupNameField = new JTextField();
		if ( groupName != "" )
		{
			groupNameField.setText(groupName);
		}
		d.anchor = GridBagConstraints.NORTH; // comp location
		d.gridy = 1;
		panel.add(groupNameField, d);


		JLabel groupSizeLabel = new JLabel("Group Size");
		d.gridy = 2;
		panel.add(groupSizeLabel, d);



		groupSize.setBorder(BorderFactory.createEtchedBorder());
		d.gridy = 3;
		panel.add(groupSize, d);


		JButton saveGroup = new JButton("Save Group");
		saveGroup.setActionCommand("saveGroup");
		saveGroup.addActionListener(this);
		d.gridy = 4;
		panel.add(saveGroup, d);


		JButton newGroupButton = new JButton("New Group");
		newGroupButton.setActionCommand("newGroup");
		newGroupButton.addActionListener(this);
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridy = 5;
		panel.add(newGroupButton, d);


		JLabel groupDescriptionLabel = new JLabel("Description");
		d.fill = GridBagConstraints.BOTH;
		d.gridx = 1;
		d.gridy = 0;
		panel.add(groupDescriptionLabel, d);



		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra horizontal space
		d.gridheight = 5;
		d.gridy = 1;
		panel.add(GraficalFunctions.getDescriptionPanel(descriptionArea,
				new Dimension(100, 40)), d);

		if ( groupDesc != "" )
		{
			descriptionArea.setText(groupDesc);
		}

		return panel;
	}


	class GroupListSelectionListener implements ListSelectionListener
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
				// Sets the group name gotten to the group name field
				groupNameField.setText(selectedGroupName);

				Connection con = AquaReg.getConnectionToDB();
				try
				{
					// Gets the description of the group
					String desc = SQLfunctions.databaseGetGroupDescription(con,
							selectedGroupName);
					// Sets the gotten description to the description area
					descriptionArea.setText(desc);


					// Gets all the objects from the group(Fish, Invertebrate
					// and Coral)
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
						groupSize.setText("" + objects.length);
					}
					else
					{
						GroupsFrame.groupObjectsList.setListData(new Object[0]);
						groupSize.setText("" + 0);
					}
				}
				catch ( MoreTheOneResultObject e1 )
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				AquaReg.closeConnection(con);
			}
		}
	}


	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getActionCommand().equals("saveGroup") )
		{
			Connection con = null;
			try
			{
				// Get the index of the group in the JList
				int currentIndex = GroupsFrame.groupsList.getSelectedIndex();

				// Get the name of the group in the database
				String currentName = (String) GroupsFrame.groupsList
						.getSelectedValue();

				if ( currentName != null )
				{
					// Get connection to the database
					con = AquaReg.getConnectionToDB();

					// Gets the new name as written in the text field
					String newName = groupNameField.getText();

					// Whether or not the name shall be changed
					boolean changeName = false;
					// Whether or not the description shall be changed
					boolean changeDesc = false;

					// If the current name is not the same as the new name
					if ( !(newName.equals(currentName)) )
					{
						if ( newName != "" )
						{
							changeName = true;
						}
					}

					// Gets the current description of the group
					String currentDesc = SQLfunctions
							.databaseGetGroupDescription(con, currentName);

					// Gets the new description as is written in the text area
					String newDesc = descriptionArea.getText();

					// If the current description is not the same as the new
					// description
					if ( !(newDesc.equals(currentDesc)) )
					{
						if ( newDesc != "" )
						{
							changeDesc = true;
						}
					}


					// If either the name or description has to be changed
					if ( changeName || changeDesc )
					{
						// The begining of the update sentence
						String update = "UPDATE "
								+ SQLfunctions.objectGroupTable + " SET";

						// If the name has to be changed
						if ( changeName )
						{
							update += " GroupName='" + newName + "'";
						}

						// If the description has to be changed
						if ( changeDesc )
						{
							// If the name also has to be changed
							if ( changeName )
							{
								update += ",";
							}

							update += " Description='" + newDesc + "'";
						}

						// The where part of the update
						update += " WHERE GroupName='" + currentName + "'";

						// Executes the SQL sentence
						SQLfunctions.databaseStatementExecution(con, update);

						if ( changeName )
						{
							// Gets the names of the current groups in the
							// database
							String[] arrayNames = SQLfunctions
									.databaseGetGroupNames(con);

							if ( arrayNames != null && arrayNames.length != 0 )
							{
								GroupsFrame.groupsList.setListData(arrayNames);
							}
							else
							{
								GroupsFrame.groupsList
										.setListData(new Object[0]);
							}

							GroupsFrame.groupsList
									.setSelectedIndex(currentIndex);
						}
					}
				}
			}
			catch ( MoreTheOneResultObject e1 )
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Closes the connection opened to the database
			if ( con != null )
			{
				AquaReg.closeConnection(con);
			}
		}
		else if ( e.getActionCommand().equals("newGroup") )
		{
			// Gets the name of the new group
			String newGroupName = JOptionPane.showInputDialog(null,
					"Group Name", "Enter the name of the new group",
					JOptionPane.QUESTION_MESSAGE);

			Connection con = null;
			// If the group name is not empty
			if ( newGroupName != "" )
			{
				// Gets the description
				String desc = JOptionPane.showInputDialog(null, "Description",
						"Enter the description of the group",
						JOptionPane.QUESTION_MESSAGE);

				// If the description is not empty
				if ( desc != "" )
				{
					// Get connection to the database
					con = AquaReg.getConnectionToDB();
					// If there does not exist a group already with the given
					// name
					if ( SQLfunctions.databaseGroupDoesNotExists(con,
							newGroupName) )
					{
						SQLfunctions.databaseAddGroup(con, newGroupName, desc,
								-1);

						// Gets the names of the current groups in the database
						String[] arrayNames = SQLfunctions
								.databaseGetGroupNames(con);


						if ( arrayNames != null && arrayNames.length != 0 )
						{
							GroupsFrame.groupsList.setListData(arrayNames);
						}
						else
						{
							GroupsFrame.groupsList.setListData(new Object[0]);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,
								"A group already exists with the given name",
								"Group Name", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"The description can not be empty", "Description",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			if ( con != null )
			{
				AquaReg.closeConnection(con);
			}
		}
	}
}