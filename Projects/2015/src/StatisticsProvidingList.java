

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A list of {@link Integer}s that keeps track of certain statistics:
 * <ul>
 * <li>minimum</li>
 * <li>maximum</li>
 * <li>average (arithmetic mean)</li>
 * <li>sum</li>
 * </ul>
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * @author <your name as the second author goes here>
 * 
 * @version 0.1
 *
 */
public class StatisticsProvidingList implements List<Integer>, StatisticsProvider<Integer> {

    private List<Integer> numbersList;

    public StatisticsProvidingList() {
        // TODO don't forget to set numbersList here
    }

    @Override
    public Integer min() {
        return numbersList.get(0);
    }

    @Override
    public Double average() {
        // TODO implement this method
        return -1.0;
    }
    
    // TODO two methods are missing here...

    @Override
    public void add(int index, Integer element) {
        numbersList.add(index, element);
    }

    @Override
    public boolean add(Integer e) {
        return numbersList.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return numbersList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return numbersList.addAll(index, c);
    }

    @Override
    public void clear() {
        numbersList.clear();
    }

    @Override
    public boolean contains(Object o) {
        return numbersList.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return numbersList.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return numbersList.equals(o);
    }

    @Override
    public Integer get(int index) {
        return numbersList.get(index);
    }

    @Override
    public int hashCode() {
        return numbersList.hashCode();
    }

    @Override
    public int indexOf(Object o) {
        return numbersList.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        return numbersList.isEmpty();
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbersList.iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        return numbersList.lastIndexOf(o);
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return numbersList.listIterator();
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return numbersList.listIterator(index);
    }

    @Override
    public Integer remove(int index) {
        return numbersList.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return numbersList.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return numbersList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return numbersList.retainAll(c);
    }

    @Override
    public Integer set(int index, Integer element) {
        return numbersList.set(index, element);
    }

    @Override
    public int size() {
        return numbersList.size();
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return numbersList.subList(fromIndex, toIndex);
    }

    @Override
    public Object[] toArray() {
        return numbersList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return numbersList.toArray(a);
    }

}