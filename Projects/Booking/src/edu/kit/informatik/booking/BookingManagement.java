package edu.kit.informatik.booking;

import java.util.Collection;

/**
 * A simplified, generic booking system. {@link Customer}s can book {@link Bookable} items, which results in a
 * {@link Booking}. Bookings can be retrieved by their unique transaction id.
 *
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * 
 * @version 1.0
 *
 * @param <T>
 *            the type of items available for booking
 */
public interface BookingManagement<T extends Bookable> {

    /**
     * Looks up the booking with the given transaction identifier and returns the booking, or <code>null</code> if none
     * could be found.
     * 
     * @param transactionId
     *            the unique identifier of the booking
     * @return the booking with the given transaction id; <code>null</code>, if no such booking could be found.
     */
    Booking<T> findBooking(Integer transactionId);

    /**
     * Books the given item for the given customer.
     * 
     * @param item
     *            the item to be booked
     * @param customer
     *            the customer booking the item
     * @return the booking, if successful; <code>null</code> , if the item could not be booked.
     */
    Booking<T> book(T item, Customer customer);

    /**
     * @return the collection of all bookings
     */
    Collection<Booking<T>> getBookings();

}
