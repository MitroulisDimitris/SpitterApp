package spitterapp.dao.impl;

import spitterapp.config.DatabaseConfig;
import spitterapp.dao.SpittleDao;
import spitterapp.model.Spittle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpittleDaoImpl implements SpittleDao {
    @Override
    public Spittle finById(int id) {
        Connection conn = DatabaseConfig.getConnection();
        Spittle spittle = null;
        String query = "SELECT * FROM MESSAGES WHERE id = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                spittle = new Spittle(
                        id,
                        rs.getString("content"),
                        rs.getInt("authorId"),
                        rs.getString("datePosted"));
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
        return spittle;
    }

    @Override
    public List<Spittle> findAll() {
        List<Spittle> spittles = new ArrayList<>();
        Connection conn = DatabaseConfig.getConnection();
        String query = "SELECT * FROM MESSAGES";

        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                spittles.add( new Spittle(
                        rs.getInt("messageId"),
                        rs.getString("content"),
                        rs.getInt("authorId"),
                        rs.getString("datePosted")));
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
        return spittles;
    }

    @Override
    public void save(String content, int authorId, String datePosted) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "INSERT INTO MESSAGES (content, authorId, datePosted) VALUES (?, ?, ?)";
        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,content);
            ps.setInt(2,authorId);
            ps.setString(3,datePosted);
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

    @Override
    public void update(Spittle spittle) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "UPDATE USERS SET content=?, authorId=?, datePosted=? WHERE messageId=?";

        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, spittle.getText());
            ps.setInt(2, spittle.getAuthorId());
            ps.setString(3, spittle.getSentDate());
            ps.setInt(4, spittle.getId());

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
        String query = "DELETE FROM MESSAGES WHERE messageId=?";
        try{
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