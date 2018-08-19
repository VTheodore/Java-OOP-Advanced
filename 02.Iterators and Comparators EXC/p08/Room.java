package IteratorsAndComparatorsEXC.p08;

public class Room {
    private Pet pet;

    public Room() {
        this.pet = null;
    }

    public void addPet(Pet pet){
        this.pet = pet;
    }

    public void releasePet(){
        this.pet = null;
    }

    public boolean isEmpty(){
        return this.pet == null;
    }

    @Override
    public String toString() {
        if (this.isEmpty()){
            return "IteratorsAndComparatorsEXC.p08.Room empty";
        }

        return String.format("%s %d %s", this.pet.getName(), this.pet.getAge(), this.pet.getKind());
    }
}
