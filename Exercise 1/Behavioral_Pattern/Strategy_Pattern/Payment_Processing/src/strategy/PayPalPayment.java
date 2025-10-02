package strategy;

import exception.AppException;
import  util.LoggerUtil;

import java.util.logging.Logger;

public class PayPalPayment implements PaymentStrategy {
    private static final Logger LOGGER = LoggerUtil.getLogger();
    private final String email;

    public PayPalPayment(String email) {
        if (email == null || email.trim().isEmpty()) 
            throw new IllegalArgumentException("Email cannot be empty");
        this.email = email;
    }

    @Override
    public void pay(double amount) throws AppException {
        if (amount <= 0) throw new AppException("Amount must be positive");
        LOGGER.info(() -> String.format("Paid %.2f using PayPal [%s]", amount, email));
    }
}
