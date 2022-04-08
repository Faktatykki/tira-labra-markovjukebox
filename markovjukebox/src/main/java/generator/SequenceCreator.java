package generator;

import datastructures.Trie;
import datastructures.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SequenceCreator {

    /**
     * Generates a song based on inserted nodes of trie and nodes weights
     * length of a training set
     *
     * @return generated sequence based on passed trie
     */
    public List<Integer> createSequence(Trie trie, int size) {
        List<Integer> generated = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TrieNode[] children = trie.search(queue);

            if (children == null) {
                queue.clear();
                continue;
            }

            int pickedChild = getRandom(children);

            queue.add(pickedChild);

            generated.add(pickedChild);
            //System.out.println("generated notes: " + this.generatedNotes);

            if (queue.size() == trie.getOrder()) {
                queue.remove(0);
                //System.out.println("markov chain: " + this.queue);
            }
        }

        return generated;
    }

    /**
     * Chooses randomly next element from the children nodes of sequence, considering weights
     * of nodes
     *
     * @param children
     * @return random children of given array based on node weights
     */
    public int getRandom(TrieNode[] children) {
        Random rand = new Random();

        List<Integer> weightedList = getWeightedList(children);
        int randomIndex = rand.nextInt(weightedList.size());
        int pickedChild = weightedList.get(randomIndex);

        return pickedChild;
    }

    /**
     * Creates a list based on frequencies of certain node's children seen in Trie
     *
     * @param children
     * @return weighted list
     */
    public List<Integer> getWeightedList(TrieNode[] children) {
        List<Integer> weightedList = new ArrayList<>();

        for (int i = 0; i < children.length; i++) {
            if (children[i] == null) {
                continue;
            }

            TrieNode node = children[i];
            int nodeWeight = node.getFreq();

            for (int j = 0; j < nodeWeight; j++) {
                weightedList.add(node.getKey());
            }
        }

        return weightedList;
    }
}
