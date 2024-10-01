package spitterapp.service;

import java.util.List;

import spitterapp.dao.impl.SpitterDaoImpl;
import spitterapp.model.Spitter;

import java.util.ArrayList;

public class SpitterService {
    private List<Spitter> spitters;
    private final SpitterDaoImpl spitterDaoImpl;

    public SpitterService(){
        this.spitters = new ArrayList<>();
        this.spitterDaoImpl = new SpitterDaoImpl();
    }

    public void createSpitter(Spitter spitter){
        spitterDaoImpl.save(spitter.getFisrtName(),spitter.getLastName(),spitter.getPassword());

        spitters.add(spitter);
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

