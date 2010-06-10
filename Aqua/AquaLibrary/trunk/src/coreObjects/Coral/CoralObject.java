package coreObjects.Coral;


import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class CoralObject extends AbstractObject
{

	/**
	 * The type of coral.
	 */
	private CoralTypes coralType;

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param name
	 * @param latinName
	 * @param description
	 * @param coralType
	 * @param par
	 */
	public CoralObject(int ID, String name, String latinName,
			String description,
			CoralTypes coralType, ObjectParameters par)
	{
		super(ID, latinName, par);
		this.setPopulareName(name);
		this.setDescription(description);
		this.coralType = coralType;
	}




	// GETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the coralType
	 */
	public CoralTypes getCoralType()
	{
		return coralType;
	}



	// SETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param coralType
	 *            the coralType to set
	 */
	public void setCoralType(CoralTypes coralType)
	{
		this.coralType = coralType;
	}
	
	
	
	/**
	 * TODO - Description NEEDED!
	 * 
	 * @author Bahram Malaekeh
	 */
	public enum CoralTypes
	{
		StoneCorals, LargePolipedCoral, SoftCoral;
	}

}
