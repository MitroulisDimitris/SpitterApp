package spitterapp.dao;
import spitterapp.model.Spitter;
import java.util.List;

public interface SpitterDao {
    Spitter findById(int id);
    List<Spitter> findAll();
    void save(Spitter spitter);
    void update(Spitter spitter);
    void delete(int id);
}
