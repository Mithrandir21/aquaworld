/**
 * 
 */
package graphics.GUI.selectionArea;



import graphics.AquaWorld;
import graphics.canvas.WorkareaCanvas;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import widgets.WidgetIcon;



/**
 * NOTE - Maybe set in a vertical tab for all the different object categories.
 */

/**
 * This JPanel extension is where the images of the different {@link Object
 * Objects} are placed. They can be clicked and dragged into an open {@link WorkareaCanvas}.
 * 
 * @author Bahram Malaekeh
 * @version 1.0
 */
public class ObjectSelection extends JPanel
{
	/**
	 * TODO - Description NEEDED!
	 */
	public ObjectSelection()
	{
		setupObjectsGroups(null, false);
	}


	/**
	 * TODO - Description NEEDED!
	 */
	public ObjectSelection(boolean transferable)
	{
		setupObjectsGroups(null, transferable);
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param mouseLis
	 */
	public ObjectSelection(MouseListener mouseLis)
	{
		setupObjectsGroups(mouseLis, false);
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param mouseLis
	 */
	public ObjectSelection(MouseListener mouseLis, boolean transferable)
	{
		setupObjectsGroups(mouseLis, transferable);
	}


	/**
	 * TODO - Description
	 */
	private void setupObjectsGroups(MouseListener mouseLis, boolean transferable)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();


		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridx = 0;


		JXTaskPaneContainer tpc = new JXTaskPaneContainer();


		d.gridy = 0;
		// Adds the group panel to the collapsible container
		tpc.add(fishIcons(mouseLis, transferable));


		// d.gridy = 1;
		// Adds the group panel to the collapsible container
		tpc.add(coralIcons(mouseLis, transferable));


		// d.gridy = 2;
		// Adds the group panel to the collapsible container
		tpc.add(invertebrateIcons(mouseLis, transferable));
		//
		//
		// d.gridy = 3;
		// // Adds the group panel to the collapsible container
		// tpc.add(initInfrastructureButtonIcons(mouseLis, transferable));



		JScrollPane scrollArea = new JScrollPane(tpc);
		// Increases how far the scroll bar scrolls on one step of a mouse wheel
		scrollArea.getVerticalScrollBar().setUnitIncrement(30);


		// Adds the container to this panel
		this.add(scrollArea, d);

		// this.setPreferredSize(new Dimension(240, getCompSize()));
	}


	/**
	 * TODO - Description
	 */
	private JXTaskPane fishIcons(MouseListener mouseLis, boolean transferable)
	{
		ArrayList<WidgetIcon> iconsList = new ArrayList<WidgetIcon>();

		// iconsList.add(makeImageIcon(Desktop.class, mouseLis, transferable));
		// iconsList.add(makeImageIcon(Laptop.class, mouseLis, transferable));
		// iconsList.add(makeImageIcon(ThinClient.class, mouseLis, transferable));

		WidgetIcon[] widIcons = new WidgetIcon[iconsList.size()];
		iconsList.toArray(widIcons);


		return getWidgetGroup("Fish", widIcons, true);
	}



	/**
	 * TODO - Description
	 */
	private JXTaskPane coralIcons(MouseListener mouseLis, boolean transferable)
	{
		ArrayList<WidgetIcon> iconsList = new ArrayList<WidgetIcon>();

		// iconsList.add(makeImageIcon(Desktop.class, mouseLis, transferable));
		// iconsList.add(makeImageIcon(Laptop.class, mouseLis, transferable));
		// iconsList.add(makeImageIcon(ThinClient.class, mouseLis, transferable));

		WidgetIcon[] widIcons = new WidgetIcon[iconsList.size()];
		iconsList.toArray(widIcons);


		return getWidgetGroup("Invertebrate", widIcons, true);
	}



	/**
	 * TODO - Description
	 */
	private JXTaskPane invertebrateIcons(MouseListener mouseLis,
			boolean transferable)
	{
		ArrayList<WidgetIcon> iconsList = new ArrayList<WidgetIcon>();

		// iconsList.add(makeImageIcon(Desktop.class, mouseLis, transferable));
		// iconsList.add(makeImageIcon(Laptop.class, mouseLis, transferable));
		// iconsList.add(makeImageIcon(ThinClient.class, mouseLis, transferable));

		WidgetIcon[] widIcons = new WidgetIcon[iconsList.size()];
		iconsList.toArray(widIcons);


		return getWidgetGroup("Invertebrate", widIcons, true);
	}



	//
	// /**
	// * TODO - Description
	// */
	// private JXTaskPane initServerButtonIcons(MouseListener mouseLis,
	// boolean transferable)
	// {
	// ArrayList<WidgetIcon> iconsList = new ArrayList<WidgetIcon>();
	//
	// iconsList.add(makeImageIcon(HTTPServer.class, mouseLis, transferable));
	// iconsList
	// .add(makeImageIcon(BackupServer.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(DatabaseServer.class, mouseLis,
	// transferable));
	// iconsList.add(makeImageIcon(MailServer.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(FirewallServer.class, mouseLis,
	// transferable));
	// iconsList.add(makeImageIcon(ProxyServer.class, mouseLis, transferable));
	// iconsList
	// .add(makeImageIcon(PrinterServer.class, mouseLis, transferable));
	//
	// WidgetIcon[] widIcons = new WidgetIcon[iconsList.size()];
	// iconsList.toArray(widIcons);
	//
	//
	// return getWidgetGroup("Server Devices", widIcons, true);
	// }
	//
	// /**
	// * TODO - Description
	// */
	// private JXTaskPane initExternalHardwareButtonIcons(MouseListener mouseLis,
	// boolean transferable)
	// {
	// ArrayList<WidgetIcon> iconsList = new ArrayList<WidgetIcon>();
	//
	// iconsList.add(makeImageIcon(Scanner.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(Printer.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(Fax.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(MultifunctionPrinter.class, mouseLis,
	// transferable));
	// iconsList.add(makeImageIcon(NetworkPrinter.class, mouseLis,
	// transferable));
	// iconsList.add(makeImageIcon(NetworkMultifunctionPrinter.class,
	// mouseLis, transferable));
	//
	// WidgetIcon[] widIcons = new WidgetIcon[iconsList.size()];
	// iconsList.toArray(widIcons);
	//
	//
	// return getWidgetGroup("External Devices", widIcons, false);
	// }
	//
	// /**
	// * TODO - Description
	// */
	// private JXTaskPane initInfrastructureButtonIcons(MouseListener mouseLis,
	// boolean transferable)
	// {
	// ArrayList<WidgetIcon> iconsList = new ArrayList<WidgetIcon>();
	//
	// iconsList.add(makeImageIcon(Hub.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(Switch.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(Router.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(Modem.class, mouseLis, transferable));
	// iconsList.add(makeImageIcon(WirelessRouter.class, mouseLis,
	// transferable));
	// iconsList.add(makeImageIcon(Internet.class, mouseLis, transferable));
	//
	// WidgetIcon[] widIcons = new WidgetIcon[iconsList.size()];
	// iconsList.toArray(widIcons);
	//
	//
	// return getWidgetGroup("Network Devices", widIcons, false);
	// }


	/**
	 * TODO - Description
	 */
	private JXTaskPane getWidgetGroup(String groupName, WidgetIcon[] widIcons,
			boolean collapsed)
	{
		// "System" GROUP
		JXTaskPane group = new JXTaskPane();
		group.setTitle(groupName);
		group.setSpecial(true);
		group.setCollapsed(collapsed);



		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.weighty = 1.0; // request any extra vertical space
		d.weightx = 1.0; // request any extra vertical space
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		d.insets = new Insets(0, 0, 5, 0); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridy = 0;


		for ( int i = 0; i < widIcons.length; i++ )
		{
			d.gridy = i;
			panel.add(widIcons[i], d);
		}


		// Adds the panel with the objects to the group panel
		group.add(panel);

		return group;
	}




	/**
	 * TODO - Description
	 */
	@SuppressWarnings("unchecked")
	private WidgetIcon makeImageIcon(Class objectType, MouseListener mouseLis,
			boolean transferable)
	{
		ImageIcon Icon = AquaWorld.objectImageIcons.get(objectType);

		WidgetIcon iconButton = null;

		try
		{
			iconButton = new WidgetIcon(Icon, objectType, objectType
					.getSimpleName());

			// Adds the given mouselistener if its not null
			if ( mouseLis != null )
			{
				iconButton.addMouseListener(mouseLis);
			}
		}
		catch ( Exception e )
		{
			System.out.println("NullPointerException" + " - ObjectSelection "
					+ " - " + objectType + "\n\n");
			System.exit(0);
		}


		if ( transferable )
		{
			// Sets up the WidgetIcon
			// GraphicalFunctions.widgetIconSetup(iconButton);
		}

		iconButton.setSize(Icon.getIconWidth(), Icon.getIconHeight());

		// iconButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		// iconButton.setHorizontalTextPosition(AbstractButton.CENTER);
		iconButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		iconButton.setAlignmentY(Component.TOP_ALIGNMENT);
		// iconButton.setBorder(grayline);

		return iconButton;
	}
}
