import datastructures.NoteObject;
import generator.Generator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class TestGenerator {

    private List<NoteObject> notes;
    private Generator melody;
    private Generator rhythm;
    private Generator duration;

    @Before
    public void init() {
        this.notes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            notes.add(new NoteObject(i, i + 1, i + 2));
        }

        this.melody = new Generator(3, 10, "melody");
        this.rhythm = new Generator(3, 10, "rhythm");
        this.duration = new Generator(3, 10, "duration");
    }

    @Test
    public void generatedSetIsNotLongerThanTrainingSet() {
        List<Integer> l = melody.generate(this.notes);

        assertTrue(l.size() <= this.notes.size());
    }

    @Test
    public void parseParsesRightComponents() {
        List<Integer> m = melody.parse(this.notes);
        List<Integer> r = rhythm.parse(this.notes);
        List<Integer> d = duration.parse(this.notes);

        int size = m.size() - 1;

        assertTrue(m.get(size) == 9);
        assertTrue(r.get(size) == 10);
        assertTrue(d.get(size) == 11);
    }

    @Test
    public void parseReturnsNullIfGivenComponentNotCompatible() {
        Generator g = new Generator(3, 10, "feeling");

        List<Integer> l = g.parse(notes);

        assertTrue(l == null);
    }
}
