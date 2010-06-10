package gui.exclusions;

import javax.swing.JTabbedPane;

public class InvertebrateExclusionView extends JTabbedPane
{
	ExclusionsListener lis;


	public InvertebrateExclusionView()
	{
		lis = new ExclusionsListener();

		this.addTab("Simple", new InvertebrateSimpleExclusionsPanel(lis));

		this.addTab("Advanced", getAdvancedTabbed());
	}



	private JTabbedPane getAdvancedTabbed()
	{
		JTabbedPane advPane = new JTabbedPane();
		advPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		advPane.addTab("Compatible With",
				new InvertebrateAdvancedExclusionsPanel(lis));

		advPane.addTab("Not Compatible With",
				new InvertebrateAdvancedExclusionsPanel(lis));


		return advPane;

	}
}
