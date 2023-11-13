package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Pier {
    private Queue<Integer> passengersQueue;
    private Boat currentBoat;
    public Pier(){
        this.passengersQueue=new LinkedList<>();
        this.currentBoat=null;
    }
    public void addPassenger(int numberOfPassengers){
        passengersQueue.add(numberOfPassengers);
    }
    public boolean isBoatAvailable() {
        return currentBoat == null;
    }

    public void moorBoat(Boat boat) {
        currentBoat = boat;
    }

    public int unloadBoat() {
        if (currentBoat != null) {
            int passengers = passengersQueue.poll();
            currentBoat = null;
            return passengers;
        }
        return 0;
    }
    public int getPassengersQueueSize() {
        return passengersQueue.size();
    }
}
