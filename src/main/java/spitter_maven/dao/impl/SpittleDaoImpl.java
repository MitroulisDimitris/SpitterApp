package spitter_maven.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spitter_maven.config.HibernateUtil;
import spitter_maven.dao.SpittleDao;
import spitter_maven.entities.Spittle;

import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SpittleDaoImpl implements SpittleDao {
    @Override
    @Transactional
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
    @Transactional
    public List findAll() {
        Transaction transaction = null;
        List spittleEnts = new ArrayList<>();
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            //Get all spittles
            spittleEnts = session.createQuery("from Spittle").getResultList();

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                throw new RuntimeException(String.valueOf(e));
            }

        }
        return spittleEnts;
    }

    @Override
    @Transactional
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
    @Transactional
    public void update(Spittle spittle) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Spittle existingSpittle = session.get(Spittle.class, spittle.getMessageId());

            if (existingSpittle != null) {
                existingSpittle.setContent(spittle.getContent());
                existingSpittle.setSpitter(spittle.getSpitter());
                existingSpittle.setDatePosted(spittle.getDatePosted());
            } else {
                throw new RuntimeException();
            }
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Spittle spittle = session.get(Spittle.class, id);
            if (spittle != null) {
                session.delete(spittle);

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

    @Transactional
    public List<Spittle> findByAuthorId(int authorId) {
        Transaction transaction = null;
        List<Spittle> spittles = null;
        HibernateUtil hibernateUtil = new HibernateUtil();

        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Create CriteriaBuilder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            // Create CriteriaQuery
            CriteriaQuery<Spittle> query = builder.createQuery(Spittle.class);

            // Define the root (from Spittle entity)
            Root<Spittle> root = query.from(Spittle.class);

            // Add a condition to match the authorId
            query.select(root).where(builder.equal(root.get("spitter"), authorId));

            // Execute the query and get the result list
            spittles = session.createQuery(query).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback transaction in case of an error
            }
            throw new RuntimeException("Failed to fetch spittles for authorId: " + authorId, e);
        }

        return spittles;  // Return the list of Spittle entities
    }


}