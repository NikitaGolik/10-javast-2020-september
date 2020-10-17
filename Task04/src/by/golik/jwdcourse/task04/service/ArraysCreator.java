package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.Array;
import java.io.File;
import java.util.Scanner;

/**
 * Creates arrays
 */
public class ArraysCreator {
    /**
     * Create array from console
     * @param array - getting from user numbers
     * @param scanner - read from user
     * @return array
     * @throws Exception
     */
    public Array fillFromConsole(Array array, Scanner scanner) throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("Enter array length");
        array = new Array(scanner.nextInt());
        System.out.println("Insert Array elements");
        for(int i = 0; i < array.getLength(); i++) {
            try {
                int value = scanner.nextInt();
                array.setElement(i, value);
            } catch (Exception e) {

            }
        } return array;
    }

    /**
     * This method fills the array with the numbers entered from .txt file.
     * @param array getting from user numbers
     * @return
     * * @throws FileNotFoundException - Constructs a FileNotFoundException with null as its error detail message.
     */
//todo
    public Array fillFromFile(Array array) throws Exception {
        File file = new File(".\\resources\\data\\testArray.txt");
        Scanner scanner = new Scanner(file);
        array = new Array(scanner.nextInt());
        for (int i = 0; i < array.getLength(); i++) {
            try {
                int value = scanner.nextInt();
                array.setElement(i, value);
            } catch (Exception e) {

            }
        } return array;
    }

    /**
     * This method fills the array with random numbers.
     * @param array - getting from user numbers
     * @param start - low radnom number
     * @param end - max random number
     * @return array
     * @throws Exception
     */
    public Array fillByRandom(Array array, int start, int end) throws Exception {
        array = new Array(10);
        for(int i = 0; i < array.getLength(); i++) {
            try {
                int value = (int) (Math.random() * (end - start) + start);
                array.setElement(i, value);
            } catch (Exception e) {

            }
        } return array;
    }
}
