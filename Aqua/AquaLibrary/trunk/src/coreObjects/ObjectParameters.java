package coreObjects;

public class ObjectParameters
{
	
	/**
	 * The ID of the class instance.
	 */
	private int objectParametersID;



	/**
	 * The salt/water ratio. (For freshwater object the ratio will be 1.)
	 */
	private double[] salinity = new double[2];



	/**
	 * The PH value of the water.
	 */
	private double[] PH = new double[2];



	/**
	 * The alkalinity(General hardness of the water) of the water.
	 */
	private double[] GH = new double[2];



	/**
	 * The temperature of the water.
	 */
	private double[] temperature = new double[2];



	/**
	 * The carbon hardness of the water.
	 */
	private double[] kh = new double[2];


	/**
	 * The amount of magnesium in the water
	 */
	private double[] magnesium = new double[2];


	/**
	 * The amount of calcium in the water
	 */
	private double[] calcium = new double[2];



	/**
	 * The amount of space(liters) a object need for its self.
	 */
	private double spaceNeeded;



	/**
	 * The lowest and highest size of the other object in tank, in regards to
	 * the object being eaten or eating others.
	 */
	private double[] othersSize = new double[2];


	
	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param salinity
	 * @param PH
	 * @param GH
	 * @param temperature
	 */
	public ObjectParameters(int ID,double[] salinity, double[] PH, double[] GH,
			double[] temperature)
	{
		this.objectParametersID = ID;
		this.salinity = salinity;
		this.PH = PH;
		this.GH = GH;
		this.temperature = temperature;
	}
	
	


	// GETTERS


	/**
	 * Gets the ID(int) of the class instance.
	 * 
	 * @return the objectParametersID
	 */
	public int getObjectParametersID()
	{
		return objectParametersID;
	}


	/**
	 * Gets the lowest and highest salinity the object can be in.
	 * 
	 * @return the salinity
	 */
	public double[] getSalinity()
	{
		return salinity;
	}



	/**
	 * Gets the lowest salinity the object can be in.
	 * 
	 * @return the salinity
	 */
	public double getSalinityLow()
	{
		return salinity[0];
	}



	/**
	 * Gets the highest salinity the object can be in.
	 * 
	 * @return the salinity
	 */
	public double getSalinityHigh()
	{
		return salinity[1];
	}



	/**
	 * The lowest and highest PH the object can be in.
	 * 
	 * @return the pH
	 */
	public double[] getPH()
	{
		return PH;
	}



	/**
	 * The lowest PH the object can be in.
	 * 
	 * @return the pH
	 */
	public double getPHlow()
	{
		return PH[0];
	}



	/**
	 * The highest PH the object can be in.
	 * 
	 * @return the pH
	 */
	public double getPHhigh()
	{
		return PH[1];
	}



	/**
	 * Gets the lowest and highest GH a object can be in.
	 * 
	 * @return the gH
	 */
	public double[] getGH()
	{
		return GH;
	}



	/**
	 * Gets the lowest GH a object can be in.
	 * 
	 * @return the gH
	 */
	public double getGHlow()
	{
		return GH[0];
	}



	/**
	 * Gets the highest GH a object can be in.
	 * 
	 * @return the gH
	 */
	public double getGHhigh()
	{
		return GH[1];
	}



	/**
	 * Gets the lowest and highest temperature a object can be in.
	 * 
	 * @return the temperature
	 */
	public double[] getTemperature()
	{
		return temperature;
	}



	/**
	 * Gets the lowest temperature a object can be in.
	 * 
	 * @return the temperature
	 */
	public double getTemperatureLow()
	{
		return temperature[0];
	}



	/**
	 * Gets the highest temperature a object can be in.
	 * 
	 * @return the temperature
	 */
	public double getTemperatureHigh()
	{
		return temperature[1];
	}



	/**
	 * Gets the lowest and highest temperature a object can be in.
	 * 
	 * @return the kh
	 */
	public double[] getKh()
	{
		return kh;
	}



	/**
	 * Gets the lowest temperature a object can be in.
	 * 
	 * @return the kh
	 */
	public double getKhLow()
	{
		try
		{
			return kh[0];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	/**
	 * Gets the highest temperature a object can be in.
	 * 
	 * @return the kh
	 */
	public double getKhHigh()
	{
		try
		{
			return kh[1];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	/**
	 * Gets the lowest and highest water calcium a object can be in.
	 * 
	 * @return the calcium
	 */
	public double[] getCalcium()
	{
		return calcium;
	}



	/**
	 * Gets the lowest water calcium a object can be in.
	 * 
	 * @return the calsium[0]
	 */
	public double getCalsiumLow()
	{
		try
		{
			return calcium[0];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	/**
	 * Gets the highest water calcium a object can be in.
	 * 
	 * @return the calsium[1]
	 */
	public double getCalsiumHigh()
	{
		try
		{
			return calcium[1];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	/**
	 * Gets the lowest and highest water magnesium a coral can be in.
	 * 
	 * @return the calcium
	 */
	public double[] getMagnesium()
	{
		return magnesium;
	}



	/**
	 * Gets the lowest water magnesium a coral can be in.
	 * 
	 * @return the magnesium[0]
	 */
	public double getMagnesiumLow()
	{
		try
		{
			return magnesium[0];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	/**
	 * Gets the highest water magnesium a coral can be in.
	 * 
	 * @return the magnesium[1]
	 */
	public double getMagnesiumHigh()
	{
		try
		{
			return magnesium[1];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the spaceNeeded
	 */
	public double getSpaceNeeded()
	{
		return spaceNeeded;
	}



	/**
	 * Gets the lowest and highest temperature a object can be in.
	 * 
	 * @return the kh
	 */
	public double[] getOthersSize()
	{
		return othersSize;
	}



	/**
	 * Gets the lowest size of other object in the same tank.
	 * 
	 * @return the OthersSize
	 */
	public double getOthersSizeLow()
	{
		try
		{
			return othersSize[0];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	/**
	 * Gets the highest size of other object in the same tank.
	 * 
	 * @return the OthersSize
	 */
	public double getOthersSizeHigh()
	{
		try
		{
			return othersSize[1];
		}
		catch ( NullPointerException e )
		{
			return -1;
		}
	}



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param salinity
	 *            the salinity to set
	 */
	public void setSalinity(double[] salinity)
	{
		this.salinity = salinity;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param pH
	 *            the pH to set
	 */
	public void setPH(double[] pH)
	{
		PH = pH;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param gH
	 *            the gH to set
	 */
	public void setGH(double[] gH)
	{
		GH = gH;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param temperature
	 *            the temperature to set
	 */
	public void setTemperature(double[] temperature)
	{
		this.temperature = temperature;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param kh
	 *            the kh to set
	 */
	public void setKh(double[] kh)
	{
		this.kh = kh;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param calcium
	 *            the calsium to set
	 */
	public void setCalcium(double[] calcium)
	{
		this.calcium = calcium;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param magnesium
	 *            the magnesium to set
	 */
	public void setMagnesium(double[] magnesium)
	{
		this.magnesium = magnesium;
	}



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param spaceNeeded
	 *            the spaceNeeded to set
	 */
	public void setSpaceNeeded(double spaceNeeded)
	{
		this.spaceNeeded = spaceNeeded;
	}




	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param othersSize
	 *            the othersSize to set
	 */
	public void setOthersSize(double[] othersSize)
	{
		this.othersSize = othersSize;
	}
}
