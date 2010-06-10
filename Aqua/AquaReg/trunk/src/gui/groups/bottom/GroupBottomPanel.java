package gui.groups.bottom;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GroupBottomPanel extends JPanel implements ActionListener
{
	/**
	 * TODO - Description NEEDED!
	 */
	public GroupBottomPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.NONE;
		// d.ipady = 0; // reset to default
		// d.weighty = 0.7; // request any extra vertical space
		// d.weightx = 0.7; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		// d.insets = new Insets(0, 80, 80, 80); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		GroupSearchPanel search = new GroupSearchPanel(this);
		Dimension searchSize = new Dimension(760, 530);
		search.setPreferredSize(searchSize);
		search.setMinimumSize(searchSize);
		search.setMaximumSize(searchSize);
		search.setVisible(false);
		this.add(search, d);



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(0, 0, 0, 0); // top padding
		d.gridwidth = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0;


		JPanel results = new GroupResultsPanel(this);
		// results.setVisible(false);
		this.add(results, d);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() instanceof JButton )
		{
			String action = e.getActionCommand();

			if ( action.equalsIgnoreCase("Reset") )
			{
				GroupSearchPanel search = new GroupSearchPanel(this);
				Dimension searchSize = new Dimension(760, 530);
				search.setPreferredSize(searchSize);
				search.setMinimumSize(searchSize);
				search.setMaximumSize(searchSize);

				this.remove(0);

				this.add(search, 0);

				this.revalidate();
				this.repaint();
			}
			else if ( action.equalsIgnoreCase("Search") )
			{

			}
		}
		else if ( e.getSource() instanceof JCheckBox )
		{
			String action = e.getActionCommand();

			if ( action.equalsIgnoreCase("Exclude_Alone") )
			{
				GroupSearchPanel p1 = (GroupSearchPanel) this.getComponent(0);
				
				for ( int i = 0; i < p1.getComponentCount(); i++ )
				{
					if ( p1.getComponent(i) instanceof JPanel )
					{
						JPanel p2 = (JPanel) p1.getComponent(i);

						for ( int j = 0; j < p2.getComponentCount(); j++ )
						{
							if ( p2.getComponent(j) instanceof JPanel )
							{
								JPanel p3 = (JPanel) p2.getComponent(j);

								for ( int k = 0; k < p3.getComponentCount(); k++ )
								{
									if ( p3.getComponent(k) instanceof JCheckBox )
									{
										JCheckBox box = (JCheckBox) p3
												.getComponent(k);

										if ( box.getActionCommand()
												.equalsIgnoreCase("Alone") )
										{
											box.setEnabled(!(box.isEnabled()));
										}
									}
								}
							}
						}
					}
				}
			}
			else if ( action.equalsIgnoreCase("Exclude_Only With Family") )
			{
				GroupSearchPanel p1 = (GroupSearchPanel) this.getComponent(0);

				for ( int i = 0; i < p1.getComponentCount(); i++ )
				{
					if ( p1.getComponent(i) instanceof JPanel )
					{
						JPanel p2 = (JPanel) p1.getComponent(i);

						for ( int j = 0; j < p2.getComponentCount(); j++ )
						{
							if ( p2.getComponent(j) instanceof JPanel )
							{
								JPanel p3 = (JPanel) p2.getComponent(j);

								for ( int k = 0; k < p3.getComponentCount(); k++ )
								{
									if ( p3.getComponent(k) instanceof JCheckBox )
									{
										JCheckBox box = (JCheckBox) p3
												.getComponent(k);

										if ( box.getActionCommand()
												.equalsIgnoreCase(
														"Only With Family") )
										{
											box.setEnabled(!(box.isEnabled()));
										}
									}
								}
							}
						}
					}
				}
			}
			else if ( action.equalsIgnoreCase("Exclude_1 of Family") )
			{
				GroupSearchPanel p1 = (GroupSearchPanel) this.getComponent(0);

				for ( int i = 0; i < p1.getComponentCount(); i++ )
				{
					if ( p1.getComponent(i) instanceof JPanel )
					{
						JPanel p2 = (JPanel) p1.getComponent(i);

						for ( int j = 0; j < p2.getComponentCount(); j++ )
						{
							if ( p2.getComponent(j) instanceof JPanel )
							{
								JPanel p3 = (JPanel) p2.getComponent(j);

								for ( int k = 0; k < p3.getComponentCount(); k++ )
								{
									if ( p3.getComponent(k) instanceof JCheckBox )
									{
										JCheckBox box = (JCheckBox) p3
												.getComponent(k);

										if ( box.getActionCommand()
												.equalsIgnoreCase("1 of Family") )
										{
											box.setEnabled(!(box.isEnabled()));
										}
									}
								}
							}
						}
					}
				}
			}
			else if ( action.equalsIgnoreCase("Exclude_1 Male Only") )
			{
				GroupSearchPanel p1 = (GroupSearchPanel) this.getComponent(0);

				for ( int i = 0; i < p1.getComponentCount(); i++ )
				{
					if ( p1.getComponent(i) instanceof JPanel )
					{
						JPanel p2 = (JPanel) p1.getComponent(i);

						for ( int j = 0; j < p2.getComponentCount(); j++ )
						{
							if ( p2.getComponent(j) instanceof JPanel )
							{
								JPanel p3 = (JPanel) p2.getComponent(j);

								for ( int k = 0; k < p3.getComponentCount(); k++ )
								{
									if ( p3.getComponent(k) instanceof JCheckBox )
									{
										JCheckBox box = (JCheckBox) p3
												.getComponent(k);

										if ( box.getActionCommand()
												.equalsIgnoreCase("1 Male Only") )
										{
											box.setEnabled(!(box.isEnabled()));
										}
									}
								}
							}
						}
					}
				}
			}
			else if ( action.equalsIgnoreCase("Exclude_1 Female Only") )
			{
				GroupSearchPanel p1 = (GroupSearchPanel) this.getComponent(0);

				for ( int i = 0; i < p1.getComponentCount(); i++ )
				{
					if ( p1.getComponent(i) instanceof JPanel )
					{
						JPanel p2 = (JPanel) p1.getComponent(i);

						for ( int j = 0; j < p2.getComponentCount(); j++ )
						{
							if ( p2.getComponent(j) instanceof JPanel )
							{
								JPanel p3 = (JPanel) p2.getComponent(j);

								for ( int k = 0; k < p3.getComponentCount(); k++ )
								{
									if ( p3.getComponent(k) instanceof JCheckBox )
									{
										JCheckBox box = (JCheckBox) p3
												.getComponent(k);

										if ( box.getActionCommand()
												.equalsIgnoreCase(
														"1 Female Only") )
										{
											box.setEnabled(!(box.isEnabled()));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else if ( e.getSource() instanceof JTextField )
		{

		}
	}
}
