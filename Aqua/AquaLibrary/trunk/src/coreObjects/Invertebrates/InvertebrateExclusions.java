/**
 * 
 */
package coreObjects.Invertebrates;


import java.util.Random;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class InvertebrateExclusions
{
	/**
	 * The ID of any given instance of this class.
	 */
	private int InvertebrateExclusionID;


	/**
	 * Whether or not there can only be one from this species of invertebrate in any
	 * given tank.
	 */
	private boolean onlyOneInSpecies;


	/**
	 * How many liters of water can hold one invertebrate from this invertebrate family.
	 */
	private int onlyOneFishPerLiter;


	/**
	 * The objects that are compatible with this invertebrate. The syntax for the string
	 * must be ID's separated by a comma.
	 * If this has any content(is not ""), the variable notCompatibleWith will be NULL.
	 */
	private String onlyCompatibleWith = "";


	/**
	 * The objects that are NOT compatible with this invertebrate. The syntax for the
	 * string must be ID's separated by a comma.
	 * If this has any content(is not ""), the variable onlyCompatibleWith
	 * will be NULL.
	 */
	private String notCompatibleWith = "";






	/**
	 * A default constructor for this class that also produces the classes ID.
	 */
	public InvertebrateExclusions()
	{
		// Default seed comes from system time.
		Random r = new Random();

		InvertebrateExclusionID = r.nextInt();
	}



	/**
	 * A constructor for this class that sets the ID for the class.
	 * <i>(Should normally be used when initiating a new instance of this class
	 * from previously saved instances, like from a database or from
	 * imports.)</i>
	 * 
	 * @param ID
	 *            The ID of this class.
	 */
	public InvertebrateExclusions(int ID)
	{
		InvertebrateExclusionID = ID;
	}




	// GETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the invertebrateExclusionID
	 */
	public int getInvertebrateExclusionID()
	{
		return InvertebrateExclusionID;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyOneInSpecies
	 */
	public boolean isOnlyOneInSpecies()
	{
		return onlyOneInSpecies;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyOneFishPerLiter
	 */
	public int getOnlyOneInvertebratePerLiter()
	{
		return onlyOneFishPerLiter;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyCompatibleWith
	 */
	public String getOnlyCompatibleWith()
	{
		return onlyCompatibleWith;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the notCompatibleWith
	 */
	public String getNotCompatibleWith()
	{
		return notCompatibleWith;
	}



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyOneInSpecies
	 *            the onlyOneInSpecies to set
	 */
	public void setOnlyOneInSpecies(boolean onlyOneInSpecies)
	{
		this.onlyOneInSpecies = onlyOneInSpecies;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyOneFishPerLiter
	 *            the onlyOneFishPerLiter to set
	 */
	public void setOnlyOneInvertebratePerLiter(int onlyOneFishPerLiter)
	{
		this.onlyOneFishPerLiter = onlyOneFishPerLiter;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyCompatibleWith
	 *            the onlyCompatibleWith to set
	 */
	public void setOnlyCompatibleWith(String onlyCompatibleWith)
	{
		this.onlyCompatibleWith = onlyCompatibleWith;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param notCompatibleWith
	 *            the notCompatibleWith to set
	 */
	public void setNotCompatibleWith(String notCompatibleWith)
	{
		this.notCompatibleWith = notCompatibleWith;
	}
}
