package gui.exclusions;


import gui.GraficalFunctions;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class FishSimpleExclusionsPanel extends JPanel
{
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


		booleanBoxPanel.add(GraficalFunctions.getBooleanBox("Alone", lis));

		booleanBoxPanel.add(GraficalFunctions.getBooleanBox("Only With Family",
				lis));

		booleanBoxPanel
				.add(GraficalFunctions.getBooleanBox("1 of Family", lis));

		booleanBoxPanel
				.add(GraficalFunctions.getBooleanBox("1 Male Only", lis));

		booleanBoxPanel.add(GraficalFunctions.getBooleanBox("1 Female Only",
				lis));


		// d.gridy = 3;
		this.add(booleanBoxPanel, d);







		JPanel otherParPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		otherParPanel
				.add(GraficalFunctions.getLowHighPanel("Min. School", lis));


		otherParPanel.add(GraficalFunctions.getLowHighPanel("Male P.L. ", lis));


		otherParPanel
				.add(GraficalFunctions.getLowHighPanel("Female P.L.", lis));


		otherParPanel.add(GraficalFunctions.getLowHighPanel("Fish P.L.", lis));


		otherParPanel.add(GraficalFunctions.getLowHighPanel("M.F.P.M.", lis));


		otherParPanel.add(GraficalFunctions.getLowHighPanel("M.M.P.F.", lis));


		otherParPanel.add(GraficalFunctions.getLowHighPanel("Reef Safe", lis));

		d.weighty = 1.0;
		d.gridy = 1;
		this.add(otherParPanel, d);
	}
}
