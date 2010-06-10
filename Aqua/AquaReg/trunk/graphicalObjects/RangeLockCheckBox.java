package graphicalObjects;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class RangeLockCheckBox extends JCheckBox
{
	/**
	 * The low {@link JTextField}.
	 */
	private JTextField low;
	
	/**
	 * The high {@link JTextField}.
	 */
	private JTextField high;
	
	
	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param low
	 * @param high
	 */
	public RangeLockCheckBox(JTextField low, JTextField high)
	{
		super("Lock");
		this.low = low;
		this.high = high;
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the low
	 */
	public JTextField getLowJTextField()
	{
		return low;
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the high
	 */
	public JTextField getHighJTextField()
	{
		return high;
	}
}
