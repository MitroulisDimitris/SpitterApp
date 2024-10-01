package spitterapp.dao.impl;


import java.sql.Connection;

import spitterapp.config.DatabaseConfig;
import spitterapp.dao.SpitterDao;
import spitterapp.model.Spitter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpitterDaoImpl implements SpitterDao {


    @Override
    public Spitter findById(int id) {
        Connection conn = null;
        Spitter spitter= null;
        String query = "Select * from USERS where userId=?";

        try {

            conn = DatabaseConfig.getConnection();
            conn.setAutoCommit(false);
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
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();  // Rollback in case of an error
            } catch (SQLException ex) {
                throw new RuntimeException("Rollback failed", ex);
            }
            throw new RuntimeException(e);
        } finally {
            DatabaseConfig.closeConnection(conn);
        }
        return spitter;
    }

    @Override
    public List<Spitter> findAll() {
        List<Spitter> spitters = new ArrayList<>();

        Connection conn = DatabaseConfig.getConnection();
        String query = "Select * from USERS";

        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                spitters.add(new Spitter(
                        rs.getInt("userId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("password")));

            }
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();  // Rollback in case of an error
            } catch (SQLException ex) {
                throw new RuntimeException("Rollback failed", ex);
            }
            throw new RuntimeException(e);
        } finally {
            DatabaseConfig.closeConnection(conn);
        }
        return spitters;
    }

    @Override
    public void save(String firstName, String lastName, String password) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "INSERT INTO USERS (firstName, lastname, password) VALUES (?, ?, ?)";
        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,password);
            ps.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();  // Rollback in case of an error
            } catch (SQLException ex) {
                throw new RuntimeException("Rollback failed", ex);
            }
            throw new RuntimeException(e);
        } finally {
            DatabaseConfig.closeConnection(conn);
        }
    }

    @Override
    public void update(Spitter spitter) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "UPDATE USERS SET firstName=?, lastName=?, password=? WHERE userId=?";

        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, spitter.getFisrtName());
            ps.setString(2, spitter.getLastName());
            ps.setString(3, spitter.getPassword());
            ps.setInt(4, spitter.getId());

            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();  // Rollback in case of an error
            } catch (SQLException ex) {
                throw new RuntimeException("Rollback failed", ex);
            }
            throw new RuntimeException(e);
        } finally {
            DatabaseConfig.closeConnection(conn);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "DELETE FROM USERS WHERE userId=?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.commit();  // Commit the transaction

        } catch (SQLException e) {
            try {
                conn.rollback();  // Rollback in case of an error
            } catch (SQLException ex) {
                throw new RuntimeException("Rollback failed", ex);
            }
            throw new RuntimeException(e);
        } finally {
            DatabaseConfig.closeConnection(conn);
        }
    }
}

