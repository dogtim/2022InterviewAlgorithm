package com.example.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.algorithm.graph.BuildBinaryTree;
import com.example.algorithm.graph.Dijkstra;
import com.example.algorithm.tree.TreeNode;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GraphTest {

    /*
      -10
      /  \
     9,     20,
   /  \     /  \
 null,null  15, 7
    * */
    @Test
    public void build_graph_test() {

        Integer[] array = {-10,9,20,null,null,15,7};
        BuildBinaryTree tree = new BuildBinaryTree();
        TreeNode node = tree.build(array);
        assertEquals(-10, node.value);
        assertEquals(9, node.left.value);
        assertEquals(20, node.right.value);
        assertNull(node.left.left);
        assertNull(node.left.right);
        assertEquals(15, node.right.left.value);
        assertEquals(7, node.right.right.value);
    }

}