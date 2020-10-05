package by.golik.jwdcourse.task03.controller;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.view.UserConsole;

import java.util.*;

/**
 *
 */
public class MainController {
    /**
     *
     */
    UserConsole userConsole = new UserConsole();
    Vault vault = new Vault();
    ArrayList<Ball>balls;
    Basket basket = new Basket();

    /**
     *
     */
    public void createVault() {
        vault.setBaskets(userConsole.addBaskets());
    }

    /**
     *
     */
    public void fillBasket() {
        int numberBasket = userConsole.chooseBasket();
        balls = new ArrayList<>(userConsole.addBall());
        vault.getBaskets().get(numberBasket).setBalls(balls);
    }
    public void createBasket() {
        vault.getBaskets().get(0);
    }


    /**
     *
     */
    public void fillVault() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для заполнения новой корзины нажми Enter или нажми exit для выхода");
        while(!scanner.nextLine().equals("exit")) {
            fillBasket();
        }
    }

    /**
     *
     */
    public void  weightBall() {
        int k = vault.getBaskets().size();
        for (int i = 0; i < k; i++) {
            int b = vault.getBaskets().get(i).getBalls().size() - 1;
            int weightBall = 0;
            for (int j = 0; j < b; j++) {
                weightBall += vault.getBaskets().get(i).getBalls().get(j).getWeight();
            }
            System.out.println("Вес корзины №"+ (i+1) +"="+(weightBall + balls.get(b).getWeight()));
        }
    }

    /**
     *
     */
    public void priceBall() {
        int k = vault.getBaskets().size();
        for (int i = 0; i < k; i++) {
            int b = vault.getBaskets().get(i).getBalls().size()-1;
            int priceBall = 0;
            for (int j = 0; j < b; j++) {
                priceBall += vault.getBaskets().get(i).getBalls().get(j).getPrice();
            }
            System.out.println("Стоимость корзины №"+ (i+1) +"="+(priceBall + balls.get(b).getPrice()));
        }
    }

    /**
     *
     */
    public int countEqualBall(Basket basket) {
        // Выводим на экран
        int sum = 0;

        Map<Ball, Integer> quantity = new HashMap<>();

        for (Ball ball : basket.getBalls()) {
            if (quantity.containsKey(ball)) {
                quantity.put(ball, quantity.get(ball) + 1);
            } else {
                quantity.put(ball, 1);
            }
        }

        for (Map.Entry<Ball, Integer> q : quantity.entrySet()) {
            int value = q.getValue();
            if (value > 1) {
                sum += value;
            }
        }
        return sum;

    }
    public void printEqualBalls() {
        System.out.println("Количество одинаковых мячей " + countEqualBall(vault.getBaskets().get(0)));
    }

    /**
     *
     * @param color
     */
    public void countColorBalls(Color color) {
        //TODO неверно указывает кол-во мячей, если их в корзине нет
        int sum = 0;
        for (int i = 0; i < balls.size(); i++) {
                if (balls.get(i).getColor().equals(color)) {
                    sum++;
                }
            }
        System.out.println("Количество мячей по цвету " + color + " мячей " + (sum));
    }

    /**
     *
     * @param vault
     * @return
     */
    public int sameBasketQuantity(Vault vault) {

        int sum = 0;

        Map<Basket, Integer> quantity = new HashMap<>();

        for (Basket basket : vault.getBaskets()) {
            if (quantity.containsKey(basket)) {
                quantity.put(basket, quantity.get(basket) + 1);
            } else {
                quantity.put(basket, 1);
            }
        }

        for (Map.Entry<Basket, Integer> q : quantity.entrySet()) {
            int value = q.getValue();
            if (value > 1) {
                sum += value;
            }
        }
        return sum;
    }
    public void print() {
        System.out.println("Количество одинаковых корзин " + sameBasketQuantity(vault));

    }

    public void number() {

        int countBaskets = sameBasketQuantity(vault);
        System.out.println(countBaskets);
    }


}
