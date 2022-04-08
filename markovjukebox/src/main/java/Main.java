

import generator.MarkovGenerator;


public class Main {
    public static void main(String[] args) {
        PerformanceTests pt = new PerformanceTests();

        pt.populateTrieTest();

        MarkovGenerator mg = new MarkovGenerator(3);
        mg.generateSong();
    }
}
