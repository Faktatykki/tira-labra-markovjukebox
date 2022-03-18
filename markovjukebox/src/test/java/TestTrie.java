
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTrie {

    Trie t;

    @Before
    public void setUp() {
        t = new Trie();
    }

    @Test
    public void insertWorks() {
        Boolean insertReturns = t.insert("test");
        assertTrue(insertReturns);
    }

    @Test
    public void keyIncrements() {
        t.insert("test2");
        assertEquals(1, t.getValue());
    }
}
