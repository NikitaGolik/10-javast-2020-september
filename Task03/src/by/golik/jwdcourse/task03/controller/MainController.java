package by.golik.jwdcourse.task03.controller;
import by.golik.jwdcourse.task03.beans.Color;
import by.golik.jwdcourse.task03.beans.Vault;
import by.golik.jwdcourse.task03.service.PriceComparator;
import java.io.IOException;
import java.util.*;
/**
 *
 * @autor Nikita Golik
 *
 */

public class MainController {

    public static void main(String[] args) throws IOException {
	// write your code here
        //TODO javadoc
        Controller controller = new Controller();
        Vault vault = new Vault();
        controller.createVault();
        System.out.println(controller.vault.getBaskets().size());
        controller.fillVault();
        controller.weightBall();
        controller.priceBall();
        controller.printEqualBalls();
        controller.sameBasketQuantity(vault);
        controller.print();
        controller.countColorBalls(Color.YELLOW);
        controller.countColorBalls(Color.BLUE);
        controller.countColorBalls(Color.GREEN);

        Collections.sort(controller.balls, new PriceComparator());
        System.out.println(Arrays.asList(controller.balls));

    }
}
