package logistical;


import coreObjects.AbstractObject;


public class DataRetrival
{

	/**
	 * This function returns a multi-dimension string array with data from the
	 * array.
	 */
	public static String[][] getObjectsData(AbstractObject[] objects)
	{
		String[][] data = new String[objects.length][10];

		for ( int i = 0; i < objects.length; i++ )
		{
			data[i][0] = objects[i].toString();
			data[i][1] = getRangeString(objects[i].getParameters()
					.getSalinity());
			data[i][2] = getRangeString(objects[i].getParameters().getPH());
			data[i][3] = getRangeString(objects[i].getParameters().getGH());
			data[i][4] = getRangeString(objects[i].getParameters().getKh());
			data[i][5] = getRangeString(objects[i].getParameters()
					.getTemperature());
			data[i][6] = getRangeString(objects[i].getParameters()
					.getMagnesium());
			data[i][7] = getRangeString(objects[i].getParameters().getCalcium());
			data[i][8] = "" + objects[i].getParameters().getSpaceNeeded();
			data[i][9] = getRangeString(objects[i].getParameters()
					.getOthersSize());
		}

		return data;
	}



	/**
	 * This function returns a string array with data from the array.
	 */
	public static String[] getObjectsData(AbstractObject objects)
	{
		String[] data = new String[10];

		data[0] = objects.toString();
		data[1] = getRangeString(objects.getParameters().getSalinity());
		data[2] = getRangeString(objects.getParameters().getPH());
		data[3] = getRangeString(objects.getParameters().getGH());
		data[4] = getRangeString(objects.getParameters().getKh());
		data[5] = getRangeString(objects.getParameters().getTemperature());
		data[6] = getRangeString(objects.getParameters().getMagnesium());
		data[7] = getRangeString(objects.getParameters().getCalcium());
		data[8] = "" + objects.getParameters().getSpaceNeeded();
		data[9] = getRangeString(objects.getParameters().getOthersSize());

		return data;
	}




	/**
	 * TODO - Description
	 */
	public static String getRangeString(double[] range)
	{
		if ( range.length != 2 )
		{
			return "";
		}

		double low = range[0];
		double high = range[1];


		String text = "";

		if ( low > 0 )
		{
			text = "" + low;
		}

		text = text + " - ";

		if ( high > 0 )
		{
			text = text + high;
		}


		return text;
	}



	/**
	 * TODO - Description
	 */
	public static String getRangeString(double low, double high)
	{
		String text = "";

		if ( low > 0 )
		{
			text = "" + low;
		}

		text = text + " - ";

		if ( high > 0 )
		{
			text = text + high;
		}

		return text;
	}





	/**
	 * TODO - Description
	 */
	public static String getRangeString(String low, String high)
	{
		if ( low.equals("") && high.equals("") )
		{
			return "";
		}


		String text = "";

		if ( !low.equals("") )
		{
			text = low;
		}

		text = text + " - ";

		if ( !high.equals("") )
		{
			text = text + high;
		}

		return text;
	}






	/**
	 * This function shortens a String to 30 chars if the string is longer then
	 * 30 char. It adds 3 "." at the end of the shortend string.
	 */
	public static String getShortendGenus(String text)
	{
		String shortDesc = "";

		// If the string is longer then 3 chars
		if ( text.length() > 3 )
		{
			// Goes through the first 3 chars
			for ( int i = 0; i < 3; i++ )
			{
				shortDesc = new StringBuffer(shortDesc).insert(i,
						text.charAt(i)).toString();
			}

			shortDesc = new StringBuffer(shortDesc).insert(3, ".").toString();
		}
		else
		{
			return text;
		}

		return shortDesc;
	}






	/**
	 * This function shortens a String to 6 chars if the string is longer then 6
	 * char. It adds 3 "." at the end of the shorten string.
	 */
	public static String getShortenString(String text)
	{
		String shortDesc = "";

		// If the string is longer then 30 chars
		if ( text.length() > 6 )
		{
			// Goes through the first 27 chars
			for ( int i = 0; i < 3; i++ )
			{
				shortDesc = new StringBuffer(shortDesc).insert(i,
						text.charAt(i)).toString();
			}

			shortDesc = new StringBuffer(shortDesc).insert(3, ".").toString();
			shortDesc = new StringBuffer(shortDesc).insert(4, ".").toString();
			shortDesc = new StringBuffer(shortDesc).insert(5, ".").toString();
		}
		else
		{
			return text;
		}

		return shortDesc;
	}

}
