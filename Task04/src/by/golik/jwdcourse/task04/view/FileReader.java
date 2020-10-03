package by.golik.jwdcourse.task04.view;

import by.golik.jwdcourse.task04.view.impl.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Reader {
    /**
     *
     * This method fills the array with the numbers entered from .txt file.
     * @throws FileNotFoundException - Constructs a FileNotFoundException with null as its error detail message.
     * @return
     */
    public int[] fillFromFile() throws FileNotFoundException {
        File file = new File("D:\\demo\\testArray.txt");
        Scanner scanner = new Scanner(file);
        int[] arrayFile = new int[10];
        for (int i = 0; scanner.hasNextInt(); i++) {
            arrayFile[i] = scanner.nextInt();
            System.out.println(arrayFile[i]);
        }
        return arrayFile;
    }

    @Override
    public int[] getReader() throws FileNotFoundException {
        return fillFromFile();
    }
}
