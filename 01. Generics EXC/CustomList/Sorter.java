package GenericsEXC.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        List<T> elements = new ArrayList<>();

        for (T t : list) {
            elements.add(t);
        }

        Collections.sort(elements);

        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {
            list.remove(0);
        }

        for (T element : elements) {
            list.add(element);
        }
    }
}
