/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalapp;

/**
 *
 * @author Mayara Lorens Student number: 2020292 Simple class that contains
 * three methods. Its main function is to print our menu.
 *
 */
public class Menu {

    /**
     * Method that outputs a welcome message for the customer.
     */
    public void welcome() {

        System.out.println("Welcome to the EirVid Movie Rental System!\nPlease, take a look at our menu of options:");
    }

    /**
     * Method that prints the menu of my toy store.
     */
    public void printMenu() {

        //Print Menu to the screen.
        System.out.println("*** Movie Rental System Menu ***");
        System.out.println();

        System.out.printf("%-25s%s\n", "Display Movie List", "1");
        System.out.printf("%-25s%s\n", "Add Movie", "2");
        System.out.printf("%-25s%s\n", "Delete Movie", "3");
        System.out.printf("%-25s%s\n", "Rent a Movie", "4");
        System.out.printf("%-25s%s\n", "Top 5 Movies rented", "5");
        System.out.printf("%-25s%s\n", "Select a Movie", "6");
        System.out.printf("%-25s%s\n", "Exit Program", "7");
        System.out.println();

    }

    /**
     * Method that prints a farewell message for the customer.
     */
    public void fareWell() {

        System.out.println("Thank you for shopping with us!\nCome Back soon!");
    }
}
