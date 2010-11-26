import org.hibernate.Session;


/**
 * 
 */

/**
 * TODO - Description NEEDED!
 * 
 * @author Bahram Malaekeh
 * 
 */
public class HibTest
{

	/**
	 * TODO - Description
	 * 
	 */
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// session.beginTransaction();

		// Event theEvent = new Event();
		// theEvent.setTitle(title);
		// theEvent.setDate(theDate);
		// session.save(theEvent);
		//
		// session.getTransaction().commit();

		HibernateUtil.getSessionFactory().close();

		System.out.println("end");
	}

}
