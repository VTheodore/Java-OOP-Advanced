package IteratorsAndComparatorsEXC.p07;

import java.util.Objects;

public class Person {
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        int hash = 0;

        for (char c : this.getName().toCharArray()) {
            if (c % 2 == 0){
                hash += c;
            }else{
                hash *= c;
            }
        }

        hash  = (int) (hash * Math.PI);

        return hash;
    }


}
