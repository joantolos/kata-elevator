package com.joantolos.kata.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hospital {

    private List<Elevator> elevators;
    private List<Floor> floors;

    public Hospital(Integer overGroundFloors, Integer underGroundFloors) {
        this.elevators = new ArrayList<>();
        this.elevators.add(new Elevator(1, "ElevatorOne"));
        this.elevators.add(new Elevator(2, "ElevatorTwo"));

        this.floors = new ArrayList<>();
        IntStream.range(0, overGroundFloors).forEach(floor -> this.floors.add(new Floor(false, floor)));
        IntStream.range(0, underGroundFloors).forEach(floor -> this.floors.add(new Floor(true, floor)));
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public Integer getOverGroundFloorsCount(){
        return floors.stream().filter(floor -> !floor.isUnderground()).collect(Collectors.toList()).size();
    }

    public Integer getUnderGroundFloorsCount(){
        return floors.stream().filter(Floor::isUnderground).collect(Collectors.toList()).size();
    }

    public void requestElevator(Integer requestedFloor) {
        elevators.get(0).setCurrentFloor(requestedFloor);
    }

    public Boolean isAnyElevatorOnFloor(Integer floorNumber){
        return floorNumber.equals(elevators.get(0).getCurrentFloor()) || floorNumber.equals(elevators.get(1).getCurrentFloor());
    }
}
