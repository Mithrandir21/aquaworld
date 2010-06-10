package logistical;


import graphics.canvas.WorkareaCanvas;
import coreObjects.Coral.CoralObject;
import coreObjects.Equipment.EquipmentObject;
import coreObjects.Fish.FishObject;
import coreObjects.Invertebrates.InvertebratesObject;


/**
 * Class that contains different cleanup and support functions that are used in the different parts of the program.
 * 
 * @author Bahram Malaekeh
 * @version 0.1
 */
public class cleanup
{

	/**
	 * Function to remove null pointer from the an array of objects.
	 */
	public static Object[] cleanObjectArray(Object[] array)
	{

		// Temporary counter for the function
		int tempCounter = 0;

		// Makes an array with given lenght
		Object[] Tempresults = new Object[array.length];

		// Goes through all of the found components array and moves those that
		// are not null
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] != null )
			{
				Tempresults[tempCounter] = array[i];

				tempCounter++;
			}
		}


		// Makes the array that is to hold the results
		Object[] results = new Object[tempCounter];


		// Creates a new array that will copy all the non-null objects.
		for ( int i = 0; i < tempCounter; i++ )
		{
			results[i] = Tempresults[i];
		}

		return results;
	}



	/**
	 * Function to remove null pointer from the an array of objects.
	 */
	public static WorkareaCanvas[] cleanObjectArray(WorkareaCanvas[] array)
	{

		// Temporary counter for the function
		int tempCounter = 0;

		// Makes an array with given lenght
		WorkareaCanvas[] Tempresults = new WorkareaCanvas[array.length];

		// Goes through all of the found components array and moves those that
		// are not null
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] != null )
			{
				Tempresults[tempCounter] = array[i];

				tempCounter++;
			}
		}


		// Makes the array that is to hold the results
		WorkareaCanvas[] results = new WorkareaCanvas[tempCounter];


		// Creates a new array that will copy all the non-null objects.
		for ( int i = 0; i < tempCounter; i++ )
		{
			results[i] = Tempresults[i];
		}

		return results;
	}




	/**
	 * Function to remove null pointer from the an array of objects.
	 */
	public static FishObject[] cleanObjectArray(FishObject[] array)
	{

		// Temporary counter for the function
		int tempCounter = 0;

		// Makes an array with given lenght
		FishObject[] Tempresults = new FishObject[array.length];

		// Goes through all of the found components array and moves those that
		// are not null
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] != null )
			{
				Tempresults[tempCounter] = array[i];

				tempCounter++;
			}
		}


		// Makes the array that is to hold the results
		FishObject[] results = new FishObject[tempCounter];


		// Creates a new array that will copy all the non-null objects.
		for ( int i = 0; i < tempCounter; i++ )
		{
			results[i] = Tempresults[i];
		}

		return results;
	}



	/**
	 * Function to remove null pointer from the an array of objects.
	 */
	public static CoralObject[] cleanObjectArray(CoralObject[] array)
	{

		// Temporary counter for the function
		int tempCounter = 0;

		// Makes an array with given lenght
		CoralObject[] Tempresults = new CoralObject[array.length];

		// Goes through all of the found components array and moves those that
		// are not null
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] != null )
			{
				Tempresults[tempCounter] = array[i];

				tempCounter++;
			}
		}


		// Makes the array that is to hold the results
		CoralObject[] results = new CoralObject[tempCounter];


		// Creates a new array that will copy all the non-null objects.
		for ( int i = 0; i < tempCounter; i++ )
		{
			results[i] = Tempresults[i];
		}

		return results;
	}



	/**
	 * Function to remove null pointer from the an array of objects.
	 */
	public static EquipmentObject[] cleanObjectArray(EquipmentObject[] array)
	{

		// Temporary counter for the function
		int tempCounter = 0;

		// Makes an array with given lenght
		EquipmentObject[] Tempresults = new EquipmentObject[array.length];

		// Goes through all of the found components array and moves those that
		// are not null
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] != null )
			{
				Tempresults[tempCounter] = array[i];

				tempCounter++;
			}
		}


		// Makes the array that is to hold the results
		EquipmentObject[] results = new EquipmentObject[tempCounter];


		// Creates a new array that will copy all the non-null objects.
		for ( int i = 0; i < tempCounter; i++ )
		{
			results[i] = Tempresults[i];
		}

		return results;
	}



	/**
	 * Function to remove null pointer from the an array of objects.
	 */
	public static InvertebratesObject[] cleanObjectArray(
			InvertebratesObject[] array)
	{

		// Temporary counter for the function
		int tempCounter = 0;

		// Makes an array with given lenght
		InvertebratesObject[] Tempresults = new InvertebratesObject[array.length];

		// Goes through all of the found components array and moves those that
		// are not null
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] != null )
			{
				Tempresults[tempCounter] = array[i];

				tempCounter++;
			}
		}


		// Makes the array that is to hold the results
		InvertebratesObject[] results = new InvertebratesObject[tempCounter];


		// Creates a new array that will copy all the non-null objects.
		for ( int i = 0; i < tempCounter; i++ )
		{
			results[i] = Tempresults[i];
		}

		return results;
	}


	/**
	 * Function to remove null pointer from the an array of strings.
	 */
	public static String[] cleanObjectArray(String[] array)
	{

		// Temporary counter for the function
		int tempCounter = 0;

		// Makes an array with given lenght
		String[] Tempresults = new String[array.length];

		// Goes through all of the found components array and moves those that
		// are not null
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] != null )
			{
				Tempresults[tempCounter] = array[i];

				tempCounter++;
			}
		}



		// Makes the array that is to hold the results
		String[] results = new String[tempCounter];


		// Creates a new array that will copy all the non-null objects.
		for ( int i = 0; i < tempCounter; i++ )
		{
			results[i] = Tempresults[i];
		}



		return results;
	}



	/**
	 * Function to remove null pointer from the an array of booleans. Its arranged after the given boolean so that the
	 * given boolean is placed first and the rest is placed afterwards.
	 */
	public static boolean[] cleanObjectArray(boolean[] array, boolean given)
	{

		// Temporary counter for the function
		int counterGiven = 0;

		// Goes through all of the array and counts all the indexes that hold
		// the given boolean.
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[i] == given )
			{
				counterGiven++;
			}
		}

		// Makes the array that is to hold the results
		boolean[] results = new boolean[array.length];

		// Creates a new array that will copy all the given booleans first and
		// then the non-given booleans.
		for ( int i = 0; i < results.length; i++ )
		{
			if ( i < counterGiven )
			{
				results[i] = given;
			}
			else
			{
				results[i] = !given;
			}
		}

		return results;
	}


	/**
	 * This method removes any empty first level index from the given data.
	 * 
	 * @param data
	 *            The array that will be checked for empty array indexes.
	 * @return Return a new array with no empty indexes.
	 */
	public static String[][] cleanObjectArray(String[][] data)
	{
		if ( data != null )
		{
			int notEmptySpaces = 0;


			for ( int i = 0; i < data.length; i++ )
			{
				if ( data[i][0] != null )
				{
					notEmptySpaces++;
				}
			}


			String[][] temp = new String[notEmptySpaces][data[0].length];


			for ( int i = 0; i < temp.length; i++ )
			{
				for ( int j = 0; j < temp[i].length; j++ )
				{
					temp[i][j] = data[i][j];
				}
			}

			return temp;
		}


		return data;
	}

}
