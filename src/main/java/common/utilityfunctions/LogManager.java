package common.utilityfunctions;

import org.apache.log4j.Logger;

public class LogManager {

    private static final Logger LOGGER = Logger.getLogger(LogManager.class.getName());


    public static void startLog (String testClassName){
        LOGGER.info("Test is Starting...");
    }


    public static void endLog (String testClassName){
        LOGGER.info("Test is Ending...");
    }


    public static void info (String message) {
        LOGGER.info(message);
    }


    public static void warn (String message) {
        LOGGER.warn(message);
    }


    public static void error (String message) {
        LOGGER.error(message);
    }


    public static void fatal (String message) {
        LOGGER.fatal(message);
    }


    public static void debug (String message) {
        LOGGER.debug(message);
    }
}

