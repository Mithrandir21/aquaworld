package logistical;


/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
public enum LogisticalCodes
{
	/**
	 * If the an object has been added to an Aquarium.
	 */
	OBJECT_ADDED,


	/**
	 * The object matches the tank.
	 */
	OBJECT_MATCH_TANK,


	/**
	 * The parameters of the object matches the parameters of the tank.
	 */
	PARAMETERS_MATCH,


	/**
	 * The parameters of the object does not match the parameters of the tank.
	 */
	PARAMETERS_NOT_MATCH,


	/**
	 * The object needs a higher tank salinity.
	 */
	TANK_SALINITY_TO_LOW,

	/**
	 * The object needs a lower tank salinity.
	 */
	TANK_SALINITY_TO_HIGH,


	/**
	 * The object needs a higher tank ph.
	 */
	TANK_PH_TO_LOW,

	/**
	 * The object needs a lower tank ph.
	 */
	TANK_PH_TO_HIGH,


	/**
	 * The object needs a higher tank gh.
	 */
	TANK_GH_TO_LOW,

	/**
	 * The object needs a lower tank gh.
	 */
	TANK_GH_TO_HIGH,


	/**
	 * The object needs a higher tank kh.
	 */
	TANK_KH_TO_LOW,

	/**
	 * The object needs a lower tank kh.
	 */
	TANK_KH_TO_HIGH,


	/**
	 * The object needs a higher tank temperature.
	 */
	TANK_TEMPERATURE_TO_LOW,

	/**
	 * The object needs a lower tank temperature.
	 */
	TANK_TEMPERATURE_TO_HIGH,


	/**
	 * The object needs a higher tank magnesium.
	 */
	TANK_MAGNESIUM_TO_LOW,

	/**
	 * The object needs a lower tank magnesium.
	 */
	TANK_MAGNESIUM_TO_HIGH,


	/**
	 * The object needs a higher tank calcium.
	 */
	TANK_CALCIUM_TO_LOW,

	/**
	 * The object needs a lower tank calcium.
	 */
	TANK_CALCIUM_TO_HIGH,


	/**
	 * The object needs a higher tank others size.
	 */
	TANK_OTHERSSIZE_TO_LOW,

	/**
	 * The object needs a lower tank others size.
	 */
	TANK_OTHERSSIZE_TO_HIGH,


	/**
	 * There is not enough space in the tank for object.
	 */
	TANK_SPACENEEDED_NOT_ENOUGH;
	
}
