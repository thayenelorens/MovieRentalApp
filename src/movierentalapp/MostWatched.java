/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

//All the libraries necessary for the program to run.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Thayene Lorens 
 * @Student Number: 2020293
 *
 * This class contains a method called topMovies that displays in the output the
 * top 5 watched movies in the last 5 minutes.
 */
public class MostWatched {

    public static void topMovies() throws SQLException {

        try {
            //root is the username to grants access to our SQL.
            String username = "root";

            //root is the password that grants access to our SQL.
            String password = "root";

            //Declaring these variables to connect the program to the movies_db database.
            Connection conn;
            Statement stmt;
            ResultSet rs;

            //Load the database driver and establishing a connection to the database (movies_db_.
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_db", username, password);

            //Get a statement from the connection
            stmt = conn.createStatement();

            System.out.println("TOP 5 WATCHED MOVIES");
            System.out.println();

            /*This statement selects all data from the transactions table and retrieves info when a movie is rented
              more than once in the last 5 minutes. It also displays no more than 5 movies to keep it short.
             */
            String duplicate = "SELECT * FROM transactions WHERE order_date >= NOW() - INTERVAL 5 MINUTE GROUP BY title HAVING COUNT(*) >1 LIMIT 5";

            //Execute the query.
            rs = stmt.executeQuery(duplicate);

            //Lines 58 - 67 were extracted from: https://javarevisited.blogspot.com/2016/10/how-to-check-if-resultset-is-empty-in-Java-JDBC.html#ixzz7oFI8zjOo
            //If ResultSet is empty, i.e, if no movies were rented in the last 5 minutes, a message is displayed/
            if (rs.next() == false) {

                System.out.println("Sorry, no movies were rented in the last 5 minutes.");
            } else {
                //If there's data to be retrieved, a loop iterates at least once through the database.
                do {
                    //It pulls movie title and order_date from the transactions database.
                    System.out.println("Top 5 movies rented in the last 5 minutes:\n" + rs.getString(3) + "\n" + rs.getString(7));
                } while (rs.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
