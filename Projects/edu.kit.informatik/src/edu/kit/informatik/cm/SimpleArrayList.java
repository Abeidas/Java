package edu.kit.informatik.cm;

import edu.kit.informatik.booking.Course;
import edu.kit.informatik.booking.ExaminationResult;


/**
 * A simplified array list. Elements in the list are organized as array.
 * <p>
 * Please notice the difference between <em>capacity</em> and <em>size</em>. Capacity refers to the size of the array
 * used internally. Size refers to the actual number of elements stored within the array. Hence, <em>capacity</em> is
 * always larger or equal to <em>size</em>. If both are equal, capacity is increased with the next insertion.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * @author Ahmad Beidas
 * 
 * @version 0.1
 */
public class SimpleArrayList {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;

    private int actualSize;

    /**
     * Constructs an empty list having an initial capacity of 5.
     */
    public SimpleArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial {@code capacity}.
     * 
     * @param capacity
     *            the initial capacity
     */
    public SimpleArrayList(int capacity) {
        elements = new Object[capacity];
    }

    /**
     * Adds the given element to the end of this list.
     * 
     * @param element
     *            the element to be added.
     */
    public void add(Object element) {
        if( DEFAULT_CAPACITY == getActualSize()) {
            doubleCapacity();
            element = elements[getActualSize() + 1];
        } else {
            element = elements[getActualSize() + 1];
        }
    }

    /**
     * Removes the element stored at the specified position.
     * 
     * @param the
     *            element's position within the array. A number between 0 and {@link #size()}-1.
     */
    public void remove(int index) {
        elements[index] = null;
    }

    /**
     * Returns the element stored at the specified position.
     * 
     * @param index
     *            the element's position within the array. A number between 0 and {@link #size()}-1.
     * 
     * @return the
     */
    public Object get(int index) {
        if(elements[index].getClass().equals(Course.class)) {
            return (Course) elements[index];
        } else if( elements[index].getClass().equals(ExaminationResult.class)) {
            return (ExaminationResult) elements[index];
        }
        return "Error";
    }

    /**
     * @return the number of elements stored in this array list.
     */
    public int size() {
        return getActualSize();
    }
    public void doubleCapacity() {
        Object[] temp = elements;
        elements = new Object[2*DEFAULT_CAPACITY];
        for (int i = 0; i < getActualSize() - 1; i++) {
            elements[i] = temp[i];
        }
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }
    public String toString(String x) {
        String result = (String)elements[0];
        for(int i = 1; i < actualSize - 1; i++) {
            result = result + "," + elements[i];
        }
        return result;
    }

}
