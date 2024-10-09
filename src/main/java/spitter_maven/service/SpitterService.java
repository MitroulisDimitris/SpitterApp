package spitter_maven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spitter_maven.dao.SpitterDao;
import spitter_maven.dao.impl.SpitterDaoImpl;
import spitter_maven.entities.Spitter;

import java.util.List;

@Service
public class SpitterService {

    @Autowired
    private SpitterDao spitterDaoImpl;

    public SpitterService(){
        this.spitterDaoImpl = new SpitterDaoImpl();
    }

    @Transactional
    public void createSpitter(String firstName, String lastName, String password) {
        Spitter spitter = new Spitter(firstName,lastName,password);
        spitterDaoImpl.save(spitter);
    }

    @Transactional
    public Spitter getSpitter(int id){
        return spitterDaoImpl.findById(id);
    }

    @Transactional
    public void updateSpitter(Spitter spitter){
        spitterDaoImpl.update(spitter);
    }

    @Transactional
    public void deleteSpitter(int id) {
        spitterDaoImpl.delete(id);
    }

    @Transactional
    public List<Spitter> getAllSpitters(){
        return spitterDaoImpl.findAll();
    }
    
}

