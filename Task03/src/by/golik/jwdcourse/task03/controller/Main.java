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


        UserConsole userConsole = new UserConsole();
        MainController mainController = new MainController();
        mainController.createVault();
        System.out.println(mainController.vault.getBaskets().size());
        mainController.fillVault();
        mainController.weightBall();
        mainController.priceBall();
        mainController.countEqualBall();
        mainController.countEqualBaskets();
        Comparator priceComparator = new PriceComparator();
        Collections.sort(mainController.balls, priceComparator);
        System.out.println(Arrays.asList(mainController.balls));











    }
}
