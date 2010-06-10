/**
 * 
 */
package graphics.GUI.messageArea;


import graphics.AquaWorld;
import graphics.canvas.WorkareaCanvas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * A class that will contain the different Message Panel that will show the user
 * messages regarding the {@link WorkareaCanvas} that is currently being
 * displayed. All tabs will be disabled in creation, and Tab titles will be
 * shown in bold when content is added to the JTable inside each tab.
 * 
 * @author Bahram Malaekeh
 */
public class MessageTabbed extends JTabbedPane implements ActionListener
{
	/**
	 * A constructor for this class that initiates the the different JPanels in
	 * this class. It also sets the preferred size of this JTabbedPane.
	 */
	public MessageTabbed()
	{
		int width = (int) (AquaWorld.width * 0.70);

		int height = (int) (AquaWorld.height * 0.40);


		// this.setMinimumSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
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
			MessagePanel test = (MessagePanel) this.getTabComponentAt(i);

			// If the class of the content is the same as the given class
			if ( test.getMessageTabContent().getMessageClass().equals(
					messageTabClass) )
			{
				this.remove(i);
			}
		}
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
		MessagePanel tab = new MessagePanel(labelText,
				(MessageInterface) content, this);


		// Add the tab to the JTabbed pane.
		this.addTab(labelText, content);

		// Instead of using a String/Icon combination for the tab,
		// use our panel instead.
		this.setTabComponentAt(this.getTabCount() - 1, tab);
	}



	/**
	 * This function finds the tab, if it exists, where the given string is
	 * equal the tab title. If the tab is found, the font of the title in the
	 * tab will be set to <b>bold</b>.
	 * 
	 * @param name
	 *            The title of the tab where the font is to be set to bold.
	 */
	public void boldTab(Class<?> messageTabClass)
	{
		// This is the current number of tabs
		int arraySize = this.getTabCount();

		// Goes through the list of tab contents until it finds one that matches
		// the given button name.
		for ( int i = 0; i < arraySize; i++ )
		{
			// Gets the MessagePanel that has been added to this JTabbedPanes
			MessagePanel test = (MessagePanel) this.getTabComponentAt(i);

			// If the class of the content is the same as the given class
			if ( test.getMessageTabContent().getMessageClass().equals(
					messageTabClass) )
			{
				JLabel label = (JLabel) test.getComponent(0);
				//
				Font f = label.getFont();

				// bold
				if ( !f.isBold() )
				{
					label.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
				}
			}
		}
	}


	/**
	 * This function finds the tab, if it exists, where the given string is
	 * equal the tab title. If the tab is found, the font of the title in the
	 * tab will be set to not bold.
	 * 
	 * @param name
	 *            The title of the tab where the font is to be set to unbold.
	 */
	public void unboldTab(Class<?> messageTabClass)
	{
		// This is the current number of tabs
		int arraySize = this.getTabCount();

		// Goes through the list of tab contents until it finds one that matches
		// the given button name.
		for ( int i = 0; i < arraySize; i++ )
		{
			// Gets the MessagePanel that has been added to this JTabbedPanes
			MessagePanel test = (MessagePanel) this.getTabComponentAt(i);
			
			// If the class of the content is the same as the given class
			if ( test.getMessageTabContent().getMessageClass().equals(
					messageTabClass) )
			{
				JLabel label = (JLabel) test.getComponent(0);
				//
				Font f = label.getFont();

				// Unbold
				if ( f.isBold() )
				{
					label.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
				}
			}
		}
	}



	/**
	 * Searches for a Tab where the {@link JPanel} within has a name equal to
	 * the given string. If such a tab exists, the index of that tab in the
	 * JTabbedPane is returned. If no tab is found -1 is returned.
	 * 
	 * @param name
	 *            The name of the {@link JPanel} searched for inside this
	 *            classes tabs.
	 * @return The index where the tab with the {@link JPanel} that has the name
	 *         equal to the given string is located. If it is not found, -1 will
	 *         be returned.
	 */
	private int getIndexOfTab(String name)
	{
		// This is the current number of tabs
		int arraySize = this.getTabCount();

		// Goes through the list of tab contents until it finds one that matches
		// the given button name.
		for ( int i = 0; i < arraySize; i++ )
		{
			JPanel test = (JPanel) this.getTabComponentAt(i);

			String tabName = test.getName();

			// If the name of the button and the name of the content match, the
			// button to close that
			// tab with the given content has been pressed and the tab is
			// removed.
			if ( tabName != null && tabName.equals(name) )
			{
				return i;
			}
		}

		// If no tab was found with the given name
		return -1;
	}



	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{

		if ( e.getSource() instanceof JButton )
		{
			// Since there is no other components in this class that can call
			// the ActionPerformed method
			// then the created JButton, we cast the source of the event as a
			// JButton.
			JButton button = (JButton) e.getSource();



			// This is the current number of tabs
			int arraySize = this.getTabCount();

			// Goes through the list of tab contents until it finds one that
			// matches the given button name.
			for ( int i = 0; i < arraySize; i++ )
			{
				// Gets the MessagePanel that has been added to this
				// JTabbedPanes
				MessagePanel test = (MessagePanel) this.getTabComponentAt(i);

				// Removes the
				test.getMessageTabContent().removeThisTab();
			}
		}
	}
}
