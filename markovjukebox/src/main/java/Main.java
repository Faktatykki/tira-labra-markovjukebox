
import dataStructures.*;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Trie tree = new Trie(1);

        int[] seq = {2, 3, 2,5,4,6,7,2,5};
        int[] s = {2};

        tree.insert(seq);
        TrieNode[] arr = tree.search(s);
    }
}
