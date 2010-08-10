/**
 * 
 */
package graphics.adGraphics;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;

import org.jdesktop.swingx.JXCollapsiblePane;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class Square200AdPanel extends JXCollapsiblePane
{
	/**
	 * TODO - Description NEEDED!
	 * 
	 */
	public Square200AdPanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints();
		this.setBorder(BorderFactory.createEtchedBorder());
		Dimension size = new Dimension(200, 200);
		this.setPreferredSize(size);
		this.setMinimumSize(size);

		d.fill = GridBagConstraints.BOTH;
		// d.ipady = 0; // reset to default
		// d.ipadx = 0; // reset to default
		// d.anchor = GridBagConstraints.CENTER; // bottom of space
		// d.insets = new Insets(10, 10, 10, 10); // top padding
		// d.gridwidth = 1; // 2 columns wide
		// d.gridheight = 1; // 2 columns wide
		d.gridx = 0;
	}
}
