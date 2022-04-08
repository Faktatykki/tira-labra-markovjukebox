
import datastructures.NoteObject;
import generator.MarkovGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TestMarkovGenerator {

    @Test
    public void combiningGeneratedPropertiesWork() {
        MarkovGenerator mg = new MarkovGenerator(1);

        mg.readTrainingSetFromMidi();

        List<Integer> mockGeneratedNotes = new ArrayList<>();
        mockGeneratedNotes.add(78);

        mg.combineGeneratedProperties(mockGeneratedNotes);

        List<NoteObject> set = mg.getGeneratedSet();

        assertTrue(set.get(0).getPitch() == 78);
        assertTrue(set.get(0).getRhythm() == 0.5078125);
        assertTrue(set.get(0).getDuration() == 0.5078125);
    }
}
