package com.joantolos.kata.elevator;

public class Elevator {

    private final Integer id;
    private final String name;
    private Floor currentFloor;
    private Boolean inMotion;

    public Elevator(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.currentFloor = new Floor(false, 0);
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

    public void moveToFloor(Floor newFloor) {
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
