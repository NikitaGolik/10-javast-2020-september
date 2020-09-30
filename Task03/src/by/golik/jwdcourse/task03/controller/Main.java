package by.golik.jwdcourse.task03.controller;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.service.PriceComparator;
import by.golik.jwdcourse.task03.view.UserConsole;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //TODO javadoc

        UserConsole userConsole = new UserConsole();
        MainController mainController = new MainController();
        mainController.createVault();
        System.out.println(mainController.vault.getBaskets().size());
        mainController.fillVault();
        mainController.weightBall();
        mainController.priceBall();
        mainController.countEqualBall();
        mainController.countEqualBaskets();
        mainController.countEqualColorBalls(Color.YELLOW);
        mainController.countEqualColorBalls(Color.BLUE);
        mainController.countEqualColorBalls(Color.GREEN);

        Collections.sort(mainController.balls, new PriceComparator());
        System.out.println(Arrays.asList(mainController.balls));











    }
}
