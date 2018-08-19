package Generics.p01;

public class Main {
    public static void main(String[] args) {
        Jar<String> arr = new Jar<>();

        arr.add("kur");
        arr.add("nq");
        arr.add("da");
        arr.add("l");

        System.out.println(arr.remove());
    }
}
