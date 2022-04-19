import datastructures.NoteObject;
import generator.GeneratorService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class TestGeneratorService {

    private GeneratorService gs;
    private List<NoteObject> trainingSet;

    @Before
    public void init() {
        this.trainingSet = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            this.trainingSet.add(new NoteObject(i, i + 1, i + 2, i + 3));
        }

        this.gs = new GeneratorService(3, trainingSet);
    }

    @Test
    public void generatingGeneratedSetIsMinListSize() {
        List<NoteObject> n = gs.generate();

        assertTrue(this.trainingSet.size() >= n.size());
    }

    @Test
    public void combiningGeneratedPropertiesReturnsRightList() {
        List<Integer> pitches = new ArrayList<>();
        List<Integer> rhythms = new ArrayList<>();
        List<Integer> durations = new ArrayList<>();
        List<Integer> dynamics = new ArrayList<>();

        for (int i = 0; i < this.trainingSet.size(); i++) {
                NoteObject note = this.trainingSet.get(i);

                pitches.add(note.getPitch());
                rhythms.add(note.getRhythm());
                durations.add(note.getDuration());
                dynamics.add(note.getDynamic());
        }

        List<NoteObject> l = gs.combineGeneratedProperties(pitches, rhythms, durations, dynamics);

        int lastIdx = l.size() - 1;

        assertTrue(l.get(lastIdx).getPitch() == 9);
        assertTrue(l.get(lastIdx).getRhythm() == 10);
        assertTrue(l.get(lastIdx).getDuration() == 11);
    }

    @Test
    public void smallestListSizeIsFound() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list1.add(i);
            list4.add(i);

            if (i < 5) {
                list2.add(i);
            }
            if (i < 8) {
                list3.add(i);
            }
        }

        int minListSize = gs.getMinListSize(list1.size(), list2.size(), list3.size(), list4.size());

        assertTrue(minListSize == 5);
    }

    @Test
    public void longestDurationIsFound() {
        assertTrue(gs.getLongestDuration(this.trainingSet) == 11);
    }
}
