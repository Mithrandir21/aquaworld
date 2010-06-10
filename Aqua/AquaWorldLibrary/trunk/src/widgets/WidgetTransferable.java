/**
 * 
 */
package widgets;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.datatransfer.Transferable;

/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
public interface WidgetTransferable extends Transferable
{
	
	
	
	/**
	 *  @return A new Dimension with the size of the image. 
	 */
	public Dimension getImageDimension();
	
	

	/**
	 * TODO - Description
	 */
	public Point getWidgetLocation();



	/**
	 * TODO - Description
	 * 
	 */
	public void setWidgetLocation(Point location);



	/**
	 * TODO - Description
	 */
	public int getWidgetSerial();



	/**
	 * TODO - Description
	 */
	public void setWidgetSerial(int serial);



	/**
	 * TODO - Description
	 */
	public String getWidgetObjectName();



	/**
	 * TODO - Description
	 */
	public void setWidgetObjectName(String name);



	/**
	 * TODO - Description
	 */
	public String getWidgetNote();



	/**
	 * TODO - Description
	 */
	public void setWidgetNote(String note);
}
