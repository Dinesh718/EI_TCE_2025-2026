package util;

import java.util.logging.*;

public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());

    static {
        LogManager.getLogManager().reset();
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        LOGGER.addHandler(ch);
        LOGGER.setLevel(Level.INFO);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
