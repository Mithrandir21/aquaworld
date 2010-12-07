/**
 * 
 */
package gui.views;


import graphicalObjects.AquaField;
import gui.AquaReg;
import gui.editing.EditingFrame;
import gui.exclusions.ExclusionFrame;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import sqlLogic.SQLfunctions;
import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;
import coreObjects.Coral.CoralObject;
import coreObjects.Fish.FishObject;
import coreObjects.Invertebrates.InvertebratesObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class EditingView extends AbstractView implements DocumentListener
{
	// The abstract object that the view contains information about.
	private AbstractObject object;

	private boolean changed = false;


	/**
	 * Empty constructor
	 */
	public EditingView(boolean incDelButton, boolean incExcButton)
	{
		super(incDelButton, incExcButton);
	}


	public void populateFields(AbstractObject obj)
	{
		if ( obj != null )
		{
			object = obj;

			ObjectParameters par = obj.getParameters();

			// Gets the genus
			populateField(genusField, obj.getGenusName());

			// Gets the species
			populateField(speciesField, obj.getSpeciesName());

			// Gets the popular name
			populateField(popNameField, obj.getPopulareName());

			if ( obj instanceof FishObject )
			{
				FishObject fishObj = (FishObject) obj;
				sizeField.setNecessary(true);
				// Gets the size
				populateField(sizeField, fishObj.getSize());
			}
			else
			{
				sizeField.setNecessary(false);
				populateField(sizeField, "");
			}

			// Gets the space needed
			populateField(spaceNeededField, par.getSpaceNeeded());


			// Gets the salinity low
			populateField(salinityLowField, par.getSalinityLow());

			// Gets the salinity high
			populateField(salinityHighField, par.getSalinityHigh());


			// Gets the ph low
			populateField(phLowField, par.getPHlow());

			// Gets the ph high
			populateField(phHighField, par.getPHhigh());


			// Gets the gh low
			populateField(ghLowField, par.getGHlow());

			// Gets the gh high
			populateField(ghHighField, par.getGHhigh());


			// Gets the kh low
			populateField(khLowField, par.getKhLow());

			// Gets the kh high
			populateField(khHighField, par.getKhHigh());


			// Gets the temp low
			populateField(tempLowField, par.getTemperatureLow());

			// Gets the temp high
			populateField(tempHighField, par.getTemperatureHigh());


			// Gets the others size low
			populateField(othersSizeLowField, par.getOthersSizeLow());

			// Gets the others size high
			populateField(othersSizeHighField, par.getOthersSizeHigh());


			String text = obj.getDescription();
			if ( text != null && !(text.equalsIgnoreCase(""))
					&& !(text.equalsIgnoreCase("null")) )
			{
				descriptionArea.setText(text);
			}
			else
			{
				descriptionArea.setText("");
			}

			// AquaAutoCompleteComboBox groupField = new
			// AquaAutoCompleteComboBox(false);

			this.revalidate();
			this.repaint();

			// Resets the changed boolean
			changed = false;
		}
	}


	/**
	 * TODO - Description
	 */
	private void populateField(AquaField field, String text)
	{
		if ( field != null )
		{
			field.addActionListener(this);
			field.getDocument().addDocumentListener(this);
		}

		if ( text != null && !(text.equalsIgnoreCase(""))
				&& !(text.equalsIgnoreCase("null")) )
		{
			field.setText(text);
		}
		else
		{
			field.setText("");
		}
	}



	/**
	 * TODO - Description
	 */
	private void populateField(AquaField field, int number)
	{
		if ( field != null )
		{
			field.addActionListener(this);
			field.getDocument().addDocumentListener(this);
		}

		if ( number > 0 )
		{
			field.setText("" + number);
		}
		else
		{
			field.setText("");
		}
	}



	/**
	 * TODO - Description
	 */
	private void populateField(AquaField field, double number)
	{
		if ( field != null )
		{
			field.addActionListener(this);
			field.getDocument().addDocumentListener(this);
		}

		if ( number > 0.0 )
		{
			field.setText("" + number);
		}
		else
		{
			field.setText("");
		}
	}


	/**
	 * Returns a boolean on whether the settings for the object has been
	 * changed.
	 */
	public boolean getSettingsChanged()
	{
		return changed;
	}


	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();

		if ( action.equals("delete") )
		{
			if ( object != null )
			{
				int answer = JOptionPane.showConfirmDialog(this,
						"Are you sure you wish to DELETE this object?",
						"Confirm", JOptionPane.YES_NO_OPTION);

				// If the user answers yes
				if ( answer == JOptionPane.YES_OPTION )
				{
					Connection con = AquaReg.getConnectionToDB();

					SQLfunctions.databaseRemoveAbstractObject(con, object);
					EditingFrame.list.refreshJLists();
				}
			}
		}
		else if ( action.equals("exclusions") )
		{
			if ( object != null )
			{
				new ExclusionFrame();
			}
		}
		else if ( action.equals("reset") )
		{
			if ( object != null && changed )
			{
				int answer = JOptionPane.showConfirmDialog(this,
						"Are you sure you wish to RESET this object?",
						"Confirm", JOptionPane.YES_NO_OPTION);

				// If the user answers yes
				if ( answer == JOptionPane.YES_OPTION )
				{
					EditingFrame.list.refreshJLists();
				}
			}
		}
		else if ( action.equals("save") )
		{
			// If the selected object is not null and the text has been changed.
			if ( object != null && changed )
			{
				int answer = JOptionPane.showConfirmDialog(this,
						"Are you sure you wish to ALTER this object?",
						"Confirm", JOptionPane.YES_NO_OPTION);

				// If the user answers yes
				if ( answer == JOptionPane.YES_OPTION )
				{
					boolean valid = saveAction();
					if ( valid )
					{
						saveObject();
						EditingFrame.list.refreshJLists();
					}
				}
			}
		}
	}




	@Override
	public void insertUpdate(DocumentEvent e)
	{
		changed = true;
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		changed = true;
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		// Plain text components do not fire these events
	}



	private void saveObject()
	{
		String groupName = "";
		String popName = "";
		String speciesName = "";
		String genusName = "";
		String description = "";
		double size = -1.0;

		// Gets the connection to the Database.
		Connection connection = AquaReg.getConnectionToDB();

		if ( connection != null && object != null )
		{
			popName = popNameField.getText(); // Gets the popular name
			speciesName = speciesField.getText(); // Gets the species name
			genusName = genusField.getText(); // Gets the genus name
			description = descriptionArea.getText(); // Gets the description
			size = getFieldDouble(sizeField); // Gets the size(-1.0 if invalid)


			// The table to update the row in
			String objType = "";
			String objIDname = "";

			if ( object instanceof CoralObject )
			{
				objType = SQLfunctions.coralObjectTable;
				objIDname = SQLfunctions.coralObjectIDname;
			}
			else if ( object instanceof InvertebratesObject )
			{
				objType = SQLfunctions.invertebrateObjectTable;
				objIDname = SQLfunctions.invertebrateObjectIDname;
			}
			else if ( object instanceof FishObject )
			{
				objType = SQLfunctions.fishObjectTable;
				objIDname = SQLfunctions.fishObjectIDname;
			}


			if ( objType != "" )
			{
				boolean parSaved = this.updateObjectParameters(object);

				// If parameters have been saved.
				if ( parSaved )
				{
					// The update string for the Object
					String objectUpdateString = "";
					objectUpdateString = "UPDATE " + objType + " "
							+ "SET PopularName='" + popName + "', Species='"
							+ speciesName + "', Genus='" + genusName
							+ "', Description='" + description + "', Size='"
							+ size + "' " + "WHERE " + objIDname + "="
							+ object.getObjectID();

					SQLfunctions.databaseStatementExecution(connection,
							objectUpdateString);


				}

				// TODO - Group Update Edit View
				// // The update string for the group that the object belongs
				// to.
				// String groupUpdateString = "";
				// groupUpdateString = "UPDATE " + objType + " "
				// + "SET PopularName='" + popName + "', Species='"
				// + speciesName + "', Genus='" + genusName
				// + "', Description='" + description + "', Size='" + size
				// + "' " + "WHERE " + objIDname + "="
				// + object.getObjectID();
				//
				// System.out.println(groupUpdateString);
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
