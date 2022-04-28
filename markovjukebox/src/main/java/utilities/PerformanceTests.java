package utilities;

import datastructures.Trie;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PerformanceTests {

    private Random rand;
    private final int highInt;

    public PerformanceTests() {
        this.rand = new Random();
        this.highInt = 127;
    }

    public void populateTrieTest() {

        for (int i = 1; i <= 5; i++) {
            int seqSize = 1;
            for (int j = 0; j <= 5; j++) {
                seqSize = seqSize * 10;
                System.out.println("Order: " + i);
                System.out.println("Seq size: " + seqSize);
                populateAndSearchTrie(i, seqSize);
                System.out.println();
            }
        }
    }

    public void populateAndSearchTrie(int order, int sequenceSize) {
        Trie trie = new Trie(order, 128);
        List<Integer> notes = new ArrayList<>();

        for (int i = 0; i < sequenceSize; i++) {
            int randomInt = rand.nextInt(128);
            notes.add(randomInt);
        }

        long start = System.nanoTime();

        trie.insert(notes);

        long end = System.nanoTime();
        double total = (end - start) / 1000000.0;

        System.out.println("======================");
        System.out.println("Insert");
        System.out.println("------");
        System.out.println(new DecimalFormat("#.##").format(total) + " ms\n");

        List<List<Integer>> searchSequences = new ArrayList<>();

        for (int i = 0; i < sequenceSize; i++) {
            searchSequences.add(new ArrayList<>());
            for (int j = 0; j < order; j++) {
                int num = this.rand.nextInt(128);
                searchSequences.get(i).add(num);
            }
        }

        start = System.nanoTime();

        for (int i = 0; i < sequenceSize; i++) {
            trie.search(searchSequences.get(i));
        }

        end = System.nanoTime();
        total = (end - start) / 1000000.0;


        System.out.println("Search");
        System.out.println("------");
        System.out.println(new DecimalFormat("#.##").format(total) + " ms");
        System.out.println("======================");
    }
}
