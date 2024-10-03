package spitterapp.dao;
import spitterapp.entities.SpitterEnt;
import java.util.List;

public interface SpitterDao {
    SpitterEnt findById(int id);
    List<SpitterEnt> findAll();
    void save(SpitterEnt spitter);
    void update(SpitterEnt spitter);
    void delete(int id);
}
