package Generics.p02;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.create(10, 10);

        String[] arr1 = ArrayCreator.create(String.class, 10, "string");

        for (Integer num : arr) {
            System.out.println(num);
        }

        for (String s : arr1) {
            System.out.println(s);
        }
    }
}
