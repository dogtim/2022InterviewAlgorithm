package com.example.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.algorithm.graph.QuickFind;
import com.example.algorithm.sorting.BubbleSort;
import com.example.algorithm.sorting.HeapSort;
import com.example.algorithm.sorting.InsertionSort;
import com.example.algorithm.sorting.MergeSort;
import com.example.algorithm.sorting.QuickSort;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnionTest {

    @Test
    public void quick_find_test() {
        QuickFind quickFind = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        quickFind.union(1, 2);
        quickFind.union(2, 5);
        quickFind.union(5, 6);
        quickFind.union(6, 7);
        
        quickFind.union(3, 8);
        quickFind.union(8, 9);

        assertTrue(quickFind.connected(1, 5));
        assertTrue(quickFind.connected(5, 7));
        assertFalse(quickFind.connected(4, 9));

        // 1-2-5-6-7 3-8-9-4
        quickFind.union(9, 4);
        assertTrue(quickFind.connected(9, 4));
    }

}