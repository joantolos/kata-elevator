package com.joantolos.kata.elevator

import spock.lang.Specification

class ElevatorSpec extends Specification {

    def 'Calculate how much time it takes to go from floor to floor'() {

        given: "an elevator on the entrance floor"
        Elevator elevator = new Elevator(new Floor(false, 0))

        expect: 'to take an extra 100 milliseconds for each floor that moves.'
        elevator.requestFloor(new Floor(false, actualFloor))
        elevator.attendRequests()
        elevator.howMuchTimeItTakes(new Floor(false, newFloor)) == expectedTime

        where:
        actualFloor | newFloor    | expectedTime
        0           | 1           | 500
        0           | 2           | 600
        0           | 3           | 700
        0           | 4           | 800
        0           | 5           | 900
        0           | 6           | 1000
        0           | 7           | 1100
        3           | 2           | 500
        4           | 7           | 700
        7           | 0           | 1100
    }
}
