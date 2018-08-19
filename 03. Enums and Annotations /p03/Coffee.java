package EnumsAndAnnotations.p03;

public class Coffee {
    private CoffeeType type;

    private CoffeeSize size;

    public Coffee(String size, String type) {
        this.setSize(size);
        this.setType(type);
    }

    private void setType(String type) {
        this.type = Enum.valueOf(CoffeeType.class, type.toUpperCase());
    }

    private void setSize(String size) {
        this.size = Enum.valueOf(CoffeeSize.class, size.toUpperCase());
    }

    public CoffeeSize getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return String.format("\"%s %s\" sold", this.size.toString(), this.type.toString());
    }
}
