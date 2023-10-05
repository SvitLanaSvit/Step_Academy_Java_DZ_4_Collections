package org.example.see_boats;
import java.util.Queue;

public class Pier {
    private final int maxPassengers;
    private int currentPassengers;
    private final int boatsArrivalInterval;
    private long currentTime;

    public Pier(int maxPassengers, int boatsArrivalInterval) {
        this.maxPassengers = maxPassengers;
        this.boatsArrivalInterval = boatsArrivalInterval;
        this.currentTime = 0;
        this.currentPassengers = 0;
    }

    public int getBoatsArrivalInterval() {
        return boatsArrivalInterval;
    }

    public void advanceTime(int minutes){
        currentTime += minutes;
    }

    public void simulateBoatArrival(Queue<Boat> boatsQueue){
        if(boatsQueue.isEmpty()){
            System.out.println("No boats are waiting. Pier is empty.");
            return;
        }

        Boat boat = boatsQueue.poll();

        // Simulate passengers getting off the boat
        int passengersOff = Math.min(boat.getFreeSeats(), currentPassengers);
        currentPassengers -= passengersOff;

        // Simulate passengers getting on the boat
        int passengersOn = Math.min(maxPassengers - currentPassengers, boat.getFreeSeats());
        currentPassengers += passengersOn;

        System.out.println("Time: " + currentTime + " minutes");
        System.out.println("Boat arrived with " + boat.getFreeSeats() + " seats.");
        System.out.println(passengersOff + " passengers got off, and " + passengersOn + " passengers got on.");
        System.out.println("Current passengers at the pier: " + currentPassengers);
        System.out.println("-----------------------------");
    }

    public boolean isPierFull(){
        return currentPassengers >= maxPassengers;
    }
}
