package by.golik.jwdcourse.task03.service;
import by.golik.jwdcourse.task03.beans.Ball;
import java.util.Comparator;

/**
 * Сompares objects of class Иall by price
 */

public class PriceComparator implements Comparator<Ball> {
    /**
     * Compares its two @params for order.
     * @param o1 - ball for compare
     * @param o2 - ball for compare
     * @return true only if the specified object is also a comparator
     * and it imposes the same ordering as this comparator.
     */
    @Override
    public int compare(Ball o1, Ball o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
