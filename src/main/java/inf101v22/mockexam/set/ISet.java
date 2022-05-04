package inf101v22.mockexam.set;

public interface ISet<T> extends Iterable<T> {

    /**
     * Number of elements in the set
     * 
     * @return number of elements in the set.
     */
    public int size();

    /**
     * Add element to the set. If element is already in the set then it should not
     * set then it should not be added again, i.e. no duplicates.
     * 
     * An element <code>elem</code> is considered to be in the set
     * if there is an element <code>other</code> which is equal,
     * i.e. <code>elem.equals(other) == true</code>.
     */
    public void add(T element);

    /**
     * Add all elements from <code>other</code> to the set.
     * 
     * @param other
     */
    public void addAll(Iterable<T> other);

    /**
     * Remove element from set.
     * 
     * @param element
     * @throws NoSuchElementException if <code>element</code> is not in the set.
     */
    public void remove(T element);

    /**
     * Check if <code>element</code> is in the set.
     * 
     * @param element
     * @return true if <code>element</code> is in the set, false if not.
     */
    public boolean contains(T element);

    /**
     * Create the union of the set and <code>other</code>
     * Definition of
     * <a href="https://en.wikipedia.org/wiki/Union_(set_theory)">union</a>
     * 
     * @param other
     * @return union of the set and <code>other</code>
     */
    public ISet<T> union(ISet<T> other);

    /**
     * Create the intersection of the set and <code>other</code>
     * Definition of
     * <a href="https://en.wikipedia.org/wiki/Intersection_(set_theory)">union</a>
     * 
     * @param other
     * @return intersection of the set and <code>other</code>
     */
    public ISet<T> intersection(ISet<T> other);

    /**
     * Create the complement of the set and <code>other</code>
     * Definition of
     * <a href="https://en.wikipedia.org/wiki/Complement_(set_theory)">complement</a>
     * 
     * @param other
     * @return complement of the set and <code>other</code>
     */

    public ISet<T> complement(ISet<T> other);

    /**
     * Create a new set with the same elements.
     * @return copy of set
     */
    public ISet<T> copy();

}
