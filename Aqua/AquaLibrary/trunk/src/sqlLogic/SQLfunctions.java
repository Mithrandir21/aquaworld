package sqlLogic;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logistical.DataManipulation;
import logistical.DataRetrival;
import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;
import coreObjects.Coral.CoralObject;
import coreObjects.Coral.CoralObject.CoralTypes;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;
import coreObjects.Fish.FishObject.FishAgeType;
import coreObjects.Fish.FishObject.FishGender;
import coreObjects.Invertebrates.InvertebrateExclusions;
import coreObjects.Invertebrates.InvertebratesObject;
import coreObjects.Invertebrates.InvertebratesObject.InvertebratesTypes;
import exceptions.MoreTheOneResultObject;
import exceptions.ObjectAlreadyInDatabaseException;
import exceptions.ObjectIDnotFoundInDatabaseException;


public class SQLfunctions
{
	public static String objectParametersTable = "ObjectParameters";

	public static String fishExclusionListTable = "FishExclusionList";

	public static String objectGroupTable = "ObjectGroup";

	public static String popNamesTable = "PopNames";

	public static String invertebrateExclusionListTable = "InvertebrateExclusionList";

	public static String fishCampaignTable = "FishCampaign";

	public static String invertebrateCampaignTable = "InvertebrateCampaign";

	public static String coralCampaignTable = "CoralCampaign";

	public static String coralObjectTable = "CoralObject";

	public static String invertebrateObjectTable = "InvertebrateObject";

	public static String fishObjectTable = "FishObject";


	public static String fishObjectIDname = "FishObjectID";

	public static String coralObjectIDname = "CoralObjectID";

	public static String invertebrateObjectIDname = "InvertebrateObjectID ";

	public static String popNamesIDname = "popNameID";

	/**
	 * This function attempts to run the given string as a statement on the
	 * given database. If either the the given connection is null or the string
	 * is "" false will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 */
	public static boolean databaseStatementExecution(Connection con,
			String statementString)
	{
		if ( con != null && statementString != "" )
		{
			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(statementString);
				statement.executeUpdate("COMMIT;");

				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}

		return false;
	}



	/**
	 * Attempts to remove the the row in the ObjectParameters table with the
	 * given ID.
	 */
	public static boolean databaseRemoveObjectParametersID(Connection con,
			int ID)
	{
		return databaseRemoveFromTableWithID(con, objectParametersTable,
				"ObjectParametersID", ID);
	}


	/**
	 * Attempts to remove the the row in the FishExclusionList table with the
	 * given ID.
	 */
	public static boolean databaseRemoveFishExclusionID(Connection con, int ID)
	{
		return databaseRemoveFromTableWithID(con, fishExclusionListTable,
				"FishExclusionID", ID);
	}



	/**
	 * Attempts to remove the the row in the FishExclusionList table with the
	 * given ID.
	 */
	public static boolean databaseRemoveInvertebrateExclusionID(Connection con,
			int ID)
	{
		return databaseRemoveFromTableWithID(con,
				invertebrateExclusionListTable, "InvertebrateExclusionID", ID);
	}



	/**
	 * Attempts to remove the the row in the PopNames table with the
	 * given ID.
	 */
	public static boolean databaseRemovePopNamesID(Connection con, int ID)
	{
		return databaseRemoveFromTableWithID(con, popNamesTable,
				popNamesIDname, ID);
	}



	/**
	 * This function removes a row with the given Unique ID(int) from the table
	 * with the given name. If either the connection is null, ID is below 1 or
	 * the table string is "", the function returns false. It also returns false
	 * if there is a {@link SQLException}.
	 */
	public static boolean databaseRemoveFromTableWithID(Connection con,
			String table, String columnName, int ID)
	{
		if ( con != null && ID > 0 || table == "" )
		{
			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate("DELETE FROM " + table + " WHERE "
						+ columnName + "=" + ID);
				statement.executeUpdate("COMMIT;");
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}
		else
		{
			return false;
		}

		return true;
	}



	/**
	 * This function attempts to remove the given {@link AbstractObject} from
	 * the database in the given {@link Connection}. This function will also
	 * remove the exclusionslist and {@link ObjectParameters} connected to the
	 * {@link AbstractObject} in the database.
	 */
	public static boolean databaseRemoveAbstractObject(Connection con,
			AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			int popID = -1;
			long excIDyoung = -1;
			long excIDadult = -1;
			long parIDyoung = -1;
			long parIDadult = -1;
			boolean foundExcYoung = false;
			boolean foundExcAdult = false;
			boolean foundParYoung = false;
			boolean foundParAdult = false;
			boolean foundObj = false;

			/**
			 * First we will determine if the object, and its parameters and
			 * exclusion list, exists in the database.
			 */
			if ( obj instanceof FishObject )
			{
				FishObject fishObj = (FishObject) obj;

				// Determines if the exclusions list was found with the ID
				FishExclusions youngEx = databaseGetFishExclusions(con,
						fishObj, FishAgeType.YOUNG);
				FishExclusions adultEx = databaseGetFishExclusions(con,
						fishObj, FishAgeType.ADULT);

				if ( youngEx != null )
				{
					excIDyoung = youngEx.getFishExclusionID();
					foundExcYoung = true;
				}

				if ( adultEx != null )
				{
					excIDadult = adultEx.getFishExclusionID();
					foundExcAdult = true;
				}


				/**
				 * If foundExcYoung and foundExcAdult is true, the exclusion 
				 * list has been found a confirmed.
				 * Now we will attempt to determine the ObjectParameters.
				 */
				ObjectParameters youngPar = databaseGetFishParameters(con,
						fishObj, FishAgeType.YOUNG);
				ObjectParameters adultPar = databaseGetFishParameters(con,
						fishObj, FishAgeType.ADULT);


				if ( youngPar != null )
				{
					parIDyoung = youngPar.getObjectParametersID();
					foundParYoung = true;
				}

				if ( adultPar != null )
				{
					parIDadult = adultPar.getObjectParametersID();
					foundParAdult = true;
				}
			}
			else if ( obj instanceof CoralObject )
			{
				/**
				 * Since there exists no exclusion list for coral it is true.
				 */
				foundExcYoung = true;
				foundExcAdult = true;


				/**
				 * If foundExc is true, the exclusion list has been found a
				 * confirmed. Now we will attempt to determine the ObjectParameters.
				 */

				parIDyoung = databaseGetParameterID(con, obj);

				// Determines if the exclusions list was found with the ID
				foundParYoung = databaseParameterExists(con, parIDyoung);
				foundParAdult = true;
			}
			else if ( obj instanceof InvertebratesObject )
			{
				InvertebratesObject invertebrateObject = (InvertebratesObject) obj;

				// If the invertebrateObject contains an exclusions list
				if ( invertebrateObject.getExclusions() == null )
				{
					return false;
				}

				excIDyoung = databaseGetInvertebrateExclusionsID(con,
						invertebrateObject);

				// Determines if the exclusions list was found with the ID
				foundExcYoung = databaseInvertebrateExclusionsExists(con,
						excIDyoung);
				foundExcAdult = true;


				/**
				 * If foundExc is true, the exclusion list has been found a
				 * confirmed. Now we will attempt to determine the ObjectParameters.
				 */

				parIDyoung = databaseGetParameterID(con, obj);

				// Determines if the exclusions list was found with the ID
				foundParYoung = databaseParameterExists(con, parIDyoung);
				foundParAdult = true;
			}


			/**
			 * Now we will determine if all the necessary objects were found in the 
			 * database.
			 */

			if ( foundExcYoung == false || foundExcAdult == false
					|| foundParYoung == false || foundParAdult == false )
			{
				return false;
			}


			/**
			 * If the function gets to this point, it means that the
			 * AbstractObject contains a ObjectParametersYoung, ObjectParametersAdult
			 * and an ExclusionsListYoung and ExclusionsListAdult that is valid and 
			 * is found in the database. Now we must determine if the AbstractObject
			 * itself exists in the database.
			 */
			foundObj = databaseAbstractObjectExists(con, obj);

			if ( foundObj == false )
			{
				return false;
			}


			String objTable = "";
			String objIDcolumn = "";

			String excTable = "";
			String excIDcolumn = "";


			if ( obj instanceof FishObject )
			{
				objTable = fishObjectTable;
				objIDcolumn = "FishObjectID";

				excTable = fishExclusionListTable;
				excIDcolumn = "FishExclusionID";
			}
			else if ( obj instanceof CoralObject )
			{
				objTable = coralObjectTable;
				objIDcolumn = "CoralObjectID";
			}
			else if ( obj instanceof InvertebratesObject )
			{
				objTable = invertebrateObjectTable;
				objIDcolumn = "InvertebrateObjectID";

				excTable = invertebrateExclusionListTable;
				excIDcolumn = "InvertebrateExclusionID";
			}

			// Gets the ID of the popular name table
			popID = databaseGetObjectPopID(con, obj);


			/**
			 * At this point all parts of an AbstractObject has been validated.
			 * Now the actual removal can happen.
			 * 
			 * For an Object to be correctly removed it has to:
			 * 1.1 Remove the objects ExclusionsListYoung (Fish and Inv)
			 * 1.2 Remove the objects ExclusionsListAdult (Fish)
			 * 2.1 Remove the objects ObjectParametersYoung (Fish, Coral and Inv)
			 * 2.2 Remove the objects ObjectParametersAdult (Fish)
			 * 3. Remove the object from any of the other objects ExclusionsList
			 * 4. Remove the object from any Group it belongs to
			 * 5. Remove the object from the objects table
			 * 6. Remove the Popular name row for the object
			 */
			String removeExcYoungString = "";
			String removeExcAdultString = "";
			String removeParString = "";
			String removeParStringAdult = "";
			if ( obj instanceof FishObject )
			{
				if ( !(excTable.equals("") || excIDcolumn.equals("")) )
				{
					// 1.1 Remove the objects ExclusionsList
					removeExcYoungString = "DELETE FROM " + excTable
							+ " WHERE " + excIDcolumn + "=" + excIDyoung;

					// 1.2 Remove the objects ExclusionsList
					removeExcAdultString = "DELETE FROM " + excTable
							+ " WHERE " + excIDcolumn + "=" + excIDadult;

					// 2.2 Remove the objects ObjectParametersAdult
					removeParStringAdult = "DELETE FROM "
							+ objectParametersTable
							+ " WHERE ObjectParametersID=" + parIDadult;
				}
			}
			else if ( obj instanceof InvertebratesObject )
			{
				if ( !(excTable.equals("") || excIDcolumn.equals("")) )
				{
					// 1.1 Remove the objects ExclusionsList
					removeExcYoungString = "DELETE FROM " + excTable
							+ " WHERE " + excIDcolumn + "=" + excIDyoung;
				}
			}

			// 2.1 Remove the objects ObjectParametersYoung
			removeParString = "DELETE FROM " + objectParametersTable
					+ " WHERE ObjectParametersID=" + parIDyoung;

			// TODO - 3. Remove the object from any of the other objects
			// ExclusionsList

			// TODO - 4. Remove the object from any Group it belongs to.


			// 5. Remove the object from the objects table
			String removeObjectString = "DELETE FROM " + objTable + " WHERE "
					+ objIDcolumn + "=" + obj.getObjectID();


			System.out.println();
			System.out.println(removeExcYoungString);
			System.out.println(removeExcAdultString);
			System.out.println(removeParString);
			System.out.println(removeParStringAdult);
			System.out.println(removeObjectString);
			System.out.println(popID);
			System.out.println();


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				// Young Exclusions
				if ( !removeExcYoungString.equals("") )
				{
					statement.executeUpdate(removeExcYoungString);
				}
				// Adult Exclusions
				if ( !removeExcAdultString.equals("") )
				{
					statement.executeUpdate(removeExcAdultString);
				}
				// (Young) Parameters
				statement.executeUpdate(removeParString);
				// Adult Parameters
				if ( !removeParStringAdult.equals("") )
				{
					statement.executeUpdate(removeParStringAdult);
				}
				statement.executeUpdate(removeObjectString);
				statement.executeUpdate("COMMIT;");

				databaseRemovePopNamesID(con, popID);

				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
			}
		}
		else
		{
			return false;
		}

		return false;
	}

	/**
	 * This function attempts to create a new ObjectGroup in the given database
	 * with the given name and description. If either the given connection,
	 * group name or description is empty false will be returned. It also
	 * returns false if there is a {@link SQLException}.
	 * 
	 * (PS: This function is created for use with SQlite and ID < 0 )
	 */
	public static boolean databaseAddGroup(Connection con, String groupName,
			String groupDescription, int ID)
	{
		if ( con != null && groupName != "" && groupDescription != "" )
		{
			// If a group does not exist with the same name as the given name
			if ( databaseGroupDoesNotExists(con, groupName) )
			{
				String parameters = "";
				if ( ID > 0 )
				{
					// If a group does not exist with the same name as the given
					// name
					if ( databaseGroupDoesNotExists(con, ID) )
					{
						parameters = "INSERT INTO " + objectGroupTable
								+ " VALUES (" + ID + ", '" // The ID of the
															// group
								+ groupName // The name of the group
								+ "', '" + groupDescription // The description
															// of the group
								+ "', " + null // FishObjectsString
								+ ", " + null // CoralObjectsString
								+ ", " + null // InvertebrateObjectsString
								+ ");";
					}
				}
				else
				{
					parameters = "INSERT INTO " + objectGroupTable
							+ " VALUES (" + null + ", '" + groupName // The name
																		// of
																		// the
																		// group
							+ "', '" + groupDescription // The description of
														// the group
							+ "', " + null // FishObjectsString
							+ ", " + null // CoralObjectsString
							+ ", " + null // InvertebrateObjectsString
							+ ");";
				}

				try
				{
					Statement statement = con.createStatement();
					statement.setQueryTimeout(30); // set timeout to 30 sec.

					statement.executeUpdate("BEGIN;");
					statement.executeUpdate(parameters);
					statement.executeUpdate("COMMIT;");

					return true;
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
			}
		}

		return false;
	}


	/**
	 * This function attempts to create a new ObjectGroup in the given database
	 * with the given name and description. If either the given connection,
	 * group name or description is empty false will be returned. It also
	 * returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddGroup(Connection con, String groupName,
			String groupDescription)
	{
		if ( con != null && groupName != "" && groupDescription != "" )
		{
			// If a group does not exist with the same name as the given name
			if ( databaseGroupDoesNotExists(con, groupName) )
			{
				String parameters = "";
				parameters = "INSERT INTO " + objectGroupTable + " VALUES ("
						+ null + ", '" + groupName // The name of the group
						+ "', '" + groupDescription // The description of the
													// group
						+ "', " + null // FishObjectsString
						+ ", " + null // CoralObjectsString
						+ ", " + null // InvertebrateObjectsString
						+ ");";

				try
				{
					Statement statement = con.createStatement();
					statement.setQueryTimeout(30); // set timeout to 30 sec.

					statement.executeUpdate("BEGIN;");
					statement.executeUpdate(parameters);
					statement.executeUpdate("COMMIT;");

					return true;
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
			}
		}

		return false;
	}


	/**
	 * This function attempts to get description(String) of the group with the
	 * given name. Returns null if no group is found.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static String databaseGetGroupDescription(Connection con,
			String groupName) throws MoreTheOneResultObject
	{
		if ( con != null )
		{
			// If a group does exist with the same name as the given name
			if ( !(databaseGroupDoesNotExists(con, groupName)) )
			{
				try
				{
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectGroupTable
							+ " WHERE GroupName='" + groupName + "'";

					ResultSet rs = stmt.executeQuery(query);

					onlyOneResultSetRow(con, groupName, query);

					while ( rs.next() )
					{
						return rs.getString("Description");
					}
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
			}
		}

		return null;
	}



	/**
	 * This function attempts to get all the group names in the object group
	 * table.
	 */
	public static String[] databaseGetGroupNames(Connection con)
	{
		if ( con != null )
		{
			ArrayList<String> groupNames = new ArrayList<String>();
			String[] stringArray = new String[1];

			try
			{
				Statement stmt = con.createStatement();

				String query = "SELECT GroupName " + "FROM " + objectGroupTable;

				ResultSet rs = stmt.executeQuery(query);


				while ( rs.next() )
				{
					String name = rs.getString("GroupName");
					if ( name != "" )
					{
						groupNames.add(name);
					}
				}
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
			}

			stringArray = groupNames.toArray(stringArray);
			return stringArray;
		}

		return null;
	}


	/**
	 * this function attempts to add the ID(int) of the given
	 * {@link AbstractObject} to the ObjectGroup in the database with the same
	 * name as the given group name. If either the given connection, group name
	 * or description is empty false will be returned. It also returns false if
	 * there is a {@link SQLException}.
	 */
	public static boolean databaseAddObjectToGroup(Connection con,
			String groupName, AbstractObject obj)
	{
		if ( con != null && groupName != "" && obj != null )
		{
			ResultSet rs;
			String[] oldIDs;
			String[] newIDs;
			String oldIDsString = "";
			String newIDsString = "";

			String groupType = "";

			if ( obj instanceof CoralObject )
			{
				groupType = "GroupCoralObjects";
			}
			else if ( obj instanceof InvertebratesObject )
			{
				groupType = "GroupInvertebrateObjects";
			}
			else if ( obj instanceof FishObject )
			{
				groupType = "GroupFishObjects";
			}

			if ( groupType != "" )
			{
				try
				{
					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectGroupTable
							+ " WHERE GroupName='" + groupName + "'";

					rs = stmt.executeQuery(query);
					while ( rs.next() )
					{
						// Delimiter
						String delimiter = ", ";

						// Gets all the ID's in the field as a string
						oldIDsString = rs.getString(groupType);

						// Given string will be split by the argument delimiter
						// provided
						oldIDs = DataManipulation.stringToArray(oldIDsString,
								delimiter);

						// Adds the ID of the given object to the array
						newIDs = DataManipulation.placeObjectIDinSortedArray(
								obj.getObjectID(), oldIDs);

						// Creates a new IDs string with the new ID
						newIDsString = DataManipulation.arrayToString(newIDs,
								delimiter);
					}

					String updateString = "UPDATE " + objectGroupTable
							+ " SET " + groupType + " = '" + newIDsString
							+ "' WHERE GroupName='" + groupName + "'";

					stmt.executeUpdate("BEGIN;");
					stmt.executeUpdate(updateString);
					stmt.executeUpdate("COMMIT;");

					return true;
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
					return false;
				}
			}
		}

		return false;
	}



	/**
	 * This function attempts to add the given ID(int) to the ObjectGroup in the
	 * database with the same name as the given group name. The group type to
	 * add the ID to is determined by the given class. If either the given
	 * connection, group name object class is empty false will be returned. Also
	 * if the ID is lower then 1. It also returns false if there is a
	 * {@link SQLException}.
	 */
	public static boolean databaseAddObjectIDToGroup(Connection con,
			String groupName, Class objClass, int objID)
	{
		if ( con != null && groupName != "" && objClass != null && objID > 0 )
		{
			ResultSet rs;
			String[] oldIDs;
			String[] newIDs;
			String oldIDsString = "";
			String newIDsString = "";

			String groupType = "";

			if ( objClass.equals(CoralObject.class) )
			{
				groupType = "GroupCoralObjects";
			}
			else if ( objClass.equals(InvertebratesObject.class) )
			{
				groupType = "GroupInvertebrateObjects";
			}
			else if ( objClass.equals(FishObject.class) )
			{
				groupType = "GroupFishObjects";
			}

			if ( groupType != "" )
			{
				try
				{
					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectGroupTable
							+ " WHERE GroupName='" + groupName + "'";

					rs = stmt.executeQuery(query);
					while ( rs.next() )
					{
						// Delimiter
						String delimiter = ", ";

						// Gets all the ID's in the field as a string
						oldIDsString = rs.getString(groupType);

						// Given string will be split by the argument delimiter
						// provided
						oldIDs = DataManipulation.stringToArray(oldIDsString,
								delimiter);

						// Adds the ID of the given object to the array
						newIDs = DataManipulation.placeObjectIDinSortedArray(
								objID, oldIDs);

						// Creates a new IDs string with the new ID
						newIDsString = DataManipulation.arrayToString(newIDs,
								delimiter);
					}

					String updateString = "UPDATE " + objectGroupTable
							+ " SET " + groupType + " = '" + newIDsString
							+ "' WHERE GroupName='" + groupName + "'";

					stmt.executeUpdate("BEGIN;");
					stmt.executeUpdate(updateString);
					stmt.executeUpdate("COMMIT;");

					return true;
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
					return false;
				}
			}
		}

		return false;
	}



	/**
	 * TODO - Description
	 */
	public static int[] databaseGetGroupObjectIDs(Connection con,
			String groupName, Class objectType)
	{
		if ( con != null && groupName != "" && objectType != null )
		{
			// If a group does exist with the same name as the given name
			if ( !(databaseGroupDoesNotExists(con, groupName)) )
			{
				ResultSet rs;
				String[] IDs = null;
				String IDsString = "";

				String groupType = "";

				if ( objectType.equals(CoralObject.class) )
				{
					groupType = "GroupCoralObjects";
				}
				else if ( objectType.equals(InvertebratesObject.class) )
				{
					groupType = "GroupInvertebrateObjects";
				}
				else if ( objectType.equals(FishObject.class) )
				{
					groupType = "GroupFishObjects";
				}

				if ( groupType != "" )
				{
					try
					{
						// Statement stmt = con.createStatement(
						// ResultSet.TYPE_SCROLL_INSENSITIVE,
						// ResultSet.CONCUR_READ_ONLY);
						Statement stmt = con.createStatement();

						String query = "SELECT * " + "FROM " + objectGroupTable
								+ " WHERE GroupName='" + groupName + "'";

						rs = stmt.executeQuery(query);
						while ( rs.next() )
						{
							// Delimiter
							String delimiter = ", ";

							// Gets all the ID's in the field as a string
							IDsString = rs.getString(groupType);

							// Given string will be split by the argument
							// delimiter provided
							IDs = DataManipulation.stringToArray(IDsString,
									delimiter);
						}

						return DataManipulation.stringArraytoIntArray(IDs);
					}
					catch ( SQLException e )
					{
						// if the error message is "out of memory",
						// it probably means no database file is found
						System.err.println(e.getMessage());
					}
					catch ( Exception e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return null;
	}



	/**
	 * TODO - Description
	 */
	public static int[] databaseGetGroupObjectIDs(Connection con,
			String groupName)
	{
		if ( con != null && groupName != "" )
		{
			// If a group does exist with the same name as the given name
			if ( !(databaseGroupDoesNotExists(con, groupName)) )
			{
				ResultSet rs;
				String[] fishIDs = null;
				String fishIDsString = "";
				String[] coralIDs = null;
				String coralIDsString = "";
				String[] invertebrateIDs = null;
				String invertebrateIDsString = "";

				try
				{
					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectGroupTable
							+ " WHERE GroupName='" + groupName + "'";

					rs = stmt.executeQuery(query);
					while ( rs.next() )
					{
						// Delimiter
						String delimiter = ", ";

						// Gets all the ID's in the field as a string
						fishIDsString = rs.getString("GroupFishObjects");

						// Given string will be split by the argument delimiter
						// provided
						fishIDs = DataManipulation.stringToArray(fishIDsString,
								delimiter);

						// Gets all the ID's in the field as a string
						coralIDsString = rs.getString("GroupCoralObjects");

						// Given string will be split by the argument delimiter
						// provided
						coralIDs = DataManipulation.stringToArray(
								coralIDsString, delimiter);

						// Gets all the ID's in the field as a string
						invertebrateIDsString = rs
								.getString("GroupInvertebrateObjects");

						// Given string will be split by the argument delimiter
						// provided
						invertebrateIDs = DataManipulation.stringToArray(
								invertebrateIDsString, delimiter);
					}

					int newArrayLenght = 0;

					if ( fishIDs != null && fishIDs.length > 0 )
					{
						newArrayLenght = newArrayLenght + fishIDs.length;
					}
					else
					{
						fishIDs = new String[0];
					}

					if ( coralIDs != null && coralIDs.length > 0 )
					{
						newArrayLenght = newArrayLenght + coralIDs.length;
					}
					else
					{
						coralIDs = new String[0];
					}

					if ( invertebrateIDs != null && invertebrateIDs.length > 0 )
					{
						newArrayLenght = newArrayLenght
								+ invertebrateIDs.length;
					}
					else
					{
						invertebrateIDs = new String[0];
					}

					String[] allObjects = new String[newArrayLenght];

					System.arraycopy(fishIDs, 0, allObjects, 0, fishIDs.length);
					System.arraycopy(coralIDs, 0, allObjects, fishIDs.length,
							coralIDs.length);
					System.arraycopy(invertebrateIDs, 0, allObjects,
							(fishIDs.length + coralIDs.length),
							invertebrateIDs.length);



					return DataManipulation.stringArraytoIntArray(allObjects);
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
				catch ( Exception e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}


	/**
	 * TODO - Description
	 */
	public static int databaseGetNumberOfObjectsInGroup(Connection con,
			String groupName)
	{
		if ( con != null && groupName != "" )
		{
			// If a group does exist with the same name as the given name
			if ( !(databaseGroupDoesNotExists(con, groupName)) )
			{
				ResultSet rs;
				String[] fishIDs = null;
				String fishIDsString = "";
				String[] coralIDs = null;
				String coralIDsString = "";
				String[] invertebrateIDs = null;
				String invertebrateIDsString = "";

				try
				{
					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectGroupTable
							+ " WHERE GroupName='" + groupName + "'";

					rs = stmt.executeQuery(query);
					while ( rs.next() )
					{
						// Delimiter
						String delimiter = ", ";

						// Gets all the ID's in the field as a string
						fishIDsString = rs.getString("GroupFishObjects");

						// Given string will be split by the argument delimiter
						// provided
						fishIDs = DataManipulation.stringToArray(fishIDsString,
								delimiter);

						// Gets all the ID's in the field as a string
						coralIDsString = rs.getString("GroupCoralObjects");

						// Given string will be split by the argument delimiter
						// provided
						coralIDs = DataManipulation.stringToArray(
								coralIDsString, delimiter);

						// Gets all the ID's in the field as a string
						invertebrateIDsString = rs
								.getString("GroupInvertebrateObjects");

						// Given string will be split by the argument delimiter
						// provided
						invertebrateIDs = DataManipulation.stringToArray(
								invertebrateIDsString, delimiter);
					}

					int lenght = 0;

					if ( fishIDs != null && fishIDs.length > 0 )
					{
						lenght += fishIDs.length;
					}

					if ( coralIDs != null && coralIDs.length > 0 )
					{
						lenght += coralIDs.length;
					}

					if ( invertebrateIDs != null && invertebrateIDs.length > 0 )
					{
						lenght += invertebrateIDs.length;
					}


					return lenght;
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
				catch ( Exception e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return -1;
	}


	/**
	 * TODO - Description
	 */
	public static AbstractObject[] databaseGetObjectsFromGroup(Connection con,
			String groupName, Class objectType)
	{
		if ( con != null && groupName != "" && objectType != null )
		{
			// If a group does exist with the same name as the given name
			if ( !(databaseGroupDoesNotExists(con, groupName)) )
			{
				ResultSet rs;

				// Gets the IDs of the objects contained in the group, depending
				// on the objectType
				int[] IDs = databaseGetGroupObjectIDs(con, groupName,
						objectType);

				if ( IDs != null && IDs.length > 0 )
				{
					String objectTable = "";
					String columnName = "";

					if ( objectType.equals(CoralObject.class) )
					{
						objectTable = coralObjectTable;
						columnName = "CoralObjectID";
					}
					else if ( objectType.equals(InvertebratesObject.class) )
					{
						objectTable = invertebrateObjectTable;
						columnName = "InvertebrateObjectID";
					}
					else if ( objectType.equals(FishObject.class) )
					{
						objectTable = fishObjectTable;
						columnName = "FishObjectID";
					}


					if ( objectTable != "" && columnName != "" )
					{
						try
						{
							ArrayList<AbstractObject> objects = new ArrayList<AbstractObject>();

							// Statement stmt = con.createStatement(
							// ResultSet.TYPE_SCROLL_INSENSITIVE,
							// ResultSet.CONCUR_READ_ONLY);
							Statement stmt = con.createStatement();

							String whereIDinString = IDs[0] + "";
							for ( int i = 1; i < IDs.length; i++ )
							{

								whereIDinString += "," + IDs[i];
							}

							String query = "SELECT * " + "FROM " + objectTable
									+ " WHERE " + columnName + " IN ("
									+ whereIDinString + ")";

							rs = stmt.executeQuery(query);

							while ( rs.next() )
							{
								AbstractObject tempObj = getObjectFromResultSet(
										con, rs, objectType);

								if ( tempObj != null )
								{
									objects.add(tempObj);
								}
							}

							return objects.toArray(new AbstractObject[0]);
						}
						catch ( SQLException e )
						{
							// if the error message is "out of memory",
							// it probably means no database file is found
							System.err.println(e.getMessage());
						}
						catch ( Exception e )
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}

		return null;
	}


	/**
	 * TODO - Description
	 */
	public static AbstractObject[] databaseGetObjectsFromGroup(Connection con,
			String groupName)
	{
		if ( con != null && groupName != "" )
		{
			// If a group does exist with the same name as the given name
			if ( !(databaseGroupDoesNotExists(con, groupName)) )
			{
				ResultSet rs;

				// Gets the IDs of the objects contained in the group, depending
				// on the objectType
				int[] IDs = databaseGetGroupObjectIDs(con, groupName);

				if ( IDs != null && IDs.length > 0 )
				{
					try
					{
						ArrayList<AbstractObject> objects = new ArrayList<AbstractObject>();

						// Statement stmt = con.createStatement(
						// ResultSet.TYPE_SCROLL_INSENSITIVE,
						// ResultSet.CONCUR_READ_ONLY);
						Statement stmt = con.createStatement();

						String whereIDinString = IDs[0] + "";
						for ( int i = 1; i < IDs.length; i++ )
						{
							whereIDinString += "," + IDs[i];
						}

						Class[] classes = { CoralObject.class,
								InvertebratesObject.class, FishObject.class };

						String[] objectTables = { coralObjectTable,
								invertebrateObjectTable, fishObjectTable };

						String[] columnNames = { "CoralObjectID",
								"InvertebrateObjectID", "FishObjectID" };


						for ( int i = 0; i < 3; i++ )
						{
							Class objectType = classes[i];
							String objectTable = objectTables[i];
							String columnName = columnNames[i];

							String query = "SELECT * " + "FROM " + objectTable
									+ " WHERE " + columnName + " IN ("
									+ whereIDinString + ")";


							rs = stmt.executeQuery(query);

							while ( rs.next() )
							{
								AbstractObject tempObj = getObjectFromResultSet(
										con, rs, objectType);

								if ( tempObj != null )
								{
									objects.add(tempObj);
								}
							}
						}

						return objects.toArray(new AbstractObject[0]);
					}
					catch ( SQLException e )
					{
						// if the error message is "out of memory",
						// it probably means no database file is found
						System.err.println(e.getMessage());
					}
					catch ( Exception e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// }
				}
			}
		}

		return null;
	}




	/**
	 * TODO - Description If either the given connection, group name object
	 * class is empty null will be returned. It also returns null if there is a
	 * {@link SQLException}.
	 */
	public static AbstractObject[] databaseGetObjectsFromTable(Connection con,
			Class objectType)
	{
		if ( con != null && objectType != null )
		{
			ResultSet rs;

			String objectTable = "";
			String columnName = "";

			if ( objectType.equals(CoralObject.class) )
			{
				objectTable = coralObjectTable;
				columnName = "CoralObjectID";
			}
			else if ( objectType.equals(InvertebratesObject.class) )
			{
				objectTable = invertebrateObjectTable;
				columnName = "InvertebrateObjectID";
			}
			else if ( objectType.equals(FishObject.class) )
			{
				objectTable = fishObjectTable;
				columnName = "FishObjectID";
			}


			if ( objectTable != "" && columnName != "" )
			{
				try
				{
					ArrayList<AbstractObject> objects = new ArrayList<AbstractObject>();

					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectTable;

					rs = stmt.executeQuery(query);

					while ( rs.next() )
					{
						AbstractObject tempObj = getObjectFromResultSet(con,
								rs, objectType);

						if ( tempObj != null )
						{
							objects.add(tempObj);
						}
					}

					return objects.toArray(new AbstractObject[0]);
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
				catch ( Exception e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}




	/**
	 * TODO - Description If either the given connection, group name object
	 * class is empty null will be returned. It also returns null if there is a
	 * {@link SQLException}.
	 */
	public static String[] databaseGetObjectNamesFromTable(Connection con,
			Class objectType)
	{
		if ( con != null && objectType != null )
		{
			ResultSet rs;

			String objectTable = "";
			String columnName = "";

			if ( objectType.equals(CoralObject.class) )
			{
				objectTable = coralObjectTable;
				columnName = "CoralObjectID";
			}
			else if ( objectType.equals(InvertebratesObject.class) )
			{
				objectTable = invertebrateObjectTable;
				columnName = "InvertebrateObjectID";
			}
			else if ( objectType.equals(FishObject.class) )
			{
				objectTable = fishObjectTable;
				columnName = "FishObjectID";
			}


			if ( objectTable != "" && columnName != "" )
			{
				try
				{
					ArrayList<String> objectNames = new ArrayList<String>();

					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectTable;

					rs = stmt.executeQuery(query);

					while ( rs.next() )
					{
						if ( objectType.equals(CoralObject.class) )
						{
							String genusString = rs.getString("Genus");
							String speciesString = rs.getString("Species");

							objectNames.add(DataRetrival.getToStringObject(
									genusString, speciesString));
						}
						else if ( objectType.equals(InvertebratesObject.class) )
						{
							String genusString = rs.getString("Genus");
							String speciesString = rs.getString("Species");

							objectNames.add(DataRetrival.getToStringObject(
									genusString, speciesString));
						}
						else if ( objectType.equals(FishObject.class) )
						{
							String genusString = rs.getString("Genus");
							String speciesString = rs.getString("Species");

							objectNames.add(DataRetrival.getToStringObject(
									genusString, speciesString));
						}
					}

					return objectNames.toArray(new String[0]);
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
				catch ( Exception e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}



	/**
	 * TODO - Description If either the given connection, group name object
	 * class is empty null will be returned. It also returns null if there is a
	 * {@link SQLException}.
	 */
	public static String[][] databaseGetObjectIDsandNamesFromTable(
			Connection con, Class objectType)
	{
		if ( con != null && objectType != null )
		{
			ResultSet rs;

			String objectTable = "";
			String columnName = "";

			if ( objectType.equals(CoralObject.class) )
			{
				objectTable = coralObjectTable;
				columnName = "CoralObjectID";
			}
			else if ( objectType.equals(InvertebratesObject.class) )
			{
				objectTable = invertebrateObjectTable;
				columnName = "InvertebrateObjectID";
			}
			else if ( objectType.equals(FishObject.class) )
			{
				objectTable = fishObjectTable;
				columnName = "FishObjectID";
			}


			if ( objectTable != "" && columnName != "" )
			{
				try
				{
					ArrayList<String> objectIDS = new ArrayList<String>();
					ArrayList<String> objectNames = new ArrayList<String>();

					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectTable;

					rs = stmt.executeQuery(query);

					while ( rs.next() )
					{
						if ( objectType.equals(CoralObject.class)
								|| objectType.equals(InvertebratesObject.class)
								|| objectType.equals(FishObject.class) )
						{
							// Gets the object ID(since the ID, aka Primary Key,
							// is located in the first index).
							int ID = rs.getInt(1);

							// Gets the object genus and species
							String genusString = rs.getString("Genus");
							String speciesString = rs.getString("Species");


							// Adds the ID
							objectIDS.add("" + ID);

							// Adds a possibly shortened version of the genus
							// and name
							objectNames.add(DataRetrival.getToStringObject(
									genusString, speciesString));
						}
					}

					// Creates arrays of the object IDs and genus/names
					String[] objIDarray = objectIDS.toArray(new String[0]);
					String[] objNameArray = objectNames.toArray(new String[0]);

					/**
					 * Only if the number of IDs gotten is the same the number
					 * of objects gotten will a new mulit-dim String array be
					 * created.
					 */
					if ( objIDarray.length == objNameArray.length )
					{
						// Creates the new multi-dim array
						String[][] data = new String[objIDarray.length][2];

						// Adds the id and name
						for ( int i = 0; i < objIDarray.length; i++ )
						{
							// Sets the ID
							data[i][0] = objIDarray[i];

							// Sets the obj name
							data[i][1] = objNameArray[i];
						}


						return data;
					}
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
				catch ( Exception e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}




	/**
	 * This function deletes all the tables inside the given connection., If the
	 * given connection is empty false will be returned. It also returns false
	 * if there is a {@link SQLException}.
	 */
	public static boolean databaseTablesDrop(Connection con)
	{
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("BEGIN;");
			statement.executeUpdate("DROP TABLE IF EXISTS " + fishCampaignTable
					+ ";");
			statement.executeUpdate("DROP TABLE IF EXISTS "
					+ invertebrateCampaignTable + ";");
			statement.executeUpdate("DROP TABLE IF EXISTS "
					+ coralCampaignTable + ";");
			statement.executeUpdate("DROP TABLE IF EXISTS " + fishObjectTable
					+ ";");
			statement.executeUpdate("DROP TABLE IF EXISTS "
					+ invertebrateObjectTable + ";");
			statement.executeUpdate("DROP TABLE IF EXISTS " + coralObjectTable
					+ ";");
			statement.executeUpdate("DROP TABLE IF EXISTS "
					+ invertebrateExclusionListTable + ";");
			statement.executeUpdate("DROP TABLE IF EXISTS "
					+ fishExclusionListTable + ";");
			statement.executeUpdate("DROP TABLE IF EXISTS " + objectGroupTable
					+ ";");
			statement.executeUpdate("DROP TABLE IF EXISTS "
					+ objectParametersTable + ";");
			statement.executeUpdate("DROP TABLE IF EXISTS " + popNamesTable
					+ ";");
			statement.executeUpdate("COMMIT;");
		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}

		return true;
	}


	// /**
	// * TODO - Description
	// */
	// public static boolean databaseAddObjectParameters(Connection con,
	// double[] sal, double[] ph, double[] gh, double[] kh, double[] temp,
	// double[] magnesium, double[] calcium, double spaceNeeded,
	// double[] othersSize)
	// {
	// return false;
	// }
	//
	// /**
	// * This function attempts to put the given values in
	// */
	// public static boolean databaseAddObjectParameters(Connection con,
	// int objParID, double[] sal, double[] ph, double[] gh, double[] kh,
	// double[] temp, double[] magnesium, double[] calcium,
	// double spaceNeeded, double[] othersSize)
	// {
	// return false;
	// }



	/**
	 * This function add the {@link ObjectParameters} contained inside the given
	 * {@link AbstractObject} into the ObjectParameters table in the database.
	 * If the given connection or given {@link AbstractObject} is empty false
	 * will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 */
	public static int databaseAddObjectParametersReturnID(Connection con,
			AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			int id = -1;

			ObjectParameters par = obj.getParameters();

			String parameters = "INSERT INTO " + objectParametersTable
					+ " VALUES (" + null + // No ID for the row
					", " + par.getSalinityLow() + // Salinity Low
					", " + par.getSalinityLow() + // Salinity High
					", " + par.getPHlow() + // PH Low
					", " + par.getPHhigh() + // PH High
					", " + par.getGHlow() + // GH Low
					", " + par.getGHhigh() + // GH High
					", " + par.getTemperatureLow() + // Temperature Low
					", " + par.getTemperatureHigh() + // Temperature High
					", " + par.getKhLow() + // KH Low
					", " + par.getKhHigh() + // KH High
					", " + par.getMagnesiumLow() + // Magnesium Low
					", " + par.getMagnesiumHigh() + // Magnesium High
					", " + par.getCalsiumLow() + // Calcium Low
					", " + par.getCalsiumHigh() + // Calcium High
					", " + par.getSpaceNeeded() + // Space Needed
					", " + par.getOthersSizeLow() + // Others Size Low
					", " + par.getOthersSizeHigh() + // Others Size High
					");";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(parameters,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					id = rs.getInt(1);
				}

				return id;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
			}
		}


		return -1;
	}



	/**
	 * This function add the {@link ObjectParameters} contained inside the given
	 * {@link AbstractObject} into the ObjectParameters table in the database.
	 * If the given connection or given {@link AbstractObject} is empty false
	 * will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 */
	public static boolean databaseAddObjectParameters(Connection con,
			AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			ObjectParameters par = obj.getParameters();

			String parameters = "INSERT INTO " + objectParametersTable
					+ " VALUES (" + null + // No ID for the row
					", " + par.getSalinityLow() + // Salinity Low
					", " + par.getSalinityLow() + // Salinity High
					", " + par.getPHlow() + // PH Low
					", " + par.getPHhigh() + // PH High
					", " + par.getGHlow() + // GH Low
					", " + par.getGHhigh() + // GH High
					", " + par.getTemperatureLow() + // Temperature Low
					", " + par.getTemperatureHigh() + // Temperature High
					", " + par.getKhLow() + // KH Low
					", " + par.getKhHigh() + // KH High
					", " + par.getMagnesiumLow() + // Magnesium Low
					", " + par.getMagnesiumHigh() + // Magnesium High
					", " + par.getCalsiumLow() + // Calcium Low
					", " + par.getCalsiumHigh() + // Calcium High
					", " + par.getSpaceNeeded() + // Space Needed
					", " + par.getOthersSizeLow() + // Others Size Low
					", " + par.getOthersSizeHigh() + // Others Size High
					");";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(parameters);

				statement.executeUpdate("COMMIT;");



				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}


		return false;
	}



	/**
	 * This function creates a PopNames row with the popular name 
	 * of the given {@link AbstractObject}. It returns the ID of the row created
	 * and -1 if any exceptions are thrown or the row is not created. 
	 */
	public static int databaseAddObjectPopName(Connection con,
			AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			int id = -1;

			String popName = obj.getPopulareName();

			String popNames = "INSERT INTO " + popNamesTable + " VALUES ("
					+ null + ", '" + popName + "'," + null + "," + null + ","
					+ null + ");";

			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(popNames,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					id = rs.getInt(1);
				}

				return id;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
			}
		}

		return -1;
	}



	/**
	 * This function adds the {@link FishExclusions} object inside the given
	 * {@link FishObject} object to the FishExclusionList table in the given
	 * database. If the given connection or given {@link FishObject} is empty
	 * false will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 */
	public static int databaseAddFishExclusionsListReturnID(Connection con,
			FishObject obj)
	{
		if ( con != null && obj != null )
		{
			int id = -1;

			FishExclusions ex = obj.getFishExclusions();

			String fishExclusiona = "INSERT INTO " + fishExclusionListTable
					+ " VALUES (" + null + ", " + ""
					+ ((ex.isAllAlone()) ? 1 : 0) + // Alone
					", " + ((ex.isAloneWithSpecies()) ? 1 : 0) + // Alone With
																	// Species
					", " + ((ex.isOnlyOneInSpecies()) ? 1 : 0) + // Only one in
																	// Species
					", " + ((ex.isOnlyOneMale()) ? 1 : 0) + // Only one male
					", " + ((ex.isOnlyOneFemale()) ? 1 : 0) + // Only one female
					", " + ex.getOnlyOneMalePerLiter() + // Only one male per
															// liter
					", " + ex.getOnlyOneFemalePerLiter() + // Only one female
															// per liter
					", " + ex.getOnlyOneFishPerLiter() + // Only one fish per
															// liter
					", " + ex.getMinumimFemalesPerMale() + // Min number of
															// female per male
					", " + ex.getMinumimMalesPerFemale() + // Min number of male
															// per female
					", " + ex.getMinimumSchoolSize() + // Min school size
					", '" + ex.getOnlyCompatibleWith() + // Only compatible with
					"', '" + ex.getNotCompatibleWith() + // Not compatible with
															// fish
					"', '" + ex.getNotCompatibleWithTheseMales() + // Not
																	// compatible
																	// with
																	// these
																	// males
					"', '" + ex.getNotCompatibleWithTheseFemales() + // Not
																		// compatible
																		// with
																		// these
																		// females
					"', '" + ex.getReefSafeString() + // Reef safe
					"');";

			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(fishExclusiona,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					id = rs.getInt(1);
				}

				return id;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
			}
		}

		return -1;
	}



	/**
	 * This function adds the {@link FishExclusions} object inside the given
	 * {@link FishObject} object to the FishExclusionList table in the given
	 * database. If the given connection or given {@link FishObject} is empty
	 * false will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 */
	public static boolean databaseAddFishExclusionsList(Connection con,
			FishObject obj)
	{
		if ( con != null && obj != null )
		{

			FishExclusions ex = obj.getFishExclusions();

			String fishExclusiona = "INSERT INTO " + fishExclusionListTable
					+ " VALUES (" + ex.getFishExclusionID() + ", " + ""
					+ ((ex.isAllAlone()) ? 1 : 0) + // Alone
					", " + ((ex.isAloneWithSpecies()) ? 1 : 0) + // Alone With
																	// Species
					", " + ((ex.isOnlyOneInSpecies()) ? 1 : 0) + // Only one in
																	// Species
					", " + ((ex.isOnlyOneMale()) ? 1 : 0) + // Only one male
					", " + ((ex.isOnlyOneFemale()) ? 1 : 0) + // Only one female
					", " + ex.getOnlyOneMalePerLiter() + // Only one male per
															// liter
					", " + ex.getOnlyOneFemalePerLiter() + // Only one female
															// per liter
					", " + ex.getOnlyOneFishPerLiter() + // Only one fish per
															// liter
					", " + ex.getMinumimFemalesPerMale() + // Min number of
															// female per male
					", " + ex.getMinumimMalesPerFemale() + // Min number of male
															// per female
					", " + ex.getMinimumSchoolSize() + // Min school size
					", '" + ex.getOnlyCompatibleWith() + // Only compatible with
					"', '" + ex.getNotCompatibleWith() + // Not compatible with
															// fish
					"', '" + ex.getNotCompatibleWithTheseMales() + // Not
																	// compatible
																	// with
																	// these
																	// males
					"', '" + ex.getNotCompatibleWithTheseFemales() + // Not
																		// compatible
																		// with
																		// these
																		// females
					"', '" + ex.getReefSafeString() + // Reef safe
					"');";

			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(fishExclusiona);

				statement.executeUpdate("COMMIT;");


				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}

		return false;
	}



	/**
	 * This function adds a new empty row into the FishExclusionList table in
	 * the database. This function should mainly be used when wanting to create
	 * a new FishExclusion for a fish. If the given connection is empty -1 will
	 * be returned. It also returns -1 if there is a {@link SQLException}.
	 */
	public static int databaseAddNewEmptyFishExclusionsList(Connection con)
	{
		int fishExID = -1;

		if ( con != null )
		{
			String fishExclusiona = "INSERT INTO " + fishExclusionListTable
					+ " VALUES (" + null + // No Id is set. The ID will be
											// returned.
					", " + 0 + // Alone
					", " + 0 + // Alone With Species
					", " + 0 + // Only one in Species
					", " + 0 + // Only one male
					", " + 0 + // Only one female
					", " + 0 + // Only one male per liter
					", " + 0 + // Only one female per liter
					", " + 0 + // Only one fish per liter
					", " + 0 + // Min number of female per male
					", " + 0 + // Min number of male per female
					", " + 0 + // Min school size
					", '" + null + // Only compatible with
					"', '" + null + // Not compatible with fish
					"', '" + null + // Not compatible with these males
					"', '" + null + // Not compatible with these females
					"', '" + CoralTypes.LargePolipedCoral.toString() + // Reef
																		// safe
					"');";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(fishExclusiona,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					fishExID = rs.getInt(1);
				}
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return -1;
			}
		}

		return fishExID;
	}


	/**
	 * This function adds a new empty row into the InvertebrateExclusionList
	 * table in the database. This function should mainly be used when wanting
	 * to create a new {@link InvertebrateExclusions} for a fish. If the given
	 * connection is empty -1 will be returned. It also returns -1 if there is a
	 * {@link SQLException}.
	 */
	public static int databaseAddNewEmptyInvertebrateExclusionsList(
			Connection con)
	{
		int inExID = -1;

		if ( con != null )
		{
			String fishExclusiona = "INSERT INTO "
					+ invertebrateExclusionListTable + " VALUES (" + null + // No
																			// Id
																			// is
																			// set.
																			// The
																			// ID
																			// will
																			// be
																			// returned.
					", " + 0 + // Only one in Species
					", " + 0 + // Only one fish per liter
					", '" + null + // Only compatible with
					"', '" + null + // Not compatible with fish
					"');";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(fishExclusiona,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					inExID = rs.getInt(1);
				}
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return -1;
			}
		}

		return inExID;
	}




	/**
	 * This function adds a new empty row into the InvertebrateExclusionList
	 * table in the database. This function should mainly be used when wanting
	 * to create a new InvertebrateExclusion for a invertebrates. If the given
	 * connection or given {@link InvertebratesObject} is empty false will be
	 * returned. It also returns false if there is a {@link SQLException}.
	 */
	public static int databaseAddInvertebrateExclusionsListReturnID(
			Connection con, InvertebratesObject obj)
	{
		if ( con != null && obj != null )
		{
			int id = -1;

			InvertebrateExclusions ex = obj.getExclusions();

			String fishExclusiona = "INSERT INTO "
					+ invertebrateExclusionListTable + " VALUES (" + null
					// Only one in Species
					+ ", " + ((ex.isOnlyOneInSpecies()) ? 1 : 0) +
					// Only one fish per liter
					", " + ex.getOnlyOneInvertebratePerLiter() +
					// Only compatible with
					", '" + ex.getOnlyCompatibleWith() +
					// Not compatible with fish
					"', '" + ex.getNotCompatibleWith() + "');";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(fishExclusiona,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					id = rs.getInt(1);
				}

				return id;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
			}
		}

		return -1;
	}




	/**
	 * This function adds a new empty row into the InvertebrateExclusionList
	 * table in the database. This function should mainly be used when wanting
	 * to create a new InvertebrateExclusion for a invertebrates. If the given
	 * connection or given {@link InvertebratesObject} is empty false will be
	 * returned. It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddInvertebrateExclusionsList(Connection con,
			InvertebratesObject obj)
	{
		if ( con != null && obj != null )
		{
			InvertebrateExclusions ex = obj.getExclusions();

			String fishExclusiona = "INSERT INTO "
					+ invertebrateExclusionListTable + " VALUES ("
					+ ex.getInvertebrateExclusionID() + ", "
					+ ((ex.isOnlyOneInSpecies()) ? 1 : 0) + // Only one in
															// Species
					", " + ex.getOnlyOneInvertebratePerLiter() + // Only one
																	// fish per
																	// liter
					", '" + ex.getOnlyCompatibleWith() + // Only compatible with
					"', '" + ex.getNotCompatibleWith() + // Not compatible with
															// fish
					"');";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(fishExclusiona);
				statement.executeUpdate("COMMIT;");

				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}

		return false;
	}



	/**
	 * This function adds a new empty row into the PopNames table in the database. 
	 * This function should mainly be used when wanting
	 * to create a new row in the PopNames for an object. If the given
	 * connection is empty -1 will be returned. It also returns -1 if there is a
	 * {@link SQLException}.
	 */
	public static int databaseAddNewPopNamesReturnID(Connection con)
	{
		int popNamesID = -1;

		if ( con != null )
		{
			String popNamesCreationString = "INSERT INTO " + popNamesTable
					+ " VALUES (" + null + // No Id is set. The ID will be
											// returned.
					", " + null + // Only one in Species
					", " + null + // Only one fish per liter
					", " + null + // Only compatible with
					", " + null + // Not compatible with fish
					");";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(popNamesCreationString,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					popNamesID = rs.getInt(1);
				}
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return -1;
			}
		}

		return popNamesID;
	}



	/**
	 * This function adds a new empty row into the PopNames table in the database. 
	 * This function should mainly be used when wanting
	 * to create a new row in the PopNames for an object. If the given
	 * connection is empty -1 will be returned. It also returns -1 if there is a
	 * {@link SQLException}.
	 */
	public static int databaseAddNewPopNamesReturnID(Connection con, String name)
	{
		int popNamesID = -1;

		if ( con != null )
		{
			String popNamesCreationString = "INSERT INTO " + popNamesTable
					+ " VALUES (" + null + // No Id is set. The ID will be
											// returned.
					",'" + name + // Only one in Species
					"', " + null + // Only one fish per liter
					", " + null + // Only compatible with
					", " + null + // Not compatible with fish
					");";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(popNamesCreationString,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					popNamesID = rs.getInt(1);
				}
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return -1;
			}
		}

		return popNamesID;
	}




	/**
	 * This function attempts to update the PopNames row associated with the
	 * given {@link AbstractObject} with the popular name inside the given Object.
	 */
	public static boolean databaseUpdatePopNames(Connection con,
			AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			String getNewPopName = obj.getPopulareName();

			// Gets the ID of the PopNames row of the Object
			int popNameRowID = databaseGetObjectPopID(con, obj);


			// If the ID is not -1, which would indicate an error.
			if ( popNameRowID > -1 )
			{
				try
				{
					Statement statement = con.createStatement();
					statement.setQueryTimeout(30); // set timeout to 30 sec.

					String popUpdateString = "UPDATE " + popNamesTable
							+ " SET popName_NO='" + getNewPopName + "' WHERE "
							+ popNamesIDname + "=" + popNameRowID;

					statement.executeUpdate("BEGIN;");
					statement.executeUpdate(popUpdateString);
					statement.executeUpdate("COMMIT;");

					return true;
				}
				catch ( SQLException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		return false;
	}

	/**
	 * This function adds the given {@link FishObject} to the FishObject table
	 * in the database. The function also add the {@link FishExclusions} and
	 * {@link ObjectParameters} inside the given {@link FishObject} to the
	 * database. If the given connection or given {@link FishObject} is empty
	 * false will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 */
	public static boolean databaseAddFishObjectAndParametersAndExclusions(
			Connection con, FishObject obj)
	{
		if ( con != null && obj != null )
		{
			// TEST OF THE EXISTENS OF A OBJECT WITH THE SAME ID
			if ( databaseAbstractObjectExists(con, obj) )
			{
				return false;
			}


			int popNameID = databaseAddObjectPopName(con, obj);

			if ( popNameID == -1 )
			{
				return false;
			}


			// PARAMETERS

			int parIDyoung = databaseAddObjectParametersReturnID(con, obj);
			// Adds the objects parameters and returns false if it fails.
			if ( parIDyoung == -1 )
			{
				// Removes the previously made PopName row.
				databaseRemovePopNamesID(con, popNameID);
				return false;
			}


			int parIDadult = databaseAddObjectParametersReturnID(con, obj);
			// Adds the objects parameters and returns false if it fails.
			if ( parIDadult == -1 )
			{
				// Removes the previously made PopName row.
				databaseRemovePopNamesID(con, popNameID);

				// Removes the previously made young parameters row.
				databaseRemoveObjectParametersID(con, parIDyoung);
				return false;
			}


			// EXCLUSIONS

			int exIDyoung = databaseAddFishExclusionsListReturnID(con, obj);
			// Adds the FishExclusion and returns false if it fails.
			if ( exIDyoung == -1 )
			{
				// Removes the previously made PopName row.
				databaseRemovePopNamesID(con, popNameID);

				// Removes the previously made young parameters row.
				databaseRemoveObjectParametersID(con, parIDyoung);

				// Removes the previously made adult parameters row.
				databaseRemoveObjectParametersID(con, parIDadult);
				return false;
			}


			int exIDadult = databaseAddFishExclusionsListReturnID(con, obj);
			// Adds the FishExclusion and returns false if it fails.
			if ( exIDadult == -1 )
			{
				// Removes the previously made PopName row.
				databaseRemovePopNamesID(con, popNameID);

				// Removes the previously made young parameters row.
				databaseRemoveObjectParametersID(con, parIDyoung);

				// Removes the previously made adult parameters row.
				databaseRemoveObjectParametersID(con, parIDadult);

				// Removes the previously made young exclusions row.
				databaseRemoveFishExclusionID(con, exIDyoung);
				return false;
			}


			String fishObject = "INSERT INTO " + fishObjectTable + " VALUES ("
					+ null + // The ID of the object // + obj.getObjectID() +
					", '" + obj.getSpeciesName() + // Species Name
					"', '" + obj.getGenusName() + // Genus Name
					"', '" + obj.getDescription() + // Description
					"', '" + obj.getSize() + // Size
					"', '" + parIDyoung + // FishParametersIDyoung
					"', '" + parIDadult + // FishParametersIDadult
					"', '" + exIDyoung + // FishExclusionIDyoung
					"', '" + exIDadult + // FishExclusionIDadult
					"', '" + popNameID + // PopNamesID
					"');";

			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(fishObject,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					obj.setObjectID(rs.getInt(1));
				}

				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}

		return false;
	}

	/**
	 * This function adds the given {@link CoralObject} to the CoralObject table
	 * in the database. The function also add the {@link ObjectParameters}
	 * inside the given {@link CoralObject} to the database. If the given
	 * connection or given {@link CoralObject} is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddCoralObjectAndCoralParameters(
			Connection con, CoralObject obj)
	{
		if ( con != null && obj != null )
		{
			// TEST OF THE EXISTENS OF A OBJECT WITH THE SAME ID
			if ( databaseAbstractObjectExists(con, obj) )
			{
				return false;
			}


			int popNameID = databaseAddObjectPopName(con, obj);

			if ( popNameID == -1 )
			{
				return false;
			}

			int parID = databaseAddObjectParametersReturnID(con, obj);
			// Adds the objects parameters and returns false if it fails.
			if ( parID == -1 )
			{
				// Removes the previously made PopName row.
				databaseRemovePopNamesID(con, popNameID);
				return false;
			}

			String coralObjectRow = "INSERT INTO " + coralObjectTable
					+ " VALUES (" + null + // The ID of the object
					", '" + obj.getSpeciesName() + // Species Name
					"', '" + obj.getGenusName() + // Genus Name
					"', '" + obj.getDescription() + // Description
					"', '" + obj.getCoralType().toString() + // Type
					"', '" + parID + // FishParametersID
					"', '" + popNameID + // PopNamesID
					"');";

			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(coralObjectRow,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					obj.setObjectID(rs.getInt(1));
				}

				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}

		return false;
	}



	/**
	 * This function adds the given {@link InvertebratesObject} to the
	 * InvertebratesObject table in the database. The function also add the
	 * {@link InvertebrateExclusions} and {@link ObjectParameters} inside the
	 * given {@link InvertebratesObject} to the database. If the given
	 * connection or given {@link InvertebratesObject} is empty false will be
	 * returned. It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddInvertebrateObjectAndParametersAndExclusions(
			Connection con, InvertebratesObject obj)
	{
		if ( con != null && obj != null )
		{
			// TEST OF THE EXISTENS OF A OBJECT WITH THE SAME ID
			if ( databaseAbstractObjectExists(con, obj) )
			{
				return false;
			}


			int popNameID = databaseAddObjectPopName(con, obj);

			if ( popNameID == -1 )
			{
				return false;
			}


			int parID = databaseAddObjectParametersReturnID(con, obj);
			// Adds the objects parameters and returns false if it fails.
			if ( parID == -1 )
			{
				// Removes the previously made PopName row.
				databaseRemovePopNamesID(con, popNameID);
				return false;
			}


			int exID = databaseAddInvertebrateExclusionsListReturnID(con, obj);
			// Adds the invertebrates exclusions and returns false if it fails.
			if ( exID == -1 )
			{
				// Removes the previously made PopName row.
				databaseRemovePopNamesID(con, popNameID);

				// Removes the previously made PopName row.
				databaseRemoveObjectParametersID(con, parID);
				return false;
			}


			String invertebrateObjectRow = "INSERT INTO "
					+ invertebrateObjectTable + " VALUES (" + null + ", '"
					+ obj.getSpeciesName() + // Species Name
					"', '" + obj.getGenusName() + // Genus Name
					"', '" + obj.getDescription() + // Description
					"', '" + obj.getInvertebrateType() + // Type
					"', '" + parID + // FishParametersID
					"', '" + exID + // InvertebrateExclusionID
					"', '" + popNameID + // PopNamesID
					"');";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");

				statement.executeUpdate(invertebrateObjectRow,
						Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();

				statement.executeUpdate("COMMIT;");

				if ( rs.next() )
				{
					obj.setObjectID(rs.getInt(1));
				}

				return true;
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}

		return false;
	}



	/**
	 * This function attempts to retrieve a {@link CoralObject} from with the
	 * given ID from the database. If no row is found in the database a
	 * {@link ObjectIDnotFoundInDatabaseException} exception is thrown. If the
	 * given connection or given coralID is smaller then 1 null will be
	 * returned. It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static CoralObject databaseGetCoralObject(Connection con, int coralID)
			throws MoreTheOneResultObject, ObjectIDnotFoundInDatabaseException
	{
		CoralObject obj = null;

		if ( con != null && coralID > 0 )
		{
			ObjectParameters objParameter;

			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();
				String query = "SELECT * " + "FROM " + coralObjectTable
						+ " WHERE CoralObjectID=" + coralID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, coralID, query);

				while ( rs.next() )
				{
					obj = (CoralObject) getObjectFromResultSet(con, rs,
							CoralObject.class);
				}
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return obj;
	}


	/**
	 * This function attempts to retrieve a {@link InvertebratesObject} from
	 * with the given ID from the database. If no row is found in the database a
	 * {@link ObjectIDnotFoundInDatabaseException} exception is thrown. If the
	 * given connection or given invID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static InvertebratesObject databaseGetInvertebrateObject(
			Connection con, int invID) throws MoreTheOneResultObject,
			ObjectIDnotFoundInDatabaseException
	{
		InvertebratesObject obj = null;

		if ( con != null && invID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);

				Statement stmt = con.createStatement();
				String query = "SELECT * " + "FROM " + invertebrateObjectTable
						+ " WHERE InvertebrateObjectID=" + invID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, invID, query);


				while ( rs.next() )
				{
					obj = (InvertebratesObject) getObjectFromResultSet(con, rs,
							InvertebratesObject.class);
				}
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return obj;
	}



	/**
	 * This function attempts to retrieve a {@link InvertebratesObject} from
	 * with the given ID from the database. If no row is found in the database a
	 * {@link ObjectIDnotFoundInDatabaseException} exception is thrown. If the
	 * given connection or given invID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static FishObject databaseGetFishObject(Connection con, int fishID)
			throws MoreTheOneResultObject, ObjectIDnotFoundInDatabaseException
	{
		FishObject obj = null;

		if ( con != null && fishID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();
				String query = "SELECT * " + "FROM " + fishObjectTable
						+ " WHERE FishObjectID=" + fishID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, fishID, query);


				while ( rs.next() )
				{
					obj = (FishObject) getObjectFromResultSet(con, rs,
							FishObject.class);
				}

			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return obj;
	}





	/**
	 * This function attempts to retrieve a {@link InvertebratesObject} from
	 * with the given ID from the database. If no row is found in the database a
	 * {@link ObjectIDnotFoundInDatabaseException} exception is thrown. If the
	 * given connection or given invID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static AbstractObject databaseGetObject(Connection con, int ID,
			Class objectType) throws MoreTheOneResultObject,
			ObjectIDnotFoundInDatabaseException
	{
		if ( con != null && ID > 0 && objectType != null )
		{
			ResultSet rs;

			String objectTable = "";
			String columnName = "";

			if ( objectType.equals(CoralObject.class) )
			{
				objectTable = coralObjectTable;
				columnName = "CoralObjectID";
			}
			else if ( objectType.equals(InvertebratesObject.class) )
			{
				objectTable = invertebrateObjectTable;
				columnName = "InvertebrateObjectID";
			}
			else if ( objectType.equals(FishObject.class) )
			{
				objectTable = fishObjectTable;
				columnName = "FishObjectID";
			}


			if ( objectTable != "" && columnName != "" )
			{
				try
				{
					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + objectTable
							+ " WHERE " + columnName + "=" + ID;

					rs = stmt.executeQuery(query);


					// // Confirms only one row
					onlyOneResultSetRow(con, ID, query);


					while ( rs.next() )
					{
						return getObjectFromResultSet(con, rs, objectType);
					}
				}
				catch ( SQLException e )
				{
					// if the error message is "out of memory",
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
			}
		}

		return null;
	}




	/**
	 * TODO - Description
	 */
	private static AbstractObject getObjectFromResultSet(Connection con,
			ResultSet rs, Class objectType) throws MoreTheOneResultObject,
			ObjectIDnotFoundInDatabaseException, SQLException
	{

		// If the class type is a CoralObject
		if ( objectType.equals(CoralObject.class) )
		{
			// Gets the objects parameters
			ObjectParameters objParameter = databaseGetParameter(con,
					rs.getInt("ObjectParametersID"));

			// If the parameters object is not null
			if ( objParameter != null )
			{
				// Created a new object
				CoralObject obj = new CoralObject(rs.getInt("CoralObjectID"),
						rs.getString("Species"), rs.getString("Description"),
						CoralTypes.valueOf(rs.getString("CoralType")),
						objParameter);

				// Adds additional fields
				obj.setGenusName(rs.getString("Genus"));
				int popNameID = rs.getInt("PopNameID");

				// Adds the PopName
				String popName = databaseGetPopName(con, popNameID);
				if ( popName != null )
				{
					obj.setPopulareName(popName);
				}

				return obj;
			}
			else
			{
				System.out.println(objectParametersTable + " is null"
						+ objParameter == null);
			}
		}
		// If the class type is a InvertebrateObject
		else if ( objectType.equals(InvertebratesObject.class) )
		{
			// Gets the objects parameters
			ObjectParameters objParameter = databaseGetParameter(con,
					rs.getInt("ObjectParametersID"));

			// Gets the objects exclusions
			InvertebrateExclusions invEx = databaseGetInvertebrateExclusions(
					con, rs.getInt("InvertebrateExclusionID"));

			// If the parameters object and exclusions are not null
			if ( objParameter != null && invEx != null )
			{
				// Created a new object
				InvertebratesObject obj = new InvertebratesObject(
						rs.getInt("InvertebrateObjectID"),
						rs.getString("Species"), rs.getString("Description"),
						InvertebratesTypes.valueOf(rs
								.getString("InvertebratesType")), objParameter,
						invEx);

				// Adds additional fields
				obj.setGenusName(rs.getString("Genus"));
				int popNameID = rs.getInt("PopNameID");

				// Adds the PopName
				String popName = databaseGetPopName(con, popNameID);
				if ( popName != null )
				{
					obj.setPopulareName(popName);
				}

				return obj;
			}
			else
			{

				System.out.println(objectParametersTable + " is null"
						+ objParameter == null);
				System.out.println(invertebrateExclusionListTable + " is null"
						+ invEx == null);
			}
		}
		// If the class type is a FishObject
		else if ( objectType.equals(FishObject.class) )
		{
			// Gets the objects parameters
			ObjectParameters objParameter = databaseGetParameter(con,
					rs.getInt("ObjectParametersIDyoung"));

			// Gets the objects exclusions
			FishExclusions fishEx = databaseGetFishExclusions(con,
					rs.getInt("FishExclusionIDyoung"));

			// If the parameters object and exclusions are not null
			if ( objParameter != null && fishEx != null )
			{
				// Created a new object
				FishObject obj = new FishObject(rs.getInt("FishObjectID"),
						rs.getString("Species"), rs.getString("Description"),
						FishGender.UNISEX, rs.getDouble("Size"), objParameter,
						fishEx, FishAgeType.YOUNG);

				// Adds additional fields
				obj.setGenusName(rs.getString("Genus"));
				int popNameID = rs.getInt("PopNameID");

				// Adds the PopName
				String popName = databaseGetPopName(con, popNameID);
				if ( popName != null )
				{
					obj.setPopulareName(popName);
				}

				return obj;
			}
			else
			{
				System.out.println(objectParametersTable + " is null"
						+ objParameter == null);
				System.out
						.println(fishExclusionListTable + " is null" + fishEx == null);
			}
		}


		return null;
	}


	/**
	 * This function attempts to retrieve a {@link ObjectParameters} with the
	 * given ID from the database. If the given connection or given parID is
	 * smaller then 1 null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static ObjectParameters databaseGetParameter(Connection con,
			int parID) throws MoreTheOneResultObject,
			ObjectIDnotFoundInDatabaseException
	{
		ObjectParameters objParameter = null;

		if ( con != null && parID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM " + objectParametersTable
						+ " WHERE ObjectParametersID=" + parID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, parID, query);

				while ( rs.next() )
				{
					double[] sal = { rs.getDouble("SalinityLow"),
							rs.getDouble("SalinityHigh") };
					double[] ph = { rs.getDouble("PHLow"),
							rs.getDouble("PHHigh") };
					double[] gh = { rs.getDouble("GHLow"),
							rs.getDouble("GHHigh") };
					double[] temp = { rs.getDouble("TemperatureLow"),
							rs.getDouble("TemperatureHigh") };
					double[] kh = { rs.getDouble("KHLow"),
							rs.getDouble("KHHigh") };
					double[] magnesium = { rs.getDouble("MagnesiumLow"),
							rs.getDouble("MagnesiumHigh") };
					double[] calcium = { rs.getDouble("CalciumLow"),
							rs.getDouble("CalciumHigh") };
					double space = rs.getDouble("SpaceNeeded");
					double[] othersS = { rs.getDouble("OthersSizeLow"),
							rs.getDouble("OthersSizeHigh") };

					objParameter = new ObjectParameters(
							rs.getInt("ObjectParametersID"), sal, ph, gh, temp);
					objParameter.setKh(kh);
					objParameter.setMagnesium(magnesium);
					objParameter.setCalcium(calcium);
					objParameter.setSpaceNeeded(space);
					objParameter.setOthersSize(othersS);
				}// end while loop

			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find " + objectParametersTable
						+ " with ID:" + parID);
			}
		}


		return objParameter;
	}


	/**
	 * This function attempts to retrieve a {@link ObjectParameters} with the
	 * given ID from the database. If the given connection or given parID is
	 * smaller then 1 null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static int databaseGetParameterID(Connection con, AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			String objTable = "";
			String objIDcolumn = "";
			String objParIDcolumn = "";


			if ( obj instanceof FishObject )
			{
				FishObject fishObj = (FishObject) obj;

				objTable = fishObjectTable;
				objIDcolumn = fishObjectIDname;
				if ( fishObj.getFishAgeType().equals(FishAgeType.YOUNG) )
				{
					objParIDcolumn = "ObjectParametersIDyoung";
				}
				else if ( fishObj.getFishAgeType().equals(FishAgeType.YOUNG) )
				{
					objParIDcolumn = "ObjectParametersIDadult";
				}
			}
			else if ( obj instanceof CoralObject )
			{
				objTable = coralObjectTable;
				objIDcolumn = coralObjectIDname;
				objParIDcolumn = "ObjectParametersID";
			}
			else if ( obj instanceof InvertebratesObject )
			{
				objTable = invertebrateObjectTable;
				objIDcolumn = invertebrateObjectIDname;
				objParIDcolumn = "ObjectParametersID";
			}


			try
			{
				// GETTING THE FISH
				Statement stmt = con.createStatement();

				String objQuery = "SELECT * " + "FROM " + objTable + " WHERE "
						+ objIDcolumn + "=" + obj.getObjectID() + "";

				ResultSet rs = stmt.executeQuery(objQuery);

				// Confirms only one row
				onlyOneResultSetRow(con, obj.getObjectID(), objQuery);

				while ( rs.next() )
				{
					// GETTING THE PARAMETER ID
					return rs.getInt(objParIDcolumn);
				}
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find " + objectParametersTable
						+ " with ID:" + obj.getObjectID());
			}
			catch ( MoreTheOneResultObject e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return -1;
	}

	/**
	 * This function attempts to retrieve a {@link ObjectParameters} with the
	 * given ID from the database. If the given connection or given parID is
	 * smaller then 1 null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static ObjectParameters databaseGetParameter(Connection con,
			AbstractObject obj) throws MoreTheOneResultObject,
			ObjectIDnotFoundInDatabaseException
	{
		ObjectParameters objParameter = null;

		if ( con != null && obj != null )
		{
			int parID = -1;

			parID = databaseGetParameterID(con, obj);

			if ( parID > -1 )
			{
				try
				{
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM "
							+ objectParametersTable
							+ " WHERE ObjectParametersID=" + parID + "";

					ResultSet rs;
					rs = stmt.executeQuery(query);

					// Confirms only one row
					onlyOneResultSetRow(con, parID, query);

					while ( rs.next() )
					{
						double[] sal = { rs.getDouble("SalinityLow"),
								rs.getDouble("SalinityHigh") };
						double[] ph = { rs.getDouble("PHLow"),
								rs.getDouble("PHHigh") };
						double[] gh = { rs.getDouble("GHLow"),
								rs.getDouble("GHHigh") };
						double[] temp = { rs.getDouble("TemperatureLow"),
								rs.getDouble("TemperatureHigh") };
						double[] kh = { rs.getDouble("KHLow"),
								rs.getDouble("KHHigh") };
						double[] magnesium = { rs.getDouble("MagnesiumLow"),
								rs.getDouble("MagnesiumHigh") };
						double[] calcium = { rs.getDouble("CalciumLow"),
								rs.getDouble("CalciumHigh") };
						double space = rs.getDouble("SpaceNeeded");
						double[] othersS = { rs.getDouble("OthersSizeLow"),
								rs.getDouble("OthersSizeHigh") };

						objParameter = new ObjectParameters(
								rs.getInt("ObjectParametersID"), sal, ph, gh,
								temp);
						objParameter.setKh(kh);
						objParameter.setMagnesium(magnesium);
						objParameter.setCalcium(calcium);
						objParameter.setSpaceNeeded(space);
						objParameter.setOthersSize(othersS);
					}// end while loop

				}
				catch ( SQLException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Could not find "
							+ objectParametersTable + " with ID:" + parID);
				}
			}
		}


		return objParameter;
	}

	/**
	 * This function will attempt to find the PopNames row String that belongs to the given {@link AbstractObject}. 
	 * If the given connection or given {@link AbstractObject} is null, null will be returned. It also returns 
	 * null if there is a {@link SQLException}.
	 */
	public static String databaseGetPopName(Connection con, int rowID)
	{
		if ( con != null && rowID > -1 )
		{
			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				String getObjPopIDquery = "SELECT popName_NO " + "FROM "
						+ popNamesTable + " WHERE " + popNamesIDname + "="
						+ rowID;

				ResultSet rs = statement.executeQuery(getObjPopIDquery);


				// // Confirms only one row
				onlyOneResultSetRow(con, getObjPopIDquery, false);

				if ( rs.next() )
				{
					String name = (String) rs.getObject("popName_NO");
					return name;
				}
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find " + popNamesTable + " with "
						+ popNamesIDname + "=" + rowID);
			}
			catch ( MoreTheOneResultObject e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getMessage();
			}

		}


		return null;
	}


	/**
	 * This function attempts to find and return the PopNameID contains 
	 * within the {@link AbstractObject} given inside the database.
	 * 
	 * -1 is returned if anything goes wrong.
	 */
	public static int databaseGetObjectPopID(Connection con, AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			String objTable = "";
			String objIDcolumn = "";


			if ( obj instanceof FishObject )
			{
				objTable = fishObjectTable;
				objIDcolumn = "FishObjectID";
			}
			else if ( obj instanceof CoralObject )
			{
				objTable = coralObjectTable;
				objIDcolumn = "CoralObjectID";
			}
			else if ( obj instanceof InvertebratesObject )
			{
				objTable = invertebrateObjectTable;
				objIDcolumn = "InvertebrateObjectID";
			}

			try
			{
				Statement stmt = con.createStatement();
				String query = "SELECT * " + "FROM " + objTable + " WHERE "
						+ objIDcolumn + "=" + obj.getObjectID() + "";

				ResultSet rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, obj.getObjectID(), query);

				while ( rs.next() )
				{
					// GETTING THE PARAMETER ID
					return rs.getInt("PopNameID");
				}
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch ( MoreTheOneResultObject e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return -1;
	}


	/**
	 * This function attempts to retrieve a {@link ObjectParameters} with the
	 * given ID from the database. If the given connection or given parID is
	 * smaller then 1 null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static boolean databaseParameterExists(Connection con, long parID)
	{
		if ( con != null && parID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM " + objectParametersTable
						+ " WHERE ObjectParametersID=" + parID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				return onlyOneResultSetRow(rs, true);
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find " + objectParametersTable
						+ " with ID:" + parID);
			}
		}


		return false;
	}



	/**
	 * This function attempts to get a {@link FishExclusions} with the given ID
	 * from the database. If the given connection or given exID is smaller then
	 * 1 null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static boolean databaseFishExclusionsExists(Connection con, long exID)
	{
		if ( con != null && exID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM " + fishExclusionListTable
						+ " WHERE FishExclusionID=" + exID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				return onlyOneResultSetRow(rs, true);
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find " + fishExclusionListTable
						+ " with ID:" + exID);
			}
		}


		return false;
	}


	/**
	 * This function attempts to find a {@link FishExclusions} with the given ID
	 * in the database. If the given connection or given exID is smaller then 1
	 * null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static FishExclusions databaseGetFishExclusions(Connection con,
			int exID) throws MoreTheOneResultObject,
			ObjectIDnotFoundInDatabaseException
	{
		FishExclusions ex = null;

		if ( con != null && exID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM " + fishExclusionListTable
						+ " WHERE FishExclusionID=" + exID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, exID, query);


				while ( rs.next() )
				{
					boolean alone = ((rs.getInt("Alone") != 0) ? true : false);
					boolean AloneWithFamily = ((rs.getInt("AloneWithFamily") != 0) ? true
							: false);
					boolean OnlyOneInFamily = ((rs.getInt("OnlyOneInFamily") != 0) ? true
							: false);
					boolean OnlyOneMale = ((rs.getInt("OnlyOneMale") != 0) ? true
							: false);
					boolean OnlyOneFemale = ((rs.getInt("OnlyOneFemale") != 0) ? true
							: false);
					int OnlyOneMalePerLiter = rs.getInt("OnlyOneMalePerLiter");
					int OnlyOneFemalePerLiter = rs
							.getInt("OnlyOneFemalePerLiter");
					int OnlyOneFishPerLiter = rs.getInt("OnlyOneFishPerLiter");
					int MinimumNumberOfFemalesPerMale = rs
							.getInt("MinimumNumberOfFemalesPerMale");
					int MinimumNumberOfMalesPerFemale = rs
							.getInt("MinimumNumberOfMalesPerFemale");
					int MinimumSchoolSize = rs.getInt("MinimumSchoolSize");
					String OnlyCompatibleWith = rs
							.getString("OnlyCompatibleWith");
					String NotCompatibleWith = rs
							.getString("NotCompatibleWith");
					String NotCompatibleWithTheseMales = rs
							.getString("NotCompatibleWithTheseMales");
					String NotCompatibleWithTheseFemales = rs
							.getString("NotCompatibleWithTheseFemales");
					String NotReefSafe = rs.getString("NotReefSafe");


					ex = new FishExclusions(exID);
					ex.setAllAlone(alone);
					ex.setAloneWithFamily(AloneWithFamily);
					ex.setOnlyOneInFamily(OnlyOneInFamily);
					ex.setOnlyOneMale(OnlyOneMale);
					ex.setOnlyOneFemale(OnlyOneFemale);
					ex.setOnlyOneMalePerLiter(OnlyOneMalePerLiter);
					ex.setOnlyOneFemalePerLiter(OnlyOneFemalePerLiter);
					ex.setOnlyOneFishPerLiter(OnlyOneFishPerLiter);
					ex.setMinumimFemalesPerMale(MinimumNumberOfFemalesPerMale);
					ex.setMinumimMalesPerFemale(MinimumNumberOfMalesPerFemale);
					ex.setMinimumSchoolSize(MinimumSchoolSize);
					ex.setOnlyCompatibleWith(OnlyCompatibleWith);
					ex.setNotCompatibleWith(NotCompatibleWith);
					ex.setNotCompatibleWithTheseMales(NotCompatibleWithTheseMales);
					ex.setNotCompatibleWithTheseFemales(NotCompatibleWithTheseFemales);
					ex.setReefSafeString(NotReefSafe);
				}// end while loop

			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find " + fishExclusionListTable
						+ " with ID:" + exID);
			}
		}


		return ex;
	}



	// /**
	// * This function attempts to find and return the ID of the
	// * {@link AbstractObject} with the given objectID. It will automatically
	// * determine what table to look in depending on what kind of
	// * {@link AbstractObject} it is passed.
	// */
	// public static int databaseGetFishExclusionsID(Connection con)
	// {
	//
	// }


	/**
	 * This function attempts to get a {@link InvertebrateExclusions} with the
	 * given ID from the database. If the given connection or given exID is
	 * smaller then 1 null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static boolean databaseInvertebrateExclusionsExists(Connection con,
			long exID)
	{
		if ( con != null && exID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM "
						+ invertebrateExclusionListTable
						+ " WHERE InvertebrateExclusionID=" + exID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				return onlyOneResultSetRow(rs, true);
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find "
						+ invertebrateExclusionListTable + " with ID:" + exID);
			}
		}


		return false;
	}



	/**
	 * This function attempts to get an row ID with the given 
	 * {@link AbstractObject} from the database. If the given connection
	 * or given {@link AbstractObject} is smaller then -1 will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static int databaseGetInvertebrateExclusionsID(Connection con,
			InvertebratesObject obj)
	{
		if ( con != null && obj != null )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM " + invertebrateObjectTable
						+ " WHERE " + invertebrateObjectIDname + "="
						+ obj.getObjectID();

				ResultSet rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, obj.getObjectID(), query);

				while ( rs.next() )
				{
					return rs.getInt("InvertebrateExclusionID");
				}

			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find "
						+ invertebrateExclusionListTable + " with ID:"
						+ obj.getObjectID());
			}
			catch ( MoreTheOneResultObject e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return -1;
	}



	/**
	 * This function attempts to get a {@link InvertebrateExclusions} with the
	 * given ID from the database. If the given connection or given exID is
	 * smaller then 1 null will be returned. It also returns false if there is a
	 * {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static InvertebrateExclusions databaseGetInvertebrateExclusions(
			Connection con, int exID) throws MoreTheOneResultObject
	{
		InvertebrateExclusions ex = null;

		if ( con != null && exID > 0 )
		{
			try
			{
				// Statement stmt = con.createStatement(
				// ResultSet.TYPE_SCROLL_INSENSITIVE,
				// ResultSet.CONCUR_READ_ONLY);
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM "
						+ invertebrateExclusionListTable
						+ " WHERE InvertebrateExclusionID=" + exID + "";

				ResultSet rs;
				rs = stmt.executeQuery(query);

				// Confirms only one row
				onlyOneResultSetRow(con, exID, query);


				while ( rs.next() )
				{
					boolean OnlyOneInFamily = ((rs.getInt("OnlyOneInFamily") != 0) ? true
							: false);
					int OnlyOneInvertebratePerLiter = rs
							.getInt("OnlyOneInvertebratePerLiter");
					String OnlyCompatibleWith = rs
							.getString("OnlyCompatibleWith");
					String NotCompatibleWith = rs
							.getString("NotCompatibleWith");


					ex = new InvertebrateExclusions(exID);
					ex.setOnlyOneInSpecies(OnlyOneInFamily);
					ex.setOnlyOneInvertebratePerLiter(OnlyOneInvertebratePerLiter);
					ex.setOnlyCompatibleWith(OnlyCompatibleWith);
					ex.setNotCompatibleWith(NotCompatibleWith);
				}// end while loop

			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find "
						+ invertebrateExclusionListTable + " with ID:" + exID);
			}
		}


		return ex;
	}



	/**
	 * This function attempts to
	 * 
	 * @throws MoreTheOneResultObject
	 * @throws SQLException
	 */
	public static void onlyOneResultSetRow(Connection con, int ID, String query)
			throws MoreTheOneResultObject, SQLException
	{
		if ( con != null && ID > 0 )
		{
			ResultSet rs;

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(query);

			boolean foundOne = false;
			while ( rs.next() )
			{
				if ( foundOne )
				{
					rs.close();
					throw new MoreTheOneResultObject(ID, con.getMetaData()
							.getURL());
				}

				foundOne = true;
			}

			rs.close();
		}
	}


	/**
	 * This function attempts to
	 * 
	 * @throws MoreTheOneResultObject
	 * @throws SQLException
	 */
	public static boolean onlyOneResultSetRow(ResultSet rs, boolean close)
			throws SQLException
	{
		if ( rs != null )
		{
			boolean foundOne = false;
			while ( rs.next() )
			{
				if ( foundOne )
				{
					return false;
				}

				foundOne = true;
			}

			if ( close )
			{
				rs.close();
			}

			return true;
		}

		return false;
	}



	/**
	 * This function attempts to
	 * 
	 * @throws MoreTheOneResultObject
	 * @throws SQLException
	 */
	public static void onlyOneResultSetRow(Connection con, String query,
			boolean close) throws MoreTheOneResultObject, SQLException
	{
		if ( con != null && query != null && query.equals("") )
		{
			ResultSet rs;

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(query);

			boolean foundOne = false;
			while ( rs.next() )
			{
				if ( foundOne )
				{
					if ( close )
					{
						rs.close();
					}
					throw new MoreTheOneResultObject(query, con.getMetaData()
							.getURL());
				}

				foundOne = true;
			}

			if ( close )
			{
				rs.close();
			}
		}
	}


	/**
	 * This function attempts to
	 * 
	 * @throws MoreTheOneResultObject
	 * @throws SQLException
	 */
	public static void onlyOneResultSetRow(Connection con, String name,
			String query) throws MoreTheOneResultObject, SQLException
	{
		if ( con != null && name != null && name != "" )
		{
			ResultSet rs;

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(query);

			boolean foundOne = false;
			while ( rs.next() )
			{
				if ( foundOne )
				{
					rs.close();
					throw new MoreTheOneResultObject(name, con.getMetaData()
							.getURL());
				}

				foundOne = true;
			}

			rs.close();
		}
	}


	/**
	 * This function attempts to
	 * 
	 * @throws MoreTheOneResultObject
	 * @throws SQLException
	 */
	public static boolean noResultSetRow(ResultSet rs, boolean close)
			throws SQLException
	{
		boolean found = false;
		if ( rs != null )
		{
			while ( rs.next() )
			{
				found = true;
			}

			if ( close )
			{
				rs.close();
			}
		}


		return found;
	}


	/**
	 * TODO - Description
	 * 
	 * @throws ObjectAlreadyInDatabaseException
	 * @throws SQLException
	 */
	public static void databaseContainsSpecies(Connection con, String species,
			String table) throws ObjectAlreadyInDatabaseException, SQLException
	{
		if ( con != null && table != "" )
		{
			ResultSet rs = null;

			try
			{
				Statement stmt = con.createStatement();

				String query = "SELECT * FROM " + table + " WHERE Species='"
						+ species + "'";

				rs = stmt.executeQuery(query);
				while ( rs.next() )
				{
					rs.close();
					throw new ObjectAlreadyInDatabaseException(species, con
							.getMetaData().getURL());
				}
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			rs.close();
		}
	}



	/**
	 * This function attempts to find and verify if a Group 
	 * exists in the database with the given name.
	 * 
	 * @return Boolean on whether there exists a Group in 
	 * the database with the given name.
	 */
	public static boolean databaseGroupDoesNotExists(Connection con,
			String groupName)
	{
		if ( con != null && groupName != "" )
		{
			ResultSet rs = null;

			try
			{
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM " + objectGroupTable
						+ " WHERE GroupName='" + groupName + "'";

				rs = stmt.executeQuery(query);
				while ( rs.next() )
				{
					return false;
				}


				rs.close();
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return false;
		}


		return true;
	}



	/**
	 * This function attempts to find and verify if a Group 
	 * exists in the database with the given ID.
	 * 
	 * @return Boolean on whether there exists a Group in 
	 * the database with the given ID.
	 */
	public static boolean databaseGroupDoesNotExists(Connection con, int ID)
	{
		if ( con != null && ID > 0 )
		{
			ResultSet rs = null;

			try
			{
				Statement stmt = con.createStatement();

				String query = "SELECT * " + "FROM " + objectGroupTable
						+ " WHERE ObjectGroupID=" + ID;

				rs = stmt.executeQuery(query);
				while ( rs.next() )
				{
					return false;
				}


				rs.close();
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return false;
		}


		return true;
	}



	/**
	 * This function attempts to find and verify if there exists an Object
	 * in the database that matches the given {@link AbstractObject},
	 * especially in regards to the object ID.
	 * 
	 */
	public static boolean databaseAbstractObjectExists(Connection con,
			AbstractObject object)
	{
		if ( con != null && object != null )
		{
			String table = "";
			String IDcolumn = "";

			if ( object instanceof FishObject )
			{
				table = fishObjectTable;
				IDcolumn = "FishObjectID";
			}
			else if ( object instanceof CoralObject )
			{
				table = coralObjectTable;
				IDcolumn = "CoralObjectID";
			}
			else if ( object instanceof InvertebratesObject )
			{
				table = invertebrateObjectTable;
				IDcolumn = "InvertebrateObjectID";
			}

			if ( table != "" )
			{
				try
				{
					// Statement stmt = con.createStatement(
					// ResultSet.TYPE_SCROLL_INSENSITIVE,
					// ResultSet.CONCUR_READ_ONLY);
					Statement stmt = con.createStatement();

					String query = "SELECT * " + "FROM " + table + " WHERE "
							+ IDcolumn + "=" + object.getObjectID();

					ResultSet rs;
					rs = stmt.executeQuery(query);

					// Confirms only one row
					return noResultSetRow(rs, true);
				}
				catch ( Exception e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		return false;
	}


	/**
	 * This function attempts to find and return the 
	 * corresponding {@link ObjectParameters} of the given 
	 * {@link FishObject} based on the {@link FishAgeType} given.
	 * 
	 * NULL is returned if anything goes wrong.
	 */
	public static ObjectParameters databaseGetFishParameters(Connection con,
			FishObject obj, FishAgeType age)
	{
		if ( con != null && obj != null && age != null )
		{
			int parID = -1;
			String parColName = "";

			if ( age.equals(FishAgeType.YOUNG) )
			{
				parColName = "ObjectParametersIDyoung";
			}
			else if ( age.equals(FishAgeType.ADULT) )
			{
				parColName = "ObjectParametersIDadult";
			}

			// If the age was either young or adult.
			if ( !parColName.equals("") )
			{
				try
				{
					// GETTING THE FISH
					Statement stmt = con.createStatement();

					String Fishquery = "SELECT * " + "FROM " + fishObjectTable
							+ " WHERE FishObjectID=" + obj.getObjectID() + "";

					ResultSet rs = stmt.executeQuery(Fishquery);

					// Confirms only one row
					onlyOneResultSetRow(con, obj.getObjectID(), Fishquery);


					while ( rs.next() )
					{
						// GETTING THE PARAMETER ID
						parID = rs.getInt(parColName);


						// GETTING THE OBJECTPARAMETER
						return databaseGetParameter(con, parID);
					}
				}
				catch ( SQLException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch ( MoreTheOneResultObject e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch ( ObjectIDnotFoundInDatabaseException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// If anything goes wrong.
		return null;
	}


	/**
	 * This function attempts to find and return the 
	 * corresponding {@link FishExclusions} of the given 
	 * {@link FishObject} based on the {@link FishAgeType} given.
	 * 
	 * NULL is returned if anything goes wrong.
	 */
	public static FishExclusions databaseGetFishExclusions(Connection con,
			FishObject obj, FishAgeType age)
	{
		if ( con != null && obj != null && age != null )
		{
			int exID = -1;
			String exColName = "";

			if ( age.equals(FishAgeType.YOUNG) )
			{
				exColName = "FishExclusionIDYoung";
			}
			else if ( age.equals(FishAgeType.ADULT) )
			{
				exColName = "FishExclusionIDAdult";
			}

			// If the age was either young or adult.
			if ( !exColName.equals("") )
			{
				try
				{
					// GETTING THE FISH
					Statement stmt = con.createStatement();

					String Fishquery = "SELECT * " + "FROM " + fishObjectTable
							+ " WHERE FishObjectID=" + obj.getObjectID() + "";

					ResultSet rs = stmt.executeQuery(Fishquery);

					// Confirms only one row
					onlyOneResultSetRow(con, obj.getObjectID(), Fishquery);

					while ( rs.next() )
					{
						// GETTING THE PARAMETER ID
						exID = rs.getInt(exColName);


						// GETTING THE OBJECTPARAMETER
						return databaseGetFishExclusions(con, exID);
					}
				}
				catch ( SQLException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch ( MoreTheOneResultObject e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch ( ObjectIDnotFoundInDatabaseException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// If anything goes wrong.
		return null;
	}

}
