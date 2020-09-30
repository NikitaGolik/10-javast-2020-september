package by.golik.jwdcourse.task03.service;

import by.golik.jwdcourse.task03.beans.Ball;

import java.util.Comparator;

public class PriceComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball o1, Ball o2) {
        return (int)  (o1.getPrice() - o2.getPrice());
    }
}
