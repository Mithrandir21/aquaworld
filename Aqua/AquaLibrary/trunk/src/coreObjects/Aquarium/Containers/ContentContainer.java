package coreObjects.Aquarium.Containers;


import java.util.ArrayList;

import coreObjects.Coral.CoralObject;
import coreObjects.Equipment.EquipmentObject;
import coreObjects.Fish.FishObject;
import coreObjects.Invertebrates.InvertebratesObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ContentContainer
{
	/**
	 * The arraylist of {@link FishObject}.
	 */
	private ArrayList<FishObject> fishes;


	/**
	 * The arraylist of {@link CoralObject}.
	 */
	private ArrayList<CoralObject> corals;


	/**
	 * The arraylist of the {@link InvertebratesObject}.
	 */
	private ArrayList<InvertebratesObject> invertebrates;


	/**
	 * The arraylist of {@link EquipmentObject},
	 */
	private ArrayList<EquipmentObject> equipment;


	
	
	// GETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the fishes
	 */
	public ArrayList<FishObject> getFishes()
	{
		return fishes;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the corals
	 */
	public ArrayList<CoralObject> getCorals()
	{
		return corals;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the invertebrates
	 */
	public ArrayList<InvertebratesObject> getInvertebrates()
	{
		return invertebrates;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the equipment
	 */
	public ArrayList<EquipmentObject> getEquipment()
	{
		return equipment;
	}



	// SETTERS


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param fishes
	 *            the fishes to set
	 */
	public void setFishes(ArrayList<FishObject> fishes)
	{
		this.fishes = fishes;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param corals
	 *            the corals to set
	 */
	public void setCorals(ArrayList<CoralObject> corals)
	{
		this.corals = corals;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param invertebrates
	 *            the invertebrates to set
	 */
	public void setInvertebrates(ArrayList<InvertebratesObject> invertebrates)
	{
		this.invertebrates = invertebrates;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param equipment
	 *            the equipment to set
	 */
	public void setEquipment(ArrayList<EquipmentObject> equipment)
	{
		this.equipment = equipment;
	}
}
