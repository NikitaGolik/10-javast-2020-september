package by.golik.jwdcourse.task05.reciever;
import java.io.*;

public class ReaderFromFile {

    /**
     *
     * @return
     * @throws IOException
     */
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
