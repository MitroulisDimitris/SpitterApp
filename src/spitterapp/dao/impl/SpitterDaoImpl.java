package spitterapp.dao.impl;


import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.Query;
import spitterapp.config.HibernateUtil;
import spitterapp.dao.SpitterDao;
import spitterapp.entities.SpitterEnt;

import java.util.List;

public class SpitterDaoImpl implements SpitterDao {

    @Override
    public SpitterEnt findById(int id) {
        Transaction transaction = null;
        SpitterEnt spitter = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            spitter = session.get(SpitterEnt.class,id);
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
    public List<SpitterEnt> findAll() {
        Transaction transaction = null;
        List<SpitterEnt> spitters = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Get all SpitterEnt Entities
            Query<SpitterEnt> query = session.createQuery("from SpitterEnt",SpitterEnt.class);
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
    public void save(SpitterEnt spitter) {
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
    public void update(SpitterEnt spitter) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            SpitterEnt existingSpitter = session.get(SpitterEnt.class, spitter.getUserId());

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
            SpitterEnt spitter = session.get(SpitterEnt.class , id);
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

