package datastructures;

public class TrieNode {

    private int key;
    private int freq;
    private TrieNode[] children;
    private boolean canTerminate;

    public TrieNode(int d, int range) {
        this.key = d;
        this.freq = 1;
        this.children = new TrieNode[range + 1];
        this.canTerminate = false;
    }

    public int getKey() {
        return this.key;
    }

    public int getFreq() {
        return this.freq;
    }

    public void addFreq() {
        this.freq += 1;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public TrieNode[] getChildren() {
        return this.children;
    }

    public boolean canTerminate() {
        return this.canTerminate;
    }

    public void setCanTerminate(boolean canIt) {
        this.canTerminate = canIt;
    }

    public String toString() {
        return Integer.toString(this.key);
    }

}
