/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Anar
 */
public class Email {
    Scanner sc = new Scanner(System.in);
    
    private String name;
    private String surname;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 300;
    private String alternateEmail;

    public Email(String name, String surname) {
        this.name = name;
        this.surname = surname;
        System.out.println("New Employee: " + name + " " + surname);
        department = this.setDepartment();
        password = this.createPassword(8);
        email = this.createEmail();
    }
    
    private String createEmail(){
        return name.toLowerCase() + surname.toLowerCase()+"@"+department.toLowerCase()+".company.com";
    }
    
    private String setDepartment(){
        System.out.println("Departments: \n1 Sales \n2 Finance \n3 iT \n4 None");
        boolean b = false;
        do{
            System.out.println("Select your department");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Finance";
                case 3:
                    return "IT";
                case 4:
                    return "None";
                    default:
                        System.out.println("Invalid choice...");
            }
        }while( !b );
        return null;
    }
    
    private String createPassword(int length){
        Random  r = new Random();
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nonCapitalLetters = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "!@#$%&*?";
        String numbers = "0123456789";
        String value = capitalLetters+nonCapitalLetters+symbols+numbers;
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password+value.charAt(r.nextInt(value.length()));
        }
        
        return password;
    }
    
    public void changePassword(){
        boolean b = false;
        do{
            System.out.println("Do you want to change your password ? (Y/N)");
            char choice = sc.next().charAt(0);
            if(choice == 'Y' || choice=='y'){
                b = true;
                System.out.println("Enter current password");
                String check = sc.next();
                if(check.equals(password)){
                    System.out.println("Enter new password");
                    password = sc.next();
                    System.out.println("Password changed successfully");
                } else{
                    System.out.println("Incorrect password.");
                }
            }else if(choice == 'N' || choice=='n'){
                b = true;
                System.out.println("Password changing cancelled");
            }else{
                System.out.println("Enter valid choice");
            }
        }while( !b);
    }
    
    public void setMailCapacity(){
        System.out.println("Current capacity = " + mailCapacity + "mb");
        System.out.println("Enter new mail capacity");
        mailCapacity = sc.nextInt();
        System.out.println("Mail capacity changed successfully");
    }
    
    public void setAlternateEmail(){
        System.out.println("Enter new alternate email:");
        alternateEmail = sc.next();
        System.out.println("Alternate email is set");
    }
    
    public void getInfo(){
        System.out.println("New: " + name + " " + surname);
        System.out.println("Department: " + department);
        System.out.println("Email: " + email);
        System.out.println("Current password: " + password);
        System.out.println("Email capacity: " + mailCapacity);
        System.out.println("Alternate email: " + alternateEmail);
    }
    
    public void writeDataIntoFile(){
        try(FileWriter fw = new FileWriter("C:\\Users\\Admin\\Desktop\\store.txt")){
            fw.write("Name: " + name);
            fw.append("\nSurname: " + surname);
            fw.append("\nDepartment: " + department);
            fw.append("\nEmail: " + email);
            fw.append("\nPassword: " + password);
            fw.append("\nEmail capacity: " + mailCapacity);
            fw.append("\nAlternate email: " + alternateEmail);
            System.out.println("Data stored...");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public void readDataFromFile(){
        try(FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\store.txt")){
            int i;
            while((i=reader.read()) != -1){
                System.out.print((char) i);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
    
}
