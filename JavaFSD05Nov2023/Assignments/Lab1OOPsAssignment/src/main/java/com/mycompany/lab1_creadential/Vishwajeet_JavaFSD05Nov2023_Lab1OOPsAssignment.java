/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1_creadential;

import java.util.Scanner;

/**
 *
 * @author Vishwajeet.Bharti
 */
public class Vishwajeet_JavaFSD05Nov2023_Lab1OOPsAssignment {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        CredentialService credentialService = new CredentialService();

        while (true) {

        // Step 1: Input department
        System.out.println("Select Department:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");

        int departmentChoice = scanner.nextInt();
        if (departmentChoice == 0) {
                break;
            }
        String selectedDepartment = getDepartment(departmentChoice);

        // Step 2: Input first name and last name
        System.out.println("Enter First Name:");
        String firstName = scanner.next();

        System.out.println("Enter Last Name:");
        String lastName = scanner.next();

        // Step 3: Create Employee object
        Employee employee = new Employee(firstName, lastName);

        // Step 4: Generate credentials using CredentialService
        
        String email = credentialService.generateEmailAddress(employee, selectedDepartment, "abc");
        String password = credentialService.generatePassword();

        // Step 5: Display generated credentials
        credentialService.showCredentials(employee, email, password);
        }
    }

    private static String getDepartment(int choice) {
        switch (choice) {
            case 1:
                return "Technical";
            case 2:
                return "Admin";
            case 3:
                return "Human Resource";
            case 4:
                return "Legal";
            default:
                return "Unknown Department";
        }
    }
}
