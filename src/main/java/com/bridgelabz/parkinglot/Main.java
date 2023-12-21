package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.observers.FullToSpaceObserver;
import com.bridgelabz.parkinglot.observers.ParkingLotFullObserver;
import com.bridgelabz.parkinglot.observers.ParkingLotSecurityObserver;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot");

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.addObserver( new ParkingLotFullObserver());
        parkingLot.addObserver(new ParkingLotSecurityObserver());
        parkingLot.addObserver(new FullToSpaceObserver());

        parkingLot.parkCar(new Car(1),1);
        parkingLot.parkCar(new Car(2),2);

        System.out.println("Car with id:1 is parked at location: " + parkingLot.getLocationOfCar(1));
    }
}