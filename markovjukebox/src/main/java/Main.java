
import dataStructures.*;
import generator.MarkovGenerator;


import java.io.File;


public class Main {
    public static void main(String[] args) {
        MarkovGenerator mg = new MarkovGenerator(3);

        mg.generateSong();
    }
}
