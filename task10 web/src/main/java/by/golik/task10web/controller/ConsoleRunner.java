package by.golik.task10web.controller;

import by.golik.task10web.builder.FlowerDOMBuilder;
import by.golik.task10web.builder.FlowerSAXBuilder;
import by.golik.task10web.builder.FlowerStAXBuilder;
import by.golik.task10web.exception.ParserException;
import by.golik.task10web.view.Command;

import java.util.Scanner;

/**
 * @author Nikita Golik
 */
public class ConsoleRunner {
    private Scanner scanner;
    Command command = new Command();

    public ConsoleRunner(Scanner scanner) {
        this.scanner = scanner;
    }
    public void start() throws ParserException {
        if(this.scanner != null) {
            String key;
            do {
                command.printMenu();
                key = this.scanner.nextLine();
                switch (key) {
                    case "1" :
                        FlowerDOMBuilder flowersDOMBuilder = new FlowerDOMBuilder();
                        flowersDOMBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
                        System.out.println(flowersDOMBuilder.getFlowerSet().toString());
                        break;
                    case "2" :
                        FlowerSAXBuilder flowerSaxBuilder = new FlowerSAXBuilder();
                        flowerSaxBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
                        System.out.println(flowerSaxBuilder.getFlowerSet().toString());
                        break;
                    case "3" :
                        FlowerStAXBuilder flowerStAXBuilder = new FlowerStAXBuilder();
                        flowerStAXBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
                        System.out.println(flowerStAXBuilder.getFlowerSet().toString());
                        break;
                    case "4" :
                        System.out.println("Ending of program...");
                        break;
                    default:
                        System.out.println("You entered incorrect value of menu, retry entering \n");
                }
            } while (!key.equals("4"));
        }
    }
}
