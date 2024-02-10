/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binarysearchtreepairsum;

/**
 *
 * @author Vishwajeet.Bharti
 */
import java.util.Scanner;

public class BSTPairSum {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(30);
        bst.insert(50);
        bst.insert(70);
        bst.insert(20);
        bst.insert(60);
        bst.insert(40);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sum: ");
        int sum = scanner.nextInt();

        if (!bst.findPairWithSum(sum))
            System.out.println("Nodes with sum " + sum + " are not found.");
    }
}
