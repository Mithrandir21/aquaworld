package coreObjects.Fish;


import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;


/**
 * A fish object with name, scientific name, size, gender and water parameters.
 * 
 * @author Bahram Malaekeh
 */
public class FishObject extends AbstractObject
{
	/**
	 * The size(cm) of the fish.
	 */
	private double size;



	/**
	 * The gender of the fish.
	 */
	private FishGender gender;



	/**
	 * What group of fish this fish belongs to.
	 */
	private FishGroups group;



	/**
	 * The unique exclusions for this fish.
	 */
	private FishExclusions exclusions;



	/**
	 * The {@link Enum} that says what type of age the
	 * fish is young or adult.
	 */
	private FishAgeType fishAge;


	/**
			 * This is a constructor for the {@link FishObject} class.
			 * 
			 * @param ID
			 *            The ID for the fish.
			 * @param speciesName
			 *            The scientific name of the fish.
			 * @param description
			 *            The description of the fish.
			 * @param gender
			 *            The gender of the fish, {@link FishGender}.
			 * @param size
			 *            The size(cm) of the fish.
			 * @param par
			 *            The water parameters for the fish.
			 * @param exclusions
			 *            The unique exclusions for this fish.
			 */
	public FishObject(int ID, String speciesName, String description,
			FishGender gender, double size, ObjectParameters par,
			FishExclusions exclusions, FishAgeType ageType)
	{
		super(ID, speciesName, par);
		this.setDescription(description);
		this.gender = gender;
		this.size = size;
		this.exclusions = exclusions;
		this.fishAge = ageType;
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the gender
	 */
	public FishGender getFishGender()
	{
		return gender;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the group
	 */
	public FishGroups getFishGroup()
	{
		return group;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the size
	 */
	public double getSize()
	{
		return size;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the exclusions
	 */
	public FishExclusions getFishExclusions()
	{
		return exclusions;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the fishAge
	 */
	public FishAgeType getFishAgeType()
	{
		return fishAge;
	}



	// SETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param gender
	 *            the gender to set
	 */
	public void setFishGender(FishGender gender)
	{
		this.gender = gender;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param group
	 *            the {@link FishGroups} to set
	 */
	public void setFishGroup(FishGroups group)
	{
		this.group = group;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param size
	 *            the size to set
	 */
	public void setSize(double size)
	{
		this.size = size;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @author Bahram Malaekeh
	 */
	public enum FishGender
	{
		MALE, FEMALE, UNISEX;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @author Bahram Malaekeh
	 */
	public enum FishAgeType
	{
		YOUNG, ADULT;
	}
}
