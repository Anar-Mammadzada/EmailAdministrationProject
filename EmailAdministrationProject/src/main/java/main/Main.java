/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import email.Email;
import java.util.Scanner;

/**
 *
 * @author Anar
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter surname:");
        String surname = sc.next();
        
        Email e = new Email(name, surname);
        
        
        int choice = -1;
        do{
            System.out.println("\n-----------\nEnter your choice\n1.Show info\n2.Change password\n3.Change email capacity"
                    + "\n4.Set alternate email\n5.Store data in file\n6.Display data from file\n7Exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    e.getInfo();
                    break;
                case 2:
                    e.changePassword();;
                    break;
                case 3:
                    e.setMailCapacity();
                    break;
                case 4:
                    e.setAlternateEmail();
                    break;
                case 5:
                    e.writeDataIntoFile();
                    break;
                case 6:
                    e.readDataFromFile();
                    break;
                case 7:
                    System.out.println("Thank you for using application");
                    break;
                    default:
                        System.out.println("Incorrect choice ! \n Enter valid choice again");
            }
        }while(choice != 7);
    }
}
