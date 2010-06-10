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
	 * TODO - Description NEEDED!
	 * 
	 * @param name
	 * @param latinName
	 * @param description
	 * @param type
	 * @param par
	 */
	public InvertebratesObject(int ID, String name, String latinName,
			String description, InvertebratesTypes type, ObjectParameters par)
	{
		super(ID, latinName, par);
		this.setPopulareName(name);
		this.setDescription(description);
		this.invType = type;
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
