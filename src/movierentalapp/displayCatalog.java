/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayara Lorens
 * Student Number: 2020292
 */
public class displayCatalog {
    public static void displayMovies()  {
     try {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
         
         //root is the username of mySQL
         String username = "root";
         
         //root is the password of mySQL
         String pass = "root";
         //Database name: movie_db
         Connection con = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/movie_db", username, pass);
         
          //Creating a statement.
         Statement stmt = con.createStatement();
         //Select statement. Using ResultSet to execute the query.
         ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
         
         //Retrieving data from movies table.
         while (rs.next()) {
             System.out.println("****************************************\n" + 
                     rs.getString(1)+ ": " + rs.getString(9) + ":    " + rs.getString(12)+ "\n    "); 
                          
         }
         
     } catch (SQLException ex) {
            Logger.getLogger(displayCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
