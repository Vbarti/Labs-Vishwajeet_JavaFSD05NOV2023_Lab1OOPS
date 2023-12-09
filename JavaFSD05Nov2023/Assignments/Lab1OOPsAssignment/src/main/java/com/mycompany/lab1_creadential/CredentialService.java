/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_creadential;

import java.util.Random;

/**
 *
 * @author Vishwajeet.Bharti
 */
public class CredentialService {
    private static final String[] DEPARTMENTS = {"Technical", "Admin", "HumanResource", "Legal"};

    public String generateEmailAddress(Employee employee, String department, String company) {
        return employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() +
                "@" + department.toLowerCase() + "." + company.toLowerCase() + ".com";
    }

    public String generatePassword() {
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-=_+[]{}|;:'\",.<>?/";

        String allChars = upperChars + lowerChars + numbers + specialChars;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upperChars.charAt(random.nextInt(upperChars.length())));
        password.append(lowerChars.charAt(random.nextInt(lowerChars.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        for (int i = 4; i < 12; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }

    public void showCredentials(Employee employee, String email, String password) {
        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }
}
