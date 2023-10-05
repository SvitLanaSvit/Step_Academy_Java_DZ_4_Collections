package org.example.tax_inspection_database;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String id;
    private final String name;
    private final List<Fine> fines;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
        fines = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addFine(Fine fine){
        fines.add(fine);
    }

    public void removeFine(Fine fine){
        fines.remove(fine);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + "\nFines: " + fines;
    }
}