package generator;

import datastructures.NoteObject;
import datastructures.Trie;
import jm.music.data.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * @param trainingSet training set as a training set
     */
    public void createMelody(List<NoteObject> trainingSet) {
        List<Integer> pitches = parsePitches(trainingSet);

        populateTrie(pitches);

        this.generatedNotes = sequencer.createSequence(this.melodyTrie, pitches.size());
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

    private List<Integer> parsePitches(List<NoteObject> trainingSet) {
        return trainingSet.stream().map(note -> note.getPitch()).collect(Collectors.toList());
    }
}
