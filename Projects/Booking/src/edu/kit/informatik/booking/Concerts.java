package edu.kit.informatik.booking;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Concerts implements BookingManagement<Concert> {
    private List<Booking<Concert>> concerts = new ArrayList<Booking<Concert>>();
    private List<Integer> usedIds = new ArrayList<Integer>();

    @Override
    public Booking<Concert> findBooking(Integer transactionId) {
        for (int i = 0; i < concerts.size(); i++) {
            if (concerts.get(i).getTransactionId() == transactionId) {
                return concerts.get(i);
                }
            }
        return null;
        }
    
    @Override
    public Booking<Concert> book(Concert item, Customer customer) {
        Booking<Concert> newBooking = new Booking<Concert>(item, customer);
        concerts.add(newBooking);
        usedIds.add(newBooking.getTransactionId());
        return newBooking;
        }
    @Override
    public Collection<Booking<Concert>> getBookings() {
        return concerts;
        }
    /**
     * 
     * @return return the List of the concerts
     */
    public List<Booking<Concert>> getConcerts() {
        return concerts;
        }
    /**
     * @return the Id of concerts that has been ever booked.
     */
    public List<Integer> getUsedIds() {
        return usedIds;
        }
}
