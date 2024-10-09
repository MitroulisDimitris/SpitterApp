package spitter_maven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spitter_maven.dao.impl.SpittleDaoImpl;
import spitter_maven.entities.Spitter;
import spitter_maven.entities.Spittle;

import java.util.List;

@Service
public class SplittleService {

    @Autowired
    private SpittleDaoImpl spittleDaoimpl;

    public SplittleService(){
         spittleDaoimpl = new SpittleDaoImpl();
    }

    @Transactional
    public void createSpittle(String content, String datePosted, Spitter authorId){
        Spittle spittle = new Spittle(content,datePosted,authorId);
        spittleDaoimpl.save(spittle);
    }
    @Transactional
    public Spittle getSpittle(int id){
        return spittleDaoimpl.finById(id);
    }

    @Transactional
    public void UpdateSpitter (Spittle spittle){
       spittleDaoimpl.update(spittle);
    }

    @Transactional
    public void deleteSpittle(int id){
        spittleDaoimpl.delete(id);
    }

    @Transactional
    public List<Spittle> findSpittlesByAuthorId(int authorId){
        return spittleDaoimpl.findByAuthorId(authorId);
    }
}
