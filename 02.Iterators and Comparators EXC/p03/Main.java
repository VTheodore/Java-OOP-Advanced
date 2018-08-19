package IteratorsAndComparatorsEXC.p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String line;

        Stack<Integer> stack = new Stack<>();
        while (!"END".equals((line = in.readLine()))){
            String[] cmdArgs = line.split(" ", 2);

            switch (cmdArgs[0]){
                case "Push":
                    Integer[] nums = Arrays.stream(cmdArgs[1].split("[, ]+")).map(Integer::parseInt).toArray(Integer[]::new);
                    stack.push(nums);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Integer num : stack) {
                System.out.println(num);
            }
        }
    }
}
