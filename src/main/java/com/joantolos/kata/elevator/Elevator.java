package com.joantolos.kata.elevator;

public class Elevator {

    private final Integer id;
    private final String name;
    private Integer currentFloor;
    private Boolean inMotion;

    public Elevator(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.currentFloor = 0;
        this.inMotion = false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public Boolean isInMotion() {
        return inMotion;
    }

    public void moveToFloor(Integer newFloor) {
        this.inMotion = true;
        this.currentFloor = newFloor;
        this.inMotion = false;
    }
}
