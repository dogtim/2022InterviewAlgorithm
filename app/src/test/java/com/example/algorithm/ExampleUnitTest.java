package com.example.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.algorithm.sorting.BubbleSort;
import com.example.algorithm.sorting.HeapSort;
import com.example.algorithm.sorting.InsertionSort;
import com.example.algorithm.sorting.MergeSort;
import com.example.algorithm.sorting.QuickSort;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void merge_sort() {
        int[] arr = {12, 11, 13, 5, 6, 7};

        MergeSort sort = new MergeSort();
        sort.sort(arr, 0, arr.length - 1);
        int[] expectedArr = {5, 6, 7, 11, 12, 13};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void quick_sort() {
        int[] arr = {12, 11, 13, 5, 6, 7};

        QuickSort sort = new QuickSort();
        sort.sort(arr, 0, arr.length - 1);
        int[] expectedArr = {5, 6, 7, 11, 12, 13};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void bubble_sort() {
        int[] arr = {12, 11, 13, 5, 6, 7};

        BubbleSort sort = new BubbleSort();
        sort.sort(arr);
        int[] expectedArr = {5, 6, 7, 11, 12, 13};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void heap_sort() {
        int[] arr = {12, 11, 13, 5, 6, 7};

        HeapSort sort = new HeapSort();
        sort.sort(arr);
        int[] expectedArr = {5, 6, 7, 11, 12, 13};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void insertion_sort() {
        int[] arr = {12, 11, 13, 5, 6, 7};

        InsertionSort sort = new InsertionSort();
        sort.sort(arr);
        int[] expectedArr = {5, 6, 7, 11, 12, 13};
        assertArrayEquals(expectedArr, arr);
    }
}