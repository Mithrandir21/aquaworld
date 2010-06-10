package logistical;


public class DataManipulation
{
	/**
	 * TODO - Description
	 * 
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
}
