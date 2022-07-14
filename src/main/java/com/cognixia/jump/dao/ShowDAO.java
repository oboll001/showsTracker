package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManagerwithProps;
import com.cognixia.jump.model.Show;

public class ShowDAO implements DAO<Show> {

    private Connection conn = ConnectionManagerwithProps.getConnection();

    
    public Show findbyShow(String show_name) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "";
        Show show = null;

        try {

            query = "select * from Shows where show_name = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, show_name);

            rs = pstmt.executeQuery();

           
            if (rs != null) {
                rs.next();
           
                show = new Show(query, 0, 0);
                show.setShow_name(rs.getString(1));
                show.setNum_of_episodes(rs.getInt(2));
                show.setShow_rating(rs.getInt(3));
                
                
              
            }

        }  
            catch (Exception e) {
            e.printStackTrace();

        }
        return show;
        
    }


    @Override
    public Show findbyId(long id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Show> findAll(long id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean create(Show entity) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean update(Show entity) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        return false;
    }
        
        
    }

  
    

