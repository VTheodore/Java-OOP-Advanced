package Generics.p06;

import java.util.ArrayList;
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

    public static <T> List<Integer> getNullIndices(List<T> list){
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null){
                indices.add(i);
            }
        }

        return indices;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source){
        for (List<? extends T> list : source) {
            destination.addAll(list);
        }
    }
}
