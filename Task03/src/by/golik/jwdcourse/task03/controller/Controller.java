package by.golik.jwdcourse.task03.controller;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.view.UserConsole;

import java.util.*;

/**
 * This class defines actions that are performed with the transmitted data and objects
 * The actions that need to be taken in order to fill the baskets with balls are described,
 * then fill the storage with the received baskets with balls. as well as matching baskets and balls
 */
public class Controller {

    UserConsole userConsole = new UserConsole();
    Vault vault = new Vault();
    ArrayList<Ball>balls;

    /**
     * Creating a value for baskets
     */
    public void createVault() {
        vault.setBaskets(userConsole.addBaskets());
    }

    /**
     * Filling baskets with balls
     */
    public void fillBasket() {
        int numberBasket = userConsole.chooseBasket();
        balls = new ArrayList<>(userConsole.addBall());
        vault.getBaskets().get(numberBasket).setBalls(balls);
    }

    /**
     * Filling vault with baskets
     */
    public void fillVault() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для заполнения новой корзины нажми Enter или нажми exit для выхода");
        while(!scanner.nextLine().equals("exit")) {
            fillBasket();
        }
    }

    /**
     * Сalculating the weight of a basket filled with balls.
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
     * Calculating the price of a basket filled with balls
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
     * Аinding and counting identical ballsю
     */
    public int countEqualBall(Basket basket) {

        int sum = 0;
        Map<Ball, Integer> count = new HashMap<>();

        for (Ball ball : basket.getBalls()) {
            if (count.containsKey(ball)) {
                count.put(ball, count.get(ball) + 1);
            } else {
                count.put(ball, 1);
            }
        }

        for (Map.Entry<Ball, Integer> map : count.entrySet()) {
            int value = map.getValue();
            if (value > 1) {
                sum += value;
            }
        }
        return sum;

    }

    /**
     * Printing count of equal balls.
     */
    public void printEqualBalls() {
        System.out.println("Количество одинаковых мячей в первой корзине " + " "  + countEqualBall(vault.getBaskets().get(0)));
    }

    /**
     * Counting the number of balls of the same color.
     * @param color - color of balls in basket.
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
     * Counting the number of equal baskets.
     * @param vault - vault with baskets.
     * @return count of equals basket in vault.
     */
    public int sameBasketQuantity(Vault vault) {

        int sum = 0;

        Map<Basket, Integer> count = new HashMap<>();

        for (Basket basket : vault.getBaskets()) {
            if (count.containsKey(basket)) {
                count.put(basket, count.get(basket) + 1);
            } else {
                count.put(basket, 1);
            }
        }

        for (Map.Entry<Basket, Integer> map : count.entrySet()) {
            int value = map.getValue();
            if (value > 1) {
                sum += value;
            }
        }
        return sum;
    }

    /**
     * Printing a count of equal baskets in vault
     */
    public void print() {
        System.out.println("Количество одинаковых корзин " + sameBasketQuantity(vault));

    }
    /*
    public void number() {
        int countBaskets = sameBasketQuantity(vault);
        System.out.println(countBaskets);
    }
     */

}
