package spitterapp.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import spitterapp.config.HibernateUtil;
import spitterapp.dao.SpittleDao;
import spitterapp.entities.Spittle;

import java.util.ArrayList;
import java.util.List;

public class SpittleDaoImpl implements SpittleDao {
    @Override
    public Spittle finById(int id) {
        Spittle spittle = null;
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            spittle = session.get(Spittle.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback transaction in case of an error
            }
            throw new RuntimeException("Failed to fetch SpittleEnt with id: " + id, e);
        }

        return spittle;  // Return the fetched SpittleEnt entity

    }

    @Override
    public List findAll() {
        Transaction transaction = null;
        List spittleEnts = new ArrayList<>();
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            //Get all spittles
            spittleEnts = session.createQuery("from Spittle").getResultList();

            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                throw new RuntimeException(String.valueOf(e));
            }

        }
        return spittleEnts;
    }

    @Override
    public void save(Spittle spittle) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(spittle);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback the transaction in case of error
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Spittle spittle) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Spittle existingSpittle = session.get(Spittle.class, spittle.getMessageId());

            if (existingSpittle != null){
                existingSpittle.setContent(spittle.getContent());
                existingSpittle.setAutorId(spittle.getAutorId());
                existingSpittle.setDatePosted(spittle.getDatePosted());
            } else {
                throw new RuntimeException();
            }
            transaction.commit();
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Spittle spittle = session.get(Spittle.class , id);
            if(spittle != null){
                session.delete(spittle);

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