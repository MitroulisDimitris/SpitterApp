package spitterapp.service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import spitterapp.dao.SpitterDaoImpl;
import spitterapp.dao.SpittleDaoImpl;
import spitterapp.model.Spittle;

import java.util.ArrayList;


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
