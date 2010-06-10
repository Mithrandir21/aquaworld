package gui.editing;


import java.util.ArrayList;

import javax.swing.JList;

import coreObjects.AbstractObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class AquaJList extends JList
{

	/**
	 * The objects list that holds the objects shown in the JList.
	 */
	ArrayList<AbstractObject> objectList = new ArrayList<AbstractObject>();



	/**
	 * TODO - Description NEEDED!
	 */
	public AquaJList(ArrayList<AbstractObject> list)
	{
		objectList = list;
		this.setListData(list.toArray());
	}





	/**
	 * TODO - Description NEEDED!
	 */
	public AquaJList(AbstractObject[] list)
	{
		this.setListData(list);
	}
}
