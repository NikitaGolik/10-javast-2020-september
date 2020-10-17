package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.JaggedArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class JaggedArraysCreator {
    /**
     *
     * @return
     */
    public JaggedArray fillJaggedFromConsole() throws Exception {
        Scanner scanner = new Scanner(System.in);
        scanner = new Scanner(System.in);
        System.out.println("Enter count of raws");
        int raw = scanner.nextInt();
        System.out.println("Enter count of cols");
        int col = scanner.nextInt();
        JaggedArray jaggedArray = new JaggedArray(raw, col);
        System.out.println("Insert Array elements");
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col ; j++) {
                try {
                    int value = scanner.nextInt();
                    jaggedArray.setElement(i, j, value);
                }catch (Exception e) {

                }
            }
        }
        System.out.println(jaggedArray);
        return jaggedArray;
    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     */
    public JaggedArray fillJaggerFromFile() throws Exception {

        File file = new File("D:\\eclipse-workspace\\10-javast-2020-september\\Task04\\testJaggedArray.txt");
        Scanner scanner = new Scanner(file);
        JaggedArray jaggedArray = new JaggedArray(10, 10);
        for (int i = 0; i < jaggedArray.getVerticalSize(); i++) {
            for (int j = 0; j < jaggedArray.getHorizontalSize() ; j++) {
                try {
                    int value = scanner.nextInt();
                    jaggedArray.setElement(i, j, value);
                } catch (Exception e) {

                }
            }
        }
        System.out.println(jaggedArray);
        return jaggedArray;
    }

    /**
     *
     * @return
     */
    public JaggedArray fillJaggedByRandom(JaggedArray jaggedArray,int start, int end) throws Exception {
        int v = jaggedArray.getVerticalSize();
        int h = jaggedArray.getHorizontalSize();

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                try {
                    int value = (int) (Math.random() * (end - start) + start);
                    jaggedArray.setElement(i, j, value);
                } catch (Exception e) {

                }
            }
        }
        System.out.println(jaggedArray);
        return jaggedArray;
    }
}
