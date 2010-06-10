package coreObjects.Equipment;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class CirculationPump extends EquipmentObject
{
	/**
	 * The amount of water the pumped by the pump.
	 */
	private int literPerHour;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 * @param literPerHour
	 */
	public CirculationPump(String producer, String description, int literPerHour)
	{
		super(producer, description);
		this.literPerHour = literPerHour;
	}



	// GETTERS




	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the literPerHour
	 */
	public int getLiterPerHour()
	{
		return literPerHour;
	}



	// SETTERS



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param literPerHour
	 *            the literPerHour to set
	 */
	public void setLiterPerHour(int literPerHour)
	{
		this.literPerHour = literPerHour;
	}
}
