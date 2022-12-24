/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newpackageTeste;

import Manager.Admin;
import Manager.DisplayData;

/**
 *
 * @author Marco dos Santos
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Admin adm = new Admin();
         adm.authenticityUser();
         adm.Login();
        //adm.deleteUser();
        
       // DisplayData jbc = new DisplayData();
       // jbc.Manager();
        
        
     }
    
}
