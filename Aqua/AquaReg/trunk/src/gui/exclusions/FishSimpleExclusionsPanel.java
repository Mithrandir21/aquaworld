package gui.exclusions;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import coreObjects.Fish.FishExclusions;


public class FishSimpleExclusionsPanel extends JPanel
{
	private JCheckBox aloneBox;

	private JCheckBox aloneWithFamilyBox;

	private JCheckBox onlyOneInFamilyBox;

	private JCheckBox onlyOneMaleInFamilyBox;

	private JCheckBox onlyOneFemaleInFamilyBox;




	private JTextField minSchoolLowField = new JTextField();

	private JTextField minSchoolHighField = new JTextField();


	private JTextField malePerLiterLowField = new JTextField();

	private JTextField malePerLiterHighField = new JTextField();


	private JTextField femalePerLiterLowField = new JTextField();

	private JTextField femalePerLiterHighField = new JTextField();


	private JTextField fishPerLiterLowField = new JTextField();

	private JTextField fishPerLiterHighField = new JTextField();


	private JTextField minFemalePerMaleLowField = new JTextField();

	private JTextField minFemalePerMaleHighField = new JTextField();


	private JTextField minMalePerFemaleLowField = new JTextField();

	private JTextField minMalePerFemaleHighField = new JTextField();



	public FishSimpleExclusionsPanel(ActionListener lis)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row



		JPanel booleanBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


		booleanBoxPanel.add(getBooleanBox("Alone", aloneBox, lis));

		booleanBoxPanel.add(getBooleanBox("Only With Family",
				aloneWithFamilyBox, lis));

		booleanBoxPanel.add(getBooleanBox("1 of Family", onlyOneInFamilyBox,
				lis));

		booleanBoxPanel.add(getBooleanBox("1 Male Only",
				onlyOneMaleInFamilyBox, lis));

		booleanBoxPanel.add(getBooleanBox("1 Female Only",
				onlyOneFemaleInFamilyBox, lis));


		// d.gridy = 3;
		this.add(booleanBoxPanel, d);







		JPanel otherParPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		otherParPanel.add(getLowHighPanel(minSchoolLowField,
				minSchoolHighField, "Min. School", lis));


		otherParPanel.add(getLowHighPanel(malePerLiterLowField,
				malePerLiterHighField, "Male P.L. ", lis));


		otherParPanel.add(getLowHighPanel(femalePerLiterLowField,
				femalePerLiterHighField, "Female P.L.", lis));


		otherParPanel.add(getLowHighPanel(fishPerLiterLowField,
				fishPerLiterHighField, "Fish P.L.", lis));


		otherParPanel.add(getLowHighPanel(minFemalePerMaleLowField,
				minFemalePerMaleHighField, "M.F.P.M.", lis));


		otherParPanel.add(getLowHighPanel(minMalePerFemaleLowField,
				minMalePerFemaleHighField, "M.M.P.F.", lis));


		// otherParPanel.add(getLowHighPanel("Reef Safe", lis));

		d.weighty = 1.0;
		d.gridy = 1;
		this.add(otherParPanel, d);
	}






	/**
	 * TODO - Description
	 * @param check 
	 */
	public static JPanel getBooleanBox(String valuename, JCheckBox check,
			ActionListener lis)
	{
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// Dimension panelSize = new Dimension(100, 40);
		// panel.setPreferredSize(panelSize);
		// panel.setMinimumSize(panelSize);
		// panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());


		check = new JCheckBox(valuename);
		check.setActionCommand(valuename);
		check.addActionListener(lis);
		panel.add(check);

		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getLowHighPanel(JTextField low, JTextField high,
			String valueName, ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 90);
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
		low = new JTextField();
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


		high = new JTextField();
		high.setPreferredSize(textSize);
		high.setMinimumSize(textSize);
		high.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
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


		return panel;
	}



	/**
	 * TODO - Description
	 * 
	 */
	private void loadExclusions(FishExclusions ex)
	{
		if ( ex != null )
		{
			// Sets the settings
			aloneBox.setSelected(ex.isAllAlone());
			aloneWithFamilyBox.setSelected(ex.isAloneWithSpecies());
			onlyOneInFamilyBox.setSelected(ex.isOnlyOneInSpecies());
			onlyOneMaleInFamilyBox.setSelected(ex.isOnlyOneMale());
			onlyOneFemaleInFamilyBox.setSelected(ex.isOnlyOneFemale());


			minSchoolLowField.setText(ex.getMinimumSchoolSize() + "");
			minSchoolHighField.setText("NA");

			malePerLiterLowField.setText(ex.getOnlyOneMalePerLiter() + "");
			malePerLiterHighField.setText("NA");

			femalePerLiterLowField.setText(ex.getOnlyOneFemalePerLiter() + "");
			femalePerLiterHighField.setText("NA");

			fishPerLiterLowField.setText(ex.getOnlyOneFishPerLiter() + "");
			fishPerLiterHighField.setText("NA");

			minFemalePerMaleLowField
					.setText(ex.getMinumimFemalesPerMale() + "");
			minFemalePerMaleHighField.setText("NA");

			minMalePerFemaleLowField
					.setText(ex.getMinumimMalesPerFemale() + "");
			minMalePerFemaleHighField.setText("NA");
		}
	}



	/**
	 * TODO - Description
	 * 
	 */
	public FishExclusions saveExclusions(FishExclusions ex)
	{
		if ( ex != null )
		{
			// Sets the settings
			ex.setAllAlone(aloneBox.isSelected());
			ex.setAloneWithFamily(aloneWithFamilyBox.isSelected());
			ex.setOnlyOneInFamily(onlyOneInFamilyBox.isSelected());
			ex.setOnlyOneMale(onlyOneMaleInFamilyBox.isSelected());
			ex.setOnlyOneFemale(onlyOneFemaleInFamilyBox.isSelected());

			boolean failed = false;

			try
			{
				ex.setMinimumSchoolSize(Integer.parseInt(minSchoolLowField
						.getText()));
				minSchoolLowField.setBackground(Color.GREEN);
			}
			catch ( NumberFormatException e )
			{
				failed = true;
				minSchoolLowField.setBackground(Color.RED);
			}


			try
			{
				ex.setOnlyOneMalePerLiter(Integer.parseInt(malePerLiterLowField
						.getText()));
				malePerLiterLowField.setBackground(Color.GREEN);
			}
			catch ( NumberFormatException e )
			{
				failed = true;
				malePerLiterLowField.setBackground(Color.RED);
			}

			try
			{
				ex.setOnlyOneFemalePerLiter(Integer
						.parseInt(femalePerLiterLowField.getText()));
				femalePerLiterLowField.setBackground(Color.GREEN);
			}
			catch ( NumberFormatException e )
			{
				failed = true;
				femalePerLiterLowField.setBackground(Color.RED);
			}

			try
			{
				ex.setOnlyOneFishPerLiter(Integer.parseInt(fishPerLiterLowField
						.getText()));
				fishPerLiterLowField.setBackground(Color.GREEN);
			}
			catch ( NumberFormatException e )
			{
				failed = true;
				fishPerLiterLowField.setBackground(Color.RED);
			}

			try
			{
				ex.setMinumimFemalesPerMale(Integer
						.parseInt(minFemalePerMaleLowField.getText()));
				minFemalePerMaleLowField.setBackground(Color.GREEN);
			}
			catch ( NumberFormatException e )
			{
				failed = true;
				minFemalePerMaleLowField.setBackground(Color.RED);
			}

			try
			{
				ex.setMinumimMalesPerFemale(Integer
						.parseInt(minMalePerFemaleLowField.getText()));
				minMalePerFemaleLowField.setBackground(Color.GREEN);
			}
			catch ( NumberFormatException e )
			{
				failed = true;
				minMalePerFemaleLowField.setBackground(Color.RED);
			}


			if ( failed )
			{
				int answer = JOptionPane
						.showConfirmDialog(
								null,
								"Some settings are wrong. Do you wish to save the correct ones?",
								"Confirm", JOptionPane.OK_CANCEL_OPTION);

				if ( answer != JOptionPane.OK_OPTION )
				{
					return null;
				}
			}
		}


		return ex;
	}




}
