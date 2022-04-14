package datastructures;


import java.util.List;


public class Trie {

    private int range;
    private TrieNode root;
    private int order;


    public Trie(int order, int range) {
        this.range = range;
        this.root = new TrieNode(-1, this.range);
        this.order = order + 1;
    }

    /**
     * Inserts sequence to trie. If sequence is already in trie
     * method updates nodes' frequency Paths can't be shorter
     * or longer than degree + 1, + 1 being the leaf node
     *
     * @param sequence
     */
    public void insert(List<Integer> sequence) {
        if (sequence.size() < order) {
            return;
        }

        TrieNode curRoot;

        for (int i = 0; i < sequence.size() - (order - 1); i++) {
            curRoot = this.root;
            for (int j = i; j < i + order; j++) {
                int note = sequence.get(j);

                if (note < 0) {
                    note = 0;
                }

                if (curRoot.getChildren()[note] == null) {
                    curRoot.getChildren()[note] = new TrieNode(note, this.range);
                } else {
                    curRoot.getChildren()[note].addFreq();
                }

                curRoot = curRoot.getChildren()[note];

                if ((j + 1 == i + order && !curRoot.canTerminate())) {
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
     * @return children of given sequence's second to last node
     */
    public TrieNode[] search(List<Integer> sequence) {
        int note;
        TrieNode node;
        TrieNode curRoot = this.root;

        for (int i = 0; i < sequence.size(); i++) {
            note = sequence.get(i);
            node = curRoot.getChildren()[note];

            if (node == null) {
                return null;
            }

            curRoot = node;
        }

        return curRoot.getChildren();
    }

    public int getOrder() {
        return this.order;
    }
}
