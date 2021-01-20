package com.qa.main;

public abstract class Apartment {
    private int squareFootage;
    private int numberOfBedrooms;

    public int getSquareFootage() {
        return squareFootage;
    }
    
    public void setSquareFootage(int sqft) {
    	this.squareFootage = sqft;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }
    
}
