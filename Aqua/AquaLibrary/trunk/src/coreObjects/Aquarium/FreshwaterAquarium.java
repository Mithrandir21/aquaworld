package coreObjects.Aquarium;


import coreObjects.Equipment.Filter;
import coreObjects.Equipment.HeatingElement;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FreshwaterAquarium extends Aquarium
{
	/**
	 * The freshwaters tank filter.
	 */
	private Filter filter;



	/**
	 * The heating element of the freshwater tank.
	 */
	private HeatingElement heatingElement;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 * @param description
	 * @param filter
	 * @param heatingElement
	 * @param salinity
	 * @param PH
	 * @param GH
	 * @param temperature
	 * @param height
	 * @param lenght
	 * @param width
	 */
	public FreshwaterAquarium(String producer, String description,
			Filter filter, HeatingElement heatingElement, double salinity,
			double PH, double GH, double temperature, double height,
			double length, double width)
	{
		super(producer, description, salinity, PH, GH, temperature, height,
				length, width);
		this.filter = filter;
		this.heatingElement = heatingElement;
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the filter
	 */
	public Filter getFilter()
	{
		return filter;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the heatingElement
	 */
	public HeatingElement getHeatingElement()
	{
		return heatingElement;
	}




	// SETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param filter
	 *            the filter to set
	 */
	public void setFilter(Filter filter)
	{
		this.filter = filter;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param heatingElement
	 *            the heatingElement to set
	 */
	public void setHeatingElement(HeatingElement heatingElement)
	{
		this.heatingElement = heatingElement;
	}
}
