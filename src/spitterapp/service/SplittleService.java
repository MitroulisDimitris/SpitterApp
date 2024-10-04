package spitterapp.service;

import spitterapp.dao.impl.SpittleDaoImpl;
import spitterapp.entities.Spitter;
import spitterapp.entities.Spittle;


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
