public class Main {
    public static void main(String[] args) {
        Trie tree = new Trie();
        boolean insertReturns = tree.insert("test");

        System.out.println(insertReturns);
    }
}
