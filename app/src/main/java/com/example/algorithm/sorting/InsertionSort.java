package com.example.algorithm.sorting;

import com.example.algorithm.Properties;

/*
 Reference: https://www.geeksforgeeks.org/insertion-sort/
 Time Complexity:
 Space Complexity:
 */
public class InsertionSort implements Properties {

    public void sort(int[] arr) {
        int length = arr.length;

        for (int i = 1; i < length; ++i) {
            int value = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
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
