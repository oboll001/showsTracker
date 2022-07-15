package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManagerwithProps;
import com.cognixia.jump.exception.PWLimitException;
import com.cognixia.jump.model.ShowsWatched;

// shows watched dao
public class SWDAO implements DAO<ShowsWatched> {

    private Connection conn = ConnectionManagerwithProps.getConnection();

    @Override
    public ShowsWatched findbyId(long user_id) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "";
        ShowsWatched sw = null;

        try {

            query = "select * from shows_watched where user_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setLong(1, user_id);

            rs = pstmt.executeQuery();

            if (rs != null) {
                rs.next();
                sw = new ShowsWatched(0, query, 0);
                sw.setUserId(rs.getInt(1));
                sw.setShow_name(rs.getString(2));
                sw.setEpisodes_watched(rs.getInt(3));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return sw;
    }

    @Override
    public List<ShowsWatched> findAll(long user_id) {

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shows.shows_watched where user_id = " + user_id);

            List<ShowsWatched> showList = new ArrayList<ShowsWatched>();

            // rs.first();

            while (rs.next()) {
                // ...iterate through to get column info...
                int id = rs.getInt("user_id");
                String show_name = rs.getString("show_name");
                int episodes_watched = rs.getInt("episodes_watched");

                // ...then add them to a list...
                ShowsWatched show = new ShowsWatched(id, show_name, episodes_watched);
                showList.add(show);
            }

            // ...and return that list once finished
            return showList;

        } catch (SQLException e) {
            System.out.println("Could not retrieve list of shows from database");
        }

        return null;
    }

    @Override
    public boolean create(ShowsWatched entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(ShowsWatched entity) {
        try {
            String query = "UPDATE shows_watched SET episodes_watched = ? where show_name =";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, entity.getUserId());
            pstmt.setString(2, entity.getShow_name());
            pstmt.setInt(3, entity.getEpisodes_watched());

            int numUpdates = pstmt.executeUpdate();

            if (numUpdates > 0) {
                System.out.println("Entity " + entity + " updated in db.");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
