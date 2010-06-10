package coreObjects.Equipment;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class UVfilter extends EquipmentObject
{
	/**
	 * The watt UV light. The watt tells much water it purifies per liter/watt.
	 */
	private int watt;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 * @param description
	 */
	public UVfilter(String producer, String description, int watt)
	{
		super(producer, description);
		this.watt = watt;
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the watt
	 */
	public int getWatt()
	{
		return watt;
	}



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param watt
	 *            the watt to set
	 */
	public void setWatt(int watt)
	{
		this.watt = watt;
	}
}
