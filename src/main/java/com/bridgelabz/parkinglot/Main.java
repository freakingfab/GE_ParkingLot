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

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.addObserver( new ParkingLotFullObserver());
        parkingLot.addObserver(new ParkingLotSecurityObserver());
        parkingLot.addObserver(new FullToSpaceObserver());

        ParkingAttendant nearestFreeSpaceAttendant = new NearestFreeSpaceParkingAttendant(parkingLot.getCapacity());
        parkingLot.parkCarsWithAttendant(Arrays.asList(new Car(1,10,1), new Car(2,20,2)), nearestFreeSpaceAttendant);
    }
}