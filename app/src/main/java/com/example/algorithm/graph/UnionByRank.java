package com.example.algorithm.graph;

// This code refer to https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3878/ from Leetcodes explore
public class UnionByRank {
    private int[] root;
    // the height of root
    public int[] rank;

    public UnionByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
            /*
            * 0 <-> 0
            * 1 <-> 1
            * 2 <-> 2
            * ...
            * */
        }
    }

    // Time Complexity: log(root.length)
    public int find(int x) {
        while(x != root[x]) {
            x = root[x];
        }
        return x;
    }

    // Time Complexity: log(root.length)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    // Time Complexity: log(root.length)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}