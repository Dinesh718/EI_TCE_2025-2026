package util;

import java.util.logging.*;

public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());

    static {
        LogManager.getLogManager().reset();
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.INFO);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}

