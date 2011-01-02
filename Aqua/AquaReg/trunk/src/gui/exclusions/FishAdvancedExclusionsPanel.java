package gui.exclusions;


import graphicalObjects.AquaGroupBox;
import graphicalObjects.AquaPanel;
import graphics.RoundedBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.Border;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FishAdvancedExclusionsPanel extends JPanel implements
		MouseListener, ActionListener
{

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param lis
	 */
	public FishAdvancedExclusionsPanel(ActionListener lis)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		this.setBackground(Color.WHITE);


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row


		JScrollPane scroll = new JScrollPane(getAllGroupsPanel(lis));
		// Increases how far the scroll bar scrolls on one step of a mouse wheel
		scroll.getVerticalScrollBar().setUnitIncrement(20);

		this.add(scroll, d);
	}




	/**
	 * TODO - Description
	 * 
	 */
	private JPanel getAllGroupsPanel(ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		// panel.setBorder(BorderFactory.createEtchedBorder());
		panel.setBackground(Color.WHITE);


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.2; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(5, 5, 5, 5); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row

		int panels = 4;

		for ( int i = 0; i < panels; i++ )
		{
			panel.add(getGroupPanel(lis), d);
			d.gridy++;

			panel.add(new JSeparator(), d);
			d.gridy++;
		}

		return panel;
	}


	/**
	 * TODO - Description
	 * 
	 */
	private JPanel getGroupPanel(ActionListener lis)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		// panel.setBorder(BorderFactory.createEtchedBorder());
		panel.setOpaque(false);


		d.fill = GridBagConstraints.HORIZONTAL;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 0.2; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(5, 5, 5, 5); // top padding
		d.gridwidth = 3; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0; // third row
		d.gridx = 0; // third row



		AquaGroupBox groupBox = new AquaGroupBox("Johans Group");
		groupBox.setBackground(Color.WHITE);
		groupBox.addMouseListener(this);
		panel.add(groupBox, d);



		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 0.2; // request any extra vertical space
		d.weightx = 0.3; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(15, 15, 15, 15); // top padding
		d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 1;
		d.gridx = -1; // third row


		int panels = 12;
		// Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED,
		// Color.WHITE, Color.BLACK);
		Border border = new RoundedBorder(10, 2.0f, new Color(0, 191, 255));



		for ( int i = 0; i < panels; i++ )
		{
			if ( i > 3 && i % 5 == 0 )
			{
				d.gridx = 0;
				d.gridy++;
			}
			else
			{
				d.gridx++;
			}


			panel.add(getObjectPanel(groupBox, border, lis), d);
		}


		panel.addMouseListener(this);


		return panel;
	}



	/**
	 * TODO - Description
	 * @param groupBox 
	 * 
	 */
	private JPanel getObjectPanel(AquaGroupBox groupBox, Border border,
			ActionListener lis)
	{
		AquaPanel panel = new AquaPanel(this, this);
		panel.setBorder(border);

		groupBox.objectPanels.add(panel);

		return panel;
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		togglePanel((Component) e.getSource());
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		togglePanel((Component) e.getSource());
	}


	/**
	 * TODO - Description
	 * 
	 */
	private void togglePanel(Component comp)
	{
		if ( comp instanceof AquaPanel )
		{
			AquaPanel panel = (AquaPanel) comp;
			panel.toggle();
		}
		else if ( comp instanceof AquaGroupBox )
		{
			AquaGroupBox box = (AquaGroupBox) comp;

			ArrayList<AquaPanel> panels = box.objectPanels;

			ListIterator<AquaPanel> itr = panels.listIterator();

			while ( itr.hasNext() )
			{
				AquaPanel panel = itr.next();

				panel.toggle(box.isSelected());
			}
		}
		else if ( comp instanceof JCheckBox )
		{
			if ( comp.getParent() instanceof AquaPanel )
			{
				JCheckBox box = (JCheckBox) comp;

				boolean selected = box.isSelected();

				AquaPanel panel = (AquaPanel) comp.getParent();

				if ( selected )
				{
					panel.setBorder(new RoundedBorder(10, 7.0f, new Color(30,
							144, 255)));
				}
				else
				{
					panel.setBorder(new RoundedBorder(10, 2.0f, new Color(0,
							191, 255)));
				}
			}
		}
	}
}
