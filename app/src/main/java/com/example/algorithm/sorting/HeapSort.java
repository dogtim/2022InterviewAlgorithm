package com.example.algorithm.sorting;

import com.example.algorithm.Properites;

/*
 Reference: https://www.geeksforgeeks.org/heap-sort/, http://www.btechsmartclass.com/data_structures/heap-sort.html
    Step 1 - Construct a Binary Tree with given list of Elements.
    Step 2 - Transform the Binary Tree into MAX Heap.
    Step 3 - Delete the root element from Min Heap using Heapify method.
    Step 4 - Put the deleted element into the Sorted list.
    Step 5 - Repeat the same until Min Heap becomes empty.
    Step 6 - Display the sorted list
 */
public class HeapSort implements Properites {

    public void sort(int[] arr) {
        int length = arr.length;

        // Step 1: Build the Binary Tree
        for(int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        // One by one extract an element from heap
        for (int i = length - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largestIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        // If left child is larger than root
        if (leftIndex < n && arr[leftIndex] > arr[largestIndex]) {
            largestIndex = leftIndex;
        }
        if (rightIndex < n && arr[rightIndex] > arr[largestIndex]) {
            largestIndex = rightIndex;
        }
        if (largestIndex != i) {
            int swap = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largestIndex);
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
