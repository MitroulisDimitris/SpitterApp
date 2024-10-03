package spitterapp.service;

import spitterapp.dao.impl.SpittleDaoImpl;
import spitterapp.entities.SpitterEnt;
import spitterapp.entities.SpittleEnt;


public class SplittleService {
    SpittleDaoImpl spittleDaoimpl;

    public SplittleService(){
         spittleDaoimpl = new SpittleDaoImpl();
    }

    public void createSpittle(String content, String datePosted, SpitterEnt authorId){
        SpittleEnt spittle = new SpittleEnt(content,datePosted,authorId);
        spittleDaoimpl.save(spittle);
    }

    public SpittleEnt getSpittle(int id){
        return spittleDaoimpl.finById(id);
    }

    public void UpdateSpitter (SpittleEnt spittle){
       spittleDaoimpl.update(spittle);
    }

    public void deleteSpittle(int id){
        spittleDaoimpl.delete(id);
    }
}
