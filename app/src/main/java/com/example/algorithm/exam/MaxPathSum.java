package com.example.algorithm.exam;

import com.example.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// [-10,9,20,null,null,15,7]
public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // If is negative, we should not take this path, this is why we use zero to compare
        int leftValue = Math.max(dfs(node.left), 0);
        int rightValue = Math.max(dfs(node.right), 0);

        // the value which starts a new path from this node
        int currentValue = node.value + leftValue + rightValue;
        max = Math.max(max, currentValue);

        return node.value + Math.max(leftValue, rightValue);
    }
}
