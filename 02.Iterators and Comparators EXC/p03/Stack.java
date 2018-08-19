package IteratorsAndComparatorsEXC.p03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<Integer> implements Iterable<Integer> {
    private List<Integer> collection;

    public Stack(Integer... items) {
        this.collection = new ArrayList<>();
    }

    public void push(Integer[] items) {
       this.collection.addAll(Arrays.asList(items));
    }

    public Integer pop(){
        if (this.collection.isEmpty()){
            throw new IllegalArgumentException("No elements");
        }
        return this.collection.remove(this.collection.size() - 1);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer>{
        private int cursor = collection.size() - 1;

        @Override
        public boolean hasNext() {
            if (cursor < 0){
                return false;
            }

            return true;
        }

        @Override
        public Integer next() {
            return collection.get(cursor--);
        }
    }

}
