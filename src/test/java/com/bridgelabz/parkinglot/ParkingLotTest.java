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
        parkingLot.parkCar(new Car(1, 20,1));
        assertEquals(1,parkingLot.getParkingPlotOccupancy());
    }

    /*
        @desc: test for unparking car
        @params: none
        @return void
     */
    @Test
    public void unparkCarTest(){
        parkingLot.parkCar(new Car(1,10,1));
        parkingLot.parkCar(new Car(2,12,1));
        parkingLot.unparkCar(1);
        assertEquals(1,parkingLot.getParkingPlotOccupancy());
    }

    /*
        @desc: test for plot full
        @params: none
        @return: void
     */
    @Test
    public void isParkingLotFullTest(){
        parkingLot.parkCar(new Car(1,10,1));
        parkingLot.parkCar(new Car(2,11,2));
        parkingLot.parkCar(new Car(3,12,3));
        assertTrue(parkingLot.isFull());
    }

    /*
        @desc: test for getting location of car by driver
        @params: none
        @return: void
     */
    @Test
    public void locationOfCarTest(){
        parkingLot.parkCar(new Car(1,10,1));
        parkingLot.parkCar(new Car(2,11,2));
        parkingLot.parkCar(new Car(3,12,3));
        assertEquals(2, parkingLot.getLocationOfCar(2));
    }

    /*
        @desc: test for parking charges
        @params: none
        @return: void
     */
    @Test
    public void parkingChargesOfCarTest(){
        parkingLot.parkCar(new Car(1,10,1));
        parkingLot.parkCar(new Car(2,11,2));
        parkingLot.parkCar(new Car(3,12,3));
        assertEquals(100, parkingLot.getParkingCharge(1,30));
    }
}
