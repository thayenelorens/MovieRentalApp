/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movierentalapp;

//importing necessary libraries for this class to run properly.
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 * Group Members:
 *
 * @author Thayene Lorens - 2020293
 * @author Mayara Lorens - 2020292
 * @author Marco Antonio dos Santos - 2020333
 */
public class MovieRentalApp {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    //IOException is thrown in case there's an error when reading each line.
    public static void main(String[] args) throws IOException {
        
       
        
         Registration user = new Registration();
         user.printSet();// method called to set customer data
         user.RegisterData();// method called to display customer data after registration
         


        System.out.println("Mayara, testing!");
    }

}
