package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Main {
    /**
     * The main method.
     * @param args the command-line-argument
     */
    public static void main(String args[]) {
        try {
            Interactive interactive = new Interactive();
            interactive.commandLine(args);
            interactive.command();
        } catch (IllegalArgumentException e) {
            Terminal.printLine(e.getMessage());
        }
    }
}
