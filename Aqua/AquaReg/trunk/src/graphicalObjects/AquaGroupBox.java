/**
 * 
 */
package graphicalObjects;


import java.util.ArrayList;

import javax.swing.JCheckBox;


/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
public class AquaGroupBox extends JCheckBox
{
	public ArrayList<AquaPanel> objectPanels = new ArrayList<AquaPanel>();

	public AquaGroupBox(String string)
	{
		super(string);
	}
}
