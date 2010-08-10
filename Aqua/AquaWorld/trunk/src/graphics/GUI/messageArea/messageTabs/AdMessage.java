/**
 * 
 */
package graphics.GUI.messageArea.messageTabs;


import graphics.GUI.messageArea.MessageInterface;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import coreObjects.Aquarium.Aquarium;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class AdMessage extends JPanel implements MessageInterface
{
	private JScrollPane content;


	/**
	 * TODO - Description NEEDED!
	 * 
	 */
	public AdMessage()
	{
		content = new JScrollPane();

		this.setLayout(new GridLayout());
		this.setEnabled(false);
	}


	/*
	 * (non-Javadoc)
	 * @see graphics.GUI.messageArea.MessageInterface#createMessageTab(java.lang.String[][])
	 */
	@Override
	public void createMessageTab(String[][] data)
	{
		this.add(content);
	}

	/*
	 * (non-Javadoc)
	 * @see graphics.GUI.messageArea.MessageInterface#getMessageClass()
	 */
	@Override
	public Class<?> getMessageClass()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see graphics.GUI.messageArea.MessageInterface#processInfo(coreObjects.Aquarium.Aquarium)
	 */
	@Override
	public void processInfo(Aquarium aqua)
	{
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * @see graphics.GUI.messageArea.MessageInterface#removeThisTab()
	 */
	@Override
	public void removeThisTab()
	{
		// AquaWorld.getMessageArea().removeTab(this.getClass());
	}

}
