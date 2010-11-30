package gui.editing;


import graphicalObjects.LockCheckBox;
import graphicalObjects.RangeLockCheckBox;
import gui.GraficalFunctions;
import gui.exclusions.ExclusionFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EditingPanel extends JPanel implements ActionListener
{
	public EditingPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		// d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridy = 0; // third row


		d.gridx = 0;
		this.add(GraficalFunctions.getUniquePanel("Genus", this, false, true),
				d);

		d.gridx = 1;
		this.add(
				GraficalFunctions.getUniquePanel("Species", this, true, false),
				d);

		d.gridx = 2;
		this.add(GraficalFunctions.getUniquePanel("Common Name", this, false,
				true), d);

		d.gridx = 3;
		this.add(GraficalFunctions.getUniquePanel("Size", this, true, true), d);

		d.gridx = 4;
		this.add(GraficalFunctions.getUniquePanel("Space Needed", this, false,
				true), d);

		d.gridx = 5;
		this.add(GraficalFunctions.getUniquePanel("Group", this, false, true),
				d);



		d.gridy = 1;

		d.gridx = 0; // aligned with button 2
		this.add(GraficalFunctions.getLowHighPanel("Salinity", this, true), d);

		d.gridx = 1;
		this.add(GraficalFunctions.getLowHighPanel("PH", this, true), d);
		// this.add(panel1, c);

		d.gridx = 2;
		this.add(GraficalFunctions.getLowHighPanel("GH", this, true), d);
		// this.add(panel1, c);

		d.gridx = 3;
		this.add(GraficalFunctions.getLowHighPanel("KH", this, false), d);
		// this.add(panel1, c);

		d.gridx = 4;
		this.add(GraficalFunctions.getLowHighPanel("Temperature", this, true),
				d);
		// this.add(panel1, c);

		d.gridx = 5;
		this.add(GraficalFunctions.getLowHighPanel("Others Size", this, false),
				d);
		//
		// d.gridx = 6;
		// this.add(GraficalFunctions.getLowHighPanel("Calsium", this, true),
		// d);
		//
		// d.gridx = 7;
		// this.add(GraficalFunctions.getLowHighPanel("Magnesium", this, true),
		// d);



		d.weighty = 0; // request any extra vertical space
		d.anchor = GridBagConstraints.LAST_LINE_START; // bottom of space
		d.gridy = 2;
		d.gridx = 0;
		d.gridwidth = 5;
		Dimension descSize = new Dimension(550, 130);
		this.add(GraficalFunctions.getDescriptionPanel(descSize), d);


		d.weighty = 0; // request any extra vertical space
		d.anchor = GridBagConstraints.LAST_LINE_END; // bottom of space
		d.gridy = 2;
		d.gridx = 5;
		d.gridwidth = 1;
		this.add(getButtons(this), d);
	}


	public static JPanel getButtons(ActionListener lis)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// buttonPanel.setLayout(new BoxLayout(buttonPanel,
		// BoxLayout.PAGE_AXIS));
		Dimension panelSize = new Dimension(115, 90);
		buttonPanel.setPreferredSize(panelSize);
		buttonPanel.setMinimumSize(panelSize);
		buttonPanel.setMaximumSize(panelSize);


		Dimension buttonSize = new Dimension(110, 20);


		JButton exclusions = new JButton("Exclusions");
		exclusions.setFocusable(true);
		exclusions.addActionListener(lis);
		exclusions.setActionCommand("exclusions");
		exclusions.setPreferredSize(buttonSize);
		exclusions.setMinimumSize(buttonSize);
		exclusions.setMaximumSize(buttonSize);


		JButton reset = new JButton("Reset");
		reset.setFocusable(false);
		reset.addActionListener(lis);
		reset.setActionCommand("reset");
		reset.setPreferredSize(buttonSize);
		reset.setMinimumSize(buttonSize);
		reset.setMaximumSize(buttonSize);


		JButton save = new JButton("Save");
		save.addActionListener(lis);
		save.setActionCommand("save");
		save.setPreferredSize(buttonSize);
		save.setMinimumSize(buttonSize);
		save.setMaximumSize(buttonSize);

		buttonPanel.add(exclusions);
		buttonPanel.add(reset);
		buttonPanel.add(save);

		return buttonPanel;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() instanceof JCheckBox )
		{
			if ( e.getSource() instanceof LockCheckBox )
			{
				LockCheckBox box = (LockCheckBox) e.getSource();

				box.getJTextField().setEditable(!box.isSelected());
			}
			else if ( e.getSource() instanceof RangeLockCheckBox )
			{
				RangeLockCheckBox box = (RangeLockCheckBox) e.getSource();

				box.getLowJTextField().setEditable(!box.isSelected());
				box.getHighJTextField().setEditable(!box.isSelected());
			}
		}
		else if ( e.getSource() instanceof JButton )
		{
			JButton button = (JButton) e.getSource();

			if ( button.getActionCommand().equals("exclusions") )
			{
				new ExclusionFrame();
			}
			else if ( button.getActionCommand().equals("reset") )
			{
				resetAction();
			}
			else if ( button.getActionCommand().equals("save") )
			{
				saveAction();
			}
		}
	}


	/**
	 * TODO - Description
	 */
	private void saveAction()
	{
		for ( int i = 0; i < this.getComponentCount(); i++ )
		{
			if ( this.getComponent(i) instanceof JPanel )
			{
				JPanel panel = (JPanel) this.getComponent(i);

				for ( int j = 0; j < panel.getComponentCount(); j++ )
				{
					if ( panel.getComponent(j) instanceof JTextField )
					{
						JTextField field = (JTextField) panel.getComponent(j);

						if ( field.getBackground().equals(Color.CYAN) )
						{
							if ( field.getText().equals("") )
							{
								field.setBackground(Color.RED);
							}
						}
						else if ( field.getBackground().equals(Color.RED) )
						{
							if ( !field.getText().equals("") )
							{
								field.setBackground(Color.CYAN);
							}
						}
					}
				}
			}
		}
	}


	/**
	 * TODO - Description
	 */
	private void resetAction()
	{
		for ( int i = 0; i < this.getComponentCount(); i++ )
		{
			if ( this.getComponent(i) instanceof JPanel )
			{
				JPanel panel = (JPanel) this.getComponent(i);

				for ( int j = 0; j < panel.getComponentCount(); j++ )
				{
					if ( panel.getComponent(j) instanceof JTextField )
					{
						JTextField field = (JTextField) panel.getComponent(j);

						// if ( field.isEditable() )
						// {
						// field.setText("");
						// }

						if ( field.getBackground().equals(Color.RED) )
						{
							field.setBackground(Color.CYAN);
						}
					}
				}
			}
		}
	}
}
