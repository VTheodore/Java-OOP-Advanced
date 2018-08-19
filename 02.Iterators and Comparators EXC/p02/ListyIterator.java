package IteratorsAndComparatorsEXC.p02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> collection;
    private int index;

    public ListyIterator(String... collection) {
        this.setCollection(collection);
    }

    private void setCollection(String[] collection) {
        this.collection = new ArrayList<>(Arrays.asList(collection));
        /*
        if (collection.length == 0){
            this.collection = new ArrayList<>();
        }else {
            this.collection = new ArrayList<>(Arrays.asList(collection));
        }
        */
    }

    public boolean move(){
        if (this.hasNext()){
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext(){
        if (this.index < this.collection.size() - 1){
            return true;
        }
        return false;
    }

    public void print(){
        if (this.collection.isEmpty()){
            throw new IllegalArgumentException("Invalid Operation!");
        }

        System.out.println(this.collection.get(this.index));
    }

    public void printAll(){
        if (this.collection.isEmpty()){
            throw new IllegalArgumentException("Invalid Operation!");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : this) {
           sb.append(s).append(" ");
        }

        System.out.println(sb.toString());
    }

    @Override
    public Iterator iterator() {
        return new ListyIteratorIterator();
    }

    private final class ListyIteratorIterator implements Iterator<String>{
        private int cursor;

        @Override
        public boolean hasNext() {
            return this.cursor < collection.size();
        }

        @Override
        public String next() {
            return collection.get(cursor++);
        }
    }
}
