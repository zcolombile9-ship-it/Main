/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author Student
 */
//Imports Scanner so we can get user input
import java.util.Scanner;
//Create the Main class
public class Main {
    
    // Create Scanner for user input
    static Scanner input = new Scanner(System.in);
    
    //store the user's entered details 
    static String username;
    static String password;
    static String cellphone;
    
    
    // Stores the registered username
    static String registeredUsername;
    
    // Store the registered password
    static String registeredPassword;
    
    // Store the registered cellphone number
    static String registeredCellphone;
    
    // Create the username checking method
     public static boolean checkUserName(String username) {
         //Username must have exactly 5 characters
         //and must contain an underscore
         if (username.length() == 5 && username.contains("-")) {
             return true;
         } else {
             return false;
         }
         
     }
   
    // Create the password checking method
     public static boolean checkPasswordComplexity(String password) {
         //password must have at least 8 characters 
         //and contains uppercase, lowercase, numbver special characters 
         if (password.length() >= 8
                 && password.matches(".*[A-Z].*")
                 && password.matches(".*[a-z].*")
                 && password.matches(".*[0-9].*")
                 && password.matches(".*[^a-zA-Z0-9].*")) {
             return true;
         }else {
             return false;
         }
         
         
     }
     // Create the cellphone checking method
     public static boolean checkCellphoneNumber(String number) {
         // Number must start with +27
         // followed by exactly 9 digits
         if (number.matches("^\\+27[0-9]{9}$")) {
             return true;
         } else {
             return false;
         }
      
     }
     // Create the registered method
     public static void registerUser() {
         // Ask for username
         System.out.print("Enter your username: ");
         username = input.nextLine();
         // Ask for password
         System.out.print("Enter your password:");
         password = input.nextLine();
         // Ask for cellphone number
          System.out.print("Enter your cellphone number (+27):");
          cellphone = input.nextLine();
          // Check username
          boolean usernameCorrect = checkUserName(username);
          //check password
          boolean passwordCorrect = checkPasswordComplexity(password);
          // Check cellphone number
          boolean phoneCorrect = checkCellphoneNumber(cellphone);
          // Check if all registration details are correct
          if (usernameCorrect && passwordCorrect && phoneCorrect){
              // Save the valid username 
              registeredUsername = username;
              // Save the valid password 
              registeredPassword = password;
              // Save the valid cellphone number
              registeredCellphone = cellphone;
              // Display success messege
              System.out.print("User registered successfully.");
          } else {
              // Display failure messege
              System.out.print("Registration failed.");
          }
     }
     // Create the login method
     public static boolean loginUser (String username, String password) {
         // compare entered details with registered details 
         if (username.equals(registeredUsername)
                 && password.equals(registeredPassword)){
             return true;
         } else {
             return false;
             
         }
             
     }
     // Create the login status method
     public static String returnLoginStatus(boolean loginSuccessful) {
         // Check if login was successful
         if (loginSuccessful){
             return "Welcome, it is great to see you again.";
         } else {
             return "Username or password incorrect, please try again.";
         }
       
     }
     // Main method where the program starts
     public static void main(String[] args){
         // Call registration method
         registerUser();
         // Call login method
         boolean loginSuccessful = loginUser(username, password);
         // Call login status method
         System.out.print(returnLoginStatus(loginSuccessful));
     }
     
}