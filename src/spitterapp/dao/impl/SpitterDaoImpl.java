package spitterapp.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.Query;
import spitterapp.config.HibernateUtil;
import spitterapp.dao.SpitterDao;
import spitterapp.entities.Spitter;

import java.util.List;

public class SpitterDaoImpl implements SpitterDao {

    @Override
    public Spitter findById(int id) {
        Transaction transaction = null;
        Spitter spitter = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            spitter = session.get(Spitter.class,id);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback the transaction in case of failure
            }
            throw new RuntimeException(String.valueOf(e));
        }
        return spitter;
    }

    @Override
    public List<Spitter> findAll() {
        Transaction transaction = null;
        List<Spitter> spitters = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Get all SpitterEnt Entities
            Query<Spitter> query = session.createQuery("from Spitter", Spitter.class);
            spitters = query.getResultList();

            transaction.commit();

        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(String.valueOf(e));
        }

        return spitters;
    }

    @Override
    public void save(Spitter spitter) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(spitter);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback the transaction in case of error
            }
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Spitter spitter) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Spitter existingSpitter = session.get(Spitter.class, spitter.getUserId());

            if (existingSpitter != null){
                existingSpitter.setFirstName(spitter.getFirstName());
                existingSpitter.setLastName(spitter.getLastName());
                existingSpitter.setPassword(spitter.getPassword());
            } else {
                throw new RuntimeException();

            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback in case of error
            }
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;

        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Spitter spitter = session.get(Spitter.class , id);
            if(spitter != null){
                session.delete(spitter);

            }else{
                throw new RuntimeException();
            }
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback in case of error
            }
            throw new RuntimeException(e);
        }
    }
}

