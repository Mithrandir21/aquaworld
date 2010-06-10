/**
 * 
 */
package graphics.canvas;


import java.awt.datatransfer.DataFlavor;

import javax.swing.TransferHandler;

import widgets.WidgetCoral;
import widgets.WidgetEquipment;
import widgets.WidgetFish;
import widgets.WidgetInvertebrates;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class WidgetTransferHandler extends TransferHandler
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.TransferHandler#canImport(javax.swing.TransferHandler.TransferSupport)
	 */
	@Override
	public boolean canImport(TransferSupport support)
	{
		DataFlavor flavors[] = support.getDataFlavors();
		if ( flavors[0].equals(new DataFlavor(WidgetFish.class, "Widget Fish")) )
		{
			return true;
		}
		else if ( flavors[0].equals(new DataFlavor(WidgetCoral.class,
				"Widget Coral")) )
		{
			return true;
		}
		else if ( flavors[0].equals(new DataFlavor(WidgetEquipment.class,
				"Widget EquipmentS")) )
		{
			return true;
		}
		else if ( flavors[0].equals(new DataFlavor(WidgetInvertebrates.class,
				"Widget Invertebrates")) )
		{
			return true;
		}


		return false;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.TransferHandler#importData(javax.swing.TransferHandler.TransferSupport)
	 */
	@Override
	public boolean importData(TransferSupport support)
	{
		return true;
	}



}
