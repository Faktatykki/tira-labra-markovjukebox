

import generator.GeneratorService;
import generator.MarkovGenerator;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        MarkovGenerator mg = new MarkovGenerator(3);
        mg.generateSong();
    }
}
