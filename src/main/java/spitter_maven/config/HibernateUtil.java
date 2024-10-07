package spitter_maven.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private final SessionFactory sessionFactory;

    // Constructor
    public HibernateUtil() {
        try {
            this.sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Handle exceptions related to configuration and factory building
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Getter for the SessionFactory
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Utility method to close the SessionFactory when the application stops
    public void shutdown() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException ex) {
                System.err.println("SessionFactory closure failed: " + ex);
            }
        }
    }
}