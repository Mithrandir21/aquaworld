/**
 * 
 */
package graphics.GUI.graphicalFunctions;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * This class contains methods and functions that perform action on graphical
 * components. Like finding and selecting indexes in JComboBoxes or JLists. Or
 * arranging components in panels or frames.
 * 
 * @author Bahram Malaekeh
 * @version 0.1
 */
public class GraphicalFunctions
{



	/**
	 * This method find and returns the index of data if it is found in the
	 * array of strings. If not it will return 0;
	 * 
	 * @param strings
	 *            The array that is searched for the data.
	 * @param data
	 *            The integer that is searched for in the array of
	 *            strings(converted to Integers).
	 * @return Returns the index in the array where the data has been found. If
	 *         not found, 0 will be returned.
	 */
	public static int getIndexInJComboBox(String[] strings, int data)
	{
		int Index = 0;

		for ( int i = 0; i < strings.length; i++ )
		{
			if ( strings[i] != "" )
			{
				if ( Integer.parseInt(strings[i]) == data )
				{
					Index = i;
					i = strings.length;
				}
			}
		}

		return Index;
	}



	/**
	 * This method find and returns the index of data if it is found in the
	 * array of strings. If not it will return 0;
	 * 
	 * @param strings
	 *            The array that is searched for the data.
	 * @param data
	 *            The string that is searched for in the array of strings.
	 * @return Returns the index in the array where the data has been found. If
	 *         not found, 0 will be returned.
	 */
	public static int getIndexInJComboBox(String[] strings, String data)
	{
		int Index = 0;

		for ( int i = 0; i < strings.length; i++ )
		{
			if ( data != null && data != "" )
			{
				if ( strings[i].equals(data) )
				{
					Index = i;
					i = strings.length;
				}
			}
		}

		return Index;
	}

	//
	//
	// /**
	// * This function does verifies that a component with the given class
	// exists
	// * in the components array of the main selected component. If it does the
	// * function then checks to verify that the input slot/socket matches with
	// * the slot/socket of the found component. If the two slots/sockets do not
	// * match the user is asked to verify their choice that will then lead to
	// the
	// * removal of the incompatible component.
	// *
	// * @param comp
	// * The components that will be the ancestor of the JOptionPane.
	// * @param mainObj
	// * The main component. The object which all other objects are
	// * children of.
	// * @param componentClass
	// * The class of the component that will be searched for.
	// * @param mbVariable
	// * The port, slot or socket on the motherboard.
	// * @param newVariable
	// * The port, slot or socket that the user has chosen.
	// * @param msg
	// * The message the user will see.
	// * @param strings
	// * The strings in the selected JComboBox.
	// * @param combo
	// * The JComboBox itself.
	// */
	// public static JComboBox verifyChange(Component comp, Object mainObj,
	// Class<?> componentClass, String mbVariable, String newVariable,
	// String msg, String[] strings, JComboBox combo)
	// {
	// if ( mbVariable != "" && mbVariable != null )
	// {
	// if ( ComponentsManagment.containsComponent(componentClass, mainObj
	// .getComponents(), mainObj.getComponents().length) )
	// {
	//
	// if ( !mbVariable.equals(newVariable) )
	// {
	// int n = JOptionPane.showConfirmDialog(comp, msg,
	// PrimeMain1.texts.getString("verify"),
	// JOptionPane.YES_NO_OPTION);
	//
	//
	// // If the answer is "No"
	// if ( n == 1 )
	// {
	//
	// combo.setSelectedIndex(getIndexInJComboBox(strings,
	// mbVariable));
	// }
	// }
	// }
	// }
	// return combo;
	// }




	/**
	 * This method looks for the given possibilities in the given data. If any
	 * are found the indexes of those are selected in the given list and that
	 * list is returned.
	 * 
	 * @param list
	 *            The list that will have selected indexes.
	 * @param possibilities
	 *            The information the method will look for in data.
	 * @param data
	 *            The data that will be searched.
	 * @return Returns the indexes of the given data in the array of
	 *         possibilities.
	 */
	public static JList getIndexInJList(JList list, String[] possibilities,
			String[] data)
	{
		int[] indices = new int[data.length];

		for ( int i = 0; i < data.length; i++ )
		{
			for ( int j = 0; j < possibilities.length; j++ )
			{
				if ( data[i].equals(possibilities[j]) )
				{
					indices[i] = j;

					// Stops the loop.
					j = possibilities.length;
				}
			}
		}


		list.setSelectedIndices(indices);

		return list;
	}




	/**
	 * This method takes all the component inside the given parent container and
	 * orders them so that there are no more then 6 components in any one row.
	 * This method is mostly used by the Object View like Hardware and Software
	 * views that show settings options.
	 * 
	 * @param parent
	 *            The container that holds the components that are to be
	 *            arranged.
	 * @param numberOfFields
	 *            The number of components in the container.
	 * @param initialX
	 *            The initial x location that the first component should be
	 *            placed.
	 * @param initialY
	 *            The initial y location that the first component should be
	 *            placed.
	 * @param xPad
	 *            The x padding that all components will have.
	 * @param yPad
	 *            The y padding that all components will have.
	 */
	public static void make6xGrid(Container parent, int numberOfFields,
			int initialX, int initialY, int xPad, int yPad)
	{
		Dimension tfSize = new Dimension(90, 20);

		int rows = 1;

		while ( numberOfFields > 6 )
		{
			numberOfFields = numberOfFields - 6;
			rows++;
		}

		while ( numberOfFields > -2 )
		{
			JLabel temp1 = new JLabel("");
			temp1.setMaximumSize(tfSize);
			temp1.setPreferredSize(tfSize);

			parent.add(temp1);

			numberOfFields--;
		}


		SpringUtilities.makeCompactGrid(parent, rows, 6, initialX, initialY,
				xPad, yPad);

	}



	/**
	 * This method takes all the component inside the given parent container and
	 * orders them so that there are no more then 1 components in any one row.
	 * This method is mostly used by the Object View like Hardware and Software
	 * views that show settings options.
	 * 
	 * @param parent
	 *            The container that holds the components that are to be
	 *            arranged.
	 * @param numberOfFields
	 *            The number of components in the container.
	 * @param initialX
	 *            The initial x location that the first component should be
	 *            placed.
	 * @param initialY
	 *            The initial y location that the first component should be
	 *            placed.
	 * @param xPad
	 *            The x padding that all components will have.
	 * @param yPad
	 *            The y padding that all components will have.
	 */
	public static void make1xGrid(Container parent, int numberOfFields,
			int initialX, int initialY, int xPad, int yPad)
	{
		int rows = numberOfFields;


		SpringUtilities.makeCompactGrid(parent, rows, 1, initialX, initialY,
				xPad, yPad);

	}



	//
	// /**
	// * Updates the LabelWidget that shows the widgetObjects name on the Scene
	// on
	// * the canvas.
	// *
	// * @param obj
	// * @param widgetObj
	// * @param name
	// * @return The object with the updated name
	// */
	// public static Object updateWidgetObjectCanvasName(Object obj,
	// WidgetObject widgetObj, String name)
	// {
	// if ( !(obj.getObjectName().equals(name)) )
	// {
	// // Sets the actual objects new Name
	// obj.setObjectName(name);
	//
	// List<Widget> children = widgetObj.getChildren();
	//
	// LabelWidget label = null;
	//
	//
	// for ( Iterator<Widget> iter = children.iterator(); iter.hasNext(); )
	// {
	// Widget temp = iter.next();
	// if ( temp instanceof LabelWidget )
	// {
	// label = (LabelWidget) temp;
	// }
	// }
	//
	// if ( label != null )
	// {
	// label.setLabel(name);
	// }
	// }
	//
	//
	// return obj;
	// }
	//
	//
	// /**
	// * Updates the LabelWidget that shows the widgetObjects name on the Scene
	// on
	// * the canvas. This method finds the WidgetObject that contains the given
	// * object in all the different canvases.
	// *
	// * @param obj
	// * @param name
	// * @return The object with the updated name
	// */
	// public static Object updateWidgetObjectCanvasName(WidgetObject obj,
	// String name)
	// {
	// if ( !(obj.getObject().getObjectName().equals(name)) )
	// {
	// obj.getObject().setObjectName(name);
	//
	// List<Widget> children = obj.getChildren();
	//
	// LabelWidget label = null;
	//
	// for ( Iterator<Widget> iter = children.iterator(); iter.hasNext(); )
	// {
	// Widget temp = iter.next();
	// if ( temp instanceof LabelWidget )
	// {
	// label = (LabelWidget) temp;
	// }
	// }
	//
	// if ( label != null )
	// {
	// label.setLabel(name);
	// }
	// }
	//
	//
	// return obj.getObject();
	// }
	//
	//
	//
	// /**
	// * Updates the LabelWidget that shows the widgetObjects name on the Scene
	// on
	// * the canvas. This method finds the WidgetObject that contains the given
	// * object in all the different canvases.
	// *
	// * @param obj
	// * @param name
	// * @return The object with the updated name
	// */
	// public static Object updateWidgetObjectCanvasName(Object obj, String
	// name)
	// {
	// WidgetObject widgetObj = CanvasManagment.findWidgetObject(obj,
	// PrimeMain1.canvases);
	//
	//
	// if ( !(obj.getObjectName().equals(name)) )
	// {
	// obj.setObjectName(name);
	//
	// List<Widget> children = widgetObj.getChildren();
	//
	// LabelWidget label = null;
	//
	// for ( Iterator<Widget> iter = children.iterator(); iter.hasNext(); )
	// {
	// Widget temp = iter.next();
	// if ( temp instanceof LabelWidget )
	// {
	// label = (LabelWidget) temp;
	// }
	// }
	//
	// if ( label != null )
	// {
	// label.setLabel(name);
	// }
	// }
	//
	//
	// return obj;
	// }
	//
	//
	//
	//
	// /**
	// * FIXME - FIX the update canvasName function.
	// */
	// public static void updateCanvasNames()
	// {
	// JPanel workpanel = PrimeMain1.getWorkareaPanel();
	//
	// WorkareaTabbed pane = (WorkareaTabbed) workpanel.getComponent(0);
	//
	// int tabCount = pane.getTabCount();
	//
	// for ( int i = 0; i < tabCount; i++ )
	// {
	// // WorkareaSceneScroll canvasScroll = (WorkareaSceneScroll)
	// // pane.getTabComponentAt(i);
	//
	// if ( pane.getTabComponentAt(i) == null )
	// {
	// System.out.println("feil");
	// }
	// else
	// // FIXME - UPDATING Canvas Tab Name
	// {
	// System.out.println("riktig");
	// }
	// }
	// }
	//
	//
	//
	// /**
	// * Updates all the LabelWidgets on the scene with the name of the object
	// * name that is within the WidgetObject.
	// */
	// public static void updateWidgetObjectNamesOnAllCanvas()
	// {
	// WorkareaCanvas[] canvases = PrimeMain1.canvases;
	//
	//
	// for ( int i = 0; i < canvases.length; i++ )
	// {
	// List<Widget> children = canvases[i].getMainLayer().getChildren();
	//
	// for ( Iterator<Widget> iter = children.iterator(); iter.hasNext(); )
	// {
	// WidgetObject temp = (WidgetObject) iter.next();
	//
	//
	// updateWidgetObjectCanvasName(temp.getObject(), temp, temp
	// .getObject().getObjectName());
	// }
	//
	// }
	// }
	//
	//




	//
	//
	// /**
	// * Gets the class of the given Object.
	// *
	// * @param obj
	// */
	// public static Class<?> getObjectClass(Object obj)
	// {
	// if ( obj.getClass().equals(Desktop.class) )
	// {
	// return Desktop.class;
	// }
	// else if ( obj.getClass().equals(Laptop.class) )
	// {
	// return Laptop.class;
	// }
	// else if ( obj.getClass().equals(ThinClient.class) )
	// {
	// return ThinClient.class;
	// }
	// else if ( obj.getClass().equals(HTTPServer.class) )
	// {
	// return HTTPServer.class;
	// }
	// else if ( obj.getClass().equals(MailServer.class) )
	// {
	// return MailServer.class;
	// }
	// else if ( obj.getClass().equals(BackupServer.class) )
	// {
	// return BackupServer.class;
	// }
	// else if ( obj.getClass().equals(FirewallServer.class) )
	// {
	// return FirewallServer.class;
	// }
	// else if ( obj.getClass().equals(ProxyServer.class) )
	// {
	// return ProxyServer.class;
	// }
	// else if ( obj.getClass().equals(Hub.class) )
	// {
	// return Hub.class;
	// }
	// else if ( obj.getClass().equals(Switch.class) )
	// {
	// return Switch.class;
	// }
	// else if ( obj.getClass().equals(Router.class) )
	// {
	// return Router.class;
	// }
	// else if ( obj.getClass().equals(WirelessRouter.class) )
	// {
	// return WirelessRouter.class;
	// }
	// else if ( obj.getClass().equals(Internet.class) )
	// {
	// return Internet.class;
	// }
	// else if ( obj.getClass().equals(Scanner.class) )
	// {
	// return Scanner.class;
	// }
	// else if ( obj.getClass().equals(Printer.class) )
	// {
	// return Printer.class;
	// }
	// else if ( obj.getClass().equals(NetworkPrinter.class) )
	// {
	// return NetworkPrinter.class;
	// }
	// else if ( obj.getClass().equals(MultifunctionPrinter.class) )
	// {
	// return MultifunctionPrinter.class;
	// }
	// else if ( obj.getClass().equals(NetworkMultifunctionPrinter.class) )
	// {
	// return NetworkMultifunctionPrinter.class;
	// }
	//
	// return null;
	// }



	// /**
	// * This method sets the widgetIcons, JLabel icon, transferhandler which
	// * takes care of the drag and drop functionality. It also adds an
	// * mouseListener to the JLabel.
	// */
	// public static void widgetIconSetup(WidgetIcon widget)
	// {
	// widget.addMouseListener(new TransferWidgetIconListener());
	// widget.setTransferHandler(new ImageSelection());
	// }



	/**
	 * This function shortens a String to 30 chars if the string is longer then
	 * 30 char. It adds 3 "." at the end of the shortend string.
	 */
	public static String verifyDescriptionLength(String Desc)
	{
		String shortDesc = "";

		// If the string is longer then 30 chars
		if ( Desc.length() > 30 )
		{
			// Goes through the first 27 chars
			for ( int i = 0; i < 27; i++ )
			{
				shortDesc = new StringBuffer(shortDesc).insert(i,
						Desc.charAt(i)).toString();
			}

			shortDesc = new StringBuffer(shortDesc).insert(27, ".").toString();
			shortDesc = new StringBuffer(shortDesc).insert(28, ".").toString();
			shortDesc = new StringBuffer(shortDesc).insert(29, ".").toString();
		}
		else
		{
			return Desc;
		}

		return shortDesc;
	}



	/**
	 * This function returns the File pointer for the given {@link ImageIcon}.
	 * The search will take place inside the images folder for the program. The
	 * function will return Null if no pointer is found.
	 * 
	 * @return A {@link File} pointer to the {@link ImageIcon} file.
	 */
	public static File getImageIconFile(ImageIcon image)
	{
		// The location of the images for the system
		URI uri = new File("./resource/images").toURI();

		File folder = new File(uri);


		// This returned file should contain a pointer to the ImageIcon, or Null
		return findImageFile(folder, image.getDescription());
	}


	/**
	 * Goes through all files and directories under a given folder. It finds and
	 * sets all files within this given folder with the file extensions *.png,
	 * *.jpg and *.gif. When it finds a file with the given name it returns the
	 * file.
	 */
	private static File findImageFile(File dir, String imageName)
	{
		if ( dir.isDirectory() )
		{
			String[] children = dir.list();
			for ( int i = 0; i < children.length; i++ )
			{
				File found = null;

				found = findImageFile(new File(dir, children[i]), imageName);

				// If found is not null, there has been found a file with the
				// given name, and found will be returned.
				if ( found != null )
				{
					return found;
				}
			}
		}
		else
		{
			String name = dir.getName();

			if ( name.endsWith(".png") || name.endsWith(".jpg")
					|| name.endsWith(".gif") )
			{
				name = name.substring(0, (name.length() - 4));

				// If the name of the file is the same as the given imageName
				if ( name.equalsIgnoreCase(imageName) )
				{
					return dir;
				}
			}
		}

		return null;
	}




	/**
	 * TODO - Description
	 */
	public static JPanel getUniquePanel(String labelName, String value)
	{
		JPanel panel = new JPanel(new GridLayout());
		// Dimension panelSize = new Dimension(115, 65);
		// panel.setPreferredSize(panelSize);
		// panel.setMinimumSize(panelSize);
		// panel.setMaximumSize(panelSize);
		// panel.setBorder(BorderFactory.createEtchedBorder());
		//
		//
		// GridBagConstraints c = new GridBagConstraints();
		//
		//
		// JLabel label = new JLabel(labelName);
		// c.fill = GridBagConstraints.BOTH;
		// // c.ipady = 0; // reset to default
		// // c.weightx = 1.0; // request any extra vertical space
		// // c.anchor = GridBagConstraints.CENTER; // bottom of space
		// // c.insets = new Insets(10, 0, 0, 0); // top padding
		// // c.gridx = 0; // aligned with button 2
		// // c.gridwidth = 1; // 2 columns wide
		// c.gridy = 0; // third row
		// panel.add(label, c);


		JLabel valueLabel = new JLabel(value);
		valueLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createEtchedBorder(), labelName));
		// c.fill = GridBagConstraints.BOTH;
		// // c.ipady = 0; // reset to default
		// // c.weightx = 1.0; // request any extra vertical space
		// // c.anchor = GridBagConstraints.CENTER; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// // c.gridx = 0; // aligned with button 2
		// // c.gridwidth = 1; // 2 columns wide
		// c.gridy = 0; // third row
		// panel.add(valueLabel, c);

		panel.add(valueLabel);


		return panel;
	}


}
