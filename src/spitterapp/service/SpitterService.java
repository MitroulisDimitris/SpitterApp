package spitterapp.service;

import java.util.List;

import spitterapp.dao.impl.SpitterDaoImpl;
import spitterapp.entities.SpitterEnt;

import java.util.ArrayList;

public class SpitterService {
    private final SpitterDaoImpl spitterDaoImpl;

    public SpitterService(){
        this.spitterDaoImpl = new SpitterDaoImpl();
    }

    public void createSpitter(String firstName, String lastName, String password) {
        SpitterEnt spitterEnt = new SpitterEnt(firstName,lastName,password);
        spitterDaoImpl.save(spitterEnt);
    }

    public SpitterEnt getSpitter(int id){

        return spitterDaoImpl.findById(id);
    }

    public void updateSpitter(SpitterEnt spitter){
        spitterDaoImpl.update(spitter);
    }

    public void deleteSpitter(int id) {
        spitterDaoImpl.delete(id);
    }

    
}

