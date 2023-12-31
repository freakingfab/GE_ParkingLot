package com.bridgelabz.parkinglot.interfaces;

import com.bridgelabz.parkinglot.models.Car;
import com.bridgelabz.parkinglot.ParkingLot;

/*
    @desc: interface for parking attendants
 */
public interface ParkingAttendant {
    void parkCar(ParkingLot parkingLot, Car car);
}
