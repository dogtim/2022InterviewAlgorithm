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
import com.example.algorithm.exam.MakePalindromeString;
import com.example.algorithm.exam.PartOfAnagrams;
import com.example.algorithm.exam.RemoveAdjacentLetter;
import com.example.algorithm.exam.TheSumCloseToTarget;

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
        int result = letter.minimumValue("eedcc", new int[] {1, 2, 5, 3, 2});
        assertEquals(2+5+3, result);
        assertEquals(5, letter.minimumValue("aaa", new int[] {1, 2, 5}));
        assertEquals(21, letter.minimumValue("ababa", new int[] {1, 2, 5, 3, 10}));
        assertEquals(16, letter.minimumValue("baaab", new int[] {1, 2, 5, 3, 10}));
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

        assertTrue(bp.checkIfCanBreak("abc","xya"));
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
        int[] array2 = { 4, 1, 2, 10, 5, 20};
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
        for(int i = 0; i < array.length; i++) {
            assertEquals(array[i], result.get(i).intValue());
        }
    }

}