package com.joantolos.kata.elevator;

public class Floor {

    private final Boolean underground;
    private final Integer number;

    public Floor(Boolean underground, Integer number) {
        this.underground = underground;
        this.number = number;
    }

    public Boolean isUnderground() {
        return underground;
    }

    public Integer getNumber() {
        return number;
    }
}
