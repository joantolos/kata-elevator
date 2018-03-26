package com.joantolos.kata.elevator;

public class Elevator {

    private final Integer id;
    private final String name;
    private Integer currentFloor;

    public Elevator(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.currentFloor = 0;
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

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }
}
