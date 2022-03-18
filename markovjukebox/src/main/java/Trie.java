import java.util.HashMap;

public class Trie {
    private HashMap<String, Integer> map;
    private int value;

    public Trie() {
        map = new HashMap<>();
        value = 0;
        System.out.println("Trie created");
    }

    /**
     * Mock insert function for to become Trie data structure class
     *
     * @param soCalledNode some string which acts as a key
     * @return always true for now
     */
    public boolean insert(String soCalledNode) {
        map.put(soCalledNode, value );
        value++;

        System.out.println(map);
        return true;
    }

    /**
     *
     * @return class variable of  value
     */
    public int getValue() {
        return value;
    }
}
