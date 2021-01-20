package com.qa.main;

public class Runner {

	public static void main(String[] args) {
		
		MultiBedApartment apartment = new Penthouse();
		
		apartment.setSquareFootage(280);
		
		System.out.println("bedrooms: "+ apartment.getNumberOfBedrooms());
		System.out.println("sqft: " + apartment.getSquareFootage());
		
		BedroomAdder moreBedroom = new BedroomAdder();
		
		moreBedroom.addBedroom(apartment);
		
		System.out.println("bedrooms: "+ apartment.getNumberOfBedrooms());
		System.out.println("sqft: " + apartment.getSquareFootage());
		
	}

}
