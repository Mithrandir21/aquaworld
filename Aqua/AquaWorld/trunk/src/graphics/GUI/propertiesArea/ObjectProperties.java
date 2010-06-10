/**
 * 
 */
package graphics.GUI.propertiesArea;


import graphics.AquaWorld;
import graphics.GUI.graphicalFunctions.GraphicalFunctions;
import graphics.GUI.propertiesArea.objectTypes.CoralPropertiesView;
import graphics.GUI.propertiesArea.objectTypes.EquipmentPropertiesView;
import graphics.GUI.propertiesArea.objectTypes.FishPropertiesView;
import graphics.GUI.propertiesArea.objectTypes.InvertebratesPropertiesView;
import graphics.GUI.propertiesArea.objectTypes.TankPropertiesView;
import graphics.canvas.WorkareaCanvas;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import widgets.WidgetCoral;
import widgets.WidgetEquipment;
import widgets.WidgetFish;
import widgets.WidgetInvertebrates;
import widgets.WidgetTransferable;


/**
 * This class will display the properties of any selected {@link WidgetObject}
 * or {@link WorkareaCanvas}.
 * 
 * @author Bahram Malaekeh
 */
public class ObjectProperties extends JPanel implements ActionListener
{
	private WidgetTransferable objectViewed = null;

	private WorkareaCanvas canvasViewed = null;

	/**
	 * The boolean that will show more information about the widget.
	 */
	private boolean moreInfo = false;


	/**
	 * The button for more info
	 */
	private JButton moreInfoButton;


	JPanel pp;


	/**
	 * An empty constructor that just sets the size of the JPanel.
	 */
	public ObjectProperties()
	{
		int width = (int) (AquaWorld.width * 0.11);

		int height = (int) (AquaWorld.height * 0.70);

		// this.setMinimumSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
	}



	/**
	 * A class constructor that takes a WorkareaCanvas and creates places
	 * information about that canvas on to this JPanel.
	 * 
	 * @param canvas
	 */
	public ObjectProperties(WorkareaCanvas canvas)
	{
		createTankProperties(canvas);
	}



	/**
	 * TODO - Description
	 */
	public void createTankProperties(WorkareaCanvas canvas)
	{
		if ( canvas != null )
		{
			this.removeAll();

			canvasViewed = canvas;

			this.setLayout(new SpringLayout());

			TankPropertiesView.getTankProperties(this, canvas.getTank());

			JPanel buttons = createSaveButtons();

			this.add(buttons);


			// Lay out the panel.
			GraphicalFunctions.make1xGrid(this, this.getComponentCount(),
					6, 6, // initX, initY
					6, 6); // xPad, yPad
		}
		else
		{
			this.removeAll();
		}
	}



	/**
	 * Adds the standard properties which normally is name and description.
	 */
	public ObjectProperties(WidgetTransferable object)
	{
		createWidgetProperties(object, false);
	}



	/**
	 * TODO - Description
	 */
	public void createWidgetProperties(WidgetTransferable object,
			boolean additionalInfo)
	{
		if ( object != null )
		{
			this.removeAll();

			objectViewed = object;

			this.setLayout(new SpringLayout());

			
			if( object instanceof WidgetFish )
			{
				FishPropertiesView.getFishProperties(this, (WidgetFish) object,
						additionalInfo);

				this.add(createMoreInfoButtons());
			}
			else if( object instanceof WidgetCoral )
			{
				CoralPropertiesView.getCoralProperties(this,
						(WidgetCoral) object, additionalInfo);

				this.add(createMoreInfoButtons());
			}
			else if( object instanceof WidgetInvertebrates )
			{
				InvertebratesPropertiesView.getInvertebratesProperties(this,
						(WidgetInvertebrates) object, additionalInfo);

				this.add(createMoreInfoButtons());
			}
			else if( object instanceof WidgetEquipment )
			{
				EquipmentPropertiesView.getEquipmentProperties(this,
						(WidgetEquipment) object);
			}

			// Lay out the panel.
			GraphicalFunctions.make1xGrid(this, this.getComponentCount(), 6, 6, // initX,
																				// initY
					6, 6); // xPad, yPad


		}
		else
		{
			this.removeAll();
		}
	}



	/**
	 * Gets the {@link Object} viewed.
	 */
	public WidgetTransferable getWidgetViewed()
	{
		return objectViewed;
	}



	/**
	 * Gets the {@link WorkareaCanvas} viewed.
	 */
	public WorkareaCanvas getCanvasViewed()
	{
		return canvasViewed;
	}


	/**
	 * Creates a JPanel with more info buttons that are listened for by
	 * actionlisteners.
	 */
	private JPanel createMoreInfoButtons()
	{
		pp = new JPanel();
		pp.setLayout(new FlowLayout(FlowLayout.TRAILING));

		moreInfoButton = new JButton(AquaWorld.texts.getString("moreInfo"));
		moreInfoButton.addActionListener(this);
		moreInfoButton.setActionCommand("info");


		pp.add(moreInfoButton);

		return pp;
	}



	/**
	 * Creates a JPanel with save buttons that are listened for by
	 * actionlisteners.
	 */
	private JPanel createSaveButtons()
	{
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));

		Button save = new Button(AquaWorld.texts.getString("save"));
		save.addActionListener(this);
		save.setActionCommand(AquaWorld.texts.getString("save"));


		buttons.add(save);

		return buttons;
	}


	/**
	 * Javadoc-TODO - Description
	 */
	public void saveAction()
	{
		Component[] comp = this.getComponents();


	}


	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getActionCommand().equals(AquaWorld.texts.getString("save")) )
		{
			saveAction();
		}
		else if ( e.getActionCommand().equals("info") )
		{
			if ( moreInfo )
			{
				createWidgetProperties(objectViewed, false);
				moreInfo = false;
				moreInfoButton.setText(AquaWorld.texts.getString("moreInfo"));
			}
			else
			{
				createWidgetProperties(objectViewed, true);
				moreInfo = true;
				moreInfoButton.setText(AquaWorld.texts.getString("lessInfo"));
			}
			
			this.revalidate();
			this.repaint();
		}
	}
}
