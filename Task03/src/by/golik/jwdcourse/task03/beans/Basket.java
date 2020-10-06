package by.golik.jwdcourse.task03.beans;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class Basket {

    public ArrayList<Ball> balls;
    public double weight;
    public double price;

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    /**
     *
     */
    public Basket()
    {
        this.balls = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Ball> getBalls() {
        return balls;
    }

    /**
     *
     * @param balls
     */
    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public void add(Ball newBall)
    {

        this.balls.add(newBall);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hash(balls);
        return result;
    }

    /**
     *
     * @param
     * @return
     */
 /*   @Override
    public boolean equals(Object obj) {
        if (obj == null) {return false;}
        if (obj.getClass() != this.getClass()) {return false;}
        if (obj == this) {return true;}

        Basket basket = (Basket) obj;

        return Objects.equals(basket.getBalls(), this.balls) && Objects.equals(basket.weight, this.weight)
                && Objects.equals(basket.price, this.price);
    }
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
