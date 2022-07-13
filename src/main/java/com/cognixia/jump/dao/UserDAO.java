package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.exception.PWLimitException;
import com.cognixia.jump.model.User;

public class UserDAO implements DAO<User> {

    private Connection conn = ConnectionManager.getConnection();

    public boolean create(User entity) {
        // we receive a ready Java course and need to make it SQL and insert
        try {
            String query = "Insert into course(course_id, course_name, course_desc, dept_id)" + " values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setNull(1, Types.INTEGER);
            pstmt.setString(2, entity.getFirstName());
            pstmt.setString(3, entity.getLastName());
            pstmt.setString(4, entity.getUserName());
            pstmt.setString(5, entity.getPassword());

            int numInserts = pstmt.executeUpdate();

            if (numInserts > 0) {
                System.out.println("Entity " + " added to db.");
                return true;
            }

            if (entity.getPassword().length() < 4) {
                throw new PWLimitException();
            }

        } catch (PWLimitException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findbyId(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
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

}
