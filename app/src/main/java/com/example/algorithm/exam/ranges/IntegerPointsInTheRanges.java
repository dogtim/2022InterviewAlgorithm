package com.example.algorithm.exam.ranges;

/*
    Key Point: Change the Float to Integer
    The interviewer wants to examine your optimization for the time complexity or space complexity from FloatPointsInTheRanges
*/
public class IntegerPointsInTheRanges implements PointsInTheRanges<Integer> {

    public final int OFFSET = 100000;

    // java.lang.OutOfMemoryError: Java heap space
    // https://stackoverflow.com/questions/19313294/java-lang-outofmemoryerror-java-heap-space-while-initialising-an-array
    private boolean[] rangeArray = new boolean[OFFSET*2];

    public IntegerPointsInTheRanges() {
        for(int i = 0; i < OFFSET * 2; i++) {
            rangeArray[i] = false;
        }
    }

    @Override
    public boolean isInRange(Integer value) {
        return rangeArray[value + OFFSET];
    }

    // The ranges from start and end are -OFFSET ~ OFFSET
    @Override
    public void addRange(Integer start, Integer end) {
        for(int i = start + OFFSET; i < OFFSET + end; i++) {
            rangeArray[i] = true;
        }
    }
}
