package gui;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

		// Get the default toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Get the current screen size
		Dimension scrnsize = toolkit.getScreenSize();


		int width = ((int) scrnsize.getWidth()) / 4;

		int height = ((int) scrnsize.getHeight()) / 4;


		// verifyConnection();7


		this.setJMenuBar(new RegMenu());


		tabPanel = new TabbedPanel();
		this.add(tabPanel);



		this.setResizable(false);
		this.setLocation(width, height);
		this.setPreferredSize(new Dimension(730, 400));
		this.setVisible(true);
		this.pack();
	}




	public void verifyConnection()
	{
		Connection connection = null;
		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
			Class.forName("com.mysql.jdbc.Driver");


			String url = "jdbc:mysql://db4free.net:3306/aquaworld";
			String user = "mithrandir21";
			String pass = "sauron21";
			// create a database connection
			connection = DriverManager.getConnection(url, user, pass);

			// connection = DriverManager.getConnection("jdbc:sqlite:Fish.db");
		}
		catch ( ClassNotFoundException e1 )
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{
			try
			{
				if ( connection != null )
					connection.close();
			}
			catch ( SQLException e )
			{
				// connection close failed.
				System.err.println(e);
			}
		}
	}



	public static Connection getConnectionToDB()
	{
		Connection connection = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			Class.forName("com.mysql.jdbc.Driver");


			// String url = "jdbc:mysql://db4free.net:3306/aquaworld";
			// String user = "mithrandir21";
			// String pass = "sauron21";
			// // create a database connection
			// connection = DriverManager.getConnection(url, user, pass);

			connection = DriverManager.getConnection("jdbc:sqlite:Fish.db");
			return connection;
		}
		catch ( ClassNotFoundException e1 )
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}


		return null;
	}



	public static void closeConnection(Connection con)
	{
		try
		{
			if ( con != null )
				con.close();
		}
		catch ( SQLException e )
		{
			// connection close failed.
			System.err.println(e);
		}
	}
}
