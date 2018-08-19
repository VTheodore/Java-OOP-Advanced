package IteratorsAndComparatorsEXC.p08;

import java.util.ArrayList;
import java.util.List;

public class Clinic{
    private String name;

    private List<Room> rooms;

    private int cursor;

    private int i;

    private boolean isEvenTurn = true;

    public Clinic(String name, int rooms) {
        this.setName(name);
        this.setRooms(rooms);
        this.cursor = this.rooms.size() / 2 ;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

//
//    public List<IteratorsAndComparatorsEXC.p08.Room> getRooms() {
//        return this.rooms;
//    }

    private void setRooms(int rooms) {
        if (rooms % 2 == 0){
            throw new IllegalArgumentException("Invalid operation!");
        }

        this.rooms = new ArrayList<>();

        for (int i = 0; i < rooms; i++) {
            this.rooms.add(new Room());
        }
    }

    public boolean addPet(Pet pet){
        try {
            if (this.isEvenTurn){
                this.cursor += this.i;
                Room room  = this.rooms.get(this.cursor);
                this.i++;
                this.isEvenTurn = false;

                if (room.isEmpty()){
                    room.addPet(pet);

                    return true;
                }

                return false;
            }

            this.cursor -= this.i;
            Room room  = this.rooms.get(this.cursor);
            this.i++;
            this.isEvenTurn = true;

            if (room.isEmpty()){
                room.addPet(pet);
                return true;
            }
        }catch (Exception ex){
            return false;
        }

        return false;
    }

    public boolean release(){
        final int MIDDLE_ROOM = this.rooms.size() / 2 ;

        for (int j = MIDDLE_ROOM; j < this.rooms.size(); j++) {
            Room room = this.rooms.get(j);

            if (!room.isEmpty()){
                room.releasePet();
                this.cursor = this.rooms.size() / 2;
                this.i = 0;
                return true;
            }
        }

        for (int j = 0; j < MIDDLE_ROOM; j++) {
            Room room = this.rooms.get(j);

            if (!room.isEmpty()){
                room.releasePet();
                this.cursor = this.rooms.size() / 2;
                this.i = 0;
                return true;
            }
        }

        return false;
    }

    public boolean hasEmptyRooms(){
        for (Room room : rooms) {
            if (room.isEmpty())return true;
        }

        return false;
    }

    public Room getRoom(int index){
        return this.rooms.get(index);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (Room room : rooms) {
            sb.append(room.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
