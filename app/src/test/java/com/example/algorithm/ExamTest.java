package com.example.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.example.algorithm.exam.BreakingPermutationString;
import com.example.algorithm.exam.EncodingString;
import com.example.algorithm.exam.EncodingStringMapping;
import com.example.algorithm.exam.EnemyBoard;
import com.example.algorithm.exam.GetMaxArea;
import com.example.algorithm.exam.MatrixRelationship;
import com.example.algorithm.exam.RandomizedSet;
import com.example.algorithm.exam.RemoveUselessParenthesis;
import com.example.algorithm.exam.ranges.FloatPointsInTheRanges;
import com.example.algorithm.exam.MakePalindromeString;
import com.example.algorithm.exam.PartOfAnagrams;
import com.example.algorithm.exam.RemoveAdjacentLetter;
import com.example.algorithm.exam.Sum3IntegerZero;
import com.example.algorithm.exam.TheNumOfChangingCharacter;
import com.example.algorithm.exam.TheSumCloseToTarget;
import com.example.algorithm.exam.ranges.IntegerPointsInTheRanges;

import org.junit.Test;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExamTest {

    @Test
    public void removeAdjacent_inorder() {
        RemoveAdjacentLetter letter = new RemoveAdjacentLetter();
        int result = letter.minimumValue("eedcc", new int[]{1, 2, 5, 3, 2});
        assertEquals(2 + 5 + 3, result);
        assertEquals(5, letter.minimumValue("aaa", new int[]{1, 2, 5}));
        assertEquals(21, letter.minimumValue("ababa", new int[]{1, 2, 5, 3, 10}));
        assertEquals(16, letter.minimumValue("baaab", new int[]{1, 2, 5, 3, 10}));
    }

    @Test
    public void makePalindrome() {
        MakePalindromeString p = new MakePalindromeString();
        assertEquals("aaa", p.result("_a_"));
        assertEquals("aaeeaa", p.result("aaee_a"));
        assertEquals("daaad", p.result("da__d"));
        assertEquals("NO", p.result("a_e"));
        assertEquals("NO", p.result("ef_fb"));
        assertEquals("NO", p.result("_dfdfe"));
    }

    @Test
    public void checkIfCanBreak() {
        BreakingPermutationString bp = new BreakingPermutationString();

        assertTrue(bp.checkIfCanBreak("abc", "xya"));
        assertTrue(bp.checkIfCanBreak("abrdft", "acvxyz"));
        assertFalse(bp.checkIfCanBreak("abe", "acd"));
        assertFalse(bp.checkIfCanBreak("bgdfrt", "acvxyz"));
    }

    @Test
    public void printEnemyBoard() {
        EnemyBoard enemyBoard = new EnemyBoard();
        enemyBoard.random(3, 3, 9);
    }

    @Test
    public void encoding() {
        EncodingString encodingString = new EncodingString();

        String input = "222";
        String encoded = encodingString.encode(input);
        String decoded = encodingString.decode(encoded);

        assertEquals(input, decoded);
    }

    @Test
    public void encoding1() {
        EncodingStringMapping encodingMapping = new EncodingStringMapping();
        assertEquals("r", encodingMapping.encode("00"));
        assertEquals("s", encodingMapping.encode("01"));
        assertEquals("zz1", encodingMapping.encode("001"));
        assertEquals("zz2", encodingMapping.encode("002"));
        assertEquals("001", encodingMapping.decode("zz1"));

        String input = "1001";
        assertEquals(input, encodingMapping.decode(encodingMapping.encode(input)));
    }

    @Test
    public void sumCloseToTarget() {
        TheSumCloseToTarget exam = new TheSumCloseToTarget();
        int[] array1 = {-1, 3, 8, 2, 9, 5};
        int[] array2 = {4, 1, 2, 10, 5, 20};
        int[] expected = {3, 20};
        assertArrayEquals(expected, exam.bruteForce(array1, array2, 24));
        assertArrayEquals(expected, exam.optimize(array1, array2, 24));
    }

    @Test
    public void PartOfAnagrams() {
        PartOfAnagrams exam = new PartOfAnagrams();
        String s = "eattea";
        String p = "tea";
        int[] array = {0, 3};
        List<Integer> result = exam.findAnagrams(s, p);

        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result.get(i).intValue());
        }
    }

    @Test
    public void Sum3IntegerZero() {
        // Input: nums = [-1,0,1,2,-1,-4]
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Sum3IntegerZero zero = new Sum3IntegerZero();
        List<List<Integer>> result = zero.findTheList(nums);

        // expected output:  [[-1,-1,2],[-1,0,1]]
        int[][] outputs = {{-1, -1, 2}, {-1, 0, 1}};

        for (int i = 0; i < outputs.length; i++) {
            for (int j = 0; j < outputs[0].length; j++) {
                assertEquals(outputs[i][j], (int) result.get(i).get(j));
            }
        }
    }

    @Test
    public void theNumOfChangingCharacter() {
        TheNumOfChangingCharacter zero = new TheNumOfChangingCharacter();
        assertEquals(1, zero.number("aaa"));
        assertEquals(0, zero.number("aa"));
        assertEquals(2, zero.number("bbaaabbb"));
        assertEquals(3, zero.number("bbaaaaaabbb"));
    }

    @Test
    public void bitCount() {
        TheNumOfChangingCharacter zero = new TheNumOfChangingCharacter();
        assertEquals(1, zero.number("aaa"));
        assertEquals(0, zero.number("aa"));
        assertEquals(2, zero.number("bbaaabbb"));
        assertEquals(3, zero.number("bbaaaaaabbb"));
    }

    @Test
    public void floatInTheRanges() {
        FloatPointsInTheRanges floatRanges = new FloatPointsInTheRanges();
        floatRanges.addRange(-1.1111f, 2.00001f);
        assertTrue(floatRanges.isInRange(-1.1111f));
        assertFalse(floatRanges.isInRange(-1.1112f));
        assertFalse(floatRanges.isInRange(2.00001f));

        floatRanges.addRange(-1.1111f, 3.00001f);
        assertTrue(floatRanges.isInRange(2.00001f));
    }

    @Test
    public void IntegerInTheRanges() {
        IntegerPointsInTheRanges intRanges = new IntegerPointsInTheRanges();
        intRanges.addRange(-1, 2);
        assertTrue(intRanges.isInRange(-1));
        assertFalse(intRanges.isInRange(-2));
        assertFalse(intRanges.isInRange(2));

        intRanges.addRange(0, intRanges.OFFSET / 4);
        assertTrue(intRanges.isInRange(0));
        assertFalse(intRanges.isInRange(-2));
    }

    @Test
    public void matrixRelation() {
        MatrixRelationship relationship = new MatrixRelationship();
        String[] relationships = {"1L2", "1L3", "2L3"};
        relationship.parse(3, relationships);
    }

    @Test
    public void randomizedSet() {
        RandomizedSet relationship = new RandomizedSet();
        assertTrue(relationship.insert(1));
        assertTrue(relationship.insert(3));
        assertTrue(relationship.insert(2));
        assertFalse(relationship.remove(4));
        assertFalse(relationship.insert(3));
        assertTrue(relationship.remove(3));
    }

    @Test
    public void removeUselessParenthesis() {
        RemoveUselessParenthesis remove = new RemoveUselessParenthesis();
        assertEquals("A", remove.filterString("((A"));
        assertEquals("(A)", remove.filterString("((A)"));
        assertEquals("ADDDDD()", remove.filterString("(ADDDDD()"));
        assertEquals("(AD)DDDD()", remove.filterString("(AD)))DDDD()"));
    }

    @Test
    public void maxArea() {
        GetMaxArea area = new GetMaxArea();
        int[][] testArray = {
                {0,1,0, 1},
                {1,1,0, 1},
                {1,1,0, 1},
                {0,1,0, 1}
        };

        int result = area.getMaxArea(testArray);
        assertEquals(6, result);
    }
}