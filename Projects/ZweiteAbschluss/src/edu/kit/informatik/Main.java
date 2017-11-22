package edu.kit.informatik;
/**
 * The class containg the main method.
 * @author Ahmad
 * @version 1.0
 */
public class Main {
    /**
     * The main method calling for the methods in interactive.
     * @param args command line argument.
     */
    public static void main(String[] args) {
        Interactive interactive = new Interactive(args);
        interactive.commands();
    }
}
