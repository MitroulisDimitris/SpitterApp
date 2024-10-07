package spitter_maven.dao;

import spitter_maven.entities.Spitter;

import java.util.List;

public interface SpitterDao {
    Spitter findById(int id);
    List<Spitter> findAll();
    void save(Spitter spitter);
    void update(Spitter spitter);
    void delete(int id);
}
