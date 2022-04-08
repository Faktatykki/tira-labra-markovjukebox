package generator;

import datastructures.NoteObject;

import jm.music.data.Note;
import utilities.*;

import java.util.List;
import java.util.ArrayList;


public class MarkovGenerator {

    private final int order;
    private MelodyGenerator melodyGenerator;
    private MidiHandler midiHandler;
    private List<NoteObject> trainingSet;
    private List<NoteObject> generatedSet;

    public MarkovGenerator(int order) {

        this.order = order;
        this.melodyGenerator = new MelodyGenerator(order);
        this.midiHandler = new MidiHandler();
        this.trainingSet = new ArrayList<>();
        this.generatedSet = new ArrayList<>();
    }

    /**
     * Goes through the process of generating a new song based on input:
     *
     * Calls readTrainingSet-function which generates a melody sequence
     * based on given input and saves is it in melodyGenerator-object.
     * Then generated notes can be passed to midiHandler, which
     * outputs generated notes as a midi-file.
     *
     *
     * outputs a new midi-file of generated notes
     */
    public void generateSong() {
        readTrainingSetFromMidi();

        this.melodyGenerator.createMelody(trainingSet);
        List<Integer> generatedNotes = this.melodyGenerator.getGeneratedNotes();

        combineGeneratedProperties(generatedNotes);

        midiHandler.outputScoreToMidi(this.generatedSet);
    }

    /**
     * Reads the given training data and passes it to melodyGenerator to generate
     * a song based on training data
     */
    public void readTrainingSetFromMidi() {
        this.trainingSet = midiHandler.getTrainingData();
    }

    public void setTrainingSet(List<NoteObject> notes) {
        this.trainingSet = notes;
    }

    public void combineGeneratedProperties(List<Integer> generatedNotes) {

        for (int i = 0; i < generatedNotes.size(); i++) {
            int pitch = generatedNotes.get(i);
            double rhythm = trainingSet.get(i).getRhythm();
            double duration = trainingSet.get(i).getDuration();

            this.generatedSet.add(new NoteObject(pitch, rhythm, duration));
        }
    }

    public List<NoteObject> getGeneratedSet() {
        return this.generatedSet;
    }
}
