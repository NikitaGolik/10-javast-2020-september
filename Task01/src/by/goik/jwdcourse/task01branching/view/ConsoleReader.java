package by.goik.jwdcourse.task01branching.view;

import by.goik.jwdcourse.task01branching.service.Service;

import java.util.Scanner;

public class ConsoleReader {
    Service service = new Service();
    public ConsoleReader() {
    }
    public double readerXPointA() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X of Point A");
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a number!");
            scanner.nextLine();
        }
        double number = scanner.nextDouble();

        return number;
    }
    public double readerYPointA() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Y of Point A");
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a number!");
            scanner.nextLine();
        }
        double number = scanner.nextDouble();

        return number;
    }
    public double readerXPointB() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X of Point B");
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a number!");
            scanner.nextLine();
        }
        double number = scanner.nextDouble();

        return number;
    }
    public double readerYPointB() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Y of Point B");
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a number!");
            scanner.nextLine();
        }
        double number = scanner.nextDouble();

        return number;
    }
    public void printResult() {
        double lengthA = service.getDistanceA(readerXPointA(), readerYPointA());
        double lengthB = service.getDistanceB(readerXPointB(), readerYPointB());

        if (lengthA < lengthB) {
            System.out.println("Distance from PointA to origin is closer.");
        } else if (lengthA == lengthB) {
            System.out.println("Distances from PointA and PointB are equal.");
        } else {
            System.out.println("Distance from PointB to origin is closer.");
        }
    }
}
