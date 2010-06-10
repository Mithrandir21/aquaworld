package graphics.GUI.messageArea.messageTabs;


import coreObjects.Aquarium.Containers.ContentContainer;


/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 */
public class MessageProcessing
{
	public static String[][] processFishAndAnimalData(ContentContainer content)
	{
		String[][] data = new String[8][4];

		for ( int i = 0; i < 8; i++ )
		{
			for ( int j = 0; j < 4; j++ )
			{
				data[i][j] = j + "";
			}
		}

		return data;
	}



	public static String[][] processAquariumAndEquipmentData(
			ContentContainer content)
	{
		String[][] data = new String[8][4];

		for ( int i = 0; i < 8; i++ )
		{
			for ( int j = 0; j < 4; j++ )
			{
				String text = j + 200 + "";
				data[i][j] = text;
			}
		}

		return data;
	}
}
