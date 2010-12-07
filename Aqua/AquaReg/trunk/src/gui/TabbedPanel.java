package gui;


import gui.views.CoralView;
import gui.views.FishView;
import gui.views.InvertebrateView;

import javax.swing.JTabbedPane;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class TabbedPanel extends JTabbedPane
{
	/**
	 * TODO - Description NEEDED!
	 */
	public TabbedPanel()
	{
		this.addTab("Fish", new FishView(false, false));

		this.addTab("Coral", new CoralView(false, false));

		this.addTab("Invertebrate", new InvertebrateView(false, false));
	}
}
