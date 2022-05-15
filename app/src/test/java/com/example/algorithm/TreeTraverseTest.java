package com.example.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
public class TreeTraverseTest {
    TreeNode node;
    TreeTraverse treeTraverse;
    LinkedList orderList;

    @Before
    public void setUp() throws Exception {
        node = buildTree();
        treeTraverse = new TreeTraverse();
        orderList = new LinkedList<Integer>();
    }

    @Test
    public void tree_traverse_inorder() {
        treeTraverse.inorder(node, orderList);
        Integer[] arr = {4, 2, 5, 1, 3};
        assertArrayEquals(buildExpectedArray(arr).toArray(), orderList.toArray());
    }

    @Test
    public void tree_traverse_preorder() {
        treeTraverse.preorder(node, orderList);
        Integer[] arr = {1, 2, 4, 5, 3};
        assertArrayEquals(buildExpectedArray(arr).toArray(), orderList.toArray());
    }

    @Test
    public void tree_traverse_postorder() {
        treeTraverse.postorder(node, orderList);
        Integer[] arr = {4, 5, 2, 3, 1};
        assertArrayEquals(buildExpectedArray(arr).toArray(), orderList.toArray());
    }

    private LinkedList<Integer> buildExpectedArray(Integer[] strArr) {
        List<Integer> list = Arrays.asList(strArr);
        return new LinkedList<Integer>(list);
    }

    /* Build the tree
          1
         / \
        2   3
       / \
      4   5
     */
    public TreeNode buildTree() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        return tree;
    }
}