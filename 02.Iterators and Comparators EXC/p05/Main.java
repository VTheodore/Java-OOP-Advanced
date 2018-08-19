package IteratorsAndComparatorsEXC.p05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String line;

        PeopleList peopleList = new PeopleList();
        while (!"END".equals((line = in.readLine()))){
            String[] cmdArgs = line.split("\\s+");

            Person person = new Person(cmdArgs[0], Integer.parseInt(cmdArgs[1]), cmdArgs[2]);
            peopleList.addPerson(person);
        }

        int index = Integer.parseInt(in.readLine());

        System.out.println(peopleList.getInfo(index));
    }
}
