package logistical;


import java.util.regex.Pattern;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class DataCheck
{
	/**
	 * TODO - Description
	 * 
	 */
	public static boolean containsOnlyNumbers(String text)
	{
		String pat = "([\\d]+)";
		
		Pattern test = Pattern.compile(pat);

		return test.matcher(text).matches();
	}
}
