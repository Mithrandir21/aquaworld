package coreObjects.Aquarium;


import coreObjects.Aquarium.Containers.ContentContainer;


public abstract class Aquarium
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
	 * The salt/water ratio. (For freshwater fish the ratio will be 1.)
	 */
	private double salinity;



	/**
	 * The PH value of the water.
	 */
	private double PH;



	/**
	 * The alkalinity(General hardness of the water) of the water.
	 */
	private double GH;



	/**
	 * The temperature of the water.
	 */
	private double temperature;



	/**
	 * The carbon hardness of the water.
	 */
	private double kh;


	/**
	 * The amount of magnesium in the water
	 */
	private double magnesium;


	/**
	 * The amount of calcium in the water
	 */
	private double calcium;



	/**
	 * The height of the tank.
	 */
	private double height;



	/**
	 * The length of the tank.
	 */
	private double length;



	/**
	 * The width of the tank;
	 */
	private double width;



	/**
	 * The content of the tank;
	 */
	private ContentContainer content;



	/**
	 * The capacity of the tank.
	 */
	private double tankCapacity;




	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 * @param description
	 * @param salinity
	 * @param PH
	 * @param GH
	 * @param temperature
	 * @param height
	 * @param lenght
	 * @param width
	 */
	public Aquarium(String producer, String description, double salinity,
			double PH, double GH, double temperature, double height,
			double length, double width)
	{
		this.producer = producer;
		this.description = description;
		this.salinity = salinity;
		this.PH = PH;
		this.GH = GH;
		this.temperature = temperature;
		this.height = height;
		this.length = length;
		this.width = width;
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



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the salinity
	 */
	public double getSalinity()
	{
		return salinity;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the pH
	 */
	public double getPH()
	{
		return PH;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the gH
	 */
	public double getGH()
	{
		return GH;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the temperature
	 */
	public double getTemperature()
	{
		return temperature;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the kh
	 */
	public double getKh()
	{
		return kh;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the magnesium
	 */
	public double getMagnesium()
	{
		return magnesium;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the calcium
	 */
	public double getCalcium()
	{
		return calcium;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the height
	 */
	public double getHeight()
	{
		return height;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the length
	 */
	public double getLength()
	{
		return length;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the width
	 */
	public double getWidth()
	{
		return width;
	}



	/**
	 * TODO - Description
	 * 
	 * @return the width
	 */
	public ContentContainer getContent()
	{
		return content;
	}



	/**
	 * TODO - Description
	 */
	public double getCapacity()
	{
		return tankCapacity;
	}



	/**
	 * TODO - Description
	 * 
	 * @return The tank volume in liters.
	 */
	public int getLiter()
	{
		return ((int) (length * height * width)) / 1000;
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



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param salinity
	 *            the salinity to set
	 */
	public void setSalinity(double salinity)
	{
		this.salinity = salinity;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param pH
	 *            the pH to set
	 */
	public void setPH(double pH)
	{
		PH = pH;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param gH
	 *            the gH to set
	 */
	public void setGH(double gH)
	{
		GH = gH;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param temperature
	 *            the temperature to set
	 */
	public void setTemperature(double temperature)
	{
		this.temperature = temperature;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param kh
	 *            the kh to set
	 */
	public void setKh(double kh)
	{
		this.kh = kh;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param magnesium
	 *            the magnesium to set
	 */
	public void setMagnesium(double magnesium)
	{
		this.magnesium = magnesium;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param calcium
	 *            the calcium to set
	 */
	public void setCalcium(double calcium)
	{
		this.calcium = calcium;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height)
	{
		this.height = height;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param length
	 *            the length to set
	 */
	public void setLength(double length)
	{
		this.length = length;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param width
	 *            the width to set
	 */
	public void setWidth(double width)
	{
		this.width = width;
	}



	/**
	 * TODO - Description
	 * 
	 * @param content
	 *            the content to set
	 */
	public void setContent(ContentContainer content)
	{
		this.content = content;
	}



	/**
	 * TODO - Description
	 */
	public void setCapacity(double capacity)
	{
		this.tankCapacity = capacity;
	}
}
