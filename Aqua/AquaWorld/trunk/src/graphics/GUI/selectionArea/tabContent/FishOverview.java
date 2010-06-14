package graphics.GUI.selectionArea.tabContent;


import graphics.AquaWorld;
import graphics.GUI.graphicalFunctions.GraphicalFunctions;
import graphics.GUI.selectionArea.ObjectSelection;
import graphics.GUI.selectionArea.SelectionAreaInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FishOverview extends JPanel implements SelectionAreaInterface
{


	/**
	 * TODO - Description NEEDED!
	 */
	public FishOverview()
	{
		int width = (int) (AquaWorld.width * 0.20);

		int height = (int) (AquaWorld.height * 0.70);

		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		this.setPreferredSize(new Dimension(width, height));

		this.setLayout(new SpringLayout());

		JTextField searchField = new JTextField();
		searchField.setSize(new Dimension(150, 20));
		searchField.setMaximumSize(new Dimension(150, 20));
		searchField.setPreferredSize(new Dimension(150, 20));

		JButton searchButton = new JButton("Søk");

		this.add(searchField);
		this.add(searchButton);
		searchArea();

		// Lay out the panel.
		GraphicalFunctions.make1xGrid(this, this.getComponentCount(), 6, 6, // initX,
				// initY
				6, 6); // xPad, yPad
	}



	private void searchArea()
	{
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(BorderFactory.createEmptyBorder());

		// JPanel panel = new JPanel(new SpringLayout());
		//
		// JTextField test = new JTextField("Testings");
		// test.setSize(new Dimension(100, 20));
		// test.setMaximumSize(new Dimension(100, 20));
		// test.setPreferredSize(new Dimension(100, 20));
		// JTextField test1 = new JTextField("Testings1");
		// test1.setSize(new Dimension(100, 20));
		// test1.setMaximumSize(new Dimension(100, 20));
		// test1.setPreferredSize(new Dimension(100, 20));
		// JButton test2 = new JButton("Testings2");
		//
		//
		// panel.add(test);
		// panel.add(test1);
		// panel.add(test2);
		//
		//
		// // Lay out the panel.
		// GraphicalFunctions.make1xGrid(panel, panel.getComponentCount(), 6, 6, // initX,
		// // initY
		// 6, 6); // xPad, yPad

		scroll.setViewportView(new ObjectSelection());

		this.add(scroll);
	}

	// /*
	// * (non-Javadoc)
	// * @see
	// graphics.GUI.selectionArea.SelectionAreaInterface#createMessageTab()
	// */
	// @Override
	// public void createSearchTab()
	// {
	// this.removeAll();
	//
	// content = new JScrollPane();
	// }


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
