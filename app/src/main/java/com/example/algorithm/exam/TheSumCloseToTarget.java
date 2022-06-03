package com.example.algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TheSumCloseToTarget {
/*
Give two lists of a1 and a2 and assume they gave the same length.
target is to find one of a1 plus one of a2 that has the sum closethe  to target.

example:
a1 = [-1, 3, 8, 2, 9, 5]
a2 = [4, 1, 2, 10, 5, 20]
a_target = 24
# closest_sum_pair(a1, a2, a_target) should return (5, 20) or (3, 20).

*/

    public int[] optimize(int[] array1, int[] array2, int target) {
        // a1 = [-1, 3, 8, 2, 9, 5]
        // a2 = [4, 1, 2, 10, 5, 20]

        // Sorted
        // a1 = [-1, 2, 3, 5  8, 9]
        // a2 = [1, 2, 4, 5, 10, 20]

        // sum = [0, 4, 7, 10, 18, 29]
        // To find the close one 24, index
        final int length = array1.length;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int diff = Integer.MAX_VALUE;
        int[] result = new int[2];

        int left = 0, right = length - 1;
        while (left < length && right >= 0) {
            int _diff = Math.abs(array1[left] + array2[right] - target);
            if (Math.abs(_diff) < diff) {
                result[0] = array1[left];
                result[1] = array2[right];
                diff = _diff;
            }
            if (array1[left] + array2[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public int[] bruteForce(int[] array1, int[] array2, int target) {
        // length should over 0.
        if (array1.length == 0) {
            return null;
        }

        int diff = Integer.MAX_VALUE;
        int[] result = new int[2];
        result[0] = array1[0];
        result[1] = array2[0];
        /// a1 = [-1, 3, 8, 2, 9, 5]
        /// a2 = [4, 1, 2, 10, 5, 20]
        /// a_target = 24
        for (int j : array1) {
            for (int k : array2) {
                int _diff = Math.min(diff, Math.abs(j + k - target));

                if (_diff != diff) {
                    result[0] = j;
                    result[1] = k;
                }

                diff = _diff;
            }
        }

        return result;
    }
}
