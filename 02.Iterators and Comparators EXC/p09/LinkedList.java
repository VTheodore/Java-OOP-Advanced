package IteratorsAndComparatorsEXC.p09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> collection;

    public LinkedList() {
        this.collection = new ArrayList<>();
    }

    public void add(T element){
        this.collection.add(element);
    }

    public boolean remove(T element){
        for (T t : collection) {
            if (t.compareTo(element) == 0){
                this.collection.remove(t);
                return true;
            }
        }

        return false;
    }

    public int getSize(){
        return this.collection.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private final class LinkedListIterator implements Iterator<T>{
        private int cursor;

        @Override
        public boolean hasNext() {
            return this.cursor < collection.size();
        }

        @Override
        public T next() {
            return collection.get(this.cursor++);
        }
    }
}
