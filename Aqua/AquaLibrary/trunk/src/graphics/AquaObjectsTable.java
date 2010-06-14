package graphics;


/**
 * A ScrollPane which "freezes" the specified number of
 * columns of a JTable.
 */
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;


public class AquaObjectsTable extends JScrollPane
{
	/**
	 * TODO - Description NEEDED!
	 * 
	 * @param data
	 */
	public AquaObjectsTable(Object[][] data)
	{
		/**
		 * sample data column names
		 */
		String[] columnNames = { "Latin Name", "Salinity", "PH", "GH",
				"Temperature", "KH", "Magnesium", "Calcium", "Space Needed",
				"Others Sizes" };


		JTable table = new JTable();
		JTable nonScrollingColumns = new JTable();

		Color gridColor = Color.BLACK;
		int rowHeight = 25;
		// int rowMargin = 23;

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		// if not on 1.6 comment this out
		table.setFillsViewportHeight(true);

		table.setGridColor(gridColor);
		nonScrollingColumns.setGridColor(gridColor);

		table.setRowHeight(rowHeight);
		nonScrollingColumns.setRowHeight(rowHeight);

		// table.setRowMargin(rowMargin);
		// nonScrollingColumns.setRowMargin(rowMargin);

		// table.setShowGrid(false);
		// nonScrollingColumns.setShowGrid(false);
		//		
		// table.setShowHorizontalLines(false);
		// nonScrollingColumns.setShowHorizontalLines(false);
		//		
		// table.setShowVerticalLines(false);
		// nonScrollingColumns.setShowVerticalLines(false);

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// nonScrollingColumns.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		// table.setAutoCreateRowSorter(true);
		// nonScrollingColumns.setAutoCreateRowSorter(true);



		nonScrollingColumns.setAutoCreateColumnsFromModel(false);
		nonScrollingColumns.setModel(model);
		nonScrollingColumns.setSelectionModel(table.getSelectionModel());
		nonScrollingColumns.setFillsViewportHeight(true);

		JTableHeader nonScrollingHeader = nonScrollingColumns.getTableHeader();
		nonScrollingHeader.setResizingAllowed(false);
		nonScrollingHeader.setReorderingAllowed(false);

		TableColumn firstColumn = table.getColumn("Latin Name");
		firstColumn.setPreferredWidth(100);
		table.removeColumn(firstColumn);

		nonScrollingColumns.addColumn(firstColumn);
		nonScrollingColumns
				.setPreferredScrollableViewportSize(nonScrollingColumns
						.getPreferredSize());

		this.setViewportView(table);
		this.setRowHeaderView(nonScrollingColumns);
		this.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER,
				nonScrollingHeader);
	}
}
