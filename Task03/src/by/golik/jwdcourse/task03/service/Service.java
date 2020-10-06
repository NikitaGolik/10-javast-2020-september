package by.golik.jwdcourse.task03.service;

import by.golik.jwdcourse.task03.beans.Basket;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.controller.MainController;

import java.util.ArrayList;

public class Service {
    Vault vault;
    MainController mainController;

    public void createHraniliwe() {
        vault.setBaskets(mainController.createVault());
    }
}
