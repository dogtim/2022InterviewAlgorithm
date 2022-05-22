package com.example.algorithm.graph;

// This code refer to https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3878/ from Leetcodes explore
public class QuickFind {
    private int[] root;

    public QuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // Time Complexity: 1
    public int find(int x) {
        return root[x];
    }

    // Time Complexity: root.length
    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if(root[i] == root[y]) {
                    root[i] = rootX;
                }
            }
        }
    }

    // Time Complexity: 1
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}