package utilities;

import datastructures.NoteObject;
import datastructures.Trie;
import generator.GeneratorService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerformanceTests {

    private Random rand;
    private final int highInt;
    private MidiHandler md;

    public PerformanceTests() {
        this.rand = new Random();
        this.highInt = 127;
        this.md = new MidiHandler();
    }

    /**
     * Tests how algorithm performs when inserting and searching to/from trie data structure 10, 100, 1000, 10000, 100000 elements
     * with Markov chain orders 1-5
     */
    public void populateTrieAndGenerateSongTest() {

        for (int i = 1; i <= 5; i++) {
            int seqSize = 1;
            for (int j = 0; j <= 5; j++) {
                seqSize = seqSize * 10;
                System.out.println("Order: " + i);
                System.out.println("Seq size: " + seqSize);
                populateAndSearchTrie(i, seqSize);

                if (seqSize > 100000) {
                    continue;
                }

                generatingSongTest(i, seqSize);


                System.out.println();
            }
        }
    }

    /**
     * Populates trie with random elements of values 0-128 and then searches from trie with randomly generated sequences
     * according to order of Markov chain and given sequence size
     *
     * @param order of Markov chain (1-5)
     * @param sequenceSize 10 || 100 || 1000 || 10000 || 100000
     */
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

    /**
     * Tests the actual generating of a new song via GeneratorService. Doesn't use MarkovGenerator
     * service class since no proper midi-files wasn't found.
     *
     * @param order of Markov chain
     * @param sequenceSize size of a training set
     */
    public void generatingSongTest(int order, int sequenceSize) {
        List<NoteObject> trainingSet = new ArrayList<>();

        for (int i = 0; i < sequenceSize; i++) {
            int pitch = rand.nextInt(128);
            int rhythm = rand.nextInt(128);
            int duration = rand.nextInt(128);
            int dynamic = rand.nextInt(128);

            NoteObject note = new NoteObject(pitch, rhythm, duration, dynamic);

            trainingSet.add(note);
        }

        long start = System.nanoTime();

        GeneratorService gs = new GeneratorService(order, trainingSet);
        List<NoteObject> generatedSong = gs.generate();

        md.arrayToMidi(generatedSong);

        long end = System.nanoTime();
        double total = (end - start) / 1000000.0;

        System.out.println("Generating");
        System.out.println("----------");
        System.out.println(new DecimalFormat("#.##").format(total) + " ms");
        System.out.println("====================");

    }


}
