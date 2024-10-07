package spitter_maven.service;

import spitter_maven.dao.impl.SpittleDaoImpl;
import spitter_maven.entities.Spitter;
import spitter_maven.entities.Spittle;

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
