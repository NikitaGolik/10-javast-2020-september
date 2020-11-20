package by.golik.task09.service.put;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Nikita Golik
 */
public class ReaderFile {

    private static final Logger logger = LogManager.getLogger(ReaderFile.class);

    public String readFromFile(final String path) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
            // String with all text
            System.out.println(text);
        } catch (FileNotFoundException e) {
           logger.error("File not found");
        } catch (IOException e) {
            logger.error("You got an error while reading file");
        }
        return text;
    }
}
