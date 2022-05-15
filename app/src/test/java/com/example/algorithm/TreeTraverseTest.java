package com.example.algorithm;

import static org.junit.Assert.assertEquals;

import com.example.algorithm.bit.Manipulation;
import com.example.algorithm.tree.TreeTraverse;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TreeTraverseTest {

    @Test
    public void add() {
        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.buildTree();
    }

}