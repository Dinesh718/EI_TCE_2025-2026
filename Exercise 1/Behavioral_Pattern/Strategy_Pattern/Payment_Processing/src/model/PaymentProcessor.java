package model;
import exception.AppException;
import strategy.PaymentStrategy;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        if (strategy == null) throw new IllegalArgumentException("Payment strategy cannot be null");
        this.strategy = strategy;
    }

    public void processPayment(double amount) throws AppException {
        if (strategy == null) throw new IllegalStateException("Payment strategy not set");
        strategy.pay(amount);
    }
}
