package gui.views;


import graphicalObjects.LockCheckBox;
import graphicalObjects.RangeLockCheckBox;
import gui.AquaReg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import sqlLogic.SQLfunctions;
import coreObjects.Fish.FishObject;


public class FishView extends AbstractView implements ActionListener
{
	/**
	 * Empty constructor.
	 */
	public FishView()
	{

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() instanceof JCheckBox )
		{
			if ( e.getSource() instanceof LockCheckBox )
			{
				LockCheckBox box = (LockCheckBox) e.getSource();

				box.getJTextField().setEditable(!box.isSelected());
			}
			else if ( e.getSource() instanceof RangeLockCheckBox )
			{
				RangeLockCheckBox box = (RangeLockCheckBox) e.getSource();

				box.getLowJTextField().setEditable(!box.isSelected());
				box.getHighJTextField().setEditable(!box.isSelected());
			}
		}
		else if ( e.getSource() instanceof JButton )
		{
			JButton button = (JButton) e.getSource();

			if ( button.getActionCommand().equals("reset") )
			{
				resetAction();
			}
			else if ( button.getActionCommand().equals("save") )
			{
				boolean valid = saveAction();
				if ( valid )
				{
					addFishObject();
				}
			}
		}
	}


	private void addFishObject()
	{
		int objectID = -1;
		String groupName = "";
		String popName = "";
		String speciesName = "";
		String genusName = "";
		String description = "";
		double size = -1.0;
		int parID = -1;
		int fishExID = -1;

		// Gets the connection to the Database.
		Connection connection = AquaReg.getConnectionToDB();

		if ( connection != null )
		{
			popName = popNameField.getText(); // Gets the popular name
			speciesName = speciesField.getText(); // Gets the species name
			genusName = genusField.getText(); // Gets the genus name
			description = descriptionArea.getText(); // Gets the description
			size = getFieldDouble(sizeField); // Gets the size(-1.0 if invalid)
			/**
			 * Inserts an ObjectParameter object with the verified data from the
			 * fields. The ID of the INSERT row is returned.
			 */
			parID = insertObjectParameters();


			/**
			 * Inserts an empty FishExclusion object. The ID of the INSERT row
			 * is returned.
			 */
			fishExID = SQLfunctions
					.databaseAddNewEmptyFishExclusionsList(connection);


			/**
			 * Verifies that both objects are inserted. If one has failed the
			 * other will be also removed.
			 */
			if ( parID == -1 || fishExID == -1 || parID == 0 || fishExID == 0 )
			{
				// If the ObjectParameter has been added.
				if ( parID != -1 )
				{
					SQLfunctions.databaseRemoveObjectParametersID(connection,
							parID);
				}

				if ( fishExID != -1 )
				{
					SQLfunctions.databaseRemoveFishExclusionID(connection,
							fishExID);
				}
			}
			/**
			 * Both a ObjectParameter object and a FishExclusion object has been
			 * added and the ID's of both have been returned.
			 */
			else
			{
				String fishObjectString = "INSERT INTO "
						+ SQLfunctions.fishObjectTable + " VALUES (" + null // obj.getFishID()
						+ ", '" + popName + // Common name
						"', '" + speciesName + // Species Name
						"', '" + genusName + // Genus Name
						"', '" + description + // Description
						"', '" + size + // Size
						"', '" + parID + // FishParametersID
						"', '" + fishExID + // FishExclusionID
						"');";

				boolean objectCreated = false;
				boolean addedToGroup = false;


				try
				{
					// If the returned connection is not null
					if ( connection != null )
					{
						Statement statement = connection.createStatement();
						statement.setQueryTimeout(30); // set timeout to 30 sec.

						statement.executeUpdate("BEGIN;");
						statement.executeUpdate(fishObjectString,
								Statement.RETURN_GENERATED_KEYS);
						ResultSet rs = statement.getGeneratedKeys();
						statement.executeUpdate("COMMIT;");


						if ( rs.next() )
						{
							objectID = rs.getInt(1);
							objectCreated = true;
						}
					}


					// GROUP ADDITION
					// If there is a group written og selected
					if ( groupField.getSelectedItem() != null )
					{
						groupName = groupField.getSelectedItem().toString();
					}

					if ( groupName != "" )
					{
						Connection con = AquaReg.getConnectionToDB();

						// If the group does not already exist in the database
						boolean newGroup = SQLfunctions
								.databaseGroupDoesNotExists(con, groupName);

						// If the group does not exist
						if ( newGroup )
						{
							String desc = JOptionPane.showInputDialog(null,
									"Description",
									"Enter the description of the group",
									JOptionPane.QUESTION_MESSAGE);

							// If a new group has been created
							if ( SQLfunctions.databaseAddGroup(con, groupName,
									desc, -1) )
							{
								// Attempts to add the ID of the newly created
								// object to the group
								SQLfunctions.databaseAddObjectIDToGroup(con,
										groupName, FishObject.class, objectID);
								addedToGroup = true;
							}
						}
						// Else if the group exists
						else
						{
							// Attempts to add the ID of the newly created
							// object to the group
							SQLfunctions.databaseAddObjectIDToGroup(con,
									groupName, FishObject.class, objectID);
							addedToGroup = true;
						}
					}


					String finalText = "";
					if ( objectCreated )
					{
						finalText += "A new object " + speciesName
								+ " has been created.";
					}

					if ( addedToGroup )
					{
						finalText += "\nAnd has been added the group "
								+ groupName + ".";
					}


					JOptionPane.showMessageDialog(null, finalText, "Success",
							JOptionPane.PLAIN_MESSAGE);

				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
			}
		}


		try
		{
			if ( connection != null )
				connection.close();
		}
		catch ( SQLException e )
		{
			// connection close failed.
			System.err.println(e);
		}
	}
}
