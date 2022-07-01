package com.example.algorithm.exam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class RandomizedSet {
    Map<Integer, Integer> hashMap = new HashMap();
    List<Integer> list = new ArrayList();
    Random rand = new Random();

    /** Required Big(1) Time Complexity*/
    public boolean insert(int val) {
        if (hashMap.containsKey(val)){
            return false;
        }

        hashMap.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Required Big(1) Time Complexity*/
    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        }

        // Swap the last element to the element which ready to delete
        int lastElement = list.get(list.size() - 1);
        int idx = hashMap.get(val);
        list.set(idx, lastElement);
        // Save the index of last element to hashMap
        hashMap.put(lastElement, idx);

        list.remove(list.size() - 1);
        hashMap.remove(val);
        return true;
    }

    /** Required Big(1) Time Complexity*/
    // (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
