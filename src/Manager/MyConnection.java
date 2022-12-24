/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marco dos Santos
 */
public class MyConnection {
    public Connection connectBD(){
        Connection conn = null;
        
        try {
               // Load the database
            String url;
            url = "jdbc:mysql://localhost:3306/movie_db?user=root&password=root";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            //error message if something get wrong in the execution.
        }
        return conn;// return the statement 
    
}
}
