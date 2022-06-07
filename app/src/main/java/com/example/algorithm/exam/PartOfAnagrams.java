package com.example.algorithm.exam;

import com.example.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Giving two Strings s and String p, return the output array that responde the indexes which is start for forming the Anagrams

for example: s = “eattea”, p = “tea”
output: [0, 3]
index o start “eat” is one of the anagram to p“tea”
index 3 start “eat” is one of the anagram to p“tea”

for example: s = “ollo eeool”, p = “lo”
output: [0, 2, 8]
index o start “ol” is one of the anagram to p“lo”
index 2 start “lo” is one of the anagram to p“lo”
index 8 start “ol” is one of the anagram to p“lo”

https://leetcode.com/problems/find-all-anagrams-in-a-string/solution/
* */
public class PartOfAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length(), pLength = p.length();
        if (pLength > sLength) return new ArrayList();

        int [] pCount = new int[26];
        int [] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[(ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        for (int i = 0; i < sLength; ++i) {
            sCount[s.charAt(i) - 'a']++;

            // remove one letter, from the left side of the window
            if (i >= pLength) {
                sCount[s.charAt(i - pLength) - 'a']--;
            }
            // compare array in the sliding window, with the reference array
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - pLength + 1);
            }
        }
        return output;
    }

}
