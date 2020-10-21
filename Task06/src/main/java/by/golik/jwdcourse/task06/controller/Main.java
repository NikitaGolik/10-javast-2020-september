package by.golik.jwdcourse.task06.controller;
import by.golik.jwdcourse.task06.exceptions.BookAlreadyHaveException;
import by.golik.jwdcourse.task06.exceptions.BookNotExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, BookAlreadyHaveException, BookNotExistException {

        logger.trace("Trace");
        logger.info("Log4j2 started.");
        logger.warn("Something to warn");
        logger.error("Something failed.");
        logger.fatal("Fatal");
        logger.debug("Debug");

        Controller controller = new Controller();
        controller.create();
        controller.find();
        controller.sort();
        controller.remove();
        controller.add();

    }
}
