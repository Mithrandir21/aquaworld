package gui.groups.bottom;


import gui.GraficalFunctions;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupSearchPanel extends JPanel
{
	public GroupSearchPanel(ActionListener lis)
	{
		// this.setComponentZOrder(lis, 0);
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		this.setBorder(BorderFactory.createEtchedBorder());
		// this.setVisible(false);



		// Dimension panelSize = new Dimension(115, 60);


		d.fill = GridBagConstraints.NONE;
		d.ipady = 0; // reset to default
		d.anchor = GridBagConstraints.FIRST_LINE_START; // bottom of space
		d.insets = new Insets(10, 10, 4, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		this.add(new JLabel("Search"), d);

		JPanel generalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		generalPanel
				.add(GraficalFunctions.getUniquePanel("Family", lis, false));

		generalPanel.add(GraficalFunctions
				.getUniquePanel("Species", lis, false));

		generalPanel.add(GraficalFunctions.getUniquePanel("Common Name", lis,
				false));

		generalPanel.add(GraficalFunctions.getLowHighExactPanel("Size", lis,
				false));



		d.gridy = 1;
		this.add(generalPanel, d);


		JPanel parametersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


		parametersPanel.add(GraficalFunctions.getLowHighExactPanel("Salinity",
				lis, false));

		parametersPanel.add(GraficalFunctions.getLowHighExactPanel("PH", lis,
				false));

		parametersPanel.add(GraficalFunctions.getLowHighExactPanel("GH", lis,
				false));

		parametersPanel.add(GraficalFunctions.getLowHighExactPanel("KH", lis,
				false));

		parametersPanel.add(GraficalFunctions.getLowHighExactPanel("Temp", lis,
				false));

		parametersPanel.add(GraficalFunctions.getLowHighExactPanel(
				"Space Needed", lis, false));

		parametersPanel.add(GraficalFunctions.getLowHighExactPanel(
				"Others Size", lis, false));


		d.gridy = 2;
		this.add(parametersPanel, d);





		JPanel booleanBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


		booleanBoxPanel.add(GraficalFunctions.getBooleanBoxWithExclude("Alone",
				lis));

		booleanBoxPanel.add(GraficalFunctions.getBooleanBoxWithExclude(
				"Only With Family", lis));

		booleanBoxPanel.add(GraficalFunctions.getBooleanBoxWithExclude(
				"1 of Family", lis));

		booleanBoxPanel.add(GraficalFunctions.getBooleanBoxWithExclude(
				"1 Male Only", lis));

		booleanBoxPanel.add(GraficalFunctions.getBooleanBoxWithExclude(
				"1 Female Only", lis));


		d.gridy = 3;
		this.add(booleanBoxPanel, d);




		JPanel otherParPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		otherParPanel.add(GraficalFunctions.getLowHighExactPanel("Min. School",
				lis, false));


		otherParPanel.add(GraficalFunctions.getLowHighExactPanel("Male P.L. ",
				lis, false));


		otherParPanel.add(GraficalFunctions.getLowHighExactPanel("Female P.L.",
				lis, false));


		otherParPanel.add(GraficalFunctions.getLowHighExactPanel("Fish P.L.",
				lis, false));


		otherParPanel.add(GraficalFunctions.getLowHighExactPanel("M.F.P.M.",
				lis, false));


		otherParPanel.add(GraficalFunctions.getLowHighExactPanel("M.M.P.F.",
				lis, false));


		otherParPanel.add(GraficalFunctions.getLowHighExactPanel("Reef Safe",
				lis, false));

		d.weighty = 1.0;
		d.gridy = 4;
		this.add(otherParPanel, d);


		d.gridy = 5;
		d.anchor = GridBagConstraints.LAST_LINE_END;
		d.weightx = 1.0;
		this.add(getButtons("Reset", "Search", "Cancel", lis), d);
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
}
