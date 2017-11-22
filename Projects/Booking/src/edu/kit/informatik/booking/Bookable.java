package edu.kit.informatik.booking;

/**
 * An item that can be booked (see: {@link Booking}).
 * <p>
 * Each item can be booked only once.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * 
 * @version 1.0
 */
public interface Bookable {

    /**
     * @return a number that identifies this item.
     */
    Integer getId();

    /**
     * @return the name of this item.
     */
    String getName();

    /**
     * @return the price of this item, including fees and VAT.
     */
    Money getPrice();

}
