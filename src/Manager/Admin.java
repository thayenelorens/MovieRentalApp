/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Marco dos Santos
 */
public class Admin extends Person {
   // private int user_Id;
    
    PreparedStatement pstm ;
    Connection conn;
    
    public void authenticityUser() {//methos resultSet to get the correct login and password from database.
        //  Get a connection to the database
        conn =  new MyConnection().connectBD();

        try (Scanner scanner = new Scanner(System.in)){
            
           
             
            //variable created to get  statement from database.
            String mySql = "Select * from admin where first_name = ? and  pass_word = ?";
            
            
            System.out.println("Please enter your Name :");
            String name = scanner.nextLine();
            this.setFirst_name(name);
            
            System.out.println("Please enter your Password :");
            String PassWordname = scanner.nextLine();
            this.setPassword(PassWordname);
            
            
            pstm = conn.prepareStatement(mySql);//Get a statement from the connection and send to database statements.
            pstm.setString(1,getFirst_name());//get the input from console and send to database.
            pstm.setString(2, getPassword());
            //// Execute the query
            
            pstm.executeQuery("Select * from admin where first_name = ? and  pass_word = ?");
            
        } catch (SQLException erro) {
            //error message if something get wrong in the execution.

        }

    }
    public void deleteUser() {
   
        try {
            //Connecting to the database.
            //Username and password are "root".
            String username = "root";
            String pass = "root";
            //Database name: movie_db
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/movie_db", username, pass);

            //Creating a statement.
            Statement stmt = conn.createStatement();

            //Using scanner to generate input by the user.
            Scanner input = new Scanner(System.in);
            System.out.println("Delete User option\n");
            System.out.println("Type user ID:\n");

            int id = input.nextInt();
            //Storing a Delete statement inside the String 'sqlDel'
            String sqlDel = "DELETE FROM user WHERE id =?";

            //Get a statement from the connection
            PreparedStatement st = conn.prepareStatement(sqlDel);
            //Passing the user's input to the query.
            st.setInt(1, id);
            //Executing the statement.
            st.executeUpdate();

                 ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE ID =" + id);
         
         //Retrieving data from movies table.
         while (rs.next()) {
             System.out.println( rs.getString("id") + "\t" + rs.getString("firstname") +
                                    "\t" + rs.getString("username")+"\t" + rs.getString("password")
                                    +"\t" + rs.getString("email")) ;    
         }
        } catch (SQLException e) {
        }
    }
   
    public  void Login()
	{
          
                    
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
                            System.out.println( rs.getString("id") +"\t----" + rs.getString("first_name") +
                                     rs.getString("pass_word")) ;
                            
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

