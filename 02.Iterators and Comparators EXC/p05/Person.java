package IteratorsAndComparatorsEXC.p05;

public class Person implements Comparable<Person> {
    private String name;

    private int age;

    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.getName()) > 0){
            return 1;
        }else if (this.name.compareTo(o.getName()) < 0){
            return -1;
        }

        if (this.age - o.getAge() > 0){
            return 1;
        }else if (this.age - o.getAge() < 0){
            return -1;
        }

        if (this.town.compareTo(o.getTown()) > 0){
            return 1;
        }else if (this.town.compareTo(o.getTown()) < 0){
            return -1;
        }

        return 0;
    }
}
