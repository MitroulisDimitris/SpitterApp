package org.example.spitterapp.service;

import org.example.spitterapp.dao.impl.SpitterDaoImpl;
import org.example.spitterapp.entities.Spitter;

public class SpitterService {
    private final SpitterDaoImpl spitterDaoImpl;

    public SpitterService(){
        this.spitterDaoImpl = new SpitterDaoImpl();
    }

    public void createSpitter(String firstName, String lastName, String password) {
        Spitter spitter = new Spitter(firstName,lastName,password);
        spitterDaoImpl.save(spitter);
    }

    public Spitter getSpitter(int id){
        return spitterDaoImpl.findById(id);
    }

    public void updateSpitter(Spitter spitter){
        spitterDaoImpl.update(spitter);
    }

    public void deleteSpitter(int id) {
        spitterDaoImpl.delete(id);
    }

    
}

