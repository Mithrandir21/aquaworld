/**
 * 
 */
package widgets;



import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.netbeans.api.visual.widget.ImageWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.modules.visual.util.GeomUtil;

import coreObjects.Invertebrates.InvertebratesObject;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class WidgetInvertebrates extends ImageWidget implements
		WidgetTransferable
{
	// The object that the widget represents.
	private InvertebratesObject object = null;

	private static final DataFlavor flavors[] = new DataFlavor[1];


	private String label;


	/**
	 * The location of the widget.
	 */
	Point location;


	/**
	 * The serial number of the widget.
	 */
	int serial;



	/**
	 * The name of the widget.
	 */
	private String name;



	/**
	 * The note about the fish.
	 */
	private String note;


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param scene
	 * @param obj
	 * @param objImg
	 */
	public WidgetInvertebrates(Scene scene, InvertebratesObject obj,
			Image objImg)
	{
		super(scene, objImg);
		this.object = obj;
		this.name = obj.getSpeciesName();

		setFlavor();
	}



	// GETTERS
	/**
	 * @return the object
	 */
	public InvertebratesObject getObject()
	{
		return object;
	}



	/**
	 * @return A new Dimension with the size of the image.
	 */
	public Dimension getImageDimension()
	{
		return new Dimension(getImage().getHeight(null), getImage().getWidth(
				null));
	}


	/**
	 * Returns a label.
	 * 
	 * @return the label
	 */
	public String getLabel()
	{
		return label;
	}


	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#getWidgetLocation()
	 */
	@Override
	public Point getWidgetLocation()
	{
		return location;
	}



	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#getWidgetSerial()
	 */
	@Override
	public int getWidgetSerial()
	{
		return serial;
	}



	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#getWidgetObjectName()
	 */
	@Override
	public String getWidgetObjectName()
	{
		return name;
	}



	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#getWidgetNote()
	 */
	@Override
	public String getWidgetNote()
	{
		return note;
	}



	// SETTERS
	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(InvertebratesObject object)
	{
		this.object = object;
	}


	/**
	 * Sets a label.
	 * 
	 * @param label
	 *            the label
	 */
	public void setLabel(String label)
	{
		if ( GeomUtil.equals(this.label, label) )
		{
			return;
		}

		this.label = label;
		revalidate();
	}



	// TRANSFERABLE IMPLEMENTATION
	public WidgetInvertebrates getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException
	{
		// System.out.println("WidgetCanvas - getTransferData");
		if ( isDataFlavorSupported(flavor) )
		{
			return this;
		}
		return null;
	}



	public DataFlavor[] getTransferDataFlavors()
	{
		// System.out.println("WidgetCanvas - getTransferDataFlavors");
		return flavors;
	}



	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		return flavors[0].equals(flavor);
	}




	private DataFlavor[] setFlavor()
	{
		// System.out.println("WidgetCanvas - setFlavor");
		if ( flavors[0] == null )
		{
			flavors[0] = new DataFlavor(WidgetInvertebrates.class,
					"Widget Invertebrates");
		}
		// System.out.println("WidgetCanvas - " + flavors[0]);
		return flavors;
	}



	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#setWidgetLocation(java.awt.Point)
	 */
	@Override
	public void setWidgetLocation(Point location)
	{
		this.location = location;
	}



	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#setWidgetSerial(int)
	 */
	@Override
	public void setWidgetSerial(int serial)
	{
		this.serial = serial;
	}



	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#setWidgetObjectName(java.lang.String)
	 */
	@Override
	public void setWidgetObjectName(String name)
	{
		this.name = name;
	}



	/*
	 * (non-Javadoc)
	 * @see widgets.WidgetTransferable#setWidgetNote(java.lang.String)
	 */
	@Override
	public void setWidgetNote(String note)
	{
		this.note = note;
	}
}
