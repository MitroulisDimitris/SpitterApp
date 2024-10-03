package spitterapp.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.id.uuid.StandardRandomStrategy;
import spitterapp.config.HibernateUtil;
import spitterapp.dao.SpittleDao;
import spitterapp.entities.SpittleEnt;

import java.util.ArrayList;
import java.util.List;

public class SpittleDaoImpl implements SpittleDao {
    @Override
    public SpittleEnt finById(int id) {
        SpittleEnt spittleEnt = null;
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            spittleEnt = session.get(SpittleEnt.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback transaction in case of an error
            }
            throw new RuntimeException("Failed to fetch SpittleEnt with id: " + id, e);
        }

        return spittleEnt;  // Return the fetched SpittleEnt entity

    }

    @Override
    public List findAll() {
        Transaction transaction = null;
        List spittleEnts = new ArrayList<>();
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            //Get all spittles
            spittleEnts = session.createQuery("from SpittleEnt").getResultList();

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
    public void save(SpittleEnt spittle) {
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
    public void update(SpittleEnt spittle) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            SpittleEnt existingSpittle = session.get(SpittleEnt.class, spittle.getMessageId());

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
            SpittleEnt spittle = session.get(SpittleEnt.class , id);
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