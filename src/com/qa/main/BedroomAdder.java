package com.qa.main;

public class BedroomAdder {
	
    public void addBedroom(MultiBedApartment multiBedApartment) {
        multiBedApartment.setSquareFootage(multiBedApartment.getSquareFootage() + 40);
        multiBedApartment.setNumberOfBedrooms(multiBedApartment.getNumberOfBedrooms() + 1);
    }
    
}
