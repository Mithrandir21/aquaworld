package graphics.GUI.selectionArea;


import java.awt.event.ActionListener;


public interface SelectionAreaInterface extends ActionListener
{
	// /**
	// * TODO - Description
	// */
	// public void createSearchTab();


	/**
	 * TODO - Description
	 */
	public void removeThisTab();


	/**
	 * Returns the class of the message JPanel.
	 */
	public Class<?> getMessageClass();

}
