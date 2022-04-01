package dataStructures;

public class TrieNode {

    private int key;
    private int freq;
    private TrieNode[] children;
    private boolean canTerminate;

    public TrieNode(int d) {
        this.key = d;
        this.freq = 1;
        this.children = new TrieNode[128];
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
