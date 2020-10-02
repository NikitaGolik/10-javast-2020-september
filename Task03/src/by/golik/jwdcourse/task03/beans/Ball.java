package by.golik.jwdcourse.task03.beans;

import by.golik.jwdcourse.task03.beans.Color;

import java.util.Objects;

public class Ball {
    public Color color;
    public double weight;
    public double price;

    public Ball(Color color, double weight, double price) {
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hash(color, weight, price);
        //long temp;
        //temp = Double.doubleToLongBits(this.price);
        //result = prime * result + (int) (temp ^ (temp >>> 32));
        //result = prime * result + (int) weight;
        return result;
    }

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

    @Override
    public String toString() {
        return "Color " + color + " Weight " + weight + " Price " + price + "\n";
    }
}
