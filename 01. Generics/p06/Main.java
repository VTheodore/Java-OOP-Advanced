package Generics.p06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{
            add(5);
            add(23);
            add(523);
            add(123);
            add(435);
            add(5);
        }};

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 12.31, 123123.1214, 56453.3);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, integers, doubles);

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, jagged);

        System.out.println(dest);
    }
}
