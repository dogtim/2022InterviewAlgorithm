package com.example.algorithm.tree;

public class TreeNode {
    public int value;
    public TreeNode left, right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
           this(value, null, null);
    }
}
