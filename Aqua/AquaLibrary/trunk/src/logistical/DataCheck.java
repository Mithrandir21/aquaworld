package logistical;


import java.util.regex.Pattern;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class DataCheck
{
	/**
	 * TODO - Description
	 */
	public static boolean containsOnlyNumbers(String text)
	{
		String pat = "([\\d]+)";

		Pattern test = Pattern.compile(pat);

		return test.matcher(text).matches();
	}




	/**
	 * TODO - Description
	 */
	public static boolean verifyStringIDs(String IDs)
	{
		String[] temp;

		// Delimiter
		String delimiter = ", ";
		// given string will be split by the argument delimiter provided.
		temp = IDs.split(delimiter);


		for ( int i = 0; i < temp.length; i++ )
		{
			boolean onlyNumbers = containsOnlyNumbers(temp[i]);

			System.out.println(temp[i]);

			// If anything other then numbers
			if ( !onlyNumbers )
			{
				return false;
			}
		}


		return true;
	}
}
