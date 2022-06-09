package com.example.algorithm.graph;

import com.example.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// [-10,9,20,null,null,15,7]
public class BuildBinaryTree {

    public TreeNode build(Integer[] array) {
        int length = array.length;
        if (length <= 0) {
            return null;
        }

        int arrayIndex = 0;
        TreeNode node = new TreeNode(array[arrayIndex]);
        TreeNode result = node;
        arrayIndex++;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode currNode = queue.poll();
                if (arrayIndex < length) {
                    Integer integer = array[arrayIndex];
                    if (integer == null) {
                        currNode.left = null;
                    } else {
                        currNode.left = new TreeNode(array[arrayIndex]);
                        queue.add(currNode.left);
                    }
                    arrayIndex++;
                }
                System.out.println("value " + currNode.value + ",left arrayIndex: " + arrayIndex);
                if (arrayIndex < length) {
                    Integer integer = array[arrayIndex];
                    if (integer == null) {
                        currNode.right = null;
                    } else {
                        currNode.right = new TreeNode(array[arrayIndex]);
                        queue.add(currNode.right);
                    }
                    arrayIndex++;
                }
                System.out.println("value " + currNode.value + ",right arrayIndex: " + arrayIndex);
            }
        }
        return result;
    }

}