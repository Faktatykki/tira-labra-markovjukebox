package utilities;


import jm.music.data.*;
import jm.util.*;

import java.util.ArrayList;
import java.util.List;


public class MidiHandler {

    private Score inputScore;
    private Score outputScore;

    public MidiHandler() {
        this.inputScore = new Score("Input");
        this.outputScore = new Score("Output");
    }

    /**
     * Creates Score-object (jMusic object which represents the song) from input midi-file
     * and returns ArrayList representation of given input midi-file
     *
     * @return Array list representation of input midi-file
     */
    public ArrayList<Integer> getTrainingData() {
        inputMidiToScore();

        return midiToArray();
    }

    /**
     * Creates a midi-file as an output from an array of generated notes
     *
     * @param generatedNotes
     */
    public void outputScoreToMidi(List<Integer>  generatedNotes) {
        Part part = new Part("Something");
        Phrase phrase = new Phrase(0.0);

        for (int i = 0; i < generatedNotes.size(); i++) {
            Note note = new Note(generatedNotes.get(i), 0.4);
            phrase.add(note);
        }

        part.addPhrase(phrase);
        this.outputScore.addPart(part);

        try {
            Write.midi(this.outputScore, "../markovjukebox/src/main/java/Testi.mid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads a midi-file and puts it to Score-object (file path is hard coded for now)
     */
    private void inputMidiToScore() {
        Read.midi(this.inputScore, "../markovjukebox/src/main/java/GiantSteps.mid");
    }

    /**
     * From a Score-object, which represents given midi-input file, creates an ArrayList representation
     * of pitches of given input
     *
     * @return
     */
    private ArrayList<Integer> midiToArray() {
        ArrayList<Integer> sequence = new ArrayList<>();

        Phrase phrase = this.inputScore.getPart(0).getPhrase(0);

        for (int i = 0; i < phrase.size(); i++) {
            int note = phrase.getNote(i).getPitch();
            sequence.add(note);
        }

        return sequence;
    }



}
