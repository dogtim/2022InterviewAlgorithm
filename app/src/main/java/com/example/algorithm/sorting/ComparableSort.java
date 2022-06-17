package com.example.algorithm.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Provide a demo codes for comparator
class ArraySort implements Comparator<int[]> {

    public int compare(int[] a, int[] b) {
        if(a[0] == b[0]) {
            return a[1] - b[1];
        }
        return a[0] - b[0];
    }

}

public class ComparableSort {
    public int[][] sortByArraySort(int[][] array) {
        Arrays.sort(array, new ArraySort());
        return array;
    }

    public Integer[] descendingSort(Integer[] array) {
        Arrays.sort(array, Collections.reverseOrder());
        return array;
    }
}
