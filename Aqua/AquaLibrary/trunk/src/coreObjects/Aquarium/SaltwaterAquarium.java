package coreObjects.Aquarium;

import coreObjects.Equipment.CirculationPump;




/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class SaltwaterAquarium extends Aquarium
{
	/**
	 * The amount of water circulation.
	 */
	private CirculationPump circulationPump;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 * @param description
	 * @param circulationPump
	 * @param salinity
	 * @param PH
	 * @param GH
	 * @param temperature
	 * @param height
	 * @param lenght
	 * @param width
	 */
	public SaltwaterAquarium(String producer, String description,
			CirculationPump circulationPump, double salinity, double PH,
			double GH, double temperature, double height, double length,
			double width)
	{
		super(producer, description, salinity, PH, GH, temperature, height,
				length, width);
		this.circulationPump = circulationPump;
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the pump
	 */
	public CirculationPump getCirculationPump()
	{
		return circulationPump;
	}


	// SETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param circulationPump
	 *            the circulationPump to set
	 */
	public void setCirculationPump(CirculationPump circulationPump)
	{
		this.circulationPump = circulationPump;
	}
}
