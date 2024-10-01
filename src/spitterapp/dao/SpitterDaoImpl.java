package spitterapp.dao;


import java.sql.Connection;

import spitterapp.config.DatabaseConfig;
import spitterapp.model.Spitter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpitterDaoImpl implements SpitterDao{


    @Override
    public Spitter findById(int id) {
        Connection conn = DatabaseConfig.getConnection();
        Spitter spitter = null;
        String query = "Select * from USERS where userId=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                spitter = new Spitter(
                        rs.getInt("userId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return spitter;
    }

    @Override
    public List<Spitter> findAll() {
        List<Spitter> spitters = new ArrayList<>();

        Connection conn = DatabaseConfig.getConnection();
        String query = "Select * from USERS";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                spitters.add(new Spitter(
                        rs.getInt("userId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("password")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return spitters;

    }

    @Override
    public void save(String firstName, String lastName, String password) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "INSERT INTO USERS (firstName, lastname, password) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,password);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Spitter spitter) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "UPDATE USERS SET firstName=?, lastName=?, password=? WHERE userId=?";

        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, spitter.getFisrtName());
            ps.setString(2, spitter.getLastName());
            ps.setString(3, spitter.getPassword());
            ps.setInt(4, spitter.getId());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "DELETE FROM USERS WHERE userId=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

