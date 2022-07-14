package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
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

            query = "select * from ShowsWatched where user_id = ?";
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(ShowsWatched entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(ShowsWatched entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    

}
