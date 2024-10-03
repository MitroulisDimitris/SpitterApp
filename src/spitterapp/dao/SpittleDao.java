package spitterapp.dao;

import spitterapp.entities.SpittleEnt;
import spitterapp.entities.SpittleEnt;

import java.sql.Date;
import java.util.List;

public interface SpittleDao {
    SpittleEnt finById(int id);
    List<SpittleEnt> findAll();
    void save(SpittleEnt spittle);
    void update(SpittleEnt spittle);
    void delete(int id);
}
