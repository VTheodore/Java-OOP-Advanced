package Generics.p03;

public class Scale<T extends Comparable<T>> {
    private T left;

    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        if (this.left.compareTo(right) < 0){
            return this.right;
        }

        if (this.left.compareTo(right) > 0){
            return this.left;
        }

        return null;
    }
}
