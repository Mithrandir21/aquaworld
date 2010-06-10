package coreObjects.Equipment;


/**
 * A heating element to heat up the water in a tank.
 * 
 * @author Bahram Malaekeh
 */
public class HeatingElement extends EquipmentObject
{
	/**
	 * The watt of the heating element. (60 watt heats up a 60 liter tank in an
	 * hour.)
	 */
	private int watt;



	/**
	 * A constructor for the {@link HeatingElement} class.
	 * 
	 * @param watt
	 *            The watt of the heating element.
	 */
	public HeatingElement(String producer, String description, int watt)
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
