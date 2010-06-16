package sqlLogic;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import coreObjects.ObjectParameters;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;


public class SQLfunctions
{
	/**
	 * TODO - Description
	 */
	public static boolean databaseStatementExecution(Connection con, String statementString)
	{
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("BEGIN;");
			statement.executeUpdate(statementString);
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
	 * TODO - Description
	 */
	public static boolean databaseTablesDrop(Connection con)
	{
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("BEGIN;");
			statement.executeUpdate("DROP TABLE IF EXISTS FishObject;");
			statement.executeUpdate("DROP TABLE IF EXISTS FishExclusionList;");
			statement.executeUpdate("DROP TABLE IF EXISTS FishGroup;");
			statement.executeUpdate("DROP TABLE IF EXISTS ObjectParameters;");
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
	
	
	
	public static boolean databaseAddFishObjectParameters(Connection con, FishObject obj)
	{
		ObjectParameters par = obj.getParameters();
		
		String fishParameters = 
			"INSERT INTO ObjectParameters " +
				"VALUES (" + par.getObjectParametersID() + ", " +
				"" + par.getSalinityLow() + // Salinity Low
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
		
		
			System.out.println(fishParameters);
		
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("BEGIN;");
			
			statement.executeUpdate(fishParameters);
			
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
	
	
	
	public static boolean databaseAddFishExclusionsList(Connection con, FishObject obj)
	{
		FishExclusions ex = obj.getFishExclusions();
		
		String fishExclusiona = 
			"INSERT INTO FishExclusionList " +
				"VALUES (" + ex.getFishExclusionID() + ", " +
				"" + ((ex.isAllAlone())?1:0) + // Alone
				", " + ((ex.isAloneWithSpecies())?1:0) + // Alone With Species
				", " + ((ex.isOnlyOneInSpecies())?1:0) + // Only one in Species
				", " + ((ex.isOnlyOneMale())?1:0) + // Only one male
				", " + ((ex.isOnlyOneFemale())?1:0) + // Only one female
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
		
		
			System.out.println(fishExclusiona);
		
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("BEGIN;");
			
			statement.executeUpdate(fishExclusiona);
			
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
	
	
	
	public static boolean databaseAddFishObject(Connection con , FishObject obj)
	{
		System.out.println(con.getClass());
		
		String fishExclusiona = 
			"INSERT INTO FishObject " +
//				"VALUES (" + null + ", " + //obj.getFishID() + ", " +
				"VALUES (" + obj.getFishID() + ", " +
				"'" + obj.getPopulareName() + // Common name
				"', '" + obj.getSpeciesName() + // Species Name
				"', '" + obj.getGenusName() + // Genus Name
				"', '" + obj.getDescription() + // Description
				"', '" + obj.getSize() + // Size
				"', '" + obj.getFishGender().toString() + // Gender
				"', '" + obj.getParameters().getObjectParametersID() + // FishParametersID
				"', '" + obj.getFishExclusions().getFishExclusionID() + // FishExclusionID
				"');";
		
		
			System.out.println(fishExclusiona);
		
		try
		{
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("BEGIN;");
			
			statement.executeUpdate(fishExclusiona);
			
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
}
