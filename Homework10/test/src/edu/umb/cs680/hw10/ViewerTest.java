package edu.umb.cs680.hw10;

import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


class ViewerTest {

    private static Car temp1;
    private static Car temp2;
    private static Car temp2Helper;    
    private static Car temp8;    
    private static Car temp9;
    private static Car temp6;

    private static Viewer viewer;

    @BeforeAll
    public static void setUp() {
        temp1 = new Car("Tesla", "Cybertruck", 50, 2018, 14999); 
        temp2 = new Car("Tesla", "Cybertruck", 48, 2012, 49998); 
        temp2Helper = new Car("Tesla", "Cybertruck", 49, 2011, 49999); 
        temp8 = new Car("Tesla", "Cybertruck", 400000, 2010, 200); 
        temp9 = new Car("Tesla", "Cybertruck", 4000000, 1919, 200000);  
        temp6 = new Car("Tesla", "Cybertruck", 0, 2019, 19999); 

        viewer = new Viewer();

        viewer.addCar(temp6);
        viewer.addCar(temp1);
        viewer.addCar(temp2Helper);
        viewer.addCar(temp2);
        viewer.addCar(temp8);
        viewer.addCar(temp9);        
}


    @Test
    public void verifyYear() {
        ArrayList<Car> carsExpected = new ArrayList<Car>();
        carsExpected.add(temp6);
        carsExpected.add(temp1);
        carsExpected.add(temp2);
        carsExpected.add(temp2Helper);
        carsExpected.add(temp8);
        carsExpected.add(temp9);

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
        carsExpected.add(temp8);
        carsExpected.add(temp1);
        carsExpected.add(temp6);
        carsExpected.add(temp2);
        carsExpected.add(temp2Helper);
        carsExpected.add(temp9);

        ArrayList<Car> carsActual = viewer.byPrice();
        for (int i = 0; i < carsExpected.size(); i++) {
            assertEquals(carsExpected.get(i), carsActual.get(i));
        }
    }

    @Test
    public void verifyMileage() {
        ArrayList<Car> carsExpected = new ArrayList<Car>();
        carsExpected.add(temp6);
        carsExpected.add(temp2);
        carsExpected.add(temp2Helper);
        carsExpected.add(temp1);
        carsExpected.add(temp8);
        carsExpected.add(temp9);

        ArrayList<Car> carsActual = viewer.byMileage();
        for (int i = 0; i < carsExpected.size(); i++) {
            assertEquals(carsExpected.get(i), carsActual.get(i));
        }
    }

    @Test void verifyParetoCompare() {
        assertEquals(viewer.paretoCompare(temp2, temp2Helper), -1);
        assertEquals(viewer.paretoCompare(temp2, temp9), -1);
        assertEquals(viewer.paretoCompare(temp2, temp1), 0);
        assertEquals(viewer.paretoCompare(temp1, temp2), 0);
        assertEquals(viewer.paretoCompare(temp1, temp9), -1);
        assertEquals(viewer.paretoCompare(temp6, temp1), 0);
        assertEquals(viewer.paretoCompare(temp6, temp9), -1);
}

    @Test
    public void verifyDomCountMeasure() {
        assertEquals(1, viewer.getDomCountComp().getDomCount(temp1));
        assertEquals(2, viewer.getDomCountComp().getDomCount(temp2));
        assertEquals(1, viewer.getDomCountComp().getDomCount(temp2Helper));
        assertEquals(0, viewer.getDomCountComp().getDomCount(temp9));
    }

    @Test
    public void verifyDomCountSort() {
        viewer.byYear();
        ArrayList<Car> carsActual = viewer.byDominanceCount();

        ArrayList<Car> carsExpected = new ArrayList<Car>();
        carsExpected.add(temp6);
        carsExpected.add(temp2);
        carsExpected.add(temp1);
        carsExpected.add(temp2Helper);
        carsExpected.add(temp8);
        carsExpected.add(temp9);

        for (int i = 0; i < carsExpected.size(); i++) {
            Car car = carsActual.get(i);
            Car carExpected = carsExpected.get(i);
            assertEquals(carExpected, car);
        }
        
        
    }


}

