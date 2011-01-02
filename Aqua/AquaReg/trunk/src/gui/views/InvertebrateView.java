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
import coreObjects.Invertebrates.InvertebratesObject;


public class InvertebrateView extends AbstractView implements ActionListener
{
	/**
	 * Empty constructor.
	 */
	public InvertebrateView(boolean incDelButton, boolean incExcButton)
	{
		super(incDelButton, incExcButton, InvertebratesObject.class);
		sizeField.setNecessary(false);
		ghLowField.setNecessary(false);
		ghHighField.setNecessary(false);
		khLowField.setNecessary(true);
		khHighField.setNecessary(true);
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
					addInvertebrateObject();
				}
			}
		}
	}


	private void addInvertebrateObject()
	{
		int objectID = -1;
		String groupName = "";
		String popName = "";
		String speciesName = "";
		String genusName = "";
		String description = "";
		String invType = "";
		int parID = -1;
		int invExID = -1;
		int popNamedID = -1;

		// Gets the connection to the Database.
		Connection connection = AquaReg.getConnectionToDB();

		if ( connection != null )
		{
			if ( !popNameField.getText().equals("") )
			{
				popName = popNameField.getText();
			}
			speciesName = speciesField.getText(); // Gets the species name
			genusName = genusField.getText(); // Gets the genus name
			description = descriptionArea.getText(); // Gets the description
			invType = this.invType.getSelectedItem().toString();

			/**
			 * Creates a new row in the database and returns the ID of the row.
			 */
			if ( !popName.equals("") )
			{
				popNamedID = SQLfunctions.databaseAddNewPopNamesReturnID(
						connection, popName);
			}
			else
			{
				popNamedID = SQLfunctions
						.databaseAddNewPopNamesReturnID(connection);
			}

			/**
			 * Inserts an ObjectParameter object with the verified data from the
			 * fields. The ID of the INSERT row is returned.
			 */
			parID = insertObjectParameters();

			/**
			 * Inserts an empty InvertebrateExclusion object. The ID of the
			 * INSERT row is returned.
			 */
			invExID = SQLfunctions
					.databaseAddNewEmptyInvertebrateExclusionsList(connection);



			/**
			 * Verifies that both objects are inserted. If one has failed the
			 * other will be also removed.
			 */
			if ( popNamedID == -1 || parID == -1 || invExID == -1
					|| popNamedID == 0 || parID == 0 || invExID == 0 )
			{
				/**
				 * If the functions have created a row in the different tables, the 
				 * IDs will be something other then -1.
				 */

				// If the PopNames row was created.
				if ( popNamedID != -1 )
				{
					SQLfunctions.databaseRemovePopNamesID(connection,
							popNamedID);
				}

				// If the ObjectParameter has been added.
				if ( parID != -1 )
				{
					SQLfunctions.databaseRemoveObjectParametersID(connection,
							parID);
				}

				if ( invExID != -1 )
				{
					SQLfunctions.databaseRemoveInvertebrateExclusionID(
							connection, invExID);
				}
			}
			/**
			 * Both a ObjectParameter object and a FishExclusion object has been
			 * added and the ID's of both have been returned.
			 */
			else
			{
				String fishObjectString = "INSERT INTO "
						+ SQLfunctions.invertebrateObjectTable + " VALUES ("
						+ null + // obj.getFishID()
						", '" + speciesName + // Species Name
						"', '" + genusName + // Genus Name
						"', '" + description + // Description
						"', '" + invType + // InvertebratesType
						"', " + parID + // ObjectParametersID
						", " + invExID + // IExclusionID
						", " + popNamedID + // IExclusionID
						");";

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

					/**
					 * If the functions have created a row in the different tables, the 
					 * IDs will be something other then -1.
					 */

					// If the PopNames row was created.
					if ( popNamedID != -1 )
					{
						SQLfunctions.databaseRemovePopNamesID(connection,
								popNamedID);
					}

					// If the ObjectParameter has been added.
					if ( parID != -1 )
					{
						SQLfunctions.databaseRemoveObjectParametersID(
								connection, parID);
					}

					if ( invExID != -1 )
					{
						SQLfunctions.databaseRemoveInvertebrateExclusionID(
								connection, invExID);
					}

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
