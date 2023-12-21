package com.bridgelabz.parkinglot;

/*
    @desc: create object for every car parked in parking lot
 */
public class Car {
    private int carId;

    /*
        @desc: constructor for the class
        @params: carId
        @return: none
     */
    public Car(int carId){
        this.carId = carId;
    }

    /*
        @desc: getter for car object id
        @params: void;
        @return: int
     */
    public int getCarId() {
        return carId;
    }
}

