package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.observers.ParkingLotFullObserver;
import com.bridgelabz.parkinglot.observers.ParkingLotSecurityObserver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot");

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.addObserver( new ParkingLotFullObserver());
        parkingLot.addObserver(new ParkingLotSecurityObserver());

        parkingLot.parkCar(new Car(1),1);
        parkingLot.parkCar(new Car(2),2);

        parkingLot.unparkCar(1);
    }
}