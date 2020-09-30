package by.golik.jwdcourse.task03.controller;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.view.UserConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainController {

    UserConsole userConsole = new UserConsole();
    Vault vault = new Vault();
    ArrayList<Ball>balls;
    Basket basket = new Basket();

    public void createVault() {
        vault.setBaskets(userConsole.addBaskets());
    }
    public void fillBasket() {
        int numberBasket = userConsole.chooseBasket();
        balls = new ArrayList<>(userConsole.addBall());
        vault.getBaskets().get(numberBasket).setBalls(balls);
    }
    public void fillVault() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для заполнения корзины нажми Enter или нажми exit");
        while(!scanner.nextLine().equals("exit")) {
            fillBasket();
        }
    }
    public void  weightBall() {
        int k = vault.getBaskets().size();
        for (int i = 0; i < k; i++) {
            int b = vault.getBaskets().get(i).getBalls().size()-1;
            int weightBall = 0;
            for (int j = 0; j < b; j++) {
                weightBall += vault.getBaskets().get(i).getBalls().get(j).getWeight();
            }
            System.out.println("Вес корзины №"+ (i+1) +"="+(weightBall + balls.get(0).getWeight() + basket.getWeight()));
        }
    }
    public void priceBall() {
        int k = vault.getBaskets().size();
        for (int i = 0; i < k; i++) {
            int b = vault.getBaskets().get(i).getBalls().size()-1;
            int priceBall = 0;
            for (int j = 0; j < b; j++) {
                priceBall += vault.getBaskets().get(i).getBalls().get(j).getPrice();
            }
            System.out.println("Стоимость корзины №"+ (i+1) +"="+(priceBall + balls.get(0).getPrice() + basket.getPrice()));
        }
    }

    public void countEqualBall() {
        // Выводим на экран

        int sum = 0;

        for (int i = 0; i < balls.size(); i++) {
            for (int j = i + 1; j < balls.size(); j++) {
                if (balls.get(i).equals(balls.get(j))) {
                    sum++;
                    break;
                }
            }
        }

        // Выводим на экран
        System.out.println("Количество одинаковых мячей " + (sum + 1));
    }
    public void countEqualBaskets() {
        //TODO неверно считает цикл с разными мячами
        int sum = 0;

        for (int i = 0; i < vault.getBaskets().size() - 1; i++) {
            for (int j = i + 1; j < vault.getBaskets().size(); j++) {
                if (vault.getBaskets().get(i).equals(vault.getBaskets().get(j))) {
                    sum++;
                    break;
                }
            }
        }
        System.out.println("Количество одинаковых по набору корзин " + (sum + 1));
    }
    public void countEqualColorBalls(Color color) {
        //TODO неверно указывает кол-во мячей, если их в корзине нет
        int sum = 0;
        for (int i = 0; i < balls.size(); i++) {
                if (balls.get(i).getColor().equals(color)) {
                    sum++;
                    break;
                }
            }
        System.out.println("Количество одинаковых по цвету " + color + " мячей " + (sum + 1));
    }



}
