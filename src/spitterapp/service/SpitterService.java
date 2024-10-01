package spitterapp.service;

import java.util.List;

import spitterapp.model.Spitter;

import java.util.ArrayList;

public class SpitterService {
    private List<Spitter> spitters;
    
    public SpitterService(){
        this.spitters = new ArrayList<>();
    }
    // CRUD for spitter (USER)
    public void createSpitter(Spitter spitter){
        spitters.add(spitter);
    }

    public Spitter getSpitter(int id){
        return spitters.stream().filter(sp -> sp.getId() == id).findFirst().orElse(null);
    }

    public boolean updateSpitter(Spitter spitter){
        Spitter existing = getSpitter(spitter.getId());
        if (existing != null){
            existing = spitter;
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteSpitter(int id) {
    return  spitters.removeIf(sp -> sp.getId() == id);
    }

    
}

