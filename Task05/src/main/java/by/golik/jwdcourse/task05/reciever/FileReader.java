package by.golik.jwdcourse.task05.reciever;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public void readerFromFile() throws FileNotFoundException {
        File file = new File("D:\\demo\\text.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            System.out.printf("File size: %d bytes \n", fileInputStream.available());
            int i = -1;
            while ((fileInputStream.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
