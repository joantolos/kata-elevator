package steps;

import com.joantolos.kata.elevator.Hospital;
import cucumber.api.java8.En;
import org.junit.Assert;

public class ElevatorSteps implements En {

    private Hospital hospital;

    public ElevatorSteps() {

        Given("^There is a hospital$", () -> {
            this.hospital = new Hospital(5, 2);
        });

        Then("^the hospital has (\\d+) floors$", (Integer expectedNumberOfOverGroundFloors) -> {
            Assert.assertEquals(expectedNumberOfOverGroundFloors, this.hospital.getOverGroundFloorsCount());
        });

        And("^the hospital has (\\d+) under ground parking floors$", (Integer expectedNumberOfUnderGroundFloors) -> {
            Assert.assertEquals(expectedNumberOfUnderGroundFloors, this.hospital.getUnderGroundFloorsCount());
        });

        And("^the hospital has (\\d+) elevators$", (Integer expectedNumberOfElevators) -> {
            Assert.assertTrue(expectedNumberOfElevators == this.hospital.getElevators().size());
        });

    }
}
