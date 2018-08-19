package Generics.p04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{
            add(5);
            add(6);
            add(18);
        }};

        Integer maxInteger = ListUtils.getMax(integers);
        System.out.println(maxInteger);

        List<String> strings = new ArrayList<>(){{
           add("this");
           add("a");
           add("addd");
           add("tiredOf this maaaaan");
        }};

        String minString = ListUtils.getMin(strings);
        System.out.println(minString);

    }
}
