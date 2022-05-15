package com.example.algorithm.tree;

import org.w3c.dom.Node;

import java.util.LinkedList;

// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
// This class implement above contents, help me to practice the common traversal of tree
// There are three fundamental Tree Traversals, Inorder, Preorder and Postorder
public class TreeTraverse {

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    public void postorder(TreeNode node, LinkedList<Integer> visitedSequence) {
        if (node == null)
            return;

        // first recur on left subtree
        postorder(node.left, visitedSequence);

        // then recur on right subtree
        postorder(node.right, visitedSequence);

        // now deal with the node
        visitedSequence.add(node.value);
    }

    /* Given a binary tree, print its nodes in inorder*/
    public void inorder(TreeNode node, LinkedList<Integer> visitedSequence) {
        if (node == null)
            return;

        /* first recur on left child */
        inorder(node.left, visitedSequence);

        visitedSequence.add(node.value);

        /* now recur on right child */
        inorder(node.right, visitedSequence);
    }

    /* Given a binary tree, print its nodes in preorder*/
    public void preorder(TreeNode node, LinkedList<Integer> visitedSequence) {
        if (node == null)
            return;

        /* first print data of node */
        visitedSequence.add(node.value);

        /* then recur on left subtree */
        preorder(node.left, visitedSequence);

        /* now recur on right subtree */
        preorder(node.right, visitedSequence);
    }
}
