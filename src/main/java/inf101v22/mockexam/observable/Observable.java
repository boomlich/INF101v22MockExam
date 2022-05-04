package inf101v22.mockexam.observable;

public interface Observable<E> {

    /**
     * Adds a (non-null) observer. The {@link Observer#update update} method on the
     * added observer will be called every time the value of the observed variable
     * changes. It will not be called immediately on the observer being installed,
     * only when the variable changes. To get the current value, use the
     * {@link #getValue} method.
     * 
     * @param observer to be added.
     */
    public void addObserver(Observer observer);

    /**
     * Removes a (non-null) observer.
     * 
     * @param observer to be removed.
     * @return true if the observer was removed, and false if the observer was not
     *         found.
     */
    public boolean removeObserver(Observer observer);

    /** Gets the current value. */
    public E getValue();

}
