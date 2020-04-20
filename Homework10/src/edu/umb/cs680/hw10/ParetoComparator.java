package edu.umb.cs680.hw10;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

class ParetoComparator implements Comparator<Car> {

    LinkedList<Comparator<Car>> simpleComps;

    public ParetoComparator() {
        simpleComps = new LinkedList<Comparator<Car>>();
    }

    public void addComparator(Comparator<Car> comp) {
        simpleComps.add(comp);
    }

    public int compare(Car c1,  Car c2) {
        boolean c1HasWinner = false, c1HasLoser = false;
        Predicate<Comparator<Car>> c1Win = comp -> (comp.compare(c1,c2) < 0);
        Predicate<Comparator<Car>> c1Loss = comp -> (comp.compare(c1,c2) > 0);
        c1HasWinner = simpleComps.stream().anyMatch(c1Win);
        c1HasLoser = simpleComps.stream().anyMatch(c1Loss);
        if (c1HasWinner == c1HasLoser) {
            return 0;
        } else if (c1HasWinner) {
            return -1;
        } else {
            return 1;
        }
    }
}



