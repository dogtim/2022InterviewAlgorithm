package com.example.algorithm.tree;

import org.w3c.dom.Node;

// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
// This class implement above contents, help me to practice the common traversal of tree
// There are three fundamental Tree Traversals, Inorder, Preorder and Postorder
public class TreeTraverse {

    // Build the tree
    public void buildTree() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println(
                "Preorder traversal of binary tree is ");
        printPreorder(tree);

        System.out.println(
                "\nInorder traversal of binary tree is ");
        printInorder(tree);

        System.out.println(
                "\nPostorder traversal of binary tree is ");
        printPostorder(tree);
    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    private void printPostorder(TreeNode node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.value + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(TreeNode node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.value + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(TreeNode node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.value + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }
}

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}