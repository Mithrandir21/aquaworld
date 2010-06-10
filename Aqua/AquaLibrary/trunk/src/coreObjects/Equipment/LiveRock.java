package coreObjects.Equipment;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class LiveRock extends EquipmentObject
{

	/**
	 * The weight of the rock.
	 */
	private int weight;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param producer
	 * @param description
	 * @param weight
	 */
	public LiveRock(String producer, String description, int weight)
	{
		super(producer, description);
		this.weight = weight;
	}



	// GETTERS



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the weight
	 */
	public int getWeight()
	{
		return weight;
	}



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
}
