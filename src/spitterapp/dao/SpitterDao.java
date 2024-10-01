package spitterapp.dao;
import spitterapp.model.Spitter;
import java.util.List;

public interface SpitterDao {
    Spitter findById(int id);
    List<Spitter> findAll();
    void save(String firstName, String lastName, String password);
    void update(Spitter spitter);
    void delete(int id);
}
