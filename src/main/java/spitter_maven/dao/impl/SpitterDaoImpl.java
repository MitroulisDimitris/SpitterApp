package spitter_maven.dao.impl;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spitter_maven.config.HibernateUtil;
import spitter_maven.dao.SpitterDao;
import spitter_maven.entities.Spitter;

import java.util.List;

@Repository
@Transactional
public class SpitterDaoImpl implements SpitterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Spitter findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Spitter.class, id);
    }

    @Override
    public List<Spitter> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Spitter> query = session.createQuery("from Spitter", Spitter.class);
        return query.getResultList();
    }

    @Override
    public void save(Spitter spitter) {
        Session session = sessionFactory.getCurrentSession();
        session.save(spitter);
    }

    @Override
    public void update(Spitter spitter) {
        Session session = sessionFactory.getCurrentSession();
        Spitter existingSpitter = session.get(Spitter.class, spitter.getUserId());

        if (existingSpitter != null) {
            existingSpitter.setFirstName(spitter.getFirstName());
            existingSpitter.setLastName(spitter.getLastName());
            existingSpitter.setPassword(spitter.getPassword());
        } else {
            throw new RuntimeException("Spitter not found for ID: " + spitter.getUserId());
        }
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Spitter spitter = session.get(Spitter.class, id);

        if (spitter != null) {
            session.delete(spitter);
        } else {
            throw new RuntimeException("Spitter not found for ID: " + id);
        }
    }
}

