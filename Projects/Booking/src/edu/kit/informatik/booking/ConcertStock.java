package edu.kit.informatik.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class ConcertStock implements StockManagement<Concert> {
    List<Concert> availableConcerts = new ArrayList<Concert>();
    @Override
    public Concert findItem(Integer itemId) {
          for (int i = 0; i < availableConcerts.size(); i++) {
              if (availableConcerts.get(i).getId() == itemId) {
                  return availableConcerts.get(i);
                  }
              }
          return null;
          }

    @Override
    public boolean addStockItem(Concert item) {
        boolean contains = false;
        for (int i = 0; i < availableConcerts.size(); i++) {
            if (availableConcerts.get(i).getName().equals(item.getName())) {
                availableConcerts.add(item);
                }
            contains = true;
            }
        if (contains || availableConcerts.isEmpty()) {
            availableConcerts.add(item);
            }
        return contains;
        }
    @Override
    public boolean removeStockItem(Integer itemId, boolean booked) {
        for (int i = 0; i < availableConcerts.size(); i++) {
            if (availableConcerts.get(i).getId() == itemId) {
                availableConcerts.remove(i);
                return true;
                }
            }
        return false;
        }

    @Override
    public Collection<Concert> getStockItems() {
        return availableConcerts;
        }

}
