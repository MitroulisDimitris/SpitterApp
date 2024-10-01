package spitterapp.service;

import spitterapp.dao.impl.SpittleDaoImpl;
import spitterapp.model.Spittle;


public class SplittleService {
    SpittleDaoImpl spittleDaoimpl;

    public SplittleService(){
         spittleDaoimpl = new SpittleDaoImpl();
    }

    public void createSpittle(Spittle spittle){
        spittleDaoimpl.save(spittle.getText(), spittle.getAuthorId(),
               spittle.getSentDate());
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
