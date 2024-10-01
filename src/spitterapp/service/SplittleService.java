package spitterapp.service;

import java.util.List;

import spitterapp.model.Spittle;

import java.util.ArrayList;


public class SplittleService {
    private List<Spittle> spittles;


    public SplittleService(){
        this.spittles = new ArrayList<>();
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
        existing.setText(text);
        return true;
    }

    public boolean deleteSpittle(int id){
        return spittles.removeIf(sp -> sp.getId() == id);
        
    }
}
