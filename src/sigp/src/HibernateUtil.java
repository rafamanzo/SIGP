package sigp.src;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static{
			try{
					sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			catch (Throwable ext) {
				System.err.println("Initial SessionFactory creation failed." + ext);
				throw new ExceptionInInitializerError(ext);
			}
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
