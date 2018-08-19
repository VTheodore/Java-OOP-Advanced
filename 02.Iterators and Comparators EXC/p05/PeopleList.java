package IteratorsAndComparatorsEXC.p05;

import java.util.ArrayList;
import java.util.List;

public class PeopleList {
    List<Person> people;

    public PeopleList() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person){
        this.people.add(person);
    }

    public String getInfo(int index){
        Person person = this.people.get(index - 1);

        int equalPeople = 0;

//        for (int i = 0; i < this.people.size(); i++) {
//            if (index - 1 == i)continue;
//
//            IteratorsAndComparatorsEXC.p05.IteratorsAndComparatorsEXC.p06.IteratorsAndComparatorsEXC.p07.Person p = this.people.get(i);
//
//            if (person.compareTo(p) == 0){
//                equalPeople++;
//            }
//        }

        for (Person p : this.people) {
            if (person.compareTo(p) == 0){
                equalPeople++;
            }
        }

        if (equalPeople == 1){
            return "No matches";
        }

        int unequalPeople = this.people.size() - equalPeople;

        return String.format("%d %d %d", equalPeople, unequalPeople, this.people.size());
    }
}
