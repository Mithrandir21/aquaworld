package graphics;


import logistical.DataManipulation;




public class Sample
{
	public static void main(String[] args) throws ClassNotFoundException
	{
		// // load the sqlite-JDBC driver using the current class loader
		// Class.forName("org.sqlite.JDBC");
		//
		// Connection connection = null;
		// try
		// {
		// // create a database connection
		// connection = DriverManager.getConnection("jdbc:sqlite:Fish.db");
		// Statement statement = connection.createStatement();
		// statement.setQueryTimeout(30); // set timeout to 30 sec.
		//
		// statement.executeUpdate("drop table if exists person");
		// statement
		// .executeUpdate("create table person (id integer, name string)");
		// statement.executeUpdate("insert into person values(1, 'leo')");
		// statement.executeUpdate("insert into person values(2, 'yui')");
		// statement.executeUpdate("insert into person values(3, 'bam')");
		// statement.executeUpdate("insert into person values(4, 'ali')");
		// ResultSet rs = statement.executeQuery("select * from person");
		// while ( rs.next() )
		// {
		// // read the result set
		// System.out.println("name = " + rs.getString("name"));
		// System.out.println("id = " + rs.getInt("id"));
		// }
		// }
		// catch ( SQLException e )
		// {
		// // if the error message is "out of memory",
		// // it probably means no database file is found
		// System.err.println(e.getMessage());
		// }
		// finally
		// {
		// try
		// {
		// if ( connection != null )
		// connection.close();
		// }
		// catch ( SQLException e )
		// {
		// // connection close failed.
		// System.err.println(e);
		// }
		// }

		String newID = "334";
		

		 String[] IDs = { "3", "4", "6", "12" };
		// String[] IDs = { "1" };
		// String[] IDs = new String[0];
		
		
		IDs = DataManipulation.placeObjectIDinSortedArray(newID, IDs);
		
		
		for ( int i = 0; i < IDs.length; i++ )
		{
			System.out.println(IDs[i]);
		}

//		System.out.println(DataCheck.containsOnlyNumbers(""));

	}
}