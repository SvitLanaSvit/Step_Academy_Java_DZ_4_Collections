package org.example.see_boats;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BoatMooringSimulation {
    public static void main(String[] args) {
        //Завдання 1:
        //Створити імітаційну модель “причал морських катерів”. Необхідно вводити наступну інформацію:
        //1. середній час між появою пасажирів на причалі в різний час доби,
        //2. середній час між появою катерів на причалі в різний час доби,
        //3. тип зупинки катера (кінцева чи ні)
        int averagePassengerArrivalTime = 10; // Average time between passenger arrivals (in minutes)
        int boatsArrivalInterval = 20; // Average time between boat arrivals (in minutes)
        int maxPassengersAtPier = 20; // Maximum number of passengers at the pier
        boolean isFinalStop = false; // Whether it's a final boat stop

        Pier pier = new Pier(maxPassengersAtPier, boatsArrivalInterval);
        Queue<Boat> boatsQueue = new LinkedList<>();

        while(true){
            if(!pier.isPierFull() || !isFinalStop){
                Boat boat = new Boat();
                boatsQueue.offer(boat);
            }

            pier.simulateBoatArrival(boatsQueue);

            if (pier.isPierFull() && isFinalStop){
                System.out.println("Final boat stop. Pier is full.");
                break;
            }

            // Simulate passenger arrivals at the pier
            int passengersArriving = new Random().nextInt(5) + 1; // Random passengers
            System.out.println(passengersArriving + " passengers arrived at the pier.");
            pier.advanceTime(averagePassengerArrivalTime);
        }
    }
}
