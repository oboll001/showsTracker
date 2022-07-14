package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Show> findAll(long user_id) {

        try {

        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM shows.shows_watched);

            List<Show> showList = new ArrayList<Show>();

            //rs.first();

            while(rs.next()) {
                // ...iterate through to get column info...
                String show_name = rs.getString("show_name");
                int num_of_episodes = rs.getInt("num_of_episodes");
                int show_rating = rs.getInt("show_rating");

                // ...then add them to a list...
                Show show = new Show(show_name, num_of_episodes,show_rating);
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

  
    

