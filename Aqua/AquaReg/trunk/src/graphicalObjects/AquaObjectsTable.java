package graphicalObjects;


/**
 * A ScrollPane which "freezes" the specified number of
 * columns of a JTable.
 */
import gui.groups.GroupsFrame;
import gui.listenerClasses.MouseJXtableObjectListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXTable;


public class AquaObjectsTable extends JScrollPane
{
	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param data
	 */
	public AquaObjectsTable(Object[][] data, JXTable table, Dimension dim)
	{
		// JTable nonScrollingColumns = new JTable();
		DefaultTableModel model = new DefaultTableModel(data,
				GroupsFrame.columnNames);
		table.setAutoResizeMode(JXTable.AUTO_RESIZE_OFF);
		// table.setPreferredSize(dim);
		table.setMinimumSize(dim);
		Font f = table.getFont();
		table.setFont(f.deriveFont(Font.BOLD));
		table.setEditable(false);

		table.setModel(model);
		Color gridColor = Color.BLACK;
		int rowHeight = 35;
		// if not on 1.6 comment this out
		table.setFillsViewportHeight(true);

		table.setGridColor(gridColor);

		table.setRowHeight(rowHeight);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.addMouseListener(new MouseJXtableObjectListener());

		this.setViewportView(table);
	}
}
