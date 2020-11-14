
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyApp {

    private static final Logger logger = LogManager.getLogger(MyApp.class);

    public static void main(String[] args) {

        logger.trace("Entering app");
        logger.trace("Exiting app");
        logger.debug("Testing debug");
        logger.error("Testing error");
        logger.info("Testing info");
        logger.fatal("Testing fatal");
        logger.warn("Testing warn");


    }
}
