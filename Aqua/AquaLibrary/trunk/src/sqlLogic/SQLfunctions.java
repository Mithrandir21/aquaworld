package sqlLogic;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLfunctions
{
	/**
	 * TODO - Description
	 */
	public static boolean databaseCreation(Connection con, String tables)
	{
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate(tables);
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
	 * TODO - Description
	 */
	public static boolean databaseTruncate(Connection con)
	{
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("DROP TABLE IF EXISTS FishObject;");
			statement.executeUpdate("DROP TABLE IF EXISTS FishExclusionList;");
			statement.executeUpdate("DROP TABLE IF EXISTS FishGroup;");
			statement.executeUpdate("DROP TABLE IF EXISTS ObjectParameters;");
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
}
