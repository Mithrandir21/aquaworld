/**
 * 
 */
package gui.editing;


import gui.groups.GroupsFrame;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import coreObjects.AbstractObject;


/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
public class JPopupEditingList extends JPopupMenu implements ActionListener
{
	private AbstractObject object;


	/**
	 * TODO - Description NEEDED!
	 *
	 */
	public JPopupEditingList(AbstractObject obj, Point localLocation)
	{
		if ( obj != null && localLocation != null )
		{
			object = obj;
			createPopupMenu(localLocation);
		}
	}


	/**
	 * The function calls the menu creator and returns the finished JPopupMenu.
	 * 
	 * @param localLocation
	 *            The location(Point) on the WorkareaCanvas that the menu will
	 *            be shown at
	 * @return The JPopupMenu that will be shown when a user right clicks on an
	 *         empty part of a WorkareaCanvas.
	 */
	public void createPopupMenu(Point localLocation)
	{
		JMenuItem Item = new JMenuItem("Delete");
		Item.addActionListener(this);
		this.add(Item);
	}



	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// A boolean on whether the object has been removed
		boolean removed = false;

		int answer = JOptionPane.showConfirmDialog(this,
				"Are you sure you wish to DELETE this object?", "Confirm",
				JOptionPane.YES_NO_OPTION);

		// If the user answers yes
		if ( answer == JOptionPane.YES_OPTION )
		{
			if ( EditingFrame.editingObjectView != null )
			{
				removed = EditingFrame.deleteObject(object);
			}

			// If the object was not removed
			if ( !removed )
			{
				GroupsFrame.deleteObject(object);
			}
		}
	}
}
