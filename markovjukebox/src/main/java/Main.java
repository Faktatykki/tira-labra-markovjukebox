

import generator.GeneratorService;
import generator.MarkovGenerator;
import jm.music.data.Note;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Note n = new Note();

        MarkovGenerator mg = new MarkovGenerator(1);
        mg.generateSong();
    }
}
