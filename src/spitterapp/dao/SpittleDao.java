package spitterapp.dao;

import spitterapp.model.Spittle;

import java.sql.Date;
import java.util.List;

public interface SpittleDao {
    Spittle finById(int id);
    List<Spittle> findAll();
    void save(String content, int authorId, String datePosted);
    void update(Spittle spittle);
    void delete(int id);
}
