/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Marco dos Santos
 */
public class addUser extends Person {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
     
    PreparedStatement pstm ;
    Connection conn;
    
    public ResultSet userAdd() {//methos resultSet to get the correct login and password from database.
        //  Get a connection to the database
        conn =  new MyConnection().connectBD();
       
        try (Scanner scanner = new Scanner(System.in)){
            //variable created to get  statement from database.
      
            String mySql = "INSERT INTO user(firstname,username,password,email) values(?,?,?,?)";
            
            // scanner to get input from console
            System.out.println("Signup your Name :");
            String name = scanner.nextLine();
            this.setFirst_name(name);
            System.out.println("Enter your Username :");
            String userName = scanner.nextLine();
            this.setUsername(userName);
            System.out.println("Enter  your Password :");
            String passWord = scanner.nextLine();
            this.setPassword(passWord);
            System.out.println("Enter  your Email :");
            String email = scanner.nextLine();
            this.setEmail(email);
            
            
            pstm = conn.prepareStatement(mySql);//Get a statement from the connection and send to database statements
            pstm.setString(1, getFirst_name());//get the input from console and send to database.
            pstm.setString(2, getUsername());
            pstm.setString(3, getPassword());
            pstm.setString(4, getEmail());
            
            //ResultSet rs = pstm.executeQuery();//// Execute the query
            pstm.execute();
           // System.out.println(getFirst_name());
           // System.out.println(getSecond_name());
           // return rs;
            
        } catch (SQLException erro) {
     
            //error message if something get wrong in the execution.
          //  return null;
        }
        return null;
    
}
}
