package com.example.algorithm.exam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.
// https://leetcode.com/problems/3sum/

/*
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
*/

public class Sum3IntegerZero {

    public List<List<Integer>> findTheList(int[] input) {
        // Sort for helping data handling
        Arrays.sort(input);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < input.length && input[i] <= 0; ++i) {
            if (i == 0 || input[i - 1] != input[i]) { // avoid pick up the duplicated number such as zero [-1, 0, 0, 0, 0, 0, 0, 1]
                sumOfThem(input, i, res);
            }
        }

        return res;
    }

    private void sumOfThem(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;

        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
}
