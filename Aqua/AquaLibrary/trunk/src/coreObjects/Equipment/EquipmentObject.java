package coreObjects.Equipment;


public abstract class EquipmentObject
{
	/**
	 * The producer of the equipment.
	 */
	private String producer;


	/**
	 * The description of the equipment;
	 */
	private String description;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 * @param description
	 */
	public EquipmentObject(String producer, String description)
	{
		this.producer = producer;
		this.description = description;
	}


	// GETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the producer
	 */
	public String getProducer()
	{
		return producer;
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



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 *            the producer to set
	 */
	public void setProducer(String producer)
	{
		this.producer = producer;
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
}
