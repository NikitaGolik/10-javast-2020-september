package by.golik.jwdcourse.task03.controller;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.view.UserConsole;

import java.util.ArrayList;
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
        System.out.println("Вес мяча " + balls.get(0).getWeight());
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
        System.out.println("Цена мяча " + balls.get(0).getPrice());
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




}
