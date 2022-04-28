package generator;

import datastructures.NoteObject;

import jm.music.data.Note;
import utilities.*;

import java.util.List;
import java.util.ArrayList;


public class MarkovGenerator {

    private final int order;
    private MidiHandler midiHandler;
    private List<NoteObject> trainingSet;
    private List<NoteObject> generatedSet;

    public MarkovGenerator(int order) {
        this.order = order;
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
    public void generateSong(String file) {
        readTrainingSetFromMidi(file);

        GeneratorService gs = new GeneratorService(this.order, this.trainingSet);

        List<NoteObject> generatedSong = gs.generate();

        midiHandler.arrayToMidi(generatedSong);
    }

    /**
     * Reads the given training data and passes it to GeneratorService to generate
     * a song based on training data
     */
    public void readTrainingSetFromMidi(String file) {
        this.trainingSet = midiHandler.getTrainingData(file);
    }
}
