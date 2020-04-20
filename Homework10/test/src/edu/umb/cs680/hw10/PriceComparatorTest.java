package edu.umb.cs680.hw10;

import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;




class PriceComparatorTest{

    private static Car temp1;
    private static Car temp2;
    private static Car temp3;    
    private static Car temp4;    
    private static Car temp5;
    private static Car temp6;
    private static Comparator<Car> comp;

    @BeforeAll
    public static void setUp() {
        temp1 = new Car("Tesla", "Cybertruck", 50, 2018, 14999);
        temp2 = new Car("Tesla", "Cybertruck", 49, 2018, 49998);
        temp3 = new Car("Tesla", "Cybertruck", 50, 2018, 49999);
        temp4 = new Car("Tesla", "Cybertruck", 400000, 2010, 200);
        temp5 = new Car("Tesla", "Cybertruck", 4000000, 1919, 200000);
        temp6 = new Car("Tesla", "Cybertruck", 0, 2019, 19999);

        comp = new PriceComparator();

}


    @Test
    public void verifyPriceComparator() {
        ArrayList<Car> carsExpected = new ArrayList<Car>();
        ArrayList<Car> carsActual = new ArrayList<Car>();        
        carsExpected.add(temp4);
        carsExpected.add(temp1);
        carsExpected.add(temp6);
        carsExpected.add(temp2);
        carsExpected.add(temp3);
        carsExpected.add(temp5);

        carsActual.add(temp1);
        carsActual.add(temp2);
        carsActual.add(temp3);
        carsActual.add(temp4);
        carsActual.add(temp5);
        carsActual.add(temp6);
        Collections.sort(carsActual, comp);
        for (int i = 0; i < carsExpected.size(); i++) {
            assertEquals(carsExpected.get(i), carsActual.get(i));
        }
    }

}

