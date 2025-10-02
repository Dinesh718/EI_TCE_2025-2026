package designpatterns.creational;

// Product interface
interface Notification {
    void send(String message);
}

// Concrete Products
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// Creator (Factory) interface
interface NotificationFactory {
    Notification createNotification();
}

// Concrete Creators
class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

// Demo class
public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===");
        
        // Use different factories to create different notifications
        NotificationFactory emailFactory = new EmailNotificationFactory();
        NotificationFactory smsFactory = new SMSNotificationFactory();
        NotificationFactory pushFactory = new PushNotificationFactory();
        
        // Create notifications using factories
        Notification email = emailFactory.createNotification();
        Notification sms = smsFactory.createNotification();
        Notification push = pushFactory.createNotification();
        
        // Use the notifications
        email.send("Your daily schedule has been updated!");
        sms.send("Reminder: Team meeting in 15 minutes");
        push.send("New task assigned: Code review");
        
        System.out.println("Factory Method demo completed!");
    }
}