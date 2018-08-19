package GenericsEXC.Box.p03;

public class Box<T> {
    T value;

    public Box(T item) {
        this.value = item;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }
}
