package EnumsAndAnnotationsEXC.p07;

public enum  CardSuit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int value;
    CardSuit(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
