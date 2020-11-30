package by.golik.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Nikita Golik
 */
public class ReadFromFile {

    public String readFromFile(final String path) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
            // String with all text
            //System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
