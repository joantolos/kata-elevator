package com.joantolos.kata.elevator;

public class Elevator {

    private final Integer id;
    private final String name;

    public Elevator(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
