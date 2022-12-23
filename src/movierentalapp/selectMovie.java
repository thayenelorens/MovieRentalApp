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
 * @author Thayene Lorens
 * Student Number: 2020293
 */
public class selectMovie {
      public static void selectMovie() throws SQLException {

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
            System.out.println("Delete RentalMovie option selected");
            System.out.println("Type movie ID");

            int id = input.nextInt();
            //Storing a Delete statement inside the String 'sqlDel'
//           double price = input.nextDouble();
//            String title = input.nextLine();
            String update = "SELECT movies WHERE Movies_id=?";

            PreparedStatement st = conn.prepareStatement(update);
            //Passing the user's input to the query.
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies WHERE Movie_ID =" + id);

            while (rs.next()) {
                System.out.println("****************************************\n"
                        + rs.getString(1) + ": " + rs.getString(9) + ":    " + rs.getString(12) + "\n    ");

            }
           } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


