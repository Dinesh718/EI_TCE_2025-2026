package model;

import util.LoggerUtil;
import java.util.*;
import java.util.logging.Logger;

public class NewsAgency {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private static final Logger LOGGER = LoggerUtil.getLogger();

    public void registerSubscriber(Subscriber subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber cannot be null");
        }
        subscribers.add(subscriber);
        LOGGER.info(() -> "Subscriber registered: " + subscriber.getName());
    }

    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber cannot be null");
        }
        if (subscribers.remove(subscriber)) {
            LOGGER.info(() -> "Subscriber removed: " + subscriber.getName());
        } else {
            LOGGER.warning(() -> "Attempted to remove non-existing subscriber: " + subscriber.getName());
        }
    }

    public void publishNews(String news) {
        if (news == null || news.trim().isEmpty()) {
            throw new IllegalArgumentException("News cannot be null or empty");
        }
        LOGGER.info(() -> "Publishing news: " + news);
        for (Subscriber subscriber : subscribers) {
            try {
                subscriber.update(news);
            } catch (Exception e) {
                LOGGER.severe(() -> "Failed to notify subscriber: " + subscriber.getName());
            }
        }
    }
}
