/**
 * 
 */
package exceptions;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class ObjectIDnotFoundInDatabaseException extends Exception
{
	/**
	 * The ID of the object that was searched for in the database.
	 */
	private int objectID;


	/**
	 * The string of the object that was searched for in the database.
	 */
	private String objectString;


	/**
	 * The location of the database searched.
	 */
	private String databaseName;


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param ID
	 */
	public ObjectIDnotFoundInDatabaseException(String name, String database)
	{
		objectString = name;
		databaseName = database;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param ID
	 */
	public ObjectIDnotFoundInDatabaseException(int ID, String database)
	{
		objectID = ID;
		databaseName = database;
	}



	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		String output = "";
		if ( objectString == null )
		{
			output = "No Object with the ID: " + objectID
					+ " in the database: " + databaseName;
		}
		else
		{
			output = "No Object with the string indicator: " + objectString
					+ " in the database: " + databaseName;
		}

		return output;
	}
}
