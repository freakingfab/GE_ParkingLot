package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.implementations.EvenDistributionParkingAttendant;
import com.bridgelabz.parkinglot.implementations.NearestFreeSpaceParkingAttendant;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;
import com.bridgelabz.parkinglot.observers.FullToSpaceObserver;
import com.bridgelabz.parkinglot.observers.ParkingLotFullObserver;
import com.bridgelabz.parkinglot.observers.ParkingLotSecurityObserver;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot");

        ParkingLot parkingLot = new ParkingLot(6);
        parkingLot.addObserver( new ParkingLotFullObserver());
        parkingLot.addObserver(new ParkingLotSecurityObserver());
        parkingLot.addObserver(new FullToSpaceObserver());

        parkingLot.parkCar(new Car(1,10,1, "A","Rj4536","BMW","white","small",true));
        parkingLot.parkCar(new Car(2,10,2, "B","Rj4533","Toyota","blue","small",false));
        parkingLot.parkCar(new Car(3,10,3, "D","Rj4534","Toyota","red","small",false));

        PoliceDepartment policeDepartment = new PoliceDepartment(parkingLot);
        System.out.println("Total Recent cars: " + policeDepartment.getAllCarsInRowBorD().size());

    }
}