package graphics.GUI.selectionArea;


/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */


import graphics.GUI.selectionArea.tabContent.SelectionOverview;
import graphics.canvas.WorkareaCanvas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


/**
 * This JTabbedPane extension is where the selection area and Networkmodels area
 * is located.
 * The selection area is where the user can click'n'drag new
 * {@link WidgetObject WidgetObjects} into an open {@link WorkareaCanvas}.
 * The Networkmodels area is where the user can see all the network models he
 * can open and edit.
 * 
 * @author Bahram Malaekeh
 */
public class TabbedSelection extends JTabbedPane
{
	/**
	 * The JScrollPane that holds the object selection area and the file area.
	 */
	JScrollPane scrollArea = null;


	/**
	 * A constructor for the class that adds both the selection area tab for the
	 * {@link Object Objects} and the network models tabs for the
	 * {@link WorkareaCanvas}.
	 */
	public TabbedSelection()
	{
		SelectionOverview fish = new SelectionOverview();
		SelectionOverview fish1 = new SelectionOverview();
		addNewMessageTab("FishX", fish);
		addNewMessageTab("Fish1", fish1);


		// The following line enables to use scrolling tabs.
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}



	/**
	 * This method creates a custom Tab with an close button.
	 * 
	 * @param labelText
	 *            The text that will be shown inside the tab.
	 * @param content
	 *            The content that will be shown within the tab.
	 */
	public void addNewMessageTab(String labelText, JPanel content)
	{
		SelectionPanel tab = new SelectionPanel(labelText,
				(SelectionAreaInterface) content, this);

		JScrollPane scroll = new JScrollPane(content);
		
		// Add the tab to the JTabbed pane.
		this.addTab(labelText, scroll);

		// Instead of using a String/Icon combination for the tab,
		// use our panel instead.
		this.setTabComponentAt(this.getTabCount() - 1, tab);
	}




	/**
	 * This method removes the tab with the given name from this class, which is
	 * a JTabbedPane.
	 * 
	 * @param title
	 *            The title of the Tab that is to be removed.
	 */
	public void removeTab(Class<?> messageTabClass)
	{
		// Searching for the tab with the given title
		for ( int i = 0; i < this.getTabCount(); i++ )
		{
			// Gets the MessagePanel that has been added to this JTabbedPanes
			SelectionPanel test = (SelectionPanel) this.getTabComponentAt(i);

			// If the class of the content is the same as the given class
			if ( test.getSelectionTabContent().getMessageClass().equals(
					messageTabClass) )
			{
				this.remove(i);
			}
		}
	}
}