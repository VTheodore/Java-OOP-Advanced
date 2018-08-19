package GenericsEXC.Box.p05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        int countOfLines = Integer.parseInt(in.readLine());

        List<String> elements = new ArrayList<>();

        while (countOfLines-- > 0){
            String element = in.readLine();

            elements.add(element);
        }

        String value = in.readLine();

        Box<String> box = new Box<>(value);

        System.out.println(box.countOfElementsGreaterThanValue(elements));
    }
}
