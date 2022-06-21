package com.example.algorithm.exam.ranges;

import java.util.HashMap;

/*
    Key Point: The comparison of float should not use the '==', get more from below link
    1. https://howtodoinjava.com/java-examples/correctly-compare-float-double/
    2. https://stackoverflow.com/questions/1088216/whats-wrong-with-using-to-compare-floats-in-java
*/
public class FloatPointsInTheRanges implements PointsInTheRanges<Float> {

    HashMap<Float, Float> map = new HashMap<>();

    @Override
    public boolean isInRange(Float value) {
        for (Float key : map.keySet()) {
            if (key <= value && map.get(key) > value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addRange(Float start, Float end) {
        if (!map.containsKey(start)) {
            map.put(start, end);
        } else if (map.containsKey(start) && map.get(start) < end) {
            map.put(start, end);
        }
    }
}
