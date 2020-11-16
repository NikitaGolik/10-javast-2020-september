package by.golik.task09.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class ReaderFromFile {

    private static final Logger logger = LogManager.getLogger(ReaderFromFile.class);

    public static String getData(String filePath) {
        File file = new File(filePath);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            logger.error(e);
        }
        return builder.toString();
    }
}
