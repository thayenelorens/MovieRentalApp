/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marco dos Santos
 */
public class DisplayData {
    
    public  void Manager()
	{
          // 
                    
		try{
			// Load the database driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://localhost:3306/movie_db";
			String user = "root";
			String password = "root";
			String query = "SELECT * FROM user";

                    // Get a statement from the connection
                    try ( // Get a connection to the database
                            Connection conn = DriverManager.getConnection(dbServer, user, password); // Get a statement from the connection
                            Statement stmt = conn.createStatement(); // Execute the query
                            ResultSet rs = stmt.executeQuery(query)) {
                        
                        
                        
                        // Loop through the result set
                        while(rs.next()) {
                            
                            System.out.println( rs.getString("id") +   "\t----" + rs.getString("firstname") +
                                    "\t----" + rs.getString("username")+"\t----" + rs.getString("password")
                                    +"\t----" + rs.getString("email")) ;
                            
                        }
                        
                    }
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			//Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( ClassNotFoundException | IllegalAccessException | InstantiationException e ){
			System.out.println( e ) ;
		}
                
        
      
}
}