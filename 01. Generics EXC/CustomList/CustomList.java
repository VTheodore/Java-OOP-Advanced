package GenericsEXC.CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public T remove(int index){
        if (index < 0 || index >= this.elements.size()){
            throw new ArrayIndexOutOfBoundsException("Check your index fella !");
        }

        return this.elements.remove(index);
    }

    public boolean contains(T element){
        if (!this.elements.contains(element)){
            return false;
        }

        return true;
    }

    public void swap(int index, int index1){
        T temp = this.elements.get(index);
        this.elements.set(index, this.elements.get(index1));
        this.elements.set(index1, temp);
    }

    public int countGreaterThan(T element){
        int count = 0;

        for (T t : elements) {
            if (t.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }

    public T getMax(){
        if (this.elements.isEmpty()){
            throw new IllegalArgumentException("Empty list !");
        }

        T max = this.elements.get(0);

        for (T element : elements) {
            if (element.compareTo(max) > 0){
                max = element;
            }
        }

        return max;
    }

    public T getMin(){
        if (this.elements.isEmpty()){
            throw new IllegalArgumentException("Empty list !");
        }

        T min = this.elements.get(0);

        for (T element : elements) {
            if (element.compareTo(min) < 0){
                min = element;
            }
        }

        return min;
    }

    public int size(){
        return this.elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator();
    }

    private final class CustomListIterator implements Iterator<T>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < elements.size();

        }

        @Override
        public T next() {
            return elements.get(counter++);
        }
    }
}
