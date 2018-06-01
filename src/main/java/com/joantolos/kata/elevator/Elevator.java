package com.joantolos.kata.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private Floor currentFloor;
    private Boolean inMotion;
    private List<Floor> floorRequests;

    public Elevator(Floor startingFloor) {
        this.currentFloor = startingFloor;
        this.inMotion = false;
        this.floorRequests = new ArrayList<>();
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public Boolean isInMotion() {
        return inMotion;
    }

    public void requestFloor(Floor newFloor) {
        this.floorRequests.add(newFloor);
    }

    public void attendRequests() {
        this.floorRequests.forEach(this::moveToFloor);
    }

    private void moveToFloor(Floor newFloor) {
        try {
            this.inMotion = true;
            Thread.sleep(howMuchTimeItTakes(newFloor));
            this.currentFloor = newFloor;
            this.inMotion = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected int howMuchTimeItTakes(Floor newFloor) {
        return (Math.abs(newFloor.getNumber() - this.currentFloor.getNumber()) * 100) + 400;
    }
}
