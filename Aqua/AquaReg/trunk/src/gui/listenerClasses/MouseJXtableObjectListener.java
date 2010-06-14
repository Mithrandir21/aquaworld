/**
 * 
 */
package gui.listenerClasses;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import coreObjects.AbstractObject;


/**
 * This is the classes mouseListener. It gets the source of the mouse event, and adds the {@link AbstractObject} to the JList in
 * the groups view.
 * 
 * @author Bahram Malaekeh
 */
public class MouseJXtableObjectListener extends MouseAdapter
{
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// If button1 is double clicked.
		if ( e.getClickCount() == 2 )
		{
			System.out.println("mouseClicked");
		}
	}
}
