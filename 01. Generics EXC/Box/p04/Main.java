package GenericsEXC.Box.p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStrings = Integer.parseInt(in.readLine());

        List<Box> boxes = new ArrayList<>();

        while (numberOfStrings-- > 0){
            Integer value = Integer.valueOf(in.readLine());

            Box<Integer> box = new Box<>(value);

            boxes.add(box);
        }

        String[] arguments = in.readLine().split(" ");
        int startingPosition = Integer.parseInt(arguments[0]);
        int desiredPosition = Integer.parseInt(arguments[1]);

        swap(startingPosition, desiredPosition, boxes);

        for (Box box : boxes) {
            System.out.println(box.toString());
        }
    }
    private static <T> void swap(int startingPosition, int desiredPosition, List<Box> boxes){
        Box<T> temp = boxes.get(startingPosition);
        boxes.set(startingPosition, boxes.get(desiredPosition));
        boxes.set(desiredPosition, temp);
    }
}