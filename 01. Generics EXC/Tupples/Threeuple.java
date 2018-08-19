package GenericsEXC.Tupples;

public class Threeuple<T, E, K> extends Tupple{
    private K item3;

    public Threeuple(T item1, E item2, K item3) {
        super(item1, item2);
        this.setItem3(item3);
    }

    protected K getItem3() {
        return this.item3;
    }

    private void setItem3(K item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", super.getItem1(), super.getItem2(), this.getItem3());
    }
}
