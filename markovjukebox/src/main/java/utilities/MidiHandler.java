package utilities;


import datastructures.NoteObject;
import jm.music.data.*;
import jm.util.*;

import java.util.ArrayList;
import java.util.List;


public class MidiHandler {

    private Score inputScore;
    private Score outputScore;
    private double tempo;
    private int instrument;

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
    public ArrayList<NoteObject> getTrainingData() {
        inputMidiToScore();
        return midiToArray();
    }

    /**
     * Creates a midi-file as an output from an array of generated notes
     *
     * @param generatedNotes
     */
    public void arrayToMidi(List<NoteObject> generatedNotes) {
        Part part = createPart(generatedNotes);

        part.setInstrument(this.instrument);
        this.outputScore.addPart(part);

        try {
            Write.midi(this.outputScore, "../markovjukebox/src/main/java/Testi.mid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a part (part represents one track of a song) based on generated notes
     *
     * @param generatedNotes
     * @return Part based on generated notes
     */
    private Part createPart(List<NoteObject> generatedNotes) {
        Part part = new Part("Something");
        Phrase phrase = new Phrase(0.0);

        for (int i = 0; i < generatedNotes.size(); i++) {
            NoteObject curNote = generatedNotes.get(i);
            int pitch = curNote.getPitch();

            double rhythm =  (double) curNote.getRhythm() / 100;
            double duration = (double) curNote.getDuration() / 100;

            Note note = new Note(pitch, rhythm);
            note.setDuration(duration);

            phrase.add(note);
        }


        part.addPhrase(phrase);
        part.setTempo(this.tempo);

        return part;
    }

    /**
     * Reads a midi-file and puts it to Score-object (file path is hard coded for now)
     */
    private void inputMidiToScore() {
        Read.midi(this.inputScore, "../markovjukebox/src/main/java/phasedancebass.mid");

        this.instrument = this.inputScore.getPart(0).getInstrument();
        this.tempo = this.inputScore.getTempo();
    }

    /**
     * From a Score-object, which represents given midi-input file, creates an ArrayList representation
     * of pitches of given input. Rhythm values and durations are multiplied by 100 because of the array
     * representation in TrieNodes.
     *
     * @return arraylist representation of a input midi-file
     */
    public ArrayList<NoteObject> midiToArray() {
        ArrayList<NoteObject> sequence = new ArrayList<>();

        Phrase phrase = this.inputScore.getPart(0).getPhrase(0);

        for (int i = 0; i < phrase.size(); i++) {
            int note = phrase.getNote(i).getPitch();
            int rhythm = roundToNearestFive(phrase.getNote(i).getRhythmValue());
            int duration = roundToNearestFive(phrase.getNote(i).getDuration());

            sequence.add(new NoteObject(note, rhythm, duration));
        }

        return sequence;
    }


    /**
     * Rounds to nearest five when original double value is multiplied by 100
     *
     * @param rhythm double value to round up to
     * @return returns rounded double value * 100
     */
    public int roundToNearestFive(double rhythm) {
        double r = rhythm * 100;
        r = 5 * Math.round(r / 5);

        return (int) r;
    }
}
