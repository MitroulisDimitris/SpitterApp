package spitter_maven.dao;


import spitter_maven.entities.Spittle;

import java.util.List;

public interface SpittleDao {
    Spittle finById(int id);
    List<Spittle> findAll();
    void save(Spittle spittle);
    void update(Spittle spittle);
    void delete(int id);
    List<Spittle> findByAuthorId(int authorId);
}
