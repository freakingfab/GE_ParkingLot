package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.models.Car;

import java.util.List;
import java.util.stream.Collectors;

/*
    @desc: class for functionality of police operations
 */
public class PoliceDepartment {
    private ParkingLot parkingLot;

    /*
        @desc: constructor for clas
        @params: parking plot
        @return: none
     */
    public PoliceDepartment(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    /*
        @desc: provides car with white color list
        @params: none
        @return: list<car>
     */
    public List<Car> getWhiteCars(){
        List<Car> whiteCars = parkingLot.getParkedCars().stream()
                .filter(car -> "white".equalsIgnoreCase(car.getColor()))
                .collect(Collectors.toList());
        return whiteCars;
    }
    /*
       @desc: provides car with blue color and of toyota list
       @params: none
       @return: list<car>
    */
    public List<Car> getBlueToyotaCars(){
        List<Car> blueToyotaCars = parkingLot.getParkedCars().stream()
                .filter(car -> "blue".equalsIgnoreCase(car.getColor()) && "toyota".equalsIgnoreCase(car.getMake()))
                .collect(Collectors.toList());
        return blueToyotaCars;
    }
}
