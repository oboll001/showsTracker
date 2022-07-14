package com.cognixia.jump.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.exception.PWLimitException;
import com.cognixia.jump.menu.LoginServlet;
import com.cognixia.jump.model.ShowsWatched;
import com.cognixia.jump.model.User;

public class DAODriver extends LoginServlet {

    public static void main(String[] args) throws PWLimitException {
        UserDAO userDAO = new UserDAO();
        SWDAO swDAO = new SWDAO();

        Scanner input = new Scanner(System.in);

        // System.out.println("Enter Login Information: ");
        System.out.println("Username: ");

        User userTest = userDAO.findbyUser(input.nextLine());

        System.out.println(userTest);

        if (userTest.getUserId() == (0)) {
            System.out.println("User Not Found.");
        } else {
            System.out.println("Password: ");
            try {
                if (userTest.getPassword().length() < 4) {
                    throw new PWLimitException("Password is not at least 4 characters long");
                }
            } catch (PWLimitException e) {
                e.getMessage();
            }

            if (userTest.getPassword().equals(input.nextLine())) {
                System.out.println("Confirmed");
                try {

                    int selection = 0;

                    do {
                        System.out.println("1. View WatchList");
                        System.out.println("2. Update Episode Count");
                        System.out.println("Choose Option:");
                        selection = input.nextInt();

                        switch (selection) {
                            case 1:
                                System.out.println("View WatchList.");
                                ShowsWatched showTest = swDAO.findbyId(input.nextInt());
                                System.out.println(showTest);
                                break;

                            case 2:
                                System.out.println("Update Episode Count");

                                break;

                            case 3:
                                System.out.println("Exit.");

                                break;

                            default:
                                System.out.println("Must enter number.");
                        }

                    } while (selection != 0);

                } catch (Exception e) {
                    System.out.println("message");
                }
            }
        }
    }
}