package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.exception.PWLimitException;
import com.cognixia.jump.model.User;

public class UserDAO implements DAO<User> {

    private Connection conn = ConnectionManager.getConnection();

    // @shem, your findall method is commended at the end of the page 

    @Override
    public User findbyId(long user_id) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "";
        User users = null;

        try {

            query = "select * from Users where user_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setLong(1, user_id);

            rs = pstmt.executeQuery();

            if(rs != null) {
                rs.next();
                users = new User(0, query, query, query, query);
                users.setUserId(rs.getInt(1));
                users.setFirstName(rs.getString(2));
                users.setLastName(rs.getString(3));
                users.setUserName(rs.getString(4));
                users.setPassword(rs.getString(5));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return users;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(User entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(User entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    // @Override
    // public List<User> findbyUser(String user_name) {

    //     PreparedStatement pstmt = null;
    //     ResultSet rs = null;
    //     String query = "";
    //     List<User> users = new LinkedList<>();

    //     try {

    //         query = "select * from Users where user_id = ?";
    //         pstmt = conn.prepareStatement(query);
    //         pstmt.setLong(1, user_id);

    //         rs = pstmt.executeQuery();

    //         if(rs != null) {
    //             rs.next();
    //             users = new User(0, query, query, query, query);
    //             users.setUserId(rs.getInt(1));
    //             users.setFirstName(rs.getString(2));
    //             users.setLastName(rs.getString(3));
    //             users.setUserName(rs.getString(4));
    //             users.setPassword(rs.getString(5));
    //         }


    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
        
    //     return users;
    // }

    // @Override
    // public List<User> findAll() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

       // public boolean create(User entity) {
    //     // we receive a ready Java course and need to make it SQL and insert
    //     try {
    //         String query = "Insert into course(course_id, course_name, course_desc, dept_id)" + " values(?,?,?,?)";
    //         PreparedStatement pstmt = conn.prepareStatement(query);

    //         pstmt.setNull(1, Types.INTEGER);
    //         pstmt.setString(2, entity.getFirstName());
    //         pstmt.setString(3, entity.getLastName());
    //         pstmt.setString(4, entity.getUserName());
    //         pstmt.setString(5, entity.getPassword());

    //         int numInserts = pstmt.executeUpdate();

    //         if (numInserts > 0) {
    //             System.out.println("Entity " + " added to db.");
    //             return true;
    //         }

    //         if (entity.getPassword().length() < 4) {
    //             throw new PWLimitException();
    //         }

    //     } catch (PWLimitException e) {
    //         e.getMessage();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }

    

    

}
