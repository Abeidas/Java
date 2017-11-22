package edu.kit.informatik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Player {
    private ArrayList<Character> inventory;
    private Map<Integer, Integer> map;
    /**
     * Constructor
     */
    Player() {
        inventory = new ArrayList<Character>();
        map = new HashMap<Integer, Integer>(20);
        for (int i = 0; i < 20; i++) {
            map.put(i, 0);
        }
    }
    /**
     * @return the inventory
     */
    public ArrayList<Character> getInventory() {
        return inventory;
    }
    /**
     * @return the map
     */
    public Map<Integer, Integer> getMap() {
        return map;
    }
    /**
     * This method adds up the score of all the valid words corresponding to certain player.
     * @return return the sum.
     */
    public int sum() {
        int sum = 0;
        for (int i = 0; i < map.size(); i++) {
            sum += map.get(i);
        }
        return sum;
    }
    /**
     * This method returns a string of the stones that this Player is carrying.
     * @return string of the stones.
     */
    public String inventoryToString() {
        if (inventory.isEmpty()) {
            return "Error, Inventory is Empty!";
        } else {
        String toString = "";
        for (char element : inventory) {
            toString += element;
        }
        return toString;
        }
    }
}
