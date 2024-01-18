/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vishwajeet_dsa_lab2problem1;

/**
 *
 * @author Vishwajeet.Bharti
 */
import java.util.Scanner;

public class PayMoneyTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
        // Input the size of the transaction array
        System.out.println("Enter the size of the transaction array");
        int size = scanner.nextInt();

        // Input the values of the transaction array
        System.out.println("Enter the values of the array");
        int[] transactions = new int[size];
        for (int i = 0; i < size; i++) {
            transactions[i] = scanner.nextInt();
        }

        // Input the total number of targets
        System.out.println("Enter the total number of targets that need to be achieved");
        int numTargets = scanner.nextInt();

        // Process each target
        for (int targetNum = 1; targetNum <= numTargets; targetNum++) {
            // Input the value of the target
            System.out.println("Enter the value of target " + targetNum);
            int targetValue = scanner.nextInt();

            // Check if the target is achievable
            int currentSum = 0;
            int transactionsCount = 0;
            while (currentSum < targetValue && transactionsCount < size) {
                currentSum += transactions[transactionsCount];
                transactionsCount++;
            }

            // Display the result
            if (currentSum >= targetValue) {
                System.out.println("Target achieved after " + transactionsCount + " transactions");
            } else {
                System.out.println("Given target is not achieved");
            }
         }
        }
    }
}

//public class Vishwajeet_DSA_Lab2Problem1 {
//
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
//}
