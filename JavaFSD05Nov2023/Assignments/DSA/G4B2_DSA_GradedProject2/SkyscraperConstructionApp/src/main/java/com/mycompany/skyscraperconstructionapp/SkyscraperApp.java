/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.skyscraperconstructionapp;

/**
 *
 * @author Vishwajeet.Bharti
 */
import java.util.Scanner;

public class SkyscraperApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {            
            try {

                // Input: Total number of floors in the building
                System.out.println("Enter the total number of floors in the building:");
                int n = scanner.nextInt();
                scanner.nextLine(); // consume newline

                int[] floors = new int[n];

                // Input: Sizes of floors given on each day
                for (int i = 0; i < n; i++) {
                    System.out.println("enter the floor size given on day : " + (i + 1));
                    floors[i] = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                }

                // Construction process analysis
                boolean[] visited = new boolean[n + 1];
                int max = n;
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    result.append("Day: ").append(i + 1).append("\n");
                    visited[floors[i]] = true;
                    if (visited[max]) {
                        while (visited[max]) {
                            result.append(max).append(" ");
                            max--;
                        }
                    }
                    result.append("\n");
                }

                // Output: Construction order
                System.out.println("The order of construction is as follows:");
                System.out.println(result);
            } catch (Exception ex) {
            }
        }
    }
}
