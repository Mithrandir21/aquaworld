/**
 * 
 */
package graphics.GUI.messageArea;


import coreObjects.Aquarium.Aquarium;


/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
public interface MessageInterface
{
	/**
	 * TODO - Description
	 */
	public void processInfo(Aquarium aqua);


	/**
	 * TODO - Description
	 */
	public void createMessageTab(String[][] data);


	/**
	 * TODO - Description
	 */
	public void removeThisTab();


	/**
	 * Returns the class of the message JPanel.
	 */
	public Class<?> getMessageClass();

}
