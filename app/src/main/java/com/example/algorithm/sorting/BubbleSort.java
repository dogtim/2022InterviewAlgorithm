package com.example.algorithm.sorting;

import com.example.algorithm.Properties;

/*
 Reference: https://www.geeksforgeeks.org/bubble-sort/
 Time Complexity:
 Space Complexity:
 */
public class BubbleSort implements Properties {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String averageTimeComplexity() {
        return "n^2";
    }

    @Override
    public String worstTimeComplexity() {
        return "n^2";
    }

    @Override
    public String spaceComplexity() {
        return "1";
    }
}
