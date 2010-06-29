package logistical;


public class DataManipulation
{
	/**
	 * TODO - Description
	 */
	public static String[] placeObjectIDinSortedArray(String newID, String[] IDs)
	{
		if ( DataCheck.containsOnlyNumbers(newID) )
		{
			// If there are no indexes in the array.
			if ( IDs == null || IDs.length == 0 )
			{
				IDs = new String[1];
				IDs[0] = newID;

				return IDs;
			}
			// A new array with one more index.
			String[] newIDarray = new String[IDs.length + 1];
			int index = 0;
			/**
			 * While the index is lower then the length of the IDs, the string
			 * at the index contains only numbers, and the newID is lower then
			 * the int at the index.
			 */
			while ( index < IDs.length
					&& DataCheck.containsOnlyNumbers(IDs[index])
					&& Integer.parseInt(newID) > Integer.parseInt(IDs[index]) )
			{
				index++;
			}
			// Copies the IDs to the new array up to the index.
			System.arraycopy(IDs, 0, newIDarray, 0, index);
			// Sets the newID at the index in the new array.
			newIDarray[index] = newID;
			// Copies the remainder of the IDs in to the new array
			System.arraycopy(IDs, index, newIDarray, index + 1,
					(IDs.length - index));
			// Returns the new array with the
			return newIDarray;
		}
		else
		{
			return IDs;
		}
	}




	/**
	 * TODO - Description
	 */
	public static String[] placeObjectIDinSortedArray(int newID, String[] IDs)
	{
		// If there are no indexes in the array.
		if ( IDs == null || IDs.length == 0 )
		{
			IDs = new String[1];
			IDs[0] = newID + "";

			return IDs;
		}

		// A new array with one more index.
		String[] newIDarray = new String[IDs.length + 1];
		int index = 0;
		/**
		 * While the index is lower then the length of the IDs, the string
		 * at the index contains only numbers, and the newID is lower then
		 * the int at the index.
		 */
		while ( index < IDs.length && DataCheck.containsOnlyNumbers(IDs[index])
				&& newID > Integer.parseInt(IDs[index]) )
		{
			index++;
		}
		// Copies the IDs to the new array up to the index.
		System.arraycopy(IDs, 0, newIDarray, 0, index);
		// Sets the newID at the index in the new array.
		newIDarray[index] = newID + "";
		// Copies the remainder of the IDs in to the new array
		System.arraycopy(IDs, index, newIDarray, index + 1,
				(IDs.length - index));
		// Returns the new array with the
		return newIDarray;
	}






	/**
	 * Returns the given string
	 */
	public static String[] stringToArray(String a, String delimiter)
	{
		if ( a == null || a == "" )
		{
			return null;
		}

		String[] tempIDs;

		// Given string will be split by the argument delimiter provided
		tempIDs = a.split(delimiter);

		if ( tempIDs.length == 0 )
		{
			return null;
		}

		return tempIDs;
	}


	/**
	 * TODO - Description
	 */
	public static String arrayToString(String[] a, String delimiter)
	{
		StringBuffer result = new StringBuffer();
		if ( a.length > 0 )
		{
			result.append(a[0]);
			for ( int i = 1; i < a.length; i++ )
			{
				result.append(delimiter);
				result.append(a[i]);
			}
		}
		return result.toString();
	}



	/**
	 * TODO - Description
	 * 
	 */
	public static int[] stringArraytoIntArray(String[] array) throws Exception
	{
		if ( array != null )
		{
			int intarray[] = new int[array.length];
			for ( int i = 0; i < array.length; i++ )
			{
				intarray[i] = Integer.parseInt(array[i]);
			}
			return intarray;
		}
		return null;
	}
}
