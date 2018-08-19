package IteratorsAndComparatorsEXC.p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        var tree = new TreeSet<Person>(new PersonComparator());
        var hash = new HashSet<Person>();

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0){
            String[] cmdArgs = in.readLine().split("\\s+");

            Person person = new Person(cmdArgs[0], Integer.parseInt(cmdArgs[1]));

            tree.add(person);
            hash.add(person);
        }

        System.out.println(tree.size());
        System.out.println(hash.size());
    }
}
