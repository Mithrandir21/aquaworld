package gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import coreObjects.AbstractObject;


public class CustomAquaObjectListRenderer extends JPanel implements
		ListCellRenderer
{
	/*
	 * (non-Javadoc)
	 * @see
	 * javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing
	 * .JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus)
	{
		if ( isSelected )
		{
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}
		else
		{
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}


		AbstractObject object = (AbstractObject) value;

		JLabel label = new JLabel("|" + object.getGenusName() + " - "
				+ object.getSpeciesName() + "|");


		this.add(label);
		// this.setMaximumSize(new Dimension(100, 30));
		// this.setMinimumSize(new Dimension(100, 30));
		// this.setPreferredSize(new Dimension(100, 30));

		// this.add(new JLabel("Tess"));


		return this;
	}

}
