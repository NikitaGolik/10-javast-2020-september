package by.golik.jwdcourse.task03.view;


import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Vault;

import java.util.ArrayList;
import java.util.Scanner;

public class UserConsole {

    ArrayList<Ball> basket = new ArrayList<>();
    Ball ball;


    public ArrayList<Basket> addBaskets() {
        System.out.println("Выбери количество корзин");
        Scanner sc = new Scanner(System.in);
        ArrayList<Basket> baskets = new ArrayList<>();
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            baskets.add(new Basket());
        }
        return baskets;
    }

    public ArrayList<Ball> addBall() {

        System.out.println("Выбери номер корзины");
        Scanner sc = new Scanner(System.in);
        
        int number = sc.nextInt();
        //number к корзине
        ArrayList<Ball> balls = new ArrayList<>();


        System.out.println("Выбери цвет мяча");
        System.out.println("Yellow");
        System.out.println("Green");
        System.out.println("Blue");


        Scanner scanner = new Scanner(System.in);
        while (!scanner.nextLine().equals("exit")) {
            String colorConsole = scanner.nextLine();

            switch (colorConsole) {
                case ("Yellow"):
                    balls.add(new Ball(Color.YELLOW, 20, 25));
                case ("Green"):
                    balls.add(new Ball(Color.GREEN, 10, 10));
                case ("Blue"):
                    balls.add(new Ball(Color.BLUE, 15, 15));
            }

        }
            return balls;
    }

}

