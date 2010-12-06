package gui;


import graphicalObjects.AquaAutoCompleteComboBox;
import graphicalObjects.AquaField;
import graphicalObjects.LockCheckBox;
import graphicalObjects.RangeLockCheckBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GraficalFunctions
{

	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(AquaField field, String valueName,
			ActionListener lis, boolean necessaryField, boolean lockPossible)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 65);
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


		field.setActionCommand(valueName);
		Dimension textSize = new Dimension(100, 20);
		field.setPreferredSize(textSize);
		field.setMinimumSize(textSize);
		field.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(7, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(field, c);



		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row

		JPanel lockPanel = new JPanel(new GridLayout());

		if ( lockPossible )
		{
			LockCheckBox lock = new LockCheckBox(field);
			lock.setActionCommand(valueName);
			lock.addActionListener(lis);
			lock.setFocusable(false);
			lockPanel.add(lock, c);
		}

		panel.add(lockPanel, c);



		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(AquaAutoCompleteComboBox field,
			String valueName, ActionListener lis, boolean necessaryField,
			boolean lockPossible)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 65);
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


		field.setActionCommand(valueName);
		Dimension textSize = new Dimension(100, 20);
		field.setPreferredSize(textSize);
		field.setMinimumSize(textSize);
		field.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(7, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(field, c);



		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row

		JPanel lockPanel = new JPanel(new GridLayout());

		// if ( lockPossible )
		// {
		// LockCheckBox lock = new LockCheckBox(field);
		// lock.setActionCommand(valueName);
		// lock.addActionListener(lis);
		// lock.setFocusable(false);
		// lockPanel.add(lock, c);
		// }

		panel.add(lockPanel, c);



		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getLowHighPanel(AquaField low, AquaField high,
			String valueName, ActionListener lis, boolean necessaryField)
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


		RangeLockCheckBox lock = new RangeLockCheckBox(low, high);
		lock.setActionCommand(valueName);
		lock.addActionListener(lis);
		lock.setFocusable(false);
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row
		panel.add(lock, c);


		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getUniqueNumberPanel(String valueName,
			Dimension panelSize, boolean blue)
	{
		JPanel panel = new JPanel(new GridBagLayout());
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


		JTextField field = new JTextField();
		if ( blue )
		{
			field.setBackground(Color.CYAN);
		}
		field.setActionCommand(valueName);
		Dimension textSize = new Dimension(30, 20);
		field.setPreferredSize(textSize);
		field.setMinimumSize(textSize);
		field.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(7, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(field, c);


		return panel;
	}


	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(String valueName, ActionListener lis,
			boolean blue, boolean lockPossible)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 65);
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


		JTextField field = new JTextField();
		if ( blue )
		{
			field.setBackground(Color.CYAN);
		}
		field.setActionCommand(valueName);
		field.setName(valueName);
		Dimension textSize = new Dimension(100, 20);
		field.setPreferredSize(textSize);
		field.setMinimumSize(textSize);
		field.setMaximumSize(textSize);
		c.fill = GridBagConstraints.NONE;
		// c.ipady = 0; // reset to default
		// c.weightx = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(7, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 1; // 2 columns wide
		c.gridy = 2; // third row
		panel.add(field, c);



		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row

		JPanel lockPanel = new JPanel(new GridLayout());

		if ( lockPossible )
		{
			LockCheckBox lock = new LockCheckBox(field);
			lock.setActionCommand(valueName);
			lock.addActionListener(lis);
			lock.setFocusable(false);
			lockPanel.add(lock, c);
		}
		// else
		// {
		// lockPanel.add(new JPanel(), c);
		// }

		panel.add(lockPanel, c);



		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(String valueName, ActionListener lis,
			boolean blue)
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


		JTextField field = new JTextField();
		if ( blue )
		{
			field.setBackground(Color.CYAN);
		}
		field.setActionCommand(valueName);
		field.setName(valueName);
		Dimension textSize = new Dimension(100, 20);
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



		// c.fill = GridBagConstraints.BOTH;
		// // c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// // c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// // c.insets = new Insets(10, 0, 0, 0); // top padding
		// // c.gridx = 0; // aligned with button 2
		// // c.gridwidth = 2; // 2 columns wide
		// c.gridy = 3; // third row
		// JCheckBox lock = new JCheckBox("Lock");
		// lock.setActionCommand(valueName);
		// lock.addActionListener(lis);
		// lock.setFocusable(false);
		//
		// panel.add(lock, c);



		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getDescriptionPanel(JTextArea description,
			Dimension Size)
	{
		JScrollPane scroll = new JScrollPane();

		// description.setBorder(BorderFactory.createEtchedBorder());
		// description.setFocusable(false);
		// description.setEditable(true);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


		scroll.setViewportView(description);


		JPanel desc = new JPanel(new GridLayout());
		desc.setPreferredSize(Size);
		desc.setMinimumSize(Size);
		desc.setMaximumSize(Size);
		desc.add(scroll);


		return desc;
	}




	/**
	 * TODO - Description
	 */
	public static JPanel getDescriptionPanel(Dimension Size)
	{
		JScrollPane scroll = new JScrollPane();

		JTextArea description = new JTextArea();
		description.setBorder(BorderFactory.createEtchedBorder());
		// description.setFocusable(false);
		// description.setEditable(true);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


		scroll.setViewportView(description);


		JPanel desc = new JPanel(new GridLayout());
		desc.setPreferredSize(Size);
		desc.setMinimumSize(Size);
		desc.setMaximumSize(Size);
		desc.add(scroll);


		return desc;
	}



	public static JPanel getButtons(String button0, String button1,
			String button2, ActionListener lis)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// buttonPanel.setLayout(new BoxLayout(buttonPanel,
		// BoxLayout.PAGE_AXIS));
		Dimension panelSize = new Dimension(115, 60);
		buttonPanel.setPreferredSize(panelSize);
		buttonPanel.setMinimumSize(panelSize);
		buttonPanel.setMaximumSize(panelSize);


		JButton exclusions = new JButton(button0);
		exclusions.setFocusable(false);
		exclusions.addActionListener(lis);
		exclusions.setActionCommand(button0);
		Dimension textSize = new Dimension(100, 20);
		exclusions.setPreferredSize(textSize);
		exclusions.setMinimumSize(textSize);
		exclusions.setMaximumSize(textSize);


		JButton reset = new JButton(button1);
		reset.setFocusable(false);
		reset.addActionListener(lis);
		reset.setActionCommand(button1);
		reset.setPreferredSize(textSize);
		reset.setMinimumSize(textSize);
		reset.setMaximumSize(textSize);


		JButton save = new JButton(button2);
		save.addActionListener(lis);
		save.setActionCommand(button2);
		save.setPreferredSize(textSize);
		save.setMinimumSize(textSize);
		save.setMaximumSize(textSize);


		buttonPanel.add(exclusions);
		buttonPanel.add(reset);
		buttonPanel.add(save);

		return buttonPanel;
	}



	public static JPanel getButtons(String button1, String button2,
			ActionListener lis)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// buttonPanel.setLayout(new BoxLayout(buttonPanel,
		// BoxLayout.PAGE_AXIS));
		Dimension panelSize = new Dimension(115, 60);
		buttonPanel.setPreferredSize(panelSize);
		buttonPanel.setMinimumSize(panelSize);
		buttonPanel.setMaximumSize(panelSize);


		JButton reset = new JButton(button1);
		reset.setFocusable(false);
		reset.addActionListener(lis);
		reset.setActionCommand(button1);
		Dimension textSize = new Dimension(100, 20);
		reset.setPreferredSize(textSize);
		reset.setMinimumSize(textSize);
		reset.setMaximumSize(textSize);


		JButton save = new JButton(button2);
		save.addActionListener(lis);
		save.setActionCommand(button2);
		save.setPreferredSize(textSize);
		save.setMinimumSize(textSize);
		save.setMaximumSize(textSize);


		buttonPanel.add(reset);
		buttonPanel.add(save);

		return buttonPanel;
	}



	public static JPanel getButtons(ActionListener lis)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// buttonPanel.setLayout(new BoxLayout(buttonPanel,
		// BoxLayout.PAGE_AXIS));
		Dimension panelSize = new Dimension(115, 60);
		buttonPanel.setPreferredSize(panelSize);
		buttonPanel.setMinimumSize(panelSize);
		buttonPanel.setMaximumSize(panelSize);

		Dimension textSize = new Dimension(80, 20);

		JButton reset = new JButton("Reset");
		reset.setFocusable(false);
		reset.addActionListener(lis);
		reset.setActionCommand("reset");
		reset.setPreferredSize(textSize);
		reset.setMinimumSize(textSize);
		reset.setMaximumSize(textSize);


		JButton save = new JButton("Save");
		save.addActionListener(lis);
		save.setActionCommand("save");
		save.setPreferredSize(textSize);
		save.setMinimumSize(textSize);
		save.setMaximumSize(textSize);


		buttonPanel.add(reset);
		buttonPanel.add(save);

		return buttonPanel;
	}





	/**
	 * TODO - Description
	 */
	public static JPanel getLowHighPanel(String valueName, ActionListener lis)
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


		JTextField low = new JTextField();
		low.setName(valueName + "_Low");
		// if ( blue )
		// {
		// low.setBackground(Color.CYAN);
		// }
		Dimension textSize = new Dimension(40, 20);
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


		JTextField high = new JTextField();
		high.setName(valueName + "_High");
		// if ( blue )
		// {
		// high.setBackground(Color.CYAN);
		// }
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


		// JCheckBox lock = new JCheckBox("Lock");
		// lock.setActionCommand(valueName);
		// lock.addActionListener(lis);
		// lock.setFocusable(false);
		// c.fill = GridBagConstraints.BOTH;
		// // c.ipady = 0; // reset to default
		// // c.weighty = 1.0; // request any extra vertical space
		// // c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// // c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 0; // aligned with button 2
		// c.gridwidth = 2; // 2 columns wide
		// c.gridy = 3; // third row
		// panel.add(lock, c);


		return panel;
	}






	/**
	 * TODO - Description
	 */
	public static JPanel getLowHighPanel(String valueName, ActionListener lis,
			boolean blue)
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


		JTextField low = new JTextField();
		low.setName(valueName + "_Low");
		if ( blue )
		{
			low.setBackground(Color.CYAN);
		}
		Dimension textSize = new Dimension(40, 20);
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


		JTextField high = new JTextField();
		high.setName(valueName + "_High");
		if ( blue )
		{
			high.setBackground(Color.CYAN);
		}
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


		RangeLockCheckBox lock = new RangeLockCheckBox(low, high);
		lock.setActionCommand(valueName);
		lock.addActionListener(lis);
		lock.setFocusable(false);
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 3; // third row
		panel.add(lock, c);


		return panel;
	}


	/**
	 * TODO - Description
	 */
	public static JPanel getEmptyLowHighPanel()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(115, 90);
		panel.setPreferredSize(panelSize);
		panel.setMinimumSize(panelSize);
		panel.setMaximumSize(panelSize);

		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getLowHighExactPanel(String valueName,
			ActionListener lis, boolean blue)
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


		JTextField low = new JTextField(4);
		low.setName(valueName + "_Low");
		if ( blue )
		{
			low.setBackground(Color.CYAN);
		}
		Dimension textSize = new Dimension(40, 20);
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


		JTextField high = new JTextField();
		high.setName(valueName + "_High");
		if ( blue )
		{
			high.setBackground(Color.CYAN);
		}
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


		JTextField exact = new JTextField();
		exact.setName(valueName + "_Exact");
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
	public static JPanel getEmptyLowHighExactPanel()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		Dimension panelSize = new Dimension(100, 90);
		panel.setPreferredSize(panelSize);
		panel.setMinimumSize(panelSize);
		panel.setMaximumSize(panelSize);

		return panel;
	}



	/**
	 * TODO - Description
	 */
	public static JPanel getBooleanBox(String valuename, ActionListener lis)
	{
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// Dimension panelSize = new Dimension(100, 40);
		// panel.setPreferredSize(panelSize);
		// panel.setMinimumSize(panelSize);
		// panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());


		JCheckBox check = new JCheckBox(valuename);
		check.setActionCommand(valuename);
		check.addActionListener(lis);
		panel.add(check);

		return panel;
	}




	/**
	 * TODO - Description
	 */
	public static JPanel getBooleanBoxWithExclude(String valuename,
			ActionListener lis)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// Dimension panelSize = new Dimension(100, 40);
		// panel.setPreferredSize(panelSize);
		// panel.setMinimumSize(panelSize);
		// panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());


		JCheckBox exclude = new JCheckBox("Exclude");
		exclude.setActionCommand("Exclude_" + valuename);
		exclude.addActionListener(lis);
		panel.add(exclude);




		// JPanel checkPanel = new JPanel();

		JCheckBox check = new JCheckBox(valuename);
		// checkPanel.setBorder(BorderFactory.createEtchedBorder());
		check.setActionCommand(valuename);
		check.addActionListener(lis);
		// checkPanel.add(check);

		panel.add(check);

		return panel;
	}
}
