package com.example.algorithm.exam;

// https://leetcode.com/problems/number-of-1-bits/
public class BitCount {

    public int count(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1; // <----- unsigned problem do not use the >>
        }
        return count;
    }

}
