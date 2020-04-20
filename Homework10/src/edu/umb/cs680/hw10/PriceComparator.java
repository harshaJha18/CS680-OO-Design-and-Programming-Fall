package edu.umb.cs680.hw10;

import java.util.Comparator;


public class PriceComparator implements Comparator<Car> {

    public int compare(Car c1,  Car c2) {
        Comparator<Float> priceComp = Comparator.<Float>naturalOrder();
        return priceComp.compare(c1.getPrice(), c2.getPrice());
    }
}
