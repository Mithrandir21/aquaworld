/**
 * 
 */
package graphics.GUI.graphicalFunctions;


import graphics.AquaWorld;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import javax.swing.ImageIcon;


/**
 * A class that contains methods for the creation and collection of the system
 * standard ImageIcon that are used, among other thing, for the creation of
 * objects or buttons.
 * 
 * @author Bahram Malaekeh
 */
public class MakeSystemImageIcons
{

	/**
	 * Gets the URL of this class to be used to locate all the system images and
	 * Icons. It calls the method visitAllFiles.
	 */
	public void getImageIcons()
	{
		URI uri = new File("./resource/images").toURI();

		File folder = new File(uri);

		visitAllFiles(folder);

		// setupAllSystemImageIcons();
	}


	/**
	 * Goes through all files and directories under a given folder. It finds and
	 * sets all files within this given folder with the file extensions *.png,
	 * *.jpg and *.gif. It then creates ImageIcons of these files and adds them
	 * to the system standard ImageIcons, located in AquaWorld, for later use in
	 * objects or buttons.
	 */
	public static void visitAllFiles(File dir)
	{
		if ( dir.isDirectory() )
		{
			String[] children = dir.list();
			for ( int i = 0; i < children.length; i++ )
			{
				visitAllFiles(new File(dir, children[i]));
			}
		}
		else
		{
			String name = dir.getName();

			if ( name.endsWith(".png") || name.endsWith(".jpg")
					|| name.endsWith(".gif") )
			{
				try
				{
					name = name.substring(0, (name.length() - 4));

					ImageIcon toBeAdded = ImageLocator.createImageIcon(dir
							.toURI().toURL());
					toBeAdded.setDescription(name);

					AquaWorld.images.add(toBeAdded);
				}
				catch ( MalformedURLException e )
				{
					e.printStackTrace();
				}
			}
		}
	}
}
