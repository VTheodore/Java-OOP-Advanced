package IteratorsAndComparatorsEXC.p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        Integer[] nums = Arrays.stream(in.readLine().split("[, ]+")).map(Integer::parseInt).toArray(Integer[]::new);
        Lake lake = new Lake(nums);

        StringBuilder sb = new StringBuilder();
        for (Integer num : lake) {
            sb.append(num).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length() - 1);

        System.out.println(sb.toString());
    }
}
