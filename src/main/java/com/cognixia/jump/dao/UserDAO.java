package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManagerwithProps;
import com.cognixia.jump.exception.PWLimitException;
import com.cognixia.jump.model.ShowsWatched;
import com.cognixia.jump.model.User;

public class UserDAO implements DAO<User> {

    private Connection conn = ConnectionManagerwithProps.getConnection();

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

            if (rs != null) {
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

    public User findbyUser(String user_name) {

        Boolean bool = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "";
        User users = null;

        try {

            query = "select * from Users where user_name = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user_name);

            rs = pstmt.executeQuery();

            // (rs.getString("user_name") != null)
            if (rs != null) {
                rs.next();
                bool = true;
                users = new User(0, query, query, query, query);
                users.setUserId(rs.getInt(1));
                users.setFirstName(rs.getString(2));
                users.setLastName(rs.getString(3));
                users.setUserName(rs.getString(4));
                users.setPassword(rs.getString(5));

            }

        } catch (SQLException e) {
            System.out.println("Username not found in database.");
            // e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return users;

    }

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

    @Override
    public List<User> findAll(long id) {
        // TODO Auto-generated method stub
        return null;
    }

}

// pstmt = conn.prepareStatement(query);
// pstmt.setLong(1, user_id);

// rs.next();
// u

//

//

// }

//

//
//

//

// pstmt.setString(4, entity.getUserName());
// pstmt.setString(5, entity.getPass

// }

// e.printStackTrace()
// }
//
