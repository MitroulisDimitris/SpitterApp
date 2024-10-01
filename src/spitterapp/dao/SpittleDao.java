package spitterapp.dao;

import spitterapp.model.Spittle;
import java.util.List;

public interface SpittleDao {
    Spittle finById(int id);
    List<Spittle> findAll();
    void save(Spittle spittle);
    void update(Spittle spittle);
    void delete(Spittle spittle);
}
