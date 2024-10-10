package spitter_maven.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional
public class SpittleDaoImpl implements SpittleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Spittle finById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Spittle.class,id);

    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Spittle> query = session.createQuery("from Spittle",Spittle.class);
        return query.getResultList();
    }

    @Override
    public void save(Spittle spittle) {
        Session session = sessionFactory.getCurrentSession();
        session.save(spittle);
    }

    @Override
    public void update(Spittle spittle) {
        Session session = sessionFactory.getCurrentSession();
        Spittle existingSpittle = session.get(Spittle.class, spittle.getMessageId());
        if (existingSpittle != null) {
            existingSpittle.setContent(spittle.getContent());
            existingSpittle.setSpitter(spittle.getSpitter());
            existingSpittle.setDatePosted(spittle.getDatePosted());

        } else {
            throw new RuntimeException("Spitter not found for ID: " + spittle.getMessageId());
        }

    }

    @Override
    public void delete(int id) {
       Session session = sessionFactory.getCurrentSession();
       Spittle spittle = session.get(Spittle.class, id);
       if (spittle != null) {
           session.delete(spittle);

       } else {
           throw new RuntimeException("Spittle not found ofr id"+id);
       }
    }

    @Override
    public List<Spittle> findByAuthorId(int authorId) {
        Session session = sessionFactory.getCurrentSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Spittle> query = builder.createQuery(Spittle.class);

        // Define the root (from Spittle entity)
        Root<Spittle> root = query.from(Spittle.class);

        // Add a condition to match the authorId (foreign key reference)
        query.select(root).where(builder.equal(root.get("spitter"), authorId));

        // Execute the query and get the result list
        return session.createQuery(query).getResultList();
    }


}