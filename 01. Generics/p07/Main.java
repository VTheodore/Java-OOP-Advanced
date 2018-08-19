package Generics.p07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{
            add(1);
            add(211);
            add(null);
            add(112);
            add(null);
        }};

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 123.3, 1231.3, 56.1, 1235.3);

        List<Number> destination = new ArrayList<>();

        ListUtils.addAll(destination, doubles);
        ListUtils.addAll(destination, integers);

        System.out.println(destination);
    }
}
