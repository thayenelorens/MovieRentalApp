/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

//Importing libraries.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static movierentalapp.MostWatched.topMovies;
import static movierentalapp.RentMovie.rentMovie;
import static movierentalapp.addMovie.addMovie;
import static movierentalapp.deleteMovie.deleteMovie;
import static movierentalapp.displayCatalog.displayMovies;
import static movierentalapp.selectMovie.selectMovie;


/**
 *
 * @author Mayara Lorens Student Number: 2020292 This class is has a method
 * "filmChoice" that holds the selection of the EirVid rental store. This class
 * is the core of our program.
 *
 */
public class Selection {

    public void filmChoice() throws IOException, SQLException {

        //Creating a selection object out of the Menu class, in order to display the Menu of our rental shop.
        Menu selection = new Menu();

        //Calling the Welcome method.
        selection.welcome();

        //Calling the printMenu method.
        selection.printMenu();
        try {
            //Using bufferedReader here to get user's input.
            BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));

            //I created this variable and set it as the condition for my do-while loop to either continue running or not.
            boolean quit = false;

            System.out.println();

            //do-while loop to keep the case statement prompting in case user input is < 1 or > 7.
            //Problem: If user input is not an integer, the program only prompts the catch message and does not restart the loop.
            do {

                System.out.println("Please, type a number from 1 to 7 for your choice: ");

                //This variable stores user's input.
                int menuChoice = Integer.parseInt(myKB.readLine());

                // Prompt user to enter selection
                switch (menuChoice) {
                    case 1:
                        //If choice is number 1, displayMovies function is triggered, so movies are displayed.
                        displayMovies();
                        break;

                    case 2:
                        //If choice is number 2, addMovie function is triggered.
                        addMovie();
                        System.out.println("Movie added successfully!");
                        break;
                    case 3:
                        deleteMovie();
                        System.out.println("Movie deleted successfully!");
                        break;
                    case 4:
                        //If choice is number 4,the user can rent a movie by calling rentMovie function.
                        rentMovie();
                        System.out.println("Thanks for choosing EirVid! xD");
                        break;

                    case 5:
                        //If choice is number 5,the user can check the top 5 rented movies in the last 5 minutes through the topMovies function.
                        topMovies();
                        break;
                    case 6:
                        selectMovie();
                        break;

                    case 7:
                        //calling farewell method.
                        selection.fareWell();
                        quit = true;

                        break;

                    default:
                        System.out.println("Numbers have to be from 1 to 7 only!");

                }
            } while (quit == false);
        } catch (Exception e) {

            //If input is not a number, error messages pops up.
            System.out.println("Error! Please, choose numbers only!"); //if user types letters instead of numbers for the choice, the program will catch this message and output it.
        }
    }
}
