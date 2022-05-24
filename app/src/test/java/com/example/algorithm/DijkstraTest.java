package com.example.algorithm;

import static org.junit.Assert.assertArrayEquals;

import com.example.algorithm.graph.Dijkstra;
import com.example.algorithm.tree.TreeNode;
import com.example.algorithm.tree.TreeTraverse;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DijkstraTest {

    @Test
    public void tree_traverse_inorder() {
        /* Let us create the example graph discussed above */
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        Dijkstra tree = new Dijkstra();
        int [] dist = tree.dijkstra(graph, 0);

        for (int i = 0; i < graph.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

}