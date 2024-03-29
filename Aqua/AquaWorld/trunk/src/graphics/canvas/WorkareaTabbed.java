/**
 * 
 */
package graphics.canvas;


import graphics.AquaWorld;
import graphics.GUI.graphicalFunctions.ImageLocator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import widgetTank.Tank;
import coreObjects.Aquarium.Aquarium;


/**
 * Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * @version 0.1
 */
public class WorkareaTabbed extends JTabbedPane implements ActionListener
{
	/**
	 * A constructor for this class that add a changeListener that will call
	 * doRepaint on the WorkareaCanvas when any change occurs.
	 */
	public WorkareaTabbed()
	{

		addChangeListener(new ChangeListener()
		{
			// This method is called whenever the selected tab changes
			public void stateChanged(ChangeEvent evt)
			{
				// Gets the JTabbedPane that the event comes from.
				JTabbedPane pane = (JTabbedPane) evt.getSource();

				// Gets the scrollPane that the JTabbedPane contains.
				WorkareaSceneScroll currentScrollPane = (WorkareaSceneScroll) pane
						.getSelectedComponent();

				// Gets the workareaCanvas that the scrollPane contains.
				WorkareaCanvas currentCanvas = null;

				if ( currentScrollPane != null )
				{
					currentCanvas = currentScrollPane.getCanvas();
					// Repaints the entire canvas.(Avoids NullPointerExeption
					// errors from swing).
					currentCanvas.doRepaint();
				}

				// // Sets the current WidgetObject for the systems current
				// canvas
				// AquaWorld.currentCanvas.setCurrentWidgetObject(null);

				// Sets the current working canvas to the canvas that is
				// actually shown in the JTabbedPane scrollPane.
				AquaWorld.currentCanvas = currentCanvas;

				// PrimeMain1.updatePropertiesCanvasArea(false);
				//
				// PrimeMain1.runCanvasObjectCheck();
			}
		});


		int width = (int) (AquaWorld.width * 0.60);
		int height = (int) (AquaWorld.width * 0.60);
		this.setPreferredSize(new Dimension(width, height));
	}


	/**
	 * The function creates a new WorkareaSceneScroll and places that component
	 * within a new tab with the given name. The tab is then added to this
	 * JTabbedPane.
	 * 
	 * @param aquarium
	 *            The {@link Aquarium} that will be placed inside the new
	 *            WorkareaSceneScroll.
	 */
	public void createNewCanvasTab(Aquarium aquarium, String aquariumName)
	{
		WorkareaCanvas canvas = new WorkareaCanvas(aquariumName, aquarium);

		WorkareaSceneScroll canvasScroll = new WorkareaSceneScroll(canvas);

		this.createNewCanvasTab(canvasScroll, -1);

		this.setSelectedComponent(canvasScroll);
	}


	/**
	 * The function creates a new WorkareaSceneScroll and places that component
	 * within a new tab with the given name. The tab is then added to this
	 * JTabbedPane.
	 * 
	 * @param tank
	 *            The {@link Tank} that will be placed inside the new
	 *            WorkareaSceneScroll.
	 */
	public void createNewCanvasTab(Tank tank)
	{
		WorkareaCanvas canvas = new WorkareaCanvas(tank);

		WorkareaSceneScroll canvasScroll = new WorkareaSceneScroll(canvas);

		this.createNewCanvasTab(canvasScroll, -1);

		this.setSelectedComponent(canvasScroll);
	}



	/**
	 * The function creates a new WorkareaSceneScroll and places that component
	 * within a new tab with the given name. The tab is then added to this
	 * JTabbedPane.
	 * 
	 * @param canvas
	 *            The canvas that will be placed inside the new
	 *            WorkareaSceneScroll.
	 */
	public void createNewCanvasTab(WorkareaCanvas canvas)
	{
		WorkareaSceneScroll canvasScroll = new WorkareaSceneScroll(canvas);

		this.createNewCanvasTab(canvasScroll, -1);

		this.setSelectedComponent(canvasScroll);
	}



	/**
	 * Javadoc-TODO - Description
	 * 
	 * @param canvas
	 * @param Name
	 */
	public void updateCanvasName(WorkareaCanvas canvas, String Name)
	{
		// Check whether or not there exists a tab with the given canvas name
		if ( existsTabWithGivenName(canvas.getTankName()) )
		{
			// This is the current number of tabs
			int arraySize = this.getTabCount();

			// Goes through the list of tab contents until it finds one that
			// matches the given button name.
			for ( int i = 0; i < arraySize; i++ )
			{
				// Gets the tab component for the current tab.
				JPanel tabPanel = (JPanel) this.getTabComponentAt(i);

				// Gets the JLabel that contains the name of the WorkareaCanvas
				// in the tab
				JLabel label = (JLabel) tabPanel.getComponent(0);

				// If the JLabel text is the same as the given string
				if ( label.getText().equals(canvas.getTankName()) )
				{
					// // Changes the label of the tab
					// if ( DesktopFileManagment.changeFileName(canvas, Name) )
					// {
					// label.setText(Name);
					// }
					//
					// PrimeMain1.updatePropertiesCanvasArea(true);

					return;
				}
			}
		}
	}




	/**
	 * This function creates a new JPanel that will be added as the Tab for the
	 * given {@link WorkareaSceneScroll}. There will be placed an image in the
	 * JPanel which will be able to close the tab when pressed.
	 * 
	 * @param canvasScroll
	 *            The {@link WorkareaSceneScroll} that will be placed inside a
	 *            Tab with a custom Tab fan.
	 * @param tabIndex
	 */
	public void createNewCanvasTab(WorkareaSceneScroll canvasScroll,
			int tabIndex)
	{
		// The ImageIcon that will be shown and will remove a tab if pressed
		ImageIcon closeXIcon = ImageLocator.getImageIconObject("Close");

		// The dimensions of the new button.
		Dimension closeButtonSize = new Dimension(
				closeXIcon.getIconWidth() + 5, closeXIcon.getIconHeight() + 5);

		String name = canvasScroll.getCanvas().getTankName();


		// The actual panel that will be the component panel which the JLabel
		// and the button
		// will be placed inside.
		JPanel tab = new JPanel();

		// The Panel is not opaque
		tab.setOpaque(false);

		// The JLabel that will show the name of the tab
		JLabel tabLabel = new JLabel(name);

		// The button that will be represented by the ImageIcon
		JButton tabCloseButton = new JButton(closeXIcon);
		tabCloseButton.setName(name);
		tabCloseButton.setPreferredSize(closeButtonSize);
		tabCloseButton.addActionListener(this);

		// Adds the label and then the button to the panel.
		tab.add(tabLabel, BorderLayout.WEST);
		tab.add(tabCloseButton, BorderLayout.EAST);

		// Sets the name of the JScrollPane parameter
		canvasScroll.setName(name);


		if ( tabIndex == -1 )
		{
			// Add the tab to the tabbed pane.
			this.addTab(name, canvasScroll);

			// Instead of using a String/Icon combination for the tab, use our
			// panel instead.
			this.setTabComponentAt(this.getTabCount() - 1, tab);
		}
		else
		{
			// Add the tab to the tabbed pane.
			this.insertTab(name, null, canvasScroll, null, tabIndex);

			// Instead of using a String/Icon combination for the tab, use our
			// panel instead.
			this.setTabComponentAt(tabIndex, tab);
		}


		int width = (int) (AquaWorld.width * 0.60);
		int height = (int) (AquaWorld.width * 0.60);
		this.setPreferredSize(new Dimension(width, height));
	}



	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() instanceof JButton )
		{
			// Since there is no other components in this class that can call
			// the actionperformed method
			// then the created JButton, we cast the source of the event as a
			// JButton.
			JButton button = (JButton) e.getSource();

			String contentName = button.getName();



			// removeTabWithCanvas(contentName, CanvasManagment
			// .canvasHaveChanged(CanvasManagment.findCanvas(contentName,
			// PrimeMain1.canvases)));
		}
	}



	/**
	 * This function removes the Tab with the given name from this JTabbedPane.
	 * It can also check, if the given boolean is set to true, check the
	 * {@link WorkareaCanvas} which is inside the tab. If the
	 * {@link WorkareaCanvas} has been altered and not saved, it will ask the
	 * user if they wish to save the {@link WorkareaCanvas}.
	 * 
	 * @param canvasName
	 *            The name of {@link WorkareaCanvas} tab to be removed.
	 */
	public int indexOfTabWithCanvas(String canvasName)
	{
		// This is the current number of tabs
		int arraySize = this.getTabCount();

		// Goes through the list of tab contents until it finds one that matches
		// the given button name.
		for ( int i = 0; i < arraySize; i++ )
		{
			// Gets the tab component for the current tab.
			JPanel tabPanel = (JPanel) this.getTabComponentAt(i);

			// Gets the JLabel that contains the name of the WorkareaCanvas in
			// the tab
			JLabel label = (JLabel) tabPanel.getComponent(0);

			// If the JLabel text is the same as the given string
			if ( label.getText().equals(canvasName) )
			{
				// Returns the index of the tab
				return i;
			}
		}


		return -1;
	}



	/**
	 * This function removes the Tab with the given name from this JTabbedPane.
	 * It can also check, if the given boolean is set to true, check the
	 * {@link WorkareaCanvas} which is inside the tab. If the
	 * {@link WorkareaCanvas} has been altered and not saved, it will ask the
	 * user if they wish to save the {@link WorkareaCanvas}.
	 * 
	 * @param canvasName
	 *            The name of {@link WorkareaCanvas} tab to be removed.
	 */
	public void removeTabWithCanvas(String canvasName, boolean verify)
	{
		// Check whether or not there exists a tab with the given canvas name
		if ( existsTabWithGivenName(canvasName) )
		{
			// This is the current number of tabs
			int arraySize = this.getTabCount();

			// Goes through the list of tab contents until it finds one that
			// matches the given button name.
			for ( int i = 0; i < arraySize; i++ )
			{
				// Gets the tab component for the current tab.
				JPanel tabPanel = (JPanel) this.getTabComponentAt(i);

				// Gets the JLabel that contains the name of the WorkareaCanvas
				// in the tab
				JLabel label = (JLabel) tabPanel.getComponent(0);

				// If the JLabel text is the same as the given string
				if ( label.getText().equals(canvasName) )
				{
					WorkareaSceneScroll test = (WorkareaSceneScroll) this
							.getComponentAt(i);

					if ( verify )
					{
						// The options the user will be presented with.
						Object[] options = { AquaWorld.texts.getString("save"),
								AquaWorld.texts.getString("dontSave"),
								AquaWorld.texts.getString("cancel") };

						// Asks the user whether or not to save
						int answer = JOptionPane
								.showOptionDialog(
										null,
										AquaWorld.texts
												.getString("removeTabRemoveWithoutSavingQuestion"),
										AquaWorld.texts.getString("save"),
										JOptionPane.WARNING_MESSAGE,
										JOptionPane.WARNING_MESSAGE, null,
										options, null);

						// Save
						if ( answer == 0 )
						{
							// // Saves the canvas to a file.
							// DesktopFileManagment.saveWorkareaCanvas(test
							// .getCanvas());
							// this.removeTabAt(i);
							// DesktopCanvasManagment.removeWorkareaCanvas(test
							// .getCanvas());
							return;
						}
						// Dont save.
						else if ( answer == 1 )
						{
							this.removeTabAt(i);
							// DesktopCanvasManagment.removeWorkareaCanvas(test
							// .getCanvas());
							return;
						}
						else
						{
							return;
						}
					}
					else
					{
						this.removeTabAt(i);
						// DesktopCanvasManagment.removeWorkareaCanvas(test
						// .getCanvas());
						return;
					}
				}
			}
		}
	}




	/**
	 * Javadoc-TODO - Description
	 * 
	 * @param canvasName
	 * @return Returns true if there exists a tab with the given name and false
	 *         there does not.
	 */
	public boolean existsTabWithGivenName(String canvasName)
	{
		// This is the current number of tabs
		int arraySize = this.getTabCount();

		// Goes through the list of tab contents until it finds one that matches
		// the given button name.
		for ( int i = 0; i < arraySize; i++ )
		{
			// Gets the tab component for the current tab.
			JPanel tabPanel = (JPanel) this.getTabComponentAt(i);

			// Gets the JLabel that contains the name of the WorkareaCanvas in
			// the tab
			JLabel label = (JLabel) tabPanel.getComponent(0);

			if ( label.getText() != null
					&& label.getText().equalsIgnoreCase(canvasName) )
			{
				return true;
			}
		}


		return false;
	}



	/**
	 * Sets the {@link WorkareaCanvas} with the given name, if it exists, as the
	 * {@link WorkareaCanvas} visible tab.
	 */
	public void bringCanvasToFront(String canvasName)
	{
		// This is the current number of tabs
		int arraySize = this.getTabCount();

		// Goes through the list of tab contents until it finds one that matches
		// the given button name.
		for ( int i = 0; i < arraySize; i++ )
		{
			// Gets the tab component for the current tab.
			JPanel tabPanel = (JPanel) this.getTabComponentAt(i);

			// Gets the JLabel that contains the name of the WorkareaCanvas in
			// the tab
			JLabel label = (JLabel) tabPanel.getComponent(0);

			if ( label.getText() != null
					&& label.getText().equalsIgnoreCase(canvasName) )
			{
				this.setSelectedIndex(i);
			}
		}
	}
}
