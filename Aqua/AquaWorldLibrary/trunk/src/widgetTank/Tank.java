package widgetTank;


import java.util.Random;

import coreObjects.Aquarium.Aquarium;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class Tank
{
	/**
	 * The name of the aquarium.(Optional)
	 */
	private String tankName;



	/**
	 * The serial number of the tank.(Mandatory)
	 */
	private long tankSerial;




	/**
	 * The pointer to the {@link Aquarium}.
	 */
	private Aquarium aquariet;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param aquariet
	 */
	public Tank(String name, Aquarium aquariet)
	{
		this.tankName = name;
		this.aquariet = aquariet;
		makeSerial();
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param aquariet
	 */
	public Tank(Aquarium aquariet)
	{
		this.aquariet = aquariet;
		makeSerial();
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the tankName
	 */
	public String getTankName()
	{
		return tankName;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the tankSerial
	 */
	public long getTankSerial()
	{
		return tankSerial;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the aquariet
	 */
	public Aquarium getAquariet()
	{
		return aquariet;
	}



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param tankName
	 *            the tankName to set
	 */
	public void setTankName(String tankName)
	{
		this.tankName = tankName;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param tankSerial
	 *            the tankSerial to set
	 */
	public void setTankSerial(long tankSerial)
	{
		this.tankSerial = tankSerial;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param aquariet
	 *            the aquariet to set
	 */
	public void setAquariet(Aquarium aquariet)
	{
		this.aquariet = aquariet;
	}



	// FUNCTIONS


	/**
	 * Create a unique {@link Long} serial number.
	 */
	private void makeSerial()
	{
		// Default seed comes from system time.
		Random r = new Random();

		tankSerial = r.nextLong();
	}
}
