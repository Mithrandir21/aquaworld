package gui.exclusions;


import javax.swing.JTabbedPane;

public class FishExclusionView extends JTabbedPane
{
	ExclusionsListener lis;


	public FishExclusionView()
	{
		lis = new ExclusionsListener();

		this.addTab("Simple", new FishSimpleExclusionsPanel(lis));

		this.addTab("Advanced", getAdvancedTabbed());
	}



	private JTabbedPane getAdvancedTabbed()
	{
		JTabbedPane advPane = new JTabbedPane();
		advPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		advPane.addTab("Compatible With", new FishAdvancedExclusionsPanel(lis));

		advPane.addTab("Not Compatible With", new FishAdvancedExclusionsPanel(lis));

		advPane.addTab("Not Compatible With These Males",
				new FishAdvancedExclusionsPanel(lis));

		advPane.addTab("Not Compatible With These Females",
				new FishAdvancedExclusionsPanel(lis));


		return advPane;

	}
}
