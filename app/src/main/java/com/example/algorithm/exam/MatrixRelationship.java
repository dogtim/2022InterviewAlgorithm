package com.example.algorithm.exam;

import com.example.algorithm.graph.QuickFind;

import java.util.ArrayList;
import java.util.HashMap;

public class MatrixRelationship {
    // Relationship is an array that describe the relationship between numbers

    // Case 1:
    // Assume the relationship array is ["1L2", "3R1", "2L3"]
    // the output should be [1, 2, 3]
    // 1L2 means 1 is the left of 2
    // 3R1 means 3 is the right of 1, in other words, is equal to 1L3

    // Case 2:
    // You should return [] when the rules conflict for each other
    // Assume the relationship array is ["1L2", "2L1"]
    // return [] in this case

    // Case 3:
    // There are unclear relationship such as
    // Assume the relationship array is ["1L2", "3R1"], you can see it as ["1L2", "1L3"]
    // you can return the [1, 2, 3] or [1, 3, 2], both of them are correct answer

    public int[] parse(int n, String[] relationships) {
        int[] result = new int[n];
        GraphBuilder graphBuilder = new GraphBuilder(n);

        for (String r: relationships) {
            if (r.indexOf('L') != -1) {
                int a = Integer.parseInt(r.substring(0, r.indexOf('L')));
                int b = Integer.parseInt(r.substring(r.indexOf('L')+1, r.length()));
                System.out.println("a " + a + ", b " + b);
                graphBuilder.union(a, b);
            }
        }
        // The value -1 means handled
        int[] values = graphBuilder.root;
        HashMap<Integer, ArrayList> graphs = new HashMap<>();

        for(int i = 1; i < values.length; i ++) {
            // TODO
        }

        return result;
    }

}

class GraphBuilder {
    int[] root;

    public GraphBuilder(int size) {
        // +1 for convenient calculate the result
        root = new int[size + 1];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // Time Complexity: n
    public int findRoot(int x) {
        while(x != root[x]) {
            x = root[x];
        }
        return x;
    }

    // Time Complexity: root.length
    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];
        if (rootX != rootY) {
            root[y] = rootX;
        }
    }

}