package com.cognixia.jump.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.exception.PWLimitException;
import com.cognixia.jump.model.Show;
import com.cognixia.jump.model.ShowsWatched;
import com.cognixia.jump.model.User;

public class DAODriver {

    public static void main(String[] args) throws PWLimitException {
        UserDAO userDAO = new UserDAO();
        SWDAO swDAO = new SWDAO();
        // ShowDAO showDAO = new ShowDAO();

        Scanner input = new Scanner(System.in);

        // System.out.println("Enter Login Information: ");
        System.out.println("Username: ");

        User userTest = userDAO.findbyUser(input.nextLine());

        System.out.println(userTest);

        if (userTest.getUserId() == (0)) {
            System.out.println("User Not Found.");
        } else {
            System.out.println("Password: ");
            if (userTest.getPassword().length() < 4) {
                throw new PWLimitException("Password must be at least 4 characters long.");
            }
            if (userTest.getPassword().equals(input.nextLine())) {
                System.out.println("Confirmed");
                try {

                    int selection = 0;

                    do {
                        System.out.println("1. View WatchList");
                        System.out.println("2. Update Episode Count");
                        System.out.println("0. Exit");
                        System.out.println("Choose Option:");
                        selection = input.nextInt();

                        switch (selection) {
                            case 1:
                                System.out.println("View WatchList.");
                                System.out.println(userTest.getUserId());
                                List<ShowsWatched> showTest = new ArrayList<ShowsWatched>();
                                showTest = Arrays.asList(swDAO.findbyId(userTest.getUserId()));

                                for (int i = 0; i < showTest.size(); i++) {
                                    System.out.println(showTest.get(i));
                                }

                                System.out.println(showTest);

                                break;

                            case 2:
                                System.out.println("Update WatchList.");
                                // Show shows = showDAO.findbyShow(shows.getShow_name());
                                // System.out.println(shows);
                                // List<Show> shows =

                                break;

                            default:
                                System.out.println("Goodbye!");
                        }

                    } while (selection != 0);

                } catch (Exception e) {
                    System.out.println("message");
                }
            }

            else {
                System.out.println("Denied");
            }
        }

        // System.out.println(userDAO.findbyPassword(input.nextLine()));

        // System.out.println("Enter user_id: ");
        // System.out.println(userDAO.findbyId(input.nextInt()));

        // I'm thinking we can have it to when we enter the userid, it will return the
        // showsWatched table and possibly plus
        // other records such as name and username

    }

    private static String getShow_name() {
        return null;
    }

}
