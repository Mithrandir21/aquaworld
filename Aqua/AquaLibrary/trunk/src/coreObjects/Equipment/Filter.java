package coreObjects.Equipment;


/**
 * A water cleaning equipment.
 * 
 * @author Bahram Malaekeh
 */
public class Filter extends EquipmentObject
{
	/**
	 * The water processing capacity of the filter.
	 */
	private double volume;



	/**
	 * A constructor for the {@link Filter} class.
	 * 
	 * @param volume
	 *            The water processing capacity of the filter.
	 */
	public Filter(String producer, String description, double volume)
	{
		super(producer, description);
		this.volume = volume;
	}



	// GETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the volume
	 */
	public double getVolume()
	{
		return volume;
	}



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param volume
	 *            the volume to set
	 */
	public void setVolume(double volume)
	{
		this.volume = volume;
	}
}
