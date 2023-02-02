package task1.config;

import java.io.IOException;
import java.util.logging.*;

/**
 * Class for logger configuration
 */
public class LoggerConfig {

    public static void config() throws IOException {
        FileHandler fileHandler = new FileHandler("src/task1/log.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        Logger logger = Logger.getLogger("");
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
    }
}
