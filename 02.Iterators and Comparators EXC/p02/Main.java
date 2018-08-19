package IteratorsAndComparatorsEXC.p02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String line;

        ListyIterator li = null;
        while (!"END".equals((line = in.readLine()))){
            String[] cmdArgs = line.split(" ");

            switch (cmdArgs[0]){
                case "Create":
                    li = new ListyIterator(Arrays.stream(cmdArgs).skip(1).toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(li.move());
                    break;
                case "HasNext":
                    System.out.println(li.hasNext());
                    break;
                case "Print":
                    try {
                        li.print();
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "PrintAll":
                    try {
                        li.printAll();
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }
    }
}
