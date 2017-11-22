package edu.kit.informatik.booking;

import java.util.Collection;

/**
 * Represents the stock of items available for booking. After adding a stock item, the item can be retrieved by its
 * unique id. It is hence not allowed to add different stock items that carry the same id.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * 
 * @version 1.0
 *
 * @param <T>
 *            the type of items available for booking
 */
public interface StockManagement<T extends Bookable> {

    /**
     * Looks up the stock item with the given identifier and returns the item, or <code>null</code> if none could be
     * found.
     * 
     * @param itemId
     *            the identifier of the stock item to be found
     * @return the stock item carrying the given id; <code>null</code>, if no such item could be found.
     */
    T findItem(Integer itemId);

    /**
     * Adds the given item to the stock of items available for booking.
     * <p>
     * The given item's id must be unique, i.e. may not carry the same id as another item currently on stock, or an item
     * booked previously.
     * 
     * @param item
     *            the item available for booking
     * @return <code>true</code>, if successful; <code>false</code>, if the item could not be added.
     */
    boolean addStockItem(T item);

    /**
     * Removes the item identified by the given id from the stock of available items.
     * <p>
     * If an item is removed that has <em>not</em> been booked before, the item's id may be assigned to another stock
     * item without violating the uniqueness required by {@link #addStockItem(Bookable)}.
     * 
     * @param itemId
     *            the identifier of the stock item to be removed
     * @param booked
     *            <code>true</code>, if the item to be removed has been booked; <code>false</code>, if the item is
     *            removed without being booked. In the latter case, the item's id becomes available again.
     * @return <code>true</code>, if successful; <code>false</code>, if no such item could be found and removed.
     */
    boolean removeStockItem(Integer itemId, boolean booked);

    /**
     * @return all items available for booking.
     */
    Collection<T> getStockItems();

}
