package steps;

import com.joantolos.kata.elevator.Floor;
import com.joantolos.kata.elevator.Hospital;
import cucumber.api.java8.En;
import org.junit.Assert;

public class ElevatorSteps implements En {

    private Hospital hospital;

    public ElevatorSteps() {

        Before((body) -> {
            this.hospital = new Hospital(5, 2);
        });

        Given("^There is a hospital with (\\d+) floors$", (Integer expectedNumberOfOverGroundFloors) -> {
            Assert.assertEquals(expectedNumberOfOverGroundFloors, this.hospital.getOverGroundFloorsCount());
        });

        And("^the hospital has (\\d+) under ground parking floors$", (Integer expectedNumberOfUnderGroundFloors) -> {
            Assert.assertEquals(expectedNumberOfUnderGroundFloors, this.hospital.getUnderGroundFloorsCount());
        });

        And("^the hospital has (\\d+) elevators$", (Integer expectedNumberOfElevators) -> {
            Assert.assertTrue(expectedNumberOfElevators == this.hospital.getElevators().size());
        });
        Given("^Joan pushes the button for the elevator on the (\\d+) floor$", (Integer requestedFloor) -> {
            this.hospital.requestElevator(new Floor(false, requestedFloor));
        });
        Then("^one of the two elevators ends up on the third floor$", () -> {
            Assert.assertTrue(this.hospital.isAnyElevatorOnFloor(new Floor(false, 3)));
        });

    }
}
