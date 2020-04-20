package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;


class CarTest{

    private static Car car;

    @BeforeAll
    public static void setUp() {
        car = new Car("Tesla", "Cybertruck",500, 2019,50099);
    }


    private String[] carToStringArrayForEquality(Car car) {
        String[] carArray = {car.getMake(), car.getModel(),
                             Integer.toString(car.getYear())};
        return carArray;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Tesla", "Cybertruck", "2019"};
        
        assertArrayEquals(expected, carToStringArrayForEquality(car));
    }

    @Test
    public void verifyMakeGetter() {
        String expectedMake = "Tesla";
        Car car = new Car(expectedMake, "Cybertruck",500, 2019, 50099);
        String actualMake = car.getMake();
        assertEquals(actualMake, expectedMake);
    }

}

