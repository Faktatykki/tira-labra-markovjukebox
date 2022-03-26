
import dataStructures.Trie;
import dataStructures.TrieNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestTrie {

    @Test
    public void firstOrderWorks() {
        Trie t = new Trie(1);
        int[] seq = {2, 3, 2, 5, 4, 6, 7, 2, 5};

        t.insert(seq);

        TrieNode[] childrenOfTwo = t.search(new int[]{2});
        TrieNode[] childrenOfSix = t.search(new int[]{6});
        TrieNode[] childrenOfSeven = t.search(new int[]{7});

        assertEquals(childrenOfTwo[3].getKey(), 3);
        assertEquals(childrenOfTwo[5].getKey(), 5);

        assertEquals(childrenOfSix[7].getKey(), 7);

        assertEquals(childrenOfSeven[2].getKey(), 2);
    }

    @Test
    public void secondOrderWorks() {
        Trie t = new Trie(2);
        int[] seq = {2, 3, 2, 5, 4, 6, 7, 2, 5, 8};

        t.insert(seq);

        TrieNode[] leafOfTwoFive = t.search(new int[]{2, 5});
        TrieNode[] leafOfTwoThree = t.search(new int[]{2, 3});
        TrieNode[] leafOfSixSeven = t.search(new int[]{6, 7});

        assertEquals(leafOfTwoFive[4].getKey(), 4);
        assertEquals(leafOfTwoFive[8].getKey(), 8);

        assertEquals(leafOfTwoThree[2].getKey(), 2);

        assertEquals(leafOfSixSeven[2].getKey(), 2);
    }

    @Test
    public void thirdOrderWorks() {
        Trie t = new Trie(3);
        int[] seq = {2, 3, 2, 5, 4, 6, 7, 2, 5, 4, 9};

        t.insert(seq);

        TrieNode[] leafOfTwoFiveFour = t.search(new int[]{2, 5, 4});
        TrieNode[] leafOfFiveFourSix = t.search(new int[]{5, 4, 6});
        TrieNode[] leafOfSixSevenTwo = t.search(new int[]{6, 7, 2});


        assertEquals(leafOfTwoFiveFour[6].getKey(), 6);
        assertEquals(leafOfTwoFiveFour[9].getKey(), 9);

        assertEquals(leafOfFiveFourSix[7].getKey(), 7);

        assertEquals(leafOfSixSevenTwo[5].getKey(), 5);
    }

    @Test
    public void fourthOrderWorks() {
        Trie t = new Trie(4);
        int[] seq = {2, 3, 2, 5, 4, 6, 7, 2, 5, 4, 6, 8};

        t.insert(seq);

        TrieNode[] leafOfTwoFiveFourSix = t.search(new int[]{2, 5, 4, 6});
        TrieNode[] leafOfFiveFourSixSeven = t.search(new int[]{5, 4, 6, 7});

        assertEquals(leafOfTwoFiveFourSix[7].getKey(), 7);
        assertEquals(leafOfTwoFiveFourSix[8].getKey(), 8);

        assertEquals(leafOfFiveFourSixSeven[2].getKey(), 2);
    }

    @Test
    public void trieIsEmptyIfTrainingSetIsShorterThanOrder() {
        Trie t = new Trie(4);
        int[] seq = {12, 13, 14};

        t.insert(seq);

        TrieNode[] firstOrder = t.search(new int[] {12});
        TrieNode[] secondOrder = t.search(new int[] {12, 13});
        TrieNode[] thirdOrder = t.search(new int[] {12, 13, 14});

        assertTrue(firstOrder == null);
        assertTrue(secondOrder == null);
        assertTrue(thirdOrder == null);
    }

    @Test
    public void trieBranchesAreNotEqualOrLessThanDegree() {
        Trie t = new Trie(1);
        int[] seq = {1, 2, 3};

        t.insert(seq);

        TrieNode[] n = t.search(new int[]{3});

        assertTrue(n == null);
    }

    @Test
    public void nodeFrequencyIncrements() {
        Trie t = new Trie(1);
        int[] seq = {2, 3, 2, 3, 4, 3, 5, 2, 4, 3};

        t.insert(seq);

        TrieNode[] afterTwo = t.search(new int[]{2});
        TrieNode[] afterFour = t.search(new int[]{4});
        TrieNode[] afterFive = t.search(new int[]{5});

        assertEquals(afterTwo[3].getFreq(), 2);
        assertEquals(afterFour[3].getFreq(), 2);
        assertEquals(afterFive[2].getFreq(), 1);
    }
}
