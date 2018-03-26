Feature: Elevators in place
  There are two elevators on the hospital, with seven floors. Two of that floors are under ground parking.

  Scenario: Both elevators exists
    Given There is a hospital with 5 floors
    And the hospital has 2 under ground parking floors
    And the hospital has 2 elevators
