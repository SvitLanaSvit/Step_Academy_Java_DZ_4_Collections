package org.example.see_boats;

import java.util.Random;

public class Boat {
    private final int freeSeats;

    public Boat(){
        freeSeats = new Random().nextInt(10) + 1;
    }

    public int getFreeSeats() {
        return freeSeats;
    }
}