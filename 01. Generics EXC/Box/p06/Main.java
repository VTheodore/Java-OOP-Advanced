package GenericsEXC.Box.p06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        int countOfLines = Integer.parseInt(in.readLine());

        List<Double> elements = new ArrayList<>();

        while (countOfLines-- > 0){
            Double element = Double.valueOf(in.readLine());

            elements.add(element);
        }

        Double value = Double.valueOf(in.readLine());

        Box<Double> box = new Box<>(value);

        System.out.println(box.countOfElementsGreaterThanValue(elements));
    }
}
