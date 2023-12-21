package com.bridgelabz.parkinglot;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*
    @desc: test file for testing parking lot functionalities
 */
public class ParkingLotTest {
    private ParkingLot parkingLot;

    /*
        @desc: setup function for testing
        @params:
        @return: void
     */
    @Before
    public void setup(){
        parkingLot = new ParkingLot(3);
    }

    /*
        @desc: test for checking car is parked or not(UC1)
        @params: none
        @return: void
     */
    @Test
    public void carIsParkedOrNotTest(){
        parkingLot.parkCar(new Car(1));
        assertEquals(1,parkingLot.getParkingPlotOccupancy());
    }
}
