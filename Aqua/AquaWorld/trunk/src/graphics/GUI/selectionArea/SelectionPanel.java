package graphics.GUI.selectionArea;


import graphics.GUI.graphicalFunctions.ImageLocator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class SelectionPanel extends JPanel
{
	/**
	 * The content of the panel, which is located inside the selection area.
	 */
	private SelectionAreaInterface selectionTabContent;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param labelText
	 * @param content
	 * @param listener
	 */
	public SelectionPanel(String labelText, SelectionAreaInterface content,
			TabbedSelection listener)
	{
		setSelectionTabContent(content);

		// The ImageIcon that will be shown and will remove a tab if pressed
		ImageIcon closeXIcon = ImageLocator.getImageIconObject("Close");

		// The dimensions of the new button.
		Dimension closeButtonSize = new Dimension(
				closeXIcon.getIconWidth() + 2, closeXIcon.getIconHeight() + 2);

		// The actual panel that will be the component panel which the JLabel
		// and the button
		// will be placed inside.

		// The Panel is not opaque
		this.setOpaque(false);

		this.setName(labelText);


		// The JLabel that will show the name of the tab
		JLabel tabLabel = new JLabel(labelText);

		Font f = tabLabel.getFont();

		// Unbold
		tabLabel.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));

		// The button that will be represented by the ImageIcon
		JButton tabCloseButton = new JButton(closeXIcon);
		tabCloseButton.setName(labelText);
		tabCloseButton.setPreferredSize(closeButtonSize);
		tabCloseButton.addActionListener(content);

		// Adds the label and then the button to the panel.
		this.add(tabLabel, BorderLayout.WEST);
		this.add(tabCloseButton, BorderLayout.EAST);
	}



	/**
	 * TODO - Description NEEDED!
	 *
	 * @param selectionTabContent the selectionTabContent to set
	 */
	public void setSelectionTabContent(SelectionAreaInterface selectionTabContent)
	{
		this.selectionTabContent = selectionTabContent;
	}



	/**
	 * TODO - Description NEEDED!
	 *
	 * @return the selectionTabContent
	 */
	public SelectionAreaInterface getSelectionTabContent()
	{
		return selectionTabContent;
	}

}
