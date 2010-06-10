package graphics.GUI.messageArea;


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
public class MessagePanel extends JPanel
{
	/**
	 * The {@link MessageInterface} that holds the info.
	 */
	private MessageInterface messageTabContent;





	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param labelText
	 * @param content
	 * @param listener
	 */
	public MessagePanel(String labelText, MessageInterface content,
			MessageTabbed listener)
	{
		messageTabContent = content;

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
		tabCloseButton.addActionListener(listener);

		// Adds the label and then the button to the panel.
		this.add(tabLabel, BorderLayout.WEST);
		this.add(tabCloseButton, BorderLayout.EAST);
	}





	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the messageTabContent
	 */
	public MessageInterface getMessageTabContent()
	{
		return messageTabContent;
	}





	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param messageTabContent
	 *            the messageTabContent to set
	 */
	public void setMessageTabContent(MessageInterface messageTabContent)
	{
		this.messageTabContent = messageTabContent;
	}
}
