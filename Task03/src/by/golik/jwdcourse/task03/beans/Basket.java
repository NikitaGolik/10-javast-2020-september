package by.golik.jwdcourse.task03.beans;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Color;

import java.util.ArrayList;

public class Basket {


    public ArrayList<Ball> balls;
    private double weight = 5;
    private double price = 5;

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public Basket()
    {
        this.balls = new ArrayList<>();
    }

    public Basket(ArrayList<Ball> balls)
    {

        this.balls = new ArrayList<>();
        for (Ball ball: balls)
            add(ball);
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public void add(Ball newBall)
    {

        this.balls.add(newBall);
    }

    public void remove(Ball ball){
        balls.remove(ball);
    }

    public int getColorCount(Color color)
    {
        int numOfBalls = 0;
        for (Ball  ball: balls)
        {
            if (ball.color == color)
                numOfBalls++;
        }

        return numOfBalls;
    }

}
