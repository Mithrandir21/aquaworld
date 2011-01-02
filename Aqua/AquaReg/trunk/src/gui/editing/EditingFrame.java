package gui.editing;


import gui.AquaReg;
import gui.views.EditingView;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import sqlLogic.SQLfunctions;
import coreObjects.AbstractObject;
import coreObjects.Fish.FishObject;


public class EditingFrame extends JFrame
{
	/**
	 * The object being shown.
	 */
	public static AbstractObject editingObject;


	/**
	 * 
	 */
	public static EditingTab list;


	/**
	 * 
	 */
	public static EditingView editingObjectView;


	public EditingFrame()
	{
		super("Editing");

		editingObjectView = new EditingView(true, true, FishObject.class);

		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		list = new EditingTab();
		list.setBorder(BorderFactory.createEtchedBorder());
		this.add(list, d);



		// d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		// d.weightx = 0.65; // request any extra vertical space
		d.anchor = GridBagConstraints.WEST; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 1;




		editingObjectView.setBorder(BorderFactory.createEtchedBorder());
		this.add(editingObjectView, d);




		this.setResizable(false);
		this.setPreferredSize(new Dimension(1000, 400));
		this.setVisible(true);
		this.pack();


		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent ev)
			{
				list = null;
				editingObjectView = null;
			}
		});
	}



	/**
	 * This function attempts to remove the given {@link AbstractObject} from 
	 * the database and refresh the editing view.
	 */
	public static boolean deleteObject(AbstractObject object)
	{
		if ( object != null && editingObjectView != null && list != null )
		{
			Connection con = AquaReg.getConnectionToDB();

			// If the object is removed from the database
			if ( SQLfunctions.databaseRemoveAbstractObject(con, object) )
			{
				editingObjectView.resetAction();
				list.refreshJLists();

				return true;
			}
		}

		return false;
	}
}
