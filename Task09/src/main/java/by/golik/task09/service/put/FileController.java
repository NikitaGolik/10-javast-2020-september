package by.golik.task09.service.put;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Nikita Golik
 */
public class FileController {

    static Logger logger = LogManager.getLogger(FileController.class);

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
