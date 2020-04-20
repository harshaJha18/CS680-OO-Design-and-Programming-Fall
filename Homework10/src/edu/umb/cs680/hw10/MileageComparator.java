package edu.umb.cs680.hw10;

import java.util.Comparator;


public class MileageComparator implements Comparator<Car> {

    public int compare(Car c1,  Car c2) {
        Comparator<Integer> mileageComp = Comparator.<Integer>naturalOrder();
        return mileageComp.compare(c1.getMileage(), c2.getMileage());
    }
}
