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

    /*
       @desc: provides all bmw cars list
       @params: none
       @return: list<car>
    */
    public List<Car> getAllBMWCars(){
        List<Car> bmwCars = parkingLot.getParkedCars().stream()
                .filter(car -> "bmw".equalsIgnoreCase(car.getMake()))
                .collect(Collectors.toList());
        return bmwCars;
    }

    /*
       @desc: provides all cars parked in 30 minutes list
       @params: none
       @return: list<car>
    */
    public List<Car> getAllRecentCars(int currentTime){
        List<Car> recentCars = parkingLot.getParkedCars().stream()
                .filter(car -> car.getEntryTime()>(currentTime - 30))
                .collect(Collectors.toList());
        return recentCars;
    }

    /*
       @desc: provides all cars parked in 30 minutes list
       @params: none
       @return: list<car>
    */
    public List<Car> getAllSmallHandicapCars(){
        List<Car> smallHandicapCars = parkingLot.getParkedCars().stream()
                .filter(car -> "small".equalsIgnoreCase(car.getType()) && car.isHandicap())
                .collect(Collectors.toList());
        return smallHandicapCars;
    }
}
