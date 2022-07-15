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

        // System.out.println(userTest);

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
                                System.out.println("");
                                // System.out.println(userTest.getUserId());

                                // List<ShowsWatched> showTest = swDAO.findAll(userTest.getUserId());
                                // List<ShowsWatched> showTest = new ArrayList<ShowsWatched>();
                                // showTest = Arrays.asList(swDAO.findbyId(userTest.getUserId()));

                                // for (int i = 0; i < showTest.size(); i++) {
                                //     System.out.println(showTest.get(i));
                                // }

                                // System.out.println(showTest);
                                List<ShowsWatched> showTest = swDAO.findAllbyId(userTest.getUserId());

                                
                                for(ShowsWatched sw : showTest){
                                    System.out.println("Show: " + sw.getShow_name() + " " + "| Episodes Watched: " + sw.getEpisodes_watched());
                                } 
                            
                                System.out.println("");


                                break;
                                

                            case 2:
                                System.out.println("Update WatchList.");
                                // Show shows = showDAO.findbyShow(shows.getShow_name());
                                // System.out.println(shows);
                                // List<Show> shows =

                                // ShowsWatched showUpdate = new ShowsWatched(userId, show_name, episodes_watched);

                               
                                // Scanner upd = new Scanner(System.in);

                                System.out.println("Your login information is: " + userTest +  "| Please enter show you want to update.");

                                swDAO.update();
                                

                                // ShowsWatched showTest2 = swDAO.findbyShow(upd.nextLine());

                               
                                
                                // if (showTest2.getUserId() == (0)) {
                                //     System.out.println("User does not have this show in WatchList.");
                                // } else {
                                //     System.out.println("Enter updated episode count.");
                                // }


                                break;

                            default:
                                System.out.println("Goodbye!");
                        }

                    } while (selection != 0);

                } catch (Exception e) {
                    System.out.println("Error.");
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
