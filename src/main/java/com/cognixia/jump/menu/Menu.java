package com.cognixia.jump.menu;

import java.util.Scanner;

public class Menu {

    int selection = 0;
    Scanner input = new Scanner(System.in);

    selection=input.nextInt();

    switch(selection)
    {
        case 1:
            System.out.println("Update");
            break;
        
        case 2:
            System.out.println("View");
            break;
        
        case 3:
            System.out.println("Exit");
            break;
    
        default:
            System.out.println("Must enter number");
    }

}
