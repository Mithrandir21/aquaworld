/**
 * 
 */
package hibTesting;


/**
 * TODO - Description NEEDED!
 *
 * @author Bahram Malaekeh
 * 
 */
import org.hibernate.Session;

import coreObjects.ObjectParameters;
import coreObjects.Fish.FishExclusions;
import coreObjects.Fish.FishObject;
import coreObjects.Fish.FishObject.FishGender;


public class HibMain
{

	public static void main(String[] args)
	{
		try
		{
			createAndPopulateDB();
		}
		catch ( Exception e )
		{
			HibernateUtil.getSessionFactory().close();
			e.printStackTrace();
		}

		HibernateUtil.getSessionFactory().close();
	}



	public static void createAndPopulateDB()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		long start = System.nanoTime();

		double[] sal = { 1.0, 1.0 };
		double[] ph = { 5.6, 8.0 };
		double[] gh = { 1.0, 9.0 };
		double[] temp = { 23, 27.5 };
		double[] kh = { 6.0, 10.0 };
		double[] magnesium = { 300, 4500 };
		double[] calcium = { 1300, 1500 };

		// ---------------------------------------------------
		ObjectParameters parameter = new ObjectParameters(1, sal, ph, gh, temp);
		// ---------------------------------------------------
		parameter.setKh(kh);
		parameter.setMagnesium(magnesium);
		parameter.setCalcium(calcium);
		FishExclusions fishEx = new FishExclusions(2);

		FishObject fish = new FishObject(3, "Gullfiskius", "...Gullfish",
				FishGender.UNISEX, 7.5, parameter, fishEx);
		fish.setGenusName("GullFiskGenus");
		fish.setPopulareName("PopFishName");



		session.save(fish);

		session.getTransaction().commit();

		System.out.println("Ending");
		long elapsedTime = System.nanoTime() - start;
		System.out.println(elapsedTime);
	}
}
