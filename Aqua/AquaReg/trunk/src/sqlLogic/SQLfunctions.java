package sqlLogic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLfunctions
{
	public static boolean databaseCreation(Connection con)
	{
		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch ( ClassNotFoundException e1 )
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection connection = null;
		try
		{
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:Fish.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("drop table if exists person");
			statement
					.executeUpdate("create table person (id integer, name string)");
		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}
		finally
		{
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


		return true;
	}
}
