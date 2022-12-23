/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Thayene Lorens Student Number: 2020293
 */
public class RentMovie {

    public static void rentMovie() throws SQLException, IOException {

        //root is the username to grants access to our SQL.
        String username = "root";
        //root is the password that grants access to our SQL.
        String password = "root";

        //Declaring these variables to connect the program to the movies_db database.
        Connection conn;
        Statement stmt;
        ResultSet rs;

        //Load the database driver and establishing a connection to the database (movies_db).
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/movie_db", username, password);

        //Get a statement from the connection
        stmt = conn.createStatement();

        System.out.println("Rent a Movie option selected");

        //Initializing these variables to later store the 'total' property of each item > total = price * quantity.
        double total = 0.0;
        double totalPrice = 0.0;

        /**
         * @ Variables for user to choose the title of the movie, select the
         * price and rating of it. They also input the amount of times they want
         * to rent a specific movie and they are asked to input their name to be
         * stored in the database.
         *
         */
        String title;
        String userName;
        double rating;
        int amount;
        double price;

        //This variable is responsible to keep the customer shopping or not.
        boolean continueShopping = true;

        //Customer can either choose to rent a movie or quit. 
        int choice;

        //Creating a cart object out of shoppingCart class.
        shoppingCart cart = new shoppingCart();

        //I chose bufferedReader for user's input.
        BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));

        //Storing a SELECT statement inside the String 'query'.
        String query = ("SELECT * FROM movies");

        //Execute the query.
        rs = stmt.executeQuery(query);

        //Source for java.util.Date: https://stackoverflow.com/questions/2400955/how-to-store-java-date-to-mysql-datetime-with-jpa
        //This piece of code gives us a String Date format for the transactions: year-month-day-hours-mins-secs
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);

        //Loop through the query and get the Strings desired from the database.
        while (rs.next()) {
            System.out.println(rs.getString(1) + ": " + rs.getString(9)+ "  "+rs.getString(12)+"\n");

        }

        //I chose to use a do while loop, because I thought it'd be more practical to keep displaying it until 'Leave shop' option was selected.
        do {

            System.out.println("Take a look at the movies above and select one of the options below.\n\n 1 - RENT A MOVIE\n 2 - CHECKOUT");
            choice = Integer.parseInt(myKB.readLine());

            //User's selection
            switch (choice) {
                case 1:
                    System.out.println("Please, give us the following information:");

                    System.out.print("Your Name: ");
                    userName = myKB.readLine();

                    System.out.print("Movie to be rented: ");
                    title = myKB.readLine();

                    System.out.print("Movie rating: ");
                    rating = Double.parseDouble(myKB.readLine());

                    System.out.print("Price: ");
                    price = Double.parseDouble(myKB.readLine());

                    System.out.print("Quantity:");
                    amount = Integer.parseInt(myKB.readLine());

                    //Making a new object according to user's input (constructor w/ parameters).
                    Movies movieItem = new Movies(title, rating, price, amount); //Making a new object according to user's input (constructor w/ parameters).

                    //Storing the new object into the ArrayList, i.e., into shoppingCart.
                    cart.buyItem(movieItem);

                    //Total before set to 0.0 is now the total of movieItem, i.e., it is the price * amount selected by the user.
                    total += movieItem.getTotal();

                    //The values are also stored in the 'transactions' table of movies_db database.
                    stmt.execute(
                            String.format("INSERT INTO transactions (user_name, title, vote_average, price, amount, order_date) "
                                    + "VALUES (\"%s\",\"%s\",%f,%f,%d, \"%s\");",
                                    userName, title, rating, price, amount, currentTime
                            ));
                    break;

                case 2:

                    //Calling this method allows the chosen items to be printed in a formatted String.
                    System.out.println(cart.emptyCart());
                    //totalPrice: It sums the (price * amount) of everything the client selects.
                    totalPrice += total;
                    System.out.println("Total Price: " + totalPrice + "\n");

                    //setting it to false is opposite of this loop criteria to keep running. I set it to 'false' since the customer no longer wants to continue shopping.
                    continueShopping = false;

                    break;
            }
          //if input is not the number 1 or 2, loop restarts.
        } while (continueShopping == true);
    }
}
