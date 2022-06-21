package com.example.algorithm.exam.ranges;

import java.util.HashMap;

public interface PointsInTheRanges<T> {
    boolean isInRange(T value);
    void addRange(T start, T end);
}

