package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class InvalidStonePlacement extends Exception {
    /**
    * The special number of the class.
    */
    public static final long serialVersionUID = 42L;
    /**
     * The overwritten constructor
     * @param message the message of the specific exception
     */

    public InvalidStonePlacement(String message) {
        super(message);
    }

}
