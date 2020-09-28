package by.golik.jwdcourse.task03.beans;

import by.golik.jwdcourse.task03.beans.Color;

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
}
