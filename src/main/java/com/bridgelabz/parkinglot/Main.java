package com.bridgelabz.parkinglot;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot");

        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.parkCar(new Car(1),1);
        parkingLot.parkCar(new Car(2),2);

        parkingLot.unparkCar(2);
    }
}