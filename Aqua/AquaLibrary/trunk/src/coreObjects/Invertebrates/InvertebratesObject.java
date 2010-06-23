package coreObjects.Invertebrates;


import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;



/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class InvertebratesObject extends AbstractObject
{

	/**
	 * The type of invertebrate
	 */
	private InvertebratesTypes invType;



	/**
	 * The unique exclusions for this Invertebrates.
	 */
	private InvertebrateExclusions exclusions;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param name
	 * @param speciesName
	 * @param description
	 * @param type
	 * @param par
	 */
	public InvertebratesObject(int ID, String speciesName, String description,
			InvertebratesTypes type, ObjectParameters par,
			InvertebrateExclusions exclusions)
	{
		super(ID, speciesName, par);
		this.setDescription(description);
		this.invType = type;
		this.exclusions = exclusions;
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the invType
	 */
	public InvertebratesTypes getInvertebrateType()
	{
		return invType;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the exclusions
	 */
	public InvertebrateExclusions getExclusions()
	{
		return exclusions;
	}


	// SETTERS




	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param type
	 *            the {@link InvertebratesTypes} to set
	 */
	public void setInvertebratesTypes(InvertebratesTypes type)
	{
		this.invType = type;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @author Bahram Malaekeh
	 */
	public enum InvertebratesTypes
	{
		Sponges, SeaCucumber, Shrimps, Crabs, SeaUrchins, Starfish, Ringworms, Snails, Anemones, Clams;
	}
}
