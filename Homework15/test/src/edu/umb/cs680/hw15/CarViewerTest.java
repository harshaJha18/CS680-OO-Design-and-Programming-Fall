package edu.umb.cs680.hw15;

import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


class CarViewerTest {

    private static Car temp1;
    private static Car temp2;
    private static Car temp3;    
    private static Car temp4;    
    private static Car temp5;
    private static Car temp6;

    private static CarViewer viewer;

    @BeforeAll
    public static void setUp() {
        temp1 = new Car("Tesla", "Cybertruck", 50, 2018, 14999); 
        temp2 = new Car("Tesla", "Cybertruck", 48, 2012, 49998); 
        temp3 = new Car("Tesla", "Cybertruck", 49, 2011, 49999); 
        temp4 = new Car("Tesla", "Cybertruck", 400000, 2010, 200); 
        temp5 = new Car("Tesla", "Cybertruck", 4000000, 1919, 200000);  
        temp6 = new Car("Tesla", "Cybertruck", 0, 2019, 19999); 

        viewer = new CarViewer();

        viewer.addCar(temp6);
        viewer.addCar(temp1);
        viewer.addCar(temp3);
        viewer.addCar(temp2);
        viewer.addCar(temp4);
        viewer.addCar(temp5);        
}


    @Test
    public void verifyYear() {
        ArrayList<Car> carsExpected = new ArrayList<Car>();
        carsExpected.add(temp6);
        carsExpected.add(temp1);
        carsExpected.add(temp2);
        carsExpected.add(temp3);
        carsExpected.add(temp4);
        carsExpected.add(temp5);

        ArrayList<Car> carsActual = viewer.byYear();
        for (int i = 0; i < carsExpected.size(); i++) {
            Car car = carsActual.get(i);
            Car carExpected = carsExpected.get(i);
      
            assertEquals(carExpected, car);
        }
    }

    @Test
    public void verifyPrice() {
        ArrayList<Car> carsExpected = new ArrayList<Car>();
        carsExpected.add(temp4);
        carsExpected.add(temp1);
        carsExpected.add(temp6);
        carsExpected.add(temp2);
        carsExpected.add(temp3);
        carsExpected.add(temp5);

        ArrayList<Car> carsActual = viewer.byPrice();
        for (int i = 0; i < carsExpected.size(); i++) {
            Car car = carsActual.get(i);
            Car carExpected = carsExpected.get(i);
   
            assertEquals(carExpected, car);
        }
    }

    @Test
    public void verifyMileage() {
        ArrayList<Car> carsExpected = new ArrayList<Car>();
        carsExpected.add(temp6);
        carsExpected.add(temp2);
        carsExpected.add(temp3);
        carsExpected.add(temp1);
        carsExpected.add(temp4);
        carsExpected.add(temp5);

        ArrayList<Car> carsActual = viewer.byMileage();
        for (int i = 0; i < carsExpected.size(); i++) {
            assertEquals(carsExpected.get(i), carsActual.get(i));
        }
    }

    @Test void verifyParetoCompare() {
     
        assertTrue(viewer.paretoCompare(temp2, temp3) < 0);
  
        assertTrue(viewer.paretoCompare(temp2, temp5) < 0);
     
        assertTrue(viewer.paretoCompare(temp2, temp1) == 0);
        assertTrue(viewer.paretoCompare(temp1, temp2) == 0);
        assertTrue(viewer.paretoCompare(temp1, temp5) < 0);
        assertTrue(viewer.paretoCompare(temp6, temp1) == 0);
        assertTrue(viewer.paretoCompare(temp6, temp5) < 0);
}


    @Test
    public void verifyDomCountSort() {
        viewer.byYear(); 
        ArrayList<Car> carsActual = viewer.byDominanceCount();

        ArrayList<Car> carsExpected = new ArrayList<Car>();
        carsExpected.add(temp6);
        carsExpected.add(temp2);
        carsExpected.add(temp1);
        carsExpected.add(temp3);
        carsExpected.add(temp4);
        carsExpected.add(temp5);

        
    }


}

