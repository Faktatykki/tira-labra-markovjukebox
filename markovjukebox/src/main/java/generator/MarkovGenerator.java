package generator;

import utilities.*;
import dataStructures.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MarkovGenerator {

    private int order;
    private Trie trie;
    private List<Integer> queue;
    private List<Integer> generatedNotes;
    private MidiHandler midiHandler;


    public MarkovGenerator(int order) {
        this.order = order;
        this.trie = new Trie(order);
        this.queue = new ArrayList();
        this.generatedNotes = new ArrayList<>();
        this.midiHandler = new MidiHandler();
    }

    /**
     * Goes through the process of generating a new song based on input:
     *
     * Reads input
     * Creates sequences based on input
     * outputs a new midi-file of generated notes
     */
    public void generateSong() {
        readTrainingSet();
        createSequence();
        midiHandler.outputScoreToMidi(this.generatedNotes);
    }

    /**
     * Reads the given training data and inserts it to trie
     */
    public void readTrainingSet() {
        ArrayList<Integer> trainingSet = midiHandler.getTrainingData();
        this.trie.insert(trainingSet);
    }

    /**
     * Generates a song based on inserted nodes of trie and nodes weights
     * For now generates only 100 notes
     */
    public void createSequence() {
        for (int i = 0; i < 100; i++) {
            TrieNode[] children = this.trie.search(this.queue);

            if (children == null) {
                this.queue.clear();
                continue;
            }

            int pickedChild = getRandom(children);

            this.queue.add(pickedChild);

            this.generatedNotes.add(pickedChild);
            //System.out.println("generated notes: " + this.generatedNotes);

            if (queue.size() == order + 1) {
                queue.remove(0);
                //System.out.println("markov chain: " + this.queue);
            }
        }
    }

    /**
     * Chooses randomly next element from the children nodes of sequence, considering weights
     * of nodes
     *
     * @param children
     */
    public int getRandom(TrieNode[] children) {
        Random rand = new Random();

        List<Integer> weightedList = getWeightedList(children);
        int randomIndex = rand.nextInt(weightedList.size());
        int pickedChild = weightedList.get(randomIndex);

        return pickedChild;
    }

    /**
     * Creates a list based on frequencies of certain node's children seen in Trie
     *
     * @param children
     * @return weighted list
     */
    public List<Integer> getWeightedList(TrieNode[] children) {
        List<Integer> weightedList = new ArrayList<>();

        for (int i = 0; i < children.length; i++) {
            if (children[i] == null) {
                continue;
            }

            TrieNode node = children[i];
            int nodeWeight = node.getFreq();

            for (int j = 0; j < nodeWeight; j++) {
                weightedList.add(node.getKey());
            }
        }

        return weightedList;
    }


}
