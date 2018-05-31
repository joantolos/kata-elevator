package com.joantolos.kata.elevator;

import com.joantolos.kata.elevator.exception.NonExistingFloorException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hospital {

    private List<Elevator> elevators;
    private List<Floor> floors;

    public Hospital(Integer overGroundFloors, Integer underGroundFloors) {
        this.floors = new ArrayList<>();
        IntStream.range(0, overGroundFloors).forEach(floor -> this.floors.add(new Floor(false, floor)));
        IntStream.range(0, underGroundFloors).forEach(floor -> this.floors.add(new Floor(true, floor)));

        this.elevators = new ArrayList<>();
        this.elevators.add(new Elevator(1, "ElevatorOne", getFloor(0)));
        this.elevators.add(new Elevator(2, "ElevatorTwo", getFloor(0)));
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

    public void requestElevator(Floor requestedFloor) {
        this.getFreeElevator().requestFloor(requestedFloor);
    }

    private Elevator getFreeElevator() {
        return elevators.stream().filter(elevator -> !elevator.isInMotion()).findFirst().get();
    }

    public Boolean isAnyElevatorOnFloor(Floor floorCandidate){
        return floorCandidate.equals(elevators.get(0).getCurrentFloor()) || floorCandidate.equals(elevators.get(1).getCurrentFloor());
    }

    public Floor getFloor(Integer floorNumber) throws NonExistingFloorException {
        return this.floors.stream().filter(floor -> floor.getNumber().equals(floorNumber)).findFirst().orElseThrow(NonExistingFloorException::new);
    }
}
