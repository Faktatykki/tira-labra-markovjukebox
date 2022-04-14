import datastructures.NoteObject;
import datastructures.Trie;
import generator.MarkovGenerator;

import java.util.ArrayList;
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
        System.out.println("Sequence of 100000, order of 1");
        populateTrie(1, 100000);
        System.out.println();
        System.out.println("Sequence of 100000, order of 2");
        populateTrie(2, 100000);
        System.out.println();
        System.out.println("Sequence of 100000, order of 3");
        populateTrie(3, 100000);
        System.out.println();
        System.out.println("Sequence of 100000, order of 4");
        populateTrie(4, 100000);
        System.out.println();
        System.out.println("Sequence of 100000, order of 5");
        populateTrie(5, 100000);
        System.out.println();
        System.out.println("Sequence of 100000, order of 6");
        populateTrie(6, 100000);
        System.out.println();
        System.out.println("Sequence of 100000, order of 7");
        populateTrie(7, 100000);
    }

    public void populateTrie(int order, int sequenceSize) {
        Trie trie = new Trie(order, 128);
        List<Integer> notes = new ArrayList<>();

        for (int i = 0; i < sequenceSize; i++) {
            int randomInt = rand.nextInt(highInt);
            notes.add(randomInt);
        }

        long start = System.currentTimeMillis();

        trie.insert(notes);

        long end = System.currentTimeMillis();
        long total = end - start;

        System.out.println(total + " ms");
    }
}
