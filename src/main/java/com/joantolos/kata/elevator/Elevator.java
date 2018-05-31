package com.joantolos.kata.elevator;

import java.util.List;

public class Elevator {

    private final Integer id;
    private final String name;
    private Floor currentFloor;
    private Boolean inMotion;
    private List<Floor> floorRequests;

    public Elevator(Integer id, String name, Floor startingFloor) {
        this.id = id;
        this.name = name;
        this.currentFloor = startingFloor;
        this.inMotion = false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public Boolean isInMotion() {
        return inMotion;
    }

    public void requestFloor(Floor newFloor) {
        this.moveToFloor(newFloor);
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
