package edu.kit.informatik.booking;

/**
 * A (simplified) customer represented by a unique customer id, the first name, and last name.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * 
 * @version 1.0
 *
 */
public class Customer {

    private static Integer nextCustomerId = 0;

    private Integer customerId;

    private String firstName;

    private String lastName;

    /**
     * Constructs a customer with the given first and last name. The customer's unique id is generated automatically.
     * 
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     */
    public Customer(String firstName, String lastName) {
        this.customerId = nextCustomerId++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (customer #" + customerId + ")";
    }

    /**
     * @return the customer's unique id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @return the customer's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the customer's last name
     */
    public String getLastName() {
        return lastName;
    }

    // for simplicity, we assume customers won't change their name

}
