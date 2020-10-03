package by.golik.jwdcourse.task03.beans;

import by.golik.jwdcourse.task03.beans.Color;

import java.util.Objects;
/**
 *
 * The class is used to store ball objects with properties
 * <b>color</b> <b>weight</b> <b>price</b>
 * @version 2.1
 */
public class Ball {

    public Color color;
    public double weight;
    public double price;

    /**
     *
     * @param color
     * @param weight
     * @param price
     */
    public Ball(Color color, double weight, double price) {
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hash(color, weight, price);
        return result;
    }

    /**
     *
     * @param obj
     * @return
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
        Ball ball = (Ball) obj;

        return Objects.equals(ball.color, this.color) && Objects.equals(ball.weight, this.weight)
                && Objects.equals(ball.price, this.price);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Color " + color + " Weight " + weight + " Price " + price + "\n";
    }
}
