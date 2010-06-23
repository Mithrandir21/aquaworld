package logistical;


import java.util.ArrayList;

import coreObjects.AbstractObject;
import coreObjects.ObjectParameters;
import coreObjects.Aquarium.Aquarium;
import coreObjects.Aquarium.FreshwaterAquarium;
import coreObjects.Fish.FishObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class TankManagment
{
	/**
	 * TODO - Description
	 */
	public static ArrayList<LogisticalCodes> addFish(FishObject fish,
			Aquarium aquarium,
			Boolean expertMode)
	{
		ArrayList<LogisticalCodes> actions = new ArrayList<LogisticalCodes>();


		// If the given aquarium is a freshwater tank
		if ( aquarium instanceof FreshwaterAquarium )
		{
			// Checks whether or not the fish matches the tank
			ArrayList<LogisticalCodes> codes = parametersMatch(fish, aquarium);

			/**
			 * If the codes returned contain parameters not match.
			 */
			if ( codes.contains(LogisticalCodes.PARAMETERS_NOT_MATCH) )
			{
				// Removes the not match so that only error codes are left
				codes.remove(LogisticalCodes.PARAMETERS_NOT_MATCH);

				return codes;
			}


		}
		else
		{

		}


		if ( actions.contains(LogisticalCodes.OBJECT_MATCH_TANK) )
		{
			actions.add(LogisticalCodes.OBJECT_ADDED);
		}


		return actions;
	}




	/**
	 * TODO - Description
	 */
	public static ArrayList<LogisticalCodes> parametersMatch(
			AbstractObject object, Aquarium aquarium)
	{
		// The parameters of the fish
		ObjectParameters par = object.getParameters();

		// The array of codes.
		ArrayList<LogisticalCodes> codes = new ArrayList<LogisticalCodes>();


		// The PH
		if ( (par.getPHlow() > aquarium.getPH()) )
		{
			codes.add(LogisticalCodes.TANK_PH_TO_LOW);
		}
		
		if ( (par.getPHhigh() < aquarium.getPH()) )
		{
			codes.add(LogisticalCodes.TANK_PH_TO_HIGH);
		}


		// The GH
		if ( (par.getGHlow() > aquarium.getGH()) )
		{
			codes.add(LogisticalCodes.TANK_GH_TO_LOW);
		}

		if ( (par.getGHhigh() < aquarium.getGH()) )
		{
			codes.add(LogisticalCodes.TANK_GH_TO_HIGH);
		}


		// The KH
		if ( par.getKhLow() != -1 )
		{
			if ( (par.getKhLow() > aquarium.getKh()) )
			{
				codes.add(LogisticalCodes.TANK_KH_TO_LOW);
			}

			if ( par.getKhHigh() != -1
					&& (par.getKhHigh() < aquarium.getMagnesium()) )
			{
				codes.add(LogisticalCodes.TANK_KH_TO_HIGH);
			}
		}


		// The temperature
		if ( (par.getTemperatureLow() > aquarium.getTemperature()) )
		{
			codes.add(LogisticalCodes.TANK_TEMPERATURE_TO_LOW);
		}
		
		if ( (par.getTemperatureHigh() < aquarium.getTemperature()) )
		{
			codes.add(LogisticalCodes.TANK_TEMPERATURE_TO_HIGH);
		}


		// The Magnesium
		if ( par.getMagnesiumLow() != -1 )
		{
			if( (par.getMagnesiumLow() > aquarium.getMagnesium()) )
			{
				codes.add(LogisticalCodes.TANK_MAGNESIUM_TO_LOW);
			}

			if ( par.getMagnesiumHigh() != -1
					&& (par.getMagnesiumHigh() < aquarium.getMagnesium()) )
			{
				codes.add(LogisticalCodes.TANK_MAGNESIUM_TO_HIGH);
			}
		}


		// The Calcium
		if ( par.getCalsiumLow() != -1 )
		{
			if ( (par.getCalsiumLow() > aquarium.getCalcium()) )
			{
				codes.add(LogisticalCodes.TANK_CALCIUM_TO_LOW);
			}

			if ( par.getCalsiumHigh() != -1
					&& (par.getCalsiumHigh() < aquarium.getCalcium()) )
			{
				codes.add(LogisticalCodes.TANK_CALCIUM_TO_HIGH);
			}
		}



		if ( codes.isEmpty() )
		{
			codes.add(LogisticalCodes.PARAMETERS_MATCH);
		}
		else
		{
			codes.add(LogisticalCodes.PARAMETERS_NOT_MATCH);
		}

		
		return codes;
	}




	/**
	 * TODO - Description
	 */
	public static boolean foundIDinStringList(AbstractObject object,
			String stringList)
	{
		String[] list = stringList.split(",");


		for ( int i = 0; i < list.length; i++ )
		{
			if ( list[i] != "" )
			{
				// The ID found in the ID list.
				int id = Integer.parseInt(list[i]);

				// If the ID found is the same as the ID of the given Object
				if ( object.getObjectID() == id )
				{
					return true;
				}
			}
		}


		// The ID of the given object was not found in the given list
		return false;
	}
	
	
	
	
	
	
	
	
}
