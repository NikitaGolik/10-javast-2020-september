package by.golik.jwdcourse.task03.beans;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Color;

import java.util.ArrayList;
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
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {return false;}
        if (obj.getClass() != this.getClass()) {return false;}
        if (obj == this) {return true;}

        Basket basket = (Basket) obj;

        return Objects.equals(basket.getBalls(), this.balls) && Objects.equals(basket.weight, this.weight)
                && Objects.equals(basket.price, this.price);
    }

}
