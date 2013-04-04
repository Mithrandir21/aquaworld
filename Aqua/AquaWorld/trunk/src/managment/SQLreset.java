/**
 * 
 */
package managment;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sqlLogic.SQLfunctions;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class SQLreset
{

	/**
	 * TODO - Description
	 */
	public static void main(String[] args)
	{
		long start = System.nanoTime();


		System.out.println("Starting");


		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch ( ClassNotFoundException e1 )
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection connection = null;
		try
		{
			// String url = "jdbc:mysql://localhost/aquaworld";
			// String user = "aquaworld";
			// String pass = "";
			//
			// // String url = "jdbc:mysql://db4free.net:3306/aquaworld";
			// // String user = "";
			// // String pass = "";
			// // create a database connection
			// connection = DriverManager.getConnection(url, user, pass);
			// File invExFile = new File(
			// "./resource/database/MySQLstatements/MySQL_InvertebrateExclusionList.txt");
			// File fishExFile = new File(
			// "./resource/database/MySQLstatements/MySQL_FishExclusionList.txt");
			// File objectGroupFile = new File(
			// "./resource/database/MySQLstatements/MySQL_ObjectGroup.txt");
			// File objectParFile = new File(
			// "./resource/database/MySQLstatements/MySQL_ObjectParameters.txt");
			// File popNamesFile = new File(
			// "./resource/database/MySQLstatements/MySQL_PopNames.txt");
			// File fishObjectFile = new File(
			// "./resource/database/MySQLstatements/MySQL_FishObject.txt");
			// File invertebrateObjectFile = new File(
			// "./resource/database/MySQLStatements/MySQL_InvertebrateObject.txt");
			// File coralObjectFile = new File(
			// "./resource/database/MySQLStatements/MySQL_CoralObject.txt");
			// File fishCampaignFile = new File(
			// "./resource/database/MySQLStatements/MySQL_FishCampaign.txt");
			// File coralCampaignFile = new File(
			// "./resource/database/MySQLStatements/MySQL_CoralCampaign.txt");
			// File invertebrateCampaignFile = new File(
			// "./resource/database/MySQLStatements/MySQL_InvertebrateCampaign.txt");
			// // File alterFile = new File(
			// // "./resource/database/MySQLstatements/MySQL_ALTER.txt");


			connection = DriverManager.getConnection("jdbc:sqlite:Fish.db");
			File invExFile = new File(
					"./resource/database/SQLiteStatements/SQLite_InvertebrateExclusionList.txt");
			File fishExFile = new File(
					"./resource/database/SQLiteStatements/SQLite_FishExclusionList.txt");
			File objectGroupFile = new File(
					"./resource/database/SQLiteStatements/SQLite_ObjectGroup.txt");
			File objectParFile = new File(
					"./resource/database/SQLiteStatements/SQLite_ObjectParameters.txt");
			File fishObjectFile = new File(
					"./resource/database/SQLiteStatements/SQLite_FishObject.txt");
			File invertebrateObjectFile = new File(
					"./resource/database/SQLiteStatements/SQLite_InvertebrateObject.txt");
			File coralObjectFile = new File(
					"./resource/database/SQLiteStatements/SQLite_CoralObject.txt");
			File fishCampaignFile = new File(
					"./resource/database/SQLiteStatements/SQLite_FishCampaign.txt");
			File coralCampaignFile = new File(
					"./resource/database/SQLiteStatements/SQLite_CoralCampaign.txt");
			File invertebrateCampaignFile = new File(
					"./resource/database/SQLiteStatements/SQLite_InvertebrateCampaign.txt");
			// File alterFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_ALTER.txt");



			SQLfunctions.databaseTablesDrop(connection);

			// InvertebrateExclusion
			String invExString = IOmanagment.getSQLtableString(invExFile);
			SQLfunctions.databaseStatementExecution(connection, invExString);

			// FishExclusion
			String fishExString = IOmanagment.getSQLtableString(fishExFile);
			SQLfunctions.databaseStatementExecution(connection, fishExString);

			// // PopNames
			// String popNamesString =
			// IOmanagment.getSQLtableString(popNamesFile);
			// SQLfunctions.databaseStatementExecution(connection,
			// popNamesString);

			// FishGroup
			String fishGroupString = IOmanagment
					.getSQLtableString(objectGroupFile);
			SQLfunctions
					.databaseStatementExecution(connection, fishGroupString);

			// ObjectParameters
			String objParString = IOmanagment.getSQLtableString(objectParFile);
			SQLfunctions.databaseStatementExecution(connection, objParString);

			// FishObject
			String fishObjectString = IOmanagment
					.getSQLtableString(fishObjectFile);
			SQLfunctions.databaseStatementExecution(connection,
					fishObjectString);

			// InvertebrateObject
			String invertebrateObjectString = IOmanagment
					.getSQLtableString(invertebrateObjectFile);
			SQLfunctions.databaseStatementExecution(connection,
					invertebrateObjectString);

			// CoralObject
			String coralObjectString = IOmanagment
					.getSQLtableString(coralObjectFile);
			SQLfunctions.databaseStatementExecution(connection,
					coralObjectString);

			// FishCampaing
			String fishCampaignString = IOmanagment
					.getSQLtableString(fishCampaignFile);
			SQLfunctions.databaseStatementExecution(connection,
					fishCampaignString);

			// InvertebrateCampaign
			String invertebrateCampaignString = IOmanagment
					.getSQLtableString(invertebrateCampaignFile);
			SQLfunctions.databaseStatementExecution(connection,
					invertebrateCampaignString);

			// CoralCampaign
			String coralCampaignString = IOmanagment
					.getSQLtableString(coralCampaignFile);
			SQLfunctions.databaseStatementExecution(connection,
					coralCampaignString);

			// ALTER
			// String alterString = IOmanagment.getSQLtableString(alterFile);
			// SQLfunctions.databaseStatementExecution(connection, alterString);


		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
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

		System.out.println("Ending");
		long elapsedTime = System.nanoTime() - start;
		System.out.println(elapsedTime);
		System.exit(0);
	}

}
