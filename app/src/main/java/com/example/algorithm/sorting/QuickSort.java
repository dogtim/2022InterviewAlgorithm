package com.example.algorithm.sorting;

import com.example.algorithm.Properties;

/*
 Reference: https://www.geeksforgeeks.org/quick-sort/
 Time Complexity:
 Space Complexity:
 */
public class QuickSort implements Properties {
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = low - 1;

        for(int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sort(int[] arr, int left, int right) {
        if (left < right) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, left, right);

            // Separately sort elements before partition and after partition
            sort(arr, left, pi - 1);
            sort(arr, pi + 1, right);
        }
    }

    @Override
    public String averageTimeComplexity() {
        return "nlog(n)";
    }

    @Override
    public String worstTimeComplexity() {
        return "n^2";
    }

    @Override
    public String spaceComplexity() {
        return "log(n)";
    }
}
