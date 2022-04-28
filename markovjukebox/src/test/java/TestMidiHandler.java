import datastructures.NoteObject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import utilities.MidiHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestMidiHandler {

    private MidiHandler mh;

    @Before
    public void init() {
        this.mh = new MidiHandler();
    }

    @Test
    public void midiToArrayWorks() {
        List<NoteObject> notes = this.mh.getTrainingData("bourree.mid");

        assertThat(notes, instanceOf(List.class));
    }

    @Test
    public void readsRightAmountOfData() {
        List<NoteObject> notes = this.mh.getTrainingData("bourree.mid");

        assertEquals(notes.size(), 264);
    }

    @Test
    public void createsMidiFile() {
        List<NoteObject> notes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            notes.add(new NoteObject(i, i, i, i));
        }

        this.mh.arrayToMidi(notes);

        File testFile = new File("../markovjukebox/src/main/java/Testi.mid");

        assertTrue(testFile.isFile());

        testFile.delete();
    }
}
