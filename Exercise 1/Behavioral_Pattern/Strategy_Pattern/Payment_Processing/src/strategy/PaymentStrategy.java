package strategy;

import exception.AppException;

public interface PaymentStrategy {
    void pay(double amount) throws AppException;
}
