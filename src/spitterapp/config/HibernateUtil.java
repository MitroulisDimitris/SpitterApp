package spitterapp.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private final SessionFactory sessionFactory;

    public HibernateUtil() {
        try {
            // Initialize the sessionFactory instance
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Getter for the SessionFactory
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Utility method to close the SessionFactory when the application stops
    public void shutdown() {
        try {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
