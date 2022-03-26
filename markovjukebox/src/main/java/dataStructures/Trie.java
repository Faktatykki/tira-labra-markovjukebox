package dataStructures;


import java.util.Arrays;

public class Trie {

    private TrieNode root;
    private int degree;

    public Trie(int d) {
        this.root = new TrieNode(-1);
        this.degree = d + 1;
    }

    /**
     * Inserts sequence to trie. If sequence is already in trie
     * method updates nodes' frequency Paths can't be shorter
     * or longer than degree + 1, + 1 being the leaf node
     *
     * @param sequence
     */
    public void insert(int[] sequence) {
        if (sequence.length < degree) {
            return;
        }

        TrieNode curRoot;

        for (int i = 0; i < sequence.length - (degree - 1) ; i++) {
            curRoot = this.root;
            for (int j = i; j < i + degree; j++) {
                int note = sequence[j];

                if (curRoot.getChildren()[note] == null) {
                    curRoot.getChildren()[note] = new TrieNode(note);
                } else {
                    curRoot.getChildren()[note].addFreq();
                }

                curRoot = curRoot.getChildren()[note];

                if ((j + 1 == i + degree && !curRoot.canTerminate())) {
                    curRoot.setCanTerminate(true);
                }
            }
        }
    }

    /**
     * Searches next possible children nodes based on given
     * sequence and returns them
     *
     * @param sequence
     * @return
     */
    public TrieNode[] search(int[] sequence) {
        int note;
        TrieNode node;
        TrieNode curRoot = this.root;

        for (int i = 0; i < sequence.length; i++) {
            note = sequence[i];
            node = curRoot.getChildren()[note];

            if (node == null) {
                return null;
            }

            curRoot = node;
        }

        return curRoot.getChildren();
    }
}
