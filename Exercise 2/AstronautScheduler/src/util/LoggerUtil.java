package util;

import java.util.logging.*;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        try {
            FileHandler fh = new FileHandler("scheduler.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            System.err.println("Logging setup failed.");
        }
    }

    public static void logInfo(String msg) {
        logger.info(msg);
    }

    public static void logError(String msg) {
        logger.severe(msg);
    }
}
