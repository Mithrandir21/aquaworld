package graphics.GUI.messageArea.messageTabs;


import graphics.AquaWorld;
import graphics.GUI.messageArea.MessageInterface;
import graphics.GUI.messageArea.MessageJTable;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import logistical.cleanup;
import coreObjects.Aquarium.Aquarium;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class FishAnimalsMessage extends JPanel implements MessageInterface
{
	private JScrollPane content;


	/**
	 * TODO - Description NEEDED!
	 *
	 */
	public FishAnimalsMessage()
	{
		content = new JScrollPane();
		
		this.setLayout(new GridLayout());
		this.setEnabled(false);
	}


	/**
	 * TODO - Description NEEDED!
	 */
	public FishAnimalsMessage(Aquarium aqua)
	{
		processInfo(aqua);

		this.setLayout(new GridLayout());
		this.setEnabled(false);
	}


	@Override
	public void createMessageTab(String[][] data)
	{
		this.removeAll();

		content = new JScrollPane();

		String[] columnNames = {
				AquaWorld.texts.getString("msgFishAndAnimalName"),
				AquaWorld.texts.getString("masFishAndAnimalText1"),
				AquaWorld.texts.getString("masFishAndAnimalText2"),
				AquaWorld.texts.getString("masFishAndAnimalText3") };


		MessageJTable table = new MessageJTable(data, columnNames);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		setColumnWidths(table);

		// table.setPreferredScrollableViewportSize(new Dimension(700,300));
		table.setFillsViewportHeight(false);

		content.setViewportView(table);

		this.add(content);
	}

	@Override
	public void removeThisTab()
	{
		AquaWorld.getMessageArea().removeTab(this.getClass());
	}

	@Override
	public void processInfo(Aquarium aqua)
	{
		String[][] data = null;
		
		// Gets the information from the processing
		data = MessageProcessing.processFishAndAnimalData(aqua.getContent());

		if ( data != null )
		{
			if ( data[0][0] != null )
			{
				// Cleans up the array
				data = cleanup.cleanObjectArray(data);

				// Creates the JScrollPane that is places inside this panel with
				// the data
				createMessageTab(data);

				// Changes the text in the
				AquaWorld.getMessageArea().boldTab(this.getClass());
			}
			else
			{
				this.removeAll();

				AquaWorld.getMessageArea().unboldTab(this.getClass());
			}
		}
		else
		{
			this.removeAll();

			AquaWorld.getMessageArea().unboldTab(this.getClass());
		}
	}


	/**
	 * TODO - Description NEEDED!
	 * 
	 * @return the content
	 */
	public JScrollPane getContent()
	{
		return content;
	}


	/*
	 * (non-Javadoc)
	 * @see graphics.GUI.messageArea.MessageInterface#getMessageClass()
	 */
	@Override
	public Class<?> getMessageClass()
	{
		return this.getClass();
	}



	/**
	 * Sets the width of the column that contains the actual message
	 * information.
	 */
	private void setColumnWidths(MessageJTable table)
	{
		TableColumn column = null;
		for ( int i = 0; i < 4; i++ )
		{
			column = table.getColumnModel().getColumn(i);
			if ( i == 2 )
			{
				column.setPreferredWidth(700); // third column is bigger
			}
			else
			{
				column.setPreferredWidth(150);
			}
		}
	}
}
