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
public class ObjectAlreadyInDatabaseException extends Exception
{
	/**
	 * The species name of the object that was searched for in the database.
	 */
	private String speciesName;


	/**
	 * The location of the database searched.
	 */
	private String databaseName;


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param ID
	 */
	public ObjectAlreadyInDatabaseException(String speciesName, String database)
	{
		this.speciesName = speciesName;
		databaseName = database;
	}



	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		String output = "An object already exists with the given species name: "
				+ speciesName + " in the database: " + databaseName;

		return output;
	}
}
