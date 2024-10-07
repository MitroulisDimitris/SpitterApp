package org.spitter_maven.spitterapp.dao;

import org.spitter_maven.spitterapp.entities.Spitter;

import java.util.List;

public interface SpitterDao {
    Spitter findById(int id);
    List<Spitter> findAll();
    void save(Spitter spitter);
    void update(Spitter spitter);
    void delete(int id);
}
