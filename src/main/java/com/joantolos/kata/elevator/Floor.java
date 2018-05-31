package com.joantolos.kata.elevator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return Objects.equals(underground, floor.underground) &&
                Objects.equals(number, floor.number);
    }

    @Override
    public int hashCode() {

        return Objects.hash(underground, number);
    }
}
