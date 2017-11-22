package edu.kit.informatik.booking;

/**
 * A booking of a {@link Bookable} item made by a {@link Customer}. A booking is uniquely identified by its transaction
 * id.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * 
 * @version 1.0
 *
 * @param <T>
 *            the type of items available for booking
 */
public class Booking<T extends Bookable> {

    private static Integer nextTransactionId = 0;

    private Integer transactionId;

    private T item;

    private Customer customer;

    /**
     * Constructs a new booking. This includes generating a unique transaction id that is assigned to this booking.
     * 
     * @param item
     *            the item that has been booked
     * @param customer
     *            the customer who has booked the item
     */
    public Booking(T item, Customer customer) {
        this.transactionId = nextTransactionId++;
        this.item = item;
        this.customer = customer;
    }

    /**
     * @return the unique transaction id.
     */
    public Integer getTransactionId() {
        return transactionId;
    }

    /**
     * @return the item that has been booked.
     */
    public T getItem() {
        return item;
    }

    /**
     * @return the customer who has booked the item.
     */
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return transactionId + ";" + item.getId() + ";" + customer.getCustomerId();
    }

}
