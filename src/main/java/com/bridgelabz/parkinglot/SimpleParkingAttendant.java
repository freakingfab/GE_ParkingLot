package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;

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
    public void parkCar(ParkingLot parkingLot, Car car, Integer location) {
        if (parkingLot.hasSpace()) {
            System.out.print("Attendant ");
            parkingLot.parkCar(car,location);
        } else {
            System.out.println("Parking lot is full!");
        }
    }
}
