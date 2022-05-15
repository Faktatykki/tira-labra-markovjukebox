package ui;

import generator.MarkovGenerator;
import utilities.PerformanceTests;

import java.util.Scanner;

public class Ui {

    private MarkovGenerator mg;
    private PerformanceTests pt;
    private Scanner io;

    public Ui() {
        this.pt = new PerformanceTests();
        this.io = new Scanner(System.in);
    }

    /**
     * The main menu of Ui
     */
    public void start() {

        boolean on = true;

        clearScreen();

        System.out.println("###########################");
        System.out.println("###########################\n");
        System.out.println("MARKOV JUKEBOX, LET'S PARTY");
        System.out.println("\n###########################");
        System.out.println("###########################\n");

        while (on) {
            System.out.println("###########################\n");
            System.out.println("1. Generate a new song");
            System.out.println("2. Performance tests\n");
            System.out.println("X. Exit\n");
            System.out.println("###########################");
            System.out.print("What do you want to do: ");
            String choice = io.nextLine();

            clearScreen();

            if (choice.toLowerCase().equals("x")) {
                System.out.println("\nSee you!");
                break;
            }
            if (!validateChoice(choice)) {
                System.out.println("Please only number values!");
                continue;
            }

            System.out.println("\n###########################\n");
            chooseAction(choice);
            System.out.println("\n###########################\n");
        }
    }

    /**
     * According to a given value in main menu chooses the next action
     *
     * @param choice numeric value
     */
    public void chooseAction(String choice) {

        int value = Integer.valueOf(choice);

        if (value == 1) {
            generateSong();
        }
        if (value == 2) {
            runThroughPerformanceTests();
        }
    }

    /**
     * Checks if given value is valid by checking if it's a numerical value (an integer to be exact)
     *
     * @param choice
     * @return
     */
    public boolean validateChoice(String choice) {

        boolean success;

        try {
            int value = Integer.valueOf(choice);
            success = true;
        } catch (Exception e) {
            success = false;
        }

        return success;
    }

    /**
     * Runs performance tests
     *
     */
    public void runThroughPerformanceTests() {
        pt.populateTrieAndGenerateSongTest();
    }

    /**
     * Menu for generating a new song
     */
    public void generateSong() {
        boolean on = true;

        while (on) {
            System.out.println("###########################\n");
            System.out.print("Enter a song to create based on (with or without suffix): ");
            String song = io.nextLine();
            System.out.print("\nSo what order should Markov chain obey: ");
            String order = io.nextLine();
            System.out.println("\n##########################");

            clearScreen();

            if (pickASong(song, order)) {
                System.out.println("\nSong generated successfully!\n");
            } else {
                System.out.println("\nOrder of the song can not be longer than the training set or negative value\n");
            }

            System.out.println("To create an other song press enter, or to go back type 'X'");
            String stop = io.nextLine();

            if (stop.toLowerCase().equals("x")) {
                break;
            }
        }
    }

    /**
     * Checks if given midi-file name is valid and is found from directory
     *
     * @param file file name
     * @param order Markov chain order
     *
     * @return if file is valid and file is found returns true. Otherwise false.
     */
    public boolean pickASong(String file, String order) {

        try {
            int value = Integer.valueOf(order);
            this.mg = new MarkovGenerator(value);

            if (mg.generateSong(file)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("\nSomething got messed up!!\n");
            return false;
        }

        return false;
    }

    /**
     * When the program is run in terminal, this clears the screen.
     */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
