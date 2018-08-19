package GenericsEXC.Box.p06;

import java.util.List;

public class Box<T extends Comparable<T>> {
    T value;

    public Box(T item) {
        this.value = item;
    }

    public int countOfElementsGreaterThanValue(List<T> el){
        int count = 0;

        for (T t : el) {
            if (t.compareTo(this.value) > 0){
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }
}
