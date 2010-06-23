package sqlLogic;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logistical.DataManipulation;
import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;
import coreObjects.Coral.CoralObject;
import coreObjects.Coral.CoralObject.CoralTypes;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;
import coreObjects.Fish.FishObject.FishGender;
import coreObjects.Invertebrates.InvertebrateExclusions;
import coreObjects.Invertebrates.InvertebratesObject;
import coreObjects.Invertebrates.InvertebratesObject.InvertebratesTypes;
import exceptions.ObjectAlreadyInDatabaseException;
import exceptions.ObjectIDnotFoundInDatabaseException;


public class SQLfunctions
{
	public static String objectParametersTable = "ObjectParameters";

	public static String fishExclusionListTable = "FishExclusionList";

	public static String objectGroupTable = "ObjectGroup";

	public static String invertebrateExclusionListTable = "InvertebrateExclusionList";

	public static String fishCampaignTable = "FishCampaign";

	public static String invertebrateCampaignTable = "InvertebrateCampaign";

	public static String coralCampaignTable = "CoralCampaign";

	public static String coralObjectTable = "CoralObject";

	public static String invertebrateObjectTable = "InvertebrateObject";

	public static String fishObjectTable = "FishObject";


	/**
	 * This function attempts to run the given string as a statement on the given database.
	 * 
	 * If either the the given connection is null or the string is "" false will be returned.
	 * It also returns false if there is a {@link SQLException}.
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
	 * Attempts to remove the the row in the ObjectParameters table with the given ID.
	 */
	public static boolean databaseRemoveObjectParametersID(Connection con,
			int ID)
	{
		return databaseRemoveFromTableWithID(con, objectParametersTable,
				"ObjectParametersID", ID);
	}


	/**
	 * Attempts to remove the the row in the FishExclusionList table with the given ID.
	 */
	public static boolean databaseRemoveFishExclusionID(Connection con, int ID)
	{
		return databaseRemoveFromTableWithID(con, fishExclusionListTable,
				"FishExclusionID", ID);
	}



	/**
	 * This function removes a row with the given Unique ID(int)
	 * from the table with the given name.
	 * 
	 * If either the connection is null, ID is below 1 or the table string is "", the function returns false.
	 * It also returns false if there is a {@link SQLException}.
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
	 * This function attempts to create a new ObjectGroup in the given
	 * database with the given name and description.
	 * 
	 * If either the given connection, group name or description is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddGroup(Connection con, String groupName,
			String groupDescription)
	{
		if ( con != null && groupName != "" && groupDescription != "" )
		{
			String parameters = "INSERT INTO " + objectGroupTable + " VALUES ("
					+ null + ", '" + groupName // The name of the group
					+ "', '" + groupDescription // The description of the group
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
			}
			catch ( SQLException e )
			{
				// if the error message is "out of memory",
				// it probably means no database file is found
				System.err.println(e.getMessage());
				return false;
			}
		}

		return true;
	}


	/**
	 * this function attempts to add the ID(int) of the given {@link AbstractObject} to the ObjectGroup in the database with the
	 * same name as the given group name.
	 * 
	 * If either the given connection, group name or description is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
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

						// Given string will be split by the argument delimiter provided
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
	 * This function deletes all the tables inside the given connection.,
	 * 
	 * If the given connection is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
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


	/**
	 * This function add the {@link ObjectParameters} contained inside the given {@link AbstractObject} into the ObjectParameters
	 * table in the database.
	 * 
	 * If the given connection or given {@link AbstractObject} is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddObjectParameters(Connection con,
			AbstractObject obj)
	{
		if ( con != null && obj != null )
		{
			ObjectParameters par = obj.getParameters();

			String parameters = "INSERT INTO " + objectParametersTable
					+ " VALUES (" + par.getObjectParametersID() + ", " + ""
					+ par.getSalinityLow() + // Salinity Low
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
	 * This function adds the {@link FishExclusions} object inside the given {@link FishObject} object to the FishExclusionList
	 * table in the given database.
	 * 
	 * If the given connection or given {@link FishObject} is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
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
					", " + ((ex.isAloneWithSpecies()) ? 1 : 0) + // Alone With Species
					", " + ((ex.isOnlyOneInSpecies()) ? 1 : 0) + // Only one in Species
					", " + ((ex.isOnlyOneMale()) ? 1 : 0) + // Only one male
					", " + ((ex.isOnlyOneFemale()) ? 1 : 0) + // Only one female
					", " + ex.getOnlyOneMalePerLiter() + // Only one male per liter
					", " + ex.getOnlyOneFemalePerLiter() + // Only one female per liter
					", " + ex.getOnlyOneFishPerLiter() + // Only one fish per liter
					", " + ex.getMinumimFemalesPerMale() + // Min number of female per male
					", " + ex.getMinumimMalesPerFemale() + // Min number of male per female
					", " + ex.getMinimumSchoolSize() + // Min school size
					", '" + ex.getOnlyCompatibleWith() + // Only compatible with
					"', '" + ex.getNotCompatibleWith() + // Not compatible with fish
					"', '" + ex.getNotCompatibleWithTheseMales() + // Not compatible with these males
					"', '" + ex.getNotCompatibleWithTheseFemales() + // Not compatible with these females
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
	 * This function adds a new empty row into the FishExclusionList table in the database.
	 * This function should mainly be used when wanting to create a new FishExclusion for a fish.
	 * 
	 * If the given connection is empty -1 will be returned.
	 * It also returns -1 if there is a {@link SQLException}.
	 */
	public static int databaseAddNewEmptyFishExclusionsList(Connection con)
	{
		int fishExID = -1;

		if ( con != null )
		{
			String fishExclusiona = "INSERT INTO " + fishExclusionListTable
					+ " VALUES (" + null + // No Id is set. The ID will be returned.
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
					"', '" + CoralTypes.LargePolipedCoral.toString() + // Reef safe
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
	 * This function adds a new empty row into the InvertebrateExclusionList table in the database.
	 * This function should mainly be used when wanting to create a new InvertebrateExclusion for a invertebrates.
	 * 
	 * If the given connection or given {@link InvertebratesObject} is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
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
					+ ((ex.isOnlyOneInSpecies()) ? 1 : 0) + // Only one in Species
					", " + ex.getOnlyOneInvertebratePerLiter() + // Only one fish per liter
					", '" + ex.getOnlyCompatibleWith() + // Only compatible with
					"', '" + ex.getNotCompatibleWith() + // Not compatible with fish
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
	 * This function adds the given {@link FishObject} to the FishObject table in the database.
	 * The function also add the {@link FishExclusions} and {@link ObjectParameters} inside the given {@link FishObject} to the
	 * database.
	 * 
	 * If the given connection or given {@link FishObject} is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddFishObjectAndParametersAndExclusions(
			Connection con, FishObject obj)
	{
		if ( con != null && obj != null )
		{
			// Adds the objects parameters
			databaseAddObjectParameters(con, obj);

			// Adds the FishExclusion
			databaseAddFishExclusionsList(con, obj);

			String fishObject = "INSERT INTO " + fishObjectTable + " VALUES ("
					+ obj.getObjectID() // The ID of the object
					+ ", " + "'" + obj.getPopulareName() + // Common name
					"', '" + obj.getSpeciesName() + // Species Name
					"', '" + obj.getGenusName() + // Genus Name
					"', '" + obj.getDescription() + // Description
					"', '" + obj.getSize() + // Size
					"', '" + obj.getParameters().getObjectParametersID() + // FishParametersID
					"', '" + obj.getFishExclusions().getFishExclusionID() + // FishExclusionID
					"');";

			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(fishObject);
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
	 * This function adds the given {@link CoralObject} to the CoralObject table in the database.
	 * The function also add the {@link ObjectParameters} inside the given {@link CoralObject} to the
	 * database.
	 * 
	 * If the given connection or given {@link CoralObject} is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddCoralObjectAndCoralParameters(
			Connection con, CoralObject obj)
	{
		if ( con != null && obj != null )
		{
			// Adds the objects parameters
			databaseAddObjectParameters(con, obj);

			String coralObjectRow = "INSERT INTO " + coralObjectTable
					+ " VALUES (" + obj.getObjectID() + // The ID of the object
					", '" + obj.getPopulareName() + // Common name
					"', '" + obj.getSpeciesName() + // Species Name
					"', '" + obj.getGenusName() + // Genus Name
					"', '" + obj.getDescription() + // Description
					"', '" + obj.getCoralType().toString() + // Type
					"', '" + obj.getParameters().getObjectParametersID() + // FishParametersID
					"');";

			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(coralObjectRow);
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
	 * This function adds the given {@link InvertebratesObject} to the InvertebratesObject table in the database.
	 * The function also add the {@link InvertebrateExclusions} and {@link ObjectParameters} inside the given
	 * {@link InvertebratesObject} to the
	 * database.
	 * 
	 * If the given connection or given {@link InvertebratesObject} is empty false will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static boolean databaseAddInvertebrateObjectAndParametersAndExclusions(
			Connection con, InvertebratesObject obj)
	{
		if ( con != null && obj != null )
		{
			// Adds the objects parameters
			databaseAddObjectParameters(con, obj);

			// Adds the invertebrates exclusions
			databaseAddInvertebrateExclusionsList(con, obj);

			String invertebrateObjectRow = "INSERT INTO "
					+ invertebrateObjectTable + " VALUES (" + obj.getObjectID()
					+ ", " + "'" + obj.getPopulareName() + // Common name
					"', '" + obj.getSpeciesName() + // Species Name
					"', '" + obj.getGenusName() + // Genus Name
					"', '" + obj.getDescription() + // Description
					"', '" + obj.getInvertebrateType() + // Type
					"', '" + obj.getParameters().getObjectParametersID() + // FishParametersID
					"', '" + obj.getExclusions().getInvertebrateExclusionID() + // InvertebrateExclusionID
					"');";


			try
			{
				Statement statement = con.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.

				statement.executeUpdate("BEGIN;");
				statement.executeUpdate(invertebrateObjectRow);
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
	 * This function attempts to retrieve a {@link CoralObject} from with the given ID from the database.
	 * 
	 * If no row is found in the database a {@link ObjectIDnotFoundInDatabaseException} exception is thrown.
	 * 
	 * If the given connection or given coralID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static CoralObject databaseGetCoralObject(Connection con, int coralID)
			throws ObjectIDnotFoundInDatabaseException
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
					objParameter = databaseGetParameter(con, rs
							.getInt("ObjectParametersID"));

					if ( objParameter != null )
					{
						obj = new CoralObject(rs.getInt("CoralObjectID"), rs
								.getString("Species"), rs
								.getString("Description"), CoralTypes
								.valueOf(rs.getString("CoralType")),
								objParameter);
					}
					else
					{
						System.out.println(objectParametersTable + " is null"
								+ objParameter == null);
					}

				}// end while loop
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
	 * This function attempts to retrieve a {@link InvertebratesObject} from with the given ID from the database.
	 * 
	 * If no row is found in the database a {@link ObjectIDnotFoundInDatabaseException} exception is thrown.
	 * 
	 * If the given connection or given invID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 */
	public static InvertebratesObject databaseGetInvertebrateObject(
			Connection con, int invID)
			throws ObjectIDnotFoundInDatabaseException
	{
		InvertebratesObject obj = null;

		if ( con != null && invID > 0 )
		{
			ObjectParameters objParameter;
			InvertebrateExclusions invEx;

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
					objParameter = databaseGetParameter(con, rs
							.getInt("ObjectParametersID"));

					invEx = databaseGetInvertebrateExclusions(con, rs
							.getInt("InvertebrateExclusionID"));

					if ( objParameter != null && invEx != null )
					{
						obj = new InvertebratesObject(rs
								.getInt("InvertebrateObjectID"), rs
								.getString("Species"), rs
								.getString("Description"), InvertebratesTypes
								.valueOf(rs.getString("InvertebratesType")),
								objParameter, invEx);
					}
					else
					{

						System.out.println(objectParametersTable + " is null"
								+ objParameter == null);
						System.out.println(invertebrateExclusionListTable
								+ " is null" + invEx == null);
					}
				}// end while loop
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
	 * This function attempts to retrieve a {@link InvertebratesObject} from with the given ID from the database.
	 * 
	 * If no row is found in the database a {@link ObjectIDnotFoundInDatabaseException} exception is thrown.
	 * 
	 * If the given connection or given invID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static FishObject databaseGetFishObject(Connection con, int fishID)
			throws ObjectIDnotFoundInDatabaseException
	{
		FishObject obj = null;

		if ( con != null && fishID > 0 )
		{
			ObjectParameters objParameter;
			FishExclusions fishEx;

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
					objParameter = databaseGetParameter(con, rs
							.getInt("ObjectParametersID"));

					fishEx = databaseGetFishExclusions(con, rs
							.getInt("FishExclusionID"));

					if ( objParameter != null && fishEx != null )
					{

						obj = new FishObject(rs.getInt("FishObjectID"), rs
								.getString("Species"), rs
								.getString("Description"), FishGender.UNISEX,
								rs.getDouble("Size"), objParameter, fishEx);

					}
					else
					{
						System.out.println(objectParametersTable + " is null"
								+ objParameter == null);
						System.out.println(fishExclusionListTable + " is null"
								+ fishEx == null);
						// return null;
					}

				}// end while loop

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
	 * This function attempts to retrieve a {@link ObjectParameters} with the given ID from the database.
	 * 
	 * If the given connection or given parID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static ObjectParameters databaseGetParameter(Connection con,
			int parID) throws ObjectIDnotFoundInDatabaseException
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
					double[] magnesium = { rs.getDouble("MagnesiumLow"),
							rs.getDouble("MagnesiumHigh") };
					double[] calcium = { rs.getDouble("CalciumLow"),
							rs.getDouble("CalciumHigh") };
					double space = rs.getDouble("SpaceNeeded");
					double[] othersS = { rs.getDouble("OthersSizeLow"),
							rs.getDouble("OthersSizeHigh") };

					objParameter = new ObjectParameters(rs
							.getInt("ObjectParametersID"), sal, ph, gh, temp);
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
	 * This function attempts to get a {@link FishExclusions} with the given ID from the database.
	 * 
	 * If the given connection or given exID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static FishExclusions databaseGetFishExclusions(Connection con,
			int exID) throws ObjectIDnotFoundInDatabaseException
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
					ex
							.setNotCompatibleWithTheseMales(NotCompatibleWithTheseMales);
					ex
							.setNotCompatibleWithTheseFemales(NotCompatibleWithTheseFemales);
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




	/**
	 * This function attempts to get a {@link InvertebrateExclusions} with the given ID from the database.
	 * 
	 * If the given connection or given exID is smaller then 1 null will be returned.
	 * It also returns false if there is a {@link SQLException}.
	 * 
	 * @throws ObjectIDnotFoundInDatabaseException
	 */
	public static InvertebrateExclusions databaseGetInvertebrateExclusions(
			Connection con, int exID)
			throws ObjectIDnotFoundInDatabaseException
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
					ex
							.setOnlyOneInvertebratePerLiter(OnlyOneInvertebratePerLiter);
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
	 */
	public static void onlyOneResultSetRow(Connection con, int ID, String query)
			throws ObjectIDnotFoundInDatabaseException, SQLException
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
					throw new ObjectIDnotFoundInDatabaseException(ID, con
							.getMetaData().getURL());
				}

				foundOne = true;
			}

			rs.close();
		}
	}



	/**
	 * TODO - Description
	 * 
	 * @throws ObjectAlreadyInDatabaseException
	 * @throws SQLException
	 */
	public static void databaseContainsObject(Connection con, String species,
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
}
