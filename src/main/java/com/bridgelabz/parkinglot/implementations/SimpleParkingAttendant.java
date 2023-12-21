package com.bridgelabz.parkinglot.implementations;

import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;

/*
    @desc: class for providng functionality of parking using attendant
 */
public class SimpleParkingAttendant implements ParkingAttendant {
    /*
        @desc: override function for parkCar
        @params: parkinglot, car
        @return: void
     */
    @Override
    public void parkCar(ParkingLot parkingLot, Car car) {
        if (parkingLot.hasSpace()) {
            System.out.print("Attendant ");
            parkingLot.parkCar(car);
        } else {
            System.out.println("Parking lot is full!");
        }
    }
}
