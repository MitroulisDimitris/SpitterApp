package org.example.spitterapp.service;

import org.example.spitterapp.dao.impl.SpittleDaoImpl;
import org.example.spitterapp.entities.Spitter;
import org.example.spitterapp.entities.Spittle;

public class SplittleService {
    SpittleDaoImpl spittleDaoimpl;

    public SplittleService(){
         spittleDaoimpl = new SpittleDaoImpl();
    }

    public void createSpittle(String content, String datePosted, Spitter authorId){
        Spittle spittle = new Spittle(content,datePosted,authorId);
        spittleDaoimpl.save(spittle);
    }

    public Spittle getSpittle(int id){
        return spittleDaoimpl.finById(id);
    }

    public void UpdateSpitter (Spittle spittle){
       spittleDaoimpl.update(spittle);
    }

    public void deleteSpittle(int id){
        spittleDaoimpl.delete(id);
    }
}
