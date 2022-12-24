/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

//Importing libraries.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Mayara Lorens
 * Student Number: 2020292
 * This class is has a method "addMovie" that adds a movie to the database movie_db.
 * This function should be done by the admin.
 */
public class addMovie {

    public static void addMovie() throws SQLException {

        try {
            //Connecting to the database.
            //Username and password are "root".
            String username = "root";
            String pass = "root";
            //Database name: movie_db
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_db", username, pass);

            //Creating a statement.
            Statement stmt = conn.createStatement();
            
            //Using scanner to generate input by the user.
            Scanner input = new Scanner(System.in);
            System.out.println("Add RentalMovie option selected");
            System.out.println();

            //Admin can add title, overview of the movie and price.
            System.out.println("Enter title:");
            String title = input.nextLine();
            System.out.println("Enter overview:");
            String overview = input.nextLine();
            System.out.println("Enter price:");
            float price = input.nextFloat();
          
            //This statement insert the info prompted by input to the movies table in the database.
            stmt.execute(
                    String.format("INSERT INTO movies (title, overview, price) "
                            + "VALUES (\"%s\",\"%s\",%f);",
                            title, overview, price)
            );
                        
        } catch (SQLException e) {
        }
    }
}
