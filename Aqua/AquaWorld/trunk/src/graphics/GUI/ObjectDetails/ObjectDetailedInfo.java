/**
 * 
 */
package graphics.GUI.ObjectDetails;


import graphics.AquaUneditableJCheckBox;
import graphics.AquaWorld;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import logistical.DataRetrival;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import coreObjects.AbstractObject;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class ObjectDetailedInfo extends JPanel
{


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param obj
	 */
	public ObjectDetailedInfo(AbstractObject obj)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridx = 0;
		d.gridy = 0;


		JXTaskPaneContainer tpc = new JXTaskPaneContainer();
		// tpc.setBackground(this.getBackground());


		// Adds the group panel to the collapsible container
		tpc.add(getParametersPanel(AquaWorld.texts
				.getString("objectGeneralGroupName"), false, obj));


		// Adds the group panel to the collapsible container
		tpc.add(getExclusionsPanel(AquaWorld.texts
				.getString("objectExclusionsGroupName"), true, obj));

		// Adds the group panel to the collapsible container
		tpc.add(getFishCompatibilityExclusionsPanel(AquaWorld.texts
				.getString("objectCompatibilityGroupName"), true,
				(FishObject) obj));


		JScrollPane scrollArea = new JScrollPane(tpc);
		// Increases how far the scroll bar scrolls on one step of a mouse wheel
		scrollArea.getVerticalScrollBar().setUnitIncrement(30);


		// Adds the container to this panel
		this.add(scrollArea, d);
	}





	/**
	 * TODO - Description
	 */
	public JXTaskPane getParametersPanel(String groupName, boolean collapsed,
			AbstractObject obj)
	{
		// "System" GROUP
		JXTaskPane group = new JXTaskPane();
		group.setTitle(groupName);
		group.setSpecial(true);
		group.setCollapsed(collapsed);



		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 0.3; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(5, 5, 5, 5); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		// d.gridy = 0;
		// d.gridx = 0;

		String[] data = DataRetrival.getObjectsData(obj);



		d.gridy = 0;
		d.gridx = 0;
		panel.add(
				getUniquePanel(AquaWorld.texts.getString("salinity"), data[1]),
				d);


		d.gridy = 0;
		d.gridx = 1;
		panel.add(getUniquePanel(AquaWorld.texts.getString("ph"), data[2]), d);


		d.gridy = 0;
		d.gridx = 2;
		panel.add(getUniquePanel(AquaWorld.texts.getString("gh"), data[3]), d);


		d.gridy = 1;
		d.gridx = 0;
		panel.add(getUniquePanel(AquaWorld.texts.getString("kh"), data[4]), d);


		d.gridy = 1;
		d.gridx = 1;
		panel.add(getUniquePanel(AquaWorld.texts.getString("temperatur"),
				data[5]), d);


		d.gridy = 1;
		d.gridx = 2;
		panel.add(getUniquePanel(AquaWorld.texts.getString("magnesium"),
				data[6]), d);


		d.gridy = 2;
		d.gridx = 0;
		panel.add(
				getUniquePanel(AquaWorld.texts.getString("calcium"), data[7]),
				d);


		d.gridy = 2;
		d.gridx = 1;
		panel.add(getUniquePanel(AquaWorld.texts.getString("spaceneeded"),
				data[8]), d);


		d.weighty = 1.0; // request any extra vertical space
		d.gridy = 2;
		d.gridx = 2;
		panel.add(getUniquePanel(AquaWorld.texts.getString("othersSize"),
				data[9]), d);



		// Adds the panel with the objects to the group panel
		group.add(panel);

		return group;
	}



	/**
	 * TODO - Description
	 */
	public JXTaskPane getExclusionsPanel(String groupName, boolean collapsed,
			AbstractObject obj)
	{
		// "System" GROUP
		JXTaskPane group = new JXTaskPane();
		group.setTitle(groupName);
		group.setSpecial(true);
		group.setCollapsed(collapsed);



		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(5, 5, 5, 5); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0;
		d.gridy = 0;

		JXTaskPaneContainer tpc = new JXTaskPaneContainer();
		tpc.setBackground(panel.getBackground());


		// Adds the group panel to the collapsible container
		tpc.add(getFishSimpleExclusionsPanel(AquaWorld.texts
				.getString("objectSimpleGroupName"), false, (FishObject) obj));


		// Adds the group panel to the collapsible container
		tpc.add(getFishGenusExclusionsPanel(AquaWorld.texts
				.getString("objectGroupsGroupName"), true, (FishObject) obj));


		panel.add(tpc, d);


		// Adds the panel with the objects to the group panel
		group.add(panel);

		return group;
	}



	/**
	 * TODO - Description
	 */
	public JXTaskPane getFishSimpleExclusionsPanel(String groupName,
			boolean collapsed, FishObject obj)
	{
		// "System" GROUP
		JXTaskPane group = new JXTaskPane();
		group.setTitle(groupName);
		group.setSpecial(true);
		group.setCollapsed(collapsed);



		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(0, 0, 5, 0); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide


		FishExclusions ex = obj.getFishExclusions();

		d.gridy = 0;
		d.gridx = 0;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectIsAloneLable"), ex.isAllAlone()), d);

		d.gridy = 0;
		d.gridx = 1;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectAloneWithFamilyLabel"), ex
				.isAloneWithSpecies()), d);

		d.gridy = 0;
		d.gridx = 2;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectOnlyOneInFamilyLabel"), ex
				.isOnlyOneInSpecies()), d);

		d.gridy = 1;
		d.gridx = 0;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectOnlyOneMaleLabel"), ex.isOnlyOneMale()), d);

		d.weighty = 1.0; // request any extra vertical space
		d.gridy = 1;
		d.gridx = 1;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectOnlyOneFemaleLabel"), ex.isOnlyOneFemale()),
				d);


		// Adds the panel with the objects to the group panel
		group.add(panel);

		return group;
	}



	/**
	 * TODO - Description
	 */
	public JXTaskPane getFishGenusExclusionsPanel(String groupName,
			boolean collapsed, FishObject obj)
	{
		// "System" GROUP
		JXTaskPane group = new JXTaskPane();
		group.setTitle(groupName);
		group.setSpecial(true);
		group.setCollapsed(collapsed);



		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(0, 0, 5, 0); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide


		FishExclusions ex = obj.getFishExclusions();

		d.gridy = 0;
		d.gridx = 0;
		panel.add(getUniquePanel(AquaWorld.texts
				.getString("objectOneMalePerLiterLabel"), ex
				.getOnlyOneMalePerLiter()
				+ ""), d);

		d.gridy = 0;
		d.gridx = 1;
		panel.add(getUniquePanel(AquaWorld.texts
				.getString("objectOneFemalePerLiterLabel"), ex
				.getOnlyOneFemalePerLiter()
				+ ""), d);

		d.gridy = 0;
		d.gridx = 2;
		panel.add(getUniquePanel(AquaWorld.texts
				.getString("objectMinMalesPerFemaleLabel"), ex
				.getMinumimMalesPerFemale()
				+ ""), d);

		d.gridy = 1;
		d.gridx = 0;
		panel.add(getUniquePanel(AquaWorld.texts
				.getString("objectMinFemalesPerMaleLabel"), ex
				.getMinumimFemalesPerMale()
				+ ""), d);

		d.weighty = 1.0; // request any extra vertical space
		d.gridy = 1;
		d.gridx = 1;
		panel.add(getUniquePanel(AquaWorld.texts
				.getString("objectMinSchoolSizeLabel"), ex
				.getMinimumSchoolSize()
				+ ""), d);


		// Adds the panel with the objects to the group panel
		group.add(panel);

		return group;
	}



	/**
	 * TODO - Description
	 */
	public JXTaskPane getFishCompatibilityExclusionsPanel(String groupName,
			boolean collapsed, FishObject obj)
	{
		// "System" GROUP
		JXTaskPane group = new JXTaskPane();
		group.setTitle(groupName);
		group.setSpecial(true);
		group.setCollapsed(collapsed);



		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(0, 0, 5, 0); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide


		FishExclusions ex = obj.getFishExclusions();

		d.gridy = 0;
		d.gridx = 0;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectIsAloneLable"), ex.isAllAlone()), d);

		d.gridy = 0;
		d.gridx = 1;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectAloneWithFamilyLabel"), ex.isAllAlone()), d);

		d.gridy = 0;
		d.gridx = 2;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectOnlyOneInFamilyLabel"), ex.isAllAlone()), d);

		d.gridy = 1;
		d.gridx = 0;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectOnlyOneMaleLabel"), ex.isAllAlone()), d);

		d.gridy = 1;
		d.gridx = 1;
		panel.add(getUniqueBooleanPanel(AquaWorld.texts
				.getString("objectOnlyOneFemaleLabel"), ex.isAllAlone()), d);


		// Adds the panel with the objects to the group panel
		group.add(panel);

		return group;
	}







	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(String labelName, String value)
	{
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createEmptyBorder(), labelName));

		JTextField valueLabel = new JTextField(value);
		valueLabel.setBorder(BorderFactory.createEtchedBorder());
		valueLabel.setEditable(false);
		valueLabel.setBackground(Color.WHITE);

		panel.add(valueLabel);


		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getUniqueBooleanPanel(String labelName, boolean checked)
	{
		JPanel panel = new JPanel(new GridLayout());

		AquaUneditableJCheckBox valueCheck = new AquaUneditableJCheckBox(
				labelName, checked);

		panel.add(valueCheck);


		return panel;
	}
}
