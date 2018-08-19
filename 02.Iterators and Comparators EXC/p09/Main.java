package IteratorsAndComparatorsEXC.p09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        while (n-- > 0){
            String[] cmdArgs = in.readLine().split("\\s+");

            switch (cmdArgs[0]){
                case "Add":
                    list.add(Integer.valueOf(cmdArgs[1]));
                    break;
                case "Remove":
                    list.remove(Integer.valueOf(cmdArgs[1]));
                    break;
            }
        }

        System.out.println(list.getSize());

        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }
}
