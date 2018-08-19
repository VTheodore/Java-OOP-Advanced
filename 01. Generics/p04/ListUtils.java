package Generics.p04;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable> T getMin(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException("Empty list !");
        }

        T min = list.get(0);

        for (T t : list) {
            if (min.compareTo(t) > 0){
                min = t;
            }
        }

        return min;
    }

    public static <T extends Comparable> T getMax(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException("Empty list !");
        }

        T max = list.get(0);

        for (T t : list) {
            if (max.compareTo(t) < 0){
                max = t;
            }
        }

        return max;
    }
}
