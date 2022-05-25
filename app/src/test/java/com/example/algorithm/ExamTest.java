package com.example.algorithm;

import static org.junit.Assert.assertEquals;
import com.example.algorithm.exam.RemoveAdjacentLetter;
import org.junit.Test;

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

}