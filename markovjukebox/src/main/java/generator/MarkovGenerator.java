package generator;

import dataStructures.*;

public class MarkovGenerator {

    private Trie trie;

    public MarkovGenerator(Trie trie) {
        this.trie = trie;
    }

    public void readTrainingSet(int[] set) {
        this.trie.insert(set);
    }
}
