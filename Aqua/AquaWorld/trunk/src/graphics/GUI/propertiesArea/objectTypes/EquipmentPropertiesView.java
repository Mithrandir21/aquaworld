package graphics.GUI.propertiesArea.objectTypes;


import graphics.AquaWorld;
import graphics.GUI.propertiesArea.ObjectScrollProperties;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import widgets.WidgetEquipment;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class EquipmentPropertiesView
{
	/**
	 * TODO - Description
	 */
	public static void getEquipmentProperties(JPanel panel,
			WidgetEquipment equipment)
	{

	}





	/**
	 * Creates a JPanel with more info buttons that are listened for by
	 * actionlisteners.
	 */
	private static JPanel createMoreInfoButtons()
	{
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));

		Button save = new Button(AquaWorld.texts.getString("moreInfo"));
		save
				.addActionListener(((ObjectScrollProperties) AquaWorld.propertiesPanel
						.getComponent(0)).getObjectPropertiePanel());
		save.setActionCommand("MerInfo");


		buttons.add(save);

		return buttons;
	}
}
