

import generator.MarkovGenerator;
import jm.music.data.Note;



public class Main {
    public static void main(String[] args) {
        MarkovGenerator mg = new MarkovGenerator(5);
        mg.generateSong();
    }
}
