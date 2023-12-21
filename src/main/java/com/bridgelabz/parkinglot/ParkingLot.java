package com.bridgelabz.parkinglot;

import java.util.ArrayList;
import java.util.List;
/*
    @desc: class for the whole parking lot
 */
public class ParkingLot {
    private int capacity;
    private List<Car> parkedCars;

    /*
        @desc: constructor for class
        @params: capacity
        @return: none
     */
    public ParkingLot(int capacity){
        this.capacity = capacity;
        parkedCars = new ArrayList<>();
    }

    /*
        @desc: getter for parking lot list size
        @params: none
        @return: int
     */
    public int getParkingPlotOccupancy(){
        return parkedCars.size();
    }
    /*
        @desc: function to provide parking facility
        @params: Car object
        @return: void
     */
    public void parkCar(Car car){
        if(getParkingPlotOccupancy() < capacity){
            parkedCars.add(car);
            System.out.println("Car parked: "+car.getCarId());
        }
        else{
            System.out.println("Parking Lot is full");
        }
    }
}
