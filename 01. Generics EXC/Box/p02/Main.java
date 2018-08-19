package GenericsEXC.Box.p02;

import GenericsEXC.Box.p01.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        int numberOfIntegers = Integer.parseInt(in.readLine());

        List<Box<Integer>> boxes = new ArrayList<>();
        while (numberOfIntegers-- > 0){
            Integer value = Integer.valueOf(in.readLine());
            Box<Integer> box = new Box<>(value);

            System.out.println(box.toString());
            boxes.add(box);
        }
    }
}
