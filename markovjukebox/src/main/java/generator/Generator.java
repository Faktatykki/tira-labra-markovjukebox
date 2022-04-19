package generator;

import datastructures.NoteObject;
import datastructures.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

    private Trie trie;
    private SequenceCreator sequencer;
    private List<Integer> generated;
    private String component;

    public Generator(int order, int range, String component) {
        this.trie = new Trie(order, range);
        this.sequencer = new SequenceCreator();
        this.generated = new ArrayList<>();
        this.component = component;
    }

    /**
     * Populates a trie based on training set and passes the resulting
     * trie to the sequenceCreator
     *
     * @param trainingSet training set as a training set
     */
    public List<Integer> generate(List<NoteObject> trainingSet) {
        List<Integer> notes = parse(trainingSet);

        populateTrie(notes);

        this.generated = sequencer.createSequence(this.trie, notes.size());

        return this.generated;
    }

    /**
     * Populates the trie for generation of a new song. Takes list of
     * pitches, rhythms or durations
     *
     * @param notes training set as a list
     */
    private void populateTrie(List<Integer> notes) {
        this.trie.insert(notes);
    }

    /**
     * From a list of NoteObjects parses pitches, rhythms or durations depending
     * of global variable 'component'
     *
     *
     * @param trainingSet
     *
     * @return Integer list of pitches, rhythms or durations
     */
    public List<Integer> parse(List<NoteObject> trainingSet) {
        if (this.component.equals("melody")) {
            return trainingSet.stream().map(note -> note.getPitch()).collect(Collectors.toList());
        }
        if (this.component.equals("rhythm")) {
            return trainingSet.stream().map(note -> note.getRhythm()).collect(Collectors.toList());
        }
        if (this.component.equals("duration")) {
            return trainingSet.stream().map(note -> note.getDuration()).collect(Collectors.toList());
        }

        return trainingSet.stream().map(note -> note.getDynamic()).collect(Collectors.toList());
    }
}
