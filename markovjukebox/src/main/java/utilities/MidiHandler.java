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
    //muuta noteobject listiks ettei tarvii olla kahta listaa
    public void outputScoreToMidi(List<NoteObject> generatedNotes) {
        Part part = new Part("Something");
        Phrase phrase = new Phrase(0.0);

        for (int i = 0; i < generatedNotes.size(); i++) {
            NoteObject curNote = generatedNotes.get(i);

            Note note = new Note(curNote.getPitch(), curNote.getRhythm());
            note.setDuration(curNote.getDuration());

            phrase.add(note);
        }

        part.addPhrase(phrase);
        this.outputScore.addPart(part);

        this.outputScore.setTempo(this.tempo);

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
        Read.midi(this.inputScore, "../markovjukebox/src/main/java/bourree.mid");
        this.tempo = this.inputScore.getTempo();
    }

    /**
     * From a Score-object, which represents given midi-input file, creates an ArrayList representation
     * of pitches of given input
     *
     * @return arraylist representation of a input midi-file
     */
    private ArrayList<NoteObject> midiToArray() {
        ArrayList<NoteObject> sequence = new ArrayList<>();

        Phrase phrase = this.inputScore.getPart(0).getPhrase(0);

        for (int i = 0; i < phrase.size(); i++) {
            int note = phrase.getNote(i).getPitch();
            double rhythm = phrase.getNote(i).getRhythmValue();
            double duration = phrase.getNote(i).getDuration();

            sequence.add(new NoteObject(note, rhythm, duration));
        }

        return sequence;
    }
}
