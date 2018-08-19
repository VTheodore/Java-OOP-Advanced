package Generics.p05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{
           add(1);
           add(null);
           add(2);
           add(null);
           add(null);
        }};

        System.out.println(ListUtils.getNullIndices(integers));

        List<String> strings = new ArrayList<>(){{
            add("this");
            add(null);
            add("iss");
            add(null);
            add(null);
            add(null);
            add(null);
            add("painful");
        }};

        System.out.println(ListUtils.getNullIndices(strings));
    }
}
