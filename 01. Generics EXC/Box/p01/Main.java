package GenericsEXC.Box.p01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        int numberOfBoxes = Integer.parseInt(in.readLine());
        List<Box<String>> boxes = new ArrayList<>();

        while (numberOfBoxes-- > 0){
            String value = in.readLine();

            var box = new Box<>(value);
            boxes.add(box);

            System.out.println(box.toString());
        }
    }
}
