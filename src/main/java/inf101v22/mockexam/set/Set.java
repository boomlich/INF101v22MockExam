package inf101v22.mockexam.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set <T> implements ISet <T>{

    private ArrayList<T> set;

    public Set() {
        set = new ArrayList<>();
    }

    public Set(ArrayList<T> elements) {
        this();
        addAll(elements);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public void add(T element) {
        if (!set.contains(element)) {
            set.add(element);
        }
    }

    @Override
    public void addAll(Iterable<T> other) {
        for (T element: other) {
            add(element);
        }
    }

    @Override
    public void remove(T element) {
        if (set.contains(element)) {
            set.remove(element);
        } else {
            throw new NoSuchElementException();
        }

    }

    @Override
    public boolean contains(T element) {
        return set.contains(element);
    }

    @Override
    public ISet<T> union(ISet<T> other) {
        ISet<T> unionSet = copy();
        for (T element : other) {
            unionSet.add(element);
        }
        return unionSet;
    }

    @Override
    public ISet<T> intersection(ISet<T> other) {
        ArrayList<T> intersection = new ArrayList<>();
        for (T element: other) {
            if (set.contains(element)) {
                intersection.add(element);
            }
        }
        return new Set<>(intersection);
    }

    @Override
    public ISet<T> complement(ISet<T> other) {
        ISet<T> complimentSet = copy();
        for (T element: other) {
            if (complimentSet.contains(element)) {
                complimentSet.remove(element);
            }
        }
        return complimentSet;
    }

    @Override
    public ISet<T> copy() {
        return new Set<T>(set);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
