package com.example.algorithm.bit;

public class Manipulation {

    public int add(int a, int b) {
        int x = Math.abs(a), y = Math.abs(b);

        if (x < y) return add(b, a);

        int sign = a > 0 ? 1 : -1;

        if (a * b >= 0) {
            while (y != 0) {
                int answer = x ^ y;
                int carry = (x & y) << 1;
                x = answer;
                y = carry;
            }
        } else {
            while (y != 0) {
                int answer = x ^ y;
                int borrow = ((~x) & y) << 1;
                x = answer;
                y = borrow;
            }

        }

        return x * sign;
    }
}
