package by.golik.jwdcourse.task03.beans;
import java.util.Objects;
/**
 *
 * The class is used to store ball objects with properties
 * <b>color</b> <b>weight</b> <b>price</b>
 *
 */
public class Ball {

    public Color color;
    public double weight;
    public double price;

    /**
     * constructor - creating new Object
     * @param color - color of ball
     * @param weight - weight of ball
     * @param price - price of ball
     */
    public Ball(Color color, double weight, double price) {
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    /**
     * function of getting value {@link Ball#color}
     * @return color of ball
     */
    public Color getColor() {
        return color;
    }

    /**
     * function of definition color of ball {@link Ball#color}
     * @param color - color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * function of getting value {@link Ball#color}
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * function of definition color of ball {@link Ball#weight}
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * function of getting value {@link Ball#price}
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * function of definition color of ball {@link Ball#price}
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return a hash code value for the object Ball.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hash(color, weight, price);
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
        Ball ball = (Ball) obj;

        return Objects.equals(ball.color, this.color) && Objects.equals(ball.weight, this.weight)
                && Objects.equals(ball.price, this.price);
    }

    /**
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Color " + color + " Weight " + weight + " Price " + price + "\n";
    }
}
