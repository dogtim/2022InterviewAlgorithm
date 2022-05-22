package com.example.algorithm.graph;

// This code refer to https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3878/ from Leetcodes explore
public class QuickUnion {
    private int[] root;

    public QuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // Time Complexity: root.length
    public int find(int x) {
        while(x != root[x]) {
            x = root[x];
        }
        return x;
    }

    // Time Complexity: root.length
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[y] = rootX;
        }
    }

    // Time Complexity: 1
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}