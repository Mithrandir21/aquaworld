package graphics;


import exceptions.MoreTheOneResultObject;
import exceptions.ObjectIDnotFoundInDatabaseException;
import graphics.GUI.graphicalFunctions.MakeSystemImageIcons;
import graphics.GUI.menues.GenericPrimeMenuBar;
import graphics.GUI.menues.GenericPrimeToolbar;
import graphics.GUI.messageArea.MessageTabbed;
import graphics.GUI.messageArea.messageTabs.AdMessage;
import graphics.GUI.messageArea.messageTabs.AquariumAndEquipmentMessage;
import graphics.GUI.messageArea.messageTabs.FishAnimalsMessage;
import graphics.GUI.propertiesArea.ObjectScrollProperties;
import graphics.GUI.selectionArea.TabbedSelection;
import graphics.GUI.selectionArea.tabContent.SelectionOverview;
import graphics.ProgramGUI.TipOfDay;
import graphics.canvas.WorkareaCanvas;
import graphics.canvas.WorkareaTabbed;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import managment.IOmanagment;
import managment.Settings;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout;
import org.jdesktop.swingx.MultiSplitLayout.Node;

import sqlLogic.SQLfunctions;
import widgetTank.Tank;
import widgets.WidgetCoral;
import widgets.WidgetFish;
import widgets.WidgetInvertebrates;
import widgets.WidgetTransferable;
import coreObjects.ObjectParameters;
import coreObjects.Aquarium.SaltwaterAquarium;
import coreObjects.Coral.CoralObject;
import coreObjects.Coral.CoralObject.CoralTypes;
import coreObjects.Equipment.CirculationPump;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;
import coreObjects.Fish.FishObject.FishGender;
import coreObjects.Invertebrates.InvertebrateExclusions;
import coreObjects.Invertebrates.InvertebratesObject;
import coreObjects.Invertebrates.InvertebratesObject.InvertebratesTypes;


public class AquaWorld extends JFrame
{
	// // Daemon services running
	// private static PrimeService services;

	// The connection to the database.
	public static Connection connection;

	// Variables to place the height and width of the main screen.
	public static int width, height;

	// Main window panel setup
	private JPanel toolbarPanel;

	private static JPanel selectionPanel;

	// // The tab selection area where one can open projects and create new
	// objects
	// private static JPanel tabSelection;

	// The JPanel where the properties of any selected object or network
	// overview is shown.
	public static JPanel propertiesPanel;

	// The JPanel that will show information about the objects and the network.
	public static JPanel messagesPanel;

	// The JPanel that will hold all the canvas.
	private static JPanel workareaPanel;

	public static WorkareaTabbed workTab;

	static JXMultiSplitPane multiSplitPane = new JXMultiSplitPane();

	// A simple border that is gray
	Border grayline = BorderFactory.createLineBorder(Color.GRAY);

	// An array that points to all the currently open canvases in the
	// workarea.
	public static WorkareaCanvas[] canvases = new WorkareaCanvas[3];


	// A pointer to the currently open canvas that is displayed in the
	// workarea.
	public static WorkareaCanvas currentCanvas = null;

	// An ImageIcon array that contains all the icons used in the system.
	public static ArrayList<ImageIcon> images = new ArrayList<ImageIcon>(60);

	// // A pointer to where all standard internal components are kept.
	// public static MakeStandardInternalComponents standard_internal_components
	// = new MakeStandardInternalComponents();

	// // A pointer to where all standard softwares are kept.
	// public static MakeStandardSoftware standard_software = new
	// MakeStandardSoftware();

	// // The variable for the object that is in view.
	// public static ArrayList<ObjectView> objView = new
	// ArrayList<ObjectView>(1);

	// // The variable for the view of the standard object view.
	// public static StandardObjects stdObjView;

	// // The variable for the view of the visual editing JDialog.
	// public static VisualCustomFrame vcf;

	// The arraylist of the systems standard Objects
	public static ArrayList<FishObject> objectlist = new ArrayList<FishObject>();

	// The HashMap that contains object ImageIcons
	public static HashMap<Class, ImageIcon> objectImageIcons = new HashMap<Class, ImageIcon>();

	// The "Copy widget" widget holder
	public static WidgetTransferable copyWidget = null;

	// The "Cut widget" widget holder
	public static WidgetTransferable cutWidget = null;

	// The boolean saying if the user has set to expert mode
	public static boolean expertMode = false;

	// The locale texts
	public static ResourceBundle texts = ResourceBundle
			.getBundle("SystemTexts");



	// FIXME - Change the way ObjectViews are handled


	// Constructor
	public AquaWorld()
	{
		super("AquaWorld");

		// Tries to retrieve the users previous settings
		IOmanagment.openSettings();


		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// // Tries to retrieve the users previous settings
		// DesktopFileManagment.openSettings();


		// Get the default toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Get the current screen size
		Dimension scrnsize = toolkit.getScreenSize();


		width = ((int) scrnsize.getWidth()) - 200;

		height = ((int) scrnsize.getHeight()) - 200;



		// Creates the system icons and places them in the ImageIcon array.
		MakeSystemImageIcons standard_Image_Icons = new MakeSystemImageIcons();
		standard_Image_Icons.getImageIcons();



		// SETUP FOR THE OEVERALL GUI
		// Get the content pane for this object
		Container c = this.getContentPane();


		/*
		 * SETUP FOR THE toolbarPanel PANEL. This panel will contain all the
		 * toolbar buttons and icons.
		 */
		// Creates a new panel with a GridBagLayout.
		toolbarPanel = new JPanel(new BorderLayout());

		// toolbarPanel.setSize(11, 6);

		// Constraints for the window
		GridBagConstraints conToolbarPanel = new GridBagConstraints();

		// Sets the constraints to fill both vertical and horizontal
		conToolbarPanel.fill = GridBagConstraints.BOTH;

		// Sets the border around the panel
		toolbarPanel.setBorder(grayline);

		toolbarPanel.add(new GenericPrimeToolbar());


		// toolbarPanel.add(new JLabel("Toolbar"));

		/*
		 * SETUP FOR THE selectionPanel PANEL. This panel will contain all the
		 * selectable icons that can be places within the workarea, like client,
		 * server or printer icons. This will also contain the Project selection
		 * tab, where a user can pick different projects to work on in the
		 * workarea.
		 */
		// Creates a new panel with a GridBagLayout.
		selectionPanel = new JPanel(new GridLayout());

		// Constraints for the window
		GridBagConstraints conSelectionPanel = new GridBagConstraints();

		// Sets the constraints to fill both vertical and horizontal
		conSelectionPanel.fill = GridBagConstraints.BOTH;

		// Sets the border around the panel
		selectionPanel.setBorder(grayline);

		// selectionPanel.add(new JLabel("Selection"));

		// tabSelection = new JPanel();
		// selectionPanel.add(tabSelection);



		/*
		 * SETUP FOR THE propertiesPanel PANEL. This panel will contain some, if
		 * not all, of the properties of the selected object.
		 */
		// Creates a new panel with a GridBagLayout.
		propertiesPanel = new JPanel(new BorderLayout());

		// Constraints for the window
		GridBagConstraints conPropertiesPanel = new GridBagConstraints();

		// Sets the constraints to fill both vertical and horizontal
		conPropertiesPanel.fill = GridBagConstraints.BOTH;

		// Sets the border around the panel
		propertiesPanel.setBorder(grayline);

		// propertiesPanel.add(new ObjectProperties());

		// propertiesPanel.setPreferredSize(new Dimension(200, 300));

		/*
		 * SETUP FOR THE messagesPanel PANEL. This panel will contain the
		 * errors, warnings, and suggestions tabs that will give information to
		 * the user about different aspects of their network setup.
		 */
		// Creates a new panel with a GridBagLayout.
		// messagesPanel = new JPanel(new GridLayout(0,1));
		messagesPanel = new JPanel(new BorderLayout());

		// Constraints for the window
		GridBagConstraints conMessagesPanel = new GridBagConstraints();

		// Sets the constraints to fill both vertical and horizontal
		conMessagesPanel.fill = GridBagConstraints.BOTH;

		// Sets the border around the panel
		messagesPanel.setBorder(grayline);

		// MessageTabbed msgTabs = new MessageTabbed();
		// messagesPanel.add(msgTabs, BorderLayout.CENTER);
		// msgTabs.createInitialTabs();
		// messagesPanel.add(new JLabel("Messages"));


		/*
		 * SETUP FOR THE workareaPanel PANEL. This panel will contain the actual
		 * work area where all of the icons and connection will be shown. This
		 * is where the "map" of the network will be.
		 */
		// Creates a new panel with a GridBagLayout.
		workareaPanel = new JPanel(new BorderLayout());

		// Constraints for the window
		GridBagConstraints conWorkareaPanel = new GridBagConstraints();

		// Sets the constraints to fill both vertical and horizontal
		// conWorkareaPanel.fill = GridBagConstraints.BOTH;

		// Sets the border around the panel
		// workareaPanel.setBorder(grayline);

		workTab = new WorkareaTabbed();
		//
		// // workareaPanel.add(new WorkareaCanvas());
		workareaPanel.add(workTab);


		createAndPopulateDB();


		CirculationPump pump = new CirculationPump("PumpTest", "PumpTestDesc",
				2000);

		SaltwaterAquarium test = new SaltwaterAquarium("ProTest", "DeskTest",
				pump, 1, 3.4, 5.3, 26, 35, 60, 20);


		ObjectScrollProperties gg = new ObjectScrollProperties();
		propertiesPanel.add(gg);
		// gg.newObjectSelectedPropertiesTab(widCoral);





		// --------------------------------------------------
		// --------------------------------------------------

		MessageTabbed tabbed = new MessageTabbed();
		messagesPanel.add(tabbed);

		FishAnimalsMessage msgTabFish = new FishAnimalsMessage(test);
		AquariumAndEquipmentMessage msgTabAqua = new AquariumAndEquipmentMessage(
				test);
		AdMessage msgAd = new AdMessage();

		tabbed.addNewMessageTab("Fisk og Dyr", msgTabFish);
		tabbed.addNewMessageTab("Aquarium og Utstyr", msgTabAqua);
		tabbed.addNewMessageTab("Tilbud", msgAd);
		// tabbed.boldTab(msgAd.getClass());


		// --------------------------------------------------
		// --------------------------------------------------

		// TabbedSelection sel = new TabbedSelection();
		SelectionOverview sel = new SelectionOverview();
		selectionPanel.add(sel);









		this.setJMenuBar(new GenericPrimeMenuBar());
		//
		// this.add(new PrimeStatusBar(), BorderLayout.SOUTH);

		makeLayoutModel();
		// LoadLayoutModel();


		multiSplitPane.setDividerSize(5);

		multiSplitPane.setContinuousLayout(true);


		multiSplitPane.add(toolbarPanel, "toolbarLeaf");
		multiSplitPane.add(selectionPanel, "selectionLeaf");
		multiSplitPane.add(workareaPanel, "workareaLeaf");
		multiSplitPane.add(propertiesPanel, "propertiesLeaf");
		multiSplitPane.add(messagesPanel, "messagesLeaf");

		// System.out.println(((JPanel) multiSplitPane.getComponent(3))
		// .getComponent(0).getClass());

		// Adding everything to the contentpane of the JFrame
		c.add(multiSplitPane, BorderLayout.CENTER);



		this.setSize(width, height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);

		if ( Settings.showTOFD )
		{
			new TipOfDay();
		}
	}


	/**
	 * The programs Main function.
	 */
	public static void main(String[] args)
	{
		AquaWorld temp = new AquaWorld();

		// services = new PrimeService();

		temp.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent ev)
			{
				exitProcess();
			}
		});
	}


	/**
	 */
	private static void SaveLayoutModel()
	{
		try
		{
			XMLEncoder output = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream("PrimeLayoutModel.xml")));

			output.writeObject(multiSplitPane);
			output.close();
			// JOptionPane.showMessageDialog(null,"Saved model.");
		}
		catch ( FileNotFoundException output )
		{
			// JOptionPane.showMessageDialog(null,"Error saving layout model.");
		}
	}


	/**
	 */
	private void makeLayoutModel()
	{
		// String layoutDef =
		// "(COLUMN (LEAF name=toolbarLeaf) (ROW (LEAF name=selectionLeaf weight=0.2) "
		// + "(COLUMN weight=0.8(ROW (LEAF name=workareaLeaf weight=0.7) "
		// + "(LEAF name=propertiesLeaf weight=0.3) )"
		// + "(LEAF name=messagesLeaf weight=0.2)  ) ) )";

		String layoutDef = "(COLUMN (LEAF name=toolbarLeaf) (ROW (LEAF name=selectionLeaf weight=0.2) "
				+ "(COLUMN weight=0.8(ROW (LEAF name=workareaLeaf weight=0.7) "
				+ "(LEAF name=propertiesLeaf weight=0.3) )"
				+ "(LEAF name=messagesLeaf weight=0.2)  ) ) )";

		// JOptionPane.showMessageDialog(null,"Error Loading layout Model.");
		Node modelRoot = MultiSplitLayout.parseModel(layoutDef);
		multiSplitPane.getMultiSplitLayout().setModel(modelRoot);
		multiSplitPane.setPreferredSize(modelRoot.getBounds().getSize());
	}




	public static void fullscreen()
	{
		String layoutDef = "";

		if ( propertiesPanel.isVisible() )
		{
			propertiesPanel.setVisible(false);
			messagesPanel.setVisible(false);
			selectionPanel.setVisible(false);

			System.out.println("Full");
			//
			//
			// propertiesPanel.revalidate();
			// messagesPanel.revalidate();
			// selectionPanel.revalidate();
			//
			// propertiesPanel.repaint();
			// messagesPanel.repaint();
			// selectionPanel.repaint();

			// layoutDef =
			// "(COLUMN (LEAF name=toolbarLeaf) (ROW (LEAF name=selectionLeaf weight=0.0) "
			// + "(COLUMN weight=1.0 (ROW (LEAF name=workareaLeaf weight=1.0) "
			// + "(LEAF name=propertiesLeaf weight=0.0) )"
			// + "(LEAF name=messagesLeaf weight=0.0)  ) ) )";

			layoutDef = "(COLUMN (LEAF name=toolbarLeaf) (LEAF name=workareaLeaf weight=1.0) )";
		}
		else
		{
			propertiesPanel.setVisible(true);
			messagesPanel.setVisible(true);
			selectionPanel.setVisible(true);

			System.out.println("!Full");
			//
			//
			// propertiesPanel.revalidate();
			// messagesPanel.revalidate();
			// selectionPanel.revalidate();
			//
			// propertiesPanel.repaint();
			// messagesPanel.repaint();
			// selectionPanel.repaint();

			layoutDef = "(COLUMN (LEAF name=toolbarLeaf) (ROW (LEAF name=selectionLeaf weight=0.2) "
					+ "(COLUMN weight=0.8(ROW (LEAF name=workareaLeaf weight=0.7) "
					+ "(LEAF name=propertiesLeaf weight=0.3) )"
					+ "(LEAF name=messagesLeaf weight=0.2)  ) ) )";

		}

		// JOptionPane.showMessageDialog(null,"Error Loading layout Model.");
		Node modelRoot = MultiSplitLayout.parseModel(layoutDef);
		multiSplitPane.getMultiSplitLayout().setModel(modelRoot);
		multiSplitPane.setPreferredSize(modelRoot.getBounds().getSize());


		multiSplitPane.revalidate();
		multiSplitPane.repaint();

		// ((MessageTabbed) messagesPanel.getComponent(0)).revalidate();
		// ((MessageTabbed) messagesPanel.getComponent(0)).repaint();
		//
		propertiesPanel.revalidate();
		messagesPanel.revalidate();
		selectionPanel.revalidate();

		propertiesPanel.repaint();
		messagesPanel.repaint();
		selectionPanel.repaint();
		// repaint();
		// multiSplitPane.revalidate();
		// multiSplitPane.repaint();
	}



	/**
	 */
	private void LoadLayoutModel()
	{
		String layoutDef = "(COLUMN (LEAF name=toolbarLeaf) (ROW (LEAF name=selectionLeaf) "
				+ "(COLUMN (ROW (LEAF name=workareaLeaf weight=0.6) "
				+ "(LEAF name=propertiesLeaf weight=0.2) )"
				+ "(LEAF name=messagesLeaf weight=1)  ) ) )";


		try
		{
			XMLDecoder d = new XMLDecoder(new BufferedInputStream(
					new FileInputStream("PrimeLayoutModel.xml")));


			multiSplitPane = (JXMultiSplitPane) (d.readObject());
			d.close();
			// JOptionPane.showMessageDialog(null,"Loaded model.");
		}
		catch ( Exception exc )
		{
			// JOptionPane.showMessageDialog(null,"Error Loading layout
			// Model.");
			Node modelRoot = MultiSplitLayout.parseModel(layoutDef);
			multiSplitPane.getMultiSplitLayout().setModel(modelRoot);
			multiSplitPane.setPreferredSize(modelRoot.getBounds().getSize());
		}
	}


	/**
	 * 
	 */
	static void renderSplashFrame(Graphics2D g, int frame)
	{
		final String[] comps = { "Bam", "Lille-Bam", "Test" };
		g.setComposite(AlphaComposite.Clear);
		g.fillRect(120, 140, 200, 40);
		g.setPaintMode();
		g.setColor(Color.BLACK);
		g.drawString("Loading " + comps[(frame / 5) % 4] + "...", 120, 150);
	}





	/**
	 * TODO - Description
	 */
	public static MessageTabbed getMessageArea()
	{
		return (MessageTabbed) messagesPanel.getComponent(0);
	}



	/**
	 * TODO - Description
	 */
	public static TabbedSelection getSelectionArea()
	{
		return (TabbedSelection) selectionPanel.getComponent(0);
	}


	// updateObjectArea
	//
	//
	//
	// /**
	// * This method calls on functions that update the programs Object
	// selection,
	// * which shows available {@link WorkareaCanvas WorkareaCanvases}.
	// */
	// public static void updateObjectSelectionArea()
	// {
	// tabSelection.updateObjectArea();
	// tabSelection.validate();
	// tabSelection.repaint();
	// }
	//
	//
	// /**
	// * This method calls on functions that update the programs JTree, which
	// * shows available {@link WorkareaCanvas WorkareaCanvases}.
	// */
	// public static void updateNetworkSelectionArea()
	// {
	// tabSelection.getPrimeTree().createTree();
	// tabSelection.validate();
	// tabSelection.repaint();
	// }
	//
	//
	// /**
	// * Updates the properties panel with information from the currently
	// selected
	// * canvas.
	// *
	// * @param override
	// * Whether or not the method should update the the properties
	// * area even if the {@link WorkareaCanvas} being shown has not be
	// * altered.
	// */
	// public static void updatePropertiesCanvasArea(boolean override)
	// {
	// PropertiesArea temp = (PropertiesArea) propertiesPanel.getComponent(0);
	//
	// // If the method is to update the properties area regardless of whether
	// // or not the currently showing object is the same WorkareaCanvas
	// if ( override )
	// {
	// temp.newObjectSelectedPropertiesTab(currentCanvas);
	// }
	// else
	// {
	// // If the WorkareaCanvas shown in the properties area is not the
	// // same as the current WorkareaCanvas
	// if ( !(temp.isGivenCanvasCurrent(currentCanvas)) )
	// {
	// temp.newObjectSelectedPropertiesTab(currentCanvas);
	// }
	// }
	// }
	//
	//
	// /**
	// * Updates the properties panel with information from the given object.
	// *
	// * @param obj
	// * @param override
	// * Whether or not the method should update the the properties
	// * area even if the {@link WorkareaCanvas} being shown has not be
	// * altered.
	// */
	// public static void updatePropertiesObjectArea(Object obj, boolean
	// override)
	// {
	// PropertiesArea temp = (PropertiesArea) propertiesPanel.getComponent(0);
	//
	// // If the method is to update the properties area regardless of whether
	// // or not the currently showing object is the same Object
	// if ( override )
	// {
	// temp.newObjectSelectedPropertiesTab(obj);
	// }
	// else
	// {
	// // If the WorkareaCanvas shown in the properties area is not the
	// // same as the current WorkareaCanvas
	// if ( !(temp.isGivenObjectCurrent(obj)) )
	// {
	// temp.newObjectSelectedPropertiesTab(obj);
	// }
	// }
	//
	// }
	//
	//
	//
	// /**
	// * This method runs all update function. These include functions to update
	// * the canvas, properties panel and messages panel.
	// */
	// public static void updateCanvasAndObjectInfo()
	// {
	// runCanvasObjectCheck();
	// }
	//
	//
	//
	// /**
	// * Runs a check on all the objects on the current canvas and passed that
	// * information over to the JTable that shows� different errors, warnings
	// and
	// * notices.
	// */
	// public static void runCanvasObjectCheck()
	// {
	// // If there is no canvas open
	// if ( currentCanvas != null )
	// {
	// Object[] children = currentCanvas.getObjectsOnTheScene();
	//
	// MessageTabbed msgTab = (MessageTabbed) messagesPanel
	// .getComponent(0);
	//
	// msgTab.processAllObjects(children);
	// }
	// }
	//
	//
	//
	// /**
	// * Searches the object views that exist to find the given object as one of
	// * the views main object. If found that view is returned.
	// */
	// public static ObjectView getObjectView(Object obj)
	// {
	// Iterator<ObjectView> i = objView.iterator();
	// while ( i.hasNext() )
	// {
	// ObjectView objViewTest = i.next();
	//
	// if ( obj == objViewTest.getObject() )
	// {
	// return objViewTest;
	// }
	//
	// }
	//
	// return null;
	// }
	//
	//
	//
	// /**
	// * Adds a view to the arraylist of views.
	// */
	// public static void addObjectView(ObjectView view)
	// {
	// objView.add(view);
	// }
	//
	//
	// /**
	// * Removes the view, if it exist, that has as its main object the given
	// * object.
	// */
	// public static void removeObjectView(Object obj)
	// {
	// ObjectView view = getObjectView(obj);
	//
	// if ( view != null )
	// {
	// objView.remove(view);
	// }
	// }
	//
	//
	// /**
	// * Sets the actual JPanel that contains the WorkareaTabbed where all the
	// * systems {@link WorkareaCanvas WorkareaCanvases} area shown.
	// */
	// public static void setWorkareaPanel(JPanel workareaPanel)
	// {
	// PrimeMain1.workareaPanel = workareaPanel;
	// }
	//
	//
	//
	// /**
	// * Gets the actual JPanel that contains the WorkareaTabbed where all the
	// * systems {@link WorkareaCanvas WorkareaCanvases} area shown.
	// *
	// * @return workareaPanel the workareaPanel to get
	// */
	// public static JPanel getWorkareaPanel()
	// {
	// return workareaPanel;
	// }
	//
	//
	// /**
	// * Gets the WorkareaTabbed which contains the tabs with
	// * {@link WorkareaCanvas} inside.
	// *
	// * @return the workareaPanel
	// */
	// public static WorkareaTabbed getWorkarea()
	// {
	// return workTab;
	// }
	//



	/**
	 * 
	 */
	public static void exitProcess()
	{

		// Saves the settings the user has in his current session
		IOmanagment.saveSettings();

		System.exit(0);
	}



	public static void createAndPopulateDB()
	{
		long start = System.nanoTime();    
		
		CirculationPump pump = new CirculationPump("PumpTest", "PumpTestDesc",
				2000);

		SaltwaterAquarium test = new SaltwaterAquarium("ProTest", "DeskTest",
				pump, 1, 3.4, 5.3, 26, 35, 60, 20);

		Tank testTank = new Tank("Test Aquarium", test);

		workTab.createNewCanvasTab(testTank);


		double[] sal = { 1.0, 1.0 };
		double[] ph = { 5.6, 8.0 };
		double[] gh = { 1.0, 9.0 };
		double[] temp = { 23, 27.5 };
		double[] kh = { 6.0, 10.0 };
		double[] magnesium = { 300, 4500 };
		double[] calcium = { 1300, 1500 };

		// ---------------------------------------------------
		ObjectParameters parameter = new ObjectParameters(31, sal, ph, gh, temp);
		ObjectParameters parameter11 = new ObjectParameters(366, sal, ph, gh,
				temp);
		// ---------------------------------------------------
		parameter.setKh(kh);
		parameter.setMagnesium(magnesium);
		parameter.setCalcium(calcium);
		FishExclusions fishEx = new FishExclusions(441);
		FishExclusions fishEx1 = new FishExclusions(352);

		FishObject fish = new FishObject(00001, "Gullfiskius", "...Gullfish",
				FishGender.UNISEX, 7.5, parameter, fishEx);
		fish.setGenusName("GullFiskGenus");
		WidgetFish widFish = new WidgetFish(currentCanvas.getScene(), fish,
				null);


		FishObject fish1 = new FishObject(8888, "AndreGullfish", "...Gullfish",
				FishGender.UNISEX, 7.5, parameter11, fishEx1);
		fish1.setGenusName("GullFiskGenus");
		WidgetFish widFish1 = new WidgetFish(currentCanvas.getScene(), fish1,
				null);





		// ---------------------------------------------------
		ObjectParameters parameter1 = new ObjectParameters(442, sal, ph, gh,
				temp);
		// ---------------------------------------------------
		parameter1.setKh(kh);
		parameter1.setMagnesium(magnesium);
		parameter1.setCalcium(calcium);

		// ---------------------------------------------------

		CoralObject coral = new CoralObject(00002, "Coralius", "...Coral",
				CoralTypes.LargePolipedCoral, parameter1);


		WidgetCoral widCoral = new WidgetCoral(currentCanvas.getScene(), coral,
				null);






		// ---------------------------------------------------
		ObjectParameters parameter2 = new ObjectParameters(875, sal, ph, gh,
				temp);
		// ---------------------------------------------------
		parameter2.setKh(kh);
		parameter2.setMagnesium(magnesium);
		parameter2.setCalcium(calcium);

		InvertebrateExclusions invEx = new InvertebrateExclusions(957);

		// --------------------------------------------------

		InvertebratesObject invertebrate = new InvertebratesObject(00007,
				"Ivenius", "...Invertebrate", InvertebratesTypes.Anemones,
				parameter2, invEx);

		WidgetInvertebrates widInv = new WidgetInvertebrates(
				currentCanvas.getScene(), invertebrate, null);





		System.out.println("Starting");


		// load the sqlite-JDBC driver using the current class loader
		try
		{
			Class.forName("org.sqlite.JDBC");
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch ( ClassNotFoundException e1 )
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection connection = null;
		try
		{
			String url = "jdbc:mysql://localhost/aquaworld";
			String user = "aquaworld";
			String pass = "";

			// String url = "jdbc:mysql://db4free.net:3306/aquaworld";
			// String user = "";
			// String pass = "";
			// create a database connection
			connection = DriverManager.getConnection(url, user, pass);
			File invExFile = new File(
					"./resource/database/MySQLstatements/MySQL_InvertebrateExclusionList.txt");
			File fishExFile = new File(
					"./resource/database/MySQLstatements/MySQL_FishExclusionList.txt");
			File objectGroupFile = new File(
					"./resource/database/MySQLstatements/MySQL_ObjectGroup.txt");
			File objectParFile = new File(
					"./resource/database/MySQLstatements/MySQL_ObjectParameters.txt");
			File fishObjectFile = new File(
					"./resource/database/MySQLstatements/MySQL_FishObject.txt");
			File invertebrateObjectFile = new File(
					"./resource/database/MySQLStatements/MySQL_InvertebrateObject.txt");
			File coralObjectFile = new File(
					"./resource/database/MySQLStatements/MySQL_CoralObject.txt");
			File fishCampaignFile = new File(
					"./resource/database/MySQLStatements/MySQL_FishCampaign.txt");
			File coralCampaignFile = new File(
					"./resource/database/MySQLStatements/MySQL_CoralCampaign.txt");
			File invertebrateCampaignFile = new File(
					"./resource/database/MySQLStatements/MySQL_InvertebrateCampaign.txt");
			// File alterFile = new File(
			// "./resource/database/MySQLstatements/MySQL_ALTER.txt");


			// connection = DriverManager.getConnection("jdbc:sqlite:Fish.db");
			// File invExFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_InvertebrateExclusionList.txt");
			// File fishExFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_FishExclusionList.txt");
			// File objectGroupFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_ObjectGroup.txt");
			// File objectParFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_ObjectParameters.txt");
			// File fishObjectFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_FishObject.txt");
			// File invertebrateObjectFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_InvertebrateObject.txt");
			// File coralObjectFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_CoralObject.txt");
			// File fishCampaignFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_FishCampaign.txt");
			// File coralCampaignFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_CoralCampaign.txt");
			// File invertebrateCampaignFile = new File(
			// "./resource/database/SQLiteStatements/SQLite_InvertebrateCampaign.txt");
			// // File alterFile = new File(
			// // "./resource/database/SQLiteStatements/SQLite_ALTER.txt");



			SQLfunctions.databaseTablesDrop(connection);

			// InvertebrateExclusion
			String invExString = IOmanagment.getSQLtableString(invExFile);
			SQLfunctions.databaseStatementExecution(connection, invExString);

			// FishExclusion
			String fishExString = IOmanagment.getSQLtableString(fishExFile);
			SQLfunctions.databaseStatementExecution(connection, fishExString);

			// FishGroup
			String fishGroupString = IOmanagment
					.getSQLtableString(objectGroupFile);
			SQLfunctions
					.databaseStatementExecution(connection, fishGroupString);

			// ObjectParameters
			String objParString = IOmanagment.getSQLtableString(objectParFile);
			SQLfunctions.databaseStatementExecution(connection, objParString);

			// FishObject
			String fishObjectString = IOmanagment
					.getSQLtableString(fishObjectFile);
			SQLfunctions.databaseStatementExecution(connection,
					fishObjectString);

			// InvertebrateObject
			String invertebrateObjectString = IOmanagment
					.getSQLtableString(invertebrateObjectFile);
			SQLfunctions.databaseStatementExecution(connection,
					invertebrateObjectString);

			// CoralObject
			String coralObjectString = IOmanagment
					.getSQLtableString(coralObjectFile);
			SQLfunctions.databaseStatementExecution(connection,
					coralObjectString);

			// FishCampaing
			String fishCampaignString = IOmanagment
					.getSQLtableString(fishCampaignFile);
			SQLfunctions.databaseStatementExecution(connection,
					fishCampaignString);

			// InvertebrateCampaign
			String invertebrateCampaignString = IOmanagment
					.getSQLtableString(invertebrateCampaignFile);
			SQLfunctions.databaseStatementExecution(connection,
					invertebrateCampaignString);

			// CoralCampaign
			String coralCampaignString = IOmanagment
					.getSQLtableString(coralCampaignFile);
			SQLfunctions.databaseStatementExecution(connection,
					coralCampaignString);

			// ALTER
			// String alterString = IOmanagment.getSQLtableString(alterFile);
			// SQLfunctions.databaseStatementExecution(connection, alterString);




			SQLfunctions.databaseAddFishObjectAndParametersAndExclusions(
					connection, fish);

			SQLfunctions.databaseAddFishObjectAndParametersAndExclusions(
					connection, fish1);

			SQLfunctions.databaseAddCoralObjectAndCoralParameters(connection,
					coral);

			SQLfunctions
					.databaseAddInvertebrateObjectAndParametersAndExclusions(
							connection, invertebrate);


			SQLfunctions.databaseAddGroup(connection, "MiscGroup1",
					"GroupTesting", 1);

			SQLfunctions.databaseAddGroup(connection, "MiscGroup1",
					"GroupTesting", 1);

			SQLfunctions.databaseAddGroup(connection, "Group Bam",
					"GroupTesting", 2);

			SQLfunctions.databaseAddGroup(connection, "Group Johan",
					"GroupTesting", 3);


			SQLfunctions.databaseAddObjectToGroup(connection, "MiscGroup1",
					fish);
			SQLfunctions.databaseAddObjectToGroup(connection, "MiscGroup1",
					fish1);

			SQLfunctions.databaseAddObjectToGroup(connection, "MiscGroup1",
					coral);

			SQLfunctions.databaseAddObjectToGroup(connection, "MiscGroup1",
					invertebrate);

			//
			CoralObject coralObj = SQLfunctions.databaseGetCoralObject(
					connection, 2);


			InvertebratesObject invObj = SQLfunctions
					.databaseGetInvertebrateObject(connection, 7);


			FishObject fishObj = SQLfunctions.databaseGetFishObject(connection,
					1);

		}
		catch ( SQLException e )
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		catch ( ObjectIDnotFoundInDatabaseException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch ( MoreTheOneResultObject e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		System.out.println("Ending");
		long elapsedTime = System.nanoTime() - start;
		System.out.println(elapsedTime);
		System.exit(0);
	}
}
