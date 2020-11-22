package by.golik.task09.reader;

import by.golik.task09.service.exception.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class for reading text from file with indication to file path
 * @author Nikita Golik
 */
public class TextReader {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * @param file - file witch contains a text
     * @return String value of getting text
     * @throws IncorrectInputFileException appears when impossible to read file
     */
    public String read(File file) throws IncorrectInputFileException {

        if(file == null || !file.exists() || file.length()==0) {
            throw new IncorrectInputFileException("Incorrect input parameters");
        }

        String allText;
        byte[] text;
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getPath());
            text = new byte[fileInputStream.available()];
            fileInputStream.read(text);
            allText = new String(text);
        } catch (IOException e) {
            LOGGER.catching(Level.FATAL, e);
            throw new RuntimeException(e);
        }
        LOGGER.log(Level.INFO, "- Text is successfully read.");
        return allText;
    }
}
