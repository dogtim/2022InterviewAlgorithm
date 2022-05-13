package com.example.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.example.algorithm.bit.Manipulation;
import com.example.algorithm.sorting.BubbleSort;
import com.example.algorithm.sorting.HeapSort;
import com.example.algorithm.sorting.MergeSort;
import com.example.algorithm.sorting.QuickSort;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BitManipulationUnitTest {

    @Test
    public void add() {
        // https://leetcode.com/problems/sum-of-two-integers/
        Manipulation bitManipulation = new Manipulation();
        int a = 5;
        int b = 7;
        int result = bitManipulation.add(a, b);
        assertEquals(a + b, result);
    }

}