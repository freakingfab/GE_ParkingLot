package com.bridgelabz.parkinglot.models;

/*
    @desc: create object for every car parked in parking lot
 */
public class Car {
    private int carId;
    private int entryTime;
    private int location;
    private String row;
    private String numberPlate;
    private String make;
    private String color;
    private String type;
    private boolean isHandicap;

    /*
        @desc: constructor for the class
        @params: carId
        @return: none
     */
    public Car(int carId, int entryTime, int location, String row, String numberPlate, String make, String color, String type, Boolean isHandicap){
        this.carId = carId;
        this.entryTime = entryTime;
        this.location = location;
        this.row = row;
        this.numberPlate = numberPlate;
        this.make = make;
        this.color = color;
        this.type = type;
        this.isHandicap = isHandicap;
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

    /*
        @desc: getters for all other variables
        @params: none
     */

    public String getRow() {
        return row;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public boolean isHandicap() {
        return isHandicap;
    }

}

