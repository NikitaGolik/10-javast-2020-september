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
    public double weight;
    public double price;

    /**
     * function of getting value of basket
     * @return weight of Basket
     */
    public double getWeight() {
        return weight;
    }

    /**
     * function of getting price of basket
     * @return price of basket
     */
    public double getPrice() {
        return price;
    }

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
     * @param o the reference Ball with which to compare.
     * @return true if this object is the same as the object argument, false otherwise.
     */
    @Override
    public boolean equals(Object o) {

        if (o == null) {return false;}
        if (o.getClass() != this.getClass()) {return false;}
        if (o == this) {return true;}

        Basket basket = (Basket) o;
        List<Ball> bb1 = basket.getBalls();
        List<Ball> bb2 = this.getBalls();

        if	(bb1.size()!=bb2.size()) {return false;}
        if  (Objects.equals(bb1, bb2)) {return true;}

        for	(int i=0; i<bb1.size(); i++) {
            int counterA = Collections.frequency(bb1,bb1.get(i));
            int counterB = Collections.frequency(bb2,bb1.get(i));
            if (counterA!=counterB){return false;}
        }
        return true;
    }

}
