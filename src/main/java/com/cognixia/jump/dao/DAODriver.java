package com.cognixia.jump.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.menu.LoginServlet;

public class DAODriver extends LoginServlet {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        Scanner input = new Scanner(System.in);

        // System.out.println("Enter Login Information: ");
        // System.out.println("Username: ");

        // System.out.println("Password: ");

        System.out.println("Enter user_id: ");
        System.out.println(userDAO.findbyId(input.nextInt()));

        // I'm thinking we can have it to when we enter the userid, it will return the
        // showsWatched table and possibly plus
        // other records such as name and username

    }

}
