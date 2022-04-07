import datastructures.NoteObject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import utilities.MidiHandler;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMidiHandler {

    private MidiHandler mh;

    @Before
    public void init() {
        this.mh = new MidiHandler();
    }

    @Test
    public void midiToArrayWorks() {
        List<NoteObject> notes = this.mh.getTrainingData();

        assertThat(notes, instanceOf(List.class));
    }

    @Test
    public void readsRightAmountOfData() {
        List<NoteObject> notes = this.mh.getTrainingData();

        assertEquals(notes.size(), 1252);
    }

    @Test
    public void createsMidiFile() {
        List<Integer> notes = new ArrayList<>();
        List<Double> rhythms = new ArrayList<>();

        notes.add(1);
        notes.add(2);

        rhythms.add(1.0);
        rhythms.add(2.0);

        this.mh.outputScoreToMidi(notes, rhythms);
        File testFile = new File("../markovjukebox/src/main/java/Testi.mid");

        assertTrue(testFile.isFile());

        testFile.delete();
    }
}
