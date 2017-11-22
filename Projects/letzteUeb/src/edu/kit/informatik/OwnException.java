package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class OwnException extends Exception {
    /**
    * The special number of the class.
    */
    public static final long serialVersionUID = 42L;
    /**
     * The overwriten contructor
     * @param message the message of the specific exception
     */

    public OwnException(String message) {
        super(message);
    }

}
