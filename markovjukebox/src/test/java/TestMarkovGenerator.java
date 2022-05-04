
import generator.MarkovGenerator;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestMarkovGenerator {

    @Test
    public void orderCantBeBiggerThanSizeOfTrainingSet() {
        int order = 9999;

        MarkovGenerator mg = new MarkovGenerator(order);

        assertFalse(mg.generateSong("bourree.mid"));
    }

    @Test
    public void orderCantBeNegative() {
        int order = -9999;

        MarkovGenerator mg = new MarkovGenerator(order);

        assertFalse(mg.generateSong("bourree.mid"));
    }

    @Test
    public void orderAndTrainingSetSizeCanBeEqualValue() {
        int order = 263;

        MarkovGenerator mg = new MarkovGenerator(order);

        assertTrue(mg.generateSong("bourree.mid"));
    }

}
