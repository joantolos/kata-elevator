package com.joantolos.kata.elevator

import com.joantolos.kata.elevator.exception.NonExistingFloorException
import spock.lang.Shared
import spock.lang.Specification

class HospitalSpec extends Specification {

    @Shared Hospital hospital

    def setupSpec() {
        hospital = new Hospital(5, 2)
    }

    def 'Should get the floor from it`s number' () {
        expect: 'to get the proper floor'
        hospital.getFloor(3) == new Floor(false, 3)
    }

    def 'Should raise an exception when asking for a non existing floor' () {
        when:
        hospital.getFloor(11)

        then:
        thrown(NonExistingFloorException)
    }
}
