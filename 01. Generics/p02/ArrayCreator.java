package Generics.p02;

import java.lang.reflect.Array;


public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T item){
        T[] arr = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }

        return arr;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> cl, int length, T item){
        T[] arr = (T[]) Array.newInstance(cl, length);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }

        return arr;
    }
}


