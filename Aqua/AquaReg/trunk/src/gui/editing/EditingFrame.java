package gui.editing;


import gui.views.EditingView;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import coreObjects.AbstractObject;


public class EditingFrame extends JFrame
{
	/**
	 * The object being shown.
	 */
	public static AbstractObject editingObject;


	/**
	 * 
	 */
	public static EditingView editingObjectView = new EditingView();


	public EditingFrame()
	{
		super("Editing");

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


		EditingTab list = new EditingTab();
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
	}
}
