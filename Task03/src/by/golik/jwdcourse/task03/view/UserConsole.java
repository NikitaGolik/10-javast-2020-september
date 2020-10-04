package by.golik.jwdcourse.task03.view;


import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.controller.MainController;

import java.util.ArrayList;
import java.util.Scanner;

public class UserConsole {

    ArrayList<Ball> basket = new ArrayList<>();


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

    public int chooseBasket() {
        System.out.println("Выбери номер корзины");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        return number -1;
    }

    public ArrayList<Ball> addBall() {
        //number к корзине
        ArrayList<Ball> balls = new ArrayList<>();
        System.out.println("Выбери цвет мяча или введи exit для прекращения");
        System.out.println("Yellow");
        System.out.println("Green");
        System.out.println("Blue");

        Scanner scanner = new Scanner(System.in);
        while (true) {

            String colorConsole = scanner.nextLine();
            switch (colorConsole) {
                case ("Yellow"):
                    balls.add(new Ball(Color.YELLOW, 20, 20));
                    break;
                case ("Green"):
                    balls.add(new Ball(Color.GREEN, 30, 30));
                    break;
                case ("Blue"):
                    balls.add(new Ball(Color.BLUE, 40, 40));
                    break;
                case ("exit"):
                    System.out.println("Введите exit для прекращения заполнения корзины или Enter для продолжения");
                    return balls;
            }
        }
    }
}

