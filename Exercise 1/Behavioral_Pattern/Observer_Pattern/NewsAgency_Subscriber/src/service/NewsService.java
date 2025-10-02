package service;

import model.*;
import util.LoggerUtil;
import java.util.*;
import java.util.logging.Logger;

public class NewsService {
    private final NewsAgency newsAgency = new NewsAgency();
    private final Map<String, Subscriber> subscriberRegistry = new HashMap<>();
    private static final Logger LOGGER = LoggerUtil.getLogger();

    public void addSubscriber(String name) {
        if (!ValidationService.isValidName(name)) {
            LOGGER.warning("Invalid subscriber name");
            return;
        }
        Subscriber subscriber = new Subscriber(name);
        newsAgency.registerSubscriber(subscriber);
        subscriberRegistry.put(name, subscriber);
    }

    public void removeSubscriber(String name) {
        Subscriber subscriber = subscriberRegistry.get(name);
        if (subscriber != null) {
            newsAgency.removeSubscriber(subscriber);
            subscriberRegistry.remove(name);
        } else {
            LOGGER.warning("Subscriber not found: " + name);
        }
    }

    public void publishNews(String news) {
        newsAgency.publishNews(news);
    }
}
