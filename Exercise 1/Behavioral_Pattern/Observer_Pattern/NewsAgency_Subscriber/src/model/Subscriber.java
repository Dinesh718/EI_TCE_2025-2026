package model;

import util.LoggerUtil;
import java.util.logging.Logger;

public class Subscriber {
    private final String name;
    private static final Logger LOGGER = LoggerUtil.getLogger();

    public Subscriber(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subscriber name cannot be null or empty");
        }
        this.name = name;
    }

    public void update(String news) {
        LOGGER.info(() -> String.format("Subscriber [%s] received news update: %s", name, news));
    }

    public String getName() {
        return name;
    }
}

