package gui.groups.bottom;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXCollapsiblePane;


public class GroupSearchPanel extends JPanel implements ActionListener
{
	JTextField genusField = new JTextField();

	JTextField speciesField = new JTextField();

	JTextField popNameField = new JTextField();


	JTextField sizeLowField = new JTextField();

	JTextField sizeHighField = new JTextField();

	JTextField sizeExactField = new JTextField();

	JTextField salinityLowField = new JTextField();

	JTextField salinityHighField = new JTextField();

	JTextField salinityExactField = new JTextField();

	JTextField phLowField = new JTextField();

	JTextField phHighField = new JTextField();

	JTextField phExactField = new JTextField();

	JTextField ghLowField = new JTextField();

	JTextField ghHighField = new JTextField();

	JTextField ghExactField = new JTextField();

	JTextField khLowField = new JTextField();

	JTextField khHighField = new JTextField();

	JTextField khExactField = new JTextField();

	JTextField tempLowField = new JTextField();

	JTextField tempHighField = new JTextField();

	JTextField tempExactField = new JTextField();

	JTextField spaceNeededLowField = new JTextField();

	JTextField spaceNeededHighField = new JTextField();

	JTextField spaceNeededExactField = new JTextField();

	JTextField othersSizeLowField = new JTextField();

	JTextField othersSizeHighField = new JTextField();

	JTextField othersSizeExactField = new JTextField();


	JXCollapsiblePane exclusionsPane = new JXCollapsiblePane();

	JCheckBox exclusionsToggleBox;


	// FISH EXCLUSIONS


	JCheckBox aloneExcludeBox;

	JCheckBox aloneBox;

	JCheckBox aloneWithFamilyExcludeBox;

	JCheckBox aloneWithFamilyBox;

	JCheckBox oneInFamilyExcludeBox;

	JCheckBox oneInFamilyBox;

	JCheckBox oneMaleInFamilyExcludeBox;

	JCheckBox oneMaleInFamilyBox;

	JCheckBox oneFemaleInFamilyExcludeBox;

	JCheckBox oneFemaleInFamilyBox;




	JTextField minSchoolLowField = new JTextField();

	JTextField minSchoolHighField = new JTextField();

	JTextField minSchoolExactField = new JTextField();


	JTextField malePerLiterLowField = new JTextField();

	JTextField malePerLiterHighField = new JTextField();

	JTextField malePerLiterExactField = new JTextField();


	JTextField femalePerLiterLowField = new JTextField();

	JTextField femalePerLiterHighField = new JTextField();

	JTextField femalePerLiterExactField = new JTextField();


	JTextField fishPerLiterLowField = new JTextField();

	JTextField fishPerLiterHighField = new JTextField();

	JTextField fishPerLiterExactField = new JTextField();


	JTextField minFemalePerMaleLowField = new JTextField();

	JTextField minFemalePerMaleHighField = new JTextField();

	JTextField minFemalePerMaleExactField = new JTextField();


	JTextField minMalePerFemaleLowField = new JTextField();

	JTextField minMalePerFemaleHighField = new JTextField();

	JTextField minMalePerFemaleExactField = new JTextField();


	JCheckBox reefStoneCoralsSafe;

	JCheckBox reefLargePolipedCoralSafe;

	JCheckBox reefSoftCoralSafe;






	public GroupSearchPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		this.setBorder(BorderFactory.createEtchedBorder());
		Dimension dim = new Dimension(700, 640);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);


		d.fill = GridBagConstraints.NONE;
		// d.ipady = 0; // reset to default
		d.anchor = GridBagConstraints.FIRST_LINE_START; // bottom of space
		d.insets = new Insets(10, 10, 4, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		this.add(new JLabel("Search"), d);

		JPanel generalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		generalPanel.add(getUniquePanel("Genus", genusField, this));

		generalPanel.add(getUniquePanel("Species", speciesField, this));

		generalPanel.add(getUniquePanel("Populare Name", popNameField, this));

		generalPanel.add(getLowHighExactPanel("Size", sizeLowField,
				sizeHighField, sizeExactField, this));



		d.gridy = 1;
		this.add(generalPanel, d);


		JPanel parametersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


		parametersPanel.add(getLowHighExactPanel("Salinity", salinityLowField,
				salinityHighField, salinityExactField, this));

		parametersPanel.add(getLowHighExactPanel("PH", phLowField, phHighField,
				phExactField, this));

		parametersPanel.add(getLowHighExactPanel("GH", ghLowField, ghHighField,
				ghExactField, this));

		parametersPanel.add(getLowHighExactPanel("KH", khLowField, khHighField,
				khExactField, this));

		parametersPanel.add(getLowHighExactPanel("Temp", tempLowField,
				tempHighField, tempExactField, this));

		parametersPanel.add(getLowHighExactPanel("Space Needed",
				spaceNeededLowField, spaceNeededHighField,
				spaceNeededExactField, this));

		parametersPanel.add(getLowHighExactPanel("Others Size",
				othersSizeLowField, othersSizeHighField, othersSizeExactField,
				this));


		d.gridy = 2;
		this.add(parametersPanel, d);

		exclusionsToggleBox = new JCheckBox("Exclusions");
		exclusionsToggleBox.addActionListener(exclusionsPane.getActionMap()
				.get(JXCollapsiblePane.TOGGLE_ACTION));


		d.gridy = 3;
		this.add(exclusionsToggleBox, d);


		exclusionsPane.setCollapsed(true);
		// exclusionsPane.setLayout(new GridBagLayout());
		// GridBagConstraints x = new GridBagConstraints();
		// x.fill = GridBagConstraints.BOTH;
		// // x.ipady = 0; // reset to default
		// x.weighty = 1.0; // request any extra vertical space
		// x.weightx = 1.0; // request any extra vertical space
		// x.anchor = GridBagConstraints.NORTH; // bottom of space
		// // d.insets = new Insets(0, 80, 80, 80); // top padding
		// x.gridwidth = 1; // 2 columns wide
		// x.gridy = 0; // third row
		// x.gridx = 0;


		JTabbedPane xTabs = new JTabbedPane();


		xTabs.addTab("Fish", getFishExclusionsPanel(this));
		exclusionsPane.add(xTabs);

		xTabs.addTab("Invertebrate", getInvertebrateExclusionsPanel(this));
		exclusionsPane.add(xTabs);

		d.gridy = 4;
		this.add(exclusionsPane, d);


		d.weighty = 1.0;
		d.gridy = 5;
		d.anchor = GridBagConstraints.LAST_LINE_END;
		d.weightx = 1.0;
		this.add(getButtons("Reset", "Search", "Cancel", this), d);
	}


	private JPanel getFishExclusionsPanel(ActionListener lis)
	{
		JPanel exPanel = new JPanel();
		exPanel.setLayout(new GridBagLayout());
		GridBagConstraints x = new GridBagConstraints();
		x.fill = GridBagConstraints.NONE;
		x.ipady = 0; // reset to default
		x.weighty = 1.0; // request any extra vertical space
		x.weightx = 1.0; // request any extra vertical space
		x.anchor = GridBagConstraints.FIRST_LINE_START; // bottom of space
		x.insets = new Insets(10, 10, 4, 10); // top padding
		x.gridwidth = 1; // 2 columns wide
		x.gridy = 0; // third row
		x.gridx = 0;


		JPanel booleanBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


		booleanBoxPanel.add(getBooleanBoxWithExclude("Alone", aloneExcludeBox,
				aloneBox, lis));

		booleanBoxPanel.add(getBooleanBoxWithExclude("Only With Family",
				aloneWithFamilyExcludeBox, aloneWithFamilyBox, lis));

		booleanBoxPanel.add(getBooleanBoxWithExclude("1 of Family",
				oneInFamilyExcludeBox, oneInFamilyBox, lis));

		booleanBoxPanel.add(getBooleanBoxWithExclude("1 Male Only",
				oneMaleInFamilyExcludeBox, oneMaleInFamilyBox, lis));

		booleanBoxPanel.add(getBooleanBoxWithExclude("1 Female Only",
				oneFemaleInFamilyExcludeBox, oneFemaleInFamilyBox, lis));


		x.gridy = 0;
		exPanel.add(booleanBoxPanel, x);




		JPanel otherParPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		otherParPanel
				.add(getLowHighExactPanel("Min. School", minSchoolLowField,
						minSchoolHighField, minSchoolExactField, lis));


		otherParPanel.add(getLowHighExactPanel("Male P.L. ",
				malePerLiterLowField, malePerLiterHighField,
				malePerLiterExactField, lis));


		otherParPanel.add(getLowHighExactPanel("Female P.L.",
				femalePerLiterLowField, femalePerLiterHighField,
				femalePerLiterExactField, lis));


		otherParPanel.add(getLowHighExactPanel("Fish P.L.",
				fishPerLiterLowField, fishPerLiterHighField,
				fishPerLiterExactField, lis));


		otherParPanel.add(getLowHighExactPanel("M.F.P.M.",
				minFemalePerMaleLowField, minFemalePerMaleHighField,
				minFemalePerMaleExactField, lis));


		otherParPanel.add(getLowHighExactPanel("M.M.P.F.",
				minMalePerFemaleLowField, minMalePerFemaleHighField,
				minMalePerFemaleExactField, lis));


		// otherParPanel.add(getLowHighExactPanel("Reef Safe",
		// lis, false));



		x.weighty = 1.0;
		x.gridy = 1;
		exPanel.add(otherParPanel, x);


		return exPanel;
	}



	private JPanel getInvertebrateExclusionsPanel(ActionListener lis)
	{
		JPanel exPanel = new JPanel();
		exPanel.setLayout(new GridBagLayout());
		GridBagConstraints x = new GridBagConstraints();
		x.fill = GridBagConstraints.BOTH;
		// x.ipady = 0; // reset to default
		x.weighty = 1.0; // request any extra vertical space
		x.weightx = 1.0; // request any extra vertical space
		x.anchor = GridBagConstraints.NORTH; // bottom of space
		// d.insets = new Insets(0, 80, 80, 80); // top padding
		x.gridwidth = 1; // 2 columns wide
		x.gridy = 0; // third row
		x.gridx = 0;



		return exPanel;
	}


	private JPanel getButtons(String button1name, String button2name,
			String button3name, ActionListener lis)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// buttonPanel.setLayout(new BoxLayout(buttonPanel,
		// BoxLayout.PAGE_AXIS));
		Dimension panelSize = new Dimension(115, 80);
		buttonPanel.setPreferredSize(panelSize);
		buttonPanel.setMinimumSize(panelSize);
		buttonPanel.setMaximumSize(panelSize);


		JButton button1 = new JButton(button1name);
		button1.setFocusable(false);
		button1.addActionListener(lis);
		button1.setActionCommand(button1name);
		Dimension textSize = new Dimension(100, 20);
		button1.setPreferredSize(textSize);
		button1.setMinimumSize(textSize);
		button1.setMaximumSize(textSize);


		JButton button2 = new JButton(button2name);
		button2.addActionListener(lis);
		button2.setActionCommand(button2name);
		button2.setPreferredSize(textSize);
		button2.setMinimumSize(textSize);
		button2.setMaximumSize(textSize);


		JButton button3 = new JButton(button3name);
		button3.addActionListener(lis);
		button3.setActionCommand(button3name);
		button3.setPreferredSize(textSize);
		button3.setMinimumSize(textSize);
		button3.setMaximumSize(textSize);


		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);

		return buttonPanel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(String valueName, JTextField field,
			ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 45);
		panel.setPreferredSize(panelSize);
		panel.setMinimumSize(panelSize);
		panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());

		// JPanel panel1 = new JPanel(new GridBagLayout());
		// Dimension panelSize1 = new Dimension(200, 400);
		// panel1.setPreferredSize(panelSize1);
		// panel1.setMinimumSize(panelSize1);
		// panel1.setMaximumSize(panelSize1);
		// panel1.setBorder(BorderFactory.createEtchedBorder());

		GridBagConstraints c = new GridBagConstraints();


		JLabel label = new JLabel(valueName);
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.CENTER; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 0; // third row
		panel.add(label, c);


		Dimension textSize = new Dimension(100, 20);
		field.addActionListener(lis);
		field.setPreferredSize(textSize);
		field.setMinimumSize(textSize);
		field.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		c.weighty = 1.0;
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(4, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(field, c);


		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getLowHighExactPanel(String valueName, JTextField low,
			JTextField high, JTextField exact, ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(100, 100);
		panel.setPreferredSize(panelSize);
		panel.setMinimumSize(panelSize);
		panel.setMaximumSize(panelSize);
		panel.setBorder(BorderFactory.createEtchedBorder());

		// JPanel panel1 = new JPanel(new GridBagLayout());
		// Dimension panelSize1 = new Dimension(200, 400);
		// panel1.setPreferredSize(panelSize1);
		// panel1.setMinimumSize(panelSize1);
		// panel1.setMaximumSize(panelSize1);
		// panel1.setBorder(BorderFactory.createEtchedBorder());

		GridBagConstraints c = new GridBagConstraints();


		JLabel label1 = new JLabel(valueName);
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.CENTER; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 0; // third row
		panel.add(label1, c);


		Dimension textSize = new Dimension(40, 20);
		low.addActionListener(lis);
		low.setPreferredSize(textSize);
		low.setMinimumSize(textSize);
		low.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(0, 0, 0, 10); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 1; // third row
		panel.add(low, c);


		high.addActionListener(lis);
		high.setPreferredSize(textSize);
		high.setMinimumSize(textSize);
		high.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(0, 0, 0, 0); // top padding
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 1; // third row
		panel.add(high, c);


		JLabel label2 = new JLabel("Low");
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(label2, c);


		JLabel label3 = new JLabel("High");
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(label3, c);


		exact.addActionListener(lis);
		exact.setPreferredSize(textSize);
		exact.setMinimumSize(textSize);
		exact.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.CENTER; // bottom of space
		c.insets = new Insets(5, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row
		panel.add(exact, c);



		JLabel labelPin = new JLabel("Eaxct");
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		c.anchor = GridBagConstraints.CENTER; // bottom of space
		c.insets = new Insets(0, 0, 5, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 4; // third row
		panel.add(labelPin, c);


		return panel;
	}




	/**
	 * TODO - Description
	 */
	public static JPanel getBooleanBoxWithExclude(String valuename,
			JCheckBox exclude, JCheckBox check, ActionListener lis)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// Dimension panelSize = new Dimension(100, 40);
		// panel.setPreferredSize(panelSize);
		// panel.setMinimumSize(panelSize);
		// panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());


		exclude = new JCheckBox("Exclude");
		exclude.addActionListener(lis);
		panel.add(exclude);




		// JPanel checkPanel = new JPanel();

		check = new JCheckBox(valuename);
		// checkPanel.setBorder(BorderFactory.createEtchedBorder());
		check.setActionCommand(valuename);
		check.addActionListener(lis);
		// checkPanel.add(check);

		panel.add(check);

		return panel;
	}




	private void saveAction()
	{
		System.out.println("Save action");
	}





	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() instanceof JButton )
		{
			String action = e.getActionCommand();

			if ( action.equalsIgnoreCase("Reset") )
			{
				JPanel searchPanel = new GroupSearchPanel();
				GroupBottomPanel.search.setViewportView(searchPanel);
			}
			else if ( action.equalsIgnoreCase("Search") )
			{
				saveAction();
			}
			else if ( action.equalsIgnoreCase("searchToggle")
					|| action.equalsIgnoreCase("Cancel") )
			{
				GroupBottomPanel.changeMode();
			}
		}
		else if ( e.getSource() instanceof JCheckBox )
		{

		}
	}
}
