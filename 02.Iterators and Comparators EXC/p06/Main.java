package IteratorsAndComparatorsEXC.p06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        var peopleByName = new TreeSet<Person>(new PersonNameComparator());
        var peopleByAge = new TreeSet<Person>(new PersonAgeComparator());

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0){
            String[] cmdArgs = in.readLine().split("\\s+");

            Person person = new Person(cmdArgs[0], Integer.parseInt(cmdArgs[1]));

            peopleByName.add(person);
            peopleByAge.add(person);
        }

        for (Person person : peopleByName) {
            System.out.println(person.toString());
        }

        for (Person person : peopleByAge) {
            System.out.println(person.toString());
        }
    }
}
