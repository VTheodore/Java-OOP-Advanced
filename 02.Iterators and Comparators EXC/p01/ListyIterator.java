package IteratorsAndComparatorsEXC.p01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
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
}
