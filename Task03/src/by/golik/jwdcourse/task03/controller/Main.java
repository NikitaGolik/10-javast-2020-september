package by.golik.jwdcourse.task03.controller;

import by.golik.jwdcourse.task03.beans.Ball;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.view.UserConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here


        MainController mainController = new MainController();
        mainController.createVault();
        System.out.println(mainController.vault.getBaskets().size());
        mainController.vault.getBaskets().get(1);
        mainController.fillBasket();
        mainController.weightBall();
        mainController.putBalls();
        mainController.priceBall();








    }
}
