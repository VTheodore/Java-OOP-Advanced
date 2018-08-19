package Generics.p01;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> arr;

    public Jar() {
        this.arr = new ArrayDeque<>();
    }

    public void add(T element){
        this.arr.add(element);
    }

    public T remove(){
        if (!this.arr.isEmpty()){
            return this.arr.pollLast();
        }

        return null;
    }
}
