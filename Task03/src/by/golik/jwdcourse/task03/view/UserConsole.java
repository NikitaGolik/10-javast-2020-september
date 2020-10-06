package by.golik.jwdcourse.task03.view;


import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Color;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserConsole {



    public ArrayList<Basket> addBaskets() {
        System.out.println("Выберите количество корзин");
        Scanner sc = new Scanner(System.in);
        boolean continueInput = true;
        ArrayList<Basket> baskets = new ArrayList<>();
        do {
            try {
                int count = sc.nextInt();
                for (int i = 0; i < count; i++) {
                    baskets.add(new Basket());
                }
                continueInput = false;
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                sc.nextLine();
            }
        } while (continueInput);
        return baskets;
    }

    public int chooseBasket() {
        System.out.println("Выберите номер корзины");
        Scanner sc = new Scanner(System.in);
        boolean continueInput = true;
        int number = 0;
        do {
            try {
                number = sc.nextInt();
                continueInput = false;
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                sc.nextLine();
            }
        } while (continueInput);
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
                default :
                    System.out.println("Выберите предложенный вариант");
                    break;
            }
        }
    }
}

