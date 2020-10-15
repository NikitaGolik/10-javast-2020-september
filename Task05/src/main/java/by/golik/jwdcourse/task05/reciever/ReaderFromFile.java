package by.golik.jwdcourse.task05.reciever;
import java.io.*;

/**
 * This class includes method that reads each line of text from the file and passes the text further for processing
 */
public class ReaderFromFile {

    /**
     * This method reads each line of text from the file and passes the text further for processing
     * @return - original text from the file for further processing
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public String readStringFromFile() throws IOException {
        String text = null;

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\demo\\text.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text = sb.toString();
            System.out.println(text);
        }
        return text;
    }
}
