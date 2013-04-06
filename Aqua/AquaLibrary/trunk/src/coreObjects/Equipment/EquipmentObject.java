package coreObjects.Equipment;

/**
 * This class is an abstract class for equipment objects, such as caves, filters and plants.
 */
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
	 * Constructor for the class that takes a Producer(String) and a Description(String).
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
	 * The producer of the equipment.
	 * 
	 * @return the producer
	 */
	public String getProducer()
	{
		return producer;
	}



	/**
	 * The equipment description.
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
