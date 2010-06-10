package graphicalObjects;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class LockCheckBox extends JCheckBox
{
	/**
	 * The field {@link JTextField}.
	 */
	private JTextField field;



	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param field
	 */
	public LockCheckBox(JTextField field)
	{
		super("Lock");
		this.field = field;
	}



	// GETTERS

	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the field
	 */
	public JTextField getJTextField()
	{
		return field;
	}

}
