package IteratorsAndComparatorsEXC.p08;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClinicManager {
    private Map<String, Pet> pets;

    private Map<String, Clinic> clinics;

    public ClinicManager() {
        this.pets = new LinkedHashMap<>();
        this.clinics = new LinkedHashMap<>();
    }

    public void createPet(String name, int age, String kind){
        Pet pet = new Pet(name, age, kind);
        this.pets.put(name, pet);
    }

    public void createClinic(String name, int rooms){
        Clinic clinic = new Clinic(name, rooms);
        this.clinics.put(name, clinic);
    }

    public boolean add (String petName, String clinicName){
        Clinic clinic = this.clinics.get(clinicName);
        Pet pet = this.pets.get(petName);

        return clinic.addPet(pet);
    }

    public boolean release(String clinicsName){
        Clinic clinic = this.clinics.get(clinicsName);

        return clinic.release();
    }

    public boolean hasEmptyRooms(String clinicsName){
        Clinic clinic = this.clinics.get(clinicsName);

        return clinic.hasEmptyRooms();
    }

    public void print(String clinicName){
        Clinic clinic = this.clinics.get(clinicName);

        System.out.println(clinic.toString());
    }

    public void print(String clinicName, int room){
        Clinic clinic = this.clinics.get(clinicName);
        Room room1 = clinic.getRoom(room - 1);

        System.out.println(room1);
    }
}
