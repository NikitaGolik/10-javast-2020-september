package by.golik.jwdcourse.task03.beans;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Color;

import java.util.ArrayList;

public class Basket {

    public ArrayList<Ball> balls;
    public double weight;

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
        this.weight += newBall.weight;
    }

    public void remove(Ball ball){
        balls.remove(ball);
        this.weight -= ball.weight;
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
