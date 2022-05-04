package ui;

import generator.MarkovGenerator;
import utilities.PerformanceTests;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Ui {

    private MarkovGenerator mg;
    private PerformanceTests pt;
    private Scanner io;

    public Ui() {
        this.pt = new PerformanceTests();
        this.io = new Scanner(System.in);
    }

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

    public void chooseAction(String choice) {

        int value = Integer.valueOf(choice);

        if (value == 1) {
            generateSong();
        }
        if (value == 2) {
            runThroughPerformanceTests();
        }
    }

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

    public void runThroughPerformanceTests() {
        pt.populateTrieTest();
    }

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

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
