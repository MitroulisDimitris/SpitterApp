package spitterapp.dao.impl;

import spitterapp.dao.SpittleDao;
import spitterapp.entities.SpittleEnt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpittleDaoImpl implements SpittleDao {
    @Override
    public SpittleEnt finById(int id) {
        return null;
    }

    @Override
    public List<SpittleEnt> findAll() {

        return null;
    }

    @Override
    public void save(String content, int authorId, String datePosted) {

    }

    @Override
    public void update(SpittleEnt spittle) {

    }

    @Override
    public void delete(int id) {
    }
}