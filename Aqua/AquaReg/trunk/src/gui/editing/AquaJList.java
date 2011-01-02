package gui.editing;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(final MouseEvent e)
			{
				if ( e.isPopupTrigger() )
				{
					// final int index = result.locationToIndex(e.getPoint());
					// result.setSelectedIndex(index);
				}
				// this.maybeShowPopup(e);
			}
		});
	}

	/**
	 * TODO - Description NEEDED!
	 */
	public AquaJList(AbstractObject[] list)
	{
		if ( list != null )
		{
			this.setListData(list);

			this.addMouseListener(new MouseAdapter()
			{
				public void mousePressed(final MouseEvent e)
				{
					if ( e.isPopupTrigger() )
					{
						// final int index =
						// result.locationToIndex(e.getPoint());
						// result.setSelectedIndex(index);
					}
					// this.maybeShowPopup(e);
				}
			});
		}
	}



}
