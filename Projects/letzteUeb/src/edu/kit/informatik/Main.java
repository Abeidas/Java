package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public final class Main {
    /**
     * Default constructor.
     */
    private Main() {
    }
    /**
     * 
     * @param args Command line-argument.
     */
    public static void main(String args[]) {
        
    Interactive interactive = new Interactive();
    try {
        interactive.interactive(args);
        } catch (OwnException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
