package adapter;

import exception.PaymentException;

public interface PaymentGateway {
    boolean refund(String transactionId, double amount) throws PaymentException;
}
