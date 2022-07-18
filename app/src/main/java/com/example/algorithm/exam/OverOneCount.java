package com.example.algorithm.exam;

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/solution/
public class OverOneCount {
    // Input: [-1, 2, 3, 5]
    // Output: 2, because 2 + (-1) >= 1

    // Input: [-1, -2, 3, 5]
    // Output: 4, because 4 + (-1) = 3, 3 + (-2) = 1, so on..

    public int count(int[] array) {

        int min = 0;
        int total = 0;

        for (int num: array) {
            total += num;
            min = Math.min(min, total);
        }

        return -min + 1;
    }

}
