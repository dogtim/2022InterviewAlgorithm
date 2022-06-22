package com.example.algorithm.exam;

public class MatrixRelationship {
    // Relationship is an array that describe the relationship between numbers

    // Case 1:
    // Assume the relationship array is ["1L2", "3R1", "2L3"]
    // the output should be [1, 2, 3]
    // 1L2 means 1 is the left of 2
    // 3R1 means 3 is the right of 1, in other words, is equal to 1L3

    // Case 2:
    // You should return [] when the rules conflict for each other
    // Assume the relationship array is ["1L2", "2L1"]
    // return [] in this case

    // Case 3:
    // There are unclear relationship such as
    // Assume the relationship array is ["1L2", "3R1"]
    // you can return the [1, 2, 3] or [1, 3, 2], both of them are correct answer
    public int[] parse(int n, String[] relationship) {
        int[] result = new int[n];
        return result;
    }

}
