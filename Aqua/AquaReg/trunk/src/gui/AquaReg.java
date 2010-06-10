package gui;


import java.awt.Dimension;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class AquaReg extends JFrame
{
	public static TabbedPanel tabPanel;

	// The connection to the database.
	public static Connection connection;


	public static void main(String[] args)
	{
		new AquaReg();
	}



	/**
	 * TODO - Description NEEDED!
	 */
	public AquaReg()
	{
		super("AquaReg");
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(new RegMenu());


		tabPanel = new TabbedPanel();
		this.add(tabPanel);



		this.setResizable(false);
		this.setPreferredSize(new Dimension(730, 400));
		this.setVisible(true);
		this.pack();
	}
}
