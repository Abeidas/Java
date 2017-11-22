

/**
 * Clients should implement this interface when they manage a collection of numbers for which statistics should be
 * provided.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * 
 * @version 1.0
 *
 * @param <T>
 *            the type of numbers managed by the client
 */
public interface StatisticsProvider<T extends Number> {

    /**
     * @return the smallest value stored in this collection; <code>null</code>, if the collection is empty.
     */
    public T min();

    /**
     * @return the largest value stored in this collection; <code>null</code>, if the collection is empty.
     */
    public T max();

    /**
     * @return the arithmetic mean of all value stored in this collection; <code>null</code>, if the collection is
     *         empty.
     */
    public Double average();

    /**
     * @return the sum of all value stored in this collection; <code>null</code>, if the collection is empty.
     */
    public Double sum();

}