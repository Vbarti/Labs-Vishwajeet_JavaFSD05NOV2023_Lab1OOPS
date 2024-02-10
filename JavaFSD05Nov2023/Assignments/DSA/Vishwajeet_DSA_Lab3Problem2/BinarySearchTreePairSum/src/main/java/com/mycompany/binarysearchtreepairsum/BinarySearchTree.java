/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreepairsum;

/**
 *
 * @author Vishwajeet.Bharti
 */

public class BinarySearchTree {
    private Node root;

    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRecursive(root.left, data);
        else if (data > root.data)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    public boolean findPairWithSum(int sum) {
        return findPairWithSum(root, root, sum);
    }

    private boolean findPairWithSum(Node root1, Node root2, int sum) {
        if (root1 == null || root2 == null)
            return false;

        int currentSum = root1.data + root2.data;
        if (currentSum == sum && root1 != root2) {
            System.out.println("Pair is (" + root1.data + ", " + root2.data + ")");
            return true;
        } else if (currentSum < sum)
            return findPairWithSum(root1.right, root2, sum) || findPairWithSum(root1, root2.right, sum);
        else
            return findPairWithSum(root1.left, root2, sum) || findPairWithSum(root1, root2.left, sum);
    }
}
