package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.implementations.EvenDistributionParkingAttendant;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/*
    @desc: test file for testing parking lot functionalities
 */
public class ParkingLotTest {
    private ParkingLot parkingLot;
    private PoliceDepartment policeDepartment;
    /*
        @desc: setup function for testing
        @params:
        @return: void
     */
    @Before
    public void setup(){
        parkingLot = new ParkingLot(6);
        policeDepartment = new PoliceDepartment(parkingLot);
    }

    /*
        @desc: test for checking car is parked or not(UC1)
        @params: none
        @return: void
     */
    @Test
    public void carIsParkedOrNotTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","TATA","white","small",false));
        assertEquals(1,parkingLot.getParkingPlotOccupancy());
    }

    /*
        @desc: test for unparking car
        @params: none
        @return void
     */
    @Test
    public void unparkCarTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4536","TATA","white","small",false));
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
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4536","TATA","white","small",false));
        assertFalse(parkingLot.isFull());
    }

    /*
        @desc: test for getting location of car by driver
        @params: none
        @return: void
     */
    @Test
    public void locationOfCarTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4536","TATA","white","small",false));
        assertEquals(2, parkingLot.getLocationOfCar(2));
    }

    /*
        @desc: test for parking charges
        @params: none
        @return: void
     */
    @Test
    public void parkingChargesOfCarTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4536","TATA","white","small",false));
        assertEquals(100, parkingLot.getParkingCharge(1,30));
    }

    /*
        @desc: test for white cars
        @params: none
        @return: void
     */
    @Test
    public void whiteCarCountTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4533","TATA","white","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4534","TATA","red","small",false));

        assertEquals(2, policeDepartment.getWhiteCars().size());
    }
    /*
        @desc: test for blue toyota cars
        @params: none
        @return: void
     */
    @Test
    public void blueToyotaCountTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","TATA","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4533","Toyota","blue","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4534","TATA","red","small",false));

        assertEquals(1, policeDepartment.getBlueToyotaCars().size());
    }

    /*
        @desc: test for bmw cars
        @params: none
        @return: void
     */
    @Test
    public void BMWCarCountTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","BMW","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4533","BMW","blue","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4534","TATA","red","small",false));

        assertEquals(2, policeDepartment.getAllBMWCars().size());
    }
    /*
        @desc: test for recent cars
        @params: none
        @return: void
     */
    @Test
    public void recentCarCountTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","BMW","white","small",false));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4533","BMW","blue","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4534","TATA","red","small",false));

        assertEquals(3, policeDepartment.getAllRecentCars(30).size());
    }
    /*
        @desc: test for small handicap cars
        @params: none
        @return: void
     */
    @Test
    public void smallHandicapCarCountTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","BMW","white","small",true));
        parkingLot.parkCar(new Car(2,10,2, "A","Rj4533","BMW","blue","small",false));
        parkingLot.parkCar(new Car(3,10,3, "A","Rj4534","TATA","red","small",false));

        assertEquals(1, policeDepartment.getAllSmallHandicapCars().size());
    }
    /*
        @desc: test for cars in b or d row
        @params: none
        @return: void
     */
    @Test
    public void CarInRowBorDCountTest(){
        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","BMW","white","small",true));
        parkingLot.parkCar(new Car(2,10,2, "B","Rj4533","BMW","blue","small",false));
        parkingLot.parkCar(new Car(3,10,3, "D","Rj4534","TATA","red","small",false));

        assertEquals(2, policeDepartment.getAllCarsInRowBorD().size());
    }
}
