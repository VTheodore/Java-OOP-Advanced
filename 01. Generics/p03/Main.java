package Generics.p03;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "v");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(5, 1);
        System.out.println(integerScale.getHeavier());
    }
}
