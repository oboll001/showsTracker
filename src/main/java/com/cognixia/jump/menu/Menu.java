package com.cognixia.jump.menu;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args){

        int selection;
        try{
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
                System.out.println("Your input was: " + selection);
                        input.close();
            } catch (Exception e){
            System.out.println("You didn't enter an integer.");
            }
    }

}
