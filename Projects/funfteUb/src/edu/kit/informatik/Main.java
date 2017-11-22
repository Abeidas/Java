package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Main {
    /**
     * Constructor of the class
     */
    protected Main() {
    }
    /**
     * 
     * @param args the command line argument.
     * @throws OwnException the author's exception.
     */
    public static void main(String args[]) throws OwnException  {
        Interactive interactive = new Interactive();
        interactive.santorini(args);
        }
}
