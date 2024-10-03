package spitterapp.service;

import spitterapp.dao.impl.SpittleDaoImpl;
import spitterapp.entities.SpittleEnt;


public class SplittleService {
    SpittleDaoImpl spittleDaoimpl;

    public SplittleService(){
         spittleDaoimpl = new SpittleDaoImpl();
    }

    public void createSpittle(SpittleEnt spittle){
        //spittleDaoimpl.save(spittle.getText(), spittle.getAuthorId(),
        //       spittle.getSentDate());
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
