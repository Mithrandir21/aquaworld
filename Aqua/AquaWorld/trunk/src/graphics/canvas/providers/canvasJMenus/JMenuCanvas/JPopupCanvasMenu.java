package graphics.canvas.providers.canvasJMenus.JMenuCanvas;



import graphics.AquaWorld;
import graphics.canvas.WorkareaCanvas;

import java.awt.Point;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import actions.aquariumActions.ActionDeleteAllFishes;
import actions.systemActions.ActionPaste;


/**
 * The class that provides a JPopupMenu to be shown on any given canvas. The
 * methods in the class both creates and returns the menus.
 * 
 * @author Bahram Malaekeh
 */
public class JPopupCanvasMenu
{
	/**
	 * The actual JPopup menu that will contain the menus.
	 */
	private JPopupMenu popup = new JPopupMenu();


	/**
	 * The class that will listen for actions and then perform the correct
	 * action.
	 */
	private WorkareaCanvasActionListener canvasActListener;


	/**
	 * The canvas which the action will be performed on.
	 */
	private WorkareaCanvas canvas;


	/**
	 * Constructor for the class that takes a WorkareaCanvas as a parameter.
	 * 
	 * @param canvas
	 */
	public JPopupCanvasMenu(WorkareaCanvas canvas)
	{
		this.canvas = canvas;
	}



	/**
	 * The function calls the menu creator and returns the finished JPopupMenu.
	 * 
	 * @param localLocation
	 *            The location(Point) on the WorkareaCanvas that the menu will
	 *            be shown at
	 * @return The JPopupMenu that will be shown when a user right clicks on an
	 *         empty part of a WorkareaCanvas.
	 */
	public JPopupMenu createPopupMenu(Point localLocation)
	{
		// The action listener that will determine what actions from the
		// JPopupMenu
		// the user wants to perform.
		canvasActListener = new WorkareaCanvasActionListener(canvas,
				localLocation);

		// -------------------------------
		JMenuItem menuItem;

		menuItem = new JMenuItem(new ActionPaste("Paste Object"));

		// If neither the copy or cut pointers point to anything, the past
		// button will be disabled
		if ( AquaWorld.copyWidget == null && AquaWorld.cutWidget == null )
		{
			menuItem.setEnabled(false);
		}
		popup.add(menuItem);
		// --------------------------------

		// popup.addSeparator();

		// // Adds the "add objects" menu
		// ObjectCreationMenues();
		//		
		// popup.addSeparator();
		//		
		// // Adds the "remove" menu
		// createRemoveMenu();

		return popup;
	}




	/**
	 * Creates the initial submenus.
	 */
	private void ObjectCreationMenues()
	{

		JMenuItem submenuAdd = new JMenu(AquaWorld.texts
				.getString("canvasMenuAddNewDevices"));



		JMenuItem submenuDesktop = createAddDesktop(new JMenu(AquaWorld.texts
				.getString("canvasMenuAddClients")));
		submenuAdd.add(submenuDesktop);


		JMenuItem submenuServer = createAddServer(new JMenu(AquaWorld.texts
				.getString("canvasMenuAddServers")));
		submenuAdd.add(submenuServer);


		JMenuItem submenuInfrastructur = createAddInfrastructur(new JMenu(
				AquaWorld.texts.getString("canvasMenuAddInfrasctructur")));
		submenuAdd.add(submenuInfrastructur);


		JMenuItem submenuPeripheral = createAddPeripheral(new JMenu(
				AquaWorld.texts.getString("canvasMenuAddPeripheral")));
		submenuAdd.add(submenuPeripheral);



		popup.add(submenuAdd);
	}


	/**
	 * Creates the menus for the creation desktop objects.
	 */
	private JMenuItem createAddDesktop(JMenuItem submenuDesktop)
	{

		JMenuItem menuItem = new JMenuItem();

		menuItem = new JMenuItem(AquaWorld.texts.getString("desktop"));
		menuItem.setActionCommand("CreateNewST_Desktop_Item");
		menuItem.addActionListener(canvasActListener);
		submenuDesktop.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("laptop"));
		menuItem.setActionCommand("CreateNewST_Laptop_Item");
		menuItem.addActionListener(canvasActListener);
		submenuDesktop.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("thinClient"));
		menuItem.setActionCommand("CreateNewST_ThinClient_Item");
		menuItem.addActionListener(canvasActListener);
		submenuDesktop.add(menuItem);


		return submenuDesktop;
	}



	/**
	 * Creates the menus for the creation server objects.
	 */
	private JMenuItem createAddServer(JMenuItem submenuServer)
	{

		JMenuItem menuItem = new JMenuItem();

		menuItem = new JMenuItem(AquaWorld.texts.getString("httpServer"));
		menuItem.setActionCommand("CreateNewST_HTTPServer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuServer.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("backupServer"));
		menuItem.setActionCommand("CreateNewST_BackupServer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuServer.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("databaseServer"));
		menuItem.setActionCommand("CreateNewST_DatabaseServer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuServer.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("mailServer"));
		menuItem.setActionCommand("CreateNewST_MailServer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuServer.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("firewallServer"));
		menuItem.setActionCommand("CreateNewST_FirewallServer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuServer.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("proxyServer"));
		menuItem.setActionCommand("CreateNewST_ProxyServer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuServer.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("printerServer"));
		menuItem.setActionCommand("CreateNewST_PrinterServer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuServer.add(menuItem);


		return submenuServer;
	}



	/**
	 * Creates the menus for the creation infrastructur objects.
	 */
	private JMenuItem createAddInfrastructur(JMenuItem submenuInfrastructur)
	{

		JMenuItem menuItem = new JMenuItem();

		menuItem = new JMenuItem(AquaWorld.texts.getString("hub"));
		menuItem.setActionCommand("CreateNewST_Hub_Item");
		menuItem.addActionListener(canvasActListener);
		submenuInfrastructur.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("switch"));
		menuItem.setActionCommand("CreateNewST_Switch_Item");
		menuItem.addActionListener(canvasActListener);
		submenuInfrastructur.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("router"));
		menuItem.setActionCommand("CreateNewST_Router_Item");
		menuItem.addActionListener(canvasActListener);
		submenuInfrastructur.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("modem"));
		menuItem.setActionCommand("CreateNewST_Modem_Item");
		menuItem.addActionListener(canvasActListener);
		submenuInfrastructur.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("wirelessRouter"));
		menuItem.setActionCommand("CreateNewST_WirelessRouter_Item");
		menuItem.addActionListener(canvasActListener);
		submenuInfrastructur.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("internet"));
		menuItem.setActionCommand("CreateNewST_Internet_Item");
		menuItem.addActionListener(canvasActListener);
		submenuInfrastructur.add(menuItem);

		return submenuInfrastructur;
	}




	/**
	 * Creates the menus for the creation peripheral objects.
	 */
	private JMenuItem createAddPeripheral(JMenuItem submenuPeripheral)
	{

		JMenuItem menuItem = new JMenuItem();

		menuItem = new JMenuItem(AquaWorld.texts.getString("scanner"));
		menuItem.setActionCommand("CreateNewST_Scanner_Item");
		menuItem.addActionListener(canvasActListener);
		submenuPeripheral.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("printer"));
		menuItem.setActionCommand("CreateNewST_Printer_Item");
		menuItem.addActionListener(canvasActListener);
		submenuPeripheral.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("fax"));
		menuItem.setActionCommand("CreateNewST_Fax_Item");
		menuItem.addActionListener(canvasActListener);
		submenuPeripheral.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts
				.getString("multifunctionPrinter"));
		menuItem.setActionCommand("CreateNewST_MFP_Item");
		menuItem.addActionListener(canvasActListener);
		submenuPeripheral.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts.getString("networkPrinter"));
		menuItem.setActionCommand("CreateNewST_NetworkPrinter_Item");
		menuItem.addActionListener(canvasActListener);
		submenuPeripheral.add(menuItem);

		menuItem = new JMenuItem(AquaWorld.texts
				.getString("networkMultifunctionPrinter"));
		menuItem.setActionCommand("CreateNewST_NetworkMFP_Item");
		menuItem.addActionListener(canvasActListener);
		submenuPeripheral.add(menuItem);

		return submenuPeripheral;
	}
	

	/**
	 * Creates a menu that holds remove actions for the canvas.
	 * 
	 */
	private void createRemoveMenu()
	{
		JMenu submenu = new JMenu(AquaWorld.texts
				.getString("deleteSubMenuLabel"));

		JMenuItem removeAllWidgets = new JMenuItem(new ActionDeleteAllFishes(
				AquaWorld.texts.getString("deleteEverythingLabel")));
		removeAllWidgets.setIcon(null);
		submenu.add(removeAllWidgets);
		
		
		popup.add(submenu);
	}
}
