package coreObjects;


import logistical.DataRetrival;



/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public abstract class AbstractObject
{
	/**
	 * The ID of the object(set only from the SQL object table).
	 */
	private int objectID;


	/**
	 * The popular name of the fish.
	 */
	private String populareName;


	/**
	 * The scientific species name of the fish.
	 */
	private String speciesName;


	/**
	 * The genus the fish belongs too.
	 */
	private String genusName;


	/**
	 * The description of the fish.
	 */
	private String description;


	/**
	 * The water parameters regarding the object.
	 */
	private ObjectParameters parameters;



	/**
	 * This private, empty constructor is placed here for Hibernate.
	 */
	private AbstractObject()
	{

	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param speciesName
	 * @param par
	 */
	public AbstractObject(int id, String speciesName, ObjectParameters par)
	{
		this.objectID = id;
		this.speciesName = speciesName;
		this.parameters = par;
	}



	// GETTERS
	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the name
	 */
	public int getObjectID()
	{
		return objectID;
	}




	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the popName
	 */
	public String getPopulareName()
	{
		return populareName;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the speciesName
	 */
	public String getSpeciesName()
	{
		return speciesName;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the genusName
	 */
	public String getGenusName()
	{
		return genusName;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}


	/**
	 * Gets the {@link ObjectParameters} belonging to the object.
	 */
	public ObjectParameters getParameters()
	{
		return parameters;
	}



	// SETTERS



	// GETTERS
	/**
	 * This function is meant to be used by Hibernate for ID setting.
	 */
	private void setObjectID(int id)
	{
		objectID = id;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param popname
	 *            the popname to set
	 */
	public void setPopulareName(String popname)
	{
		this.populareName = popname;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param species
	 *            the species to set
	 */
	public void setSpeciesName(String species)
	{
		this.speciesName = species;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param genus
	 *            the genusName to set
	 */
	public void setGenusName(String genus)
	{
		this.genusName = genus;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}



	/**
	 * Sets the {@link ObjectParameters} belonging to the object.
	 */
	public void setParameters(ObjectParameters parameters)
	{
		this.parameters = parameters;
	}







	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String ret = "";

		if ( genusName != null && !(genusName.equalsIgnoreCase(""))
				&& !(genusName.equalsIgnoreCase("null")) )
		{
			ret = DataRetrival.getShortendGenus(genusName) + " ";
		}

		ret = ret + speciesName;

		return ret;
	}
}
