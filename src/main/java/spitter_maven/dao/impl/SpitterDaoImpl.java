package spitter_maven.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spitter_maven.config.HibernateUtil;
import spitter_maven.dao.SpitterDao;
import spitter_maven.entities.Spitter;

import java.util.List;

@Repository
public class SpitterDaoImpl implements SpitterDao {

    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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

