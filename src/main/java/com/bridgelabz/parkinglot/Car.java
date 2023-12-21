package com.bridgelabz.parkinglot;

/*
    @desc: create object for every car parked in parking lot
 */
public class Car {
    private int carId;
    private int entryTime;
    private int location;

    /*
        @desc: constructor for the class
        @params: carId
        @return: none
     */
    public Car(int carId, int entryTime, int location){
        this.carId = carId;
        this.entryTime = entryTime;
        this.location = location;
    }

    /*
        @desc: getter for car object id
        @params: void;
        @return: int
     */
    public int getCarId() {
        return carId;
    }

    /*
        @desc: getter for entry time
        @params: none
        @return: int
     */
    public int getEntryTime() {
        return entryTime;
    }
    /*
        @desc: setter for location
        @params: int
        @return: void
     */
    public void setLocation(int location) {
        this.location = location;
    }
    /*
        @desc: getter for location
        @params: none
        @return: int
     */
    public int getLocation() {
        return location;
    }
}

