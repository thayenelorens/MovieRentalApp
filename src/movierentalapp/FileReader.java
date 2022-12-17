/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Thayene Lorens
 */
public class FileReader {
    
    public static String reader(String filePath) throws IOException{
              
        //The sentece variable is initially set with an empty value.
        String sentence = "";

        //Surrounding BufferedReader with "try and catch".
        try {
            //Using BufferedReader to read from the Movie_Metadata.csv file. 
            BufferedReader movieFile = new BufferedReader(new java.io.FileReader(filePath));

            /*Using while loop to read from the file.
             The loop is going to read a sentence and store it into the "sentence" variable created above.
             While the next sentence is not equals to null, the loop will keep going.*/
            while ((sentence = movieFile.readLine()) != null) {
                                
                //Creating a String array "index" that splits the lines separating them by commas.
                String[] index = sentence.split(",");
                
                //Printing only the Original Title of each movie, located into index position number 1.
                System.out.println("Title: " + index[1]);
            }
            //Catch statement in case the Movie_Metadata file is not found.
        } catch (FileNotFoundException ex) {
             System.out.println("ERROR - Unable to find file " + "'" + filePath + "'");

        }
        return sentence;
    }
    }
    
