import datastructures.Trie;
import datastructures.TrieNode;
import generator.SequenceCreator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class TestSequenceGenerator {

    private Trie trie;
    private SequenceCreator sc;

    @Before
    public void init() {
        this.trie = new Trie(2);
        this.sc = new SequenceCreator();

        List<Integer> arrList = Arrays.asList(1, 2, 3);

        trie.insert(arrList);
    }

    @Test
    public void creatingSequenceWorks() {
        SequenceCreator sc = new SequenceCreator();

        List<Integer> sequence = sc.createSequence(this.trie, 3);

        assertTrue(sequence.get(0) == 1);
        assertTrue(sequence.get(1) == 2);
        assertTrue(sequence.get(2) == 3);
    }

    @Test
    public void randomGetterWorks() {
        TrieNode[] nodes = new TrieNode[3];

        nodes[0] = new TrieNode(0);
        nodes[1] = new TrieNode(1);
        nodes[2] = new TrieNode(2);

        nodes[1].setFreq(0);
        nodes[2].setFreq(0);

        int rand = sc.getRandom(nodes);

        assertEquals(rand, nodes[0].getKey());
    }
}
