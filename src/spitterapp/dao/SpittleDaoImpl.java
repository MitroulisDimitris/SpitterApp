package spitterapp.dao;

import spitterapp.config.DatabaseConfig;
import spitterapp.model.Spittle;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class SpittleDaoImpl implements SpittleDao {
    @Override
    public Spittle finById(int id) {
        Connection conn = DatabaseConfig.getConnection();
        Spittle spittle = null;
        String query = "SELECT * FROM MESSAGES WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                spittle = new Spittle(
                        id,
                        rs.getString("content"),
                        rs.getInt("authorId"),
                        // def not optimal
                        rs.getDate("datePosted").toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return spittle;
    }

    @Override
    public List<Spittle> findAll() {
        List<Spittle> spittles = new ArrayList<>();
        Connection conn = DatabaseConfig.getConnection();
        String query = "SELECT * FROM MESSAGES";

        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                spittles.add( new Spittle(
                        rs.getInt("messageId"),
                        rs.getString("content"),
                        rs.getInt("authorId"),
                        // def not optimal
                        rs.getDate("datePosted").toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDateTime()));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatabaseConfig.closeConnection(conn);
        return spittles;
    }

    @Override
    public void save(String content, int authorId, Date datePosted) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "INSERT INTO MESSAGES (content, authorId, datePosted) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,content);
            ps.setInt(2,authorId);
            ps.setDate(3,datePosted);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        DatabaseConfig.closeConnection(conn);
    }

    @Override
    public void update(Spittle spittle) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "UPDATE USERS SET content=?, authorId=?, datePosted=? WHERE messageId=?";

        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, spittle.getText());
            ps.setInt(2, spittle.getAuthorId());
            ps.setDate(3, (Date) Date.from(spittle.getSentDate().atZone(ZoneId.systemDefault()).toInstant()));
            ps.setInt(4, spittle.getId());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        DatabaseConfig.closeConnection(conn);
    }

    @Override
    public void delete(int id) {
        Connection conn = DatabaseConfig.getConnection();
        String query = "DELETE FROM MESSAGES WHERE messageId=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        DatabaseConfig.closeConnection(conn);
    }
}
