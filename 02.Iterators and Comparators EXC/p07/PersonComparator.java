package IteratorsAndComparatorsEXC.p07;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().compareTo(o2.getName())> 0){
            return 1;
        }else if (o1.getName().compareTo(o2.getName())< 0){
            return -1;
        }

        if (o1.getAge() - o2.getAge() > 0){
            return 1;
        }else if (o1.getAge() - o2.getAge() < 0){
            return -1;
        }

        return 0;
    }
}
