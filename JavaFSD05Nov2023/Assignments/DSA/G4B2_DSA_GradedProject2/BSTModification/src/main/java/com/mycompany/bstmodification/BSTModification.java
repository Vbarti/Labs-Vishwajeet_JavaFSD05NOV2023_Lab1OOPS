/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bstmodification;

/**
 *
 * @author Vishwajeet.Bharti
 */
import java.util.Stack;

public class BSTModification {

    static Node headNode = null;
    static Node prevNode = null;

    static void BSTToSkewed(Node curr, int k) {
        if (curr == null) {
            return;
        }

        if (k == 1) {
            BSTToSkewed(curr.right, k);
        } else {
            BSTToSkewed(curr.left, k);
        }

        Node leftSubTree = curr.left;
        Node rightSubTree = curr.right;

        if (headNode == null) {
            headNode = curr;
            prevNode = curr;
        } else {
            prevNode.right = curr;
            curr.left = null;
            prevNode = curr;
        }

        if (k == 1) {
            BSTToSkewed(leftSubTree, k);
        } else {
            BSTToSkewed(rightSubTree, k);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(40);
        root.right = new Node(60);
        root.right.left = new Node(55);

        int k = 0; // For increasing order

        BSTToSkewed(root, k);

        

        // Traversing the skewed tree
        while (headNode != null) {
            System.out.print(headNode.data + " ");
            headNode = headNode.right;
        }
        System.out.println();
    }
}

