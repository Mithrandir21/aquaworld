/**
 * 
 */
package managment;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class IOmanagment
{
	/**
	 * TODO - Description
	 */
	public static String getSQLtableString(File file)
	{
		String tables = "";
		String temp = "";

		try
		{
			FileInputStream fin = new FileInputStream(file);

			DataInputStream ois = new DataInputStream(fin);

			BufferedReader d = new BufferedReader(new InputStreamReader(ois));

			while ( (temp = d.readLine()) != null )
			{
				// System.out.println(temp);
				tables += temp;
			}

			ois.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}

		return tables;
	}




	/**
	 * Saves the {@link Settings} instance to a file to preserve the users
	 * settings.
	 */
	public static void saveSettings()
	{
		File file = new File("./resource/settings.dat");

		try
		{
			FileOutputStream fout = new FileOutputStream(file);

			// The object stream file
			ObjectOutputStream oos = new ObjectOutputStream(fout);


			oos.writeBoolean(managment.Settings.showTOFD);

			oos.flush();
			oos.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}



	/**
	 * Opens the {@link Settings} instance from a file to preserve the users
	 * settings from previous sessions.
	 */
	public static void openSettings()
	{
		File file = new File("./resource/settings.dat");

		// If the Objects file exists
		if ( file.exists() )
		{
			// If the pointer is to a file and not anything else
			if ( file.isFile() )
			{
				// If the file can be written to
				if ( file.canRead() )
				{
					try
					{
						FileInputStream fin = new FileInputStream(file);

						ObjectInputStream ois = new ObjectInputStream(fin);


						managment.Settings.showTOFD = ois.readBoolean();


						ois.close();
					}
					catch ( Exception e )
					{
						e.printStackTrace();
					}
				}
			}
		}
	}





}
