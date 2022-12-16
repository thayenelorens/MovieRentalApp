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
import static movierentalapp.FileReader.reader;


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
     */
    
    //IOException is thrown in case there's an error when reading each line.
    public static void main(String[] args) throws IOException {
        
        /**
         * Calling method from FileReader class.
         * @Thayene Lorens
         */
        String print = reader("Movie_Metadata.csv");
        System.out.println(print);

//        //The filePath variable stores the Movie_Metadata.csv file. The csv file is inside this project folder.
//        String filePath = "Movie_Metadata.csv";
//        //The sentece variable is initially set with an empty value.
//        String sentence = "";
//
//        //Surrounding BufferedReader with "try and catch".
//        try {
//            //Using BufferedReader to read from the Movie_Metadata.csv file. 
//            BufferedReader movieFile = new BufferedReader(new FileReader(filePath));
//
//            /*Using while loop to read from the file.
//             The loop is going to read a sentence and store it into the "sentence" variable created above.
//             While the next sentence is not equals to null, the loop will keep going.*/
//            while ((sentence = movieFile.readLine()) != null) {
//                                
//                //Creating a String array "index" that splits the lines separating them by commas.
//                String[] index = sentence.split(",");
//                
//                //Printing only the Original Title of each movie, located into index position number 1.
//                System.out.println("Title: " + index[1]);
//            }
//            //Catch statement in case the Movie_Metadata file is not found.
//        } catch (FileNotFoundException ex) {
//             System.out.println("ERROR - Unable to find file " + "'" + filePath + "'");
//
//        }
    }

}
