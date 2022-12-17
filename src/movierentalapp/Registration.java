/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

import java.util.Scanner;

/**
 *
 * @author Marco dos Santos
 */
public class Registration {
    public String Name;
    public String email;
    public String password;  

   // public Registration(String Name, String email, String password) {
    //    this.Name = Name;
     //   this.email = email;
     //   this.password = password;
   // }

    @Override
    public String toString() {
        return "Registration{" + "Name=" + Name + ", email=" + email + ", password=" + password + '}';
    }
    
    

    public String getName() {
        return Name;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   
    public void printSet(){
       
        
     try(Scanner scanner = new Scanner(System.in)){
        System.out.println("Register your Name:");
        String name = scanner.nextLine();
        this.setEmail( Name);
        
        
         System.out.println("Register your Email");
         String newemail = scanner.nextLine();
         this.setEmail(email);
         
         
         System.out.println("Register your password");
         String passWord = scanner.nextLine();
         this.setPassword(password);
    }
    
    } 
   // public void RegisterData(){
     //   System.out.println(this.getName());
     //   System.out.println(this.getEmail());
     //   System.out.println(this.getPassword());
              
  //  }
}

