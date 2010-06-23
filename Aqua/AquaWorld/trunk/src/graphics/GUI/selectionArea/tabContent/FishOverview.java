package graphics.GUI.selectionArea.tabContent;


import graphics.AquaWorld;
import graphics.GUI.selectionArea.ObjectSelection;
import graphics.GUI.selectionArea.SelectionAreaInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXCollapsiblePane;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FishOverview extends JPanel implements SelectionAreaInterface
{
	JXCollapsiblePane colPanel;

	/**
	 * TODO - Description NEEDED!
	 */
	public FishOverview()
	{
		int width = (int) (AquaWorld.width * 0.15);

		int height = (int) (AquaWorld.height * 0.70);

		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		this.setPreferredSize(new Dimension(width, height));

		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		// d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.NORTH; // bottom of space
		d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0;
		d.gridx = 0;
		this.add(getSearchArea(), d);

		d.insets = new Insets(0, 10, 10, 10); // top padding
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridy = 1;
		this.add(getResultsArea(), d);
	}


	private JPanel getSearchArea()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		// d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.LINE_START; // bottom of space
		d.insets = new Insets(0, 5, 0, 0); // top padding
		// d.gridwidth = 2; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0;
		d.gridx = 0;
		JLabel nameSearchLabel = new JLabel(AquaWorld.texts
				.getString("selGeneralSearchFieldLabel"),
				SwingConstants.LEADING);
		panel.add(nameSearchLabel, d);


		JTextField searchField = new JTextField();
		searchField.setToolTipText(AquaWorld.texts
				.getString("selGeneralSearchFieldToolTip"));
		d.insets = new Insets(0, 0, 5, 0); // top padding
		d.gridy = 1;
		panel.add(searchField, d);

		d.gridy = 2;
		panel.add(getAdvancedPanel(), d);




		d.anchor = GridBagConstraints.LINE_END; // bottom of space
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.gridy = 3;
		panel.add(getButtons(), d);
		return panel;
	}




	private JXCollapsiblePane getAdvancedPanel()
	{
		colPanel = new JXCollapsiblePane();
		colPanel.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		colPanel.setCollapsed(true);

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		d.anchor = GridBagConstraints.LINE_END; // bottom of space
		d.insets = new Insets(0, 5, 0, 0); // top padding
		// d.gridwidth = 2; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0;
		d.gridx = 0;

		colPanel.add(new JLabel("*Flere valg*"), d);

		return colPanel;
	}



	private JPanel getButtons()
	{
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

		JButton advancedButton = new JButton(AquaWorld.texts
				.getString("selAdvancedButtonText"));
		advancedButton.addActionListener(colPanel.getActionMap().get(
				JXCollapsiblePane.TOGGLE_ACTION));
		panel.add(advancedButton);

		JButton searchButton = new JButton(AquaWorld.texts
				.getString("selSearchButtonText"));
		panel.add(searchButton);


		return panel;
	}



	private JScrollPane getResultsArea()
	{
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(BorderFactory.createEmptyBorder());

		scroll.setViewportView(new ObjectSelection());

		return scroll;
	}


	/*
	 * (non-Javadoc)
	 * @see graphics.GUI.selectionArea.SelectionAreaInterface#getMessageClass()
	 */
	@Override
	public Class<?> getMessageClass()
	{
		return this.getClass();
	}


	/*
	 * (non-Javadoc)
	 * @see graphics.GUI.selectionArea.SelectionAreaInterface#removeThisTab()
	 */
	@Override
	public void removeThisTab()
	{
		AquaWorld.getSelectionArea().removeTab(this.getClass());
	}


	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{

	}
}
