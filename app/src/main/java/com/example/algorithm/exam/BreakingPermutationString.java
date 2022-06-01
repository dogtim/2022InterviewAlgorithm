package com.example.algorithm.exam;

import android.icu.util.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// https://leetcode.com/problems/check-if-a-string-can-break-another-string/
public class BreakingPermutationString {

    public boolean checkIfCanBreak(String string1, String string2) {
        String sortedString1 = getSortedString(string1);
        String sortedString2 = getSortedString(string2);

        if(string1.length() == 0) {
            return false;
        }

        if (string1.length() == 1) {
            return true;
        }

        int relationship = 0; // 0 is none, 1 is ascending, 2 is decending

        for(int i = 0; i < sortedString1.length(); i++) {
            int _diff = sortedString1.charAt(i) - sortedString2.charAt(i);
            int _relationship = _diff > 0 ? 1 : 2;
            if(_diff != 0) {
                if (relationship == 0){
                    relationship = _diff > 0 ? 1 : 2;
                } else if (relationship != _relationship) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getSortedString(String input) {
        char[] string1chars = input.toCharArray();
        Arrays.sort(string1chars);
        return new String(string1chars);
    }
}
