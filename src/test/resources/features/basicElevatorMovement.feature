Feature: Elevators move as expected
  Basic movements for both elevators

  Scenario: Requesting an elevator one on the third floor
    Given Joan pushes the button for the elevator on the 3 floor
    Then one of the two elevators ends up on the third floor
