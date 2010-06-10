package coreObjects.Fish;


import java.util.Random;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FishExclusions
{
	/**
	 * The ID of any given instance of this class.
	 */
	private long FishExclusionID;



	/**
	 * Whether or not the fish has to be completely alone in the tank.
	 */
	private boolean allAlone;


	/**
	 * Whether or not the fish can only be placed in a tank with fish from his
	 * family.
	 */
	private boolean aloneWithFamily;


	/**
	 * Whether or not there can only be one from this family of fish in any
	 * given tank.
	 */
	private boolean onlyOneInFamily;


	/**
	 * Whether or not there can only be one male from this fishes family in any
	 * given tank.
	 */
	private boolean onlyOneMale;


	/**
	 * Whether or not there can only be one female from this fishes family in
	 * any given tank.
	 */
	private boolean onlyOneFemale;


	/**
	 * How many liters of water can hold one male from this fishes family.
	 */
	private int onlyOneMalePerLiter;


	/**
	 * How many liters of water can hold one female from this fishes family.
	 */
	private int onlyOneFemalePerLiter;


	/**
	 * The minimum number of females per male in a tank.
	 */
	private int MinumimFemalesPerMale;


	/**
	 * The minimum number of males per female in a tank.
	 */
	private int MinumimMalesPerFemale;


	/**
	 * The minimum size of the school of fish this fish requires.
	 */
	private int minimumSchoolSize;


	/**
	 * The objects that are compatible with this fish. The syntax for the string
	 * must be ID's separated by a comma.
	 * 
	 * If this has any content(is not NULL), the variable notCompatibleWith will be NULL.
	 */
	private String onlyCompatibleWith;


	/**
	 * The objects that are NOT compatible with this fish. The syntax for the
	 * string must be ID's separated by a comma.
	 * 
	 * If this has any content(is not NULL), the variable onlyCompatibleWith
	 * will be NULL.
	 */
	private String notCompatibleWith;


	/**
	 * The male fish that are NOT compatible with this fish. The syntax for the
	 * string must be ID's separated by a comma.
	 */
	private String notCompatibleWithTheseMales;


	/**
	 * The female fish that are NOT compatible with this fish. The syntax for
	 * the string must be ID's separated by a comma.
	 */
	private String notCompatibleWithTheseFemales;


	/**
	 * A default constructor for this class that also produces the classes ID.
	 */
	public FishExclusions()
	{
		// Default seed comes from system time.
		Random r = new Random();

		FishExclusionID = r.nextLong();
	}



	/**
	 * A constructor for this class that sets the ID for the class.
	 * 
	 * <i>(Should normally be used when initiating a new instance of this class
	 * from previously saved instances, like from a database or from
	 * imports.)</i>
	 * 
	 * @param ID
	 *            The ID of this class.
	 */
	public FishExclusions(long ID)
	{
		FishExclusionID = ID;
	}




	// GETTERS



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the fishExclusionID
	 */
	public long getFishExclusionID()
	{
		return FishExclusionID;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the allAlone
	 */
	public boolean isAllAlone()
	{
		return allAlone;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the aloneWithFamily
	 */
	public boolean isAloneWithFamily()
	{
		return aloneWithFamily;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyOneInFamily
	 */
	public boolean isOnlyOneInFamily()
	{
		return onlyOneInFamily;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyOneMale
	 */
	public boolean isOnlyOneMale()
	{
		return onlyOneMale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyOneFemale
	 */
	public boolean isOnlyOneFemale()
	{
		return onlyOneFemale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyOneMalePerLiter
	 */
	public int getOnlyOneMalePerLiter()
	{
		return onlyOneMalePerLiter;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the onlyOneFemalePerLiter
	 */
	public int getOnlyOneFemalePerLiter()
	{
		return onlyOneFemalePerLiter;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the minumimFemalesPerMale
	 */
	public int getMinumimFemalesPerMale()
	{
		return MinumimFemalesPerMale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the minumimMalesPerFemale
	 */
	public int getMinumimMalesPerFemale()
	{
		return MinumimMalesPerFemale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the minimumSchoolSize
	 */
	public int getMinimumSchoolSize()
	{
		return minimumSchoolSize;
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


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the notCompatibleWithTheseMales
	 */
	public String getNotCompatibleWithTheseMales()
	{
		return notCompatibleWithTheseMales;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the notCompatibleWithTheseFemales
	 */
	public String getNotCompatibleWithTheseFemales()
	{
		return notCompatibleWithTheseFemales;
	}




	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param allAlone
	 *            the allAlone to set
	 */
	public void setAllAlone(boolean allAlone)
	{
		this.allAlone = allAlone;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param aloneWithFamily
	 *            the aloneWithFamily to set
	 */
	public void setAloneWithFamily(boolean aloneWithFamily)
	{
		this.aloneWithFamily = aloneWithFamily;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyOneInFamily
	 *            the onlyOneInFamily to set
	 */
	public void setOnlyOneInFamily(boolean onlyOneInFamily)
	{
		this.onlyOneInFamily = onlyOneInFamily;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyOneMale
	 *            the onlyOneMale to set
	 */
	public void setOnlyOneMale(boolean onlyOneMale)
	{
		this.onlyOneMale = onlyOneMale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyOneFemale
	 *            the onlyOneFemale to set
	 */
	public void setOnlyOneFemale(boolean onlyOneFemale)
	{
		this.onlyOneFemale = onlyOneFemale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyOneMalePerLiter
	 *            the onlyOneMalePerLiter to set
	 */
	public void setOnlyOneMalePerLiter(int onlyOneMalePerLiter)
	{
		this.onlyOneMalePerLiter = onlyOneMalePerLiter;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param onlyOneFemalePerLiter
	 *            the onlyOneFemalePerLiter to set
	 */
	public void setOnlyOneFemalePerLiter(int onlyOneFemalePerLiter)
	{
		this.onlyOneFemalePerLiter = onlyOneFemalePerLiter;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param minumimFemalesPerMale
	 *            the minumimFemalesPerMale to set
	 */
	public void setMinumimFemalesPerMale(int minumimFemalesPerMale)
	{
		MinumimFemalesPerMale = minumimFemalesPerMale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param minumimMalesPerFemale
	 *            the minumimMalesPerFemale to set
	 */
	public void setMinumimMalesPerFemale(int minumimMalesPerFemale)
	{
		MinumimMalesPerFemale = minumimMalesPerFemale;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param minimumSchoolSize
	 *            the minimumSchoolSize to set
	 */
	public void setMinimumSchoolSize(int minimumSchoolSize)
	{
		this.minimumSchoolSize = minimumSchoolSize;
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


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param notCompatibleWithTheseMales
	 *            the notCompatibleWithTheseMales to set
	 */
	public void setNotCompatibleWithTheseMales(
			String notCompatibleWithTheseMales)
	{
		this.notCompatibleWithTheseMales = notCompatibleWithTheseMales;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param notCompatibleWithTheseFemales
	 *            the notCompatibleWithTheseFemales to set
	 */
	public void setNotCompatibleWithTheseFemales(
			String notCompatibleWithTheseFemales)
	{
		this.notCompatibleWithTheseFemales = notCompatibleWithTheseFemales;
	}




}
