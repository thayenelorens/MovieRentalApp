/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Mayara Lorens
 * Student Number: 2020292
 */
public class deleteMovie {

    public static void deleteMovie() throws SQLException {

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
            System.out.println("Delete RentalMovie option selected\n");
            System.out.println("Type movie ID:\n");

            int id = input.nextInt();
            //Storing a Delete statement inside the String 'sqlDel'
            String sqlDel = "DELETE FROM movies WHERE Movie_id=?";

            //Get a statement from the connection
            PreparedStatement st = conn.prepareStatement(sqlDel);
            //Passing the user's input to the query.
            st.setInt(1, id);
            //Executing the statement.
            st.executeUpdate();

                 ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
         
         //Retrieving data from movies table.
         while (rs.next()) {
             System.out.println("****************************************\n" + 
                     rs.getString(1)+ ": " + rs.getString(9) + ":    " + rs.getString(12)+ "\n    "); 
                          
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
