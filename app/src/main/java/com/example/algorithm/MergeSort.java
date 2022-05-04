package com.example.algorithm;

/*
 Reference: https://www.geeksforgeeks.org/merge-sort/?ref=lbp
 Time Complexity:
 Space Complexity:
 */
class MergeSort implements Properites {

    private void merge(int arr[], int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        /* Create temp arrays */
        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftArraySize; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < rightArraySize; ++j)
            rightArray[j] = arr[middle + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of leftArray[] if any */
        while (i < leftArraySize) {
            arr[k++] = leftArray[i++];
        }

        /* Copy remaining elements of rightArray[] if any */
        while (j < rightArraySize) {
            arr[k++] = rightArray[j++];
        }
    }

    private void sort(int arr[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;

            // Sort first and second halves
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public void testCase1() {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    @Override
    public String averageTimeComplexity() {
        return "nlog(n)";
    }

    @Override
    public String worstTimeComplexity() {
        return "nlog(n)";
    }

    @Override
    public String spaceComplexity() {
        return "n";
    }
}
/* This code is contributed by Rajat Mishra */

