package gui;


import gui.editing.EditingFrame;
import gui.groups.GroupsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class RegMenu extends JMenuBar implements ActionListener
{
	// The menu buttons at the top of the screen
	private JMenu tools;


	public RegMenu()
	{
		tools = new JMenu("Tools");


		JMenuItem createGroup = new JMenuItem("Groups");
		createGroup.setActionCommand("group");
		createGroup.addActionListener(this);

		JMenuItem editFish = new JMenuItem("Edit Objects");
		editFish.setActionCommand("edit");
		editFish.addActionListener(this);


		tools.add(createGroup);
		tools.add(editFish);

		this.add(tools);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();

		if ( action.equals("group") )
		{
			new GroupsFrame();
		}
		else if ( action.equals("edit") )
		{
			new EditingFrame();
		}
	}
}
