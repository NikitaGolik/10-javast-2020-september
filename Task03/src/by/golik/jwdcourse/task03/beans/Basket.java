package by.golik.jwdcourse.task03.beans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The class is used to store basket objects with properties
 * <b>balls</b> <b>weight</b> <b>price</b>
 */
public class Basket {

    public ArrayList<Ball> balls;

    /**
     * constructor creates new object Basket
     */
    public Basket()
    {
        this.balls = new ArrayList<>();
    }

    /**
     * function of getting balls from basket
     * @return a list with balls in basket
     */
    public ArrayList<Ball> getBalls() {
        return balls;
    }

    /**
     * definition of list balls in basket
     * @param balls list of balls in basket
     */
    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    /**
     * @return a hash code value for the object Basket.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hash(balls);
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param obj the reference Ball with which to compare.
     * @return true if this object is the same as the object argument, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        Basket basket = (Basket) obj;
        List<Ball> list1 = basket.getBalls();
        List<Ball> list2 = this.getBalls();

        if	(list1.size() != list2.size()) {
            return false;
        }
        if  (Objects.equals(list1, list2)) {
            return true;
        }

        for	(int i=0; i<list1.size(); i++) {
            int counterA = Collections.frequency(list1,list1.get(i));
            int counterB = Collections.frequency(list2,list1.get(i));
            if (counterA!=counterB) {
                return false;
            }
        }
        return true;
    }

}
