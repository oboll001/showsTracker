package com.cognixia.jump.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    public List<ShowsWatched> findAll() {

        List<ShowsWatched> showswatched = new ArrayList<ShowsWatched>();


        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shows.shows_watched");

            List<ShowsWatched> showList = new ArrayList<ShowsWatched>();

            // rs.first();

            while (rs.next()) {
                // iterate to get column info
                int id = rs.getInt("user_id");
                String show_name = rs.getString("show_name");
                int episodes_watched = rs.getInt("episodes_watched");

                // add them to a list...
                ShowsWatched show = new ShowsWatched(id, show_name, episodes_watched);
                showList.add(show);
            }

            // return that list once finished
            return showList;

        } catch (SQLException e) {
            System.out.println("Could not retrieve list of shows from database");
        }
        return showswatched;

        // return null;
    }

    public ShowsWatched findbyShow(String show_name) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "";
        ShowsWatched showsw = null;

        try {

            query = "select * from shows_watched where show_name = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, show_name);

            rs = pstmt.executeQuery();

            

                if (rs != null) {
                    rs.next();
                    showsw = new ShowsWatched(0, query, 0);
                    showsw.setUserId(rs.getInt(1));
                    showsw.setShow_name(rs.getString(2));
                    showsw.setEpisodes_watched(rs.getInt(3));
                }

            

        } catch (Exception e) {
            e.printStackTrace();

        }
        return showsw;

    }

    @Override
    public List<ShowsWatched> findAllbyId(long user_id) {

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shows.shows_watched where user_id = " + user_id);

            List<ShowsWatched> showList = new ArrayList<ShowsWatched>();

            // rs.first();

            while (rs.next()) {
                // iterate to get column info
                int id = rs.getInt("user_id");
                String show_name = rs.getString("show_name");
                int episodes_watched = rs.getInt("episodes_watched");

                // add them to a list...
                ShowsWatched show = new ShowsWatched(id, show_name, episodes_watched);
                showList.add(show);
            }

            // return that list once finished
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
    public boolean update() {
        try {
            String query = "UPDATE shows_watched SET episodes_watched = ? WHERE user_id = ? AND show_name = ?";
            
            BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in));

            System.out.println("Enter episodes watched: ");
            int ew = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Enter the userID: ");
            int uid = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Enter the show: ");
            String sn = bufferedReader.readLine();

            
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, ew);
            pstmt.setInt(2, uid);
            pstmt.setString(3, sn);
            
            int numUpdates = pstmt.executeUpdate();

            if (numUpdates > 0) {
                System.out.println("Episode count has been updated in database.");
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
