package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.implementations.EvenDistributionParkingAttendant;
import com.bridgelabz.parkinglot.implementations.NearestFreeSpaceParkingAttendant;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;
import com.bridgelabz.parkinglot.observers.FullToSpaceObserver;
import com.bridgelabz.parkinglot.observers.ParkingLotFullObserver;
import com.bridgelabz.parkinglot.observers.ParkingLotSecurityObserver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot");
        // Assuming 4 Rows Parking Lot with 5 parking location in each row

        ParkingLot parkingLot = new ParkingLot(20);
        parkingLot.addObserver( new ParkingLotFullObserver());
        parkingLot.addObserver(new ParkingLotSecurityObserver());
        parkingLot.addObserver(new FullToSpaceObserver());

        ParkingAttendant largeCarAttendant = new LargeCarParkingAttendant(4,5);
        parkingLot.parkCarsWithAttendant(Arrays.asList(new Car(1,10,1, "A"), new Car(2,20,2,"B")), largeCarAttendant);
    }
}