package edu.umb.cs680.hw15;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.lang.System;

class CarDominanceCountTable {

    private CarViewer viewer; 

    private HashMap<Car, HashSet<Car>> carDomTable;
    private Comparator<Car> dominanceCountComp;

    protected CarDominanceCountTable(CarViewer viewer) {
        this.viewer = viewer;
        carDomTable = new HashMap<Car, HashSet<Car>>();
    }

    protected void addCar(Car car) {
        HashSet<Car> dominates = new HashSet<Car>();
        carDomTable.put(car, dominates);
        for (Car car2 : viewer.getCars()) {
            int cmp = viewer.paretoCompare(car2, car);
            if (cmp < 0) {
                carDomTable.get(car2).add(car);
            } else if (cmp > 0) {
                carDomTable.get(car).add(car2);
            }
        }
    }

    protected void removeCar(Car car) {
        carDomTable.remove(car);
        for (Car car2 : viewer.getCars()) {
            carDomTable.get(car2).remove(car);
        }
    }
    
    protected int getDomCount(Car car) {
        return carDomTable.get(car).size();
    }


}
