package generator;

import datastructures.Trie;

import java.util.ArrayList;
import java.util.List;

public class MelodyGenerator {

    private Trie melodyTrie;
    private SequenceCreator sequencer;
    private List<Integer> generatedNotes;

    public MelodyGenerator(int order) {
        this.melodyTrie = new Trie(order);
        this.sequencer = new SequenceCreator();
        this.generatedNotes = new ArrayList<>();
    }

    /**
     * Populates a trie based on training set and passes the resulting
     * trie to the sequenceCreator
     *
     *
     * @param trainingSet training set as a training set
     */
    public void createMelody(List<Integer> trainingSet) {
        populateTrie(trainingSet);
        this.generatedNotes = sequencer.createSequence(this.melodyTrie, trainingSet.size());
    }

    /**
     * returns the notes which are generated based on training set
     *
     * @return generated notes
     */
    public List<Integer> getGeneratedNotes() {
        return this.generatedNotes;
    }

    /**
     * Populates the trie where the generating of a new song in based on
     *
     * @param notes training set as a list
     */
    private void populateTrie(List<Integer> notes) {
        this.melodyTrie.insert(notes);
    }
}
