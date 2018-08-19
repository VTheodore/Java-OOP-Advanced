package IteratorsAndComparatorsEXC.p06;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() - o2.getName().length() > 0){
            return 1;
        }else if (o1.getName().length() - o2.getName().length() < 0){
            return -1;
        }

        if (o1.getName().toLowerCase().charAt(0) - o2.getName().toLowerCase().charAt(0) > 0){
            return 1;
        }else if (o1.getName().toLowerCase().charAt(0) - o2.getName().toLowerCase().charAt(0) < 0){
            return -1;
        }

        return 0;
    }
}
