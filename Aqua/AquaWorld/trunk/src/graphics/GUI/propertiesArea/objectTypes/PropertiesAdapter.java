package graphics.GUI.propertiesArea.objectTypes;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * A {@link KeyAdapter} extension that only has one overridden method,
 * keyPressed. This method calls the save function for the properties panel.
 * 
 * @author Bahram Malaekeh
 */
public class PropertiesAdapter extends KeyAdapter
{
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if ( key == KeyEvent.VK_ENTER )
		{
			// ObjectScrollProperties objPro = (ObjectScrollProperties) AquaWorld.propertiesPanel
			// .getComponent(0);
			// objPro.getObjectPropertiePanel().saveAction();
		}
	}
}
