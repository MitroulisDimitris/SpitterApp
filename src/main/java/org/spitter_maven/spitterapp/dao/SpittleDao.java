package org.spitter_maven.spitterapp.dao;


import org.spitter_maven.spitterapp.entities.Spittle;

import java.util.List;

public interface SpittleDao {
    Spittle finById(int id);
    List<Spittle> findAll();
    void save(Spittle spittle);
    void update(Spittle spittle);
    void delete(int id);
}
