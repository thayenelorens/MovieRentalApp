/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

import java.util.Scanner;

/**
 *
 * @author Marco dos Santos
 */ //class 
public class Registration {
    public String Name;
    public String email;
    public String password; 
   
    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public String setPassword(String password) { //validator the password
        this.password = password;
        if (password.length() < 8 || password.length() > 9) {
            System.out.println("Sorry, the input was the wrong length,try again");
        }
        else {
            if (password.matches("^[0-9]{7}[A-Z]+$")) {
                System.out.println("Thank you for entering a valid Password");
            }
            else {
                System.out.println("The Password needs to be 7 numbers followed by 1 or 2 capital letters");
            }
            return  password; 
        }
        return null;
    }
       
    
   //method to print scanner to set customer data
    public void printSet(){
          
     try(Scanner scanner = new Scanner(System.in)){
        System.out.print("Register your Name :");
        String name = scanner.nextLine();
        this.setName(name);
        
        
         System.out.print("Register your Email :");
         String newEmail = scanner.nextLine();
         this.setEmail(newEmail);
         
         
         System.out.print("Register your password, your password must have 7 numbers and 1 or 2 Capital letter :");
         String passWord = scanner.nextLine();
         this.setPassword(passWord);
    }
    
    } 
    //method created to display customer data after registration
    public void RegisterData(){
       System.out.println("---------CustomerData---");
       System.out.println(getName());
       System.out.println(getEmail());
       System.out.println(getPassword());
              
   }
}

