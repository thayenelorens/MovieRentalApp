/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

/**
 *
 * @author Marco dos Santos
 */

//Abtract class for addUsser and Admin user  classs get getter and setters
public abstract class Person {
     private String first_name;
     private String Email;
     private String password;
   
     // getters method to  get names, emails and passwords   
    public String getFirst_name() {
        return first_name;
    }
     // methos to setters methods to setting names,emails and passwords
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
      
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     
}
