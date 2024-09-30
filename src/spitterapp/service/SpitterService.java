package spitterapp.service;

import spitterapp.domain.Spitter;
import spitterapp.domain.Spittle;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;

public class SpitterService {
    private List<Spitter> spitters;
    private List<Spittle> spittles;

    public SpitterService(){
        this.spitters = new ArrayList<>();
        this.spittles = new ArrayList<>();
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

    //CRUD operations for Spittle (MESSAGES)
    public void createSpittle(Spittle spittle){
        spittles.add(spittle);
    }
    public Spittle getSpittle(int id){
        return spittles.stream().filter(sp-> sp.getId() == id).findFirst().orElse(null);
    }

    public boolean UpdateSpitter (int id, String text){
        Spittle existing = getSpittle(id);
        if (existing == null){
            return false;
        }
        LocalDateTime timeOfChange = LocalDateTime.now();
        existing.setText(text);
        return true;
    }

    public boolean deleteSpittle(int id){
        return spittles.removeIf(sp -> sp.getId() == id);
    }
}

