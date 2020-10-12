package by.golik.jwdcourse.task05.reciever;
import by.golik.jwdcourse.task05.bean.Document;

import java.io.*;

public class ReaderFromFile {

    public void readerFile() throws IOException {
        String fileName = "D:\\demo\\text.txt";
        try (FileInputStream fin = new FileInputStream("D:\\demo\\text.txt");
             FileOutputStream fos = new FileOutputStream("D:\\demo\\newText.txt")) {
            byte[] buffer = new byte[fin.available()];
            // read buffer
            fin.read(buffer, 0, buffer.length);
            //write from buffer to file
            fos.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readStringFromFile() throws IOException {
        String everything = null;

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\demo\\text.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            System.out.println(everything);
        }
        return everything;
    }
}
