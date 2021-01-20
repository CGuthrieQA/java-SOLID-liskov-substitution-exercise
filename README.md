# SOLID

## Liskov Substitution

### Exercises

Consider the following four classes, which is meant to upgrade apartments with new bedrooms:

* BedroomAdder.java
* Apartment.java (abstract)
* Penthouse.java (extends from Apartment)
* Studio.java (extends from Apartment)

```java
public class BedroomAdder {
    public void addBedroom(Apartment apartment) {
        apartment.setSquareFootage(apartment.getSquareFootage() + 40);

        if (!(apartment instanceof Studio)) {
            apartment.setNumberOfBedrooms(apartment.getNumberOfBedrooms() + 1);
        }
    }
}
```

```java
public abstract class Apartment {
    private int squareFootage;
    private int numberOfBedrooms;

    public abstract void setSquareFootage(int sqft);

    public int getSquareFootage() {
        return squareFootage;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }
}
```

```java
public class Penthouse extends Apartment{
    public Penthouse() {
        this.setNumberOfBedrooms(4);
    }

    @Override
    public void setSquareFootage(int sqft) {
        this.setSquareFootage(this.getSquareFootage());
    }
}
```

```java
public class Studio extends Apartment{
    public Studio() {
        this.setNumberOfBedrooms(0);
    }

    @Override
    public void setSquareFootage(int sqft) {
        this.setSquareFootage(sqft);
    }
}
```

These classes violate the Liskov Substitution Principle because BedroomAdder.java seems like it accepts any object of type Apartment which is fed into it, but actually checks the sub-class of the object to ensure that no object of type Studio is upgraded.

Refactor the program using the following three classes to ensure that it adheres to the Liskov Substitution Principle to complete this exercise:

* BedroomAdder.java
* Penthouse.java
* Studio.java

```java
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
```

```java
package com.qa.main;

public class BedroomAdder {
	
    public void addBedroom(MultiBedApartment multiBedApartment) {
        multiBedApartment.setSquareFootage(multiBedApartment.getSquareFootage() + 40);
        multiBedApartment.setNumberOfBedrooms(multiBedApartment.getNumberOfBedrooms() + 1);
    }
    
}
```

```java
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
```

```java
package com.qa.main;

public abstract class OneBedApartment extends Apartment {

}
```

```java
package com.qa.main;

public abstract class MultiBedApartment extends Apartment {
    
    
}
```

```java
package com.qa.main;

public class Studio extends OneBedApartment{
	
    public Studio() {
        this.setNumberOfBedrooms(0);
    }
    
}
```

```java
package com.qa.main;

public class Penthouse extends MultiBedApartment{
   
	public Penthouse() {
        this.setNumberOfBedrooms(4);
    }
    
}
```